package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Vendas;

public class VendasDAO {
    
    // Método para consultar todas as vendas
    public List<Vendas> consultarVendas() {
        List<Vendas> vendas = new ArrayList<>();
        String sql = "SELECT id, data_venda, valor_total, id_cliente FROM vendas";

        try (Connection conn = ConexaoDB.getConnection(); // Obter a conexão do banco de dados
             PreparedStatement pstmt = conn.prepareStatement(sql); // Preparar a instrução SQL
             ResultSet rs = pstmt.executeQuery()) { // Executar a consulta
             
            while (rs.next()) {
                int id = rs.getInt("id");
                Date dataVenda = rs.getDate("data_venda");
                double valorTotal = rs.getDouble("valor_total");
                int idCliente = rs.getInt("id_cliente");
                // Adicionar a venda à lista
                vendas.add(new Vendas(id, dataVenda, valorTotal, idCliente));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar vendas: " + e.getMessage());
            // Aqui você poderia lançar uma exceção personalizada ou fazer um log
        }
        return vendas; // Retornar a lista de vendas
    }

    // Se você quiser um método para fechar a conexão, faça assim:
    public void closeConnection() {
        // Este método não é necessário, já que a conexão é gerenciada no try-with-resources
    }
}
