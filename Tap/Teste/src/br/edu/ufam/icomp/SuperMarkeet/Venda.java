package br.edu.ufam.icomp.SuperMarkeet;

import java.sql.SQLException;
import java.util.ArrayList;

public class Venda {
    public ArrayList<Produto> listaDeProdutos;
    private double totalCompra;
    private String tipoPagamento;
    private double totalPagamento;
    private double troco;
    private int codigo;

    public Venda(ArrayList<Produto> listaDeProdutos,double totalCompra, String tipoPagamento, double totalPagamento, int codigo) throws Exception {
        // Verifica se todos os produtos estão no banco de dados
        for (Produto produto : listaDeProdutos) {
            if (!produtoExisteNoBanco(produto.getCodigoDeBarras())) {
                throw new Exception("O produto '" + produto.getDescricao() + "' não está no banco de dados.");
            }
        }

        this.listaDeProdutos = listaDeProdutos;
        this.tipoPagamento = tipoPagamento;
        this.totalPagamento = totalPagamento;
        this.codigo = codigo;
        this.totalCompra = totalCompra;
        calcularTroco();
    }

    public Venda(double totalCompra, String tipoPagamento, double totalPagamento, int codigo) throws Exception {
        this.listaDeProdutos = new ArrayList<Produto>();
        this.tipoPagamento = tipoPagamento;
        this.totalPagamento = totalPagamento;
        this.codigo = codigo;
        this.totalCompra = totalCompra;
        calcularTroco();
    }
    public Venda(int codigo) throws Exception {
        this.listaDeProdutos = new ArrayList<Produto>();
        this.tipoPagamento = "";
        this.codigo = codigo;
        this.totalPagamento = 0;
        calcularTotalCompra();
        calcularTroco();
    }

    public void calcularTotalCompra() {    
        totalCompra = 0;
        for (Produto produto : listaDeProdutos) {
            totalCompra += produto.getPrecoVenda(); // Acumula o preço de venda de cada produto
        }
    }

    public void calcularTroco() {
        this.troco = totalPagamento - totalCompra;
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public double getTotalPagamento() {
        return totalPagamento;
    }
    
    public double getTroco() {
        return troco;
    }
    public int getCodigo(){
        return codigo;
    }
    public ArrayList<Produto> getProdutos(){
        return listaDeProdutos;
    }

    public String getDescricao(){
        return getTotalCompra() + " " + getTotalPagamento() + " " + getTipoPagamento() + " " + getCodigo();
    }

    public void setListaDeProdutos(ArrayList<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public void setTotalPagamento(double totalPagamento) {
        this.totalPagamento = totalPagamento;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    private boolean produtoExisteNoBanco(String codigoDeBarras) {
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto produto = produtoDAO.getProdutoPorCodigoDeBarras(codigoDeBarras);
            return produto != null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void adicionarProduto(Produto p){
        this.listaDeProdutos.add(p);
        calcularTotalCompra();
        calcularTroco();
    }
    public void exibirListaCompra(){
        for(Produto produto : listaDeProdutos){
            System.out.println(produto.getPrecoVenda());
        }
    }
    public void exibirListaNome(){
        for(Produto produto : listaDeProdutos){
            System.out.println(produto.getDescricao());
        }
    }
}
