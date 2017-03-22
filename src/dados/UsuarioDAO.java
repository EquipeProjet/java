package dados;

import excecoes.BancoDeDadosException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import negocio.entidades.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO extends GenericDAO {

    private Usuario u;
    
    public void adicionarUsuario(Usuario u) throws BancoDeDadosException {

        String query = "INSERT INTO Usuario (login, senha)values(?,?)";
        PreparedStatement ps = prepareStatement(query);

        try {
            //pegando o login
            ps.setString(1, u.getLogin());

            //pegando a senha
            ps.setString(2, u.getSenha());

            //executar o comando
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao inserir" + ex);
        }
    }//adicionar usuario

    /*public Usuario procurarUsuario(String login, String senha) throws BancoDeDadosException {
        String query = "SELECT * FROM usuario WHERE login=? AND senha=? ";

        PreparedStatement ps = prepareStatement(query);

        try {
            //Substitui as interrogações 
            ps.setString(1, login);
            ps.setString(2, senha);
            //Faz a consulta no BD e retorna o conjunto
            ResultSet rs = ps.executeQuery();

            //se tem algum resultado 
            if (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("senha"));

                return u;
            }
            //fechar as conexoes
            rs.close();
            ps.close();
            return null;
        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao procurar");

        }
    }

    
    public Usuario procurarUsuario(String login) throws BancoDeDadosException{
        
        String query = "SELECT * from usuario where login = ?";
        
        //Criando a ps
        PreparedStatement ps = prepareStatement(query);
        
        try{
            //Substitui as interrogações
            ps.setString(1, login);
            
            
            //Faz a consulta do BD e retorna o conjunto
            ResultSet rs = ps.executeQuery();
            
            //Se tem algum resultado
            if(rs.next()){
                Usuario u = new Usuario(
                    rs.getInt("Id"),
                    rs.getString("Login"),
                    rs.getString("Senha"));
            }
            
            //Fechar as conexões
            rs.close();
            
            return u;
            
        }catch (SQLException ex){
            throw new BancoDeDadosException("Erro ao procurar.");
        }
    }
    */
    
    
    
    
    
    
    public void alterarUsuario(Usuario u) 
            throws BancoDeDadosException{
        
        String query = "UPDATE usuario SET login=?, senha=? WHERE id=?";
        PreparedStatement ps = prepareStatement(query);
        
        try{
            //pegando o login
            ps.setString(1, u.getLogin());
            
            //pegando a senha
            ps.setString(2, u.getSenha());
            
            //pegando id
            ps.setInt(3, u.getId());
            
            //executar o comando
            ps.executeUpdate();
            
        }catch(SQLException ex){
            throw new BancoDeDadosException("Erro ao alterar");
        }
    }//adicionar usuario
    
    
    public Usuario lerUsuario(String id) throws BancoDeDadosException {
        
            //String query = "Select * From usuario";
            String query = "SELECT * FROM usuario where id = ?";
        //criando a ps
        PreparedStatement ps = prepareStatement(query);

        try {
            ps.setString(1, id);

            //substitui as interrrogações
            ResultSet rs = ps.executeQuery();

            //se tem algum resultado
            if (rs.next()) {
                //Usuario u = new Usuario(rs.getInt("id"),rs.getString("cadastro"), rs.getString("nome"));
                Usuario u = new Usuario(rs.getString("login"), rs.getString("senha"));

                //fechar as conexoes
                rs.close();
                ps.close();
                return u;
                
            }//if

            return null;

        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao procurar #UsuarioDAO " + ps);
        }
        
        

    }//ler usuario
    
    
    public void deletarUsuario(int id) 
            throws BancoDeDadosException{
        
        String query = "DELETE FROM usuario WHERE id=?";
        PreparedStatement ps = prepareStatement(query);
        
        try{
                        
            //pegando id
            ps.setInt(1, id);
            
            //executar o comando
            ps.executeUpdate();
            
        }catch(SQLException ex){
            throw new BancoDeDadosException("Erro ao deletar");
        }
    }//adicionar usuario
    

    
    
    
    
    public Usuario procurarUsuario(String login, String senha) throws BancoDeDadosException{
        
        String query = "SELECT * FROM usuario WHERE login=? AND senha=? ";
        
        //Criando a ps
        PreparedStatement ps = prepareStatement(query);
        
        try{
            //substitui as interrogacoes
            ps.setString(1, login);
            ps.setString(2, senha);
            
            //Faz a consulta no BD e retorna o conjunto
            ResultSet rs = ps.executeQuery();
            
            //se tem algum resultado
            if(rs.next()){
                Usuario u = new Usuario(
                  rs.getInt("id"), 
                  rs.getString("login"),
                  rs.getString("senha"));                
                //fechar as conexoes
                rs.close();
                ps.close();                
                return u;
            }//if            
            return null;            
        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao procurar");
        }
        
    }
    
    public Usuario procurarUsuario(String login) throws BancoDeDadosException{
        
        String query = "SELECT * FROM usuario WHERE login=? ";
        
        //Criando a ps
        PreparedStatement ps = prepareStatement(query);
        
        try{
            //substitui as interrogacoes
            ps.setString(1, login);           
            
            //Faz a consulta no BD e retorna o conjunto
            ResultSet rs = ps.executeQuery();
            
            //se tem algum resultado
            if(rs.next()){
                Usuario u = new Usuario(
                        rs.getInt("id"), 
                        rs.getString("login"),
                        rs.getString("senha"));                
                //fechar as conexoes
                rs.close();
                ps.close();                
                return u;
            }//if            
            return null;            
        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao procurar");
        }
        
    }
    
    public Usuario procurarUsuario(int id) throws BancoDeDadosException{
        
        String query = "SELECT * FROM usuario WHERE id=? ";
        
        //Criando a ps
        PreparedStatement ps = prepareStatement(query);
        
        try{
            //substitui as interrogacoes
            ps.setInt(1, id);           
            
            //Faz a consulta no BD e retorna o conjunto
            ResultSet rs = ps.executeQuery();
            
            //se tem algum resultado
            if(rs.next()){
                Usuario u = new Usuario(
                        rs.getInt("id"), 
                        rs.getString("login"), 
                        rs.getString("senha"));                
                //fechar as conexoes
                rs.close();
                ps.close();                
                return u;
            }//if            
            return null;            
        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao procurar");
        }
        
    }
    
   public static void main(String[] args) throws BancoDeDadosException{
       UsuarioDAO udao = new UsuarioDAO();
       
       //Usuario u = new Usuario("admin2", "1234");       
       //udao.adicionarUsuario(u);
       
       Usuario u = udao.procurarUsuario("teste", "teste");
       if(u != null){
            System.out.println(u.getId());
       }
   }
   
   
   public ArrayList<Usuario> listarUsuario() 
           throws BancoDeDadosException{
       
       String query = "SELECT * FROM usuario";
       //Criando a ps
       PreparedStatement ps = prepareStatement(query);
       
       ArrayList<Usuario> lista = new ArrayList<Usuario>();
       
        try {
            
            ResultSet rs = ps.executeQuery(query);
            
            while(rs.next()){
                
                Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("senha")
                );
                
                lista.add(u);
            }//while
            
            rs.close();
            ps.close();
            
            return lista;
            
        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao listar usuarios");
        }
   }
    
    
    
    
    
    
    
    
    
    
    
    /*
    
    public static void main(String[] args) throws BancoDeDadosException {
        UsuarioDAO udao = new UsuarioDAO();
        
         Usuario u = new Usuario("Deyvison", "123");
         udao.adicionarUsuario(u);

         //Usuario u = udao.procurarUsuario("klev", "123");
            
        
       // if (u != null) {
         //   System.out.println(u.getId());
       // }
    }*/
    
    
    
    
}
