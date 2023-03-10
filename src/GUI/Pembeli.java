
package GUI;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

    
    public class Pembeli extends javax.swing.JFrame {
   koneksi koneksi = new koneksi();
    
    private DefaultTableModel model;
    
    private void autonumber(){
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM pembeli ORDER BY ID_Pembeli DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String IdPembeli = r.getString("ID_Pembeli").substring(2);
                String P = "" +(Integer.parseInt(IdPembeli)+1);
                String Nol = "";
                
                if (P.length()==1)
                {Nol = "00";}
                else if (P.length()== 2)
                {Nol = "0";}
                else if(P.length()== 3)
                {Nol = "";}
                
                txtidpembeli.setText("P" + Nol + P);
            }else{
                txtidpembeli.setText("P001");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }
        
    public void clear(){
        txtnama.setText("");
        txtalamat.setText("");
        txttelepon.setText("");
        
    }
    public void loadData(){
        model.getDataVector().removeAllElements();
        
        model.fireTableDataChanged();
        
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM pembeli";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                Object[] o = new Object[7];
                o [0] = r.getString("ID_Pembeli");
                o [1] = r.getString("Nama");
                o [2] = r.getString("Alamat");
                o [3] = r.getString("Telepon");
                
                
                model.addRow(o);
            }
            r.close();
            s.close();
            
        } catch (Exception e) {
            System.out.println("terjadi kesalahan");
        }
    }
    
    public Pembeli() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        model = new DefaultTableModel();
        
        jtabel.setModel(model);
        
        model.addColumn("ID_Pembeli");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("Telepon");
        
        
        loadData();
        autonumber();
        btnedit.setEnabled(false);
        btnhapus.setEnabled(false);

        
    }
    
    

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblpembeli = new javax.swing.JLabel();
        txtidpembeli = new javax.swing.JTextField();
        lblnama = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        lblalamat = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();
        lbltelepon = new javax.swing.JLabel();
        txttelepon = new javax.swing.JTextField();
        btnedit = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtabel = new javax.swing.JTable();
        btnkeluar = new javax.swing.JButton();
        backGround1 = new GUI.BackGround();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pembeli_0001");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblpembeli.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblpembeli.setForeground(new java.awt.Color(255, 255, 255));
        lblpembeli.setText("ID PEMBELI");
        getContentPane().add(lblpembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 96, -1, 31));

        txtidpembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidpembeliActionPerformed(evt);
            }
        });
        getContentPane().add(txtidpembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 96, 144, 31));

        lblnama.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblnama.setForeground(new java.awt.Color(255, 255, 255));
        lblnama.setText("NAMA");
        getContentPane().add(lblnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 156, -1, 25));
        getContentPane().add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 152, 144, 33));

        lblalamat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblalamat.setForeground(new java.awt.Color(255, 255, 255));
        lblalamat.setText("ALAMAT");
        getContentPane().add(lblalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 203, -1, 32));
        getContentPane().add(txtalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 203, 144, 32));

        lbltelepon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltelepon.setForeground(new java.awt.Color(255, 255, 255));
        lbltelepon.setText("TELEPON");
        getContentPane().add(lbltelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 258, -1, 23));
        getContentPane().add(txttelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 253, 144, 33));

        btnedit.setBackground(new java.awt.Color(255, 255, 255));
        btnedit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        getContentPane().add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 328, 65, -1));

        btnsimpan.setBackground(new java.awt.Color(255, 255, 255));
        btnsimpan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 287, -1, -1));

        btnhapus.setBackground(new java.awt.Color(255, 255, 255));
        btnhapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 369, -1, -1));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("THE LERZ BOOKSTORE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jtabel.setBackground(new java.awt.Color(102, 102, 102));
        jtabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID PEMBELI", "Nama", "Alamat", "Telepon"
            }
        ));
        jtabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtabel);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 434, 92));

        btnkeluar.setBackground(new java.awt.Color(255, 255, 255));
        btnkeluar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });
        getContentPane().add(btnkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, -1, -1));

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pembeli");

        javax.swing.GroupLayout backGround1Layout = new javax.swing.GroupLayout(backGround1);
        backGround1.setLayout(backGround1Layout);
        backGround1Layout.setHorizontalGroup(
            backGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backGround1Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
        );
        backGround1Layout.setVerticalGroup(
            backGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backGround1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addContainerGap(370, Short.MAX_VALUE))
        );

        getContentPane().add(backGround1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        String id = txtidpembeli.getText();
        String nama = txtnama.getText();
        String alamat = txtalamat.getText();
        String telepon = txttelepon.getText();
        
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "INSERT INTO pembeli VALUES (?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, nama);
            p.setString(3, alamat);
            p.setString(4, telepon);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
            loadData();
            
        } catch (Exception e){
            System.out.println("Terjadi kesalahan");
            
        } finally {
            autonumber ();
            clear();
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        int i = jtabel.getSelectedRow();
        if (i == -1) {
            return;
        }
        String id = (String) model.getValueAt(i, 0);
        String nama = txtnama.getText();
        String alamat = txtalamat.getText();
        String telepon = txttelepon.getText();

        
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "UPDATE pembeli SET Nama = ?, Alamat = ?, Telepon = ? WHERE ID_Pembeli = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, nama);
            p.setString(2, alamat);
            p.setString(3, telepon);
            p.setString(4, id);
            
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data diubah");
            btnsimpan.setEnabled(true);
            btnedit.setEnabled(false);
            btnhapus.setEnabled(false);
            
            
            clear();
        } catch (Exception e) {
            System.out.println("Update error");
        } finally {
            loadData();
            autonumber();
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
         int i = jtabel.getSelectedRow();
        if (i == -1) {
            return;
        }
        
        String id = (String) model.getValueAt(i, 0);
        
        int pernyataan = JOptionPane.showConfirmDialog(null, "Yakin ingin dihapus","konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(pernyataan== JOptionPane.OK_OPTION) {
            try {
                Connection c = koneksi.getKoneksi();
                String sql = "DELETE FROM pembeli where ID_Pembeli = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, id);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Data terhapus");
            } catch (Exception e) {
                System.out.println("Terjadi Kesalahan");
            } finally{
                btnsimpan.setEnabled(true);
                btnedit.setEnabled(false);
                btnhapus.setEnabled(false);
                loadData();
                autonumber();
                clear();
            }
        }
         if (pernyataan == JOptionPane.CANCEL_OPTION) {
             
         }                                       
        
    }//GEN-LAST:event_btnhapusActionPerformed

    private void jtabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabelMouseClicked
         btnsimpan.setEnabled(false);
        btnedit.setEnabled(true);
        btnhapus.setEnabled(true);
        
        int i = jtabel.getSelectedRow();
        if (i == -1) {
            return;
        }
        
        String id = (String) model.getValueAt(i, 0);
        String nama = (String) model.getValueAt(i, 1);
        String alamat = (String) model.getValueAt(i, 2);
        String telepon = (String) model.getValueAt(i, 3);

        txtidpembeli.setText(id);
        txtnama.setText(nama);
        txtalamat.setText(alamat);
        txttelepon.setText(telepon);
        
    }//GEN-LAST:event_jtabelMouseClicked

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        // TODO add your handling code here:
        new MenuUtama ().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void txtidpembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpembeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidpembeliActionPerformed

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
            java.util.logging.Logger.getLogger(Pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembeli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.BackGround backGround1;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtabel;
    private javax.swing.JLabel lblalamat;
    private javax.swing.JLabel lblnama;
    private javax.swing.JLabel lblpembeli;
    private javax.swing.JLabel lbltelepon;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtidpembeli;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txttelepon;
    // End of variables declaration//GEN-END:variables
}
