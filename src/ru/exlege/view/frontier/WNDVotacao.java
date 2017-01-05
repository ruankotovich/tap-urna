/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.exlege.view.frontier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import ru.exlege.model.bean.Candidato;
import ru.exlege.model.dao.CandidatoDao;
import ru.exlege.model.dao.PrivilegesDao;
import ru.exlege.model.pojo.PNLVotacaoChildren;
import ru.exlege.model.pojo.PasswordUtils;

/**
 *
 * @author dmitry
 */
public class WNDVotacao extends javax.swing.JFrame {

    /**
     * Creates new form WNDVotacao
     */
    private JPanel jPmainContent;
    public static final int C_WIDTH = 800;
    public static final int C_HEIGHT = 600;
    private ArrayList<Candidato> candidatos;
    
    public WNDVotacao() {
        initComponents();
        jContentPanel.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        startMainContent();
        addContent(new PNLLoading(this));
        
        new Thread(() -> {
            candidatos = CandidatoDao.candidatos();
            addContent(new PNLInsertDataWindow(this));
        }).start();
    }
    
    public void addContent(PNLVotacaoChildren content) {
        SwingUtilities.invokeLater(() -> {
            jPmainContent.removeAll();
            content.setSize(800, 600);
            content.setPreferredSize(content.getSize());
            content.setVisible(true);
            
            jPmainContent.add(content);
            jPmainContent.repaint();
            jPmainContent.revalidate();
            content.repaint();
            content.grabFocusToMain();
        });
    }
    
    private void startMainContent() {
        jPmainContent = new JPanel();
        jPmainContent.setBackground(Color.WHITE);
        jPmainContent.setOpaque(true);
        jPmainContent.setVisible(true);
        jPmainContent.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
        jContentPanel.add(jPmainContent);
        jPmainContent.setSize(C_WIDTH, C_HEIGHT);
        jPmainContent.setLocation(jContentPanel.getPreferredSize().width / 2 - jPmainContent.getWidth() / 2, jContentPanel.getPreferredSize().height / 2 - jPmainContent.getHeight() / 2);
    }
    
    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jContentPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SCP URN : Votação");
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);

        jContentPanel.setBackground(new java.awt.Color(14, 56, 98));

        jButton1.setBackground(new java.awt.Color(253, 105, 92));
        jButton1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jButton1.setText("Encerrar Urna");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jContentPanelLayout = new javax.swing.GroupLayout(jContentPanel);
        jContentPanel.setLayout(jContentPanelLayout);
        jContentPanelLayout.setHorizontalGroup(
            jContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(693, Short.MAX_VALUE))
        );
        jContentPanelLayout.setVerticalGroup(
            jContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(610, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int confirmation = JOptionPane.showConfirmDialog(null, "Deseja encerrar a urna?", "Votação", JOptionPane.OK_CANCEL_OPTION);
        if (confirmation == JOptionPane.OK_OPTION) {
            String password = PasswordUtils.requestPassword("Fim da votação", "Entre com a senha de administração : ");
            boolean permissao = PrivilegesDao.verifyPrivileges(password);
            if (permissao) {
                PrivilegesDao.doDeadlock(password);
                new WNDEstatisticas().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Permissão Negada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(WNDVotacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WNDVotacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WNDVotacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WNDVotacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WNDVotacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jContentPanel;
    // End of variables declaration//GEN-END:variables
}