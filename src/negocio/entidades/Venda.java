package negocio.entidades;

import excecoes.NomeNuloException;


public class Venda {
    
    private int id;
     private  String data;
    private String nomeCliente;
    private String nomeProduto;
   
    private double valorVenda;
    private int quant;

   

     public void setNomeCliente(String nc) throws NomeNuloException {

        if (nc == null) {
            throw new NomeNuloException("Nome nulo!");
        }

        nomeCliente = nc;
        
        
    }
     
     public String getNomeCliente() {
        return nomeCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        id = i;
    }

    public String getData() {
        return data;
    }

    public void setData(String d) {
        data = d;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String np) {
        nomeProduto = np;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double v) {
        valorVenda = v;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int q) {
        quant = q;
    }
    
    

     
     public Venda (int i, String d, String nc, String np, double v, int q) throws NomeNuloException{
        setId(i);
        setData(d);
        setNomeCliente(nc);
        setNomeProduto(np);
        
        setValorVenda(v);
        setQuant(q);
        
   }
    public Venda(String d, String nc, String np,  double v, int q) throws NomeNuloException{
    //setNome(n);
    //setId(i);
        //setNome(n);
        setData(d);
        setNomeCliente(nc);
        setNomeProduto(np);
        
        setValorVenda(v);
        setQuant(q);
    }
/*
    public Venda(String nc, String np,  double v, int q) {
        this.nomeCliente = nomeCliente;
        this.nomeProduto = nomeProduto;
        this.data = data;
        this.valor_venda = valor_venda;
        this.quant = quant;
    }

    public Venda(int id, String nomeCliente, String nomeProduto, String data, double valor_venda, int quant) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.nomeProduto = nomeProduto;
        this.data = data;
        this.valor_venda = valor_venda;
        this.quant = quant;
    }*/

    
}