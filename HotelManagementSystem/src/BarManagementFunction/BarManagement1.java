/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarManagementFunction;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import loginnav.loginnav;
import userLoginFunction.Login;
import userLoginFunction.SplashView;
//import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

/**
 *
 * @author Manthi
 */
public class BarManagement1 extends javax.swing.JFrame {

    private int barproductid;
    private int barid;
    private int barordersid;
    public static boolean homeStatus;
      private ImageIcon img ;
  
//    private Connection con = DBHandler.getDBConnection();
    
    /**
     * Creates new form FinancialManagement
     */
    public BarManagement1() {
         img= new ImageIcon(getClass().getResource("/icons/HotelManager.png"));
        this.setIconImage(img.getImage());
        initComponents();
          showDate();
           showTime();
           jButton5.setVisible(false);
           displayHome();
           System.out.println("Home status:" +homeStatus);
    
    }
  
    public void displayHome(){
        if(homeStatus){
            jButton5.setVisible(true);
        }
    }
    
     public void showDate(){
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-YYYY");
        jLabel1.setText(s.format(d));

    }
    
    public void showTime(){
        new Timer(0,new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh : mm : ss a");
                
            jLabel27.setText(s.format(d));

            }
    }).start();
    }
    
    public void refreshTablebarstock(List barstockcontrolList) {
        
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, barstockcontrolList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productid}"));
        columnBinding.setColumnName("Productid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productname}"));
        columnBinding.setColumnName("Productname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${standardunit}"));
        columnBinding.setColumnName("Standardunit");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${amountperunit}"));
        columnBinding.setColumnName("Amountperunit");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${priceperunit}"));
        columnBinding.setColumnName("Priceperunit");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        
    }
    
    public void refreshTablebarorder(List barordersList) {
        
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, barordersList, jTable3);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderid}"));
        columnBinding.setColumnName("Orderid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ordertype}"));
        columnBinding.setColumnName("Ordertype");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderpid}"));
        columnBinding.setColumnName("Orderpid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderpname}"));
        columnBinding.setColumnName("Orderpname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${stunit}"));
        columnBinding.setColumnName("Stunit");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${apunit}"));
        columnBinding.setColumnName("Apunit");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ppunit}"));
        columnBinding.setColumnName("Ppunit");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderamount}"));
        columnBinding.setColumnName("Orderamount");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        
    }
        
        
    public void refreshTablebarbill(List barorderbillList){
            
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, barorderbillList, jTable4);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ordersid}"));
        columnBinding.setColumnName("Ordersid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${calamount}"));
        columnBinding.setColumnName("Calamount");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${discountselect}"));
        columnBinding.setColumnName("Discountselect");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${discount}"));
        columnBinding.setColumnName("Discount");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalbill}"));
        columnBinding.setColumnName("Totalbill");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${status}"));
        columnBinding.setColumnName("Status");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        
    }
        
    public void refreshTablebarincome(List barincomeList){
        
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, barincomeList, jTable6);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${monthstartdate}"));
        columnBinding.setColumnName("Monthstartdate");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${monthenddate}"));
        columnBinding.setColumnName("Monthenddate");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalincome}"));
        columnBinding.setColumnName("Totalincome");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        
    }
        
    public void refreshTablebarwastage(List barwastageList){
        
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, barwastageList, jTable5);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${wastageid}"));
        columnBinding.setColumnName("Wastageid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${wastageamount}"));
        columnBinding.setColumnName("Wastageamount");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
       
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    void viewPanel(String cname) {
        CardLayout cL = (CardLayout) jPanel5.getLayout();
        cL.show(jPanel5, cname);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        ITPNewPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("HotelManagementSystemPU").createEntityManager();
        barstockcontrolQuery = java.beans.Beans.isDesignTime() ? null : ITPNewPUEntityManager.createQuery("SELECT b FROM Barstockcontrol b");
        barstockcontrolList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : barstockcontrolQuery.getResultList();
        barwastageQuery = java.beans.Beans.isDesignTime() ? null : ITPNewPUEntityManager.createQuery("SELECT b FROM Barwastage b");
        barwastageList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : barwastageQuery.getResultList();
        barincomeQuery = java.beans.Beans.isDesignTime() ? null : ITPNewPUEntityManager.createQuery("SELECT b FROM Barincome b");
        barincomeList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : barincomeQuery.getResultList();
        barstockcontrolQuery1 = java.beans.Beans.isDesignTime() ? null : ITPNewPUEntityManager.createQuery("SELECT b FROM Barstockcontrol b");
        barstockcontrolList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : barstockcontrolQuery1.getResultList();
        barordersQuery = java.beans.Beans.isDesignTime() ? null : ITPNewPUEntityManager.createQuery("SELECT b FROM Barorders b");
        barordersList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : barordersQuery.getResultList();
        barorderbillQuery = java.beans.Beans.isDesignTime() ? null : ITPNewPUEntityManager.createQuery("SELECT b FROM Barorderbill b");
        barorderbillList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : barorderbillQuery.getResultList();
        barorderbillQuery1 = java.beans.Beans.isDesignTime() ? null : ITPNewPUEntityManager.createQuery("SELECT b FROM Barorderbill b");
        barorderbillList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : barorderbillQuery1.getResultList();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        barstockcontrolQuery2 = java.beans.Beans.isDesignTime() ? null : ITPNewPUEntityManager.createQuery("SELECT b FROM Barstockcontrol b");
        barstockcontrolList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : barstockcontrolQuery2.getResultList();
        barordersQuery1 = java.beans.Beans.isDesignTime() ? null : ITPNewPUEntityManager.createQuery("SELECT b FROM Barorders b");
        barordersList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : barordersQuery1.getResultList();
        barincomeQuery1 = java.beans.Beans.isDesignTime() ? null : ITPNewPUEntityManager.createQuery("SELECT b FROM Barincome b");
        barincomeList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : barincomeQuery1.getResultList();
        jPanel2 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jTextField70 = new javax.swing.JTextField();
        jTextField71 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField72 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton39 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jLabel48 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField82 = new javax.swing.JTextField();
        jTextField83 = new javax.swing.JTextField();
        jTextField84 = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jTextField85 = new javax.swing.JTextField();
        jTextField86 = new javax.swing.JTextField();
        jTextField87 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel109 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField42 = new javax.swing.JTextField();
        jButton43 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jPanel24 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jTextField88 = new javax.swing.JTextField();
        jTextField89 = new javax.swing.JTextField();
        jTextField90 = new javax.swing.JTextField();
        jTextField93 = new javax.swing.JTextField();
        jTextField92 = new javax.swing.JTextField();
        jTextField91 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel110 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField48 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jPanel25 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton44 = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jLabel70 = new javax.swing.JLabel();
        jButton45 = new javax.swing.JButton();
        jTextField9 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jTextField49 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jLabel74 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        jPanel9 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jButton54 = new javax.swing.JButton();
        jTextField13 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField51 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jDateChooser9 = new com.toedter.calendar.JDateChooser();
        jLabel38 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jButton23 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 1009));

        jPanel17.setBackground(new java.awt.Color(85, 68, 118));
        jPanel17.setToolTipText("");
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/order.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Order Handling");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(85, 68, 118));
        jPanel16.setToolTipText("");
        jPanel16.setPreferredSize(new java.awt.Dimension(278, 67));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Stock Handling");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BarManagementFunction/stock.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(19, 19, 19))
        );

        jPanel15.setBackground(new java.awt.Color(85, 68, 118));
        jPanel15.setToolTipText("");
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Generate Reports");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BarManagementFunction/report.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel18.setBackground(new java.awt.Color(85, 68, 118));
        jPanel18.setToolTipText("");
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel18MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Wastage Handling");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BarManagementFunction/wastage.png"))); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel21.setBackground(new java.awt.Color(85, 68, 118));
        jPanel21.setToolTipText("");
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel21MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Account Handling");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BarManagementFunction/financial.png"))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Bar Inventory");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Management");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addGap(58, 58, 58)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1609, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(new java.awt.Color(54, 33, 89));
        jPanel3.setPreferredSize(new java.awt.Dimension(2205, 154));

        jPanel4.setBackground(new java.awt.Color(54, 33, 89));

        jLabel2.setText("jLabel2");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 80)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("H o t e l K a b a l a n a");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("jLabel27");

        jButton2.setBackground(new java.awt.Color(54, 33, 89));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Log Out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo (1).png"))); // NOI18N
        jLabel28.setText("jLabel28");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

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

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Matara Rd, Ahangama 80650");

        jButton5.setBackground(new java.awt.Color(54, 33, 89));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Home");
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 587, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(143, 143, 143))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton5)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30))
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2449, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.CardLayout());

        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel77.setText("Product ID");

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel103.setText("Product Name");

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel80.setText("Standard Unit");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setText("Amount Per Unit");

        jLabel104.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel104.setText("Price Per Unit");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel49.setText("Select Date");

        jTextField70.setEditable(false);
        jTextField70.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.productid}"), jTextField70, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField70ActionPerformed(evt);
            }
        });
        jTextField70.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField70KeyReleased(evt);
            }
        });

        jTextField71.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.productname}"), jTextField71, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField71ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "LITRE", "MILLILITRE", "GRAM", "KILOGRAM", "CAN", "GALLOON", "BOTTLE", "GLASS", "PLATE", "ITEM" }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.standardunit}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField72.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.amountperunit}"), jTextField72, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField72ActionPerformed(evt);
            }
        });
        jTextField72.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField72KeyTyped(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.priceperunit}"), jTextField5, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jButton39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton39.setText("ADD");
        jButton39.setBorder(null);
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton41.setText("UPDATE");
        jButton41.setBorder(null);
        jButton41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton41MouseClicked(evt);
            }
        });
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton42.setText("DELETE");
        jButton42.setBorder(null);
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, barstockcontrolList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productid}"));
        columnBinding.setColumnName("Productid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productname}"));
        columnBinding.setColumnName("Productname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${standardunit}"));
        columnBinding.setColumnName("Standardunit");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${amountperunit}"));
        columnBinding.setColumnName("Amountperunit");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${priceperunit}"));
        columnBinding.setColumnName("Priceperunit");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel103)
                            .addComponent(jLabel80)
                            .addComponent(jLabel77)
                            .addComponent(jLabel10)
                            .addComponent(jLabel104)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooser6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField71, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField70, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 138, Short.MAX_VALUE)
                            .addComponent(jTextField72, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel103, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField71, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel80)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel104)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(183, Short.MAX_VALUE))
        );

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel48.setText("BAR STOCK CONTROL");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(520, 520, 520)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2863, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1521, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6, "card2");

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setText("OrderNumber");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel112.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel112.setText("Order Type");

        jLabel118.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel118.setText("Product ID");

        jLabel119.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel119.setText("Product Name");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jRadioButton1.setText("POS");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jRadioButton2.setText("EVENT");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTextField82.setEditable(false);
        jTextField82.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable2, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.productid}"), jTextField82, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField82ActionPerformed(evt);
            }
        });
        jTextField82.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField82KeyReleased(evt);
            }
        });

        jTextField83.setEditable(false);
        jTextField83.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable2, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.productname}"), jTextField83, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField84.setEditable(false);
        jTextField84.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable2, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.standardunit}"), jTextField84, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel120.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel120.setText("Standard Unit");

        jLabel121.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel121.setText("Amount Per Unit");

        jLabel122.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel122.setText("Price Per Unit");

        jLabel123.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel123.setText("Quantity");

        jTextField85.setEditable(false);
        jTextField85.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable2, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.amountperunit}"), jTextField85, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField86.setEditable(false);
        jTextField86.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable2, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.priceperunit}"), jTextField86, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField86ActionPerformed(evt);
            }
        });

        jTextField87.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField87.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField87KeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Calculate Amount");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel109.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel109.setText("Order Amount Rs.");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel24.setText("Select Date");

        jTextField42.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField42ActionPerformed(evt);
            }
        });

        jButton43.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton43.setText("ADD");
        jButton43.setBorder(null);
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, barstockcontrolList1, jTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productid}"));
        columnBinding.setColumnName("Productid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productname}"));
        columnBinding.setColumnName("Productname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${standardunit}"));
        columnBinding.setColumnName("Standardunit");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${amountperunit}"));
        columnBinding.setColumnName("Amountperunit");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${priceperunit}"));
        columnBinding.setColumnName("Priceperunit");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel23Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel24)
                                            .addGap(33, 33, 33)
                                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel23Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jLabel109)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel119)
                                            .addComponent(jLabel120)
                                            .addComponent(jLabel123)
                                            .addComponent(jLabel112)
                                            .addComponent(jLabel122)
                                            .addComponent(jLabel121))
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField85, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jTextField87, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField86, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextField83, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField84, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField82, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel23Layout.createSequentialGroup()
                                                .addComponent(jRadioButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton2))))
                                    .addComponent(jLabel118)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(85, 85, 85)))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(31, 31, 31)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel118)
                    .addComponent(jTextField82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel119))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel120))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel121)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTextField85, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel122)
                    .addComponent(jTextField86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel123)
                    .addComponent(jTextField87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109))
                .addGap(29, 29, 29)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel65.setText("ID");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel17.setText("Order Number");

        jLabel113.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel113.setText("Order Type");

        jLabel125.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel125.setText("Product ID");

        jLabel126.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel126.setText("Product Name");

        jLabel127.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel127.setText("Standard Unit");

        jLabel128.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel128.setText("Amount Per Unit");

        jLabel129.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel129.setText("Price Per Unit");

        jLabel130.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel130.setText("Quantity");

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.id}"), jTextField10, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.orderid}"), jTextField3, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jRadioButton3.setText("POS");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.ordertype}"), jRadioButton3, org.jdesktop.beansbinding.BeanProperty.create("selectedIcon"));
        bindingGroup.addBinding(binding);

        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jRadioButton4.setText("EVENT");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.ordertype}"), jRadioButton4, org.jdesktop.beansbinding.BeanProperty.create("selectedIcon"));
        bindingGroup.addBinding(binding);

        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jTextField88.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.orderpid}"), jTextField88, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField88ActionPerformed(evt);
            }
        });
        jTextField88.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField88KeyReleased(evt);
            }
        });

        jTextField89.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.orderpname}"), jTextField89, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField90.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.stunit}"), jTextField90, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField93.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.apunit}"), jTextField93, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField92.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.ppunit}"), jTextField92, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField92ActionPerformed(evt);
            }
        });

        jTextField91.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.quantity}"), jTextField91, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField91.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField91KeyTyped(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Calculate Amount");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel110.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel110.setText("Order Amount Rs.");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel25.setText("Select Date");

        jTextField48.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.orderamount}"), jTextField48, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField48ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setText("UPDATE");
        jButton7.setBorder(null);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setText("DELETE");
        jButton9.setBorder(null);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, barordersList, jTable3);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderid}"));
        columnBinding.setColumnName("Orderid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ordertype}"));
        columnBinding.setColumnName("Ordertype");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderpid}"));
        columnBinding.setColumnName("Orderpid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderpname}"));
        columnBinding.setColumnName("Orderpname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${stunit}"));
        columnBinding.setColumnName("Stunit");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${apunit}"));
        columnBinding.setColumnName("Apunit");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ppunit}"));
        columnBinding.setColumnName("Ppunit");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderamount}"));
        columnBinding.setColumnName("Orderamount");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel128, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel24Layout.createSequentialGroup()
                                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel126)
                                                    .addComponent(jLabel127)
                                                    .addComponent(jLabel130)
                                                    .addComponent(jLabel113)
                                                    .addComponent(jLabel129))
                                                .addGap(14, 14, 14))
                                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(35, 35, 35)
                                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField93, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField88, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jRadioButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRadioButton4))
                                            .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField92, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField91, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField90)
                                            .addComponent(jTextField89)))
                                    .addComponent(jLabel125, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel110)
                                            .addComponent(jLabel25))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel24Layout.createSequentialGroup()
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)))))
                        .addGap(0, 282, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel125)
                    .addComponent(jTextField88, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel126))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel127))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel128)
                    .addComponent(jTextField93, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel129)
                    .addComponent(jTextField92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel130))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel67.setText("Order Number");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.ordersid}"), jTextField4, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jButton44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton44.setText("Calculate Total Amount");
        jButton44.setBorder(null);
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel68.setText("Calculated Total Amount");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Rs.");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.calamount}"), jTextField6, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel69.setText("Select Discount");

        buttonGroup3.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jRadioButton6.setText("YES");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.discountselect}"), jRadioButton6, org.jdesktop.beansbinding.BeanProperty.create("selectedIcon"));
        bindingGroup.addBinding(binding);

        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jRadioButton7.setText("NO");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.discountselect}"), jRadioButton7, org.jdesktop.beansbinding.BeanProperty.create("selectedIcon"));
        bindingGroup.addBinding(binding);

        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel70.setText("Discount Amount");

        jButton45.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton45.setText("Calculate Total Bill");
        jButton45.setBorder(null);
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.discount}"), jTextField9, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel71.setText("Total Bill");

        jTextField49.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.totalbill}"), jTextField49, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel72.setText("Order Status");

        buttonGroup4.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jRadioButton5.setText("PAID");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.status}"), jRadioButton5, org.jdesktop.beansbinding.BeanProperty.create("selectedIcon"));
        bindingGroup.addBinding(binding);

        buttonGroup4.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jRadioButton8.setText("NOT PAID");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.status}"), jRadioButton8, org.jdesktop.beansbinding.BeanProperty.create("selectedIcon"));
        bindingGroup.addBinding(binding);

        jButton46.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jButton46.setText("Generate Receipt");
        jButton46.setBorder(null);
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jButton47.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jButton47.setText("Print Receipt");
        jButton47.setBorder(null);
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton48.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jButton48.setText("Reset");
        jButton48.setBorder(null);
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel73.setText("Select Date");

        jButton49.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton49.setText("ADD");
        jButton49.setBorder(null);
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        jButton50.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton50.setText("UPDATE");
        jButton50.setBorder(null);
        jButton50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton50MouseClicked(evt);
            }
        });
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        jButton51.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton51.setText("DELETE");
        jButton51.setBorder(null);
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, barorderbillList1, jTable4);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ordersid}"));
        columnBinding.setColumnName("Ordersid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${calamount}"));
        columnBinding.setColumnName("Calamount");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${discountselect}"));
        columnBinding.setColumnName("Discountselect");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${discount}"));
        columnBinding.setColumnName("Discount");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalbill}"));
        columnBinding.setColumnName("Totalbill");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${status}"));
        columnBinding.setColumnName("Status");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71)
                            .addComponent(jLabel72)
                            .addComponent(jLabel73))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jRadioButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton8))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(337, 337, 337))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addComponent(jLabel69)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton7))
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel68)
                                            .addGroup(jPanel25Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel25Layout.createSequentialGroup()
                                            .addComponent(jLabel67)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel25Layout.createSequentialGroup()
                                            .addComponent(jLabel70)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel67)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel68)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel69)
                            .addComponent(jRadioButton6)
                            .addComponent(jRadioButton7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel71))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton8)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel73))
                        .addGap(31, 31, 31)))
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel74.setText("BAR ORDER CONTROL");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(607, 607, 607)
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2536, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(1463, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel7, "card3");

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel75.setText("BAR WASTAGE HANDLING");

        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel76.setText("Wastage ID");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Total Wastage Rs.");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Select Date");

        jTextField11.setEditable(false);
        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable5, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.wastageid}"), jTextField11, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable5, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.wastageamount}"), jTextField50, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField50ActionPerformed(evt);
            }
        });
        jTextField50.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField50KeyTyped(evt);
            }
        });

        jButton52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton52.setText("ADD");
        jButton52.setBorder(null);
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jButton53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton53.setText("DELETE");
        jButton53.setBorder(null);
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        jButton25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton25.setText("SUBMIT");
        jButton25.setBorder(null);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jTable5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, barwastageList, jTable5);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${wastageid}"));
        columnBinding.setColumnName("Wastageid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${wastageamount}"));
        columnBinding.setColumnName("Wastageamount");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane6.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(124, 124, 124))
                        .addGroup(jPanel26Layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel29)
                                .addComponent(jLabel76))))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(527, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29)
                    .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(466, 466, 466)
                        .addComponent(jLabel75)))
                .addContainerGap(2867, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1732, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel8, "card4");

        jPanel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel11.setText("Income ID");

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel78.setText("Select Month End Date");

        jButton54.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton54.setText("Calculate Total Income");
        jButton54.setBorder(null);
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        jTextField13.setEditable(false);
        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable6, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.incomeid}"), jTextField13, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel16.setText("Total Income");

        jTextField51.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable6, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.totalincome}"), jTextField51, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField51.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField51KeyTyped(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("ADD");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton18.setText("DELETE");
        jButton18.setBorder(null);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton19.setText("SUBMIT");
        jButton19.setBorder(null);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jTable6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, barincomeList, jTable6);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${incomeid}"));
        columnBinding.setColumnName("Incomeid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalincome}"));
        columnBinding.setColumnName("Totalincome");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${monthenddate}"));
        columnBinding.setColumnName("Monthenddate");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane7.setViewportView(jTable6);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel27Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel11)
                                .addGap(58, 58, 58)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel27Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel27Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(59, 59, 59)
                                .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel78)
                .addGap(18, 18, 18)
                .addComponent(jDateChooser9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel78)
                    .addComponent(jDateChooser9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel38.setText("BAR ACCOUNT HANDLING ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(442, 442, 442)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(3079, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1634, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel9, "card5");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, barstockcontrolList2, jTable7);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productid}"));
        columnBinding.setColumnName("Productid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productname}"));
        columnBinding.setColumnName("Productname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${standardunit}"));
        columnBinding.setColumnName("Standardunit");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${amountperunit}"));
        columnBinding.setColumnName("Amountperunit");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${priceperunit}"));
        columnBinding.setColumnName("Priceperunit");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane8.setViewportView(jTable7);

        jTable8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, barincomeList1, jTable8);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${incomeid}"));
        columnBinding.setColumnName("Incomeid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalincome}"));
        columnBinding.setColumnName("Totalincome");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${monthenddate}"));
        columnBinding.setColumnName("Monthenddate");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane9.setViewportView(jTable8);

        jButton23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton23.setText("Generate Product Report");
        jButton23.setBorder(null);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton22.setText("Generate Income Report");
        jButton22.setBorder(null);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel18.setText("GENERATE REPORT");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(458, 458, 458)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(368, 368, 368)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(378, 378, 378)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(517, 517, 517)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1679, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(521, 521, 521)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel18)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1371, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel10, "card6");

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField70ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField70ActionPerformed

    private void jTextField70KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField70KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField70KeyReleased

    private void jTextField71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField71ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField71ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField72ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField72ActionPerformed

    private void jTextField72KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField72KeyTyped
        if (!(Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField72KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped

        if (!(Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed

        //Validate Bar stock control empty fields

        if (validateInput() == true) {

            String productname = jTextField71.getText();
            double amountperunit = Double.parseDouble(jTextField72.getText());
            double priceperunit = Double.parseDouble(jTextField5.getText());

            //            if(jTextField71.getText().isEmpty()){
                //                JOptionPane.showMessageDialog(null,"Product name is require");
                //            }
            ////            else if(jTextField72.getText().isEmpty()){
                ////                JOptionPane.showMessageDialog(null,"Product name is require");
                ////            }else if(jTextField5.getText().isEmpty()){
                ////                JOptionPane.showMessageDialog(null,"Product name is require");
                ////            }else if(date.equals("")){
                ////                JOptionPane.showMessageDialog(null,"Product name is require");
                ////            }

            try {

                Class.forName("java.sql.DriverManager");
                String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                Connection con = DriverManager.getConnection(url);

                Date d = jDateChooser6.getDate();
                String date = new SimpleDateFormat("MM/dd/YYY").format(d);

                String standardunit = (String) jComboBox1.getSelectedItem();

                //insert data into bar stock control table

                Statement s = con.createStatement();
                s.execute("insert into barstockcontrol(productname,standardunit,amountperunit,priceperunit,date) values ('" + productname + "','"+ standardunit+"'," + amountperunit + "," + priceperunit + ",'" + date + "')");

                //clear all the textfields
                jTextField71.setText("");
                jTextField72.setText("");
                jTextField5.setText("");

                //set combobox from selected item to "SELECT"
                jComboBox1.setSelectedItem("SELECT");

                String sql = "SELECT * FROM BARSTOCKCONTROL";
                PreparedStatement statement1 = con.prepareStatement(sql);
                ResultSet rs = statement1.executeQuery();
                barstockcontrolList.clear();

                while(rs.next()){

                    Barstockcontrol barstockcontrol = new Barstockcontrol();

                    jComboBox1.addItem(rs.getString("STANDARDUNIT"));
                    jComboBox1.getSelectedItem();

                    barstockcontrol.setProductid(rs.getInt(1));
                    barstockcontrol.setProductname(rs.getString(2));
                    barstockcontrol.setStandardunit(rs.getString(3));
                    barstockcontrol.setAmountperunit(rs.getDouble(4));
                    barstockcontrol.setPriceperunit(rs.getDouble(5));
                    barstockcontrol.setDate(rs.getDate(6));

                    barstockcontrolList.add(barstockcontrol);

                }

                //display a successfully data inserted message
                JOptionPane.showMessageDialog(this, "Records Submitted Successfully !");

                //Refresh the table after data is inserted
                refreshTablebarstock(barstockcontrolList);

            } catch (Exception ex) {

                //show error message
                JOptionPane.showMessageDialog(this, ex);

            }

        } else {

            //display an error message when field is empty
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton41MouseClicked

        try {

            Class.forName("java.sql.DriverManager");
            String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
            Connection con = DriverManager.getConnection(url);

            barproductid = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("select from barstockcontrol where productid=" + barproductid);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton41MouseClicked

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed

        //Validate Bar stock control empty fields

        if (validateInput() == true) {
            if (barproductid != 0) {

                String productname = jTextField71.getText();
                double amountperunit = Double.parseDouble(jTextField72.getText());
                double priceperunit = Double.parseDouble(jTextField5.getText());

                try {

                    Class.forName("java.sql.DriverManager");
                    String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                    Connection con = DriverManager.getConnection(url);

                    String standardunit = (String) jComboBox1.getSelectedItem();

                    //update data of bar stock control table

                    Statement smt = con.createStatement();
                    smt.execute("update barstockcontrol set productname ='" + productname + "',standardunit='"+standardunit+"',amountperunit=" + amountperunit + ",priceperunit=" + priceperunit + " where productid=" + barproductid);

                    String sql = "SELECT * FROM BARSTOCKCONTROL";
                    PreparedStatement statement1 = con.prepareStatement(sql);
                    ResultSet rs = statement1.executeQuery();
                    barstockcontrolList.clear();

                    //clear all the entered data in the textfields
                    jTextField70.setText("");
                    jTextField71.setText("");
                    jTextField72.setText("");
                    jTextField5.setText("");

                    //set combobox from selected item to "SELECT"
                    jComboBox1.setSelectedItem("SELECT");

                    while(rs.next()){

                        Barstockcontrol barstockcontrol = new Barstockcontrol();

                        jComboBox1.addItem(rs.getString("STANDARDUNIT"));
                        jComboBox1.getSelectedItem();

                        barstockcontrol.setProductid(rs.getInt(1));
                        barstockcontrol.setProductname(rs.getString(2));
                        barstockcontrol.setStandardunit(rs.getString(3));
                        barstockcontrol.setAmountperunit(rs.getDouble(4));
                        barstockcontrol.setPriceperunit(rs.getDouble(5));
                        barstockcontrol.setDate(rs.getDate(6));

                        barstockcontrolList.add(barstockcontrol);

                    }

                    //display a successfully data updated message

                    JOptionPane.showMessageDialog(this, "Records Updated Successfully !");

                    //Refresh the table after data is update

                    refreshTablebarstock(barstockcontrolList);

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(this, ex);

                }
            }

        } else {

            //display an error message when field is empty
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed

        //Validate Bar stock control empty fields

        if (validateInput() == true) {

            try {

                Class.forName("java.sql.DriverManager");
                String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                Connection con = DriverManager.getConnection(url);

                //delete data from bar stock control table

                String sql = "DELETE FROM barstockcontrol WHERE productid = ?";

                PreparedStatement statement = con.prepareStatement(sql);

                statement.setInt(1, Integer.parseInt(jTextField70.getText()));
                statement.executeUpdate();

                jTextField70.setText("");
                jTextField71.setText("");
                jTextField72.setText("");
                jTextField5.setText("");

                //set combobox from selected item to "SELECT"

                jComboBox1.setSelectedItem("SELECT");

                String sql3 = "SELECT * FROM BARSTOCKCONTROL";
                PreparedStatement statement1 = con.prepareStatement(sql3);
                ResultSet rs = statement1.executeQuery();
                barstockcontrolList.clear();

                while(rs.next()){

                    Barstockcontrol barstockcontrol = new Barstockcontrol();

                    jComboBox1.addItem(rs.getString("STANDARDUNIT"));
                    jComboBox1.getSelectedItem();

                    barstockcontrol.setProductid(rs.getInt(1));
                    barstockcontrol.setProductname(rs.getString(2));
                    barstockcontrol.setStandardunit(rs.getString(3));
                    barstockcontrol.setAmountperunit(rs.getDouble(4));
                    barstockcontrol.setPriceperunit(rs.getDouble(5));
                    barstockcontrol.setDate(rs.getDate(6));

                    barstockcontrolList.add(barstockcontrol);

                }

                //display a data removed message
                JOptionPane.showMessageDialog(this, "Details Removed Successfully !");

                //refresh table after delete
                org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, barstockcontrolList, jTable1);
                org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productid}"));
                columnBinding.setColumnName("Productid");
                columnBinding.setColumnClass(Integer.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productname}"));
                columnBinding.setColumnName("Productname");
                columnBinding.setColumnClass(String.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${standardunit}"));
                columnBinding.setColumnName("Standardunit");
                columnBinding.setColumnClass(String.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${amountperunit}"));
                columnBinding.setColumnName("Amountperunit");
                columnBinding.setColumnClass(Double.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${priceperunit}"));
                columnBinding.setColumnName("Priceperunit");
                columnBinding.setColumnClass(Double.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
                columnBinding.setColumnName("Date");
                columnBinding.setColumnClass(java.util.Date.class);
                bindingGroup.addBinding(jTableBinding);
                jTableBinding.bind();

            } catch (Exception e) {

                System.out.println(e.getMessage());

            }
        } else {

            //display an error message when field is empty
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        //        ordertypes="POS";

        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed

        //        ordertypes="EVENT";
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTextField82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField82ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField82ActionPerformed

    private void jTextField82KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField82KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField82KeyReleased

    private void jTextField86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField86ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField86ActionPerformed

    private void jTextField87KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField87KeyTyped

        if (!(Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField87KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        double i = Double.parseDouble(jTextField86.getText());
        double j = Double.parseDouble(jTextField87.getText());
        double y = i * j;

        jTextField42.setText(Double.toString(y));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed

        //Validate Bar order empty fields
        if(validateroder()==true){

            int orderid = Integer.parseInt(jTextField2.getText());
            int orderpid = Integer.parseInt(jTextField82.getText());
            String orderpname = jTextField83.getText();
            String stunit = jTextField84.getText();
            double apunit = Double.parseDouble(jTextField85.getText());
            double ppunit = Double.parseDouble(jTextField86.getText());
            double quantity = Double.parseDouble(jTextField87.getText());
            double orderamount = Double.parseDouble(jTextField42.getText());
            String ordertype = "";

            //select radio buttons
            if (jRadioButton1.isSelected()) {
                ordertype = "POS";
            } else if (jRadioButton2.isSelected()) {
                ordertype = "EVENT";
            }

            try {

                Class.forName("java.sql.DriverManager");
                String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                Connection con = DriverManager.getConnection(url);

                Date d = jDateChooser3.getDate();
                String date = new SimpleDateFormat("MM/dd/YYY").format(d);

                //insert data into barorders table
                Statement s = con.createStatement();
                s.execute("insert into barorders(orderid,ordertype,orderpid,orderpname,stunit,apunit,ppunit,quantity,orderamount,date) values (" + orderid + ",'" + ordertype + "'," + orderpid + ",'" + orderpname + "','" + stunit + "'," + apunit + "," + ppunit + "," + quantity + "," + orderamount + ",'" + date + "')");

                //clear all the textfields
                jTextField2.setText("");
                jTextField82.setText("");
                jTextField83.setText("");
                jTextField84.setText("");
                jTextField85.setText("");
                jTextField86.setText("");
                jTextField87.setText("");
                jTextField42.setText("");

                String sql1 = "SELECT * FROM BARORDERS";
                PreparedStatement statement1 = con.prepareStatement(sql1);
                ResultSet rs1 = statement1.executeQuery();
                barordersList.clear();

                while(rs1.next()){

                    Barorders barorders = new Barorders();

                    barorders.setId(rs1.getInt(1));
                    barorders.setOrderid(rs1.getInt(2));
                    barorders.setOrdertype(rs1.getString(3));
                    barorders.setOrderpid(rs1.getInt(4));
                    barorders.setOrderpname(rs1.getString(5));
                    barorders.setStunit(rs1.getString(6));
                    barorders.setApunit(rs1.getDouble(7));
                    barorders.setPpunit(rs1.getDouble(8));
                    barorders.setQuantity(rs1.getDouble(9));
                    barorders.setOrderamount(rs1.getDouble(10));
                    barorders.setDate(rs1.getDate(11));

                    barordersList.add(barorders);

                }

                //display a successfully data inserted message
                JOptionPane.showMessageDialog(this, "Details Insereted Successfully !");

                //Refresh the table after data is inserted
                refreshTablebarorder(barordersList);

            } catch (Exception ex) {

                //show error message
                ex.printStackTrace();
               // JOptionPane.showMessageDialog(this, ex);

            }

        }else{

            //display an error message when field is empty
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jTextField88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField88ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField88ActionPerformed

    private void jTextField88KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField88KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField88KeyReleased

    private void jTextField92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField92ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField92ActionPerformed

    private void jTextField91KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField91KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField91KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        double i1 = Double.parseDouble(jTextField91.getText());
        double j1 = Double.parseDouble(jTextField92.getText());
        double y1 = i1 * j1;

        jTextField48.setText(Double.toString(y1));
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField48ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField48ActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked

        try {

            Class.forName("java.sql.DriverManager");
            String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
            Connection con = DriverManager.getConnection(url);

            barid = Integer.parseInt(jTable4.getValueAt(jTable4.getSelectedRow(), 0).toString());
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("select from barorders where id=" + barid);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        //Validate Bar order empty fields
        if (validateroderedit() == true) {

            if (barid != 0) {

                int orderid = Integer.parseInt(jTextField3.getText());
                int orderpid = Integer.parseInt(jTextField88.getText());
                String orderpname = jTextField89.getText();
                String stunit = jTextField90.getText();
                double apunit = Double.parseDouble(jTextField93.getText());
                double ppunit = Double.parseDouble(jTextField92.getText());
                double quantity = Double.parseDouble(jTextField91.getText());
                double orderamount = Double.parseDouble(jTextField48.getText());
                String ordertype = "";

                //select radio buttons
                if (jRadioButton3.isSelected()) {
                    ordertype = "POS";
                } else if (jRadioButton4.isSelected()) {
                    ordertype = "EVENT";
                }

                try {

                    Class.forName("java.sql.DriverManager");
                    String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                    Connection con = DriverManager.getConnection(url);

                    //update data of barorders table
                    Statement smt = con.createStatement();
                    smt.execute("update barorders set orderid =" + orderid + ",ordertype='"+ordertype+"',orderpid="+orderpid+",orderpname='" + orderpname + "',stunit='" +stunit + "',apunit="+apunit+",ppunit="+ppunit+",quantity="+quantity+",orderamount="+orderamount+" where id=" + barid);

                    String sql1 = "SELECT * FROM BARORDERS";
                    PreparedStatement statement1 = con.prepareStatement(sql1);
                    ResultSet rs1 = statement1.executeQuery();
                    barordersList.clear();

                    while(rs1.next()){

                        Barorders barorders = new Barorders();

                        barorders.setId(rs1.getInt(1));
                        barorders.setOrderid(rs1.getInt(2));
                        barorders.setOrdertype(rs1.getString(3));
                        barorders.setOrderpid(rs1.getInt(4));
                        barorders.setOrderpname(rs1.getString(5));
                        barorders.setStunit(rs1.getString(6));
                        barorders.setApunit(rs1.getDouble(7));
                        barorders.setPpunit(rs1.getDouble(8));
                        barorders.setQuantity(rs1.getDouble(9));
                        barorders.setOrderamount(rs1.getDouble(10));
                        barorders.setDate(rs1.getDate(11));

                        barordersList.add(barorders);

                    }

                    //display a successfully data inserted message
                    JOptionPane.showMessageDialog(this, "Details Updated Successfully !");

                    //Refresh the table after data is inserted
                    refreshTablebarorder(barordersList);

                } catch (Exception ex) {

                    //show error message
                    JOptionPane.showMessageDialog(this, ex);

                }

            }

        } else {

            //display an error message when field is empty
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        //Validate Bar order empty fields
        if (validateroderedit() == true) {

            try {

                Class.forName("java.sql.DriverManager");
                String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                Connection con = DriverManager.getConnection(url);

                //delete data from barorders table
                String sql = "DELETE FROM barorders WHERE id = ?";

                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt(jTextField10.getText()));
                statement.executeUpdate();

                //clear all the textfields
                jTextField10.setText("");
                jTextField3.setText("");
                jTextField88.setText("");
                jTextField89.setText("");
                jTextField90.setText("");
                jTextField93.setText("");
                jTextField92.setText("");
                jTextField91.setText("");
                jTextField48.setText("");

                String sql1 = "SELECT * FROM BARORDERS";
                PreparedStatement statement1 = con.prepareStatement(sql1);
                ResultSet rs1 = statement1.executeQuery();
                barordersList.clear();

                while(rs1.next()){

                    Barorders barorders = new Barorders();

                    barorders.setId(rs1.getInt(1));
                    barorders.setOrderid(rs1.getInt(2));
                    barorders.setOrdertype(rs1.getString(3));
                    barorders.setOrderpid(rs1.getInt(4));
                    barorders.setOrderpname(rs1.getString(5));
                    barorders.setStunit(rs1.getString(6));
                    barorders.setApunit(rs1.getDouble(7));
                    barorders.setPpunit(rs1.getDouble(8));
                    barorders.setQuantity(rs1.getDouble(9));
                    barorders.setOrderamount(rs1.getDouble(10));
                    barorders.setDate(rs1.getDate(11));

                    barordersList.add(barorders);

                }

                //display a successfully data deleted message
                JOptionPane.showMessageDialog(this, "Details Removed Successfully !");

                //refresh table after delete
                org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, barordersList, jTable3);
                org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderid}"));
                columnBinding.setColumnName("Orderid");
                columnBinding.setColumnClass(Integer.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ordertype}"));
                columnBinding.setColumnName("Ordertype");
                columnBinding.setColumnClass(String.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderpid}"));
                columnBinding.setColumnName("Orderpid");
                columnBinding.setColumnClass(Integer.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderpname}"));
                columnBinding.setColumnName("Orderpname");
                columnBinding.setColumnClass(String.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${stunit}"));
                columnBinding.setColumnName("Stunit");
                columnBinding.setColumnClass(String.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${apunit}"));
                columnBinding.setColumnName("Apunit");
                columnBinding.setColumnClass(Double.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ppunit}"));
                columnBinding.setColumnName("Ppunit");
                columnBinding.setColumnClass(Double.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
                columnBinding.setColumnName("Quantity");
                columnBinding.setColumnClass(Double.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderamount}"));
                columnBinding.setColumnName("Orderamount");
                columnBinding.setColumnClass(Double.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
                columnBinding.setColumnName("Date");
                columnBinding.setColumnClass(java.util.Date.class);
                bindingGroup.addBinding(jTableBinding);
                jTableBinding.bind();

            } catch (Exception e) {

                //show error message
                System.out.println(e.getMessage());

            }

        } else {

            //display an error message when field is empty
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed

        int id = Integer.parseInt(jTextField4.getText());

        try {

            Class.forName("java.sql.DriverManager");
            String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
            Connection con = DriverManager.getConnection(url);
            Statement s = con.createStatement();

            //calculate the total bill of one order number
            String sql = "select ORDERAMOUNT from barorders where orderid= "+jTextField4.getText()+"";
            ResultSet rs =  s.executeQuery(sql);
            double i = 0;
            while(rs.next()){
                i = i+ Double.parseDouble(rs.getString(1));
            }

            jTextField6.setText(Double.toString(i));

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, ex);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed

        //enable the text field when select "YES"
        jTextField9.setEditable(TRUE);

        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed

        //disable the text field when select "NO"
        jTextField9.setEditable(FALSE);
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed

        double i2 = Double.parseDouble(jTextField6.getText());
        double j2 = Double.parseDouble(jTextField9.getText());
        double y2 = i2 * j2;

        jTextField49.setText(Double.toString(y2));

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed

        jTextArea1.setText("**************** RECEIPT ****************\n\n\n");

        jTextArea1.setText(jTextArea1.getText()+"Date: "+jDateChooser7.getDate()+"\n\n");
        jTextArea1.setText(jTextArea1.getText()+"Order Number: "+jTextField4.getText()+"\n\n");
        jTextArea1.setText(jTextArea1.getText()+"Discount: "+jTextField9.getText()+"\n\n");
        jTextArea1.setText(jTextArea1.getText()+"Total Bill: "+jTextField49.getText()+"\n\n\n");
        jTextArea1.setText(jTextArea1.getText()+"         -------------------------------"+"\n");
        jTextArea1.setText(jTextArea1.getText()+"                      Signature");

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed

        //print the generated reciept

        try {

            jTextArea1.print();

        } catch (Exception e) {

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed

        //clear teaxtfields and teaxtarea
        jTextArea1.setText("");
        jTextField4.setText("");
        jTextField6.setText("");
        jTextField9.setText("");
        jTextField49.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed

        //Validate Bar order bill empty fields
        if (validatebill() == true) {

            int ordersid = Integer.parseInt(jTextField4.getText());
            double calamount = Double.parseDouble(jTextField6.getText());
            double discount = Double.parseDouble(jTextField9.getText());
            double totalbill = Double.parseDouble(jTextField49.getText());
            String selectdiscount = "";
            String status = "";

            //select radio buttons
            if (jRadioButton6.isSelected()) {
                selectdiscount = "YES";
            } else if (jRadioButton7.isSelected()) {
                selectdiscount = "NO";
            }

            if (jRadioButton5.isSelected()) {
                status = "PAID";
            } else if (jRadioButton8.isSelected()) {
                status = "NOT PAID";
            }

            try {

                Class.forName("java.sql.DriverManager");
                String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                Connection con = DriverManager.getConnection(url);

                Date d = jDateChooser7.getDate();
                String date = new SimpleDateFormat("MM/dd/YYY").format(d);

                Statement s = con.createStatement();

                //insert data into barorderbill table
                s.execute("insert into barorderbill(ordersid,calamount,discountselect,discount,totalbill,status,date) values (" + ordersid + "," + calamount + ",'"+selectdiscount+"'," + discount + "," + totalbill + ",'"+status+"','" + date + "')");

                //clear all the textfields
                jTextField4.setText("");
                jTextField6.setText("");
                jTextField9.setText("");
                jTextField49.setText("");

                String sql2 = "SELECT * FROM BARORDERBILL";
                PreparedStatement statement1 = con.prepareStatement(sql2);
                ResultSet rs2 = statement1.executeQuery();
                barorderbillList.clear();

                while(rs2.next()){

                    Barorderbill barorderbill = new Barorderbill();

                    barorderbill.setOrdersid(rs2.getInt(1));
                    barorderbill.setCalamount(rs2.getDouble(2));
                    barorderbill.setDiscountselect(rs2.getString(3));
                    barorderbill.setDiscount(rs2.getDouble(4));
                    barorderbill.setTotalbill(rs2.getDouble(5));
                    barorderbill.setStatus(rs2.getString(6));
                    barorderbill.setDate(rs2.getDate(7));

                    barorderbillList.add(barorderbill);

                }

                //display a successfully data inserted message
                JOptionPane.showMessageDialog(this, "Details Insereted Successfully !");

                //Refresh the table after data is inserted
                refreshTablebarbill(barorderbillList);

            } catch (Exception ex) {

                //show error message
                JOptionPane.showMessageDialog(this, ex);

            }

        } else {

            //display an error message when field is empty
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton50MouseClicked

        try {

            Class.forName("java.sql.DriverManager");
            String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
            Connection con = DriverManager.getConnection(url);

            barordersid = Integer.parseInt(jTable7.getValueAt(jTable7.getSelectedRow(), 0).toString());
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("select from barorderbill where ordersid=" + barordersid);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton50MouseClicked

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed

        //Validate Bar income empty fields
        if (validatebill() == true) {

            if (barordersid != 0) {

                int ordersid = Integer.parseInt(jTextField4.getText());
                double calamount = Double.parseDouble(jTextField6.getText());
                double discount = Double.parseDouble(jTextField9.getText());
                double totalbill = Double.parseDouble(jTextField49.getText());
                String selectdiscount = "";
                String status = "";

                //select radio buttons
                if (jRadioButton6.isSelected()) {
                    selectdiscount = "YES";
                } else if (jRadioButton7.isSelected()) {
                    selectdiscount = "NO";
                }

                if (jRadioButton5.isSelected()) {
                    status = "PAID";
                } else if (jRadioButton8.isSelected()) {
                    status = "NOT PAID";
                }

                try {

                    Class.forName("java.sql.DriverManager");
                    String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                    Connection con = DriverManager.getConnection(url);

                    Statement smt = con.createStatement();

                    //update data of barincome table
                    smt.execute("update barorderbill set calamount=" + calamount + ",discountselect = '"+selectdiscount+"',discount=" + discount + ",totalbill=" + totalbill + ",status='"+status+"' where ordersid=" + barordersid);

                    //clear all the textfields
                    jTextField4.setText("");
                    jTextField6.setText("");
                    jTextField9.setText("");
                    jTextField49.setText("");

                    String sql2 = "SELECT * FROM BARORDERBILL";
                    PreparedStatement statement1 = con.prepareStatement(sql2);
                    ResultSet rs2 = statement1.executeQuery();
                    barorderbillList.clear();

                    while(rs2.next()){

                        Barorderbill barorderbill = new Barorderbill();

                        barorderbill.setOrdersid(rs2.getInt(1));
                        barorderbill.setCalamount(rs2.getDouble(2));
                        barorderbill.setDiscountselect(rs2.getString(3));
                        barorderbill.setDiscount(rs2.getDouble(4));
                        barorderbill.setTotalbill(rs2.getDouble(5));
                        barorderbill.setStatus(rs2.getString(6));
                        barorderbill.setDate(rs2.getDate(7));

                        barorderbillList.add(barorderbill);

                    }

                    //display a successfully data inserted message
                    JOptionPane.showMessageDialog(this, "Details Updated Successfully !");

                    //Refresh the table after data is inserted
                    refreshTablebarbill(barorderbillList);

                } catch (Exception ex) {

                    //show error message
                    JOptionPane.showMessageDialog(this, ex);

                }

            }

        } else {

            //display an error message when field is empty
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed

        //Validate Bar income empty fields
        if (validatebill() == true) {

            try {

                Class.forName("java.sql.DriverManager");
                String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                Connection con = DriverManager.getConnection(url);

                //delete data from barorderbill table
                String sql = "DELETE FROM barorderbill WHERE ordersid = ?";

                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt(jTextField4.getText()));
                statement.executeUpdate();

                //clear all the textfields
                jTextField4.setText("");
                jTextField6.setText("");
                jTextField9.setText("");
                jTextField49.setText("");

                String sql2 = "SELECT * FROM BARORDERBILL";
                PreparedStatement statement1 = con.prepareStatement(sql2);
                ResultSet rs2 = statement1.executeQuery();
                barorderbillList.clear();

                while(rs2.next()){

                    Barorderbill barorderbill = new Barorderbill();

                    barorderbill.setOrdersid(rs2.getInt(1));
                    barorderbill.setCalamount(rs2.getDouble(2));
                    barorderbill.setDiscountselect(rs2.getString(3));
                    barorderbill.setDiscount(rs2.getDouble(4));
                    barorderbill.setTotalbill(rs2.getDouble(5));
                    barorderbill.setStatus(rs2.getString(6));
                    barorderbill.setDate(rs2.getDate(7));

                    barorderbillList.add(barorderbill);

                }

                //display a successfully data deleted message
                JOptionPane.showMessageDialog(this, "Details Removed Successfully !");

                //refresh table after delete
                org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, barorderbillList, jTable4);
                org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ordersid}"));
                columnBinding.setColumnName("Ordersid");
                columnBinding.setColumnClass(Integer.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${calamount}"));
                columnBinding.setColumnName("Calamount");
                columnBinding.setColumnClass(Double.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${discountselect}"));
                columnBinding.setColumnName("Discountselect");
                columnBinding.setColumnClass(String.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${discount}"));
                columnBinding.setColumnName("Discount");
                columnBinding.setColumnClass(Double.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalbill}"));
                columnBinding.setColumnName("Totalbill");
                columnBinding.setColumnClass(Double.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${status}"));
                columnBinding.setColumnName("Status");
                columnBinding.setColumnClass(String.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
                columnBinding.setColumnName("Date");
                columnBinding.setColumnClass(java.util.Date.class);
                bindingGroup.addBinding(jTableBinding);
                jTableBinding.bind();

            } catch (Exception e) {

                //show error message
                System.out.println(e.getMessage());

            }

        } else {

            //display an error message when field is empty
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jTextField50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField50ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField50ActionPerformed

    private void jTextField50KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField50KeyTyped

        if (!(Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField50KeyTyped

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed

        //Validate Bar wastage empty fields
        if (validateWastage() == true) {

            double wastageamount = Double.parseDouble(jTextField50.getText());

            try {

                Class.forName("java.sql.DriverManager");
                String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                Connection con = DriverManager.getConnection(url);

                Date d = jDateChooser8.getDate();
                String date = new SimpleDateFormat("MM/dd/YYY").format(d);

                //insert data into barwastage table
                Statement s = con.createStatement();
                s.execute("insert into barwastage(wastageamount,date) values (" + wastageamount + ",'" + date + "')");

                //clear the textfield
                jTextField50.setText("");

                String sql2 = "SELECT * FROM BARWASTAGE";
                PreparedStatement statement1 = con.prepareStatement(sql2);
                ResultSet rs4 = statement1.executeQuery();
                barwastageList.clear();

                while(rs4.next()){

                    Barwastage barwastage = new Barwastage();

                    barwastage.setWastageid(rs4.getInt(1));
                    barwastage.setWastageamount(rs4.getDouble(2));
                    barwastage.setDate(rs4.getDate(3));

                    barwastageList.add(barwastage);

                }

                //display a successfully data inserted message
                JOptionPane.showMessageDialog(this, "Details Insereted Successfully !");

                //Refresh the table after data is inserted
                refreshTablebarwastage(barwastageList);

            } catch (Exception ex) {

                //show error message
                JOptionPane.showMessageDialog(this, ex);

            }

        } else {

            //display an error message when field is empty
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed

        //Validate Bar wastage empty fields

        if (validateWastage() == true) {

            try {

                Class.forName("java.sql.DriverManager");
                String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                Connection con = DriverManager.getConnection(url);

                //delete data from barwastage table

                String sql = "DELETE FROM barwastage WHERE wastageid = ?";

                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt(jTextField11.getText()));
                statement.executeUpdate();

                //clear all the textfields

                jTextField11.setText("");
                jTextField50.setText("");

                String sql2 = "SELECT * FROM BARWASTAGE";
                PreparedStatement statement1 = con.prepareStatement(sql2);
                ResultSet rs4 = statement1.executeQuery();
                barwastageList.clear();

                while(rs4.next()){

                    Barwastage barwastage = new Barwastage();

                    barwastage.setWastageid(rs4.getInt(1));
                    barwastage.setWastageamount(rs4.getDouble(2));
                    barwastage.setDate(rs4.getDate(3));

                    barwastageList.add(barwastage);

                }

                //display a successfully data deleted message
                JOptionPane.showMessageDialog(this, "Details Removed Successfully !");

                //refresh table after delete
                org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, barwastageList, jTable5);
                org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${wastageid}"));
                columnBinding.setColumnName("Wastageid");
                columnBinding.setColumnClass(Integer.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${wastageamount}"));
                columnBinding.setColumnName("Wastageamount");
                columnBinding.setColumnClass(Double.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
                columnBinding.setColumnName("Date");
                columnBinding.setColumnClass(java.util.Date.class);
                bindingGroup.addBinding(jTableBinding);
                jTableBinding.bind();

            } catch (Exception e) {

                //display a successfully data inserted message

                System.out.println(e.getMessage());

            }

        } else {
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed

        //Validate Bar wastage empty fields
        if (validateWastage() == true) {

            double barwastage = Double.parseDouble(jTextField50.getText());

            try {

                Class.forName("java.sql.DriverManager");
                String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                Connection con = DriverManager.getConnection(url);

                //insert data into financedetails table
                Statement s = con.createStatement();
                s.execute("insert into financedetails(barwastage) values (" + barwastage + ")");

                ////display a successfully data submitted message
                JOptionPane.showMessageDialog(this, "Details Submitted Successfully !");

                //clear the textfield
                jTextField50.setText("");

            } catch (Exception ex) {

                //show error message
                JOptionPane.showMessageDialog(this, ex);

            }

        } else {

            //display an error message when field is empty
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed

        //     String id = jTextField8.getText();

        //     Date d = jDateChooser1.getDate();
        //     String date = new SimpleDateFormat("MM/dd/YYY").format(d);
        //
        //     Date dd = jDateChooser9.getDate();
        //     String dated = new SimpleDateFormat("MM/dd/YYY").format(dd);

        try {

            Class.forName("java.sql.DriverManager");
            String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
            Connection con = DriverManager.getConnection(url);
            Statement s = con.createStatement();

            //calculate the total bills which have the 'PAID' status
            String sql = "select TOTALBILL from barorderbill where status='PAID'";

            //               String sql = "select TOTALBILL from barorderbill where status='PAID' AND Date between" + jDateChooser1.getDate()+"and"+jDateChooser9.getDate()+"";
            ResultSet rs = s.executeQuery(sql);

            double i = 0;
            while(rs.next()){
                i = i+ Double.parseDouble(rs.getString(1));
            }

            jTextField51.setText(Double.toString(i));

        } catch (Exception ex) {

            //show error message
            JOptionPane.showMessageDialog(this, ex);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jTextField51KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField51KeyTyped

        if (!(Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField51KeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        //Validate Bar income empty fields
        if (validateIncome() == true) {

            double totalincome = Double.parseDouble(jTextField51.getText());

            try {

                Class.forName("java.sql.DriverManager");
                String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                Connection con = DriverManager.getConnection(url);

                //                Date d1 = jDateChooser1.getDate();
                //                String date1 = new SimpleDateFormat("MM/dd/YYY").format(d1);

                Date d2 = jDateChooser9.getDate();
                String date2 = new SimpleDateFormat("MM/dd/YYY").format(d2);

                Statement s = con.createStatement();

                //insert data into barincome table
                s.execute("insert into barincome(totalincome,monthenddate) values (" + totalincome + ",'" + date2 + "')");

                //clear the textfield
                jTextField51.setText("");

                String sql2 = "SELECT * FROM BARINCOME";
                PreparedStatement statement1 = con.prepareStatement(sql2);
                ResultSet rs3 = statement1.executeQuery();
                barincomeList.clear();

                while(rs3.next()){

                    Barincome barincome = new Barincome();

                    barincome.setIncomeid(rs3.getInt(1));
                    barincome.setTotalincome(rs3.getDouble(2));
                    //                barincome.setMonthstartdate(rs3.getDate(3));
                    barincome.setMonthenddate(rs3.getDate(4));

                    barincomeList.add(barincome);

                }

                //display a successfully data inserted message
                JOptionPane.showMessageDialog(this, "Details Insereted Successfully !");

                //Refresh the table after data is inserted
                refreshTablebarincome(barincomeList);

            } catch (Exception ex) {

                //show error message
                JOptionPane.showMessageDialog(this, ex);

            }

        } else {

            //display an error message when field is empty
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

        //Validate Bar income empty fields
        if (validateIncome() == true) {

            try {

                Class.forName("java.sql.DriverManager");
                String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                Connection con = DriverManager.getConnection(url);

                //delete data from barincome table
                String sql = "DELETE FROM barincome WHERE incomeid = ?";

                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt(jTextField13.getText()));
                statement.executeUpdate();

                //clear all the textfields
                jTextField13.setText("");
                jTextField51.setText("");

                String sql2 = "SELECT * FROM BARINCOME";
                PreparedStatement statement1 = con.prepareStatement(sql2);
                ResultSet rs3 = statement1.executeQuery();
                barincomeList.clear();

                while(rs3.next()){

                    Barincome barincome = new Barincome();

                    barincome.setIncomeid(rs3.getInt(1));
                    barincome.setTotalincome(rs3.getDouble(2));
                    //                barincome.setMonthstartdate(rs3.getDate(3));
                    barincome.setMonthenddate(rs3.getDate(4));

                    barincomeList.add(barincome);

                }

                //display a successfully data deleted message
                JOptionPane.showMessageDialog(this, "Details Removed Successfully !");

                //refresh table after delete
                org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, barincomeList, jTable6);
                org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${monthstartdate}"));
                columnBinding.setColumnName("Monthstartdate");
                columnBinding.setColumnClass(java.util.Date.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${monthenddate}"));
                columnBinding.setColumnName("Monthenddate");
                columnBinding.setColumnClass(java.util.Date.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalincome}"));
                columnBinding.setColumnName("Totalincome");
                columnBinding.setColumnClass(Double.class);
                bindingGroup.addBinding(jTableBinding);
                jTableBinding.bind();

            } catch (Exception e) {

                //show error message
                System.out.println(e.getMessage());

            }

        } else {

            //display an error message when field is empty
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed

        //Validate Bar income empty fields
        if (validateIncome() == true) {

            double barincome = Double.parseDouble(jTextField2.getText());

            try {

                Class.forName("java.sql.DriverManager");
                String url = "jdbc:derby://localhost:1527/HotelManagement;user= root; password=root";
                Connection con = DriverManager.getConnection(url);

                Statement s = con.createStatement();

                //insert data into financedetails table
                s.execute("insert into financedetails(barincome) values (" + barincome + ")");

                //clear all the textfields
                jTextField13.setText("");
                jTextField2.setText("");

                //display a successfully data inserted message
                JOptionPane.showMessageDialog(this, "Record Submitted Successfully !");

            } catch (Exception ex) {

                //show error message
                JOptionPane.showMessageDialog(this, ex);

            }

        } else {

            //display an error message when field is empty
            JOptionPane.showMessageDialog(this, "Fields Cannot Be Empty !", "Details not added successfully", JOptionPane.ERROR_MESSAGE);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed

        //generate report for the products
        String path = "";
        JFileChooser j1 = new JFileChooser();
        j1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x1=j1.showSaveDialog(this);

        if(x1==JFileChooser.APPROVE_OPTION)
        {
            path=j1.getSelectedFile().getPath();

        }

        Document doc1=new Document(PageSize.A4.rotate());

        try {

            PdfWriter.getInstance(doc1, new FileOutputStream(path+".pdf"));

            doc1.open();

            //            doc1.add(new Paragraph("PRODUCTS REPORT"));
            doc1.add(new Paragraph("\n\n                                                                                          GENERATED PRODUCTS REPORT\n\n\n"));
            doc1.add(new Paragraph("********************************************************************************************************************************************************************\n\n\n"));

            float[] columnWidths = {10,15,10,10,10,18};
            //            PdfPTable tb2 = new PdfPTable(columnWidths);

            PdfPTable tb2 = new PdfPTable(columnWidths);

            PdfPCell cell = new PdfPCell(new Paragraph("PRODUCTS REPORT"));
            cell.setColspan(8);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setPadding(10.0f);

            tb2.addCell(cell);
            tb2.addCell("Productid");
            tb2.addCell("Productname");
            tb2.addCell("Standardunit");
            tb2.addCell("Amountperunit");
            tb2.addCell("Priceperunit");
            tb2.addCell("Date");

            for(int v = 0; v<jTable2.getRowCount(); v++){

                String Productid = jTable2.getValueAt(v,0).toString();
                String Productname = jTable2.getValueAt(v,1).toString();
                String Standardunit = jTable2.getValueAt(v,2).toString();
                String Amountperunit = jTable2.getValueAt(v,3).toString();
                String Priceperunit = jTable2.getValueAt(v,4).toString();
                String Date = jTable2.getValueAt(v,5).toString();

                tb2.addCell(Productid);
                tb2.addCell(Productname);
                tb2.addCell(Standardunit);
                tb2.addCell(Amountperunit);
                tb2.addCell(Priceperunit);
                tb2.addCell(Date);

            }

            doc1.add(tb2);

            JOptionPane.showMessageDialog(rootPane,"Report Successfully Generated !","ALERT MESSAGE",1);

            // TODO add your handling code here:
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BarManagement1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(BarManagement1.class.getName()).log(Level.SEVERE, null, ex);
        }

        doc1.close();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed

        //generate report for the total income
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x=j.showSaveDialog(this);

        if(x==JFileChooser.APPROVE_OPTION)
        {
            path=j.getSelectedFile().getPath();

        }

        Document doc=new Document(PageSize.A4.rotate());

        try {

            PdfWriter.getInstance(doc, new FileOutputStream(path+".pdf"));

            doc.open();

            doc.add(new Paragraph("\n\n                                                                                         GENERATED INCOME REPORT\n\n\n"));
            doc.add(new Paragraph("*******************************************************************************************************************************************************************\n\n\n"));

            //            com.itexttpdf.text.Image image = com.itextpdf.text.Image.getInstance("C:\\Users\\VAGEE\\Desktop\\ICONS\\loggo.JPEG");
            //
            //            document.add(image);

            float[] columnWidths = {10,18,15};

            PdfPTable tb1 = new PdfPTable(columnWidths);

            PdfPCell cell = new PdfPCell(new Paragraph("INCOME REPORT"));
            cell.setColspan(8);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setPadding(10.0f);

            tb1.addCell(cell);
            tb1.addCell("INCOME ID");
            tb1.addCell("DATE");
            tb1.addCell("TOTAL INCOME");

            for(int i = 0; i<jTable8.getRowCount(); i++){

                String ID = jTable8.getValueAt(i,0).toString();
                String Income = jTable8.getValueAt(i,1).toString();
                String Date = jTable8.getValueAt(i,2).toString();

                tb1.addCell(ID);
                tb1.addCell(Income);
                tb1.addCell(Date);

            }

            doc.add(tb1);

            JOptionPane.showMessageDialog(rootPane,"Report Successfully Generated !","ALERT MESSAGE",1);

            // TODO add your handling code here:
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BarManagement1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(BarManagement1.class.getName()).log(Level.SEVERE, null, ex);
        }

        doc.close();

    }//GEN-LAST:event_jButton22ActionPerformed

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked

        this.viewPanel("card2");

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked

        this.viewPanel("card3");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseClicked

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked

        this.viewPanel("card4");

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseClicked

    private void jPanel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseClicked

        this.viewPanel("card5");

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseClicked

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked

        this.viewPanel("card6");

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked


        int z = jTable3.getSelectedRow();

         String g = barordersList.get(z).getOrdertype();
         
         if(g.equalsIgnoreCase("POS")){
             
             jRadioButton3.setSelected(true);
             
         }else{
             
             jRadioButton4.setSelected(true);
         }
         
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked


        int t = jTable4.getSelectedRow();

         String h = barorderbillList1.get(t).getDiscountselect();
         
         if(h.equalsIgnoreCase("YES")){
             
             jRadioButton6.setSelected(true);
             
         }else{
             
             jRadioButton7.setSelected(true);
         }
         

         String n = barorderbillList1.get(t).getStatus();
         
         if(n.equalsIgnoreCase("PAID")){
             
             jRadioButton5.setSelected(true);
             
         }else{
             
             jRadioButton8.setSelected(true);
         }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          int i = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to log out?");
        if (i == JOptionPane.YES_OPTION) {
            
            dispose();
            SplashView sp = new SplashView();
            sp.setVisible(true);
            
            Login l = new Login();
            l.setSpalshView(sp); 
            l.setVisible(true);
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
     dispose();
     loginnav l1 = new loginnav();
     l1.setVisible(true);
    }//GEN-LAST:event_jButton5MouseClicked

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
            java.util.logging.Logger.getLogger(BarManagement1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarManagement1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarManagement1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarManagement1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarManagement1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager ITPNewPUEntityManager;
    private java.util.List<BarManagementFunction.Barincome> barincomeList;
    private java.util.List<BarManagementFunction.Barincome> barincomeList1;
    private javax.persistence.Query barincomeQuery;
    private javax.persistence.Query barincomeQuery1;
    private java.util.List<BarManagementFunction.Barorderbill> barorderbillList;
    private java.util.List<BarManagementFunction.Barorderbill> barorderbillList1;
    private javax.persistence.Query barorderbillQuery;
    private javax.persistence.Query barorderbillQuery1;
    private java.util.List<BarManagementFunction.Barorders> barordersList;
    private java.util.List<BarManagementFunction.Barorders> barordersList1;
    private javax.persistence.Query barordersQuery;
    private javax.persistence.Query barordersQuery1;
    private java.util.List<BarManagementFunction.Barstockcontrol> barstockcontrolList;
    private java.util.List<BarManagementFunction.Barstockcontrol> barstockcontrolList1;
    private java.util.List<BarManagementFunction.Barstockcontrol> barstockcontrolList2;
    private javax.persistence.Query barstockcontrolQuery;
    private javax.persistence.Query barstockcontrolQuery1;
    private javax.persistence.Query barstockcontrolQuery2;
    private java.util.List<BarManagementFunction.Barwastage> barwastageList;
    private javax.persistence.Query barwastageQuery;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private com.toedter.calendar.JDateChooser jDateChooser9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
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
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField70;
    private javax.swing.JTextField jTextField71;
    private javax.swing.JTextField jTextField72;
    private javax.swing.JTextField jTextField82;
    private javax.swing.JTextField jTextField83;
    private javax.swing.JTextField jTextField84;
    private javax.swing.JTextField jTextField85;
    private javax.swing.JTextField jTextField86;
    private javax.swing.JTextField jTextField87;
    private javax.swing.JTextField jTextField88;
    private javax.swing.JTextField jTextField89;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextField90;
    private javax.swing.JTextField jTextField91;
    private javax.swing.JTextField jTextField92;
    private javax.swing.JTextField jTextField93;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public boolean validateInput() {

        return !(jTextField71.getText().isEmpty() || jTextField72.getText().isEmpty() || jTextField5.getText().isEmpty());

    }

    public boolean validateroderedit() {

        return !(jTextField10.getText().isEmpty() ||jTextField3.getText().isEmpty() || jTextField88.getText().isEmpty() || jTextField89.getText().isEmpty() || jTextField90.getText().isEmpty() || jTextField93.getText().isEmpty() || jTextField92.getText().isEmpty() || jTextField91.getText().isEmpty() || jTextField48.getText().isEmpty());
    }

    public boolean validateroder() {

        return !(jTextField2.getText().isEmpty() ||jTextField82.getText().isEmpty() || jTextField83.getText().isEmpty() || jTextField84.getText().isEmpty() || jTextField85.getText().isEmpty() || jTextField86.getText().isEmpty() || jTextField87.getText().isEmpty() || jTextField42.getText().isEmpty());
    }
    
    public boolean validatebill() {

        return !(jTextField4.getText().isEmpty() || jTextField6.getText().isEmpty() || jTextField49.getText().isEmpty());

    }

    public boolean validateWastage() {

        return !(jTextField50.getText().isEmpty());

    }

    public boolean validateIncome() {

        return !(jTextField51.getText().isEmpty());

    }



}
