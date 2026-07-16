package Conexoes;


import Conexoes.Conexao;
import Funcionario.Professor;


public class TesteConexao {
    
        public static void main(String[] args) {
        Conexao.conectar();
        
        Professor.listarProfessor();
        }
}
