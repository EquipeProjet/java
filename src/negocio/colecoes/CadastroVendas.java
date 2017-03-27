/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.colecoes;

import dados.VendaDAO;
import excecoes.BancoDeDadosException;
import excecoes.NomeNuloException;
import java.util.ArrayList;
import negocio.entidades.Venda;

/**
 *
 * @author DEYVISON
 */
public class CadastroVendas {
    private VendaDAO vendas;
    
    public CadastroVendas() {
    vendas = new VendaDAO();
    
  }
    
   public void adicionarVenda(int i, String d, String nc,String np, double v, int q) throws BancoDeDadosException, NomeNuloException {
        
        
        Venda  a = new Venda(i, d, nc, np, v, q); 
        //manda cadastra no banco
       
        vendas.adicionarVenda(a);
    }
    
    
     public ArrayList<Venda> listarProduto() 
            throws BancoDeDadosException, NomeNuloException{
        return vendas.listarVenda();
    }
     
     
     public Venda lerVenda(String id) throws BancoDeDadosException, NomeNuloException{
         return vendas.lerVenda(id);}
    
    
    
}
