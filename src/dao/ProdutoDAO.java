package dao;

import model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {
    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO Produto (nome, precoCompra, precoVenda, quantidade) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoCompra());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getQuantidade());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public Produto buscarProdutoPorNome(String nome) {
        String sql = "SELECT * FROM Produto WHERE nome = ?";
        Produto produto = null;

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                produto = new Produto(
                    rs.getString("nome"),
                    rs.getDouble("precoCompra"),
                    rs.getDouble("precoVenda"),
                    rs.getInt("quantidade")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto: " + e.getMessage());
        }
        return produto;
    }
}
