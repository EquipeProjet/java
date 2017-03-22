package dados;

import java.util.ArrayList;
import negocio.entidades.Cliente;

public class RepositorioClientesLista {
    
    private ArrayList<Cliente> clientes;
    
    public RepositorioClientesLista(){
        clientes = new ArrayList<Cliente>();
    }

    public void inserirCliente(Cliente c) {
        
        //se tiver alguma validacao na parte de dados pode fazer aqui
        
        //inserindo na lista
        clientes.add(c);               
        
    }
    
    public void procurarCliente(Cliente c) {
        
        //se tiver alguma validacao na parte de dados pode fazer aqui
        
        //inserindo na lista
        clientes.add(c);       
    }
    /*
    * Fazer as outras funcionalidades
    * Pesquisar mais o que pode ser feito com a classe ArrayList
    * Olhar na documentação da classe disponivel na internet
    */
    
    public void deletarCliente(Cliente c) {
        
        //se tiver alguma validacao na parte de dados pode fazer aqui
        
        //inserindo na lista
        clientes.add(c);       
    }
    
    
    public void EditarCliente(Cliente c) {
        
        //se tiver alguma validacao na parte de dados pode fazer aqui
        
        //inserindo na lista
        clientes.add(c);       
    }
    
    public void listarCliente(Cliente c) {
        
        //se tiver alguma validacao na parte de dados pode fazer aqui
        
        //inserindo na lista
        clientes.add(c);       
    }
    
    
    public void lerCliente(Cliente c) {
        
        //se tiver alguma validacao na parte de dados pode fazer aqui
        
        //inserindo na lista
        clientes.add(c);  
        
    }
}
