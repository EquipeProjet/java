/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.*;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author Note
 */
public class ConectaBanco {
    
    public Statement stm;
    public ResultSet rs;
    private String driver = ("com.mysql.jdbc.Driver");
    private String caminho = ("jdbc:mysql://localhost:3306/sistemavideoaula");
    private String usuario = "aula1";
    private String senha = "asdf";
    //private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //private String caminho = "jdbc:sqlserver://localhost:1433;databaseName=sistemavideoaula;user=sa; password=123;";
    //private string usuario = "sa";
    //private String senha = "123";
    public Connection conn;
    
    public void conexao() {
        try {
            System.setProperty("jdbc.Driver",driver);
            conn = DriverManager.getConnection(caminho,usuario,senha);
          //  JOptionPane.showMessageDialog (null, "Conectado com Sucesso");
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro de Conexão!\n Erro:" + ex.getMessage());
    }
    }
    
    public void executaSQL(String sql){
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); //CONCUR_UPDATABLE CONCUR_READ_ONLY
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Executa sql!\n Erro:" + ex.getMessage());
        }
    }
    
    public void desconecta() {
        try {
            conn.close();
         //   JOptionPane.showMessageDialog (null, "Desconectado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão!\n Erro:" + ex.getMessage());
        }
    }
}