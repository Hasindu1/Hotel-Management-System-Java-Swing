/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventManagementFunction;



import static BarManagementFunction.BarManagement1.homeStatus;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import databaseConnectivity.DBHandler;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.TableModel;
import javax.swing.text.Document;
import loginnav.loginnav;
import userLoginFunction.Login;
import userLoginFunction.SplashView;



/**
 *
 * @author Malki
 */
public class EventsManagement extends javax.swing.JFrame {
    public static boolean homeStatus;
    int i=0;
    Connection connection=null;
    ResultSet RS=null;
    PreparedStatement ps1=null;
   private ImageIcon img ;
    private Integer id;

    private ArrayList<Integer> hallNoList = new ArrayList<Integer>();
    /**
     * Creates new form NewJFrame1
     */
    public EventsManagement() {
        img= new ImageIcon(getClass().getResource("/icons/HotelManager.png"));
        this.setIconImage(img.getImage());
        initComponents();
        showDate();
        showTime();
        jButton13.setVisible(false);
          displayHome();
        
        //
    }
     public void displayHome(){
        if(homeStatus){
            jButton13.setVisible(true);
        }
    }
    
     private Connection connection1 = DBHandler.getDBConnection();
     
     void viewPanel(String cname){
         CardLayout cl = (CardLayout)jPanel5.getLayout();
         cl.show(jPanel5, cname);
     }
       public void showDate(){
        java.util.Date d=new java.util.Date();
        SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
        jLabel49.setText(s.format(d));
       
    }
    
    public void showTime(){
            new Timer(0,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                java.util.Date d=new java.util.Date();
                SimpleDateFormat s=new SimpleDateFormat("hh:mm:ss a");
                jLabel50.setText(s.format(d));
              
            }
            
        }
        ).start();
       
    } 
     
     void refreshTableHallUser(List halluserList1){
         
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, halluserList1, jTable1);
         org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${guestid}"));
        columnBinding.setColumnName("Guestid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nicpassport}"));
        columnBinding.setColumnName("Nicpassport");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fname}"));
        columnBinding.setColumnName("Fname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lname}"));
        columnBinding.setColumnName("Lname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contactnumber}"));
        columnBinding.setColumnName("Contactnumber");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${country}"));
        columnBinding.setColumnName("Country");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
         
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel6 = new javax.swing.JPanel();
        HotelManagementPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("HotelManagementSystemPU").createEntityManager();
        halluserQuery = java.beans.Beans.isDesignTime() ? null : HotelManagementPUEntityManager.createQuery("SELECT h FROM Halluser h");
        halluserList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : halluserQuery.getResultList();
        buttonGroup1 = new javax.swing.ButtonGroup();
        halluserQuery1 = java.beans.Beans.isDesignTime() ? null : HotelManagementPUEntityManager.createQuery("SELECT h FROM Halluser h");
        halluserList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : halluserQuery1.getResultList();
        hallbookingQuery = java.beans.Beans.isDesignTime() ? null : HotelManagementPUEntityManager.createQuery("SELECT h FROM Hallbooking h");
        hallbookingList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : hallbookingQuery.getResultList();
        hallQuery = java.beans.Beans.isDesignTime() ? null : HotelManagementPUEntityManager.createQuery("SELECT h FROM Hall h");
        hallList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : hallQuery.getResultList();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        hallbookingQuery1 = java.beans.Beans.isDesignTime() ? null : HotelManagementPUEntityManager.createQuery("SELECT h FROM Hallbooking h");
        hallbookingList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : hallbookingQuery1.getResultList();
        hallbookingQuery2 = java.beans.Beans.isDesignTime() ? null : HotelManagementPUEntityManager.createQuery("SELECT h FROM Hallbooking h");
        hallbookingList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : hallbookingQuery2.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        Availability = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        Payment = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        Reports = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        EventBooking = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField14 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1074, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
        );

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 1009));

        jPanel4.setBackground(new java.awt.Color(85, 68, 118));
        jPanel4.setToolTipText("");
        jPanel4.setPreferredSize(new java.awt.Dimension(223, 67));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/availbility.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("      Availability");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(85, 68, 118));
        jPanel9.setToolTipText("");
        jPanel9.setPreferredSize(new java.awt.Dimension(276, 67));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eventBooking.png"))); // NOI18N
        jLabel7.setText("jLabel4");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("      Event Booking");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(85, 68, 118));
        jPanel10.setToolTipText("");
        jPanel10.setPreferredSize(new java.awt.Dimension(276, 67));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/RoomPayment.png"))); // NOI18N
        jLabel9.setText("jLabel4");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("        Payment");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel10))
        );

        jPanel8.setBackground(new java.awt.Color(85, 68, 118));
        jPanel8.setToolTipText("");
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ReportsFinal.png"))); // NOI18N
        jLabel5.setText("jLabel4");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("     Reports");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("   Management");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("        Event");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(60, 60, 60)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(669, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));
        jPanel2.setPreferredSize(new java.awt.Dimension(2205, 154));

        jPanel3.setBackground(new java.awt.Color(54, 33, 89));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 1009));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 80)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("H o t e l  K a b a l a n a");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Matara Rd, Ahangama 80650");

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo (1).png"))); // NOI18N
        jLabel48.setText("jLabel48");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("date");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("time");

        jButton11.setBackground(new java.awt.Color(54, 33, 89));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Log Out");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(54, 33, 89));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Home");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(551, 551, 551)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50))
                .addContainerGap(1631, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel50)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.CardLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel14.setText("Check In Date :");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel30.setText("Check Out Date :");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Availability");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, hallList, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hallid}"));
        columnBinding.setColumnName("Hallid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hallno}"));
        columnBinding.setColumnName("Hallno");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${halltype}"));
        columnBinding.setColumnName("Halltype");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hallprice}"));
        columnBinding.setColumnName("Hallprice");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel31.setBackground(new java.awt.Color(0, 0, 0));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setText("Hall Details");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel35.setText("No Of Plates    :");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel36.setText("Price Per Plate :");

        jTextField19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField19KeyReleased(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel37.setText("Amount         :");

        jTextField20.setEditable(false);
        jTextField20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField20KeyReleased(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel34.setText("Hall Price         :");

        jTextField17.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable2, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.hallprice}"), jTextField17, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField17KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel36)
                                .addComponent(jLabel35)
                                .addComponent(jLabel34)
                                .addComponent(jLabel37))
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel31)
                .addGap(54, 54, 54)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Event Booking");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton12.setText("Availability");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AvailabilityLayout = new javax.swing.GroupLayout(Availability);
        Availability.setLayout(AvailabilityLayout);
        AvailabilityLayout.setHorizontalGroup(
            AvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AvailabilityLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(AvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(AvailabilityLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AvailabilityLayout.createSequentialGroup()
                        .addGroup(AvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AvailabilityLayout.createSequentialGroup()
                                .addGap(784, 784, 784)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AvailabilityLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(172, 172, 172)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1975, 1975, 1975))))
        );
        AvailabilityLayout.setVerticalGroup(
            AvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AvailabilityLayout.createSequentialGroup()
                .addGroup(AvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AvailabilityLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(AvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(AvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AvailabilityLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(AvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(120, 120, 120)
                .addGroup(AvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(81, 81, 81)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(449, 449, 449))
        );

        jPanel5.add(Availability, "card6");

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel33.setText("Hall Price          : ");

        jTextField15.setEditable(false);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel38.setText("Price Per Plate : ");

        jTextField16.setEditable(false);
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel39.setText("No Of Plates     :");

        jTextField21.setEditable(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel40.setText("Amount            :");

        jTextField22.setEditable(false);
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel41.setText("Discount           :");

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

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel42.setText("Total Price         :");

        jTextField24.setEditable(false);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel43.setText("Guest ID          :");

        jTextField25.setEditable(false);

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel44.setText("Check In Date   :");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel45.setText("Check Out Date :");

        jTextField26.setEditable(false);

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel46.setText("Booking ID     : ");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel43)
                                .addComponent(jLabel46)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField22, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(jTextField23, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(jTextField24, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addGap(36, 36, 36)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel44))
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel39)
                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel45))
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel32.setText("Payment Details");

        javax.swing.GroupLayout PaymentLayout = new javax.swing.GroupLayout(Payment);
        Payment.setLayout(PaymentLayout);
        PaymentLayout.setHorizontalGroup(
            PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PaymentLayout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2097, Short.MAX_VALUE))
        );
        PaymentLayout.setVerticalGroup(
            PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(504, Short.MAX_VALUE))
        );

        jPanel5.add(Payment, "card4");

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton10.setText("Generate Report");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, hallbookingList2, jTable3);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${guestid}"));
        columnBinding.setColumnName("Guestid");
        columnBinding.setColumnClass(eventManagementFunction.Halluser.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hallCollection}"));
        columnBinding.setColumnName("Hall Collection");
        columnBinding.setColumnClass(java.util.Collection.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${amount}"));
        columnBinding.setColumnName("Amount");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${discount}"));
        columnBinding.setColumnName("Discount");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${noofplates}"));
        columnBinding.setColumnName("Noofplates");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${priceperplate}"));
        columnBinding.setColumnName("Priceperplate");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalprice}"));
        columnBinding.setColumnName("Totalprice");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${checkout}"));
        columnBinding.setColumnName("Checkout");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${checkin}"));
        columnBinding.setColumnName("Checkin");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bookingid}"));
        columnBinding.setColumnName("Bookingid");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout ReportsLayout = new javax.swing.GroupLayout(Reports);
        Reports.setLayout(ReportsLayout);
        ReportsLayout.setHorizontalGroup(
            ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportsLayout.createSequentialGroup()
                .addGroup(ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReportsLayout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReportsLayout.createSequentialGroup()
                        .addGap(712, 712, 712)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1826, Short.MAX_VALUE))
        );
        ReportsLayout.setVerticalGroup(
            ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportsLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(548, Short.MAX_VALUE))
        );

        jPanel5.add(Reports, "card8");

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("Personal Details");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setText("NIC or Passport No      : ");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nicpassport}"), jTextField2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel16.setText("First Name                 :");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fname}"), jTextField3, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel17.setText("Last Name                 :");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.lname}"), jTextField9, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel27.setText("Guest Email               : ");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.email}"), jTextField4, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel26.setText("Contact Number          :  ");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.contactnumber}"), jTextField10, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel28.setText("Guest Country            : ");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.country}"), jTextField11, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel23.setText("Guest ID                    :");

        jTextField5.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.guestid}"), jTextField5, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setText("Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setText("Update");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton8.setText("Reset");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel26)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel23)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addGap(1, 1, 1))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11, 11, 11)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel28))
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Hall Details");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel20.setText("Check In Date      : ");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel21.setText("Check Out Date    :");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel22.setText("Hall Price             :");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel24.setText("No Of Plates        :");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel25.setText("Price per Plate      :");

        jTextField8.setEditable(false);

        jTextField12.setEditable(false);

        jTextField13.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Amount                :");

        jTextField1.setEditable(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel25)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel22)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel20))
                                    .addGap(30, 30, 30)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jDateChooser6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(35, 35, 35)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel21))
                    .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(26, 26, 26)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, halluserList1, jTable1);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${guestid}"));
        columnBinding.setColumnName("Guestid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nicpassport}"));
        columnBinding.setColumnName("Nicpassport");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fname}"));
        columnBinding.setColumnName("Fname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lname}"));
        columnBinding.setColumnName("Lname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contactnumber}"));
        columnBinding.setColumnName("Contactnumber");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${country}"));
        columnBinding.setColumnName("Country");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setText("SEARCH By GuestID");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EventBookingLayout = new javax.swing.GroupLayout(EventBooking);
        EventBooking.setLayout(EventBookingLayout);
        EventBookingLayout.setHorizontalGroup(
            EventBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EventBookingLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(EventBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EventBookingLayout.createSequentialGroup()
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9))
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(EventBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
                .addContainerGap(1916, Short.MAX_VALUE))
        );
        EventBookingLayout.setVerticalGroup(
            EventBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EventBookingLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(EventBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(EventBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(EventBookingLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(315, Short.MAX_VALUE))
        );

        jPanel5.add(EventBooking, "card5");

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        this.viewPanel("card6");
        
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
         this.viewPanel("card5");
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        // TODO add your handling code here:
         this.viewPanel("card4");
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
         this.viewPanel("card8");
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // BOOK AN EVENT
        jTextField8.setText(jTextField17.getText());
        jTextField12.setText(jTextField18.getText()); 
        jTextField13.setText(jTextField19.getText());
        jTextField1.setText(jTextField20.getText());
        
        jDateChooser5.setDate(jDateChooser1.getDate());
        jDateChooser6.setDate(jDateChooser2.getDate());
        
        this.viewPanel("card5");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField20KeyReleased
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTextField20KeyReleased

    private void jTextField19KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField19KeyReleased
        // TODO add your handling code here:
        double b = Double.valueOf(jTextField17.getText());
        double p = Double.valueOf(jTextField18.getText());
        double k = Double.valueOf(jTextField19.getText());
        
        double Amount = (b+(p*k));
        jTextField20.setText(String.valueOf(Amount));
        
    }//GEN-LAST:event_jTextField19KeyReleased

    private void jTextField23KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField23KeyReleased
        // TODO add your handling code here:
        Double i=Double.valueOf(jTextField22.getText());
        Double k=Double.valueOf(jTextField23.getText());
        
        double total=(i*(100.0-k))/100.0;
        jTextField24.setText(String.valueOf(total));
        
    }//GEN-LAST:event_jTextField23KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // INSERT PAYMENT DETAILS
        
        try{
                    //System.out.println(""); 
                    
                    String insertQuery= "INSERT INTO HALLBOOKING(CHECKIN,CHECKOUT,TOTALPRICE,PRICEPERPLATE,NOOFPLATES,DISCOUNT,AMOUNT) values(?,?,?,?,?,?,?)";
                    
                    
                    PreparedStatement statement=connection1.prepareStatement(insertQuery);
                    
                     
                    statement.setString(1, ((JTextField)jDateChooser3.getDateEditor().getUiComponent()).getText());
                    statement.setString(2, ((JTextField)jDateChooser4.getDateEditor().getUiComponent()).getText());
                    statement.setDouble(3, Double.parseDouble(jTextField24.getText()));
                    statement.setDouble(4, Double.parseDouble(jTextField16.getText()));
                    statement.setString(5, jTextField21.getText());
                    statement.setDouble(6, Double.parseDouble(jTextField23.getText()));
                    statement.setDouble(7, Double.parseDouble(jTextField22.getText()));
                    
                    
                     JOptionPane.showMessageDialog(rootPane,"Successfully Inserted","Info",1);   
                     
                     statement.executeUpdate();
                     
                     String sql2 = "SELECT max(BookingID) FROM HallBooking";
                     PreparedStatement p2 = connection1.prepareStatement(sql2);

            ResultSet rs3=p2.executeQuery();
            int lastID=0 ;

            while (rs3.next()){
                lastID = rs3.getInt(1);
            }

            for(int i : hallNoList){

                p2.setInt(1,lastID);
                p2.setInt(2,i);
                p2.executeUpdate();

            }
                     
                     
                    
        }
        
        catch (Exception e){ 
                      e.printStackTrace();
                            }
        
        this.viewPanel("card8");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//         UPDATE PAYMENT DETAILS
//        
        try{
                String insertQuery= "UPDATE HALLBOOKING SET  CHECKIN=?, CHECKOUT=?,TOTALPRICE=?,GUESTID=?,PRICEPERPLATE=?,NOOFPLATES=?,DISCOUNT=?,AMOUNT=? WHERE BOOKINGID=?";
                
                String sql3 = "INSERT INTO HALLBOOKING_HALL(BOOKINGID, HALLID) values (?,?)";
                
                PreparedStatement p=connection1.prepareStatement(insertQuery);
                
                p.setInt(9, Integer.parseInt(jTextField26.getText()));
                p.setString(1, ((JTextField)jDateChooser3.getDateEditor().getUiComponent()).getText());
                p.setString(2, ((JTextField)jDateChooser4.getDateEditor().getUiComponent()).getText());
                p.setDouble(3, Double.parseDouble(jTextField24.getText()));
                p.setInt(4, Integer.parseInt(jTextField25.getText()));
                p.setDouble(5, Double.parseDouble(jTextField16.getText()));
                p.setInt(6, Integer.parseInt(jTextField21.getText()));
                p.setDouble(7, Double.parseDouble(jTextField23.getText()));
                p.setDouble(8, Double.parseDouble(jTextField22.getText()));
                
                
                JOptionPane.showMessageDialog(rootPane,"Successfully Update","Info",1);
            
                p.executeUpdate();
            
                PreparedStatement p2=connection1.prepareStatement(sql3);
                
                for(int i : hallNoList){
                    
                    p2.setInt(1, Integer.parseInt(jTextField26.getText()));
                    p2.setInt(2,i);
                    p2.executeUpdate();
                }
           
               
        }
        
         catch (Exception e){ 
                
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TRESET PERSONAL DETAILS

        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField9.setText(null);
        jTextField10.setText(null);
        jTextField11.setText(null);
        jTextField14.setText(null);
        buttonGroup1.clearSelection();
        buttonGroup1.clearSelection();
        jTable1.clearSelection();

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // UPDATE PERSONAL DETAILS

        try{

            String insertQuery= "UPDATE HALLUSER SET NICPASSPORT=? , FNAME=?, LNAME=?, EMAIL=?, CONTACTNUMBER=?, COUNTRY=? WHERE GUESTID=? ";
            //System.out.println("1");

            PreparedStatement p=connection1.prepareStatement(insertQuery);

            // connection1.createStatement().executeUpdate(insertQuery);

            p.setInt(7,Integer.parseInt(jTextField5.getText()));
            System.out.println("3");
            p.setString(1,jTextField2.getText());
            p.setString(2,jTextField3.getText());
            p.setString(3,jTextField9.getText());
            p.setString(4,jTextField4.getText());
            p.setInt(5,Integer.parseInt(jTextField10.getText()));
            p.setString(6,jTextField11.getText());

            refreshTableHallUser(halluserList1);
            
            JOptionPane.showMessageDialog(rootPane,"Successfully Update","Info",1);

            p.executeUpdate();
            
            String sql1="SELECT BOOKINGID FROM HALLBOOKING WHERE GUESTID="+ jTextField5.getText();
            
            PreparedStatement p1 = connection1.prepareStatement(sql1);
            
            ResultSet rs = p1.executeQuery();
            while(rs.next()){
                jTextField26.setText(rs.getString("bookingID"));
                
            }
            
            

        }

        catch (Exception e){

        }

        jTextField25.setText(jTextField5.getText());
        jTextField15.setText(jTextField8.getText());
        jTextField21.setText(jTextField12.getText());
        jTextField16.setText(jTextField13.getText());
        jTextField22.setText(jTextField1.getText());

        jDateChooser3.setDate(jDateChooser5.getDate());
        jDateChooser4.setDate(jDateChooser6.getDate());

        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField9.setText(null);
        jTextField10.setText(null);
        jTextField11.setText(null);
        jTextField14.setText(null);

        this.viewPanel("card4");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // INSERT PERSONAL DETAILS
        //PERSONAL DETAILS INSERT VALIDATION
        
        String NICNo = jTextField2.getText().toString();
        String FirstName = jTextField3.getText().toString();
        String LastName = jTextField9.getText().toString();
        String Email = jTextField4.getText().toString();
        String ContactNo = jTextField10.getText().toString();
        String Country = jTextField11.getText().toString();
        
        if (NICNo.equals("")){
            JOptionPane.showMessageDialog(null, "NIC or Passport No is Mandotory");
        }else if (FirstName.equals("")){
            JOptionPane.showMessageDialog(null, "First Name is Mandotory");
        }else if (LastName.equals("")) {
            JOptionPane.showMessageDialog(null, "Last Name is Mandotory");
        }else if (Email.equals("")) {
            JOptionPane.showMessageDialog(null, "Guest Email is Mandotory");
        }else if (ContactNo.equals("")){
            JOptionPane.showMessageDialog(null, "Contact No is Mandotary");
        }else if (Country.equals("")) {
            JOptionPane.showMessageDialog(null, "Guest Country is Mandotory");
        }
       
        else{        
        

        try{
            //System.out.println("");

            String insertQuery= "INSERT INTO HALLUSER(NICPASSPORT, FNAME, LNAME, EMAIL, CONTACTNUMBER, COUNTRY) values(?,?,?,?,?,?)";

            //java.sql.PreparedStatement ps1=connection.prepareStatement(insertQuery);
            //connection1.createStatement().executeUpdate(insertQuery);
            PreparedStatement statement=connection1.prepareStatement(insertQuery);

            statement.setString(1, jTextField2.getText());
            statement.setString(2, jTextField3.getText());
            statement.setString(3, jTextField9.getText());
            statement.setString(4, jTextField4.getText());
            statement.setString(5, jTextField10.getText());
            statement.setString(6, jTextField11.getText());
            statement.executeUpdate();
            String sql = "SELECT * FROM HALLUSER";
            PreparedStatement statement1=connection1.prepareStatement(sql);
            ResultSet rs = statement1.executeQuery();
            halluserList1.clear();
            while(rs.next()){
                Halluser halluser = new Halluser();
                // H job = new Job();
                halluser.setGuestid(rs.getInt(1));
                halluser.setNicpassport(rs.getString(2));
                halluser.setFname(rs.getString(3));
                halluser.setLname(rs.getString(4));
                halluser.setEmail(rs.getString(5));
                halluser.setContactnumber(rs.getString(6));
                halluser.setCountry(rs.getString(7));
                halluserList1.add(halluser);

            }
            refreshTableHallUser(halluserList1);

            

            //                    if(jTextField2.equals("")){
                //                        JOptionPane.showMessageDialog(null, "NIC or Passport Number cannot be Empty");
                //                    }

            //                    if(jTextField3.equals("")){
                //                        JOptionPane.showMessageDialog(null, "First Name cannot be Empty");
                //                    }
            //
            //                    if(jTextField9.equals("")){
                //                        JOptionPane.showMessageDialog(null, "Last Name cannot be Empty");
                //                    }
            //
            //                    if(jTextField4.equals("")){
                //                        JOptionPane.showMessageDialog(null, "Guest Email cannot be Empty");
                //                    }
            //
            //                    if(jTextField10.equals("")){
                //                        JOptionPane.showMessageDialog(null, "Contact Number cannot be Empty");
                //                    }
            //
            //                    if(jTextField11.equals("")){
                //                        JOptionPane.showMessageDialog(null, "Guest Country cannot be Empty");
                //                    }

            JOptionPane.showMessageDialog(rootPane,"Successfully Inserted","Info",1);
            //refreshTableHallUser(halluserList1);

            //halluserList1.clear();
            //refreshTableHallUser(halluserList1);

            //

        }catch (Exception e){
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
        TableModel model=jTable1.getModel();
        id=(int) model.getValueAt(model.getRowCount()-1, 0);
        jTextField25.setText(id.toString());

        jTextField15.setText(jTextField8.getText());
        jTextField21.setText(jTextField12.getText());
        jTextField16.setText(jTextField13.getText());
        jTextField22.setText(jTextField1.getText());

        jDateChooser3.setDate(jDateChooser5.getDate());
        jDateChooser4.setDate(jDateChooser6.getDate());

        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField9.setText(null);
        jTextField10.setText(null);
        jTextField11.setText(null);
        jTextField14.setText(null);

        this.viewPanel("card4");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        //VALIDATE EMAIL

        String email = "^((\"[\\w-\\s]+\")|([\\w-]+(?:\\.[\\w-]+)*)|(\"[\\w-\\s]+\")([\\w-]+(?:\\.[\\w-]+)*))(@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\."
                + "([a-z]{2,6}(?:\\.[a-z]{2})?)$)|(@\\[?((25[0-5]\\.|2[0-4][0-9]\\.|1[0-9]{2}\\.|[0-9]{1,2}\\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}"
                + "|[0-9]{1,2})\\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\]?$)";
        Pattern pattern = Pattern.compile(email);
        Matcher match1 = pattern.matcher(jTextField4.getText());

        if(!(match1.matches() )){
            jLabel13.setText("Invalid");

        }else{
            jLabel13.setText("");

        }

    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // VALIDATE NIC/PASSPORT

        String passport = "^[A-Z][0-9][0-9] [0-9][0-9][0-9][0-9][0-9]$";
        Pattern pattern1 = Pattern.compile(passport);
        Matcher match1 = pattern1.matcher(jTextField2.getText());

        String oldNIC = "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][v]$";
        Pattern pattern2 = Pattern.compile(oldNIC);
        Matcher match2 = pattern2.matcher(jTextField2.getText());

        String newNIC = "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$";
        Pattern pattern3 = Pattern.compile(newNIC);
        Matcher match3 = pattern3.matcher(jTextField2.getText());

        if(!(match1.matches() || match2.matches() || match3.matches())){
            jLabel12.setText("Invalid");

        }else{
            jLabel12.setText("");

        }

    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // DELETE PERSONAL DETAILS
        try{
        String insertQuery ="DELETE FROM HALLUSER WHERE GUESTID = ?";
        
         PreparedStatement p=connection1.prepareStatement(insertQuery);
         
         //p.setInt(1,Integer.parseInt(jTextField5.getText()));
         p.setString(1, jTextField5.getText());
         
         refreshTableHallUser(halluserList1);
            JOptionPane.showMessageDialog(rootPane,"Successfully Deleted","Info",1);

            p.executeUpdate();

        }

        catch (Exception e){

        }
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField9.setText(null);
        jTextField10.setText(null);
        jTextField11.setText(null);
        jTextField14.setText(null);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        
        jTextField14.getText();
        try{
            String q = "SELECT * FROM HALLUSER WHERE GUESTID = "+Integer.parseInt(jTextField14.getText())+"";
            
            PreparedStatement ps = connection1.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            halluserList1.clear();
            
            while(rs.next()){
                Halluser halluser = new Halluser();
                halluser.setGuestid(rs.getInt(1));
                halluser.setNicpassport(rs.getString(2));
                halluser.setFname(rs.getString(3));
                halluser.setLname(rs.getString(4));
                halluser.setEmail(rs.getString(5));
                halluser.setContactnumber(rs.getString(6));
                halluser.setCountry(rs.getString(7));
                
                halluserList1.add(halluser);
                
            }
            
            refreshTable(halluserList1);
            
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // GENERATE REPORT
        
        
          
        
        
        
        
        
        
        
        
        
        String path="";
        JFileChooser j=new JFileChooser();
        int x=j.showOpenDialog(this);
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //int x=j.showOpenDialog(this);
        
        if(x==JFileChooser.APPROVE_OPTION){
            
            path=j.getSelectedFile().getPath();
        }

        com.itextpdf.text.Document doc=new com.itextpdf.text.Document();
        
        try{
            doc.open();
            
            PdfWriter.getInstance(doc,new FileOutputStream(path + ".pdf")); 
            
           doc.add(new Paragraph("Hotel Kabalana Monthly Income Of Events", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.RED)));
            //doc.add(new Paragraph(new Date().toString()));
            doc.add(new Paragraph("---------------------------------------------------------------------------------------"));
            
            doc.open();
            PdfPTable tb=new PdfPTable(4);
            
                tb.addCell("Guest ID");
                tb.addCell("Check-In");
                tb.addCell("Check-Out");
                tb.addCell("Total Price");
                doc.setPageSize(PageSize.LETTER);

                for(int i=0;i<jTable3.getRowCount();i++){
                    System.out.println("r1");
                    tb = new PdfPTable(4);
                    //Integer id=Integer.parseInt(jTable4.getValueAt(i,0).toString());
                    String id=jTable3.getValueAt(i,0).toString();
                    String checkin=jTable3.getValueAt(i,1).toString();
                    String checkout=jTable3.getValueAt(i,2).toString();
                    String tot=jTable3.getValueAt(i,3).toString();

                    System.out.println("r2");

                tb.addCell(id);
                tb.addCell(checkin);
                tb.addCell(checkout);
                tb.addCell(tot);

                    System.out.println("r3");
                    doc.add(tb);

                }
            
            
           
             doc.close();
            JOptionPane.showMessageDialog(null,"Report Generated Successfully","AlERT MESSAGE",JOptionPane.WARNING_MESSAGE);
         
        }catch(FileNotFoundException ex){
             Logger.getLogger(EventsManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(EventsManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
   
         
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        //this.viewPanel("card5");
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        //this.viewPanel("card8");
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        try{
            System.out.println("123");
            java.sql.Date d1=null;
            java.util.Date date1= jDateChooser1.getDate();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
             Date date=new Date(0);
            String sdate = formatter.format(date);

            Date systemdate=(Date) new SimpleDateFormat("yyyy-MM-dd").parse(sdate);

            if(date1==null){
                System.out.println("No date choose");
                JOptionPane.showMessageDialog(this,"No date choose","Info",0);

            }else{
                //d1=new java.sql.Date(date1.getTime());
                java.sql.Date d3 = new java.sql.Date(jDateChooser1.getDate().getTime());
                System.out.println("345");
            }
                
            java.sql.Date d2=null;
            java.util.Date date2= jDateChooser2.getDate();

            if(date2==null){
                System.out.println("No date choose");
                JOptionPane.showMessageDialog(this,"No date choose","Info",0);
            }else{
                d2=new java.sql.Date(date2.getTime());
            }

            if (d1.compareTo(systemdate) < 0 ) {

                JOptionPane.showMessageDialog(this, "Check-in date must be equal or greater than current date","Info",0);
            }

            else if (!(d2.compareTo(systemdate) >=d1.compareTo(systemdate)) ) {

                JOptionPane.showMessageDialog(this, "Check-out date must be equal or greater than check-in date","Info",0);
            }
            else{

                String q="SELECT HallNo,HallType,HallPrice,HallID From ROOM WHERE HallID NOT IN (SELECT HallID FROM HALLBOOKING B "
                + "JOIN HALLBOOKING_HALL RB  ON B.BookingID = RB.BookingID  WHERE  (checkin <= '"+d1+"' AND "
                + "checkout >= '"+d1+"') OR (checkin < '"+d2+"' AND checkout >= '"+d2+"' )  OR "
                + "('"+d1+"' <= checkin AND '"+d2+"' >= checkout) )" ;
                //System.out.println("1234");

                PreparedStatement pst=connection1.prepareStatement(q);

                ResultSet rs=pst.executeQuery();
                TableModel t=jTable2.getModel();
                hallList.clear();

                while(rs.next()){

                    Hall hall=new Hall();
                    hall.setHallid(rs.getInt(4));
                    hall.setHallno(rs.getString(1));
                    hall.setHalltype(rs.getString(2));
                    hall.setHallprice(rs.getDouble(3));
                    

                    hallList.add(hall);
                    //System.out.println(rs.getInt(1));

                }
                refreshTablehall(hallList);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17KeyReleased

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
         int i = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to log out?");
        if (i == JOptionPane.YES_OPTION) {
            
            dispose();
            SplashView sp = new SplashView();
            sp.setVisible(true);
            
            Login l = new Login();
            l.setSpalshView(sp); 
            l.setVisible(true);
            
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
     dispose();
        loginnav l1 = new loginnav();
      
      l1.setVisible(true);
    }//GEN-LAST:event_jButton13MouseClicked
    
    /**
     * @param args the command line arguments
     * 
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
            java.util.logging.Logger.getLogger(EventsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater (new Runnable() {
            public void run() {
                new EventsManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Availability;
    private javax.swing.JPanel EventBooking;
    private javax.persistence.EntityManager HotelManagementPUEntityManager;
    private javax.swing.JPanel Payment;
    private javax.swing.JPanel Reports;
    private javax.swing.ButtonGroup buttonGroup1;
    private java.util.List<eventManagementFunction.Hall> hallList;
    private javax.persistence.Query hallQuery;
    private java.util.List<eventManagementFunction.Hallbooking> hallbookingList;
    private java.util.List<eventManagementFunction.Hallbooking> hallbookingList1;
    private java.util.List<eventManagementFunction.Hallbooking> hallbookingList2;
    private javax.persistence.Query hallbookingQuery;
    private javax.persistence.Query hallbookingQuery1;
    private javax.persistence.Query hallbookingQuery2;
    private java.util.List<eventManagementFunction.Halluser> halluserList;
    private java.util.List<eventManagementFunction.Halluser> halluserList1;
    private javax.persistence.Query halluserQuery;
    private javax.persistence.Query halluserQuery1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
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
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
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
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void refreshTablehall(List<Hall> hallList) {
        
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, hallList, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hallid}"));
        columnBinding.setColumnName("Hallid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hallno}"));
        columnBinding.setColumnName("Hallno");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${halltype}"));
        columnBinding.setColumnName("Halltype");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hallprice}"));
        columnBinding.setColumnName("Hallprice");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);
    }

    private void refreshTable(List<Halluser> halluserList1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
