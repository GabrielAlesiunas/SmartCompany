package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Estoque; // Certifique-se de importar o modelo Estoque

public class EstoqueDAO {

    public List<Estoque> listarEstoque() {
        List<Estoque> estoque = new ArrayList<>();
        String sql = "SELECT id, id_venda, id_produto, quantidade, preco_unitario FROM estoque";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estoque item = new Estoque();
                item.setId(rs.getInt("id")); // Defina o ID do estoque
                item.setIdVenda(rs.getInt("id_venda"));
                item.setIdProduto(rs.getInt("id_produto"));
                item.setQuantidade(rs.getInt("quantidade"));
                item.setPrecoUnitario(rs.getDouble("preco_unitario"));
                estoque.add(item);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar estoque: " + e.getMessage());
        }
        return estoque;
    }
}
