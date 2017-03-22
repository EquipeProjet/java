package negocio.entidades;

public class Usuario {    
    private int id;
    private String login;
    private String senha;
    
    /**
     * @return the id
     */
    
    public int getId(){
        return id;
    }
    
    public String getLogin(){
        return login;
    }
    
    /**
     *
     * @return
     */
    public String getSenha(){
        return senha;
    }
    
    public void setId(int i){
        id=i;
    }
    
    public void setLogin(String l){
        login = l;}
        
    public void setSenha(String s){
        senha = s;
    }
        
   public Usuario(int i, String l,String s){
        setId(i);
        setLogin(l);
        setSenha(s);
    }
public Usuario(String l,String s){
    setLogin(l);
    setSenha(s);}
}
