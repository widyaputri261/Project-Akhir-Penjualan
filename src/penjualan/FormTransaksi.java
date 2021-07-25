package penjualan;

import method.Control;
import entity.Entitas;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import method.Control;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import entity.Entitas;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class FormTransaksi extends javax.swing.JFrame {
    
     int x=0;
        private DefaultTableModel model;
        Control bc=new Control();
        Entitas eb=new Entitas();
        List <Entitas> listBarang=new ArrayList<Entitas>();
    
    Statement st;
    Connection conn;
    ResultSet rs;
    String tgl;
    private double total;
    DefaultTableModel tableModel = new DefaultTableModel(
    new Object [ ][ ] {},
    new String [ ] {
    "Kd Barang", "Nama Barang","Harga Barang","Jumlah","Total"
    });
    private int row;
    private String tanggal;

    public FormTransaksi() {
        initComponents();
        bersih();
        siapIsi(false);
        aktif(false);
        setTombol(true);
        setLocationRelativeTo(this);
        tgl();
        inisialisasi_tabel();
        setkoneksi();
    }
    
    public String Kodeba, Namaba, Hargaju, stock;

    public String Kodebar() {
        return Kodeba;
    }

    public String Namabar() {
        return Namaba;
    }

    public String Hargaju() {
        return Hargaju;
    }

    public String stock() {
        return stock;
    }
   
    private void bersih(){
    txtnojual.setText(null);
        
    }

    private void siapIsi(boolean a){
    txtnojual.setEnabled(a);
        
    }
    
    private void buatNoJual(){
        listBarang=bc.tampil();
        int a=listBarang.size()-1;
        int no=Integer.parseInt(listBarang.get(a).getNojual().replace("NOTA-", ""))+1;
        txtnojual.setText("NOTA-"+no);
        txtnojual.setEnabled(false);
    }
    

    
    void cetak_nota(){
        try {
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("nota", txtnojual.getText());
            File file = new File("src/laporan/struk.jrxml");
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost:3306/scashier", "root", "");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null,
                    "Gagal Menampilkan Laporan: \n"+ exc.getMessage());
        }
    }
    
    private void tgl(){
        Date date = new Date();
        tanggalTF.setDate(date);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnojual = new javax.swing.JTextField();
        bttambah = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtkonsumen = new javax.swing.JTextField();
        tanggalTF = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        txtnm_brg = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtjumlah = new javax.swing.JTextField();
        txttot = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btsimpanitem = new javax.swing.JButton();
        bthapusitem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtkode = new javax.swing.JTextField();
        caribrg = new javax.swing.JButton();
        stockTF = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbljual = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtkembali = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtbayar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        btsimpan = new javax.swing.JButton();
        btkeluar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Tramsaksi");

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setText("No Jual");

        jLabel2.setText("Tanggal");

        txtnojual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnojualActionPerformed(evt);
            }
        });

        bttambah.setText("Tambah");
        bttambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttambahActionPerformed(evt);
            }
        });

        jLabel14.setText("Nama Konsumen");

        txtkonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkonsumenActionPerformed(evt);
            }
        });

        tanggalTF.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggalTFPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel14))
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tanggalTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addComponent(txtkonsumen, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtnojual, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(bttambah)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnojual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tanggalTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtkonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        txtnm_brg.setEditable(false);

        txtharga.setEditable(false);
        txtharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaActionPerformed(evt);
            }
        });

        txtjumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahActionPerformed(evt);
            }
        });

        txttot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotActionPerformed(evt);
            }
        });
        txttot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttotKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Data Barang");

        btsimpanitem.setText("Tambah Item");
        btsimpanitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsimpanitemActionPerformed(evt);
            }
        });

        bthapusitem.setText("Hapus Item");
        bthapusitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthapusitemActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Jumlah");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel12.setText("*tekan enter");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel13.setText("*tekan enter");

        txtkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodeActionPerformed(evt);
            }
        });
        txtkode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtkodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtkodeKeyReleased(evt);
            }
        });

        caribrg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Cari2.png"))); // NOI18N
        caribrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caribrgActionPerformed(evt);
            }
        });

        stockTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stockTFKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Stock");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Nama Barang");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Harga");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caribrg))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtnm_brg, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12))
                        .addGap(27, 27, 27))
                    .addComponent(txtjumlah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(stockTF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txttot, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btsimpanitem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bthapusitem))
                            .addComponent(jLabel13)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(caribrg)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnm_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btsimpanitem)
                            .addComponent(bthapusitem)
                            .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stockTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbljual.setModel(new javax.swing.table.DefaultTableModel(
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
        tbljual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbljualMouseClicked(evt);
            }
        });
        tbljual.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbljualAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tbljual);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Detail Barang");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));

        txtkembali.setEditable(false);
        txtkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkembaliActionPerformed(evt);
            }
        });
        txtkembali.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtkembaliKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Kembalian");

        txtbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbayarActionPerformed(evt);
            }
        });
        txtbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbayarKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Bayar");

        Total.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Total.setText("Total");

        txttotal.setEditable(false);
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        txttotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttotalKeyReleased(evt);
            }
        });

        btsimpan.setText("Simpan");
        btsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsimpanActionPerformed(evt);
            }
        });

        btkeluar.setText("Keluar");
        btkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btkeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(752, 752, 752)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(Total))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btsimpan)
                    .addComponent(btkeluar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("Transaksi Penjualan");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(390, 390, 390))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btkeluarActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btkeluarActionPerformed

    private void bttambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttambahActionPerformed
    
    if(bttambah.getText().equalsIgnoreCase("tambah")){
            bttambah.setText("Batal");
            bersih();
            siapIsi(true);
            buatNoJual();          
            bttambah.setEnabled(true);
            
        } else{
            bttambah.setText("Tambah");
            bersih();
            siapIsi(true);
          
        }
        
    aktif(true);
    setTombol(true);
    
    }//GEN-LAST:event_bttambahActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void btsimpanitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsimpanitemActionPerformed
        simpan_ditabel();
        txtkode.setText("");
        txtnm_brg.setText("");
        txtharga.setText("");
        txtjumlah.setText("");
        stockTF.setText("");
        txttot.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_btsimpanitemActionPerformed

    private void btsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsimpanActionPerformed
        try{
            setkoneksi();
//            int xidjual = 0;
            String xnojual=txtnojual.getText();
//            format_tanggal();  
            String xkonsumen = txtkonsumen.getText();
            String xtotal=txttotal.getText();
            String xbayar=txtbayar.getText();
            String xkembalian=txtkembali.getText();
         
            String msql="insert into penjualan values('"+xnojual+"','"+tgl+"','"+xkonsumen+"','"+xtotal+"','"+xbayar+"','"+xkembalian+"')";
            st.executeUpdate(msql);
            
            

            int t = tbljual.getRowCount();
            for(int i=0; i < t ; i++)
            {
                int xiddjual = 0;
                String xkd  = tbljual.getValueAt(i,0).toString();
                String xhrg = tbljual.getValueAt(i,2).toString();
                String xjml = tbljual.getValueAt(i,3).toString();
                
                
                String zsql="insert into djual values('"+xiddjual+"','"+xnojual+"','"+xkd+"','"+xhrg+"','"+xjml+"')";
                st.executeUpdate(zsql);
                
               
            }
            
            //Con.close();
            JOptionPane.showMessageDialog(null,"Transaksi tersimpan sukses"); 
            int pesan=JOptionPane.showConfirmDialog(null, "Cetak Kwitansi Nota","Cetak",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
               
            if(pesan==JOptionPane.YES_OPTION){
                   cetak_nota();
               }else {
                   JOptionPane.showMessageDialog(null, "Simpan Transaksi Berhasil");
               }
            setTombol(false);
            txtnojual.setText("");
            txtkonsumen.setText("");
            txtkode.setText("");
            txtnm_brg.setText("");
            txtharga.setText("");
            txtjumlah.setText("");
            stockTF.setText("");
            txttot.setText("");
            txttotal.setText("");
            txtbayar.setText("");
            txtkembali.setText("");
            tbljual.selectAll();
            tbljual.clearSelection();
            tableModel.removeRow(row);
        }
        catch(SQLException e)
        {
            System.out.println("Error : "+e);
            JOptionPane.showMessageDialog(null,"Transaksi gagal tersimpan");
            setTombol(false);
            txtnojual.setText("");
            txtkonsumen.setText("");
            txtkode.setText("");
            txtnm_brg.setText("");
            txtharga.setText("");
            txtjumlah.setText("");
            stockTF.setText("");
            txttot.setText("");
            txttotal.setText("");
            txtbayar.setText("");
            txtkembali.setText("");
            tbljual.selectAll();
            tbljual.clearSelection();
            tableModel.removeRow(row);
        }
    }//GEN-LAST:event_btsimpanActionPerformed

    private void bthapusitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthapusitemActionPerformed
        tableModel.removeRow(row);
        total_harga();
    }//GEN-LAST:event_bthapusitemActionPerformed

    private void txttotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotActionPerformed
        hitung_jual();  
    }//GEN-LAST:event_txttotActionPerformed

    private void txthargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaActionPerformed

    private void txtbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbayarActionPerformed
        double xtot,xhrg,xjml;
        xhrg=Double.parseDouble(txttotal.getText());
        xjml=Double.parseDouble(txtbayar.getText());
        xtot=xjml-xhrg;
        String xtotal=Double.toString(xtot);
        txtkembali.setText(xtotal);   // TODO add your handling code here:
    }//GEN-LAST:event_txtbayarActionPerformed

    private void txttotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalKeyReleased
        if (evt.getKeyCode() == 10){
        txtbayar.requestFocus();}
         // TODO add your handling code here:
    }//GEN-LAST:event_txttotalKeyReleased

    private void txtbayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbayarKeyReleased
        if (evt.getKeyCode() == 10){
        txtkembali.requestFocus();}

         // TODO add your handling code here:
    }//GEN-LAST:event_txtbayarKeyReleased

    private void txtkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkembaliActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_txtkembaliActionPerformed

    private void txtkembaliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkembaliKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkembaliKeyReleased

    private void txtnojualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnojualActionPerformed
    int no,x,y;
    x=00000000;
    y=1;
    no=x+y;
    String nojual=Integer.toString(no);
    txtnojual.setText(nojual);// TODO add your handling code here:
    }//GEN-LAST:event_txtnojualActionPerformed

    private void txtjumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahActionPerformed
        double xtot,xhrg,xjml;
        int stock;
        xhrg=Double.parseDouble(txtharga.getText());
        xjml=Double.parseDouble(txtjumlah.getText());
        stock=Integer.parseInt(stockTF.getText());
        if(xjml>stock){
            JOptionPane.showMessageDialog(null, "Stok barang tidak mencukupi");
             
        }else{
            xtot=xjml*xhrg;
            String xsubtotal=Double.toString(xtot);
            txttot.setText(xsubtotal);
        }
        
        
    }//GEN-LAST:event_txtjumlahActionPerformed

    private void txttotKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotKeyReleased
        if (evt.getKeyCode() == 10){
            txttot.requestFocus();}
    }//GEN-LAST:event_txttotKeyReleased

    private void tbljualAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbljualAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbljualAncestorAdded

    private void tbljualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbljualMouseClicked
        if (evt.getClickCount() ==1){
            // tampil();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbljualMouseClicked

    private void caribrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caribrgActionPerformed
        boolean closable = true;
        brg fDB = new brg(null, closable);
        fDB.fAB = this;
        fDB.setVisible(true);
        fDB.setResizable(true);
        txtkode.setText(Kodeba);
        txtnm_brg.setText(Namaba);
        txtharga.setText(Hargaju);
        stockTF.setText(stock);
    }//GEN-LAST:event_caribrgActionPerformed

    private void stockTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockTFKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_stockTFKeyReleased

    private void txtkodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkodeKeyPressed
        // TODO add your handling code here:
        try{
            setkoneksi();
            rs=st.executeQuery("SELECT *from barang where KodeBarang='" + txtkode.getText() + "'");
            
            if (rs.next());
            txtkode.setText(rs.getString("KodeBarang"));
            
            stockTF.setText(rs.getString("Stock"));
             } catch (Exception e) {
        }
    }//GEN-LAST:event_txtkodeKeyPressed

    private void txtkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodeActionPerformed

    private void txtkodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkodeKeyReleased
        // TODO add your handling code here:
        try{
            setkoneksi();
            rs=st.executeQuery("SELECT *from barang where KodeBarang='" + txtkode.getText() + "'");
            
            if (rs.next());
            txtkode.setText(rs.getString("KodeBarang"));
            
            stockTF.setText(rs.getString("Stock"));
             } catch (Exception e) {
        }
    }//GEN-LAST:event_txtkodeKeyReleased

    private void tanggalTFPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggalTFPropertyChange
        try{
            if(tanggalTF.getDate()!=null){
                String pattern="yyyy-MM-dd";
                SimpleDateFormat format =new SimpleDateFormat(pattern);
                tgl=String.valueOf(format.format(tanggalTF.getDate()));
            }
        }catch(Exception e){

        }
    }//GEN-LAST:event_tanggalTFPropertyChange

    private void txtkonsumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkonsumenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkonsumenActionPerformed
 
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FormTransaksi().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Total;
    private javax.swing.JButton bthapusitem;
    private javax.swing.JButton btkeluar;
    private javax.swing.JButton btsimpan;
    private javax.swing.JButton btsimpanitem;
    private javax.swing.JButton bttambah;
    private javax.swing.JButton caribrg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField stockTF;
    private com.toedter.calendar.JDateChooser tanggalTF;
    private javax.swing.JTable tbljual;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkembali;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtkonsumen;
    private javax.swing.JTextField txtnm_brg;
    private javax.swing.JTextField txtnojual;
    private javax.swing.JTextField txttot;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables

    private void aktif(boolean x) {
      txtnojual.setEditable(x);
      tanggalTF.setEnabled(x);
      txtkode.setEnabled(x);
      txtnm_brg.setEnabled(x);
      txtjumlah.setEditable(x);
      txtharga.setEnabled(x);      
      txttotal.setEnabled(x);
    }

    private void setTombol(boolean t) {
        btsimpan.setEnabled(t); 
        btsimpanitem.setEnabled(t);
        bthapusitem.setEnabled(t);
    }

    private void setkoneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/scashier","root","");
            st = (Statement) conn.createStatement();

        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Koneksi gagal");
            System.out.println(e.getMessage());
        }
    }

    private void inisialisasi_tabel() {
        tbljual.setModel(tableModel);
    }

    private void hitung_jual() {
        double xtot,xhrg;
        int xjml;
        xhrg=Double.parseDouble(txtharga.getText());
        xjml=Integer.parseInt(txtjumlah.getText());
        xtot=xhrg*xjml;
        String xtotal=Double.toString(xtot);
        txttot.setText(xtotal);
        total=total+xtot;
        txttotal.setText(Double.toString(total));
    }

private void cekstock(){
        try{
            setkoneksi();
            rs=st.executeQuery("SELECT *from barang where KodeBarang='" + txtkode.getText() + "'");
            
            if (rs.next());
            txtkode.setText(rs.getString("KodeBarang"));
            
            stockTF.setText(rs.getString("Stock"));
        } catch (Exception e) {
            
        }
    }
    
    private void total_harga() {
        double tothrg = 0;
        int jumrec = tbljual.getRowCount();
        for (int i=0;i<jumrec;i++){
            tothrg = tothrg + Double.parseDouble(txttot.getText().toString()); 
        }
        txttotal.setText(String.valueOf(tothrg)); 
    }

    private void simpan_ditabel() {
        try{
            String tKode=txtkode.getText();
            String tNama=txtnm_brg.getText();
            double hrg=Double.parseDouble(txtharga.getText());
            int jml=Integer.parseInt(txtjumlah.getText());
            double tot=Double.parseDouble(txttot.getText());
            tableModel.addRow(new Object[]{tKode,tNama,hrg,jml,tot});
            inisialisasi_tabel();
        } catch(Exception e) {
            System.out.println("Error : "+e);
        }
    }

    private void format_tanggal() {
        String DATE_FORMAT = "yyyy-MM-dd";
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        int year=c1.get(Calendar.YEAR);
        int month=c1.get(Calendar.MONTH)+1;
        int day=c1.get(Calendar.DAY_OF_MONTH);
        tanggal=Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day);
    }


}