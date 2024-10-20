package dao;

import model.Produto;
import java.sql.Connection;
import java.sql.Date; // Importa java.sql.Date
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
<<<<<<< HEAD

	public void adicionarProduto(Produto produto) {
	    // Validações para o produto
	    if (produto.getNome() == null || produto.getNome().isEmpty()) {
	        throw new IllegalArgumentException("O nome do produto não pode ser nulo ou vazio.");
	    }
	    if (produto.getPreco() < 0 || produto.getQuantidadeEstoque() < 0 || produto.getLimiteEstoque() < 0) {
	        throw new IllegalArgumentException("Os valores de preço e quantidade não podem ser negativos.");
	    }

	    String sql = "INSERT INTO produtos (nome, categoria, preco, quantidade_estoque, limite_estoque, data_adicao, id_fornecedor) VALUES (?, ?, ?, ?, ?, ?, ?)";

	    try (Connection conn = ConexaoDB.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

	        stmt.setString(1, produto.getNome());
	        stmt.setString(2, produto.getCategoria());
	        stmt.setDouble(3, produto.getPreco());
	        stmt.setInt(4, produto.getQuantidadeEstoque());
	        stmt.setInt(5, produto.getLimiteEstoque());
	        stmt.setDate(6, Date.valueOf(produto.getDataAdicao())); // Converte LocalDate para java.sql.Date
	        stmt.setInt(7, produto.getIdFornecedor());

	        stmt.executeUpdate();
	        System.out.println("Produto inserido com sucesso!");

	        // Recupera o ID gerado para o produto
	        ResultSet rs = stmt.getGeneratedKeys();
	        if (rs.next()) {
	            int idProduto = rs.getInt(1); // ID do produto recém-inserido
	            
	            // Atualizar a tabela de estoque com o novo produto
	            adicionarEstoque(idProduto, produto.getQuantidadeEstoque());
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Imprime a pilha de rastreamento para facilitar a depuração
	        System.out.println("Erro ao inserir produto: " + e.getMessage());
	    }
	}

    // Método para atualizar a tabela de estoque
	private void adicionarEstoque(int idProduto, int quantidade) {
	    String sql = "INSERT INTO estoque (id_produto, quantidade) VALUES (?, ?)";

	    try (Connection conn = ConexaoDB.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, idProduto); // ID do produto que foi recém-inserido
	        stmt.setInt(2, quantidade); // A quantidade a ser adicionada ao estoque

	        stmt.executeUpdate();
	        System.out.println("Estoque adicionado para o produto ID: " + idProduto);
	    } catch (SQLException e) {
	        e.printStackTrace(); // Imprime a pilha de rastreamento
	        System.out.println("Erro ao adicionar estoque: " + e.getMessage());
	    }
	}

    // Método para buscar produtos por nome parcial
    public List<Produto> buscarProdutoPorNomeParcial(String nome) {
        String sql = "SELECT * FROM produtos WHERE LOWER(nome) LIKE LOWER(?)"; // Busca case-insensitive
        List<Produto> produtos = new ArrayList<>();
=======
    
    public void adicionarProduto(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser nulo ou vazio.");
        }
        if (produto.getPreco() < 0 || produto.getQuantidadeEstoque() < 0 || produto.getLimiteEstoque() < 0) {
            throw new IllegalArgumentException("Os valores de preço e quantidade não podem ser negativos.");
        }

        String sql = "INSERT INTO produtos (nome, categoria, preco, quantidade_estoque, limite_estoque, data_adicao, id_fornecedor) VALUES (?, ?, ?, ?, ?, ?, ?)";
>>>>>>> ff156fb5ecb2f226116f4ecf66723d3c24558215

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

<<<<<<< HEAD
=======
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCategoria());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidadeEstoque());
            stmt.setInt(5, produto.getLimiteEstoque());
            stmt.setDate(6, new java.sql.Date(produto.getDataAdicao().getTime()));
            stmt.setInt(7, produto.getIdFornecedor());

            stmt.executeUpdate();
            System.out.println("Produto inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public List<Produto> buscarProdutoPorNomeParcial(String nome) {
        String sql = "SELECT * FROM produtos WHERE LOWER(nome) LIKE LOWER(?)"; // Busca case-insensitive com LIKE
        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

>>>>>>> ff156fb5ecb2f226116f4ecf66723d3c24558215
            stmt.setString(1, "%" + nome + "%"); // Usar '%' para buscar por partes do nome
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto(
                    rs.getString("nome"),
                    rs.getString("categoria"),
                    rs.getDouble("preco"),
                    rs.getInt("quantidade_estoque"),
                    rs.getInt("limite_estoque"),
                    rs.getDate("data_adicao").toLocalDate(), // Converte java.sql.Date para LocalDate
                    rs.getInt("id_fornecedor")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
<<<<<<< HEAD
            e.printStackTrace(); // Imprime a pilha de rastreamento
=======
>>>>>>> ff156fb5ecb2f226116f4ecf66723d3c24558215
            System.out.println("Erro ao buscar produtos: " + e.getMessage());
        }
        return produtos;
    }

<<<<<<< HEAD
    // Método para buscar todos os produtos
=======
>>>>>>> ff156fb5ecb2f226116f4ecf66723d3c24558215
    public List<Produto> buscarTodosProdutos() {
        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto(
                    rs.getString("nome"),
                    rs.getString("categoria"),
                    rs.getDouble("preco"),
                    rs.getInt("quantidade_estoque"),
                    rs.getInt("limite_estoque"),
<<<<<<< HEAD
                    rs.getDate("data_adicao").toLocalDate(), // Converte java.sql.Date para LocalDate
=======
                    rs.getDate("data_adicao"),
>>>>>>> ff156fb5ecb2f226116f4ecf66723d3c24558215
                    rs.getInt("id_fornecedor")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
<<<<<<< HEAD
            e.printStackTrace(); // Imprime a pilha de rastreamento
=======
>>>>>>> ff156fb5ecb2f226116f4ecf66723d3c24558215
            System.out.println("Erro ao buscar produtos: " + e.getMessage());
        }
        return produtos;
    }

<<<<<<< HEAD
    // Método para verificar se um produto existe
=======
>>>>>>> ff156fb5ecb2f226116f4ecf66723d3c24558215
    public boolean verificarProdutoExistente(String nome) {
        String sql = "SELECT COUNT(*) FROM produtos WHERE LOWER(nome) = LOWER(?)";
        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna verdadeiro se existir pelo menos um produto
            }
        } catch (SQLException e) {
<<<<<<< HEAD
            e.printStackTrace(); // Imprime a pilha de rastreamento
=======
>>>>>>> ff156fb5ecb2f226116f4ecf66723d3c24558215
            System.out.println("Erro ao verificar produto: " + e.getMessage());
        }
        return false; // Produto não existe
    }
}
