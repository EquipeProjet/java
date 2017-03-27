package negocio;


import excecoes.BancoDeDadosException;
import excecoes.LoginExistenteException;
import excecoes.NomeNuloException;
import excecoes.UsuarioInexistenteException;
import java.util.ArrayList;
import negocio.colecoes.CadastroClientes;
import negocio.colecoes.CadastroProduto;
import negocio.colecoes.CadastroUsuarios;
import negocio.colecoes.CadastroVendas;
import negocio.entidades.Cliente;
import negocio.entidades.Produto;
import negocio.entidades.Usuario;
import negocio.entidades.Venda;

/**
 * Classe que representa a fachada de acesso ao sistema
 * Ela deve ter como atributo todos as colecoes de negocio
 */
public class Fachada {
    
    private CadastroClientes clientes;
    private CadastroUsuarios usuarios;
    private CadastroProduto produtos;
    private CadastroVendas vendas;
    //No construtor da fachada o ideal e inicalizar todos os atributos
    public Fachada(){
        clientes = new CadastroClientes();
        usuarios = new CadastroUsuarios();
        produtos = new CadastroProduto();
        vendas = new CadastroVendas();
    }
   
    
    //vendas
    
    
    
    public void adicionarVenda(int i, String d, String nc, String np, double v, int q) throws BancoDeDadosException, NomeNuloException {
        
       vendas.adicionarVenda(i,d, nc, np, v, q);
    
    }
    
    
    public Venda lerVenda(String id)throws BancoDeDadosException, NomeNuloException{
        return vendas.lerVenda(id);
    }
     public ArrayList<Venda> listarVenda() 
            throws BancoDeDadosException, NomeNuloException{
        return vendas.listarProduto();
    }
    
    
    
    
    
    //Produto
    public void adicionarProduto(String n, double p, int q) throws BancoDeDadosException, NomeNuloException {
        
       produtos.adicionarProduto(n, p, q);
    
    }
    
   
    
   
        
    
    public void deletarProduto(int produto_id)throws BancoDeDadosException {
        produtos.deletarProduto(produto_id);
    }

    
    
    public void procurarProduto(String nome) throws BancoDeDadosException, NomeNuloException {
        produtos.procurarProduto(nome);

    }
    
    public void EditarProduto(int produto_id,String nome, Double preco, int quantidade) throws NomeNuloException, BancoDeDadosException{
          produtos.EditarProduto(produto_id, nome, preco, quantidade);
    }
   
    public Produto lerProduto(String id)throws BancoDeDadosException, NomeNuloException{
        return produtos.lerProduto(id);
    }
     public ArrayList<Produto> listarProduto() 
            throws BancoDeDadosException, NomeNuloException{
        return produtos.listarProduto();
    }
    
    
    //Cliente
    
    
   public void inserirCliente(String n, String c, String t,String e, String nu, String ce, String b) throws BancoDeDadosException, NomeNuloException {                       
        clientes.inserirCliente(n, c, t, e, nu, ce, b);
        
   }
   
   
        public void EditarCliente(int cliente_id, String nome, String cpf, String telefone, String endereco,String numero,String cep, String bairro) 
            throws BancoDeDadosException, NomeNuloException{
        
        clientes.EditarCliente(cliente_id,nome,cpf,telefone,endereco,numero,cep,bairro);
    
    }
        
       public ArrayList<Cliente> listarCliente() 
            throws BancoDeDadosException, NomeNuloException{
        return clientes.listarCliente();
    }  
    
       public Cliente lerCliente(String cliente_id)throws BancoDeDadosException, NomeNuloException{
        return clientes.lerCliente(cliente_id);
    }
    public void deletarCliente(int cliente_id) 
            throws BancoDeDadosException{
        clientes.deletarCliente(cliente_id);
    }
    /*
    public void inserirCliente(Cliente c) {                       
        clientes.inserirCliente(c);
    }*/
  
   
   
   //Usuario
    
      public void efetuarLogin(String l, String s)
      throws BancoDeDadosException, UsuarioInexistenteException{
        usuarios.efetuarLogin(l, s);
    }
    
      public ArrayList<Usuario> listarUsuario() throws BancoDeDadosException {
        return usuarios.listarUsuario();
    }
      public void adicionarUsuario(String l,String s) throws BancoDeDadosException, LoginExistenteException{
        
        usuarios.adicionarUsuario(l,s);
        
        
    }
      
      /*public ArrayList<Usuario> listarUsuario() 
            throws BancoDeDadosException{
        return usuarios.listarUsuario();
    }
      */
    
    public Usuario procurarUsuario(int id) throws 
            BancoDeDadosException{
        return usuarios.procurarUsuario(id);
    }
    
    public void alterarUsuario(int i, String l, String s) 
            throws BancoDeDadosException{
        usuarios.alterarUsuario(i, l, s);
    }
    
    public void deletarUsuario(int id) 
            throws BancoDeDadosException{
        usuarios.deletarUsuario(id);
    }
      
    public Usuario lerUsuario(String id) throws BancoDeDadosException{
        return usuarios.lerUsuario(id);
    }
    
    
      /*
     * Colocar as outras funcionalidades 
     */

    

    
    
}
