/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.exlege.view.frontier.internal;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import ru.exlege.model.bean.Candidato;
import ru.exlege.model.dao.CandidatoDao;

/**
 *
 * @author dmitry
 */
public class IFEditCandidate extends javax.swing.JInternalFrame {

    /**
     * Creates new form IFInsertElector
     */
    private BufferedImage imagem = null;
    private BufferedImage defaultImagem = null;
    private Candidato current = null;

    public IFEditCandidate() {
        initComponents();
    }

    public IFEditCandidate(Candidato can) {
        initComponents();
        current = can;
        if (can != null) {
            jTnome.setText(can.getNome());
            jTpartido.setText(can.getPartido());
            jTcodigo.setText(String.valueOf(can.getPid()));
            jBexcluir.setEnabled(true);
            jBalterar.setEnabled(true);
            jBescolher.setEnabled(true);

            if (can.getFoto() != null) {
                try {
                    imagem = defaultImagem = ImageIO.read(can.getFoto().getBinaryStream());
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(IFEditCandidate.class.getName()).log(Level.SEVERE, null, ex);
                }
                jBremover.setEnabled(true);
                jTimagem.setText("");
                jTimagem.setIcon(new ImageIcon(imagem));
            } else {
                jBremover.setEnabled(false);
                jTimagem.setText("SEM FOTO");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Candidato não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            jBexcluir.setEnabled(false);
            jBalterar.setEnabled(false);
            jTnome.setText("");
            jTpartido.setText("");
            jTcodigo.setText("");
            jTnome.setEnabled(false);
            jTcodigo.setEnabled(false);
            jTpartido.setEnabled(false);
            jTimagem.setText("");
            jTimagem.setIcon(null);
            jBalteracao.setEnabled(false);
            jBremover.setEnabled(false);
            jBescolher.setEnabled(false);
            jTpid.grabFocus();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTnome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTcodigo = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTimagem = new javax.swing.JLabel();
        jBremover = new javax.swing.JButton();
        jBescolher = new javax.swing.JButton();
        jBalteracao = new javax.swing.JButton();
        jBalterar = new javax.swing.JButton();
        jBexcluir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTpartido = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTpid = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Edição de Candidato");
        setToolTipText("");
        setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(12, 111, 209));

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Nome : ");

        jTnome.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTnome.setEnabled(false);
        jTnome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTnomeMouseClicked(evt);
            }
        });
        jTnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTnomeActionPerformed(evt);
            }
        });
        jTnome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTnomeKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Cód : ");

        try {
            jTcodigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTcodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTcodigo.setEnabled(false);
        jTcodigo.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jTcodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTcodigoMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Foto : ");

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(254, 254, 254), 5, true));
        jPanel2.setOpaque(false);

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel5.setText("Restrições para a imagem : ");

        jLabel6.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel6.setText("- Dimensões : 150x150");

        jLabel7.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel7.setText("- Tamanho : até 100kb");

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTimagem.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTimagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTimagem.setText("SEM FOTO");
        jTimagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTimagem.setPreferredSize(new java.awt.Dimension(150, 150));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTimagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTimagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBremover.setText("Remover Foto");
        jBremover.setEnabled(false);
        jBremover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBremoverActionPerformed(evt);
            }
        });

        jBescolher.setText("Escolher...");
        jBescolher.setEnabled(false);
        jBescolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBescolherActionPerformed(evt);
            }
        });

        jBalteracao.setText("Cancelar Alteração");
        jBalteracao.setEnabled(false);
        jBalteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBalteracaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBremover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBescolher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBalteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBescolher, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBremover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBalteracao)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jBalterar.setBackground(new java.awt.Color(1, 119, 13));
        jBalterar.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jBalterar.setForeground(new java.awt.Color(254, 254, 254));
        jBalterar.setText("Alterar");
        jBalterar.setEnabled(false);
        jBalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBalterarActionPerformed(evt);
            }
        });

        jBexcluir.setBackground(new java.awt.Color(151, 2, 36));
        jBexcluir.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jBexcluir.setForeground(new java.awt.Color(254, 254, 254));
        jBexcluir.setText("Excluir");
        jBexcluir.setEnabled(false);
        jBexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBexcluirActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Partido : ");

        jTpartido.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jTpartido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTpartido.setEnabled(false);
        jTpartido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTpartidoMouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(1, 76, 151));

        jLabel8.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("Pesquisar PID do candidato : ");

        jButton2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        try {
            jTpid.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTpid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTpid.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTpid, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTpid, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBexcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBalterar, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTpartido))
                            .addComponent(jTnome)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTnome)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTpartido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBexcluir)
                    .addComponent(jBalterar))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTnomeActionPerformed

    private void jTnomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTnomeKeyReleased

    }//GEN-LAST:event_jTnomeKeyReleased

    private void jBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBalterarActionPerformed
        Blob blob = null;

        if (imagem != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                ImageIO.write(imagem, "png", baos);
            } catch (IOException ex) {
                Logger.getLogger(IFInsertCandidate.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] bytes = baos.toByteArray();
            try {
                blob = new SerialBlob(bytes);
            } catch (SQLException ex) {
                blob = null;
                Logger.getLogger(IFInsertCandidate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Candidato candidato = new Candidato(Integer.parseInt(jTcodigo.getText()),
                jTnome.getText(), jTpartido.getText(), blob);

        if (CandidatoDao.alterar(current.getPid(), candidato)) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Realizado", JOptionPane.INFORMATION_MESSAGE);
            jTpid.setText(jTcodigo.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Alteração não realizada!\nConsulte o administrador do sistema", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jBalterarActionPerformed

    private void jBexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBexcluirActionPerformed
        if (current != null) {
            if (CandidatoDao.deletar(current.getPid())) {
                JOptionPane.showMessageDialog(null, "Excluído com sucesso!", "Realizado", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
//                jTnome.setText("");
//                jTpartido.setText("");
//                jTcodigo.setText("");
//                jTnome.setEnabled(false);
//                jTpartido.setEnabled(false);
//                jTcodigo.setEnabled(false);
//                jBremover.setEnabled(false);
//                jBexcluir.setEnabled(false);
//                jBalterar.setEnabled(false);
//                jBescolher.setEnabled(false);
//                jTimagem.setIcon(null);
//                jTimagem.setText("SEM FOTO");
//                imagem = defaultImagem = null;
//                jTpid.setText("");
//                jTpid.grabFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Candidado não excluído!\nConsulte o administrador do sistema", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Candidado à ser excluído", "Erro", JOptionPane.ERROR_MESSAGE);
            jTpid.grabFocus();
        }
    }//GEN-LAST:event_jBexcluirActionPerformed

    private void jBescolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBescolherActionPerformed
        File f;
        JFileChooser chooser = new JFileChooser("./");
        chooser.setFileFilter(new FileNameExtensionFilter("Image Files", new String[]{"jpg", "png"}));
        chooser.showOpenDialog(null);
        f = chooser.getSelectedFile();

        if (f != null) {
            jBalteracao.setEnabled(true);
            jTimagem.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
            try {
                if (f.length() <= 100000) {
                    imagem = ImageIO.read(f);
                    if (imagem.getWidth(null) != 150 || imagem.getWidth(null) != 150) {
                        JOptionPane.showMessageDialog(null, "A imagem não pôde ser lida", "Erro", JOptionPane.ERROR_MESSAGE);
                        imagem = null;
                        jTimagem.setText("SEM FOTO");
                        jTimagem.setIcon(null);
                    } else {
                        jTimagem.setText("");
                        jTimagem.setIcon(new ImageIcon(imagem));
                        jBremover.setEnabled(true);
                    }
                } else {
                    imagem = null;
                    jTimagem.setText("SEM FOTO");
                    jTimagem.setIcon(null);
                    jBremover.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "A imagem é muito pesada(" + f.length() + ")", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "A imagem não pôde ser lida", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jBescolherActionPerformed

    private void jBremoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBremoverActionPerformed
        jTimagem.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        jBalteracao.setEnabled(true);
        imagem = null;
        jTimagem.setText("SEM FOTO");
        jTimagem.setIcon(null);
        jBremover.setEnabled(false);
    }//GEN-LAST:event_jBremoverActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Candidato can;
        current = can = CandidatoDao.consultar(Integer.parseInt(jTpid.getText()));
        if (can != null) {
            jTnome.setText(can.getNome());
            jTpartido.setText(can.getPartido());
            jTcodigo.setText(jTpid.getText());
            jBexcluir.setEnabled(true);
            jBalterar.setEnabled(true);
            jBescolher.setEnabled(true);

            if (can.getFoto() != null) {
                try {
                    imagem = defaultImagem = ImageIO.read(can.getFoto().getBinaryStream());
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(IFEditCandidate.class.getName()).log(Level.SEVERE, null, ex);
                }
                jBremover.setEnabled(true);
                jTimagem.setText("");
                jTimagem.setIcon(new ImageIcon(imagem));
            } else {
                jBremover.setEnabled(false);
                jTimagem.setText("SEM FOTO");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Candidato não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            jBexcluir.setEnabled(false);
            jBalterar.setEnabled(false);
            jTnome.setText("");
            jTpartido.setText("");
            jTcodigo.setText("");
            jTnome.setEnabled(false);
            jTcodigo.setEnabled(false);
            jTpartido.setEnabled(false);
            jTimagem.setText("");
            jTimagem.setIcon(null);
            jBalteracao.setEnabled(false);
            jBremover.setEnabled(false);
            jBescolher.setEnabled(false);
            jTpid.grabFocus();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBalteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBalteracaoActionPerformed
        imagem = defaultImagem;
        if (imagem != null) {
            jBremover.setEnabled(true);
            jTimagem.setText("");
            jTimagem.setIcon(new ImageIcon(imagem));
        } else {
            jTimagem.setText("SEM FOTO");
            jTimagem.setIcon(null);
        }
        jTimagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jBalteracao.setEnabled(false);
    }//GEN-LAST:event_jBalteracaoActionPerformed

    private void jTnomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTnomeMouseClicked
        if (current != null) {
            jTnome.setEnabled(true);
        }
    }//GEN-LAST:event_jTnomeMouseClicked

    private void jTcodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTcodigoMouseClicked
        if (current != null) {
            jTcodigo.setEnabled(true);
        }
    }//GEN-LAST:event_jTcodigoMouseClicked

    private void jTpartidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTpartidoMouseClicked
        if (current != null) {
            jTpartido.setEnabled(true);
        }
    }//GEN-LAST:event_jTpartidoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBalteracao;
    private javax.swing.JButton jBalterar;
    private javax.swing.JButton jBescolher;
    private javax.swing.JButton jBexcluir;
    private javax.swing.JButton jBremover;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JFormattedTextField jTcodigo;
    private javax.swing.JLabel jTimagem;
    private javax.swing.JTextField jTnome;
    private javax.swing.JTextField jTpartido;
    private javax.swing.JFormattedTextField jTpid;
    // End of variables declaration//GEN-END:variables
}
