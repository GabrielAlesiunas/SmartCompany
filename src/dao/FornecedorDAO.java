package dao;

import model.Fornecedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    public boolean verificarFornecedorPorId(int idFornecedor) {
        if (idFornecedor <= 0) {
            throw new IllegalArgumentException("O ID do fornecedor deve ser um número positivo.");
        }

        String sql = "SELECT COUNT(*) FROM fornecedores WHERE id = ?";
        boolean existe = false;

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFornecedor);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                existe = rs.getInt(1) > 0; // Retorna verdadeiro se existir pelo menos um fornecedor
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar fornecedor: " + e.getMessage());
        }

        return existe;
    }

    public Fornecedores buscarFornecedorPorId(int idFornecedor) {
        if (!verificarFornecedorPorId(idFornecedor)) {
            return null; // Retorna null se o fornecedor não existir
        }

        String sql = "SELECT * FROM fornecedores WHERE id = ?";
        Fornecedores fornecedor = null;

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFornecedor);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                fornecedor = new Fornecedores(
                    rs.getString("nome"),
                    rs.getString("cnpj"),
                    rs.getString("contato"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar fornecedor: " + e.getMessage());
        }
        return fornecedor;
    }

    public void cadastrarFornecedor(Fornecedores fornecedor) {
        String sql = "INSERT INTO fornecedores (nome, cnpj, contato, telefone, email) VALUES (?, ?, ?, ?, ?)"; // Adicionado CNPJ

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getContato());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setString(5, fornecedor.getEmail());
            stmt.executeUpdate();

            System.out.println("Fornecedor cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar fornecedor: " + e.getMessage());
        }
    }

    public List<Fornecedores> buscarTodosFornecedores() {
        String sql = "SELECT * FROM fornecedores";
        List<Fornecedores> fornecedores = new ArrayList<>();

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Fornecedores fornecedor = new Fornecedores(
                    rs.getString("nome"),
                    rs.getString("cnpj"),
                    rs.getString("contato"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os fornecedores: " + e.getMessage());
        }
        return fornecedores;
    }

    public List<Fornecedores> buscarFornecedorPorNome(String nome) {
        List<Fornecedores> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM fornecedores WHERE nome LIKE ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%"); // Busca por nome parcial
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedores fornecedor = new Fornecedores(
                    rs.getString("nome"),
                    rs.getString("cnpj"),
                    rs.getString("contato"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar fornecedor por nome: " + e.getMessage());
        }
        return fornecedores;
    }
}
