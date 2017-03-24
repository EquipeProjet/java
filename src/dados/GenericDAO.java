package dados;

import excecoes.BancoDeDadosException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public  class GenericDAO {
    public Statement stm;
    public ResultSet rs;
    private final String Driver = "com.mysql.jdbc.Driver";
    private final String BD = "aula";
    private final String Conexao = "jdbc:mysql://localhost:3306/"+BD;
    private final String Usuario = "aula1";
    private final String senha = "asdf";
    public Connection conn;
    public Connection getConnection()throws BancoDeDadosException{
        
        try {
            //carregar o driver
            Class.forName(Driver);
            
            //pegando a conexao com o bd
            
            Connection cx = DriverManager.getConnection(Conexao,Usuario,senha);
            
            //retornando a conexao
            return cx;
            
        } catch (ClassNotFoundException ex) {
           throw new BancoDeDadosException("Erro ao ler o driver mysql");
        }catch (SQLException ex){
            throw new BancoDeDadosException("Erro ao conectar o mysql"+ex);
        }
        
    }//getConnection
    
    
     public void executaSQL(String sql){
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); //CONCUR_UPDATABLE CONCUR_READ_ONLY
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Executa sql!\n Erro:" + ex.getMessage());
        }
    }
    
    public PreparedStatement prepareStatement(String query) throws BancoDeDadosException
    {
        try {
            return getConnection().prepareStatement(query);
        }catch(SQLException ex){
                    throw new BancoDeDadosException("Erro no Statement");
             }
    }
    
}
   /*public static void main(String[] args) throws BancoDeDadosException{
        GenericDAO gd = new GenericDAO();
        gd.getConnection();
    }*/






