package view;
import dao.ProdutoDAO;
import model.Produto;

public class main {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        Produto produto = new Produto("Alface Orgânica", 1.50, 3.00, 50);
        produtoDAO.adicionarProduto(produto);

        Produto produtoBuscado = produtoDAO.buscarProdutoPorNome("Alface Orgânica");
        if (produtoBuscado != null) {
            System.out.println("Produto encontrado: " + produtoBuscado.getNome() + " - Quantidade: " + produtoBuscado.getQuantidade());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
