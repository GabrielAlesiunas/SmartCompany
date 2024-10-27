package model;

public class Fornecedores {
    private String nome;
    private String cnpj;
    private String contato;
    private String telefone;
    private String email;

    public Fornecedores(String nome, String cnpj, String contato, String telefone, String email) { 
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio");
        if (cnpj == null || cnpj.trim().isEmpty()) throw new IllegalArgumentException("CNPJ não pode ser vazio");
    }
    
    public Fornecedores(String nome, String contato, String telefone, String email) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio");
        if (contato == null || contato.trim().isEmpty()) throw new IllegalArgumentException("Contato não pode ser vazio");
        if (telefone == null || telefone.trim().isEmpty()) throw new IllegalArgumentException("Telefone não pode ser vazio");
        if (email == null || email.trim().isEmpty()) throw new IllegalArgumentException("Email não pode ser vazio");
        
        this.nome = nome;
        this.cnpj = cnpj;
        this.contato = contato;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
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
                ", cnpj='" + cnpj + '\'' +
                ", contato='" + contato + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
