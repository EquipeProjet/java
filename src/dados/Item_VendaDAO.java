/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author DEYVISON
 */
import excecoes.BancoDeDadosException;
import excecoes.NomeNuloException;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.entidades.Item_Venda;
import negocio.entidades.Venda;
//import negocio.entidades.Venda;

public class Item_VendaDAO extends GenericDAO {

    public void adicionarItem_Venda (Item_Venda u) throws BancoDeDadosException {
        String query = "INSERT INTO Item_Venda ( Quant, PrecoUnitario, PrecoTotal, Produto_id, Venda_id, )values(?,?,?,?,?)";
        PreparedStatement ps = prepareStatement(query);

        try {
            //pegando o login
            
            //pegando a senha
            //ps.setInt(1, u.getId());
            
            ps.setInt(1, u.getQuant());
            
            ps.setDouble(2, u.getPrecoUnitario());
            
            ps.setDouble(3, u.getPrecoTotal());
            
            ps.setInt(4, u.getProduto_id());
            
            ps.setInt(5, u.getVenda_id());
            
            
            
            //executar o comando
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao inserir" + ex);
        }
    }//adicionar usuario

    public Item_Venda procurarItem_Venda(int i) throws BancoDeDadosException, NomeNuloException {
        String query = "SELECT * FROM Item_Venda WHERE id_item_venda=?";

        PreparedStatement ps = prepareStatement(query);

        try {
            //Substitui as interrogações 
            ps.setInt(1,1);
            
            //Faz a consulta no BD e retorna o conjunto
            ResultSet rs = ps.executeQuery();

            //se tem algum resultado 
            if (rs.next()) {
                
              Item_Venda u = new Item_Venda(
              rs.getInt("id_item_venda"),
              //rs.getString("nome"),
              rs.getInt("quant"),
              rs.getDouble("PrecoUnitario"),
              rs.getDouble("PrecoTotal"),
              rs.getInt("produto_id"),
              rs.getInt("venda_id")
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
    //Procurar Cliente 
    
public void deletarItem_Venda(int id)throws BancoDeDadosException 
{ String query= ("DELETE FROM Item_Venda WHERE ID_Item_Venda = ?");
PreparedStatement ps = prepareStatement(query);
try{
    ps.setInt(1, id);
    ps.executeUpdate();
    ps.close();
  } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao Excluir");
}
} //Deletar Usuário
    
public void EditarItem_Venda( int quant, double PrecoUnitario, double PrecoTotal, int produto_id, int venda_id, int id)throws BancoDeDadosException 
{ String query= ("UPDATE Item_Venda SET  quant = ?, PrecoUnitario =?, PrecoTotal=?, produto_id=?, venda_id=? WHERE id=?");
PreparedStatement ps = prepareStatement(query);
try{
    
    ps.setInt(1, quant);
    ps.setDouble(2, PrecoUnitario);
    ps.setDouble(3, PrecoTotal);
    ps.setInt(4, produto_id);
    ps.setInt(5, venda_id);
    ps.setInt(6, id);
    ps.executeUpdate();
    ps.close();
  } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao Editar");
}
}

public static void main(String[] args) throws BancoDeDadosException, NomeNuloException {
       Item_VendaDAO udao = new Item_VendaDAO();
        
        // Item_Venda u = new Item_Venda(2,12.45,25.45,1, 1);
        // udao.adicionarItem_Venda(u);

         
         //udao.EditarVenda("Deyvison","20,03,1999",1);

        //Item_Venda u = udao.procurarItem_Venda(1);
        
       // udao.deletarCliente(1);
            
        
        
        
    }
}

