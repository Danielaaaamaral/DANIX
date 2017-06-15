
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Vendedor;

/**
 *
 * @author Daniela
 */
public class Vendedor_CRUD {
     Conexão conex = new Conexão();

    // ok
    public void inserir(Vendedor v) {
        try {
            conex.conecta();
            PreparedStatement stmt = conex.con.prepareStatement("insert into Vendedor values(?,?,?)");
            stmt.setInt(1, v.getCodvendedor());
            stmt.setString(2, v.getNomevendedor());
            stmt.setDouble(3, v.getQtdvendas());
            stmt.executeUpdate();
            stmt.close();
            conex.fechar();

            JOptionPane.showMessageDialog(null, "Vendedor cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO :" + ex.getMessage());
        }
    }
    public void alterarTotalDeVendas(double qtdVenda, int codigo) {
        try {
            conex.conecta();
            PreparedStatement stmt = conex.con.prepareStatement(""
                    + "UPDATE Vendedor SET qtdvendas = qtdvendas + "
                    + qtdVenda + " WHERE codvendedor = " + codigo);
            stmt.executeUpdate();
            stmt.close();
            JOptionPane.showMessageDialog(null, "alterado com sucesso!");
            conex.fechar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deletar(Vendedor v) {
        try {
            conex.conecta();
            PreparedStatement stmt = conex.con.prepareStatement("delete from Vendedor where codvendedor = ?");
            stmt.setInt(1, v.getCodvendedor());
            stmt.executeUpdate();
            stmt.close();
            conex.fechar();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO:\n" + e.getMessage());
        }
    }
      public List listar() {
        List<Vendedor> list = new ArrayList<>();
        try {
            conex.conecta();

            PreparedStatement stmt = conex.con.prepareStatement("Select * from vendedor");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Vendedor v = new Vendedor();
                v.setCodvendedor(rs.getInt(1));
                v.setNomevendedor(rs.getString(2));
                v.setQtdvendas(rs.getInt(3));
                list.add(v);
            }
            stmt.close();
            conex.fechar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO:\n" + e.getMessage());
        }
        return list;
    }
    
}
