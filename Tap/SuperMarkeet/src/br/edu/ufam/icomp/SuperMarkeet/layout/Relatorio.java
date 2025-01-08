package br.edu.ufam.icomp.SuperMarkeet.layout;
import java.io.IOException;
import java.util.List;

import br.edu.ufam.icomp.SuperMarkeet.Produto;
import br.edu.ufam.icomp.SuperMarkeet.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Relatorio {

    private double lucro = GerenciadorVendas.getLucroTotal();
    @FXML
    private Button voltar;
    
    @FXML
    private ListView<String> listViewProdutosDaVenda;

    @FXML
    private TreeView<String> treeViewVendas;

    @FXML
    private Label lucroTotal;
    
    @FXML
    private Label gastos;

    //private VendaDAO vendaDAO;

    public void initialize() {
       // vendaDAO = new VendaDAO();
        if (lucro< 0){
            lucroTotal.setText("Lucro total:\n R$" + GerenciadorVendas.getLucroTotal());
            lucroTotal.setTextFill(Color.RED);
            
        }
        else{
            lucroTotal.setText("Lucro total:\n R$" + GerenciadorVendas.getLucroTotal());
        }
        gastos.setText("Gastos:\n R$" + GerenciadorVendas.getCompraProduto());
       
        atualizarListaVendas();
    }


    @SuppressWarnings("unchecked")
    private void atualizarListaVendas() {
        List<Venda> vendas = GerenciadorVendas.getVendasRealizadas();
    
        TreeItem<String> root = new TreeItem<>("Vendas"); // Cria um novo root para as vendas
    
        for (Venda venda : vendas) {
            TreeItem<String> vendaCodigo = new TreeItem<>("Venda: " + String.valueOf(venda.getCodigo()));
            TreeItem<String> produtos = new TreeItem<>("Produtos");
            TreeItem<String> totalCompra = new TreeItem<>("Total da compra: " + String.valueOf(venda.getTotalCompra()));
            TreeItem<String> totalPagamento = new TreeItem<>("Total pago: " + String.valueOf(venda.getTotalPagamento()));
            TreeItem<String> tipoPagamento = new TreeItem<>("Metodo de pagamento: " + String.valueOf(venda.getTipoPagamento()));
            TreeItem<String> troco = new TreeItem<>("Troco: " + String.valueOf(venda.getTroco()));
            vendaCodigo.getChildren().addAll(produtos, totalCompra, totalPagamento, tipoPagamento, troco);
            root.getChildren().add(vendaCodigo); // Adiciona o item da venda ao root
        }
    
        treeViewVendas.setRoot(root); // Define o root apenas uma vez após o loop
    }

    public void selectItem() {
        TreeItem<String> item = treeViewVendas.getSelectionModel().getSelectedItem();
        
        if(item != null) {
            if(item.getValue() == "Produtos"){
                listViewProdutosDaVenda.getItems().clear();
                int codigo = Integer.parseInt((item.getParent().getValue()).substring(7));
                Venda venda = GerenciadorVendas.getVendaAtual(codigo);
                List<Produto> produtos = venda.getListaDeProdutos();
                for (Produto produto : produtos) {
                    listViewProdutosDaVenda.getItems().add(produto.getCodigoDeBarras()+" | " + produto.getDescricao() + " | Preco de Compra: R$ "+ produto.getPrecoCompra() +
                    " | Vendido por: R$ " + produto.getPrecoVenda() + " | "+ produto.getUnidadeMedida());
                }
            }
        }
    }

    @FXML
    void voltarButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            Parent root = loader.load();
            
            
            Stage stage = (Stage) voltar.getScene().getWindow();
            
         
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
