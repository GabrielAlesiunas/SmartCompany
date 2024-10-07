package view;

import dao.ProdutoDAO;
import dao.FornecedorDAO;
import model.Produto;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        
        Produto produto = new Produto("Cenoura Orgânica", "Vegetais", 2.80, 60, 120, new Date(), 1);
        
        if (fornecedorDAO.verificarFornecedorPorId(produto.getIdFornecedor())) {
            Produto produtoBuscado = produtoDAO.buscarProdutoPorNome(produto.getNome());
        
            if (produtoBuscado == null) {
                produtoDAO.adicionarProduto(produto);
                System.out.println("Produto adicionado: " + produto.getNome());
            } else {
                System.out.println("Produto já existe: " + produtoBuscado.getNome() + 
                                   " - Preço: " + produtoBuscado.getPreco() +
                                   " - Quantidade em Estoque: " + produtoBuscado.getQuantidadeEstoque());
            }
        } else {
            System.out.println("Erro: O fornecedor com ID " + produto.getIdFornecedor() + " não existe.");
        }
    }
}
