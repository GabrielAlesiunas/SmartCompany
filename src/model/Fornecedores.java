package model;

public class Fornecedores {
    private String nome;
    private String cnpj; // Novo atributo
    private String contato;
    private String telefone;
    private String email;

    public Fornecedores(String nome, String cnpj, String contato, String telefone, String email) { // Adicionado cnpj ao construtor
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio");
        if (cnpj == null || cnpj.trim().isEmpty()) throw new IllegalArgumentException("CNPJ não pode ser vazio"); // Validação para CNPJ
        if (contato == null || contato.trim().isEmpty()) throw new IllegalArgumentException("Contato não pode ser vazio");
        if (telefone == null || telefone.trim().isEmpty()) throw new IllegalArgumentException("Telefone não pode ser vazio");
        if (email == null || email.trim().isEmpty()) throw new IllegalArgumentException("Email não pode ser vazio");
        
        this.nome = nome;
        this.cnpj = cnpj; // Atribuição do CNPJ
        this.contato = contato;
        this.telefone = telefone;
        this.email = email;
    }

    // Métodos getters
    public String getNome() {
        return nome;
    }

    public String getCnpj() { // Método get para CNPJ
        return cnpj;
    }

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
                ", cnpj='" + cnpj + '\'' + // Adicionado CNPJ
                ", contato='" + contato + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
