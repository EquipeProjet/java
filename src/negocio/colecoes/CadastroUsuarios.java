
package negocio.colecoes;

import excecoes.BancoDeDadosException;
import dados.UsuarioDAO;
import excecoes.LoginExistenteException;
import excecoes.UsuarioInexistenteException;
import java.util.ArrayList;
import negocio.entidades.Usuario;

/**
 *
 * @author Warley
 */
public class CadastroUsuarios {
    
    private UsuarioDAO usuarios;
    
    public CadastroUsuarios(){
        usuarios = new UsuarioDAO();
    }
    
    public void efetuarLogin(String l, String s) throws BancoDeDadosException, UsuarioInexistenteException{
        
        //Lógica de negócio
        Usuario u = usuarios.procurarUsuario(l, s);
        
        //Não achou usuário ou senha
        if(u == null){
            throw new UsuarioInexistenteException("Usuário e/ou Senha inexistentes!");
        }
    }
    
    
    public void adicionarUsuario(String l, String s)throws BancoDeDadosException, LoginExistenteException {
        
        //validacao
        if(usuarios.procurarUsuario(l) != null){
            //lancar excecao
            throw new LoginExistenteException("Login existente!");
            
        }
        
        Usuario  u = new Usuario(l, s); 
        //manda cadastra no banco
        usuarios.adicionarUsuario(u);
        
    }//adicionarUsuario
    
    public ArrayList<Usuario> listarUsuario() 
            throws BancoDeDadosException{
        return usuarios.listarUsuario();
    }
    
    public Usuario procurarUsuario(int id) 
            throws BancoDeDadosException{
        return usuarios.procurarUsuario(id);
    }
    
    public void alterarUsuario(int i, String l, String s) 
            throws BancoDeDadosException{
        
        //validacao
        
        Usuario u = new Usuario(i, l, s);
        
        usuarios.alterarUsuario(u);
    }
    
    public void deletarUsuario(int id) 
            throws BancoDeDadosException{
        usuarios.deletarUsuario(id);
    }
    
    
    
    public Usuario lerUsuario(String id) throws BancoDeDadosException{
       
       
       return usuarios.lerUsuario(id);
        
        
    }//adicionarUsuario
    
     /*public ArrayList<Usuario> ListarUsuario() throws BancoDeDadosException{
        return usuarios.listarUsuario();
    }*/
}
