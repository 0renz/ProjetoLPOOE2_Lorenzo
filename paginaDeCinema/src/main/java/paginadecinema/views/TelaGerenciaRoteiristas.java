/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package paginadecinema.views;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import paginadecinema.modelo.Filmes;
import paginadecinema.modelo.Roteiristas;
import paginadecinema.modelo.dao.PersistenciaJPA;

/**
 *
 * @author loren
 */
public class TelaGerenciaRoteiristas extends javax.swing.JDialog {

    public TelaGerenciaRoteiristas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        listarRoteiristas();
    }

    PersistenciaJPA persistencia;

    private void listarRoteiristas() {
        try {
            persistencia = new PersistenciaJPA();
            lstRoteiristas.clearSelection();
            persistencia.conexaoAberta();
            List<Roteiristas> roteiristas = persistencia.getRoteiristas();
            DefaultListModel modeloLista = new DefaultListModel<>();
            for (Roteiristas roteirista : roteiristas) {
                modeloLista.addElement(roteirista);
            }
            lstRoteiristas.setModel(modeloLista);
            persistencia.fecharConexao();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao listar modalidades: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRoteiristas = new javax.swing.JList<>();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        jLabel1.setText("Gerenciar Roteiristas");

        jScrollPane1.setViewportView(lstRoteiristas);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.setToolTipText("");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            Roteiristas r = new Roteiristas();
            r.setNomeRoteirista(JOptionPane.showInputDialog("Informe o nome do roteirista: "));
            persistencia = new PersistenciaJPA();
            persistencia.conexaoAberta();
            persistencia.persist(r);
            listarRoteiristas();
        } catch (Exception ex) {
            Logger.getLogger(TelaGerenciaRoteiristas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed

        Roteiristas roteiristaSelecionado = lstRoteiristas.getSelectedValue();
        if (roteiristaSelecionado != null) {
            int confirmacaoDel = JOptionPane.showConfirmDialog(rootPane,
                    "Tem certeza que deseja remover o roteirista " + roteiristaSelecionado.getNomeRoteirista() + "?");
            if (confirmacaoDel == JOptionPane.YES_OPTION) {
                try {
                    persistencia = new PersistenciaJPA();
                    persistencia.conexaoAberta();

                    // Recarregar a entidade
                    Roteiristas roteiristaGerenciado = (Roteiristas) persistencia.find(Roteiristas.class, roteiristaSelecionado.getIdRoteirista());

                    if (roteiristaGerenciado != null) {
                        persistencia.remover(roteiristaGerenciado);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Roteirista não encontrado no banco de dados.");
                    }

                    persistencia.fecharConexao();
                    listarRoteiristas();
                } catch (Exception e) {
                    System.err.println("Erro ao excluir modalidade: " + e.getMessage());
                } finally {
                    persistencia.fecharConexao();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane,
                    "Nenhuma modalidade selecionada");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Roteiristas roteiristaSelecionado = lstRoteiristas.getSelectedValue();
        if (roteiristaSelecionado != null) {
            try {
                persistencia = new PersistenciaJPA();
                persistencia.conexaoAberta();

                String novoNome = JOptionPane.showInputDialog(this,
                        "Edite o nome do roteirista:",
                        roteiristaSelecionado.getNomeRoteirista());

                if (novoNome != null && !novoNome.trim().isEmpty()) {
                    roteiristaSelecionado.setNomeRoteirista(novoNome);
                    persistencia.merge(roteiristaSelecionado); // Persiste a mudança no banco de dados

                    listarRoteiristas();
                } else {
                    JOptionPane.showMessageDialog(this, "Nome inválido, edição cancelada.");
                }

            } catch (Exception e) {
                System.err.println("Erro ao editar o roteirista: " + e.getMessage());
            } finally {
                persistencia.fecharConexao();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um roteirista para editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGerenciaRoteiristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciaRoteiristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciaRoteiristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciaRoteiristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaGerenciaRoteiristas dialog = new TelaGerenciaRoteiristas(new javax.swing.JFrame(), true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Roteiristas> lstRoteiristas;
    // End of variables declaration//GEN-END:variables
}
