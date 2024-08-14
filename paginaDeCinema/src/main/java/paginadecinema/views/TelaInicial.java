/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package paginadecinema.views;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import paginadecinema.modelo.Filmes;
import paginadecinema.modelo.dao.PersistenciaJPA;

/**
 *
 * @author loren
 */
public class TelaInicial extends javax.swing.JFrame {

    public TelaInicial() {
        initComponents();
        listarFilmes();
    }
    
    PersistenciaJPA persistencia;


    private void listarFilmes() {
        try {
            persistencia = new PersistenciaJPA();
            lstFilmes.clearSelection();
            persistencia.conexaoAberta();
            List<Filmes> filmes = persistencia.getFilmes();
            DefaultListModel modeloLista = new DefaultListModel<>();
            for (Filmes filme : filmes) {
                modeloLista.addElement(filme);
            }
            lstFilmes.setModel(modeloLista);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnFilmes = new javax.swing.JButton();
        btnDiretores = new javax.swing.JButton();
        btnRoteiristas = new javax.swing.JButton();
        btnAtores = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstFilmes = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Página de Cinema");

        btnFilmes.setText("Gerenciar Filmes");
        btnFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilmesActionPerformed(evt);
            }
        });

        btnDiretores.setText("Gerenciar Diretores");
        btnDiretores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiretoresActionPerformed(evt);
            }
        });

        btnRoteiristas.setText("Gerenciar Roteiristas");
        btnRoteiristas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoteiristasActionPerformed(evt);
            }
        });

        btnAtores.setText("Gerenciar Atores");
        btnAtores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtoresActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(lstFilmes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDiretores, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRoteiristas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRoteiristas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDiretores, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtores, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilmesActionPerformed
        TelaGerenciaFilmes telaFilmes = new TelaGerenciaFilmes(this, true);
        telaFilmes.setVisible(true);
        
        if (!telaFilmes.isVisible()) {
            listarFilmes();
        }
        // atualiza filmes na pagina inicial depois de fechar a tela inicial
        
    }//GEN-LAST:event_btnFilmesActionPerformed

    private void btnRoteiristasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoteiristasActionPerformed
        TelaGerenciaRoteiristas telaRoteiristas = new TelaGerenciaRoteiristas(this, true);
        telaRoteiristas.setVisible(true);
        
        if (!telaRoteiristas.isVisible()) {
            listarFilmes();
        }
    }//GEN-LAST:event_btnRoteiristasActionPerformed

    private void btnDiretoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiretoresActionPerformed
        TelaGerenciaDiretores telaDiretores = new TelaGerenciaDiretores(this, true);
        telaDiretores.setVisible(true);
        
        if (!telaDiretores.isVisible()) {
            listarFilmes();
        }
    }//GEN-LAST:event_btnDiretoresActionPerformed

    private void btnAtoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtoresActionPerformed
        TelaGerenciaAtores telaAtores = new TelaGerenciaAtores(this, true);
        telaAtores.setVisible(true);
        
        if (!telaAtores.isVisible()) {
            listarFilmes();
        }
    }//GEN-LAST:event_btnAtoresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtores;
    private javax.swing.JButton btnDiretores;
    private javax.swing.JButton btnFilmes;
    private javax.swing.JButton btnRoteiristas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Filmes> lstFilmes;
    // End of variables declaration//GEN-END:variables
}
