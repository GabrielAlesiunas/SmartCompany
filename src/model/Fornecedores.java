package model;

public class Fornecedores {
    private String nome;
    private String cnpj;
    private String contato;
    private String telefone;
    private String email;

    public Fornecedores(String nome, String cnpj, String contato, String telefone, String email) {
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
}
