package br.edu.ufam.icomp.SuperMarkeet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO extends BancoDeDados {

  public List<Produto> listarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM produtos");
            while (rs.next()) {
                Produto produto = new Produto(rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getInt(6), rs.getString(7));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao listar produtos: " + e.getMessage());
        }
        return produtos;
    }

  public boolean adicionarProduto(Produto p) {
    try {
      Statement st = conexao.createStatement();
      st.executeUpdate("INSERT INTO produtos VALUES (NULL, '" + p.getCodigoDeBarras() + "', '" + p.getDescricao() 
      + "', " + p.getPrecoCompra() + ", " + p.getPrecoVenda() + ", " + p.getQuantidade()  + ", '" + p.getUnidadeMedida() + "')");

      return true;
    } catch (SQLException e) { return false; }
  }

  public Produto getProduto(String codigoDebarras) {
    try {
      Statement st = conexao.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM produtos WHERE " + 
                                     "codigodebarras='" + codigoDebarras + "'");
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

  public boolean removeProduto(String codigo) {
    try {
      Statement st = conexao.createStatement();
      st.executeUpdate("DELETE FROM produtos WHERE " + "codigodebarras='" + codigo + "'");

      return true;
    } catch (SQLException e) { return false; }
  }

  public Produto getProdutoPorCodigoDeBarras(String codigoDeBarras) throws SQLException {
    try {
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM produtos WHERE codigodebarras='" + codigoDeBarras + "'");
        if (rs.next()) {
            return new Produto(rs.getString("codigodebarras"), rs.getString("descricao"), rs.getDouble("precodecompra"),
                    rs.getDouble("precodevenda"), rs.getInt("quantidadecomprada"), rs.getString("unidademedida"));
        } else {
            return null;
        }
    } catch (SQLException e) {
        throw new SQLException("Erro ao obter produto por código de barras: " + e.getMessage());
    }
  }
  public ArrayList<Produto> arrayProduto() throws SQLException {
    ArrayList<Produto> produtos = new ArrayList<>();
    try {
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM produtos");
        while (rs.next()) {
            Produto produto = new Produto(rs.getString(2), rs.getString(3),
                    rs.getDouble(4), rs.getDouble(5), rs.getInt(6), rs.getString(7));
            produtos.add(produto);
        }
    } catch (SQLException e) {
        throw new SQLException("Erro ao listar produtos: " + e.getMessage());
    }
    return produtos;
  }
  public boolean resetarDAO(){
    try {
      Statement st = conexao.createStatement();
      st.executeUpdate("TRUNCATE produtos");
      return true;
    } 
    catch (SQLException e) {
      e.getMessage();
      return false;
    }
  }

  public Produto getProdutoByCodigo(String codigoDeBarras) {
    try {
        PreparedStatement ps = conexao.prepareStatement("SELECT * FROM produtos WHERE codigodebarras =" + codigoDeBarras);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Produto(rs.getString("codigodebarras"), rs.getString("descricao"),
                    rs.getDouble("precodecompra"), rs.getDouble("precodevenda"),
                    rs.getInt("quantidadecomprada"), rs.getString("unidademedida"));
        } else {
            return null;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
  }

  public boolean atualizarProdutos(Produto p) {
    try {
      Statement st = conexao.createStatement();
      st.executeUpdate("UPDATE produtos SET quantidadecomprada = " + p.getQuantidade() + " WHERE codigodebarras = '" + p.getCodigoDeBarras() + "'");

      return true;
    } catch (SQLException e) { return false; }
  }



}


