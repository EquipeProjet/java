package negocio.entidades;

import excecoes.NomeNuloException;

public class Produto {
    
    private int produto_id;
    
    private String nome;
    
    private double preco;
    
    private int quantidade;

    
    
    //private String pesquisa;
    
    public void setNome(String n) throws NomeNuloException{
        
        if(n == null){
            throw new NomeNuloException("Nome nulo!");
        }
        
        nome = n;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int id) {
        produto_id = id;
    }
    
    
    public String getNome() {
        return nome;
    }


    

    public double getPreco() {
        return preco;
    }

    public void setPreco(double p) {
        preco = p;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int q) {
       quantidade = q;
    }
    

     
    public Produto(int i, String n, double c, int q) throws NomeNuloException{
        setProduto_id(i);
        setNome(n);
        setPreco(c);
        setQuantidade(q);
    }
    public Produto(String n, double c, int q) throws NomeNuloException{
    setNome(n);
    setPreco(c);
    setQuantidade(q);
    }
    
    public Produto(String n) throws NomeNuloException{
    setNome(n);
     }

     public Produto(int i){
         setProduto_id(i);
     }
   
     public Produto(int qtde, int id){
        setQuantidade(qtde);
         setProduto_id(id);
     }
     
}

