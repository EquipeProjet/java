/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import dados.GenericDAO;
import excecoes.BancoDeDadosException;
import excecoes.BancoDeDadosException;
import excecoes.NomeNuloException;
import excecoes.NomeNuloException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.entidades.Produto;

public class ProdutoDAO extends GenericDAO   {

    public void adicionarProduto(Produto u) throws BancoDeDadosException {
        String query = "INSERT INTO Produto (nome,preco,quantidade)values(?,?, ?)";
        PreparedStatement ps = prepareStatement(query);

        try {
            //pegando o login
            ps.setString(1, u.getNome());
            //pegando a senha
            ps.setDouble(2,u.getPreco());
            ps.setInt(3,u.getQuantidade());
            //executar o comando
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao inserir" + ex);
        }
    }//adicionar usuario

    public Produto procurarProduto(String nome, double preco) throws BancoDeDadosException, NomeNuloException {
        String query = "SELECT * FROM Produto WHERE nome=? AND preco=? ";

        PreparedStatement ps = prepareStatement(query);

        try {
            //Substitui as interrogações 
            ps.setString(1, nome);
            ps.setDouble(2, preco);
            //Faz a consulta no BD e retorna o conjunto
            ResultSet rs = ps.executeQuery();

            //se tem algum resultado 
            if (rs.next()) {
                
                Produto u = new Produto(
                        rs.getInt("produto_id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade")
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
    
public void deletarProduto(int produto_id )throws BancoDeDadosException 
{ String query= ("DELETE FROM Produto WHERE produto_id = ?");
PreparedStatement ps = prepareStatement(query);
try{
    ps.setInt(1, produto_id);
    ps.executeUpdate();
   // ps.close();
  } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao Excluir");
}
} //Deletar Usuário
    
/*public void EditarProduto(String Nome, Double Preco, int Quantidade,int id_produto)throws BancoDeDadosException 
{ String query= ("UPDATE Produto SET NOME =? , Preco = ?, Quantidade = ? WHERE id_produto=?");
PreparedStatement ps = prepareStatement(query);
try{
    ps.setString(1, Nome);
    ps.setDouble(2, Preco);
    ps.setInt(3, Quantidade);
    ps.setInt(4, id_produto);
    ps.executeUpdate();
    ps.close();
  } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao Editar");
}*/


public Produto lerProduto(String id)throws BancoDeDadosException, NomeNuloException {
    String query = "SELECT * FROM Produto where produto_id = ?";
     PreparedStatement ps = prepareStatement(query);
     
     try {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
            Produto u = new Produto(rs.getString("nome"), Double.parseDouble(rs.getString("preco")), Integer.parseInt(rs.getString("quantidade")));
            
            rs.close();
            ps.close();
            return u;
             }//if

            return null;

        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao procurar #ProdutoDAO " + ps);
        }
        
        

    }//ler usuario



public void EditarProduto(Produto produto)throws BancoDeDadosException 
{ 
String query = ("UPDATE Produto SET nome =?, preco = ?, quantidade=? WHERE produto_id=?");
PreparedStatement ps = prepareStatement(query);
try{
    
    
   
    
    ps.setString(1, produto.getNome());
            //pegando a senha
    ps.setDouble(2,produto.getPreco());
    
    ps.setInt(3, produto.getQuantidade());
    
    ps.setInt(4, produto.getProduto_id());
    
    ps.executeUpdate();
    ps.close();
  } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao Editar");
}

}
   public ArrayList<Produto> listarProduto() 
           throws BancoDeDadosException, NomeNuloException{
       
       String query = "SELECT * FROM Produto";
       //Criando a ps
       PreparedStatement ps = prepareStatement(query);
       
       ArrayList<Produto> lista = new ArrayList<Produto>();
       
        try {
            
            ResultSet rs = ps.executeQuery(query);
            
            while(rs.next()){
                
                Produto u = new Produto(
                        rs.getInt("produto_id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade")
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

}





//public static void main(String[] args) throws BancoDeDadosException, NomeNuloException {
    
    
      ///ProdutoDAO udao = new ProdutoDAO();
        
      //Produto u = new Produto("Arroz", 47.50);
      
      //udao.adicionarProduto(u); //Adiciona os produtos na tabela 
      
      //udao.EditarProduto("OTAKU",23.88, 1);
        
          //udao.procurarProduto("OTAKU",1);
      
      //udao.deletarProduto(15);
    //}







