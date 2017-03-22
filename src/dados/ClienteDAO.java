/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import dados.GenericDAO;
import excecoes.BancoDeDadosException;

import excecoes.NomeNuloException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import negocio.entidades.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDAO extends GenericDAO {

    public void inserirCliente(Cliente a) throws BancoDeDadosException {
        String query = "INSERT INTO Cliente (nome, cpf, telefone, endereco, numero, cep,  bairro)values(?,?,?,?,?,?,?)";
        PreparedStatement ps = prepareStatement(query);
        //String querySelect = "SELECT cpf FROM Cliente WHERE cpf = ?";
        //PreparedStatement psSelect = prepareStatement(querySelect);
        try {
            
            //psSelect.setString(1, a.getCpf());
            //ResultSet rs = psSelect.executeQuery();
            
                //JOptionPane.showMessageDialog(null, rs.getString("cpf"));
            
            //pegando o login
            ps.setString(1, a.getNome());

            //pegando a senha
            ps.setString(2, a.getCpf());
            ps.setString(3, a.getTelefone());
            ps.setString(4, a.getEndereco());

            ps.setString(5, a.getNumero());

            ps.setString(6, a.getCep());

            ps.setString(7, a.getBairro());
//executar o comando
            ps.executeUpdate();

            ps.close();
        
            
        
        } catch (SQLException ex) {
            throw new BancoDeDadosException(ex.getMessage());
        }
    }//adicionar usuario

   
    public Cliente lerCliente(String cliente_id)throws BancoDeDadosException, NomeNuloException {
    String query = "SELECT * FROM Cliente where cliente_id = ?";
     PreparedStatement ps = prepareStatement(query);
     
     try {
            ps.setString(1, cliente_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
            Cliente u = new Cliente(rs.getString("nome"), rs.getString("cpf"),rs.getString("telefone"),rs.getString("endereco"),rs.getString("numero"),rs.getString("cep"),rs.getString("bairro"));
            
            rs.close();
            ps.close();
            return u;
             }//if

            return null;

        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao procurar #ClienteDAO " + ps);
        }
        
        

    }//ler usuario
    
    
    
    public ArrayList <Cliente> listarCliente() 
           throws BancoDeDadosException, NomeNuloException{
       
       String query = "SELECT * FROM Cliente";
       //Criando a ps
       PreparedStatement ps = prepareStatement(query);
       
       ArrayList<Cliente> lista = new ArrayList<Cliente>();
       
        try {
            
            ResultSet rs = ps.executeQuery(query);
            
            while(rs.next()){
                
                Cliente u = new Cliente(
                        rs.getInt("cliente_id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("endereco"),
                        rs.getString("numero"),
                        rs.getString("cep"),
                        rs.getString("bairro")
                );
                
                lista.add(u);
            }//while
            
            rs.close();
            ps.close();
            
            return lista;
            
        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao listar Clientes");
     }}
     
    
    
    
    
    
    public Cliente procurarCliente(String nome, String cpf) throws BancoDeDadosException, NomeNuloException {
        String query = "SELECT * FROM Cliente WHERE nome=? AND cpf=? ";

        PreparedStatement ps = prepareStatement(query);

        try {
            //Substitui as interrogações 
            ps.setString(1, nome);
            ps.setString(2, cpf);

            //Faz a consulta no BD e retorna o conjunto
            ResultSet rs = ps.executeQuery();

            //se tem algum resultado 
            if (rs.next()) {

                Cliente u = new Cliente(
                        rs.getInt("cliente_id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("endereco"),
                        rs.getString("numero"),
                        rs.getString("cep"),
                        rs.getString("bairro"));

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

    public void deletarCliente(Cliente cliente) throws BancoDeDadosException {
        String query = ("DELETE FROM Cliente WHERE cliente_id = ?");
        PreparedStatement ps = prepareStatement(query);
        try {
            ps.setInt(1, cliente.getCliente_id());
            ps.executeUpdate();
           
            ps.close();
        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao Excluir");
        }
    } //Deletar Usuário

    public void EditarCliente(Cliente cliente) throws BancoDeDadosException {
        String query = "UPDATE Cliente SET nome =? , cpf = ?, telefone = ?, endereco = ?, numero = ?, cep = ?,  bairro = ?  WHERE cliente_id=?";
        PreparedStatement ps = prepareStatement(query);
        try {
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getEndereco());
            ps.setString(5, cliente.getNumero());
            ps.setString(6, cliente.getCep());
            ps.setString(7, cliente.getBairro());
            ps.setInt(8, cliente.getCliente_id());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao Editar");
        }
    }

    
    
    
    
    
    
    public Cliente procurarUsuario(String nome) throws BancoDeDadosException, NomeNuloException{
        
        String query = "SELECT * FROM usuario WHERE nome=? ";
        
        //Criando a ps
        PreparedStatement ps = prepareStatement(query);
        
        try{
            //substitui as interrogacoes
            ps.setString(1, nome);           
            
            //Faz a consulta no BD e retorna o conjunto
            ResultSet rs = ps.executeQuery();
            
            //se tem algum resultado
            if(rs.next()){
                Cliente u = new Cliente (
                        rs.getInt("cliente_id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("endereco"),
                        rs.getString("numero"),
                        rs.getString("cep"),
                        rs.getString("bairro"));                
                //fechar as conexoes
                rs.close();
                ps.close();                
                return u;
            }//if            
            return null;            
        } catch (SQLException ex) {
            throw new BancoDeDadosException("Erro ao procurar");
        }
        
    }
    
   // public static void main(String[] args) throws BancoDeDadosException, NomeNuloException {
       // ClienteDAO udao = new ClienteDAO();

        //Cliente u = new Cliente("João", "001245278-45");
        //udao.adicionarCliente(u);
        //udao.EditarCliente("Deyvison","14523698774",1);
        //Cliente u = udao.procurarCliente("klev", "123");
        // udao.deletarCliente(1);
   // }
}
