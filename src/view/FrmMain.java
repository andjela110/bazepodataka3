/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author Korisnik
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMainn
     */
    public FrmMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenuTipUsluge = new javax.swing.JMenu();
        jMenuItemTipUslugePregled = new javax.swing.JMenuItem();
        jMenuPelet = new javax.swing.JMenu();
        jMenuItemPeletPregled = new javax.swing.JMenuItem();
        jMenuKupio = new javax.swing.JMenu();
        jMenuItemKupioPregled = new javax.swing.JMenuItem();
        jMenuKupac = new javax.swing.JMenu();
        jMenuItemKupacPregled = new javax.swing.JMenuItem();
        jMenuPrijemnica = new javax.swing.JMenu();
        jMenuItemPrijemnicaPregled = new javax.swing.JMenuItem();
        jMenuTrebovanje = new javax.swing.JMenu();
        jMenuItemTrebovanjePregled = new javax.swing.JMenuItem();
        jMenuRacun = new javax.swing.JMenu();
        jMenuItemRacunPregled = new javax.swing.JMenuItem();
        jMenuStavkaRacuna = new javax.swing.JMenu();
        jMenuItemStavkaRacunaPregled = new javax.swing.JMenuItem();
        jMenuKvar = new javax.swing.JMenu();
        jMenuItemKvarPregled = new javax.swing.JMenuItem();
        jMenuGotovProizvod = new javax.swing.JMenu();
        jMenuItemGotovProizvodPregled = new javax.swing.JMenuItem();
        jMenuPartner = new javax.swing.JMenu();
        jMenuItemPartnerPregled = new javax.swing.JMenuItem();
        jMenuDelatnost = new javax.swing.JMenu();
        jMenuItemDelatnostPregled = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuTipUsluge.setText("TipUsluge");

        jMenuItemTipUslugePregled.setText("Pregled");
        jMenuItemTipUslugePregled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTipUslugePregledActionPerformed(evt);
            }
        });
        jMenuTipUsluge.add(jMenuItemTipUslugePregled);

        jMenuBar2.add(jMenuTipUsluge);

        jMenuPelet.setText("Pelet");

        jMenuItemPeletPregled.setText("Pregled");
        jMenuItemPeletPregled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPeletPregledActionPerformed(evt);
            }
        });
        jMenuPelet.add(jMenuItemPeletPregled);

        jMenuBar2.add(jMenuPelet);

        jMenuKupio.setText("Kupio");

        jMenuItemKupioPregled.setText("Pregled");
        jMenuItemKupioPregled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemKupioPregledActionPerformed(evt);
            }
        });
        jMenuKupio.add(jMenuItemKupioPregled);

        jMenuBar2.add(jMenuKupio);

        jMenuKupac.setText("Kupac");

        jMenuItemKupacPregled.setText("Pregled");
        jMenuItemKupacPregled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemKupacPregledActionPerformed(evt);
            }
        });
        jMenuKupac.add(jMenuItemKupacPregled);

        jMenuBar2.add(jMenuKupac);

        jMenuPrijemnica.setText("Prijemnica");

        jMenuItemPrijemnicaPregled.setText("Pregled");
        jMenuItemPrijemnicaPregled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPrijemnicaPregledActionPerformed(evt);
            }
        });
        jMenuPrijemnica.add(jMenuItemPrijemnicaPregled);

        jMenuBar2.add(jMenuPrijemnica);

        jMenuTrebovanje.setText("Trebovanje");

        jMenuItemTrebovanjePregled.setText("Pregled");
        jMenuItemTrebovanjePregled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTrebovanjePregledActionPerformed(evt);
            }
        });
        jMenuTrebovanje.add(jMenuItemTrebovanjePregled);

        jMenuBar2.add(jMenuTrebovanje);

        jMenuRacun.setText("Račun");

        jMenuItemRacunPregled.setText("Pregled");
        jMenuItemRacunPregled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRacunPregledActionPerformed(evt);
            }
        });
        jMenuRacun.add(jMenuItemRacunPregled);

        jMenuBar2.add(jMenuRacun);

        jMenuStavkaRacuna.setText("StavkaRačuna");

        jMenuItemStavkaRacunaPregled.setText("Pregled");
        jMenuItemStavkaRacunaPregled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemStavkaRacunaPregledActionPerformed(evt);
            }
        });
        jMenuStavkaRacuna.add(jMenuItemStavkaRacunaPregled);

        jMenuBar2.add(jMenuStavkaRacuna);

        jMenuKvar.setText("Kvar");

        jMenuItemKvarPregled.setText("Pregled");
        jMenuItemKvarPregled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemKvarPregledActionPerformed(evt);
            }
        });
        jMenuKvar.add(jMenuItemKvarPregled);

        jMenuBar2.add(jMenuKvar);

        jMenuGotovProizvod.setText("GotovProizvod");

        jMenuItemGotovProizvodPregled.setText("Pregled");
        jMenuItemGotovProizvodPregled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGotovProizvodPregledActionPerformed(evt);
            }
        });
        jMenuGotovProizvod.add(jMenuItemGotovProizvodPregled);

        jMenuBar2.add(jMenuGotovProizvod);

        jMenuPartner.setText("Partner");

        jMenuItemPartnerPregled.setText("Pregled");
        jMenuItemPartnerPregled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPartnerPregledActionPerformed(evt);
            }
        });
        jMenuPartner.add(jMenuItemPartnerPregled);

        jMenuBar2.add(jMenuPartner);

        jMenuDelatnost.setText("Delatnost");

        jMenuItemDelatnostPregled.setText("Pregled");
        jMenuItemDelatnostPregled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDelatnostPregledActionPerformed(evt);
            }
        });
        jMenuDelatnost.add(jMenuItemDelatnostPregled);

        jMenuBar2.add(jMenuDelatnost);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1114, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemPeletPregledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPeletPregledActionPerformed
        FrmPrikaziPelet fpd = new FrmPrikaziPelet(this, true);
        fpd.setLocationRelativeTo(null);
        fpd.setVisible(true);
    }//GEN-LAST:event_jMenuItemPeletPregledActionPerformed

    private void jMenuItemKvarPregledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemKvarPregledActionPerformed
        FrmPrikaziKvar fpd = new FrmPrikaziKvar(this, true);
        fpd.setLocationRelativeTo(null);
        fpd.setVisible(true);
    }//GEN-LAST:event_jMenuItemKvarPregledActionPerformed

    private void jMenuItemGotovProizvodPregledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGotovProizvodPregledActionPerformed
        FrmPrikaziGotoveProizvod fpd = new FrmPrikaziGotoveProizvod(this, true);
        fpd.setLocationRelativeTo(null);
        fpd.setVisible(true);
    }//GEN-LAST:event_jMenuItemGotovProizvodPregledActionPerformed

    private void jMenuItemDelatnostPregledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDelatnostPregledActionPerformed
        FrmPrikaziDelatnost fpd = new FrmPrikaziDelatnost(this, true);
        fpd.setLocationRelativeTo(null);
        fpd.setVisible(true);
    }//GEN-LAST:event_jMenuItemDelatnostPregledActionPerformed

    private void jMenuItemTipUslugePregledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTipUslugePregledActionPerformed
        FrmPrikaziTipUsluge fpd = new FrmPrikaziTipUsluge(this, true);
        fpd.setLocationRelativeTo(null);
        fpd.setVisible(true);
    }//GEN-LAST:event_jMenuItemTipUslugePregledActionPerformed

    private void jMenuItemKupioPregledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemKupioPregledActionPerformed
        FrmPrikaziKupio fpd = new FrmPrikaziKupio(this, true);
        fpd.setLocationRelativeTo(null);
        fpd.setVisible(true);
    }//GEN-LAST:event_jMenuItemKupioPregledActionPerformed

    private void jMenuItemKupacPregledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemKupacPregledActionPerformed
        FrmPrikaziKupac fpd = new FrmPrikaziKupac(this, true);
        fpd.setLocationRelativeTo(null);
        fpd.setVisible(true);
    }//GEN-LAST:event_jMenuItemKupacPregledActionPerformed

    private void jMenuItemPrijemnicaPregledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPrijemnicaPregledActionPerformed
        FrmPrikaziPrijemnica fpd = new FrmPrikaziPrijemnica(this, true);
        fpd.setLocationRelativeTo(null);
        fpd.setVisible(true);
    }//GEN-LAST:event_jMenuItemPrijemnicaPregledActionPerformed

    private void jMenuItemTrebovanjePregledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTrebovanjePregledActionPerformed
        FrmPrikaziTrebovanje fpd = new FrmPrikaziTrebovanje(this, true);
        fpd.setLocationRelativeTo(null);
        fpd.setVisible(true);
    }//GEN-LAST:event_jMenuItemTrebovanjePregledActionPerformed

    private void jMenuItemRacunPregledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRacunPregledActionPerformed
        FrmPrikaziRacun fpd = new FrmPrikaziRacun(this, true);
        fpd.setLocationRelativeTo(null);
        fpd.setVisible(true);
    }//GEN-LAST:event_jMenuItemRacunPregledActionPerformed

    private void jMenuItemStavkaRacunaPregledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemStavkaRacunaPregledActionPerformed
        FrmPrikaziStavkaRacuna fpd = new FrmPrikaziStavkaRacuna(this, true);
        fpd.setLocationRelativeTo(null);
        fpd.setVisible(true);
    }//GEN-LAST:event_jMenuItemStavkaRacunaPregledActionPerformed

    private void jMenuItemPartnerPregledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPartnerPregledActionPerformed
        FrmPrikaziPartner fpd = new FrmPrikaziPartner(this, true);
        fpd.setLocationRelativeTo(null);
        fpd.setVisible(true);
    }//GEN-LAST:event_jMenuItemPartnerPregledActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMenuDelatnost;
    private javax.swing.JMenu jMenuGotovProizvod;
    private javax.swing.JMenuItem jMenuItemDelatnostPregled;
    private javax.swing.JMenuItem jMenuItemGotovProizvodPregled;
    private javax.swing.JMenuItem jMenuItemKupacPregled;
    private javax.swing.JMenuItem jMenuItemKupioPregled;
    private javax.swing.JMenuItem jMenuItemKvarPregled;
    private javax.swing.JMenuItem jMenuItemPartnerPregled;
    private javax.swing.JMenuItem jMenuItemPeletPregled;
    private javax.swing.JMenuItem jMenuItemPrijemnicaPregled;
    private javax.swing.JMenuItem jMenuItemRacunPregled;
    private javax.swing.JMenuItem jMenuItemStavkaRacunaPregled;
    private javax.swing.JMenuItem jMenuItemTipUslugePregled;
    private javax.swing.JMenuItem jMenuItemTrebovanjePregled;
    private javax.swing.JMenu jMenuKupac;
    private javax.swing.JMenu jMenuKupio;
    private javax.swing.JMenu jMenuKvar;
    private javax.swing.JMenu jMenuPartner;
    private javax.swing.JMenu jMenuPelet;
    private javax.swing.JMenu jMenuPrijemnica;
    private javax.swing.JMenu jMenuRacun;
    private javax.swing.JMenu jMenuStavkaRacuna;
    private javax.swing.JMenu jMenuTipUsluge;
    private javax.swing.JMenu jMenuTrebovanje;
    // End of variables declaration//GEN-END:variables
}