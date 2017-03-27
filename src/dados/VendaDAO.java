/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import excecoes.BancoDeDadosException;
import excecoes.NomeNuloException;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.entidades.Venda;

public class VendaDAO extends GenericDAO {

  public void adicionarVenda(Venda u) throws BancoDeDadosException {
        String query = "INSERT INTO venda (id,data,nomeCliente ,nomeProduto,valorVenda,quant)values(?,?,?,?,?,?)";
        PreparedStatement ps = prepareStatement(query);
            
        
        
        
        try {
            //pegando o login
            //ps.setString(1, u.getNome());
            //pegando a senha
            ps.setInt(1, u.getId());
            ps.setString(2, u.getData());
            ps.setString(3, u.getNomeCliente());
            ps.setString(4, u.getNomeProduto());
            ps.setDouble(5, u.getValorVenda());
            ps.setInt(6, u.getQuant());
          
            //executar o comando
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao inserir" + ex);
        }
    }//adicionar usuario
/*
    public Venda procurarVenda(int i) throws BancoDeDadosException, NomeNuloException {
        String query = "SELECT * FROM Venda WHERE id_venda=?";

        PreparedStatement ps = prepareStatement(query);

        try {
            //Substitui as interrogações 
            ps.setInt(1,i);
            
            //Faz a consulta no BD e retorna o conjunto
            ResultSet rs = ps.executeQuery();

            //se tem algum resultado 
            if (rs.next()) {
                
              Venda u = new Venda(
              rs.getInt("id"),
              //rs.getString("nome"),
              rs.getString("data"),
              rs.getString("nomeCliente"),
               rs.getString("nomeProduto")
                      rs.getDouble("valor_venda")
                              rs.getInt("quant")
                                    
              );
                return u;
            }
            //fechar as conexoes
            rs.close();
            
            ps.close();
            return null;
        } catch (SQLException ex) {
          throw new BancoDeDadosException("Erro ao procurar");
        }
           //Cliente u = udao.procurarCliente("lucas", "1234");
        }
    //Procurar Cliente */
    
    
public void deletarVenda(int id)throws BancoDeDadosException 
{ String query= ("DELETE FROM Venda WHERE ID = ?");
PreparedStatement ps = prepareStatement(query);
try{
    ps.setInt(1, id);
    ps.executeUpdate();
    ps.close();
  } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao Excluir");
}
} //Deletar Usuário
    
public void EditarVenda(String Nome, String Data,int Cliente_id, double valor_venda, int id)throws BancoDeDadosException 
{ String query= ("UPDATE VENDA SET  data = ?, Cliente_id=?, valot_venda=? WHERE id=?");
PreparedStatement ps = prepareStatement(query);
try{
    //ps.setString(1, Nome);
    ps.setString(1, Data);
    ps.setInt(2, Cliente_id);
    ps.setDouble(3, valor_venda);
    ps.setInt(4, id);
    ps.executeUpdate();
    ps.close();
  } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao Editar");
}
}


public Venda lerVenda(String id)throws BancoDeDadosException, NomeNuloException {
    String query = "SELECT * FROM Venda where id = ?";
     PreparedStatement ps = prepareStatement(query);
     
     try {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
            Venda u = new Venda(
                    rs.getString("data"),
                    rs.getString("nomeCliente"),
                    rs.getString("nomeProduto"),
                    Double.parseDouble(rs.getString("valorVenda")), 
                    Integer.parseInt(rs.getString("quant")));
            
            rs.close();
            ps.close();
            return u;
             }//if

            return null;

        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao procurar #ProdutoDAO " + ps);
        }
        
        

    }//ler usuario



public ArrayList<Venda> listarVenda() 
           throws BancoDeDadosException, NomeNuloException{
       
       String query = "SELECT * FROM Venda";
       //Criando a ps
       PreparedStatement ps = prepareStatement(query);
       
       ArrayList<Venda> lista = new ArrayList<Venda>();
       
        try {
            
            ResultSet rs = ps.executeQuery(query);
            
            while(rs.next()){
                
                Venda u = new Venda(
                        rs.getInt("id"),
                        rs.getString("data"),
                        rs.getString("nomeCliente"),
                        rs.getString("nomeProduto"),
                        rs.getDouble("valorVenda"),
                        rs.getInt("quant")
                );
                
                lista.add(u);
            }//while
            
            rs.close();
            ps.close();
            
            return lista;
            
        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao listar Produto");
        }
   }



public static void main(String[] args) throws BancoDeDadosException, NomeNuloException {
        VendaDAO udao = new VendaDAO();
        
         //Venda u = new Venda("2010-10-10", 1);
         //udao.adicionarVenda(u);

         
         //udao.EditarVenda("Deyvison","20,03,1999",1);

            //Venda u = udao.procurarVenda(1);
        
       // udao.deletarCliente(1);
            
        
        
        
    }
}






