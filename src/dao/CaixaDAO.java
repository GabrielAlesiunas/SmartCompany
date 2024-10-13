package dao;

import model.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaixaDAO {

    public void salvarCaixa(Caixa caixa) {
        String sql = "INSERT INTO caixa (data_abertura, data_fechamento, saldo) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, caixa.getDataAbertura());
            stmt.setString(2, caixa.getDataFechamento());
            stmt.setDouble(3, caixa.getSaldo());

            stmt.executeUpdate();
            System.out.println("Caixa salvo com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar caixa: " + e.getMessage());
        }
    }

    public void adicionarRegistro(String descricao, double valor, String tipo) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode ser nula ou vazia.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }

        String sql = "INSERT INTO registros_caixa (descricao, valor, data_registro, tipo) VALUES (?, ?, NOW(), ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, descricao);
            stmt.setDouble(2, valor);
            stmt.setString(3, tipo); 

            stmt.executeUpdate();
            System.out.println("Registro adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar registro ao caixa: " + e.getMessage());
        }
    }

    public List<Caixa> listarCaixa() {
        List<Caixa> listaCaixa = new ArrayList<>();
        String sql = "SELECT * FROM caixa";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Caixa caixa = new Caixa(rs.getString("data_abertura"));
                caixa.setDataFechamento(rs.getString("data_fechamento"));
                caixa.setSaldo(rs.getDouble("saldo"));
                listaCaixa.add(caixa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCaixa;
    }

    public List<String> consultarRegistrosCaixa() {
        List<String> listaRegistros = new ArrayList<>();
        String sql = "SELECT * FROM caixa";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String registro = "Data Abertura: " + rs.getString("data_abertura") + 
                                  ", Data Fechamento: " + rs.getString("data_fechamento") + 
                                  ", Saldo: R$" + rs.getDouble("saldo");
                listaRegistros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaRegistros;
    }
}
