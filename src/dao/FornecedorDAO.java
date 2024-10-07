package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FornecedorDAO {
    
    public boolean verificarFornecedorPorId(int idFornecedor) {
        String sql = "SELECT * FROM fornecedores WHERE id = ?";
        boolean existe = false;

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFornecedor);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar fornecedor: " + e.getMessage());
        }

        return existe;
    }
}
