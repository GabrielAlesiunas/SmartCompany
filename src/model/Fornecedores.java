package model;

public class Fornecedores {
    private String nome;
    private String contato;
    private String telefone;
    private String email;
    private String cnpj;

    // Construtor completo
    public Fornecedores(String nome, String cnpj, String contato, String telefone, String email) {
        if (nome == null || nome.trim().isEmpty()) 
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        if (cnpj == null || cnpj.trim().isEmpty()) 
            throw new IllegalArgumentException("CNPJ não pode ser vazio.");
        if (contato == null || contato.trim().isEmpty()) 
            throw new IllegalArgumentException("Contato não pode ser vazio.");
        if (telefone == null || telefone.trim().isEmpty()) 
            throw new IllegalArgumentException("Telefone não pode ser vazio.");
        if (email == null || email.trim().isEmpty()) 
            throw new IllegalArgumentException("Email não pode ser vazio.");

        this.nome = nome;
        this.cnpj = cnpj;
        this.contato = contato;
        this.telefone = telefone;
        this.email = email;
    }

    // Construtor sem CNPJ
    public Fornecedores(String nome, String contato, String telefone, String email) {
        this(nome, "Não informado", contato, telefone, email);
    }

    // Getters
    public String getNome() {
        return nome;
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

    public String getCnpj() {
        return cnpj;
    }

    // Setters
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) 
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        this.nome = nome;
    }

    public void setContato(String contato) {
        if (contato == null || contato.trim().isEmpty()) 
            throw new IllegalArgumentException("Contato não pode ser vazio.");
        this.contato = contato;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) 
            throw new IllegalArgumentException("Telefone não pode ser vazio.");
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) 
            throw new IllegalArgumentException("Email não pode ser vazio.");
        this.email = email;
    }

    public void setCnpj(String cnpj) {
        if (cnpj == null || cnpj.trim().isEmpty()) 
            throw new IllegalArgumentException("CNPJ não pode ser vazio.");
        this.cnpj = cnpj;
    }

    // Método toString
    @Override
    public String toString() {
        return "Fornecedor {" +
               "nome='" + nome + '\'' +
               ", contato='" + contato + '\'' +
               ", telefone='" + telefone + '\'' +
               ", email='" + email + '\'' +
               ", cnpj='" + cnpj + '\'' +
               '}';
    }
}
