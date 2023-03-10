
package GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
        
 
public class Pembayaran extends javax.swing.JFrame {

    String Tanggal;
    private DefaultTableModel model;
    
    public void totalBiaya(){
        int jumlahBaris = jtabel.getRowCount();
        int totalBiaya = 0;
        int jumlahBuku, hargaBuku;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBuku = Integer.parseInt(jtabel.getValueAt(i, 3).toString());
            hargaBuku = Integer.parseInt(jtabel.getValueAt(i, 4).toString());
            totalBiaya = totalBiaya + (jumlahBuku * hargaBuku);
        }
        txttotalbayar.setText(String.valueOf(totalBiaya));
        txttampil.setText("Rp "+ totalBiaya +",00");
    }
    
    private void autonumber(){
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM pembayaran ORDER BY NoFaktur DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String NoFaktur = r.getString("NoFaktur").substring(2);
                String TR = "" +(Integer.parseInt(NoFaktur)+1);
                String Nol = "";
                
                if(TR.length()==1)
                {Nol = "000";}
                else if(TR.length()==2)
                {Nol = "00";}
                else if(TR.length()==3)
                {Nol = "0";}
                else if(TR.length()==4)
                {Nol = "";}
                txttransaksi.setText("TR" + Nol + TR);
            }else{
                txttransaksi.setText("TR0001");
            }
            r.close();
            s.close();
            
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    } 
    
    public void loadData(){
        DefaultTableModel model = (DefaultTableModel) jtabel.getModel();
        model.addRow(new Object[]{
        txttransaksi.getText(),
        txtidbuku.getText(),
        txtjudul.getText(),
        txtjumlah.getText(),
        txtharga.getText(),
        txttotalbayar.getText()
        });
    }
    
    public void kosong() {
       DefaultTableModel model = (DefaultTableModel) jtabel.getModel();
       
       while (model.getRowCount()>0) {
           model.removeRow(0);
       }
    }
    
    public void utama() {
        txttransaksi.setText("");
        txtidbuku.setText("");
        txtjudul.setText("");
        txtharga.setText("");
        txtjumlah.setText("");
        autonumber();
    }
    
    public void clear() {
        txtidpembeli.setText("");
        txtnama.setText("");
        txttotalbayar.setText("0");
        txtbayar.setText("0");
        txtkembalian.setText("0");
        txttampil.setText("0");
    }
    
    public void clear2() {
        txtidbuku.setText("");
        txtjudul.setText("");
        txtharga.setText("");
        txtjumlah.setText("");
    }
    
    public void tambahTransaksi(){
        int jumlah, harga, total;
        
        jumlah = Integer.valueOf(txtjumlah.getText());
        harga = Integer.valueOf(txtharga.getText());
        total = jumlah * harga;
        
        txttotalbayar.setText(String.valueOf(total));
        
        loadData();
        totalBiaya();
        clear2();
        txtidbuku.requestFocus();
    }
     
    
    public Pembayaran() {
        initComponents();
        
        
        model = new DefaultTableModel();
        
        jtabel.setModel(model);
        
        model.addColumn("No Transaksi");
        model.addColumn("ID Buku");
        model.addColumn("Judul");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Total");
        
        utama();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        
        txttanggal.setText(s.format(date));
        txttotalbayar.setText("0");
        txtbayar.setText("0");
        txtkembalian.setText("0");
        txtidpembeli.requestFocus();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblidpembeli = new javax.swing.JLabel();
        txtidpembeli = new javax.swing.JTextField();
        lblnama = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        lbltanggal = new javax.swing.JLabel();
        txttanggal = new javax.swing.JTextField();
        lblidbuku = new javax.swing.JLabel();
        txtidbuku = new javax.swing.JTextField();
        lbljudul = new javax.swing.JLabel();
        txtjudul = new javax.swing.JTextField();
        lblharga = new javax.swing.JLabel();
        txtharga = new javax.swing.JTextField();
        lbljumlah = new javax.swing.JLabel();
        txtjumlah = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabel = new javax.swing.JTable();
        btntambah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        txttampil = new javax.swing.JTextField();
        lbltotalbayar = new javax.swing.JLabel();
        txttotalbayar = new javax.swing.JTextField();
        lblbayar = new javax.swing.JLabel();
        txtbayar = new javax.swing.JTextField();
        lblkembalian = new javax.swing.JLabel();
        txtkembalian = new javax.swing.JTextField();
        txttransaksi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btncari = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        backGround1 = new GUI.BackGround();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pembayaran_0001");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblidpembeli.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblidpembeli.setForeground(new java.awt.Color(255, 255, 255));
        lblidpembeli.setText("ID Pembeli");
        getContentPane().add(lblidpembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));
        getContentPane().add(txtidpembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 120, -1));

        lblnama.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblnama.setForeground(new java.awt.Color(255, 255, 255));
        lblnama.setText("Nama");
        getContentPane().add(lblnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        getContentPane().add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 120, -1));

        lbltanggal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbltanggal.setText("Tanggal");
        getContentPane().add(lbltanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 85, -1, -1));

        txttanggal.setEnabled(false);
        getContentPane().add(txttanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 82, 132, -1));

        lblidbuku.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblidbuku.setForeground(new java.awt.Color(255, 255, 255));
        lblidbuku.setText("ID Buku");
        getContentPane().add(lblidbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 151, -1, -1));
        getContentPane().add(txtidbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 171, 103, -1));

        lbljudul.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbljudul.setForeground(new java.awt.Color(255, 255, 255));
        lbljudul.setText("Judul");
        getContentPane().add(lbljudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));
        getContentPane().add(txtjudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 117, -1));

        lblharga.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblharga.setForeground(new java.awt.Color(255, 255, 255));
        lblharga.setText("Harga");
        getContentPane().add(lblharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));
        getContentPane().add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 113, -1));

        lbljumlah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbljumlah.setForeground(new java.awt.Color(255, 255, 255));
        lbljumlah.setText("Jumlah");
        getContentPane().add(lbljumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, -1));

        txtjumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahActionPerformed(evt);
            }
        });
        getContentPane().add(txtjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 164, -1));

        jtabel.setBackground(new java.awt.Color(102, 102, 102));
        jtabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jtabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 493, 182));

        btntambah.setBackground(new java.awt.Color(255, 255, 255));
        btntambah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        getContentPane().add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 197, -1, 51));

        btnhapus.setBackground(new java.awt.Color(255, 255, 255));
        btnhapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 266, 71, 51));

        btnsimpan.setBackground(new java.awt.Color(255, 255, 255));
        btnsimpan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, -1, 39));

        txttampil.setBackground(new java.awt.Color(153, 153, 153));
        txttampil.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txttampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 397, 186, 41));

        lbltotalbayar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltotalbayar.setForeground(new java.awt.Color(255, 255, 255));
        lbltotalbayar.setText("Total Bayar");
        getContentPane().add(lbltotalbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, 20));

        txttotalbayar.setEnabled(false);
        getContentPane().add(txttotalbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 115, -1));

        lblbayar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblbayar.setForeground(new java.awt.Color(255, 255, 255));
        lblbayar.setText("Bayar");
        getContentPane().add(lblbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, -1, -1));

        txtbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbayarActionPerformed(evt);
            }
        });
        getContentPane().add(txtbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 115, -1));

        lblkembalian.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblkembalian.setForeground(new java.awt.Color(255, 255, 255));
        lblkembalian.setText("Kembalian");
        getContentPane().add(lblkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, -1, 24));

        txtkembalian.setEnabled(false);
        getContentPane().add(txtkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 115, -1));

        txttransaksi.setEnabled(false);
        getContentPane().add(txttransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 120, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No Transaksi");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, -1));

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        getContentPane().add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        btnkeluar.setBackground(new java.awt.Color(255, 255, 255));
        btnkeluar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });
        getContentPane().add(btnkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pembayaran");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("THE LERZ BOOKSTORE");
        backGround1.add(jLabel1);

        getContentPane().add(backGround1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtjumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahActionPerformed
        tambahTransaksi ();
    }//GEN-LAST:event_txtjumlahActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        tambahTransaksi();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed

        DefaultTableModel model = (DefaultTableModel) jtabel.getModel();
        int row = jtabel.getSelectedRow();
        model.removeRow(row);
        totalBiaya();
        txtbayar.setText("0");
        txtkembalian.setText("0");
    }//GEN-LAST:event_btnhapusActionPerformed

    private void txtbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbayarActionPerformed
        int total, bayar, kembalian;
        
        total = Integer.valueOf(txttotalbayar.getText());
        bayar = Integer.valueOf(txtbayar.getText());
        
        if(total > bayar) {
            JOptionPane.showMessageDialog(null, "Uang tidak cukup untuk melakukan pembayaran");
            
        } else{
            kembalian = bayar - total;
            txtkembalian.setText(String.valueOf(kembalian));
            
        }
    }//GEN-LAST:event_txtbayarActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        DefaultTableModel model = (DefaultTableModel) jtabel.getModel();
        
        String noTransaksi = txttransaksi.getText();
        String tanggal = txttanggal.getText();
        String idPembeli = txtidpembeli.getText();
        String total = txttotalbayar.getText();
        
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "INSERT INTO pembayaran VALUES(?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, noTransaksi);
            p.setString(2, tanggal);
            p.setString(3, idPembeli);
            p.setString(4, total);
            p.executeUpdate();
            p.close();    
        }catch (Exception e){
            System.out.println("simpan pembayaran eror");
            
        }
        
        try {
            Connection c = koneksi.getKoneksi();
            int baris = jtabel.getRowCount();
            
            for (int i = 0; i < baris; i++) {
                String sql = "INSERT INTO pembayaranrinci (NoFaktur, ID_Buku, Judul, Jumlah, Harga, Total) VALUES('"
                        + jtabel.getValueAt(i, 0) +"','"+ jtabel.getValueAt(i, 1) +"','"+ jtabel.getValueAt(i, 2)
                        +"','"+ jtabel.getValueAt(i, 3) +"','"+ jtabel.getValueAt(i, 4) +"','"+ jtabel.getValueAt(i, 5) 
                        +"')";
                PreparedStatement p = c.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            }
        } catch (Exception e) {
            System.out.println("simpan pembayaranrinci eror");
        }
        clear();
        utama();
        autonumber();
        kosong();
        txttampil.setText("Rp. 0");
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
        ListBuku a = new ListBuku();
        a.setVisible(true);
    }//GEN-LAST:event_btncariActionPerformed

    private void jtabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabelMouseClicked
        // TODO add your handling code here:
        btnsimpan.setEnabled(true);
        btnhapus.setEnabled(true);

        int i = jtabel.getSelectedRow();
        if (i == -1) {
            return;
        }

        String noTransaksi = (String) model.getValueAt(i, 0);
        String id = (String) model.getValueAt(i, 1);
        String judul = (String) model.getValueAt(i, 2);
        String jumlah = (String) model.getValueAt(i, 3);
        String harga = (String) model.getValueAt(i, 4);
        String total = (String) model.getValueAt(i, 5);

        txttransaksi.setText(noTransaksi);
        txtidbuku.setText(id);
        txtjudul.setText(judul);
        txtjumlah.setText(jumlah);
        txtharga.setText(harga);
        txttotalbayar.setText(total);
    }//GEN-LAST:event_jtabelMouseClicked

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        // TODO add your handling code here:
        new MenuUtama().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnkeluarActionPerformed

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
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.BackGround backGround1;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtabel;
    private javax.swing.JLabel lblbayar;
    private javax.swing.JLabel lblharga;
    private javax.swing.JLabel lblidbuku;
    private javax.swing.JLabel lblidpembeli;
    private javax.swing.JLabel lbljudul;
    private javax.swing.JLabel lbljumlah;
    private javax.swing.JLabel lblkembalian;
    private javax.swing.JLabel lblnama;
    private javax.swing.JLabel lbltanggal;
    private javax.swing.JLabel lbltotalbayar;
    private javax.swing.JTextField txtbayar;
    public static javax.swing.JTextField txtharga;
    public static javax.swing.JTextField txtidbuku;
    private javax.swing.JTextField txtidpembeli;
    public static javax.swing.JTextField txtjudul;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txttampil;
    private javax.swing.JTextField txttanggal;
    private javax.swing.JTextField txttotalbayar;
    private javax.swing.JTextField txttransaksi;
    // End of variables declaration//GEN-END:variables
}
