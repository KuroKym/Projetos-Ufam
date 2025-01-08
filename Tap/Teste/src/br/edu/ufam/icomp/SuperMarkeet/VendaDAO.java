package br.edu.ufam.icomp.SuperMarkeet;
import java.sql.*;

public class VendaDAO extends BancoDeDados {

    public void listarVendas() {
      try {
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM controlevendas");
        while (rs.next()) {
          System.out.println("Preco: " + rs.getDouble(4) +
                             "\nTipo do Pagamento: " + rs.getString(5) + 
                             "\n Total pago: " + rs.getDouble(6) + 
                             "\n Troco : " + rs.getDouble(7));
        }
      }
      catch (SQLException e) { }
    }
  
    public boolean adicionarVenda(Venda v) {
      try {
          Statement st = conexao.createStatement();
          st.executeUpdate("INSERT INTO controlevendas (CodigoDeVenda, TotalDaCompra, TipoDePagamento, TotalDoPagamento, Troco) VALUES ("
              + v.getCodigo() + ", " 
              + v.getTotalCompra() + ", '" 
              + v.getTipoPagamento() + "', " 
              + v.getTotalPagamento() + ", " 
              + v.getTroco() + ")");
          return true;
      } catch (SQLException e) {
          e.getMessage();
          return false;
      }
  }
  
  
    public Produto getProduto(String descricao) {
      try {
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM controlevendas WHERE " + 
                                       "Descricao='" + descricao + "'");
        if (rs.next()) {
          return new Produto(rs.getString(2), rs.getString(3), 
                                rs.getDouble(4), rs.getDouble(5), rs.getInt(6), rs.getString(7));
        }
        else{
          System.out.println("Produto nao encontrado");
          return null;
        }
      }
      catch (SQLException e) { return null; }
    }
    public boolean resetarDAO(){
      try {
        Statement st = conexao.createStatement();
        st.executeUpdate("TRUNCATE controlevendas");
        return true;
      } 
      catch (SQLException e) {
        e.getMessage();
        return false;
      }
    }
}
