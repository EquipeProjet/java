package negocio.colecoes;


import dados.ClienteDAO;
import dados.RepositorioClientesLista;
import excecoes.BancoDeDadosException;
import excecoes.NomeNuloException;
import java.util.ArrayList;

import negocio.entidades.Cliente;

/**
 * Classe que representa a colecao de negocio do cliente
 */
public class CadastroClientes {

    private RepositorioClientesLista  cliente;

   /* public CadastroClientes() {
        cliente = new RepositorioClientesLista();
    }*/
    
    private ClienteDAO clientes;

    public CadastroClientes() {
        clientes = new ClienteDAO();
         cliente = new RepositorioClientesLista();
    }

    public void inserirCliente(String n, String c,String t, String e, String nu, String ce,  String b) throws BancoDeDadosException, NomeNuloException {
        

//se tiver alguma validacao de negocio pode fazer aqui
        //Repassando pra colecao de dados fazer a persistencia
        
        Cliente  a = new Cliente(n, c, t, e, nu, ce, b); 
        //manda cadastra no banco
       
        clientes.inserirCliente(a);

    }
    
    
    
    public ArrayList<Cliente> listarCliente() 
            throws BancoDeDadosException, NomeNuloException{
        return clientes.listarCliente();
    }
    
      

       
          
    public void EditarCliente(int cliente_id, String nome, String cpf, String telefone, String endereco,String numero,String cep, String bairro) 
            throws BancoDeDadosException, NomeNuloException{
        
        Cliente a = new Cliente(cliente_id, nome, cpf, telefone,endereco,numero,cep,bairro);
        
        clientes.EditarCliente(a);
    }
      
    
     public Cliente lerCliente(String cliente_id)throws BancoDeDadosException, NomeNuloException{
       return clientes.lerCliente(cliente_id);
    }
     
     
     public void deletarCliente(int cliente_id) 
            throws BancoDeDadosException{
        clientes.deletarCliente(cliente_id);
    }
   
    /*
    public void  procurarUsuario(String nome) throws BancoDeDadosException {
         Cliente a = new Cliente(nome);
    
         
    }
   public void deletarCliente(int cliente_id) throws BancoDeDadosException{
        Cliente a = new Cliente(cliente_id);
    }*/
   
   /*
    public void inserirCliente(Cliente c) {
        
        //se tiver alguma validacao de negocio pode fazer aqui
        //Repassando pra colecao de dados fazer a persistencia
        clientes.inserirCliente(c);

    }
    */
    /*
    * Fazer as outras funcionalidades
    */

}
