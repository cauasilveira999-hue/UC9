package Funcionario;

import Conexoes.Conexao;
import static Conexoes.Conexao.conectar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;

public class Professor {
    
     public static Connection cadastrarProfessor() {
        Connection conexao = null;

        Scanner entrada = new Scanner(System.in);

        String url = "jdbc:postgresql://localhost/Escola";
        String usuario = "postgres";
        String senha = "root";

        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");

            String sql = "INSERT INTO professor(nome,cpf,telefone,disciplina,ativo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            System.out.print("Digite o nome do professor:  ");
            String nomeProfessor = entrada.nextLine();

            System.out.print("Digite o CPF do professor:  ");
            String cpf = entrada.nextLine();

            System.out.print("Digite o telefone do professor:  ");
            int telefone = entrada.nextInt();
            entrada.nextLine();
            
            System.out.print("Digite a disciplina do professor:  ");
            String disciplina = entrada.nextLine();

            System.out.print("O professor está ativo:  ");
            Boolean ativo = entrada.nextBoolean();

            System.out.println();
            System.out.println("==========================");
            System.out.println("   CADASTRO DE PROFESSOR            ");
            System.out.println("==========================");
            System.out.println("Nome: " + nomeProfessor);
            System.out.println("CPF: " + cpf);
            System.out.println("Telefone: " + telefone);
            System.out.println("Disciplina: " + disciplina);
            System.out.println("Ativo: " + ativo);
            System.out.println("==========================");

            stmt.setString(1, nomeProfessor);
            stmt.setString(2, cpf);
            stmt.setInt(3, telefone);
            stmt.setString(4, disciplina);
            stmt.setBoolean(5, ativo);

            int linhas = stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            System.out.println("Erro ao conectar.");
            System.out.println(erro.getMessage());
        }

        return conexao;
    }

     
     public static void alterarProfessor() {

        Scanner entrada = new Scanner(System.in);

        String sql = """
                         UPDATE professor
                         Set nome = ?, cpf = ?, telefone = ?, disciplina = ?, ativo = ?
                         WHERE id = ?
                         """;
        try {
            Connection conexao = conectar();

            System.out.println("Digite o ID do professor: ");
            int id = entrada.nextInt();

            System.out.print("Digite o nome do professor:  ");
            String nomeProfessor = entrada.nextLine();

            System.out.print("Digite o CPF do professor:  ");
            String cpf = entrada.nextLine();
            entrada.nextLine();

            System.out.print("Digite o telefone do professor:  ");
            int telefone = entrada.nextInt();
            
            System.out.print("Digite a disciplina do professor:  ");
            String disciplina = entrada.nextLine();
            
            System.out.print("Digite se o professor está ativo:  ");
            Boolean ativo = entrada.nextBoolean();

            System.out.println();
            System.out.println("==========================");
            System.out.println("     ALTERAR PROFESSOR            ");
            System.out.println("==========================");
            System.out.println("Nome: " + nomeProfessor);
            System.out.println("CPF: " + cpf);
            System.out.println("Telefone: " + telefone);
            System.out.println("Disciplina: " + disciplina);
            System.out.println("Ativo: " + ativo);
            System.out.println("==========================");

            PreparedStatement stmt = conexao.prepareStatement(sql);

           stmt.setString(1, nomeProfessor);
            stmt.setString(2, cpf);
            stmt.setInt(3, telefone);
            stmt.setString(4, disciplina);
            stmt.setBoolean(5, ativo);

            int linhas = stmt.executeUpdate();

            conexao.close();

        } catch (SQLException erro) {
            System.out.println("erro ao alterar o professor");
            System.out.println(erro.getMessage());
        }

    }

     
     public static void deletarProfessor() {

        String sql = """
                     DELETE FROM professor
                     Set nome = ?, cpf = ?, telefone = ?, disciplina = ?, ativo = ?
                     WHERE id = ?
                     """;

        try {
            Connection conexao = conectar();

            Scanner entrada = new Scanner(System.in);

            PreparedStatement stmt = conexao.prepareStatement(sql);

            System.out.println("Digite o ID do professor: ");
            int id = entrada.nextInt();

            System.out.print("Digite o nome do professor:  ");
            String nomeProfessor = entrada.nextLine();

            System.out.print("Digite o CPF do professor:  ");
            String cpf = entrada.nextLine();
            entrada.nextLine();

            System.out.print("Digite o telefone do professor:  ");
            int telefone = entrada.nextInt();
            
            System.out.print("Digite a disciplina do professor:  ");
            String disciplina = entrada.nextLine();
            
            System.out.print("Digite se o professor está ativo:  ");
            Boolean ativo = entrada.nextBoolean();

            System.out.println();
            System.out.println("==========================");
            System.out.println("      DADOS APAGADOS          ");
            System.out.println("==========================");
            System.out.println("Nome: " + nomeProfessor);
            System.out.println("CPF: " + cpf);
            System.out.println("Telefone: " + telefone);
            System.out.println("Disciplina: " + disciplina);
            System.out.println("Ativo: " + ativo);
            System.out.println("ID: " + id);
            System.out.println("==========================");

            stmt.setInt(id, id);

            int linhas = stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            System.out.println("erro ao apagar o professor");
            System.out.println(erro.getMessage());
        }

    }

     
     public static void buscarProfessor() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o id do professor");
        int id = entrada.nextInt();

        String sql = """
                     SELECT * FROM professor
                     WHERE id = ?
                     """;

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                System.out.println("Professor encontrado");
                System.out.println("ID: " + resultado.getInt("id"));
                System.out.println("Nome: " + resultado.getString("nomeProfessor"));
                System.out.println("CPF: " + resultado.getString("cpf"));
                System.out.println("Telefone: " + resultado.getInt("telefone"));
                System.out.println("Disciplina: " + resultado.getString("disciplina"));
                System.out.println("Ativo: " + resultado.getBoolean("ativo"));
            } else {
                System.out.println("Professor não encontrado");
            }

            resultado.close();
            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            System.out.println("Erro ao buscar professor");
            System.out.println(erro.getMessage());
        }
        entrada.close();
    }
    
     
     public static void listarProfessor(){
        String sql = """
                     SELECT * FROM professor
                     ORDER BY id
                     """;
        
        try {
            Connection conexao = conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            System.out.println();
            System.out.println("=============================");
            System.out.println("   PROFESSORES CADASTRADOS");
            System.out.println("=============================");
            
            boolean encontrouProfessor = false;
            
            while(resultado.next()){
                encontrouProfessor= true;
                System.out.println("ID: " + resultado.getInt("id"));
                System.out.println("Nome: " + resultado.getString("nome"));
                System.out.println("CPF: " + resultado.getString("cpf"));
                System.out.println("Telefone: " + resultado.getInt("telefone"));
                System.out.println("Disciplina: " + resultado.getString("disciplina"));
                System.out.println("Ativo: " + resultado.getBoolean("ativo"));
                System.out.println("==========================");
            }  
            
            if(encontrouProfessor){
                System.out.println("Nenhum professor cadastrado");
            }
            
            resultado.close();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            System.out.println("Erro ao buscar professor");
            System.out.println(erro.getMessage());
    }
    }
}
