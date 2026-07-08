package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
        public static Connection conectar() {
        Connection conexao = null;
    
    String url = "jdbc:postgresql://localhost:/banco_app";
        String usuario = "postgres";
        String senha = "root";
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");
        } catch (SQLException erro){
            System.out.println("Erro ao conectar.");
            System.out.println(erro.getMessage());
        }
            
        return conexao;
        
        }
}
