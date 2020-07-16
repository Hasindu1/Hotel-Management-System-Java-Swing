/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplierManagement;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import databaseConnectivity.DBHandler;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import loginnav.loginnav;
import userLoginFunction.Login;
import userLoginFunction.SplashView;

public class SupplierManagementFunction extends javax.swing.JFrame {
    public static  boolean homeStatus;
      private ImageIcon img ;
    /**
     * Creates new form NewJFrame
     */
    private Connection connection = DBHandler.getDBConnection();

    public SupplierManagementFunction() {
        initComponents();
           img= new ImageIcon(getClass().getResource("/icons/HotelManager.png"));
        this.setIconImage(img.getImage());
        showDate();
        showTime();
        jTextField25.setVisible(false);
        jLabel4.setVisible(false);
        jTextField26.setVisible(false);
        jLabel5.setVisible(false);
        jLabel3.setVisible(false);
        jButton17.setVisible(false);
          displayHome();
        
        
        
        
        
        
         CardLayout c1 = (CardLayout) jPanel1.getLayout();
        c1.show(jPanel1, "card7");
        
    }
     public void displayHome(){
        if(homeStatus){
            jButton17.setVisible(true);
        }
    }
    
    

    void ViewPanel(String cname){
        
        CardLayout c1 = (CardLayout)jPanel1.getLayout();
        c1.show(jPanel1, cname);
    }
    
    public void showDate(){
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-YYYY");
        jLabel45.setText(s.format(d));

    }
    
    public void showTime(){
        new Timer(0,new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh : mm : ss a");
                
            jLabel47.setText(s.format(d));

            }
    }).start();
    }
    private void displayItemName(){
           // ADD ORDER - to get item name automatically
        try{
            PreparedStatement ps;
            ps = connection.prepareStatement("select name from SUPPLIERITEMS where ITEMCODE=?");
            ps.setString(1, jTextField16.getText());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String s = rs.getString(1);
                
                jTextField14.setText(s);
            }
        }catch(SQLException ex){
            Logger.getLogger(SupplierManagementFunction.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
         
           
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel11 = new javax.swing.JLabel();
        ITProjectPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("HotelManagementSystemPU").createEntityManager();
        supplierdetailsQuery = java.beans.Beans.isDesignTime() ? null : ITProjectPUEntityManager.createQuery("SELECT s FROM Supplierdetails s");
        supplierdetailsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : supplierdetailsQuery.getResultList();
        supplierdetailsQuery1 = java.beans.Beans.isDesignTime() ? null : ITProjectPUEntityManager.createQuery("SELECT s FROM Supplierdetails s");
        supplierdetailsList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : supplierdetailsQuery1.getResultList();
        orderdetailsQuery = java.beans.Beans.isDesignTime() ? null : ITProjectPUEntityManager.createQuery("SELECT o FROM Orderdetails o");
        orderdetailsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : orderdetailsQuery.getResultList();
        orderdetailsQuery1 = java.beans.Beans.isDesignTime() ? null : ITProjectPUEntityManager.createQuery("SELECT o FROM Orderdetails o");
        orderdetailsList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : orderdetailsQuery1.getResultList();
        orderdetailsQuery2 = java.beans.Beans.isDesignTime() ? null : ITProjectPUEntityManager.createQuery("SELECT o FROM Orderdetails o");
        orderdetailsList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : orderdetailsQuery2.getResultList();
        jPanel3 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        AddOrder = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        UpdateDeleteOrder = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jTextField15 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        AddSupplier = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        UpdateDeleteSupplier = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        Reports = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jPanel26 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        btnPDF = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel57 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("   Management");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(54, 33, 89));
        jPanel3.setPreferredSize(new java.awt.Dimension(2205, 154));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("jLabel45");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("jLabel47");

        jButton15.setBackground(new java.awt.Color(85, 68, 118));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Log Out");

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 80)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("H o t e l K a b a l a n a");

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Matara Rd, Ahangama 80650");

        jPanel13.setPreferredSize(new java.awt.Dimension(906, 8));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 906, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel14.setPreferredSize(new java.awt.Dimension(8, 0));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo (1).png"))); // NOI18N
        jLabel68.setText("jLabel68");

        jButton16.setBackground(new java.awt.Color(54, 33, 89));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("LogOut");
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton16MouseClicked(evt);
            }
        });
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(54, 33, 89));
        jButton17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Home");
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton17MouseClicked(evt);
            }
        });
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 482, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel45)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel47)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 1009));

        jPanel8.setBackground(new java.awt.Color(85, 68, 118));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Generate Reports");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ReportsFinal.png"))); // NOI18N
        jLabel17.setText("jLabel17");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(85, 68, 118));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Add Supplier");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/SupplierIcon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(85, 68, 118));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Add Order");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddOrderFinal.png"))); // NOI18N
        jLabel15.setText("jLabel15");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        jPanel12.setBackground(new java.awt.Color(85, 68, 118));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Update & Delete Order");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/DeleteOrderFinal.png"))); // NOI18N
        jLabel16.setText("jLabel16");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(85, 68, 118));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Update & Delete Supplier");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/RemoveSupplierFinal.png"))); // NOI18N
        jLabel14.setText("jLabel14");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(240, 240, 240));
        jLabel65.setText("Management");

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(240, 240, 240));
        jLabel69.setText("Supplier");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel65)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel23.setBackground(new java.awt.Color(204, 204, 204));
        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel35.setText("Supplier ID");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel36.setText("Order Date");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel37.setText("Item Code");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel38.setText("Quantity");

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setText("INSERT");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setText("CLEAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField16KeyReleased(evt);
            }
        });

        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable6, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.quantity}"), jTextField17, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel50.setText("Unit Price");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel48.setText("Total");

        jTextField23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable6, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.unitprice}"), jTextField23, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });
        jTextField23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField23KeyReleased(evt);
            }
        });

        jTextField24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable6, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.total}"), jTextField24, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField24MouseClicked(evt);
            }
        });
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });
        jTextField24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField24KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setText("Add New Order");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Order ID");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable6, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.orderid}"), jTextField26, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable6, org.jdesktop.beansbinding.ELProperty.create("${selectedElement_IGNORE_ADJUSTING.supplierid.supplierid}"), jTextField5, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel32.setText("Item Name");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel12.setText("Supplier Name");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel35))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)))
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                .addComponent(jTextField26, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel48)
                            .addComponent(jLabel50)
                            .addComponent(jLabel32)
                            .addComponent(jLabel38))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(97, 97, 97)
                .addComponent(jButton6)
                .addGap(141, 141, 141))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(47, 47, 47)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(43, 43, 43)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel50)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addGap(69, 69, 69))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jTable6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, orderdetailsList2, jTable6);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderid}"));
        columnBinding.setColumnName("Orderid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${supplierid}"));
        columnBinding.setColumnName("Supplierid");
        columnBinding.setColumnClass(supplierManagement.Supplierdetails.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderdate}"));
        columnBinding.setColumnName("Orderdate");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemcode}"));
        columnBinding.setColumnName("Itemcode");
        columnBinding.setColumnClass(supplierManagement.Supplieritems.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${unitprice}"));
        columnBinding.setColumnName("Unitprice");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${total}"));
        columnBinding.setColumnName("Total");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Itemcode", "Itemname", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton12.setText("Refresh");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel70.setText("Order Requests");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel70)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton12)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AddOrderLayout = new javax.swing.GroupLayout(AddOrder);
        AddOrder.setLayout(AddOrderLayout);
        AddOrderLayout.setHorizontalGroup(
            AddOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddOrderLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(448, Short.MAX_VALUE))
        );
        AddOrderLayout.setVerticalGroup(
            AddOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddOrderLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(AddOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        jPanel1.add(AddOrder, "card2");

        jPanel22.setBackground(new java.awt.Color(204, 204, 204));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel40.setText("Supplier ID");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel41.setText("Order Date");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel42.setText("Item Code");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel43.setText("Quantity");

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setText("UPDATE");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton10.setText("DELETE");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable7, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.supplierid.supplierid}"), jTextField15, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField15KeyReleased(evt);
            }
        });

        jTextField18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable7, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.itemcode.itemcode}"), jTextField18, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });
        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField18KeyReleased(evt);
            }
        });

        jTextField19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable7, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.quantity}"), jTextField19, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel44.setText("Unit Price");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel46.setText("Order ID");

        jTextField20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable7, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.orderid}"), jTextField20, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });

        jTextField21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable7, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.unitprice}"), jTextField21, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });
        jTextField21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField21KeyReleased(evt);
            }
        });

        jTextField22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable7, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.total}"), jTextField22, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField22MouseClicked(evt);
            }
        });
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });
        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField22KeyReleased(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel39.setText("Update & Delete Order Details ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Total");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("CLEAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel33.setText("Item Name");

        jTextField29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField29ActionPerformed(evt);
            }
        });
        jTextField29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField29KeyReleased(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel34.setText("Supplier Name");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel44)
                            .addComponent(jLabel43)
                            .addComponent(jLabel33)
                            .addComponent(jLabel42)
                            .addComponent(jLabel41)
                            .addComponent(jLabel34)
                            .addComponent(jLabel40)
                            .addComponent(jLabel46))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField20)
                            .addComponent(jTextField15)
                            .addComponent(jTextField32)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(jTextField18)
                            .addComponent(jTextField29)
                            .addComponent(jTextField19)
                            .addComponent(jTextField21)
                            .addComponent(jTextField22)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addGap(48, 48, 48)
                        .addComponent(jButton10)
                        .addGap(56, 56, 56)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addGap(20, 20, 20)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel41)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton4))
                .addGap(111, 111, 111))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jTable7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, orderdetailsList2, jTable7);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderid}"));
        columnBinding.setColumnName("Orderid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${supplierid}"));
        columnBinding.setColumnName("Supplierid");
        columnBinding.setColumnClass(supplierManagement.Supplierdetails.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${supplierid.firstname}"));
        columnBinding.setColumnName("SupplierName");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderdate}"));
        columnBinding.setColumnName("Orderdate");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemcode}"));
        columnBinding.setColumnName("Itemcode");
        columnBinding.setColumnClass(supplierManagement.Supplieritems.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemcode.name}"));
        columnBinding.setColumnName("ItemName");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${unitprice}"));
        columnBinding.setColumnName("Unitprice");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${total}"));
        columnBinding.setColumnName("Total");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable7);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout UpdateDeleteOrderLayout = new javax.swing.GroupLayout(UpdateDeleteOrder);
        UpdateDeleteOrder.setLayout(UpdateDeleteOrderLayout);
        UpdateDeleteOrderLayout.setHorizontalGroup(
            UpdateDeleteOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateDeleteOrderLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(460, Short.MAX_VALUE))
        );
        UpdateDeleteOrderLayout.setVerticalGroup(
            UpdateDeleteOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateDeleteOrderLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(UpdateDeleteOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(256, Short.MAX_VALUE))
        );

        jPanel1.add(UpdateDeleteOrder, "card3");

        jPanel28.setBackground(new java.awt.Color(204, 204, 204));
        jPanel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel28.setPreferredSize(new java.awt.Dimension(846, 655));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setText("Supplier NIC");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel20.setText("First Name");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel21.setText("Last Name");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel22.setText("Contact Number");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel23.setText("E-mail");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel24.setText("Company Name");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel18.setText("Add New Supplier");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nic}"), jTextField6, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.firstname}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.lastname}"), jTextField2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.contactnumber}"), jTextField3, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Supplier ID");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.supplierid}"), jTextField25, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton13.setText("INSERT");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton14.setText("CLEAR");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.companyname}"), jTextField27, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.email}"), jTextField28, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField28ActionPerformed(evt);
            }
        });
        jTextField28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField28KeyReleased(evt);
            }
        });

        jLabel59.setForeground(new java.awt.Color(204, 0, 0));

        jLabel60.setForeground(new java.awt.Color(204, 0, 0));

        jLabel61.setForeground(new java.awt.Color(204, 0, 0));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("*please fill all fields");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(8, 8, 8))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 65, Short.MAX_VALUE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel24)
                                .addComponent(jLabel22)))
                        .addGap(263, 356, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton13)
                        .addGap(119, 119, 119)
                        .addComponent(jButton14)
                        .addGap(105, 105, 105))))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(44, 44, 44)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jButton14))
                .addGap(118, 118, 118))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, supplierdetailsList1, jTable4);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${supplierid}"));
        columnBinding.setColumnName("Supplierid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nic}"));
        columnBinding.setColumnName("Nic");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstname}"));
        columnBinding.setColumnName("Firstname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastname}"));
        columnBinding.setColumnName("Lastname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contactnumber}"));
        columnBinding.setColumnName("Contactnumber");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${companyname}"));
        columnBinding.setColumnName("Companyname");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane4.setViewportView(jTable4);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel25.setText("Search by Supplier ID");

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel25)
                .addGap(57, 57, 57)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout AddSupplierLayout = new javax.swing.GroupLayout(AddSupplier);
        AddSupplier.setLayout(AddSupplierLayout);
        AddSupplierLayout.setHorizontalGroup(
            AddSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddSupplierLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(389, Short.MAX_VALUE))
        );
        AddSupplierLayout.setVerticalGroup(
            AddSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddSupplierLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(AddSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(221, Short.MAX_VALUE))
        );

        jPanel1.add(AddSupplier, "card5");

        jPanel24.setBackground(new java.awt.Color(204, 204, 204));
        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel26.setText("Supplier ID");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel28.setText("Supplier NIC");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel29.setText("First Name");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel30.setText("Last Name");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel31.setText("Contact Number");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel49.setText("E-mail");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel51.setText("Company Name");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("DELETE");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable5, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nic}"), jTextField7, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable5, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.firstname}"), jTextField8, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable5, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.lastname}"), jTextField9, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable5, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.contactnumber}"), jTextField10, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
        });

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable5, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.email}"), jTextField11, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
        });

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable5, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.companyname}"), jTextField12, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable5, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.supplierid}"), jTextField13, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel52.setText("Update & Delete Supplier Details");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("CLEAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel62.setForeground(new java.awt.Color(204, 0, 0));

        jLabel63.setForeground(new java.awt.Color(204, 0, 0));

        jLabel64.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel30))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel62)
                                    .addComponent(jLabel63)
                                    .addComponent(jLabel64)))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jButton1)
                                .addGap(55, 55, 55)
                                .addComponent(jButton2)
                                .addGap(43, 43, 43)
                                .addComponent(jButton3)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel52)
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel62)
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel63)
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel64)
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel51)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(165, 165, 165))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jTable5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, supplierdetailsList1, jTable5);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${supplierid}"));
        columnBinding.setColumnName("Supplierid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nic}"));
        columnBinding.setColumnName("Nic");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstname}"));
        columnBinding.setColumnName("Firstname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastname}"));
        columnBinding.setColumnName("Lastname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contactnumber}"));
        columnBinding.setColumnName("Contactnumber");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${companyname}"));
        columnBinding.setColumnName("Companyname");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane5.setViewportView(jTable5);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel27.setText("Search by SupplierID");

        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton8.setText("Search");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(38, 38, 38)
                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton8))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout UpdateDeleteSupplierLayout = new javax.swing.GroupLayout(UpdateDeleteSupplier);
        UpdateDeleteSupplier.setLayout(UpdateDeleteSupplierLayout);
        UpdateDeleteSupplierLayout.setHorizontalGroup(
            UpdateDeleteSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateDeleteSupplierLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(647, Short.MAX_VALUE))
        );
        UpdateDeleteSupplierLayout.setVerticalGroup(
            UpdateDeleteSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateDeleteSupplierLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(UpdateDeleteSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(284, Short.MAX_VALUE))
        );

        jPanel1.add(UpdateDeleteSupplier, "card6");

        jPanel25.setBackground(new java.awt.Color(204, 204, 204));
        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel53.setText("Monthly Expenditure Amount");

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton11.setText("Generate Expenditure");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel55.setText("Start Date");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel56.setText("End Date");

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel58.setText("Total expenditure for the selected time period ");

        jTextField33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel56))
                    .addComponent(jLabel58))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addComponent(jButton11)
                        .addGap(315, 315, 315))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addGap(26, 26, 26))))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel53)
                .addGap(54, 54, 54)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(jLabel55)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jButton11)
                .addGap(37, 37, 37)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel26.setBackground(new java.awt.Color(204, 204, 204));
        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel54.setText("Supplier Report View");

        btnPDF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPDF.setText("Generate Supplier Report View");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, supplierdetailsList1, jTable1);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${supplierid}"));
        columnBinding.setColumnName("Supplierid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nic}"));
        columnBinding.setColumnName("Nic");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstname}"));
        columnBinding.setColumnName("Firstname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastname}"));
        columnBinding.setColumnName("Lastname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contactnumber}"));
        columnBinding.setColumnName("Contactnumber");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${companyname}"));
        columnBinding.setColumnName("Companyname");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel57.setText("Total Number of suppliers");

        jTextField34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField34ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel57)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel54))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel54)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout ReportsLayout = new javax.swing.GroupLayout(Reports);
        Reports.setLayout(ReportsLayout);
        ReportsLayout.setHorizontalGroup(
            ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(306, Short.MAX_VALUE))
        );
        ReportsLayout.setVerticalGroup(
            ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportsLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        jPanel1.add(Reports, "card8");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //update supplier
        
        String supplierNIC = jTextField7.getText().toString();
        String firstName = jTextField8.getText().toString();
        String lastName = jTextField9.getText().toString();
        String contactnumber = jTextField10.getText().toString();
        String email = jTextField11.getText().toString();
        String companyname = jTextField12.getText().toString();
        
        if(supplierNIC.equals("")){
            JOptionPane.showMessageDialog(rootPane, "NIC is mandotory");
        }else if(firstName.equals("")){
            JOptionPane.showMessageDialog(rootPane, "First Name is mandotory");   
        }else if(lastName.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Last Name is mandotory"); 
        }else if(contactnumber.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Contact Number is mandotory"); 
        }else if(email.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Email is mandotory"); 
        }else if(companyname.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Company Name is mandotory"); 
        }
        
        else{

        try{
           
            String sql = "UPDATE SUPPLIERDETAILS SET NIC = ?, FIRSTNAME = ?, LASTNAME = ?, CONTACTNUMBER = ?, EMAIL = ?, COMPANYNAME = ? WHERE SUPPLIERID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, jTextField7.getText());
            statement.setString(2, jTextField8.getText());
            statement.setString(3, jTextField9.getText());
            statement.setString(4, jTextField10.getText());
            statement.setString(5, jTextField11.getText());
            statement.setString(6, jTextField12.getText());
            statement.setInt(7,Integer.parseInt(jTextField13 .getText()));
            statement.executeUpdate();
             JOptionPane.showMessageDialog(rootPane,"Update successfully","Info",1); 
             
             //refreshTable(suplierdetailsList1)
             String sql2 = "SELECT * FROM SUPPLIERDETAILS";
             PreparedStatement statement1 = connection.prepareStatement(sql2);
             ResultSet rs = statement1.executeQuery();
             supplierdetailsList1.clear();
             
             while (rs.next()){
                 Supplierdetails sup1 = new Supplierdetails();
                 sup1.setSupplierid(rs.getInt(1));
                 sup1.setNic(rs.getString(2));
                 sup1.setFirstname(rs.getString(3));
                 sup1.setLastname(rs.getString(4));
                 sup1.setContactnumber(rs.getString(5));
                 sup1.setEmail(rs.getString(6));
                 sup1.setCompanyname(rs.getString(7));
                 
                 
                 
                 supplierdetailsList1.add(sup1);
             }
             refreshTable1( supplierdetailsList1);
             
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        }
        
    
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // Delete Order Details
         // Delete Order Details
         try{
              String sql = "DELETE FROM ORDERDETAILS WHERE supplierid =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,Integer.parseInt(jTextField15 .getText()));
        statement.executeUpdate();
             
         }catch(Exception e)
         {
             System.err.println("error in delelete try first try  " + e);
         }
         try{
             
        String sql = "DELETE FROM supplierdetails WHERE supplierid =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,Integer.parseInt(jTextField15 .getText()));
        statement.executeUpdate();
             
         }catch(Exception e){
              System.out.println("error in supplierdetails first " + e);
         }
         
          try{
             
        String sql = "DELETE FROM supplieritems WHERE itemcode =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,Integer.parseInt(jTextField18 .getText()));
        statement.executeUpdate();
             
         }catch(Exception e){
              System.out.println("error in supplier items  " + e);
         }
         
        try{
        String sql = "DELETE FROM ORDERDETAILS WHERE ORDERID =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,Integer.parseInt(jTextField20 .getText()));
        statement.executeUpdate();
        
      
    }    
        
        catch(Exception e){
            System.out.println("erro in orderdetails dele last " + e);
        }
          try{ String sql2 = "SELECT * FROM ORDERDETAILS";
             PreparedStatement statement1 = connection.prepareStatement(sql2);
             ResultSet rs = statement1.executeQuery();
             orderdetailsList2.clear();
             
             while (rs.next()){
                 Orderdetails ord1 = new Orderdetails();
                 ord1.setOrderid(rs.getInt(1));
                 ord1.setOrderdate(rs.getDate(2));
                 ord1.setQuantity(rs.getInt(3));
                 ord1.setUnitprice(rs.getDouble(4));
                 ord1.setTotal(rs.getDouble(5));
                 Supplierdetails sup1 = new Supplierdetails();
                 
                 sup1.setSupplierid(rs.getInt(6));
                 ord1.setSupplierid(sup1);
                 
                 Supplieritems si = new Supplieritems(rs.getString(7));
                 ord1.setItemcode(si);
                 
                 
                 
                orderdetailsList2.add(ord1);
             }
             refreshTable2( orderdetailsList2);
          }catch(Exception e){
              System.out.println(e.getMessage());
          }
            
        
       JOptionPane.showMessageDialog(rootPane,"delete successfully","Info",1); 
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        //ADD NEW SUPPLIER
        if(jTextField25.getText().isEmpty() || jTextField6.getText().isEmpty() || jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || 
                jTextField3.getText().isEmpty() || jTextField28.getText().isEmpty() || jTextField27.getText().isEmpty()){
            jLabel3.setVisible(true);
        }
        
        String supplierNIC = jTextField6.getText().toString();
        String firstName = jTextField1.getText().toString();
        String lastName = jTextField2.getText().toString();
        String contactnumber = jTextField3.getText().toString();
        String email = jTextField28.getText().toString();
        String companyname = jTextField27.getText().toString();
        
        if(supplierNIC.equals("")){
            JOptionPane.showMessageDialog(rootPane, "NIC is mandotory");
        }else if(firstName.equals("")){
            JOptionPane.showMessageDialog(rootPane, "First Name is mandotory");   
        }else if(lastName.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Last Name is mandotory"); 
        }else if(contactnumber.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Contact Number is mandotory"); 
        }else if(email.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Email is mandotory"); 
        }else if(companyname.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Company Name is mandotory"); 
        }
        
        else{
         try {
             jLabel3.setVisible(true);
            
            //ADD NEW SUPPLIER insert
            String sql = "INSERT INTO SUPPLIERDETAILS(NIC,FIRSTNAME,LASTNAME,CONTACTNUMBER,EMAIL,COMPANYNAME)VALUES(?,?,?,?,?,?)";
            System.out.println("22");
            PreparedStatement statement = connection.prepareStatement(sql);
               
            System.out.println("33");
            //statement.setInt(1,Integer.parseInt(jTextField25 .getText()));
            statement.setString(1, jTextField6.getText());
            statement.setString(2, jTextField1.getText());
            System.out.println("44");
            statement.setString(3, jTextField2.getText());
            statement.setString(4, jTextField3.getText());
            System.out.println("55");
            statement.setString(5, jTextField28.getText());
            statement.setString(6, jTextField27.getText());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(rootPane,"Insert successfully","Info",1);
             
             
             
             String sql2 = "SELECT * FROM SUPPLIERDETAILS";
             PreparedStatement statement1 = connection.prepareStatement(sql2);
             ResultSet rs = statement1.executeQuery();
            
             supplierdetailsList1.clear();
             
             while (rs.next()){
                 Supplierdetails sup1 = new Supplierdetails();
                 sup1.setSupplierid(rs.getInt(1));
                 sup1.setNic(rs.getString(2));
                 sup1.setFirstname(rs.getString(3));
                 sup1.setLastname(rs.getString(4));
                 sup1.setContactnumber(rs.getString(5));
                 sup1.setEmail(rs.getString(6));
                 sup1.setCompanyname(rs.getString(7));
                 
                 
                 
                 supplierdetailsList1.add(sup1);
             }
             refreshTable1(supplierdetailsList1);
             
           
           
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            //ex.getMessage();
        }
        
    }
         
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        
       
        
    }//GEN-LAST:event_jButton5MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
        this.ViewPanel("card5");
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        // TODO add your handling code here:
        this.ViewPanel("card6");
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
        this.ViewPanel("card2");
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
         try{ String sql2 = "SELECT * FROM ORDERDETAILS";
             PreparedStatement statement1 = connection.prepareStatement(sql2);
             ResultSet rs = statement1.executeQuery();
             orderdetailsList2.clear();
             int count = 0;
             while (rs.next()){
                 Orderdetails ord1 = new Orderdetails();
                 ord1.setOrderid(rs.getInt(1));
                 ord1.setOrderdate(rs.getDate(2));
                 ord1.setQuantity(rs.getInt(3));
                 ord1.setUnitprice(rs.getDouble(4));
                 ord1.setTotal(rs.getDouble(5));
                 Supplierdetails sup1 = new Supplierdetails();
                 
                 sup1.setSupplierid(rs.getInt(6));
                 ord1.setSupplierid(sup1);
//                 String sql = "SELECT supplierName FROM SupplierDetails where supplierid=?";
//                 PreparedStatement pst = connection.prepareStatement(sql);
//                 pst.executeQuery();
//                 while(rs.next()){
//                     
//                 }
//                 jTable7.setValueAt(sql2, NORMAL);
                 
                 Supplieritems si = new Supplieritems(rs.getString(7));
                 ord1.setItemcode(si);
                 
                 
                 
                orderdetailsList2.add(ord1);
                count ++;
             }
             refreshTable2( orderdetailsList2);
         }catch(Exception e){
             System.out.println(e.getMessage());
         }
            
        this.ViewPanel("card3");
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        this.ViewPanel("card8");
        String count = String.valueOf(jTable1.getRowCount());
        jTextField34.setText(count);
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
      int i = jTable6.getSelectedRow();
////        Date a = orderdetailsList2.get(i).getOrderdate();
//       // jDateChooser1.setDate(a);
//        jTextField5.setText(jTable6.getValueAt(i,1).toString());
//        jDateChooser1.setDate((Date)jTable6.getValueAt(i,2));
         jTextField16.setText(jTable6.getValueAt(i,3).toString());
//         jTextField17.setText(jTable6.getValueAt(i,4).toString());
//         jTextField23.setText(jTable6.getValueAt(i,5).toString());
//         jTextField26.setText(jTable6.getValueAt(i,5).toString());
//         jTextField26.setText(jTable6.getValueAt(i,0).toString());
//         jTextField26.setText(jTable6.getValueAt(i,0).toString());
//         jTextField26.setText(jTable6.getValueAt(i,0).toString());
//         jTextField26.setText(jTable6.getValueAt(i,0).toString());
            displayItemName();
//        
        
    }//GEN-LAST:event_jTable6MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // Update Order Details
      
       
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // Delete Supplier Details
        
    }//GEN-LAST:event_jButton2MouseClicked

   void refreshTable1(List supplierdetailsList1){
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, supplierdetailsList1, jTable5);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${supplierid}"));
        columnBinding.setColumnName("Supplierid"); 
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nic}"));
        columnBinding.setColumnName("Nic");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstname}"));
        columnBinding.setColumnName("Firstname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastname}"));
        columnBinding.setColumnName("Lastname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contactnumber}"));
        columnBinding.setColumnName("Contactnumber");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${companyname}"));
        columnBinding.setColumnName("Companyname");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    
    
   }
    
    
   void refreshTable2(List orderdetailsList2){
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, orderdetailsList2, jTable6);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderid}"));
        columnBinding.setColumnName("Orderid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${supplierid}"));
        columnBinding.setColumnName("Supplierid");
        columnBinding.setColumnClass(supplierManagement.Supplierdetails.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderdate}"));
        columnBinding.setColumnName("Orderdate");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemcode}"));
        columnBinding.setColumnName("Itemcode");
        columnBinding.setColumnClass(supplierManagement.Supplieritems.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${unitprice}"));
        columnBinding.setColumnName("Unitprice");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${total}"));
        columnBinding.setColumnName("Total");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        
   
   }
    
    
    
    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
       
    }//GEN-LAST:event_jButton10MouseClicked

    private void jTextField21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyReleased
       
    }//GEN-LAST:event_jTextField21KeyReleased

    private void jTextField22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyReleased
         
    }//GEN-LAST:event_jTextField22KeyReleased

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        
        
    }//GEN-LAST:event_jButton13MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here: 
        clearfields();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void jTextField28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //supplier delete
        try{
        String sql = "DELETE FROM SUPPLIERDETAILS WHERE SUPPLIERID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,Integer.parseInt(jTextField13 .getText()));
        statement.executeUpdate();
        JOptionPane.showMessageDialog(rootPane,"Delete successfully","Info",1);
        
         String sql2 = "SELECT * FROM SUPPLIERDETAILS";
             PreparedStatement statement1 = connection.prepareStatement(sql2);
             ResultSet rs = statement1.executeQuery();
             supplierdetailsList1.clear();
             
             while (rs.next()){
                 Supplierdetails sup1 = new Supplierdetails();
                 sup1.setSupplierid(rs.getInt(1));
                 sup1.setNic(rs.getString(2));
                 sup1.setFirstname(rs.getString(3));
                 sup1.setLastname(rs.getString(4));
                 sup1.setContactnumber(rs.getString(5));
                 sup1.setEmail(rs.getString(6));
                 sup1.setCompanyname(rs.getString(7));
                 
                 
                 
                 supplierdetailsList1.add(sup1);
             }
             refreshTable1( supplierdetailsList1);
             
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
         //ADD Supplier clear button
        clearfields();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        //ADD ORDER
       
       
         try {
            //ADD NEW ORDER
            String sql = "INSERT INTO ORDERDETAILS(SUPPLIERID,ORDERDATE,ITEMCODE,QUANTITY,UNITPRICE,TOTAL)VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
                //statement.setInt(1,Integer.parseInt(jTextField25 .getText()));
            System.out.println("55");
            statement.setInt(1,Integer.parseInt(jTextField5 .getText()));
            System.out.println("55");
            java.sql.Date d1 = null;
            java.sql.Date sqldate = new java.sql.Date(jDateChooser1.getDate().getTime());
            statement.setDate(2, sqldate);
            statement.setString(3,(jTextField16 .getText()));
            statement.setDouble(4,Double.parseDouble(jTextField17 .getText()));
            statement.setDouble(5,Double.parseDouble(jTextField23 .getText()));
            statement.setDouble(6,Double.parseDouble(jTextField24 .getText()));
            
            statement.executeUpdate();
             JOptionPane.showMessageDialog(rootPane,"Insert successfully","Info",1);
             
              String sql2 = "SELECT * FROM ORDERDETAILS";
             PreparedStatement statement1 = connection.prepareStatement(sql2);
             ResultSet rs = statement1.executeQuery();
             orderdetailsList2.clear();
             
             while (rs.next()){
                 Orderdetails ord1 = new Orderdetails();
                 ord1.setOrderid(rs.getInt(1));
                 ord1.setOrderdate(rs.getDate(2));
                 ord1.setQuantity(rs.getInt(3));
                 ord1.setUnitprice(rs.getDouble(4));
                 ord1.setTotal(rs.getDouble(5));
                 Supplierdetails sup1 = new Supplierdetails();
                 
                 sup1.setSupplierid(rs.getInt(6));
                 ord1.setSupplierid(sup1);
                 
                 Supplieritems si = new Supplieritems(rs.getString(7));
                 ord1.setItemcode(si);
                 
                 
                 
                 
                orderdetailsList2.add(ord1);
             }
             refreshTable2( orderdetailsList2);
            
            
        } catch (Exception e) {
          
            System.out.println(e.getMessage());
        
         }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jTextField24KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField24KeyReleased
        
    }//GEN-LAST:event_jTextField24KeyReleased

    private void jTextField24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField24MouseClicked
        // Calculation
        int b = Integer.parseInt(jTextField17.getText());
        double c = Double.parseDouble(jTextField23.getText());
        jTextField24.setText(""+b*c);
    }//GEN-LAST:event_jTextField24MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // Update ORDER details
        
         
        try{
            String sql = "UPDATE ORDERDETAILS SET SUPPLIERID = ?, ORDERDATE = ?, ITEMCODE = ?, QUANTITY = ?, UNITPRICE = ?, TOTAL = ? WHERE ORDERID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1,Integer.parseInt(jTextField20 .getText()));
            statement.setInt(1,Integer.parseInt(jTextField15 .getText()));
            System.out.println("55");
            java.sql.Date d1 = null;
            java.sql.Date sqldate = new java.sql.Date(jDateChooser2.getDate().getTime());
            statement.setDate(2, sqldate);
            statement.setString(3,(jTextField18 .getText()));
            statement.setDouble(4,Double.parseDouble(jTextField19 .getText()));
            statement.setDouble(5,Double.parseDouble(jTextField21 .getText()));
            statement.setDouble(6,Double.parseDouble(jTextField22 .getText()));
            statement.setInt(7,Integer.parseInt(jTextField20 .getText()));
            
            
            statement.executeUpdate();
              
              String sql2 = "SELECT * FROM ORDERDETAILS";
             PreparedStatement statement1 = connection.prepareStatement(sql2);
             ResultSet rs = statement1.executeQuery();
             orderdetailsList2.clear();
             
             while (rs.next()){
                 Orderdetails ord1 = new Orderdetails();
                 ord1.setOrderid(rs.getInt(1));
                 ord1.setOrderdate(rs.getDate(2));
                 ord1.setQuantity(rs.getInt(3));
                 ord1.setUnitprice(rs.getDouble(4));
                 ord1.setTotal(rs.getDouble(5));
                 Supplierdetails sup1 = new Supplierdetails();
                 
                 sup1.setSupplierid(rs.getInt(6));
                 ord1.setSupplierid(sup1);
                 
                 Supplieritems si = new Supplieritems(rs.getString(7));
                 ord1.setItemcode(si);
                 
                 
                 
                orderdetailsList2.add(ord1);
             }
             refreshTable2( orderdetailsList2);
            
           
            JOptionPane.showMessageDialog(rootPane,"Update successfully","Info",1);
           
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // ADD SEARCH
        //jTextField4.getText();
      //  System.out.println("asd");
        try{
            int id = Integer.parseInt(jTextField4.getText()) ;
            String s = "SELECT * FROM SUPPLIERDETAILS WHERE SUPPLIERID = " +id+"";
            PreparedStatement ps = connection.prepareStatement(s);
            ResultSet rs = ps.executeQuery();
            
            supplierdetailsList1.clear();
           
            while(rs.next()){
                
                Supplierdetails sd = new Supplierdetails();
                sd.setSupplierid(rs.getInt(1));
                sd.setNic(rs.getString(2));
                sd.setFirstname(rs.getString(3));
                sd.setLastname(rs.getString(4));
                sd.setContactnumber(rs.getString(5));
                sd.setEmail(rs.getString(6));
                sd.setCompanyname(rs.getString(7));
            }
            refreshTable1(supplierdetailsList1);
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
      
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // Contact Number Validation
        String contactnumber = "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$";
        Pattern pattern1 = Pattern.compile(contactnumber);
        Matcher match1 = pattern1.matcher(jTextField3.getText());
        
        if(!(match1.matches())){
            jLabel60.setText("Invalid");
            
        }else{
            jLabel60.setText("");
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField29ActionPerformed

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         clearfields();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         clearfields();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField23KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField23KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23KeyReleased

    private void jTextField22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField22MouseClicked
        // Calculation
        int b = Integer.parseInt(jTextField19.getText());
        double c = Double.parseDouble(jTextField21.getText());
        jTextField22.setText(""+b*c);
    }//GEN-LAST:event_jTextField22MouseClicked

    private void jTextField29KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField29KeyReleased
       
    }//GEN-LAST:event_jTextField29KeyReleased

    private void jTextField18KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyReleased
         // UPDATE & DELETE ORDER - to get item name automatically
//        try{
//            PreparedStatement ps;
//            ps = connection.prepareStatement("select name from SUPPLIERITEMS where ITEMCODE=?");
//            ps.setString(1, jTextField18.getText());
//            ResultSet rs = ps.executeQuery();
//            
//            while(rs.next()){
//                String s = rs.getString(1);
//                
//                jTextField29.setText(s);
//            }
//        }catch(SQLException ex){
//            Logger.getLogger(SupplierManagementFunction.class.getName()).log(Level.SEVERE,null,ex);
//        }
 try{
            int id= Integer.parseInt(jTextField18.getText());
            
            PreparedStatement ps,ps1;
            ps = connection.prepareStatement("select FIRSTNAME from SUPPLIERDETAILS where SUPPLIERID=?");
            
            ps1 = connection.prepareStatement("select * from SUPPLIERITEMS WHERE ITEMCODE=?");
            ps1.setInt(1,Integer.parseInt(jTextField18.getText()));
            ResultSet rs1 =  ps1.executeQuery();
            boolean validation1= false;
            while(rs1.next()){
                validation1= true;
            }
            
           // int id2 = rs1.getInt(1);
           // rs1.next();
            
            if(!(validation1)){
                JOptionPane.showMessageDialog(rootPane,"Insert Valid item code","Info",1);
                
            }
            
            ps.setString(1, jTextField18.getText());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String s = rs.getString(1);
                
                jTextField29.setText(s);
            }
        }catch(SQLException ex){
            Logger.getLogger(SupplierManagementFunction.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }//GEN-LAST:event_jTextField18KeyReleased

    private void jTextField16KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField16KeyReleased
       try{
            int id= Integer.parseInt(jTextField16.getText());
            
            PreparedStatement ps,ps1;
            ps = connection.prepareStatement("select NAME from SUPPLIERITEMS where ITEMCODE=?");
            
            ps1 = connection.prepareStatement("select * from SUPPLIERITEMS WHERE ITEMCODE=?");
            ps1.setInt(1,Integer.parseInt(jTextField16.getText()));
            ResultSet rs1 =  ps1.executeQuery();
            boolean validation1= false;
            while(rs1.next()){
                validation1= true;
            }
            
           // int id2 = rs1.getInt(1);
           // rs1.next();
            
            if(!(validation1)){
                JOptionPane.showMessageDialog(rootPane,"Insert Valid item code","Info",1);
                
            }
            else{
            
            ps.setString(1, jTextField16.getText());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String s = rs.getString(1);
                
                jTextField14.setText(s);
            }
            }
        }catch(SQLException ex){
            Logger.getLogger(SupplierManagementFunction.class.getName()).log(Level.SEVERE,null,ex);
        }
       //catch (Exception e){
         //  System.out.println(e.getMessage());
     //  }
        displayItemName();
    }//GEN-LAST:event_jTextField16KeyReleased

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased

        // ADD ORDER - to get supplier name automatically
        try{
            int id= Integer.parseInt(jTextField5.getText());
            
            PreparedStatement ps,ps1;
            ps = connection.prepareStatement("select FIRSTNAME from SUPPLIERDETAILS where SUPPLIERID=?");
            
            ps1 = connection.prepareStatement("select * from SUPPLIERDETAILS WHERE supplierId=?");
            ps1.setInt(1,Integer.parseInt(jTextField5.getText()));
            ResultSet rs1 =  ps1.executeQuery();
            boolean validation1= false;
            while(rs1.next()){
                validation1= true;
            }
            
           // int id2 = rs1.getInt(1);
           // rs1.next();
            
            if(!(validation1)){
                JOptionPane.showMessageDialog(rootPane,"Insert Valid Supplier ID","Info",1);
                
            }
            
            ps.setString(1, jTextField5.getText());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String s = rs.getString(1);
                
                jTextField31.setText(s);
            }
        }catch(SQLException ex){
            Logger.getLogger(SupplierManagementFunction.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyReleased
        // TODO add your handling code here:
        // UPDATE ORDER - to get supplier name automatically
//        try{
//            PreparedStatement ps;
//            ps = connection.prepareStatement("select FIRSTNAME from SUPPLIERDETAILS where SUPPLIERID=?");
//            ps.setInt(1, Integer.parseInt( jTextField15.getText()));
//            ResultSet rs = ps.executeQuery();
//            
//            while(rs.next()){
//                String s = rs.getString(1);
//                
//                jTextField32.setText(s);
//            }
//        }catch(SQLException ex){
//            Logger.getLogger(SupplierManagementFunction.class.getName()).log(Level.SEVERE,null,ex);
        //}
         try{
            int id= Integer.parseInt(jTextField15.getText());
            
            PreparedStatement ps,ps1;
            ps = connection.prepareStatement("select FIRSTNAME from SUPPLIERDETAILS where SUPPLIERID=?");
            
            ps1 = connection.prepareStatement("select * from SUPPLIERDETAILS WHERE supplierId=?");
            ps1.setInt(1,Integer.parseInt(jTextField15.getText()));
            ResultSet rs1 =  ps1.executeQuery();
            boolean validation1= false;
            while(rs1.next()){
                validation1= true;
            }
            
           // int id2 = rs1.getInt(1);
           // rs1.next();
            
            if(!(validation1)){
                JOptionPane.showMessageDialog(rootPane,"Insert Valid Supplier ID","Info",1);
                
            }
            
            ps.setString(1, jTextField15.getText());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String s = rs.getString(1);
                
                jTextField32.setText(s);
            }
        }catch(SQLException ex){
            Logger.getLogger(SupplierManagementFunction.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_jTextField15KeyReleased

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        //GENERATE EXPENDITURE 
        
        if(jDateChooser3 .getDate()==null){
            JOptionPane.showMessageDialog(rootPane,"Please Select Start Date & End Date ","Info",1);
            
        }
                
//                else if((java.util.Date)jDateChooser3.getDate()< (java.util.Date)jDateChooser4.getDate()){
//                    
//                }
                else{
                    
                    try{
            java.sql.Date startDate = new java.sql.Date(jDateChooser3.getDate().getTime());
            java.sql.Date endDate = new java.sql.Date(jDateChooser4.getDate().getTime());
            
                        System.out.println(startDate);
                        System.out.println(endDate);
            PreparedStatement ps;
            ps = connection.prepareStatement("select orderid,total from orderdetails where orderDate between ? and ?");
            ps.setDate(1, startDate);
            ps.setDate(2, endDate);
            ResultSet rs = ps.executeQuery();
            
            Double d = 0D;
            while(rs.next()){
                d = d+rs.getDouble(2);
                
                jTextField33.setText(d.toString());
            }
        }catch(SQLException ex){
            Logger.getLogger(SupplierManagementFunction.class.getName()).log(Level.SEVERE,null,ex);
        }
                        };
        
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        //Generate PDF report
        String path = "";
        JFileChooser j = new JFileChooser();
        int x = j.showSaveDialog(this);
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        System.out.println(" ");
        if(x==JFileChooser.APPROVE_OPTION){
            path =j.getSelectedFile().getPath();
        }
        Document doc = new Document(PageSize.A4.rotate());
        try {
            PdfWriter.getInstance(doc,new FileOutputStream(path + ".pdf"));
            doc.open();
            
            
            
            doc.add(new Paragraph("\n\n\n                                                                                     Generated Supplier Details Report\n\n\n"));
            doc.add(new Paragraph("******************************************************************************************************************************************************\n\n\n"));
            
            Paragraph p1=new Paragraph("Total Number of Suppliers : "+jTextField34.getText().toString()+"\n\n\n");

            PdfPTable tb1 = new PdfPTable(7);
            
            PdfPCell cell = new PdfPCell(new Paragraph("Employee Details Report"));
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.DARK_GRAY);
            cell.setPadding(30.0f);
            
            tb1.addCell(cell);
            tb1.addCell("Supplier ID");
            tb1.addCell("Supplier NIC");
            tb1.addCell("First Name");
            tb1.addCell("Last Name");
            tb1.addCell("Contact Number");
            tb1.addCell("E-mail");
            tb1.addCell("Company Name");
            
            for(int i = 0; i < jTable1.getRowCount(); i++){
                String ID = jTable1.getValueAt(i, 0).toString();
                String NIC = jTable1.getValueAt(i, 1).toString();
                String Firstname = jTable1.getValueAt(i, 2).toString();
                String Lastname = jTable1.getValueAt(i, 3).toString();
                String Contactnumber = jTable1.getValueAt(i, 4).toString();
                String Email = jTable1.getValueAt(i, 5).toString();
                String Companyname = jTable1.getValueAt(i, 6).toString();
                
               
                tb1.addCell(ID);
                tb1.addCell(NIC);
                tb1.addCell(Firstname);
                tb1.addCell(Lastname);
                tb1.addCell(Contactnumber);
                tb1.addCell(Email);
                tb1.addCell(Companyname);
                
            }
            
            doc.add(p1);
            doc.add(tb1);
            
            JOptionPane.showMessageDialog(null,"Report Generated Successfully","ALERT MESSAGE", JOptionPane.WARNING_MESSAGE);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SupplierManagementFunction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(SupplierManagementFunction.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        doc.close();
    }//GEN-LAST:event_btnPDFActionPerformed

    private void jTextField34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField34ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // NIC Validation
        String oldNIC = "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][v]$";
        Pattern pattern1 = Pattern.compile(oldNIC);
        Matcher match1 = pattern1.matcher(jTextField6.getText());
        
        String newNIC = "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$";
        Pattern pattern2 = Pattern.compile(newNIC);
        Matcher match2 = pattern2.matcher(jTextField6.getText());
        
        if(!(match1.matches() || match2.matches())){
            jLabel59.setText("Invalid");
            
        }else{
            jLabel59.setText("");
        }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // NIC Validation
         String oldNIC = "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][v]$";
        Pattern pattern1 = Pattern.compile(oldNIC);
        Matcher match1 = pattern1.matcher(jTextField7.getText());
        
        String newNIC = "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$";
        Pattern pattern2 = Pattern.compile(newNIC);
        Matcher match2 = pattern2.matcher(jTextField7.getText());
        
        if(!(match1.matches() || match2.matches())){
            jLabel62.setText("Invalid");
            
        }else{
            jLabel62.setText("");
        }
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        // Contact Number Validation
        String contactnumber = "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$";
        Pattern pattern1 = Pattern.compile(contactnumber);
        Matcher match1 = pattern1.matcher(jTextField10.getText());
        
        if(!(match1.matches())){
            jLabel63.setText("Invalid");
            
        }else{
            jLabel63.setText("");
        }
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        // Email Validation
       String email = "^((\"[\\w-\\s]+\")|([\\w-]+(?:\\.[\\w-]+)*)|(\"[\\w-\\s]+\")([\\w-]+(?:\\.[\\w-]+)*))(@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$)|(@\\[?((25[0-5]\\.|2[0-4][0-9]\\.|1[0-9]{2}\\.|[0-9]{1,2}\\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\]?$)";
       Pattern pattern1 = Pattern.compile(email);
       Matcher match1 = pattern1.matcher(jTextField11.getText());
       
       if(!(match1.matches())){
            jLabel64.setText("Invalid");
            
        }else{
            jLabel64.setText("");
        }
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jTextField28KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField28KeyReleased
         // Email Validation
       String email = "^((\"[\\w-\\s]+\")|([\\w-]+(?:\\.[\\w-]+)*)|(\"[\\w-\\s]+\")([\\w-]+(?:\\.[\\w-]+)*))(@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$)|(@\\[?((25[0-5]\\.|2[0-4][0-9]\\.|1[0-9]{2}\\.|[0-9]{1,2}\\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\]?$)";
       Pattern pattern1 = Pattern.compile(email);
       Matcher match1 = pattern1.matcher(jTextField28.getText());
       
       if(!(match1.matches())){
            jLabel61.setText("Invalid");
            
        }else{
            jLabel61.setText("");
        }
    }//GEN-LAST:event_jTextField28KeyReleased

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
     String sql ="SELECT * FROM ADDORDER";
     DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
     try{
     PreparedStatement pst= connection.prepareStatement(sql);
      
      ResultSet rs = pst.executeQuery();
      int row =0;
      model.setRowCount(0);
      while(rs.next()){
          model.insertRow(row, new Object[]{rs.getString(1),rs.getString(2),rs.getInt(3)});
          row ++ ;

          
      }
      
     }catch(Exception e){
     e.printStackTrace();
     }
     
     
    
     
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
     jTextField32.setText(jTable7.getValueAt(jTable7.getSelectedRow(), 2).toString());
      jTextField29.setText(jTable7.getValueAt(jTable7.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_jTable7MouseClicked

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseClicked
           int i = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to log out?");
        if (i == JOptionPane.YES_OPTION) {
            
            dispose();
            SplashView sp = new SplashView();
            sp.setVisible(true);
            
            Login l = new Login();
            l.setSpalshView(sp); 
            l.setVisible(true);
            
        }
    }//GEN-LAST:event_jButton16MouseClicked

    private void jButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseClicked
        dispose();
        loginnav l1 = new loginnav();
        l1.setVisible(true);
    }//GEN-LAST:event_jButton17MouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    
    
    public void clearfields(){
        jTextField25.setText("");
        jTextField6.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField28.setText("");
        jTextField27.setText("");
        jTextField25.setText("");
        jTextField6.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField28.setText("");
        jTextField27.setText("");
        jTextField13.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField20.setText("");
        jTextField15.setText("");
        jTextField18.setText("");
        jTextField29.setText("");
        jTextField19.setText("");
        jTextField21.setText("");
        jTextField22.setText("");
        jDateChooser2.setDate(null);
        jTextField26.setText("");
        jTextField5.setText("");
        jDateChooser1.setDate(null);
        jTextField16.setText("");
        jTextField14.setText("");
        jTextField17.setText("");
        jTextField23.setText("");
        jTextField24.setText("");
        jTextField31.setText("");
        jTextField32.setText("");
        
        
    
    }
            
        
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
            java.util.logging.Logger.getLogger(SupplierManagementFunction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierManagementFunction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierManagementFunction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierManagementFunction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SupplierManagementFunction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddOrder;
    private javax.swing.JPanel AddSupplier;
    private javax.persistence.EntityManager ITProjectPUEntityManager;
    private javax.swing.JPanel Reports;
    private javax.swing.JPanel UpdateDeleteOrder;
    private javax.swing.JPanel UpdateDeleteSupplier;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private java.util.List<supplierManagement.Orderdetails> orderdetailsList;
    private java.util.List<supplierManagement.Orderdetails> orderdetailsList1;
    private java.util.List<supplierManagement.Orderdetails> orderdetailsList2;
    private javax.persistence.Query orderdetailsQuery;
    private javax.persistence.Query orderdetailsQuery1;
    private javax.persistence.Query orderdetailsQuery2;
    private java.util.List<supplierManagement.Supplierdetails> supplierdetailsList;
    private java.util.List<supplierManagement.Supplierdetails> supplierdetailsList1;
    private javax.persistence.Query supplierdetailsQuery;
    private javax.persistence.Query supplierdetailsQuery1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

  /*  private void ViewPanel(String card2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}

