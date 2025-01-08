package br.edu.ufam.icomp.SuperMarkeet.layout;

import br.edu.ufam.icomp.SuperMarkeet.Produto;
import br.edu.ufam.icomp.SuperMarkeet.ProdutoDAO;
import br.edu.ufam.icomp.SuperMarkeet.Venda;
import br.edu.ufam.icomp.SuperMarkeet.VendaDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CenaVendas {
    private int codigoDaVenda = GerenciadorVendas.getCodigoDaVendaAtual();
    Venda venda;
    @FXML
    private Label totalAPagarLabel;
    
    @FXML
    private TextField quantidade;

    @FXML
    private Button addVenda;

    @FXML
    private TextField codigoVenda;

    @FXML
    private ListView<String> listaProdutos;

    @FXML
    private Button fim;
    
    @FXML
    private Button voltar;

    String codigoAtual;

    
    private ProdutoDAO produtoDAO;
    private VendaDAO vendaDAO;
    public void initialize() throws Exception {
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Como funciona?");
        info.setHeaderText(null);
        info.setContentText("Para adicionar produtos a venda selecione o produto na lista e então clique em adicionar, quando terminar clique em fim e informe o total pago pelo cliente e o metodo de pagamento");
        info.showAndWait();
        produtoDAO = new ProdutoDAO();
        vendaDAO = new VendaDAO();
        venda = new Venda(codigoDaVenda);
        atualizarListaProdutos();
        selectItem();
    }

    public void selectItem() {
        listaProdutos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    String[] partes = newValue.split("\\|");
                    String codigoProduto = partes[0].trim();
                    codigoVenda.setText(codigoProduto);
                }
            }
        });
    }
    
    @FXML
    void adicionarVenda(ActionEvent event) throws Exception {
        ArrayList<Produto> produtos = produtoDAO.arrayProduto();
        String quantidadeText = quantidade.getText();
        if (quantidadeText.isEmpty()) {
            // Se o campo de quantidade estiver vazio, executar a lógica para adicionar o produto sem quantidade
            String codigo = codigoVenda.getText();
            boolean produtoEncontrado = false;
            for (Produto produto : produtos) {
                String codigoProduto = produto.getCodigoDeBarras(); 
                if (codigoProduto.equals(codigo)) {
                    produtoEncontrado = true;
                    venda.adicionarProduto(produto);
                    if (produto.getQuantidade() > 1) {
                        produto.decrementaQuantidade();
                        produtoDAO.atualizarProdutos(produto);
                    } else {
                        produtoDAO.removeProduto(codigoProduto);
                        produtos.remove(produto); // Remover o produto da lista
                    }
                    break; // Encerra o loop após encontrar o produto
                }
            }
            if (!produtoEncontrado) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Produto não encontrado");
                alert.setHeaderText(null);
                alert.setContentText("O produto com o código " + codigo + " não foi encontrado na lista.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Produto encontrado");
                alert.setHeaderText(null);
                alert.setContentText("O produto foi adicionado com sucesso");
                alert.showAndWait();
            }
        } else {
            // Se o campo de quantidade não estiver vazio, continuar com o processamento normal
            int numero = Integer.parseInt(quantidadeText);
            boolean produtoEncontrado = false;
            String codigo = codigoVenda.getText();
            for (Produto produto : produtos) {
                String codigoProduto = produto.getCodigoDeBarras(); 
                if (codigoProduto.equals(codigo)) {
                    produtoEncontrado = true;
                    if(produto.getQuantidade() >= numero){
                        for(int i = 0; i < numero; i++){
                            venda.adicionarProduto(produto);
                            produto.decrementaQuantidade();
                            produtoDAO.atualizarProdutos(produto);
                            if (produto.getQuantidade() <= 0) {
                                produtoDAO.removeProduto(codigoProduto);
                                produtos.remove(produto); // Remover o produto da lista
                            }
                        }
                    }
                    else{
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Quantidade inválida");
                        alert.setHeaderText(null);
                        alert.setContentText("A quantidade de produtos é insuficiente.");
                        alert.showAndWait();
                        return;
                    }
                    break; // Encerra o loop após encontrar o produto
                }
            }
            if (!produtoEncontrado) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Produto não encontrado");
                alert.setHeaderText(null);
                alert.setContentText("O produto com o código " + codigo + " não foi encontrado na lista.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Produto encontrado");
                alert.setHeaderText(null);
                alert.setContentText("O produto foi adicionado com sucesso");
                alert.showAndWait();
            }
        }
        double totalAPagar = venda.getTotalCompra();
        totalAPagarLabel.setText("Total a pagar: R$ " + totalAPagar);
        atualizarListaProdutos();
    }
    

    
    

    
    private void atualizarListaProdutos() {
        listaProdutos.getItems().clear();

        try {

            List<Produto> produtos = produtoDAO.listarProdutos();

            for (Produto produto : produtos) {
                listaProdutos.getItems().add(produto.getCodigoDeBarras()+" | " + produto.getDescricao() + " | R$ "+ produto.getPrecoCompra() +
                " | R$ " + produto.getPrecoVenda() + " | " + produto.getQuantidade() + " | " + produto.getUnidadeMedida());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void botaoFim(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Pagamento.fxml"));
            Parent root = loader.load();

            PagamentoCenaController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Informe o Pagamento");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            String totalPago = controller.getTotalPago();
            String tipoPagamento = controller.getTipoPagamento();
            if (Double.parseDouble(totalPago) < venda.getTotalCompra()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Pagamento Insuficiente");
                alert.setHeaderText(null);
                alert.setContentText("O valor total pago é menor que o total a pagar. Por favor, insira um valor válido.");
                alert.showAndWait();
    
                // Volta a exibir a janela de pagamento para inserir um valor válido
                botaoFim(event);
                return;
            }

            venda.setTipoPagamento(tipoPagamento);
            venda.setTotalPagamento(Double.parseDouble(totalPago));
            venda.calcularTroco();
            vendaDAO.adicionarVenda(venda);
            GerenciadorVendas.adicionarVenda(venda);
            GerenciadorVendas.incrementarCodigoDaVendaAtual();
            Alert done = new Alert(Alert.AlertType.INFORMATION);
            done.setTitle("Venda Adicionada");
            done.setHeaderText(null);
            done.setContentText("A venda foi adicionada com sucesso!");
            done.showAndWait();
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("menu.fxml"));
            Parent root2 = loader2.load();
            
            
            Stage stage2 = (Stage) fim.getScene().getWindow();
            
         
            stage2.setScene(new Scene(root2));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void voltarButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            Parent root = loader.load();
            
            
            Stage stage = (Stage) fim.getScene().getWindow();
            
         
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}