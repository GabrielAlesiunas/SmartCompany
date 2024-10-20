package model;

public class Fornecedores {
    private String nome;
<<<<<<< HEAD
    private String cnpj; // Novo atributo
=======
>>>>>>> ff156fb5ecb2f226116f4ecf66723d3c24558215
    private String contato;
    private String telefone;
    private String email;

<<<<<<< HEAD
    public Fornecedores(String nome, String cnpj, String contato, String telefone, String email) { // Adicionado cnpj ao construtor
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio");
        if (cnpj == null || cnpj.trim().isEmpty()) throw new IllegalArgumentException("CNPJ não pode ser vazio"); // Validação para CNPJ
=======
    public Fornecedores(String nome, String contato, String telefone, String email) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio");
>>>>>>> ff156fb5ecb2f226116f4ecf66723d3c24558215
        if (contato == null || contato.trim().isEmpty()) throw new IllegalArgumentException("Contato não pode ser vazio");
        if (telefone == null || telefone.trim().isEmpty()) throw new IllegalArgumentException("Telefone não pode ser vazio");
        if (email == null || email.trim().isEmpty()) throw new IllegalArgumentException("Email não pode ser vazio");
        
        this.nome = nome;
<<<<<<< HEAD
        this.cnpj = cnpj; // Atribuição do CNPJ
=======
>>>>>>> ff156fb5ecb2f226116f4ecf66723d3c24558215
        this.contato = contato;
        this.telefone = telefone;
        this.email = email;
    }

    // Métodos getters
    public String getNome() {
        return nome;
    }

<<<<<<< HEAD
    public String getCnpj() { // Método get para CNPJ
        return cnpj;
    }

=======
>>>>>>> ff156fb5ecb2f226116f4ecf66723d3c24558215
    public String getContato() {
        return contato;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Fornecedores{" +
                "nome='" + nome + '\'' +
<<<<<<< HEAD
                ", cnpj='" + cnpj + '\'' + // Adicionado CNPJ
=======
>>>>>>> ff156fb5ecb2f226116f4ecf66723d3c24558215
                ", contato='" + contato + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
