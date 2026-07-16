package Conexoes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;
import Funcionario.Professor;
        
public class Conexao {

    public static Connection conectar() {
        Connection conexao = null;

        String url = "jdbc:postgresql://localhost/Escola";
        String usuario = "postgres";
        String senha = "root";

        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");

        } catch (SQLException erro) {
            System.out.println("Erro ao conectar.");
            System.out.println(erro.getMessage());
        }

        return conexao;
    }

    public static Connection Cadastrar() {
        Connection conexao = null;

        Scanner entrada = new Scanner(System.in);

        String url = "jdbc:postgresql://localhost/Escola";
        String usuario = "postgres";
        String senha = "root";

        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");

            String sql = "INSERT INTO aluno(nome,turma,email) VALUES (?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            System.out.print("Digite o nome do aluno:  ");
            String nome = entrada.nextLine();

            System.out.print("Digite a id do aluno:  ");
            int turma = entrada.nextInt();
            entrada.nextLine();

            System.out.print("Digite a email do aluno:  ");
            String email = entrada.nextLine();

            System.out.println();
            System.out.println("==========================");
            System.out.println("     CADASTRO DE ALUNOS            ");
            System.out.println("==========================");
            System.out.println("Nome: " + nome);
            System.out.println("Turma: " + turma);
            System.out.println("Email: " + email);
            System.out.println("Email: " + email);
            System.out.println("==========================");

            stmt.setString(1, nome);
            stmt.setInt(2, turma);
            stmt.setString(3, email);

            int linhas = stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            System.out.println("Erro ao conectar.");
            System.out.println(erro.getMessage());
        }

        return conexao;
    }

    public static void alterar() {

        Scanner entrada = new Scanner(System.in);

        String sql = """
                         UPDATE aluno
                         Set nome = ?, turma = ?, email = ?
                         WHERE id = ?
                         """;
        try {
            Connection conexao = conectar();

            System.out.println("Digite o ID do aluno: ");
            int id = entrada.nextInt();

            System.out.print("Digite o nome do aluno:  ");
            String nome = entrada.nextLine();

            System.out.print("Digite a id do aluno:  ");
            int turma = entrada.nextInt();
            entrada.nextLine();

            System.out.print("Digite a email do aluno:  ");
            String email = entrada.nextLine();

            System.out.println();
            System.out.println("==========================");
            System.out.println("       DADOS DO ALUNO            ");
            System.out.println("==========================");
            System.out.println("Nome: " + nome);
            System.out.println("Turma: " + turma);
            System.out.println("Email: " + email);
            System.out.println("ID: " + id);
            System.out.println("==========================");

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setInt(2, turma);
            stmt.setString(3, email);
            stmt.setInt(id, id);

            int linhas = stmt.executeUpdate();

            conexao.close();

        } catch (SQLException erro) {
            System.out.println("erro ao alterar o aluno");
            System.out.println(erro.getMessage());
        }

    }

    public static void deletar() {

        String sql = """
                     DELETE FROM aluno
                     Set nome = ?, turma = ?, email = ?
                     WHERE id = ?
                     """;

        try {
            Connection conexao = conectar();

            Scanner entrada = new Scanner(System.in);

            PreparedStatement stmt = conexao.prepareStatement(sql);

            System.out.println("Digite o ID do aluno: ");
            int id = entrada.nextInt();

            System.out.print("Digite o nome do aluno:  ");
            String nome = entrada.nextLine();

            System.out.print("Digite a id do aluno:  ");
            int turma = entrada.nextInt();
            entrada.nextLine();

            System.out.print("Digite a email do aluno:  ");
            String email = entrada.nextLine();

            System.out.println();
            System.out.println("==========================");
            System.out.println("      DADOS APAGADOS          ");
            System.out.println("==========================");
            System.out.println("Nome: " + nome);
            System.out.println("Turma: " + turma);
            System.out.println("Email: " + email);
            System.out.println("ID: " + id);
            System.out.println("==========================");

            stmt.setInt(id, id);

            int linhas = stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            System.out.println("erro ao apagar o aluno");
            System.out.println(erro.getMessage());
        }

    }

    public static void buscarAluno() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o id do aluno");
        int id = entrada.nextInt();

        String sql = """
                     SELECT * FROM aluno
                     WHERE id = ?
                     """;

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                System.out.println("Aluno encontrado");
                System.out.println("ID: " + resultado.getInt("id"));
                System.out.println("Nome: " + resultado.getString("nome"));
                System.out.println("Turma: " + resultado.getString("turma"));
                System.out.println("Email: " + resultado.getString("email"));
            } else {
                System.out.println("Aluno não encontrado");
            }

            resultado.close();
            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            System.out.println("Erro ao buscar aluno");
            System.out.println(erro.getMessage());
        }
        entrada.close();
    }
    
    public static void listarAlunos(){
        String sql = """
                     SELECT * FROM aluno
                     ORDER BY id
                     """;
        
        try {
            Connection conexao = conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            System.out.println();
            System.out.println("=============================");
            System.out.println("      ALUNOS CADASTRADOS");
            System.out.println("=============================");
            
            boolean encontrouAluno = false;
            
            while(resultado.next()){
                encontrouAluno = true;
                System.out.println("ID: " + resultado.getInt("id"));
                System.out.println("Nome: " + resultado.getString("nome"));
                System.out.println("Turma: " + resultado.getString("turma"));
                System.out.println("Email: " + resultado.getString("email"));
                System.out.println("==========================");
            }  
            
            if(encontrouAluno){
                System.out.println("Nenhum aluno cadastrado");
            }
            
            resultado.close();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            System.out.println("Erro ao buscar aluno");
            System.out.println(erro.getMessage());
    }
    }
}

