package view;

import dao.ProdutoDAO;
import dao.FornecedorDAO;
import dao.ClienteDAO;
import dao.EstoqueDAO;
import dao.PagamentosDAO;
import dao.VendasDAO;
import dao.CaixaDAO;
import dao.AlertaEstoqueDAO;
import model.Produto;
import model.Fornecedores;
import model.Cliente;
import model.Estoque;
import model.Pagamentos;
import model.Vendas;
import model.Caixa;
import model.AlertaEstoque;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        ClienteDAO clienteDAO = new ClienteDAO(); 
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        PagamentosDAO pagamentoDAO = new PagamentosDAO();
        VendasDAO vendasDAO = new VendasDAO();
        CaixaDAO caixaDAO = new CaixaDAO();
        AlertaEstoqueDAO alertaEstoqueDAO = new AlertaEstoqueDAO();
        
        boolean continuar = true;
        boolean menuAberto = true;

        while (continuar) {
            if (menuAberto) {
                System.out.println("=== Bem-vindo ao Sistema de Gestão ===");
                System.out.println("Escolha uma opção:");
                System.out.println("1) Consultar todos Produtos");
                System.out.println("2) Buscar Produto por Nome");
                System.out.println("3) Cadastrar Produto");
                System.out.println("4) Consultar Todos Fornecedores");
                System.out.println("5) Consultar Fornecedor por Nome");
                System.out.println("6) Cadastrar Fornecedor");
                System.out.println("7) Consultar Clientes");
                System.out.println("8) Buscar Cliente por Nome");
                System.out.println("9) Cadastrar Clientes");
                System.out.println("10) Consultar caixa");
                System.out.println("11) Consultar Vendas");
                System.out.println("12) Consultar Pagamentos");
                System.out.println("13) Consultar Estoque");
                System.out.println("14) Alerta Estoque");
                System.out.println("99) Abrir Menu Novamente");
                System.out.println("0) Sair");
                System.out.print("Digite sua opção: ");
            }

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    consultarTodosProdutos(produtoDAO);
                    menuAberto = false;
                    break;
                case 2:
                    buscarProdutoPorNomeParcial(produtoDAO, scanner);
                    menuAberto = false;
                    break;
                case 3:
                    cadastrarProduto(produtoDAO, scanner);
                    menuAberto = false;
                    break;
                case 4:
                    consultarTodosFornecedores(fornecedorDAO);
                    menuAberto = false;
                    break;
                case 5:
                    buscarFornecedorPorNome(fornecedorDAO, scanner);
                    menuAberto = false;
                    break;
                case 6:
                    cadastrarFornecedor(fornecedorDAO, scanner);
                    menuAberto = false;
                    break;
                case 7:
                    consultarClientes(clienteDAO);
                    menuAberto = false;
                    break;
                case 8:
                    buscarClientePorNome(clienteDAO, scanner);
                    menuAberto = false;
                    break;
                case 9:
                    cadastrarCliente(clienteDAO, scanner);
                    menuAberto = false;
                    break;
                case 10:
                    consultarCaixa(caixaDAO);
                    menuAberto = false;
                    break;
                case 11:
                    consultarVendas(vendasDAO);
                    menuAberto = false;
                    break;
                case 12:
                    listarPagamentos(pagamentoDAO);
                    menuAberto = false;
                    break;
                case 13:
                    consultarEstoque(estoqueDAO);
                    menuAberto = false;
                    break;
                case 14:
                	verificarEstoqueBaixo(estoqueDAO, alertaEstoqueDAO);
                    menuAberto = false;
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                case 99:
                    menuAberto = true; // O usuário escolheu abrir o menu novamente
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close(); // Fechar o scanner ao final
    }

    private static void consultarTodosProdutos(ProdutoDAO produtoDAO) {
        List<Produto> produtos = produtoDAO.buscarTodosProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println("Nome: " + produto.getNome() + 
                                   ", Categoria: " + produto.getCategoria() + 
                                   ", Preço: " + produto.getPreco() + 
                                   ", Estoque: " + produto.getQuantidadeEstoque());
            }
        }
    }

    private static void consultarTodosFornecedores(FornecedorDAO fornecedorDAO) {
        List<Fornecedores> fornecedores = fornecedorDAO.buscarTodosFornecedores();
        if (fornecedores.isEmpty()) {
            System.out.println("Nenhum fornecedor cadastrado.");
        } else {
            for (Fornecedores fornecedor : fornecedores) {
                System.out.println("Nome: " + fornecedor.getNome() + 
                                   ", Contato: " + fornecedor.getContato() + 
                                   ", Telefone: " + fornecedor.getTelefone() + 
                                   ", Email: " + fornecedor.getEmail());
            }
        }
    }

    private static void buscarFornecedorPorNome(FornecedorDAO fornecedorDAO, Scanner scanner) {
        System.out.print("Digite o nome do fornecedor a ser buscado: ");
        String nome = scanner.nextLine();

        List<Fornecedores> fornecedoresEncontrados = fornecedorDAO.buscarFornecedorPorNome(nome);
        if (fornecedoresEncontrados.isEmpty()) {
            System.out.println("Nenhum fornecedor encontrado com o nome: " + nome);
        } else {
            System.out.println("Fornecedores encontrados:");
            for (Fornecedores fornecedor : fornecedoresEncontrados) {
                System.out.println("Nome: " + fornecedor.getNome() + 
                                   ", Contato: " + fornecedor.getContato() + 
                                   ", Telefone: " + fornecedor.getTelefone() + 
                                   ", Email: " + fornecedor.getEmail());
            }
        }
    }

    private static void buscarProdutoPorNomeParcial(ProdutoDAO produtoDAO, Scanner scanner) {
        System.out.print("Digite o nome do produto a ser buscado: ");
        String nome = scanner.nextLine();

        List<Produto> produtosEncontrados = produtoDAO.buscarProdutoPorNomeParcial(nome);
        if (produtosEncontrados.isEmpty()) {
            System.out.println("Nenhum produto encontrado com o nome: " + nome);
        } else {
            System.out.println("Produtos encontrados:");
            for (Produto produto : produtosEncontrados) {
                System.out.println("Nome: " + produto.getNome() + 
                                   ", Categoria: " + produto.getCategoria() + 
                                   ", Preço: " + produto.getPreco() + 
                                   ", Estoque: " + produto.getQuantidadeEstoque());
            }
        }
    }

    private static void cadastrarProduto(ProdutoDAO produtoDAO, Scanner scanner) {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        // Verificar se o produto já existe
        if (produtoDAO.verificarProdutoExistente(nome)) {
            System.out.println("Produto já existe. Tente outro nome.");
            return;
        }

        System.out.print("Digite a categoria do produto: ");
        String categoria = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Digite a quantidade em estoque: ");
        int quantidadeEstoque = scanner.nextInt();
        System.out.print("Digite o limite de estoque: ");
        int limiteEstoque = scanner.nextInt();
        System.out.print("Digite o ID do fornecedor: ");
        int idFornecedor = scanner.nextInt();
        LocalDate dataAdicao = LocalDate.now();
        
        Produto produto = new Produto(nome, categoria, preco, quantidadeEstoque, limiteEstoque, dataAdicao, idFornecedor);
        produtoDAO.adicionarProduto(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void cadastrarFornecedor(FornecedorDAO fornecedorDAO, Scanner scanner) {
        System.out.print("Digite o nome do fornecedor: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite o CNPJ do fornecedor: ");
        String cnpj = scanner.nextLine();
        
        System.out.print("Digite o contato do fornecedor: ");
        String contato = scanner.nextLine();
        
        System.out.print("Digite o telefone do fornecedor: ");
        String telefone = scanner.nextLine();
        
        System.out.print("Digite o e-mail do fornecedor: ");
        String email = scanner.nextLine();

        Fornecedores fornecedor = new Fornecedores(nome, cnpj, contato, telefone, email);
        
        fornecedorDAO.cadastrarFornecedor(fornecedor);
        System.out.println("Fornecedor cadastrado com sucesso!");
    }

    private static void consultarClientes(ClienteDAO clienteDAO) {
        List<Cliente> clientes = clienteDAO.buscarTodosClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println("Nome: " + cliente.getNome() + 
                                   ", Email: " + cliente.getEmail() + 
                                   ", Telefone: " + cliente.getTelefone());
            }
        }
    }

    private static void cadastrarCliente(ClienteDAO clienteDAO, Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone);
        clienteDAO.cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // O método buscarClientePorNome foi atualizado para ser estático
    private static void buscarClientePorNome(ClienteDAO clienteDAO, Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        Cliente cliente = clienteDAO.buscarClientePorNome(nomeCliente);

        if (cliente != null) {
            System.out.println("Cliente encontrado:");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getTelefone());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
    
    private static void consultarEstoque(EstoqueDAO estoqueDAO) {
    	List<Estoque> estoques = estoqueDAO.listarEstoque(); // Use o método listarEstoque
    	if (estoques.isEmpty()) {
    		System.out.println("Nenhum item no estoque.");
    	} else {
    		for (Estoque estoque : estoques) {
    			System.out.println("ID: " + estoque.getId() +
    					", ID Venda: " + estoque.getIdVenda() +
    					", ID Produto: " + estoque.getIdProduto() +
    					", Quantidade: " + estoque.getQuantidade() +
    					", Preço Unitário: " + estoque.getPrecoUnitario());
    		}
    	}
    }
    
    private static void listarPagamentos(PagamentosDAO pagamentoDAO) {
        List<Pagamentos> pagamentos = pagamentoDAO.listarPagamentos();
        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento registrado.");
        } else {
            for (Pagamentos p : pagamentos) {
                System.out.println("ID: " + p.getId() +
                                   ", Venda ID: " + p.getIdVenda() +
                                   ", Método: " + p.getMetodoPagamento() +
                                   ", Data: " + p.getDataPagamento() +
                                   ", Valor: " + p.getValorPago());
            }
        }
    }
    
    private static void consultarVendas(VendasDAO vendasDAO) {
        List<Vendas> vendas = vendasDAO.consultarVendas();
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            for (Vendas venda : vendas) {
                System.out.println("Venda ID: " + venda.getId() +
                                   ", Data: " + venda.getDataVenda() +
                                   ", Valor Total: " + venda.getValorTotal() +
                                   ", ID Cliente: " + venda.getIdCliente());
            }
        }
    }
    
    private static void consultarCaixa(CaixaDAO caixaDAO) {
        List<String> registros = caixaDAO.consultarRegistrosCaixa();
        if (registros.isEmpty()) {
            System.out.println("Nenhum registro encontrado no caixa.");
        } else {
            for (String registro : registros) {
                System.out.println(registro);
            }
        }
    }
    
    private static void verificarEstoqueBaixo(EstoqueDAO estoqueDAO, AlertaEstoqueDAO alertaEstoqueDAO) {
        int limiteEstoque = 10;
        List<Estoque> estoqueBaixo = estoqueDAO.listarEstoqueBaixo(limiteEstoque);

        if (estoqueBaixo.isEmpty()) {
            System.out.println("Nenhum produto com estoque baixo.");
        } else {
            for (Estoque item : estoqueBaixo) {
                String mensagem = "Estoque baixo para o produto ID " + item.getIdProduto() + 
                                  ". Quantidade atual: " + item.getQuantidade();
                alertaEstoqueDAO.adicionarAlerta(item.getIdProduto(), mensagem);
                System.out.println("Alerta gerado para o produto ID: " + item.getIdProduto());
            }
        }
    }
}
