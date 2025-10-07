
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {

    public Connection connectDB() {
        Connection conn = null;

        try {
            // Conexão ajustada para evitar erro de SSL e timezone
            String url = "jdbc:mysql://localhost:3306/leilao?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String user = "root";
            String password = "123456789";

            conn = DriverManager.getConnection(url, user, password);
            // Mensagem opcional de debug (pode remover)
            // System.out.println("Conexão estabelecida com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, 
                "Erro ao conectar ao banco de dados: " + erro.getMessage(),
                "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
        }

        return conn;
    }
    
   /* public static void main(String[] args) {
        conectaDAO conexao = new conectaDAO();
        Connection conn = conexao.connectDB();

        if (conn != null) {
            System.out.println("✅ Conexão bem-sucedida com o banco de dados!");
        } else {
            System.out.println("❌ Falha na conexão com o banco de dados!");
        }
    }*/
}