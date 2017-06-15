
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author Daniela
 */
public class Produto_CRUD {
    Conexão conex = new Conexão();

    public void inserir(Produto p) {
        try {
            conex.conecta();

            PreparedStatement stmt = conex.con.prepareStatement("INSERT INTO Produto VALUES(?,?,?,?)");
            stmt.setInt(1, p.getCodproduto());
            stmt.setString(2, p.getNomeproduto());
            stmt.setDouble(3, p.getPrecoproduto());
            stmt.setInt(4, p.getQtdproduto());
            stmt.executeUpdate();
            stmt.close();
            conex.fechar();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO :" + e.getMessage());
        }
    }
    
     public void deletar(Produto p) {
        try {
            conex.conecta();

            PreparedStatement stmt = conex.con.prepareStatement("DELETE FROM produto WHERE  codproduto = ?");
            stmt.setInt(1, p.getCodproduto());
            stmt.executeUpdate();
            stmt.close();
            conex.fechar();
            JOptionPane.showMessageDialog(null, "Produto excluído !");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO :" + e.getMessage());
        }
    }
     
      public List listar() {
        List<Produto> list = new ArrayList<>();
        try {
            conex.conecta();
            PreparedStatement stmt = conex.con.prepareStatement("SELECT * FROM  produto");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setCodproduto(rs.getInt(1));
                p.setNomeproduto(rs.getString(2));
                p.setPrecoproduto(rs.getDouble(3));
                p.setQtdproduto(rs.getInt(4));
                list.add(p);
            }
            stmt.close();
            conex.fechar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO :" + e.getMessage()
            );
        }
        return list;
    }
      public void alterar(Produto p){
        try {
            conex.conecta();
            
            PreparedStatement stmt = 
                    conex.con.prepareStatement(
                            "UPDATE produto "
                            + "SET nome_produto = ?,"
                    + "preco_produto = ?,"
                    + "qtd_estoque_produto = ?"
                    + "WHERE id_produto = ?");
            stmt.setString(1, p.getNomeproduto());
            stmt.setDouble(2, p.getPrecoproduto());
            stmt.setInt(3, p.getQtdproduto());
            stmt.setInt(4, p.getCodproduto());
            
            stmt.executeUpdate();
            stmt.close();
            conex.fechar();
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERRO :"+ e.getMessage());
        }
    }
}
