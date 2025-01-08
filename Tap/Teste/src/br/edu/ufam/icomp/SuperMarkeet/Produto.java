package br.edu.ufam.icomp.SuperMarkeet;

public class Produto {
    private String codigoDeBarras;
    private  String descricao;
    private double precoCompra;
    private double precoVenda;
    private int quantidade;
    private String unidadeMedida;

    public Produto(String codigoDeBarras, String descricao, double precoCompra, double precoVenda, int quantidade, String unidadeMedida){
        this.codigoDeBarras = codigoDeBarras;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
    }

    public String getCodigoDeBarras(){
        return codigoDeBarras;
    }

    public double getPrecoCompra(){
        return precoCompra;
    }

    public double getPrecoVenda(){
        return precoVenda;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getUnidadeMedida(){
        return unidadeMedida;
    }

    public int getQuantidade(){
        return quantidade;
    }
    public void decrementaQuantidade(){
        this.quantidade--;
    }
}