package negocio.entidades;


import excecoes.NomeNuloException;

public class Cliente {

    private int id;
    private String nome, cpf, telefone, endereco, numero, cep, bairro;

    
    public void setNome(String n) throws NomeNuloException {

        if (n == null) {
            throw new NomeNuloException("Nome nulo!");
        }

        nome = n;
    }

    public void setCpf(String c) {
      
        cpf = c;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCliente_id(int i) {
        id = i;
    }

    public int getCliente_id() {
        return id;
    }

    public void setTelefone(String t) {
        telefone = t;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setEndereco(String e) {
        endereco = e;
    }

    public String getEndereco() {
        return endereco;

    }

    public void setNumero(String nu) {
        numero = nu;
    }

    public String getNumero() {
        return numero;

    }

    public void setCep(String ce) {
        cep = ce;
    }

    public String getCep() {
        return cep;
    }

    public void setBairro(String b) {
        bairro = b;
    }

    public String getBairro() {
        return bairro;
    }
public Cliente(int i, String n, String c, String t, String e, String nu, String ce, String b) throws NomeNuloException{
        setCliente_id(i);
        setNome(n);
        setCpf(c);
        setTelefone(t);
        setEndereco(e);
        setNumero(nu);
        setCep(ce);
        setBairro(b);
    }

    public Cliente(String n, String c, String t, String e, String nu, String ce, String b) throws NomeNuloException{
        setNome(n);
        setCpf(c);
        setTelefone(t);
        setEndereco(e);
        setNumero(nu);
        setCep(ce);
        setBairro(b);
    }

    public Cliente(int i, String n, String c) throws NomeNuloException{
        setCliente_id(i);
        setNome(n);
        setCpf(c);
    }
    
    
}
