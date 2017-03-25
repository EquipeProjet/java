/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dados.GenericDAO;
import excecoes.BancoDeDadosException;
import excecoes.NomeNuloException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocio.Fachada;
import negocio.entidades.Produto;

/**
 *
 * @author Klevson
 */
public class listarProduto extends javax.swing.JFrame {

     private Fachada fachada;
    
    /**
     * Creates new form JPanelListarUsuario2
     */
    public listarProduto() throws NomeNuloException {
        initComponents();
        fachada = new Fachada();
        
    try{
    ArrayList<Produto> lista = fachada.listarProduto();
    
    String[] colunas = {"produto_id","nome","preco","quantidade"};        
    
    Object[][] dados = carregarDados(lista);        
    
    DefaultTableModel model = new DefaultTableModel(dados, colunas);        
            
    jTable1.setModel(model);
    
     jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
     jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
     jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
     jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
     jTable1.setRowSelectionInterval(0, 0);
     
     
      jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
     
    } catch (BancoDeDadosException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
     }
      
         }
      
    
    private Object[][] carregarDados(ArrayList<Produto> lista) {
        Object[][] dados = new Object[lista.size()][4];

        for (int i = 0; i < lista.size(); i++) {
            dados[i][0] = lista.get(i).getProduto_id();
            dados[i][1] = lista.get(i).getNome();
            dados[i][2] = lista.get(i).getPreco();
            dados[i][3] = lista.get(i).getQuantidade();
        }
        return dados;
    }
    
    
    /*
     private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {
         setVisible(false);
     }
         private Object[][] carregarDados(ArrayList<Produto> lista) {
                 Object[][] dados = new Object[lista.size()][4];
         
         
      
      
         for (int i = 0; i < lista.size(); i++) {
            dados[i][0] = lista.get(i).getId_produto();
            dados[i][1] = lista.get(i).getNome();
            dados[i][2] = lista.get(i).getPreco();
            dados[i][3] = lista.get(i).getQuantidade();
         }
         return dados;
    
         }*/
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFielPreco = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFielQuant = new javax.swing.JTextField();
        jButtonDeletar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Produto");

        jLabelID.setText("Id:");

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("Preço:");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade:");

        jButtonDeletar.setText("Deletar");
        jButtonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabelID))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(10, 10, 10)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFielQuant, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jTextFielPreco))))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar))
                    .addComponent(jButtonDeletar))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelID)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFielPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFielQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEditar)
                            .addComponent(jButtonSalvar)
                            .addComponent(jButtonCancelar))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDeletar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        
        jLabelID.setText((jTable1.getValueAt(jTable1.getSelectedRow(),0)).toString());
         
        try {
            
            Produto ler = fachada.lerProduto(jLabelID.getText());

            jTextFieldNome.setText(ler.getNome());
            jTextFielPreco.setText (Double.toString(ler.getPreco()));
            jTextFielQuant.setText(Integer.toString(ler.getQuantidade()));
} 
        catch (BancoDeDadosException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NomeNuloException ex) {
             Logger.getLogger(listarProduto.class.getName()).log(Level.SEVERE, null, ex);
         }





// TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
              try{
                  int idvalida = Integer.parseInt(jLabelID.getText());
                  
                  fachada.EditarProduto(idvalida, jTextFieldNome.getText(),Double.parseDouble(jTextFielPreco.getText()), Integer.parseInt(jTextFielQuant.getText()));
                   JOptionPane.showMessageDialog(null, "Concluído com Sucesso!","Mensagem",0);
              
                 ArrayList<Produto> lista = fachada.listarProduto();
    
                 String[] colunas = {"id_produto","nome","preço","quantidade"};        
    
                 Object[][] dados = carregarDados(lista);        
    
                DefaultTableModel model = new DefaultTableModel(dados, colunas);        
            
                jTable1.setModel(model);
                jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
                jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
                jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
                jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
                jTable1.setRowSelectionInterval(0, 0);
     
                jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
                   
                   
              
              }catch (NomeNuloException ex) {
             Logger.getLogger(listarProduto.class.getName()).log(Level.SEVERE, null, ex);
         } catch (BancoDeDadosException ex) {
             Logger.getLogger(listarProduto.class.getName()).log(Level.SEVERE, null, ex);
         }
           jTextFieldNome.setText("");
           jTextFielPreco.setText("");
           jTextFielQuant.setText("");
         //LIMPAR CAMPOS
           //jTextFieldNome.setText("");
           //jTextFielPreco.setText("");
           //jTextFielQuant.setText("");
           
         // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
         setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarActionPerformed
        jLabelID.setText((jTable1.getValueAt(jTable1.getSelectedRow(),0)).toString());

        try {

            Produto ler = fachada.lerProduto(jLabelID.getText());

        }
        catch (BancoDeDadosException ex) {
            JOptionPane.showMessageDialog(this,
                ex.getMessage(), "Erro",
                JOptionPane.ERROR_MESSAGE);
        } catch (NomeNuloException ex) {
            Logger.getLogger(listarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

        try{
            int idvalida = Integer.parseInt(jLabelID.getText());

            fachada.deletarProduto(idvalida);
            JOptionPane.showMessageDialog(null, "Concluído com Sucesso!","Mensagem",0);

            ArrayList<Produto> lista = fachada.listarProduto();

            String[] colunas = {"id_produto","nome","preço","quantidade"};

            Object[][] dados = carregarDados(lista);

            DefaultTableModel model = new DefaultTableModel(dados, colunas);

            jTable1.setModel(model);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTable1.setRowSelectionInterval(0, 0);

            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        }catch (NomeNuloException ex) {
            Logger.getLogger(listarProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BancoDeDadosException ex) {
            Logger.getLogger(listarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDeletarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(listarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new listarProduto().setVisible(true);
                } catch (NomeNuloException ex) {
                    Logger.getLogger(listarProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFielPreco;
    private javax.swing.JTextField jTextFielQuant;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
