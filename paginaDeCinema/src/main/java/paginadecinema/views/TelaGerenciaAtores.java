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
import javax.swing.JOptionPane;
import paginadecinema.modelo.Atores;
import paginadecinema.modelo.Diretores;
import paginadecinema.modelo.SexoAtor;
import paginadecinema.modelo.dao.PersistenciaJPA;

/**
 *
 * @author loren
 */
public class TelaGerenciaAtores extends javax.swing.JDialog {

    public TelaGerenciaAtores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        listarAtores();
    }

    PersistenciaJPA persistencia;

    private void listarAtores() {
        try {
            persistencia = new PersistenciaJPA();
            lstAtores.clearSelection();
            persistencia.conexaoAberta();
            List<Atores> atores = persistencia.getAtores();
            DefaultListModel modeloLista = new DefaultListModel<>();
            for (Atores ator : atores) {
                modeloLista.addElement(ator);
            }
            lstAtores.setModel(modeloLista);
            persistencia.fecharConexao();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao listar atores: " + ex.getMessage());
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
        lstAtores = new javax.swing.JList<>();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        jLabel1.setText("Gerenciar Atores");

        jScrollPane1.setViewportView(lstAtores);

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
            // Solicita o nome do diretor
            String nomeAtor = JOptionPane.showInputDialog("Informe o nome do ator:");

            if (nomeAtor == null || nomeAtor.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nome inválido, adição cancelada.");
                return;
            }

            // Solicita o tipo do diretor
            SexoAtor sexoAtor = (SexoAtor) JOptionPane.showInputDialog(this,
                    "Selecione o sexo do ator:",
                    "Adicionar ator",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    SexoAtor.values(), // Array de valores da enumeração
                    SexoAtor.MASCULINO); // Valor padrão

            if (sexoAtor == null) {
                JOptionPane.showMessageDialog(this, "Tipo inválido, adição cancelada.");
                return;
            }

            // Cria um novo objeto Diretor e define seus atributos
            Atores novoAtor = new Atores();
            novoAtor.setNomeAtor(nomeAtor);
            novoAtor.setSexoAtor(sexoAtor);

            // Persiste o novo diretor no banco de dados
            persistencia = new PersistenciaJPA();
            persistencia.conexaoAberta();
            persistencia.persist(novoAtor);
            listarAtores(); // Atualiza a lista de diretores

        } catch (Exception ex) {
            Logger.getLogger(TelaGerenciaDiretores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (persistencia != null) {
                persistencia.fecharConexao();
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed

        Atores atorSelecionado = lstAtores.getSelectedValue();
        if (atorSelecionado != null) {
            int confirmacaoDel = JOptionPane.showConfirmDialog(rootPane,
                    "Tem certeza que deseja remover o ator " + atorSelecionado.getNomeAtor() + "?");
            if (confirmacaoDel == JOptionPane.YES_OPTION) {
                try {
                    persistencia = new PersistenciaJPA();
                    persistencia.conexaoAberta();

                    // Recarregar a entidade
                    Atores atorGerenciado = (Atores) persistencia.find(Atores.class, atorSelecionado.getIdAtor());

                    if (atorGerenciado != null) {
                        persistencia.remover(atorGerenciado);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Ator não encontrado no banco de dados.");
                    }

                    persistencia.fecharConexao();
                    listarAtores();
                } catch (Exception e) {
                    System.err.println("Erro ao excluir ator: " + e.getMessage());
                } finally {
                    persistencia.fecharConexao();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane,
                    "Nenhum ator selecionado");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Atores atorSelecionado = lstAtores.getSelectedValue();
        if (atorSelecionado != null) {
            try {
                persistencia = new PersistenciaJPA();
                persistencia.conexaoAberta();

                // Editar nome do diretor
                String novoNome = JOptionPane.showInputDialog(this,
                        "Edite o nome do ator:",
                        atorSelecionado.getNomeAtor());

                // Se o novo nome não for nulo ou vazio
                if (novoNome != null && !novoNome.trim().isEmpty()) {
                    atorSelecionado.setNomeAtor(novoNome);
                } else {
                    JOptionPane.showMessageDialog(this, "Nome inválido, edição cancelada.");
                    return;
                }

                // Editar tipo de diretor
                SexoAtor novoSexo = (SexoAtor) JOptionPane.showInputDialog(this,
                        "Selecione o sexo do ator:",
                        "Editar sexo",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        SexoAtor.values(), // Array de valores da enumeração
                        atorSelecionado.getSexoAtor());

                if (novoSexo != null) {
                    atorSelecionado.setSexoAtor(novoSexo);
                } else {
                    JOptionPane.showMessageDialog(this, "Tipo inválido, edição cancelada.");
                    return;
                }

                persistencia.merge(atorSelecionado); // Persiste a mudança no banco de dados
                listarAtores(); // Atualiza a lista de diretores

            } catch (Exception e) {
                System.err.println("Erro ao editar o diretor: " + e.getMessage());
            } finally {
                persistencia.fecharConexao();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um ator para editar.");
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
            java.util.logging.Logger.getLogger(TelaGerenciaAtores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciaAtores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciaAtores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciaAtores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                TelaGerenciaAtores dialog = new TelaGerenciaAtores(new javax.swing.JFrame(), true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Atores> lstAtores;
    // End of variables declaration//GEN-END:variables
}
