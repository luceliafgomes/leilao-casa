/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
       String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, produto.getNome());
            pstm.setDouble(2, produto.getValor());
            pstm.setString(3, produto.getStatus());
            pstm.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Erro ao salvar produto: " + e.getMessage(), 
                "Erro SQL", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        String sql = "SELECT * FROM produtos ORDER BY id ASC";
        ArrayList<ProdutosDTO> listagem = new ArrayList<>();
        
        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {
            
            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getDouble("valor"));
                produto.setStatus(rs.getString("status"));
                listagem.add(produto);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "❌ Erro ao listar produtos: " + e.getMessage(), 
                "Erro SQL", JOptionPane.ERROR_MESSAGE);
        }
        return listagem;
    }

    
    
    
        
}

