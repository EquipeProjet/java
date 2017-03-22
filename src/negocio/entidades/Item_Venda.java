package negocio.entidades;

import excecoes.NomeNuloException;

public class Item_Venda {
    
  private int id;
  
  private int produto_id;
  
  private int venda_id;
  
  private String nome;
    
  private int quant;
    
  private double PrecoUnitario;
  
  private double PrecoTotal;
  
    
   
    
    public void setNome(String n) throws NomeNuloException{
        
        if(n == null){
            throw new NomeNuloException("Nome nulo!");
        }
        
        nome = n;
    }
    
    public void setId(int i){
        id=i;
    }
     
     public int getId(){
     return id;
    }
     
     public void setProduto_id(int pi){
        id=pi;
    }
     
     public int getProduto_id(){
     return produto_id;
    }
     
     public void setVenda_id(int vi){
        id=vi;
    }
     
     public int getVenda_id(){
     return venda_id;
    }
     
     
    public void setQuant(int q){
        //lancar excecao
        quant = q;
    }
    
    public int getQuant(){
        return quant;
    }
    
   /* public String getNome(){
        return nome;
    }*/
    
    public void setPrecoUnitario(double p){
        PrecoUnitario = p;
    }
   
    
    public Double getPrecoUnitario(){
        return PrecoUnitario;
    }
    
    public void setPrecoTotal(double pt){
        PrecoUnitario = pt;
    }
   
    
    public Double getPrecoTotal(){
        return PrecoTotal;
    }
    
    
    public Item_Venda(int i, int q, double p, double pt, int pi, int vi) throws NomeNuloException{
        setId(i);
        //setNome(n);
        setQuant(q);
        setPrecoUnitario(p);
        setPrecoTotal(pt);
        setProduto_id(pi);
        setVenda_id(vi);
    }
    public Item_Venda (int q, double p, double pt, int pi, int vi) throws NomeNuloException{
    //setNome(n);
    setQuant(q);
    setPrecoUnitario(p);
    setPrecoTotal(pt);
    setProduto_id(pi);
    setVenda_id(vi);
        
    }
    
}

