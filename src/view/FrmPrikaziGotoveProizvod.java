/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.Controller;
import domain.GotovProizvod;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.model.TableModelGotovProizvod;
import java.sql.SQLException;

/**
 *
 * @author Korisnik
 */
public class FrmPrikaziGotoveProizvod extends javax.swing.JDialog {

    /**
     * Creates new form FrmPrikaziGotoveProizvode
     */
    public FrmPrikaziGotoveProizvod(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            prepareView();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška prilikom pripreme forme", JOptionPane.ERROR_MESSAGE);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGotovProizvod = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gotov proizvod"));

        tblGotovProizvod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblGotovProizvod);

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodaj)
                    .addComponent(btnIzmeni)
                    .addComponent(btnObrisi))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnDodaj)
                .addGap(18, 18, 18)
                .addComponent(btnIzmeni)
                .addGap(18, 18, 18)
                .addComponent(btnObrisi)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        FrmDodajGotovProizvod f = new FrmDodajGotovProizvod((JFrame) this.getParent(), true);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int red = tblGotovProizvod.getSelectedRow();
        if (red != -1) {
            TableModelGotovProizvod tmt = (TableModelGotovProizvod) tblGotovProizvod.getModel();
            GotovProizvod gp = tmt.vratiIzabranGotovProizvod(red);
            FrmIzmeniGotovProizvod fpt = new FrmIzmeniGotovProizvod((FrmMain) this.getParent(), true);
            fpt.setGotovProizvod(gp);
            fpt.setLocationRelativeTo(null);

            JOptionPane.showMessageDialog(this, "Sistem je učitao gotov proizvod.", "Učitavanje gotovog proizvoda", JOptionPane.INFORMATION_MESSAGE);
            fpt.setVisible(true);
        } else{ JOptionPane.showMessageDialog(this,"Sistem ne moze da učita gotov proizvod.","Greška", JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        try {
            int red = tblGotovProizvod.getSelectedRow();
            if (red != -1) {
                TableModelGotovProizvod tmv = (TableModelGotovProizvod) tblGotovProizvod.getModel();
                GotovProizvod gp = tmv.vratiIzabranGotovProizvod(red);
                Controller.getInstance().deleteGotovProizvod(gp);
                prepareView();
                JOptionPane.showMessageDialog(this, "Sistem je obrisao gotov proizvod.", "Brisanje gotovog proizvoda", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da obriše gotov proizvod.", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrikaziGotoveProizvod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrikaziGotoveProizvod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrikaziGotoveProizvod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrikaziGotoveProizvod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPrikaziGotoveProizvod dialog = new FrmPrikaziGotoveProizvod(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGotovProizvod;
    // End of variables declaration//GEN-END:variables

    private void prepareView() throws SQLException, Exception {
        pripremiTabelu();
    }

    private void pripremiTabelu() throws SQLException, Exception {
         List<GotovProizvod> lista = Controller.getInstance().getAllGotovProizvod();
        TableModelGotovProizvod tmr = new TableModelGotovProizvod(lista);
        tblGotovProizvod.setModel(tmr);
    }


}
