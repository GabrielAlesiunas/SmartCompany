package dao;

import model.Pagamentos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentosDAO {

    // Método para adicionar um pagamento ao banco de dados
    public void adicionarPagamento(Pagamentos pagamento) {
        String sql = "INSERT INTO pagamentos (id_venda, metodo_pagamento, data_pagamento, valor_pago) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pagamento.getIdVenda());
            stmt.setString(2, pagamento.getMetodoPagamento());
            stmt.setDate(3, new java.sql.Date(pagamento.getDataPagamento().getTime()));
            stmt.setDouble(4, pagamento.getValorPago());
            stmt.executeUpdate();

            System.out.println("Pagamento adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar pagamento: " + e.getMessage());
        }
    }

    // Método para listar todos os pagamentos
    public List<Pagamentos> listarPagamentos() {
        List<Pagamentos> pagamentos = new ArrayList<>();
        String sql = "SELECT id, id_venda, metodo_pagamento, data_pagamento, valor_pago FROM pagamentos";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pagamentos pagamento = new Pagamentos(
                    rs.getInt("id_venda"),
                    rs.getString("metodo_pagamento"),
                    rs.getDate("data_pagamento"),
                    rs.getDouble("valor_pago")
                );
                pagamento.setId(rs.getInt("id")); // Definindo o ID do pagamento
                pagamentos.add(pagamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pagamentos: " + e.getMessage());
        }
        return pagamentos;
    }

    // Método para buscar um pagamento por ID
    public Pagamentos buscarPagamentoPorId(int id) {
        Pagamentos pagamento = null;
        String sql = "SELECT id, id_venda, metodo_pagamento, data_pagamento, valor_pago FROM pagamentos WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pagamento = new Pagamentos(
                    rs.getInt("id_venda"),
                    rs.getString("metodo_pagamento"),
                    rs.getDate("data_pagamento"),
                    rs.getDouble("valor_pago")
                );
                pagamento.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar pagamento: " + e.getMessage());
        }
        return pagamento;
    }
}
