package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class AlertaEstoqueDAO {

    // Método para adicionar um alerta de estoque baixo na tabela alertas_estoque
    public void adicionarAlerta(int idProduto, String mensagem) {
        String sql = "INSERT INTO alertas_estoque (id_produto, data_alerta, mensagem) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection(); // Usando sua classe ConexaoDB
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProduto); // Define o ID do produto
            stmt.setDate(2, java.sql.Date.valueOf(LocalDate.now())); // Define a data atual
            stmt.setString(3, mensagem); // Define a mensagem do alerta

            stmt.executeUpdate(); // Executa a inserção
            System.out.println("Alerta adicionado para o produto ID: " + idProduto);
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar alerta de estoque: " + e.getMessage());
        }
    }
}
