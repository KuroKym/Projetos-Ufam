package br.edu.ufam.icomp.SuperMarkeet.layout;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufam.icomp.SuperMarkeet.Venda;

public class GerenciadorVendas {
    private static int codigoDaVendaAtual = 1;
    private static double lucroTotal = 0;
    private static double compraProdutos = 0;
    private static List<Venda> vendasRealizadas = new ArrayList<>();

    public static int getCodigoDaVendaAtual() {
        return codigoDaVendaAtual;
    }

    public static void incrementarCodigoDaVendaAtual() {
        codigoDaVendaAtual++;
    }

    public static List<Venda> getVendasRealizadas() {
        return vendasRealizadas;
    }

    public static void adicionarVenda(Venda venda) {
        vendasRealizadas.add(venda);
        lucroTotal += venda.getTotalCompra();
    }

    public static Venda getVendaAtual(int codigo) {
        for (Venda venda : vendasRealizadas){
            if(codigo == venda.getCodigo()){
                return venda;
            }
        }
        return null;
    }
    public static double getLucroTotal() {
        return lucroTotal;
    }
    public static double getCompraProduto() {
        return compraProdutos;
    }
    public static void setLucroTotal(double venda) {
        lucroTotal -= venda;
    }
    public static void setCompraProdutos(double venda) {
        compraProdutos += venda;
    }
}
