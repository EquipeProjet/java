/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.colecoes;

import dados.ProdutoDAO;
import excecoes.BancoDeDadosException;
import excecoes.NomeNuloException;
import java.util.ArrayList;
import negocio.entidades.Produto;

/**
 *
 * @author DEYVISON
 */
public class CadastroProduto {
    
    private ProdutoDAO produtos;
    
    public CadastroProduto() {
    produtos = new ProdutoDAO();
    
  }
    
    public void adicionarProduto(String n, double p, int q) throws BancoDeDadosException, NomeNuloException{
        
        Produto a = new Produto(n,p,q);
        
        produtos.adicionarProduto(a);
        
    }
    
    public void procurarProduto(String nome) throws BancoDeDadosException, NomeNuloException {
         Produto a = new Produto(nome);
    }
    
    public void deletarProduto(int produto_id) throws BancoDeDadosException{
        Produto a = new Produto(produto_id);
    }

       public ArrayList<Produto> listarProduto() 
            throws BancoDeDadosException, NomeNuloException{
        return produtos.listarProduto();
    }
         
    public void EditarProduto(int produto_id, String nome, Double preco, int quantidade) throws NomeNuloException, BancoDeDadosException{
         Produto a = new Produto(produto_id, nome, preco, quantidade);
         produtos.EditarProduto(a);
    
    
    }
    
    public Produto lerProduto(String id) throws BancoDeDadosException, NomeNuloException{
         return produtos.lerProduto(id);}
    
    /*
    * Fazer as outras funcionalidades
    */
}
