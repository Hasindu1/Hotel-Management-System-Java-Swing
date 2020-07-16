/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeManagementFunction;

//import com.itextpdf.text.BaseColor;
import static BarManagementFunction.BarManagement1.homeStatus;
import com.itextpdf.text.BaseColor;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import loginnav.loginnav;
import userLoginFunction.Login;
import userLoginFunction.SplashView;


/**
 *
 * @author Manthi
 */
public class EmployeeManagement extends javax.swing.JFrame {
    private Connection connection = DBHandler.getDBConnection();
    public static boolean homeStatus;
     private ImageIcon img ;
    /**
     * Creates new form EmployeeManagement
     */
    
    public EmployeeManagement() {
           img= new ImageIcon(getClass().getResource("/icons/HotelManager.png"));
        this.setIconImage(img.getImage());
        initComponents();
        showDate();
        showTime();
        loadAttendanceDetails();
        jButton14.setVisible(false);
          displayHome();
        
        
          try
        {
            String sql = "select * from JOB";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next())
            {
                    String jid  = rs.getString("JOBID");
                    String jrole  = rs.getString("JOBROLE");
                    String jbsal  = rs.getString("BASICSALARY");
                    String jrte  = rs.getString("OTRTE");
                    jComboBox1.addItem(rs.getString("JOBROLE"));
                    jComboBox1.getSelectedItem();       
            }
            
        }
        catch(SQLException ex)
        {
            ex.getStackTrace();
        }
        
    }
     public void displayHome(){
        if(homeStatus){
            jButton14.setVisible(true);
        }
    }
    
     private void loadAttendanceDetails(){
         try{
            
            DefaultTableModel m1 = (DefaultTableModel)jTable1.getModel();
            
            String q = "SELECT a.ATTENDECEID, a.DATE, e.EMPLOYEEID,e.EMPLOYEENAME,e.CURRENTJOBROLE, a.WORKEDHOURS,a.OVERTIMEHOURS FROM ATTENDENCE a, EMPLOYEE e WHERE e.EMPLOYEEID=a.EMPLOYEEID";
            PreparedStatement pst = connection.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
                m1.insertRow(0, new Object[]{
                rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getString(4), rs.getString(5),rs.getInt(6),rs.getInt(7)});
            }   
            jTable1.setModel(m1);   
            
            String sq = "select * from EMPLOYEE";
            PreparedStatement stat = connection.prepareStatement(sq);
            
            ResultSet rs1 = stat.executeQuery();
            
            while(rs1.next())
            {
                    String ename  = rs1.getString("EMPLOYEENAME");
                    String jrole  = rs1.getString("CURRENTJOBROLE");
                    jComboBox2.addItem(rs1.getString("EMPLOYEEID"));
                    jComboBox2.getSelectedItem();         
            }
            
            
            }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        } 
        
    }
    
    void  ViewPanel(String cname){
        CardLayout cl = (CardLayout)jPanel4.getLayout();
        cl.show(jPanel4,cname);
    }
    
    public void showDate(){
        Date d= new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        d1.setText(s.format(d));
//        d2.setText(s.format(d));
//        d3.setText(s.format(d));
//        d4.setText(s.format(d));
//        d5.setText(s.format(d));
    }  
    
    public void showTime(){
    
        new Timer(0,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh : mm : ss a");
                
            t1.setText(s.format(d));
//            t2.setText(s.format(d));
//            t3.setText(s.format(d));
//            t4.setText(s.format(d));
//            t5.setText(s.format(d));
            }
        }).start();
    
    }
    private String getMonth(JDateChooser jDateChooser){
        String monthName = null;
          int month =jDateChooser.getDate().getMonth();
                        if(month == 0){
                          monthName = "January";
                        }
                        if(month == 1){
                            monthName= "February";
                        }
                        if(month == 2){
                             monthName="March";
                        }
                        if(month == 3){
                        monthName = "April";
                        }
                        if(month == 4){
                            monthName= "May";
                        }
                        if(month == 5){
                            monthName="June";
                        }
                        if(month == 6){
                            monthName ="July";
                        }
                        if(month == 7){
                          monthName=  "August";
                        }
                        if(month == 8){
                         monthName = "September";
                        }
                        if(month == 9){
                           monthName = "Octomber";
                        }
                        if(month == 10){
                            monthName = "November";
                        }
                        if(month == 11){
                            monthName = "December";
                        }
                        return monthName;
        
    }

    
    void refreshTable(List employeeList2){
        
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, employeeList2, jTable3);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${employeeid}"));
        columnBinding.setColumnName("Employeeid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${employeename}"));
        columnBinding.setColumnName("Employeename");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nicpassport}"));
        columnBinding.setColumnName("Nicpassport");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dob}"));
        columnBinding.setColumnName("Dob");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${maritalstate}"));
        columnBinding.setColumnName("Maritalstate");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${address}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gender}"));
        columnBinding.setColumnName("Gender");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contactnumber}"));
        columnBinding.setColumnName("Contactnumber");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${currentjobrole}"));
        columnBinding.setColumnName("Currentjobrole");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }
    
    void refreshTable2(List jobList2){
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jobList2, jTable4);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${jobid}"));
        columnBinding.setColumnName("Jobid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${jobrole}"));
        columnBinding.setColumnName("Jobrole");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${basicsalary}"));
        columnBinding.setColumnName("Basicsalary");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${otrte}"));
        columnBinding.setColumnName("Otrte");
        columnBinding.setColumnClass(Double.class);
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

        HotelManagementSystemPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("HotelManagementSystemPU").createEntityManager();
        employeeQuery = java.beans.Beans.isDesignTime() ? null : HotelManagementSystemPUEntityManager.createQuery("SELECT e FROM Employee e");
        employeeList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : employeeQuery.getResultList();
        jobQuery = java.beans.Beans.isDesignTime() ? null : HotelManagementSystemPUEntityManager.createQuery("SELECT j FROM Job j");
        jobList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : jobQuery.getResultList();
        jobQuery1 = java.beans.Beans.isDesignTime() ? null : HotelManagementSystemPUEntityManager.createQuery("SELECT j FROM Job j");
        jobList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : jobQuery1.getResultList();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jobQuery2 = java.beans.Beans.isDesignTime() ? null : HotelManagementSystemPUEntityManager.createQuery("SELECT j FROM Job j");
        jobList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : jobQuery2.getResultList();
        employeeQuery1 = java.beans.Beans.isDesignTime() ? null : HotelManagementSystemPUEntityManager.createQuery("SELECT e FROM Employee e");
        employeeList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : employeeQuery1.getResultList();
        jPanel3 = new javax.swing.JPanel();
        d1 = new javax.swing.JLabel();
        t1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        EmpDetailsjPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        btnENewEmp = new javax.swing.JButton();
        btnEUpdate = new javax.swing.JButton();
        btnEDelete = new javax.swing.JButton();
        btnEClear = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel14 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        SalaryManjPanel8 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txtSaaryManBasicSal = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        txtSalaryEmpId = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtSalaryMnEmpname = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        txtSalaryManOt = new javax.swing.JTextField();
        txtSalarManOverHour = new javax.swing.JTextField();
        txtSalarManOverAmount = new javax.swing.JTextField();
        txtSalaryManTotal = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtSalaryManOt1 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        JobManajPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtJobRole = new javax.swing.JTextField();
        txtBasicSal = new javax.swing.JTextField();
        txtHourlyRate = new javax.swing.JTextField();
        btnJInsert = new javax.swing.JButton();
        btnJUpdate = new javax.swing.JButton();
        btnJDelete = new javax.swing.JButton();
        btnJClear = new javax.swing.JButton();
        txtJobRole1 = new javax.swing.JTextField();
        show_validation_here1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        AttandencejPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField15 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        ViewReportsjPanel12 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        btnpdf = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(54, 33, 89));
        jPanel3.setPreferredSize(new java.awt.Dimension(2205, 154));

        d1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        d1.setForeground(new java.awt.Color(255, 255, 255));
        d1.setText("gg");
        d1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        t1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        t1.setForeground(new java.awt.Color(255, 255, 255));
        t1.setText("tt");
        t1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton3.setText("jButton3");

        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 80)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("H o t e l  K a b a l a n a");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Matara Rd, Ahangama 80650");

        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo (1).png"))); // NOI18N
        jLabel73.setText("jLabel73");

        jButton14.setBackground(new java.awt.Color(54, 33, 89));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Home");
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton14MouseClicked(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(54, 33, 89));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Log Out");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton15MouseClicked(evt);
            }
        });
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(421, 421, 421)
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(252, 252, 252)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(419, 419, 419)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2231, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel72)
                        .addGap(48, 48, 48)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 1009));

        jPanel17.setBackground(new java.awt.Color(85, 68, 118));
        jPanel17.setToolTipText("");
        jPanel17.setPreferredSize(new java.awt.Dimension(300, 67));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText(" Salary Management");

        jPanel9.setPreferredSize(new java.awt.Dimension(67, 57));

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clipart-6-17-23-27-40 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(285, 285, 285))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel1)
                .addGap(49, 49, 49))
        );

        jPanel18.setBackground(new java.awt.Color(85, 68, 118));
        jPanel18.setToolTipText("");
        jPanel18.setPreferredSize(new java.awt.Dimension(288, 67));
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel18MouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("    Employee Details");

        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/images--3-.png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(85, 68, 118));
        jPanel19.setToolTipText("");
        jPanel19.setPreferredSize(new java.awt.Dimension(300, 67));
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel19MouseClicked(evt);
            }
        });
        jPanel19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel19KeyReleased(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("   Daily Attendance");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        jPanel13.setPreferredSize(new java.awt.Dimension(67, 57));

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tftft (1).jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel20.setBackground(new java.awt.Color(85, 68, 118));
        jPanel20.setToolTipText("");
        jPanel20.setPreferredSize(new java.awt.Dimension(300, 67));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("   Job Management   ");

        jPanel12.setPreferredSize(new java.awt.Dimension(67, 57));

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/images (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        jPanel21.setBackground(new java.awt.Color(85, 68, 118));
        jPanel21.setToolTipText("");
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel21MouseClicked(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("   View Reports");
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ReportsFinal.png"))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Management");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(59, 59, 59)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(388, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel4.setLayout(new java.awt.CardLayout());

        EmpDetailsjPanel6.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                EmpDetailsjPanel6ComponentShown(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Employee ID");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setText("Employee name");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("NIC or Passport No");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel12.setText("Date of Birth");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel13.setText("Marital State");

        jTextField1.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.employeeid}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.employeename}"), jTextField2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nicpassport}"), jTextField3, org.jdesktop.beansbinding.BeanProperty.create("text"));
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

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.contactnumber}"), jTextField4, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Single");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRadioButton1MousePressed(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Married");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel14.setText("Address");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setText("Contact Number");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel16.setText("Gender");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.address}"), jTextField5, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Male");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Female");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel18.setText("Job Role");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.currentjobrole}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, eLProperty, jComboBox1);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btnENewEmp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnENewEmp.setText("Add New Employee");
        btnENewEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnENewEmpActionPerformed(evt);
            }
        });

        btnEUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEUpdate.setText("Update");
        btnEUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEUpdateActionPerformed(evt);
            }
        });

        btnEDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEDelete.setText("Delete");
        btnEDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEDeleteActionPerformed(evt);
            }
        });

        btnEClear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEClear.setText("Clear");
        btnEClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEClearActionPerformed(evt);
            }
        });

        jLabel65.setForeground(new java.awt.Color(255, 51, 51));

        jLabel66.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnENewEmp)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel18)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16)
                        .addComponent(jLabel14)
                        .addComponent(jLabel13)
                        .addComponent(jLabel12)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel8)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton4))
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addComponent(jRadioButton2))
                            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnEUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnEClear)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnENewEmp)
                    .addComponent(btnEUpdate)
                    .addComponent(btnEDelete)
                    .addComponent(btnEClear))
                .addGap(68, 68, 68))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("     Search by Employee ID");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, employeeList, jTable3);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${employeeid}"));
        columnBinding.setColumnName("Employeeid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${employeename}"));
        columnBinding.setColumnName("Employeename");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nicpassport}"));
        columnBinding.setColumnName("Nicpassport");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dob}"));
        columnBinding.setColumnName("Dob");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${maritalstate}"));
        columnBinding.setColumnName("Maritalstate");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${address}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gender}"));
        columnBinding.setColumnName("Gender");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contactnumber}"));
        columnBinding.setColumnName("Contactnumber");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${currentjobrole}"));
        columnBinding.setColumnName("Currentjobrole");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable3MousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton1))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel7.setText("Employee Details");

        javax.swing.GroupLayout EmpDetailsjPanel6Layout = new javax.swing.GroupLayout(EmpDetailsjPanel6);
        EmpDetailsjPanel6.setLayout(EmpDetailsjPanel6Layout);
        EmpDetailsjPanel6Layout.setHorizontalGroup(
            EmpDetailsjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmpDetailsjPanel6Layout.createSequentialGroup()
                .addGroup(EmpDetailsjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EmpDetailsjPanel6Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EmpDetailsjPanel6Layout.createSequentialGroup()
                        .addGap(478, 478, 478)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2403, Short.MAX_VALUE))
        );
        EmpDetailsjPanel6Layout.setVerticalGroup(
            EmpDetailsjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmpDetailsjPanel6Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(EmpDetailsjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jPanel4.add(EmpDetailsjPanel6, "card3");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel35.setText("  Salary Management");

        txtSaaryManBasicSal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel36.setText("Employee ID");

        txtSalaryEmpId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaryEmpIdActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel37.setText("Employee Name");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel38.setText("Total Salary");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel40.setText("OT Rate");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel41.setText("Basic Salary");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel43.setText("Job ID");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel44.setText("Over Time");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel45.setText("Amount");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel46.setText("Hours");

        txtSalaryMnEmpname.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSalaryMnEmpnameInputMethodTextChanged(evt);
            }
        });
        txtSalaryMnEmpname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaryMnEmpnameActionPerformed(evt);
            }
        });

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        txtSalaryManOt.setEditable(false);

        txtSalarManOverHour.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSalarManOverHourKeyReleased(evt);
            }
        });

        txtSalarManOverAmount.setEditable(false);

        txtSalaryManTotal.setEditable(false);
        txtSalaryManTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaryManTotalActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel39.setText("Salary ID");

        txtSalaryManOt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaryManOt1ActionPerformed(evt);
            }
        });
        txtSalaryManOt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSalaryManOt1KeyReleased(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setText("Insert");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton10.setText("Update");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton11.setText("Delete");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel63.setText("Date");

        jTextField17.setEditable(false);
        jTextField17.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField17InputMethodTextChanged(evt);
            }
        });
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

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel64.setText("Job Role");

        jTextField18.setEditable(false);

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton12.setText("Clear");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtSaaryManBasicSalLayout = new javax.swing.GroupLayout(txtSaaryManBasicSal);
        txtSaaryManBasicSal.setLayout(txtSaaryManBasicSalLayout);
        txtSaaryManBasicSalLayout.setHorizontalGroup(
            txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtSaaryManBasicSalLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtSaaryManBasicSalLayout.createSequentialGroup()
                        .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel64)
                            .addComponent(jLabel43)
                            .addComponent(jLabel37)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(txtSaaryManBasicSalLayout.createSequentialGroup()
                        .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtSaaryManBasicSalLayout.createSequentialGroup()
                                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(txtSaaryManBasicSalLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jButton9)))
                                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(txtSaaryManBasicSalLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton10)
                                        .addGap(83, 83, 83)
                                        .addComponent(jButton11)
                                        .addGap(76, 76, 76)
                                        .addComponent(jButton12))
                                    .addGroup(txtSaaryManBasicSalLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(txtSalarManOverHour, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel45)
                                            .addComponent(txtSalarManOverAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSalaryManTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(txtSaaryManBasicSalLayout.createSequentialGroup()
                                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36))
                                .addGap(76, 76, 76)
                                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSalaryManOt1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                    .addComponent(txtSalaryEmpId, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                    .addComponent(txtSalaryManOt)
                                    .addComponent(jTextField6)
                                    .addComponent(jTextField17)
                                    .addComponent(txtSalaryMnEmpname)
                                    .addComponent(jTextField18)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(97, 97, Short.MAX_VALUE))))
        );
        txtSaaryManBasicSalLayout.setVerticalGroup(
            txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtSaaryManBasicSalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalaryEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addGap(18, 18, 18)
                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel63)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalaryManOt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtSalaryManOt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalaryMnEmpname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel45))
                .addGap(18, 18, 18)
                .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtSaaryManBasicSalLayout.createSequentialGroup()
                        .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalarManOverHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalarManOverAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))
                        .addGap(28, 28, 28)
                        .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSalaryManTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtSaaryManBasicSalLayout.createSequentialGroup()
                        .addGroup(txtSaaryManBasicSalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(jButton10)
                            .addComponent(jButton11)
                            .addComponent(jButton12))
                        .addGap(98, 98, 98))))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jTable5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SalaryID", "Date", "Emp ID", "EMP Name", "Job ID", "Job Role", "Basic Salary", "OT total", "OT Hrs", "OT Total", "Sal Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SalaryManjPanel8Layout = new javax.swing.GroupLayout(SalaryManjPanel8);
        SalaryManjPanel8.setLayout(SalaryManjPanel8Layout);
        SalaryManjPanel8Layout.setHorizontalGroup(
            SalaryManjPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalaryManjPanel8Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(txtSaaryManBasicSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 345, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2002, 2002, 2002))
            .addGroup(SalaryManjPanel8Layout.createSequentialGroup()
                .addGap(501, 501, 501)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SalaryManjPanel8Layout.setVerticalGroup(
            SalaryManjPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalaryManjPanel8Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(SalaryManjPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaaryManBasicSal, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(224, Short.MAX_VALUE))
        );

        jPanel4.add(SalaryManjPanel8, "card5");

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel20.setText("Job Role");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel21.setText("Job ID");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel23.setText("Basic Salary");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel34.setText("OT Rate");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.jobrole}"), txtJobRole, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtJobRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJobRoleActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.basicsalary}"), txtBasicSal, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtBasicSal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBasicSalActionPerformed(evt);
            }
        });
        txtBasicSal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBasicSalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBasicSalKeyTyped(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.otrte}"), txtHourlyRate, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtHourlyRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHourlyRateActionPerformed(evt);
            }
        });
        txtHourlyRate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHourlyRateKeyTyped(evt);
            }
        });

        btnJInsert.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnJInsert.setText("Insert");
        btnJInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJInsertActionPerformed(evt);
            }
        });

        btnJUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnJUpdate.setText("Update");
        btnJUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJUpdateActionPerformed(evt);
            }
        });

        btnJDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnJDelete.setText("Delete");
        btnJDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJDeleteActionPerformed(evt);
            }
        });

        btnJClear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnJClear.setText("Clear");
        btnJClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJClearActionPerformed(evt);
            }
        });

        txtJobRole1.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.jobid}"), txtJobRole1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtJobRole1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJobRole1ActionPerformed(evt);
            }
        });

        show_validation_here1.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(show_validation_here1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel21)
                                .addComponent(jLabel20)
                                .addComponent(jLabel23)
                                .addComponent(jLabel34))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(btnJInsert)
                                .addGap(21, 21, 21)))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBasicSal, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJobRole, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJobRole1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(btnJUpdate)
                                .addGap(72, 72, 72)
                                .addComponent(btnJDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnJClear)))))
                .addGap(0, 36, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtJobRole1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtJobRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtBasicSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtHourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(show_validation_here1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJInsert)
                    .addComponent(btnJUpdate)
                    .addComponent(btnJDelete)
                    .addComponent(btnJClear))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel17.setText("Job Management");

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("     Search By Job ID");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("SEARCH");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jobList, jTable4);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${jobid}"));
        columnBinding.setColumnName("Jobid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${jobrole}"));
        columnBinding.setColumnName("Jobrole");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${basicsalary}"));
        columnBinding.setColumnName("Basicsalary");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${otrte}"));
        columnBinding.setColumnName("Otrte");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JobManajPanel5Layout = new javax.swing.GroupLayout(JobManajPanel5);
        JobManajPanel5.setLayout(JobManajPanel5Layout);
        JobManajPanel5Layout.setHorizontalGroup(
            JobManajPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JobManajPanel5Layout.createSequentialGroup()
                .addGap(389, 389, 389)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JobManajPanel5Layout.createSequentialGroup()
                .addGap(0, 322, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2226, 2226, 2226))
        );
        JobManajPanel5Layout.setVerticalGroup(
            JobManajPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JobManajPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JobManajPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(451, Short.MAX_VALUE))
        );

        jPanel4.add(JobManajPanel5, "card2");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel19.setText(" Daily Attendance");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel42.setText("Attendance ID");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel48.setText("Employee ID");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel49.setText("Employee Name");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel50.setText("Job Role");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel52.setText("Worked Hours");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel53.setText("  Date");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel54.setText("OverTime Hours");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField10KeyPressed(evt);
            }
        });

        jTextField11.setEditable(false);
        jTextField11.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField11InputMethodTextChanged(evt);
            }
        });
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

        jTextField12.setEditable(false);
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Insert");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setText("Clear");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextField15.setEditable(false);
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox2KeyReleased(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel57.setText("Employee IDs");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(76, 76, 76)
                        .addComponent(jButton5)
                        .addGap(106, 106, 106)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addGap(198, 198, 198))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField11)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(31, 31, 31)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(214, 214, 214))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel50)
                                    .addGap(135, 135, 135)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addGap(82, 82, 82)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ATTENDECEID", "DATE", "EMPLOYEEID", "EMPLOYEENAME", "CURRENTJOBROLE", "WORKEDHOURS", "OTHOURS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Search by Attendence ID");

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton8.setText("SEARCH");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton8)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8)
                    .addComponent(jLabel2))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AttandencejPanel7Layout = new javax.swing.GroupLayout(AttandencejPanel7);
        AttandencejPanel7.setLayout(AttandencejPanel7Layout);
        AttandencejPanel7Layout.setHorizontalGroup(
            AttandencejPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttandencejPanel7Layout.createSequentialGroup()
                .addGroup(AttandencejPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AttandencejPanel7Layout.createSequentialGroup()
                        .addGap(586, 586, 586)
                        .addComponent(jLabel19)
                        .addGap(695, 695, 695))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AttandencejPanel7Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2168, Short.MAX_VALUE))
        );
        AttandencejPanel7Layout.setVerticalGroup(
            AttandencejPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttandencejPanel7Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AttandencejPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(372, Short.MAX_VALUE))
        );

        jPanel4.add(AttandencejPanel7, "card6");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel24.setText("View Report Details ");

        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnpdf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnpdf.setText("Convert to PDF");
        btnpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpdfActionPerformed(evt);
            }
        });

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, employeeList1, jTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${employeeid}"));
        columnBinding.setColumnName("Employeeid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${employeename}"));
        columnBinding.setColumnName("Employeename");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nicpassport}"));
        columnBinding.setColumnName("Nicpassport");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dob}"));
        columnBinding.setColumnName("Dob");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${maritalstate}"));
        columnBinding.setColumnName("Maritalstate");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${address}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gender}"));
        columnBinding.setColumnName("Gender");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contactnumber}"));
        columnBinding.setColumnName("Contactnumber");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${currentjobrole}"));
        columnBinding.setColumnName("Currentjobrole");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel67.setText("     Employee Details ");
        jLabel67.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel68.setText("  Total Number Of Employees");
        jLabel68.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnpdf, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(btnpdf, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jobList2, jTable6);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${jobid}"));
        columnBinding.setColumnName("Jobid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${jobrole}"));
        columnBinding.setColumnName("Jobrole");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${basicsalary}"));
        columnBinding.setColumnName("Basicsalary");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${otrte}"));
        columnBinding.setColumnName("Otrte");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane6.setViewportView(jTable6);

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel69.setText("     Job Details");
        jLabel69.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel70.setText("Total Number Of Job Roles");
        jLabel70.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton13.setText("Convert to PDF");
        jButton13.setBorder(null);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ViewReportsjPanel12Layout = new javax.swing.GroupLayout(ViewReportsjPanel12);
        ViewReportsjPanel12.setLayout(ViewReportsjPanel12Layout);
        ViewReportsjPanel12Layout.setHorizontalGroup(
            ViewReportsjPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewReportsjPanel12Layout.createSequentialGroup()
                .addGroup(ViewReportsjPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewReportsjPanel12Layout.createSequentialGroup()
                        .addGap(601, 601, 601)
                        .addComponent(jLabel24))
                    .addGroup(ViewReportsjPanel12Layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addGroup(ViewReportsjPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 966, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(2491, Short.MAX_VALUE))
        );
        ViewReportsjPanel12Layout.setVerticalGroup(
            ViewReportsjPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewReportsjPanel12Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(ViewReportsjPanel12, "card7");

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        //SALARY MANUAL BINDING TABLE
        try{

            DefaultTableModel m1 = (DefaultTableModel)jTable5.getModel();
            m1.setRowCount(0);

            String q = "SELECT s.SALARYID,s.DATE,e.EMPLOYEEID,e.EMPLOYEENAME,j.JOBID,j.JOBROLE,j.BASICSALARY,j.OTRTE, s.OTHOURS,s.TOTALAMOUNT,s.TOTALSAL FROM SALARY s, EMPLOYEE e , JOB j WHERE e.EMPLOYEEID=s.EMPID and j.JOBID=s.JOBID";
            PreparedStatement pst = connection.prepareStatement(q);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){

                m1.insertRow(0, new Object[]{
                    rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getString(4), rs.getInt(5),rs.getString(6),rs.getDouble(7),rs.getDouble(8),rs.getInt(9),rs.getDouble(10),rs.getDouble(11)});
        }
        jTable5.setModel(m1);

        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }

        this.ViewPanel("card5");
    }//GEN-LAST:event_jPanel17MouseClicked

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked
        this.ViewPanel("card3");
        try
        {
            String sql = "select * from JOB";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                String jid  = rs.getString("JOBID");
                String jrole  = rs.getString("JOBROLE");
                String jbsal  = rs.getString("BASICSALARY");
                String jrte  = rs.getString("OTRTE");
                jComboBox1.addItem(rs.getString("JOBROLE"));
                jComboBox1.getSelectedItem();
            }

        }
        catch(SQLException ex)
        {
            ex.getStackTrace();
        }
    }//GEN-LAST:event_jPanel18MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        this.ViewPanel("card6");
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked
        clearfields();
        this.ViewPanel("card6");
    }//GEN-LAST:event_jPanel19MouseClicked

    private void jPanel19KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel19KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19KeyReleased

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        this.ViewPanel("card2");
    }//GEN-LAST:event_jPanel20MouseClicked

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MouseClicked

    private void jPanel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseClicked
        this.ViewPanel("card7");
        String count = String.valueOf(jTable2.getRowCount());
        jTextField16.setText(count);

        String count1 = String.valueOf(jTable6.getRowCount());
        jTextField19.setText(count1);
    }//GEN-LAST:event_jPanel21MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // Employee details NIC/Passport validation

        String passport="^[A-Z][0-9][0-9] [0-9][0-9][0-9][0-9][0-9]$";
        Pattern pattern1 = Pattern.compile(passport);
        Matcher match1 = pattern1.matcher(jTextField3.getText());

        String oldNIC = "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][v]$";
        Pattern pattern2 = Pattern.compile(oldNIC);
        Matcher match2 = pattern2.matcher(jTextField3.getText());

        String newNIC = "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$";
        Pattern pattern3 = Pattern.compile(newNIC);
        Matcher match3 = pattern3.matcher(jTextField3.getText());

        if(!(match1.matches() || match2.matches() || match3.matches())){
            jLabel65.setText("Invalid");
        }else{
            jLabel65.setText("");
        }

    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed

    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed

    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // contact number validation
        String contactnumber = "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$";
        Pattern pattern1 = Pattern.compile(contactnumber);
        Matcher match1 = pattern1.matcher(jTextField4.getText());

        if(!(match1.matches())){
            jLabel66.setText("Invalid");
        }else{
            jLabel66.setText("");
        }

    }//GEN-LAST:event_jTextField4KeyReleased

    private void jRadioButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1MousePressed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jDateChooser1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1MousePressed

    private void btnENewEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnENewEmpActionPerformed
        //EMPLOYEE DETAILS INSERT
        //Employee Details insert validation

        String EmployeeName = jTextField2.getText().toString();
        String Address = jTextField5.getText().toString();
        String DateOfBirth = jDateChooser1.getDate().toString();
        String ContactNumber = jTextField4.getText().toString();
        String NicorPassportNumber = jTextField3.getText().toString();

        if(EmployeeName.equals("")){
            JOptionPane.showMessageDialog(null,"Name is mandotory");
        }else if(ContactNumber.equals("")){
            JOptionPane.showMessageDialog(null,"Contact number is mandotory");
        }else if(Address.equals("")){
            JOptionPane.showMessageDialog(null,"Address is mandotory");
        }
        else if(DateOfBirth.equals("")){
            JOptionPane.showMessageDialog(null,"Date of birth is mandotory");
        }else if(NicorPassportNumber.equals("")){
            JOptionPane.showMessageDialog(null,"Nic or PassportNumber is mandotory");
        }

        else{

            try{
                String sql = "INSERT INTO EMPLOYEE(EMPLOYEENAME,NICPASSPORT,DOB,MARITALSTATE,ADDRESS,CONTACTNUMBER,GENDER,CURRENTJOBROLE)VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                //statement.setString(1,jTextField1.getText());
                statement.setString(1,jTextField2.getText());
                statement.setString(2,jTextField3.getText());
                java.sql.Date d1 = null;
                java.sql.Date sqldate = new java.sql.Date(jDateChooser1.getDate().getTime());
                //java.util.Date date1= jDateChooser1.getDate();
                // d1 = new java.sql.Date(date1.getDate());
                statement.setDate(3, sqldate);
                //marital state
                if(jRadioButton1.isSelected()){
                    statement.setString(4,"Single");
                }
                if(jRadioButton2.isSelected()){
                    statement.setString(4,"Married");
                }
                statement.setString(5,jTextField5.getText());
                statement.setString(6,jTextField4.getText());
                //gender
                if(jRadioButton3.isSelected()){
                    statement.setString(7,"Male");
                }
                if(jRadioButton4.isSelected()){
                    statement.setString(7,"Female");
                }
                System.out.println("MOnth: " + jDateChooser1.getDate().getMonth());
                statement.setString(8,jComboBox1.getSelectedItem().toString());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null,"New Employee Successfully Inserted!");
                //refreshTable(employeeList2);

                String sql1 = "SELECT * FROM EMPLOYEE";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                ResultSet rs = statement1.executeQuery();
                employeeList.clear();
                String sq = "select * from EMPLOYEE";
                PreparedStatement stat = connection.prepareStatement(sq);
                //statement.setString(1, (String)jComboBox1.getSelectedItem());

                ResultSet rs1 = stat.executeQuery();

                while(rs1.next())
                {
                    String ename  = rs1.getString("EMPLOYEENAME");
                    String jrole  = rs1.getString("CURRENTJOBROLE");
                    jComboBox2.addItem(rs1.getString("EMPLOYEEID"));
                    jComboBox2.getSelectedItem();

                }

                while(rs.next()){
                    Employee employee = new Employee();
                    Job job = new Job();
                    employee.setEmployeeid(rs.getInt(1));
                    employee.setEmployeename(rs.getString(2));
                    employee.setNicpassport(rs.getString(3));
                    employee.setDob(rs.getDate(4));
                    employee.setMaritalstate(rs.getString(5));
                    employee.setAddress(rs.getString(6));
                    employee.setContactnumber(rs.getString(7));
                    employee.setGender(rs.getString(8));
                    employee.setCurrentjobrole(rs.getString(9));
                    job.setJobid(rs.getInt(10));
                    employee.setJobid(job);

                    employeeList.add(employee);
                }

                refreshTable(employeeList);

            }

            catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("Wada Naha");
            }
        }
    }//GEN-LAST:event_btnENewEmpActionPerformed

    private void btnEUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEUpdateActionPerformed
        // TODO add your handling code here:
        //update employee details.
        String EmployeeName = jTextField2.getText().toString();
        String Address = jTextField5.getText().toString();
        String DateOfBirth = jDateChooser1.getDate().toString();
        String ContactNumber = jTextField4.getText().toString();
        String NicorPassportNumber = jTextField3.getText().toString();

        if(EmployeeName.equals("")){
            JOptionPane.showMessageDialog(null,"Name is mandotory");
        }else if(ContactNumber.equals("")){
            JOptionPane.showMessageDialog(null,"Contact number is mandotory");
        }else if(Address.equals("")){
            JOptionPane.showMessageDialog(null,"Address is mandotory");
        }else if(NicorPassportNumber.equals("")){
            JOptionPane.showMessageDialog(null,"Nic or PassportNumber is mandotory");
        }
        else{
            try{
                String sql = "UPDATE EMPLOYEE SET EMPLOYEENAME=?, NICPASSPORT=?, DOB=?,MARITALSTATE=?, ADDRESS=?, CONTACTNUMBER=?, GENDER=?, CURRENTJOBROLE=? WHERE EMPLOYEEID=? ";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,jTextField2.getText());
                statement.setString(2,jTextField3.getText());

                java.sql.Date sqldate = new java.sql.Date(jDateChooser1.getDate().getTime());
                statement.setDate(3,sqldate);

                if(jRadioButton1.isSelected()){
                    statement.setString(4,"Single");
                }
                if(jRadioButton2.isSelected()){
                    statement.setString(4,"Married");
                }
                statement.setString(5,jTextField5.getText());
                statement.setString(6,jTextField4.getText());
                //gender
                if(jRadioButton3.isSelected()){
                    statement.setString(7,"Male");
                }
                if(jRadioButton4.isSelected()){
                    statement.setString(7,"Female");
                }
                statement.setString(8,jComboBox1.getSelectedItem().toString());
                statement.setInt(9,Integer.parseInt(jTextField1.getText()));
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, " Data Updated successfully.");

                String sql1 = "SELECT * FROM EMPLOYEE";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                ResultSet rs = statement1.executeQuery();
                employeeList.clear();

                while(rs.next()){
                    Employee employee = new Employee();
                    Job job = new Job();
                    employee.setEmployeeid(rs.getInt(1));
                    employee.setEmployeename(rs.getString(2));
                    employee.setNicpassport(rs.getString(3));
                    employee.setDob(rs.getDate(4));
                    employee.setMaritalstate(rs.getString(5));
                    employee.setAddress(rs.getString(6));
                    employee.setContactnumber(rs.getString(7));
                    employee.setGender(rs.getString(8));
                    employee.setCurrentjobrole(rs.getString(9));
                    job.setJobid(rs.getInt(10));
                    employee.setJobid(job);

                    employeeList.add(employee);
                }

                refreshTable(employeeList);

            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEUpdateActionPerformed

    private void btnEDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEDeleteActionPerformed
        // TODO add your handling code here:
        //employee details delete
        if( jTextField1.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null,"No Employee Selected!");
        }
        else{
            int dialogboxresult= JOptionPane.showConfirmDialog(this,"Are you sure to delete", "Confirm", JOptionPane.YES_NO_OPTION);
            if(dialogboxresult == JOptionPane.YES_OPTION){

                try{
                    String sql = "DELETE FROM ATTENDENCE WHERE EMPLOYEEID=? ";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1,Integer.parseInt(jTextField1.getText()));
                    statement.executeUpdate();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

                try{
                    String sql = "DELETE FROM SALARY WHERE EMPID=? ";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1,Integer.parseInt(jTextField1.getText()));
                    statement.executeUpdate();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

                try{
                    String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEEID=?";
                    PreparedStatement statement= connection.prepareStatement(sql);
                    statement.setInt(1,Integer.parseInt(jTextField1.getText()));
                    statement.executeUpdate();
                    clearfields();

                    String sql1 = "SELECT * FROM EMPLOYEE";
                    PreparedStatement statement1 = connection.prepareStatement(sql1);
                    ResultSet rs = statement1.executeQuery();
                    employeeList.clear();

                    while(rs.next()){
                        Employee employee = new Employee();
                        Job job = new Job();
                        employee.setEmployeeid(rs.getInt(1));
                        employee.setEmployeename(rs.getString(2));
                        employee.setNicpassport(rs.getString(3));
                        employee.setDob(rs.getDate(4));
                        employee.setMaritalstate(rs.getString(5));
                        employee.setAddress(rs.getString(6));
                        employee.setContactnumber(rs.getString(7));
                        employee.setGender(rs.getString(8));
                        employee.setCurrentjobrole(rs.getString(9));
                        job.setJobid(rs.getInt(10));
                        employee.setJobid(job);

                        employeeList.add(employee);
                    }

                    refreshTable(employeeList);

                }
                catch(Exception e){

                    System.out.println(e.getMessage());
                }
            }
        }

        JOptionPane.showMessageDialog(null,"Details deleted from Attendance and Salary Tables also! ");
    }//GEN-LAST:event_btnEDeleteActionPerformed

    private void btnEClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEClearActionPerformed
        // TODO add your handling code here:
        clearfields();
        jTable3.clearSelection();
    }//GEN-LAST:event_btnEClearActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //employee search

        jTextField7.getText();
        try{
            String q = "select * from EMPLOYEE where EMPLOYEEID = "+Integer.parseInt(jTextField7.getText())+"";

            PreparedStatement pst = connection.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            employeeList.clear();
            while(rs.next()){
                Employee employee = new Employee();
                Job job = new Job();
                employee.setEmployeeid(rs.getInt(1));
                employee.setEmployeename(rs.getString(2));
                employee.setNicpassport(rs.getString(3));
                employee.setDob(rs.getDate(4));
                employee.setMaritalstate(rs.getString(5));
                employee.setAddress(rs.getString(6));
                employee.setContactnumber(rs.getString(7));
                employee.setGender(rs.getString(8));
                employee.setCurrentjobrole(rs.getString(9));
                job.setJobid(rs.getInt(10));
                employee.setJobid(job);

                employeeList.add(employee);
            }

            refreshTable(employeeList);

        }

        catch(Exception e){
            System.out.println(e.getMessage());

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MousePressed
        // TODO add your handling code here:

        int i = jTable3.getSelectedRow();
        Date a = employeeList.get(i).getDob();
        jDateChooser1.setDate(a);

        String g = employeeList.get(i).getMaritalstate();
        if(g.equalsIgnoreCase("Single")){
            jRadioButton1.setSelected(true);
        }else{
            jRadioButton2.setSelected(true);
        }

        String b = employeeList.get(i).getGender();
        if(b.equalsIgnoreCase("Male")){
            jRadioButton3.setSelected(true);
        }else{
            jRadioButton4.setSelected(true);
        }

    }//GEN-LAST:event_jTable3MousePressed

    private void EmpDetailsjPanel6ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_EmpDetailsjPanel6ComponentShown
        // TODO add your handling code here:

    }//GEN-LAST:event_EmpDetailsjPanel6ComponentShown

    private void txtSalaryEmpIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaryEmpIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaryEmpIdActionPerformed

    private void txtSalaryMnEmpnameInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSalaryMnEmpnameInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSalaryMnEmpnameInputMethodTextChanged

    private void txtSalaryMnEmpnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaryMnEmpnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaryMnEmpnameActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyReleased

    private void txtSalarManOverHourKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalarManOverHourKeyReleased
        //calculation part
        double basSal = Double.valueOf(txtSalaryMnEmpname.getText());
        double otrt = Double.valueOf(jTextField18.getText());
        int ohrs = Integer.valueOf(txtSalarManOverHour.getText());
        double amount= (double)ohrs*otrt;
        txtSalarManOverAmount.setText(String.valueOf(amount));

        double total = basSal+amount;
        txtSalaryManTotal.setText(String.valueOf(total));

    }//GEN-LAST:event_txtSalarManOverHourKeyReleased

    private void txtSalaryManTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaryManTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaryManTotalActionPerformed

    private void txtSalaryManOt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaryManOt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaryManOt1ActionPerformed

    private void txtSalaryManOt1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalaryManOt1KeyReleased
        // TODO add your handling code here:
        if(!(txtSalaryManOt1.getText().isEmpty())){

            try
            {
                String sq2 = "SELECT EMPLOYEENAME,CURRENTJOBROLE from EMPLOYEE WHERE EMPLOYEEID=?";
                PreparedStatement st = connection.prepareStatement(sq2);

                st.setInt(1,Integer.parseInt(txtSalaryManOt1.getText()));

                ResultSet rs3 = st.executeQuery();

                while(rs3.next())
                {
                    String ename  = rs3.getString("EMPLOYEENAME");
                    txtSalaryManOt.setText(ename);
                    String jrole = rs3.getString("CURRENTJOBROLE");
                    jTextField17.setText(jrole);
                    System.out.println(ename);
                }
                String sql="SELECT SUM(WORKEDHOURS) FROM ATTENDENCE WHERE EMPLOYEEID=? AND MONTH=?";
                PreparedStatement st1 = connection.prepareStatement(sql);

                st1.setInt(1,Integer.parseInt(txtSalaryManOt1.getText()));
                st1.setString(2,getMonth(jDateChooser3));

                ResultSet rs4 = st1.executeQuery();

                while(rs4.next())
                {
                    Integer tot = rs4.getInt(1);

                    txtSalarManOverHour.setText(tot.toString());
                }

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_txtSalaryManOt1KeyReleased

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // Salary insert

        jDateChooser3.getDate().getYear();
        System.out.println("YEAR:   " +(jDateChooser3.getDate().getYear() + 1900));
        try{

            PreparedStatement statement;
            statement=connection.prepareStatement(" INSERT INTO SALARY(TOTALAMOUNT,TOTALSAL,YEARNO,MONTHNAME,EMPID,JOBID,DATE,OTHOURS)VALUES(?,?,?,?,?,?,?,?)");

            statement.setString(1,txtSalarManOverAmount.getText());

            statement.setString(2,txtSalaryManTotal.getText());
            statement.setInt(3,(jDateChooser3.getDate().getYear() + 1900));

            //                        int month =jDateChooser3.getDate().getMonth();
            //                        if(month == 0){
                //                            statement.setString(4, "January");
                //                        }
            //                        if(month == 1){
                //                            statement.setString(4, "February");
                //                        }
            //                        if(month == 2){
                //                            statement.setString(4, "March");
                //                        }
            //                        if(month == 3){
                //                            statement.setString(4, "April");
                //                        }
            //                        if(month == 4){
                //                            statement.setString(4, "May");
                //                        }
            //                        if(month == 5){
                //                            statement.setString(4, "June");
                //                        }
            //                        if(month == 6){
                //                            statement.setString(4, "July");
                //                        }
            //                        if(month == 7){
                //                            statement.setString(4, "August");
                //                        }
            //                        if(month == 8){
                //                            statement.setString(4, "September");
                //                        }
            //                        if(month == 9){
                //                            statement.setString(4, "Octomber");
                //                        }
            //                        if(month == 10){
                //                            statement.setString(4, "November");
                //                        }
            //                        if(month == 11){
                //                            statement.setString(4, "December");
                //                        }
            statement.setString(4,getMonth(jDateChooser3));
            statement.setInt(5,Integer.parseInt(txtSalaryManOt1.getText()));
            statement.setInt(6,Integer.parseInt(jTextField6.getText()));
            System.out.println(" ttt");
            java.sql.Date d1  = new java.sql.Date(jDateChooser3.getDate().getTime());
            statement.setDate(7, d1);
            System.out.println(" qqq");
            statement.setInt(8,Integer.parseInt(txtSalarManOverHour.getText()));
            System.out.println(" dddd");
            statement.executeUpdate();
            System.out.println(" mmm");

            JOptionPane.showMessageDialog(null,"Salary  details Successfully Inserted!");

            try{

                DefaultTableModel m1 = (DefaultTableModel)jTable5.getModel();
                m1.setRowCount(0);
                System.out.println(" yygyy");
                String q = "SELECT s.SALARYID,s.DATE,e.EMPLOYEEID,e.EMPLOYEENAME,j.JOBID,j.JOBROLE,j.BASICSALARY,j.OTRTE, s.OTHOURS,s.TOTALAMOUNT,s.TOTALSAL FROM SALARY s, EMPLOYEE e , JOB j WHERE e.EMPLOYEEID=s.EMPID and j.JOBID=s.JOBID";
                PreparedStatement pst = connection.prepareStatement(q);
                System.out.println(" bbb");
                ResultSet rs = pst.executeQuery();

                while(rs.next()){
                    System.out.println(" vvv");
                    m1.insertRow(0, new Object[]{
                        rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getString(4), rs.getInt(5),rs.getString(6),rs.getDouble(7),rs.getDouble(8),rs.getInt(9),rs.getDouble(10),rs.getDouble(11)});
            }
            jTable5.setModel(m1);

        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }

        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // Salary Update

        jDateChooser3.getDate().getYear();
        System.out.println("YEAR:   " +(jDateChooser3.getDate().getYear() + 1900));
        try{

            String sql=" UPDATE SALARY SET TOTALAMOUNT=?,TOTALSAL=?,YEARNO=?,MONTHNAME=?,EMPID=?,JOBID=?,DATE=?,OTHOURS=? WHERE SALARYID=?" ;
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,txtSalarManOverAmount.getText());
            statement.setString(2,txtSalaryManTotal.getText());
            statement.setInt(3,(jDateChooser3.getDate().getYear() + 1900));

            int month =jDateChooser3.getDate().getMonth();
            if(month == 0){
                statement.setString(4, "January");
            }
            if(month == 1){
                statement.setString(4, "February");
            }
            if(month == 2){
                statement.setString(4, "March");
            }
            if(month == 3){
                statement.setString(4, "April");
            }
            if(month == 4){
                statement.setString(4, "May");
            }
            if(month == 5){
                statement.setString(4, "June");
            }
            if(month == 6){
                statement.setString(4, "July");
            }
            if(month == 7){
                statement.setString(4, "August");
            }
            if(month == 8){
                statement.setString(4, "September");
            }
            if(month == 9){
                statement.setString(4, "Octomber");
            }
            if(month == 10){
                statement.setString(4, "November");
            }
            if(month == 11){
                statement.setString(4, "December");
            }
            statement.setInt(5,Integer.parseInt(txtSalaryManOt1.getText()));
            statement.setInt(6,Integer.parseInt(jTextField6.getText()));

            java.sql.Date d1  = new java.sql.Date(jDateChooser3.getDate().getTime());
            statement.setDate(7, d1);
            statement.setInt(8,Integer.parseInt(txtSalarManOverHour.getText()));
            statement.setInt(9,Integer.parseInt(txtSalaryEmpId.getText()));

            statement.executeUpdate();

            //refreshTableAttendance(employeeList);
            JOptionPane.showMessageDialog(null,"Salary  details Successfully Updated!");

            try{

                DefaultTableModel m1 = (DefaultTableModel)jTable5.getModel();
                m1.setRowCount(0);

                String q = "SELECT s.SALARYID,s.DATE,e.EMPLOYEEID,e.EMPLOYEENAME,j.JOBID,j.JOBROLE,j.BASICSALARY,j.OTRTE,s.OTHOURS, s.TOTALAMOUNT,s.TOTALSAL FROM SALARY s, EMPLOYEE e , JOB j WHERE e.EMPLOYEEID=s.EMPID and j.JOBID=s.JOBID";
                PreparedStatement pst = connection.prepareStatement(q);
                ResultSet rs = pst.executeQuery();

                while(rs.next()){

                    m1.insertRow(0, new Object[]{
                        rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getString(4), rs.getInt(5),rs.getString(6),rs.getDouble(7),rs.getDouble(8),rs.getInt(9),rs.getDouble(10),rs.getDouble(11)});
            }
            jTable5.setModel(m1);

        }

        catch(Exception e){
            e.printStackTrace();
        }

        }catch(Exception e){
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // SALARY DELETE

        if( txtSalaryEmpId.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null,"No Salary ID Selected!");
        }
        else{
            int dialogboxresult= JOptionPane.showConfirmDialog(this,"Are you sure to delete", "Confirm", JOptionPane.YES_NO_OPTION);
            if(dialogboxresult == JOptionPane.YES_OPTION){
                try{
                    String sql = "DELETE FROM SALARY WHERE SALARYID=?";
                    PreparedStatement statement= connection.prepareStatement(sql);
                    statement.setInt(1,Integer.parseInt(txtSalaryEmpId.getText()));
                    statement.executeUpdate();
                    clearfields();

                    try{

                        DefaultTableModel m1 = (DefaultTableModel)jTable5.getModel();
                        m1.setRowCount(0);

                        String q = "SELECT s.SALARYID,s.DATE,e.EMPLOYEEID,e.EMPLOYEENAME,j.JOBID,j.JOBROLE,j.BASICSALARY,j.OTRTE, s.TOTALAMOUNT,s.TOTALSAL FROM SALARY s, EMPLOYEE e , JOB j WHERE e.EMPLOYEEID=s.EMPID and j.JOBID=s.JOBID";
                        PreparedStatement pst = connection.prepareStatement(q);
                        ResultSet rs = pst.executeQuery();

                        while(rs.next()){

                            m1.insertRow(0, new Object[]{
                                rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getString(4), rs.getInt(5),rs.getString(6),rs.getDouble(7),rs.getDouble(7),rs.getInt(8),rs.getDouble(9),rs.getDouble(10)});
                    }
                    jTable5.setModel(m1);

                }

                catch(Exception e){
                    System.out.println(e.getMessage());
                }

            }
            catch(Exception e){

                System.out.println(e.getMessage());
            }
        }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField17InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField17InputMethodTextChanged

    }//GEN-LAST:event_jTextField17InputMethodTextChanged

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed

    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyReleased

        try
        {
            String sq2 = "SELECT JOBID,BASICSALARY,OTRTE from JOB WHERE JOBROLE=?";
            PreparedStatement st = connection.prepareStatement(sq2);
            st.setString(1,jTextField17.getText());
            ResultSet rs3 = st.executeQuery();

            while(rs3.next())
            {
                String jid  = rs3.getString("JOBID");
                jTextField6.setText(jid);
                Double bSal = rs3.getDouble("BASICSALARY");
                txtSalaryMnEmpname.setText(bSal.toString());
                Double otrte = rs3.getDouble("OTRTE");
                jTextField18.setText(otrte.toString());

                System.out.println(jid);
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }//GEN-LAST:event_jTextField17KeyReleased

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        clearfields();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable5.getModel();
        int s = jTable5.getSelectedRow();

        txtSalaryEmpId.setText(model.getValueAt(s, 0).toString());
        jDateChooser3.setDate((Date) model.getValueAt(s,1));
        txtSalaryManOt1.setText(model.getValueAt(s, 2).toString());
        txtSalaryManOt.setText(model.getValueAt(s, 3).toString());
        jTextField6.setText(model.getValueAt(s, 4).toString());
        jTextField17.setText(model.getValueAt(s, 5).toString());
        txtSalaryMnEmpname.setText(model.getValueAt(s, 6).toString());
        jTextField18.setText(model.getValueAt(s, 7).toString());
        txtSalarManOverHour.setText(model.getValueAt(s, 8).toString());
        txtSalarManOverAmount.setText(model.getValueAt(s, 9).toString());
        txtSalaryManTotal.setText(model.getValueAt(s, 10).toString());

    }//GEN-LAST:event_jTable5MouseClicked

    private void txtJobRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJobRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJobRoleActionPerformed

    private void txtBasicSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBasicSalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBasicSalActionPerformed

    private void txtBasicSalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBasicSalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBasicSalKeyPressed

    private void txtBasicSalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBasicSalKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c)&&!evt.isAltDown()){
            evt.consume();
        }
    }//GEN-LAST:event_txtBasicSalKeyTyped

    private void txtHourlyRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHourlyRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHourlyRateActionPerformed

    private void txtHourlyRateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHourlyRateKeyTyped
        // TODO add your handling code here:
        char d = evt.getKeyChar();
        if(Character.isLetter(d)&&!evt.isAltDown()){
            evt.consume();
        }

    }//GEN-LAST:event_txtHourlyRateKeyTyped

    private void btnJInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJInsertActionPerformed
        // TODO add your handling code here:
        //Job insert

        String jobrole = txtJobRole.getText().toString();
        String basicsal = txtBasicSal.getText().toString();
        String otrate = txtHourlyRate.getText().toString();

        if( txtJobRole.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null,"Insert details correctly!");
        }else if(jobrole.equals("")){
            JOptionPane.showMessageDialog(null,"job role is mandotory");
        }else if(basicsal.equals("")){
            JOptionPane.showMessageDialog(null,"Basic salary is mandotory");
        }else if(otrate.equals("")){
            JOptionPane.showMessageDialog(null,"OT Rate is mandotory");
        }
        else{
            try{

                String sql=" INSERT INTO JOB(JOBROLE,BASICSALARY,OTRTE)VALUES(?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1,txtJobRole.getText());
                statement.setString(2,txtBasicSal.getText());
                statement.setString(3,txtHourlyRate.getText());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, " Data inserted successfully.");

                String sql1 = "SELECT * FROM JOB";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                ResultSet rs = statement1.executeQuery();
                jobList.clear();

                while(rs.next()){
                    Job job = new Job();
                    job.setJobid(rs.getInt(1));
                    job.setJobrole(rs.getString(2));
                    job.setBasicsalary(rs.getDouble(3));
                    job.setOtrte(rs.getDouble(4));
                    jobList.add(job);
                }
                refreshTable2(jobList);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

    }//GEN-LAST:event_btnJInsertActionPerformed

    private void btnJUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJUpdateActionPerformed
        // TODO add your handling code here:
        //Update jobRole

        String jobrole = txtJobRole.getText().toString();
        String basicsal = txtBasicSal.getText().toString();
        String otrate = txtHourlyRate.getText().toString();
        if( txtJobRole1.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null,"Fill the feilds correctly!");
        }
        else if(jobrole.equals("")){
            JOptionPane.showMessageDialog(null,"job role is mandotory");
        }else if(basicsal.equals("")){
            JOptionPane.showMessageDialog(null,"Basic salary is mandotory");
        }else if(otrate.equals("")){
            JOptionPane.showMessageDialog(null,"OT Rate is mandotory");
        }else{
            try{
                String sql = "UPDATE JOB SET JOBROLE=?, BASICSALARY=?, OTRTE=? WHERE JOBID=? ";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,txtJobRole.getText());
                statement.setString(2,txtBasicSal.getText());
                statement.setString(3,txtHourlyRate.getText());
                statement.setInt(4,Integer.parseInt(txtJobRole1.getText()));
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, " Data updated successfully.");

                String sql1 = "SELECT * FROM JOB";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                ResultSet rs = statement1.executeQuery();
                jobList.clear();

                while(rs.next()){
                    Job job = new Job();
                    job.setJobid(rs.getInt(1));
                    job.setJobrole(rs.getString(2));
                    job.setBasicsalary(rs.getDouble(3));
                    job.setOtrte(rs.getDouble(4));
                    jobList.add(job);
                }
                refreshTable2(jobList);

            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }

        }
    }//GEN-LAST:event_btnJUpdateActionPerformed

    private void btnJDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJDeleteActionPerformed
        // TODO add your handling code here:
        //JobMangement Delete

        if( txtJobRole1.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null,"No Job Selected!");
        }
        else{
            int dialogboxresult2= JOptionPane.showConfirmDialog(this,"Are you sure to delete", "Confirm", JOptionPane.YES_NO_OPTION);
            if(dialogboxresult2 == JOptionPane.YES_OPTION){

                try{
                    String sql = "DELETE FROM SALARY WHERE JOBID=? ";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1,Integer.parseInt(txtJobRole1.getText()));
                    statement.executeUpdate();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

                try{
                    String sql = "DELETE FROM EMPLOYEE WHERE JOBID=? ";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1,Integer.parseInt(txtJobRole1.getText()));
                    statement.executeUpdate();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

                try{

                    String sql = "DELETE FROM JOB WHERE JOBID=?";
                    PreparedStatement statement= connection.prepareStatement(sql);
                    statement.setInt(1,Integer.parseInt(txtJobRole1.getText()));
                    statement.executeUpdate();

                    clearfields();

                    String sql1 = "SELECT * FROM JOB";
                    PreparedStatement statement1 = connection.prepareStatement(sql1);
                    ResultSet rs = statement1.executeQuery();
                    jobList.clear();

                    while(rs.next()){
                        Job job = new Job();
                        job.setJobid(rs.getInt(1));
                        job.setJobrole(rs.getString(2));
                        job.setBasicsalary(rs.getDouble(3));
                        job.setOtrte(rs.getDouble(4));
                        jobList.add(job);
                    }
                    refreshTable2(jobList);

                }
                catch(Exception e){

                    System.out.println(e.getMessage());
                }
            }
        }
        JOptionPane.showMessageDialog(null,"Details deleted from Employee ans Salary Tables also! ");
    }//GEN-LAST:event_btnJDeleteActionPerformed

    private void btnJClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJClearActionPerformed
        // TODO add your handling code here:
        //JobManagement Clear
        clearfields();
        jTable4.clearSelection();
    }//GEN-LAST:event_btnJClearActionPerformed

    private void txtJobRole1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJobRole1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJobRole1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Job Management Search

        jTextField8.getText();
        try{
            String q = "select * from JOB where JOBID = "+Integer.parseInt(jTextField8.getText())+"";

            PreparedStatement pst = connection.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            jobList.clear();
            while(rs.next()){
                Job job = new Job();
                job.setJobid(rs.getInt(1));
                job.setJobrole(rs.getString(2));
                job.setBasicsalary(rs.getDouble(3));
                job.setOtrte(rs.getDouble(4));
                jobList.add(job);
            }
            refreshTable2(jobList);
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTextField11InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField11InputMethodTextChanged

    }//GEN-LAST:event_jTextField11InputMethodTextChanged

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //attendence insert

        String workedhours = jTextField14.getText().toString();
        String othrs = jTextField9.getText().toString();

        if( jTextField14.getText().toString().equals("") || jTextField9.getText().toString().equals("") ){
            JOptionPane.showMessageDialog(null,"Fill all the details");
        }
        else if(workedhours.equals("")){
            JOptionPane.showMessageDialog(null,"Worked Hours is mandotory");
        }else if(othrs.equals("")){
            JOptionPane.showMessageDialog(null,"OT Hours is mandotory");
        }
        else{
            try{

                String sql=" INSERT INTO ATTENDENCE(DATE,MONTH,WORKEDHOURS,OVERTIMEHOURS,EMPLOYEEID)VALUES(?, ?, ?, ?,?)";

                PreparedStatement statement = connection.prepareStatement(sql);

                java.sql.Date d1  = new java.sql.Date(jDateChooser2.getDate().getTime());
                statement.setDate(1, d1);
                int month =jDateChooser2.getDate().getMonth();
                if(month == 0){
                    statement.setString(2, "January");
                }
                if(month == 1){
                    statement.setString(2, "February");
                }
                if(month == 2){
                    statement.setString(2, "March");
                }
                if(month == 3){
                    statement.setString(2, "April");
                }
                if(month == 4){
                    statement.setString(2, "May");
                }
                if(month == 5){
                    statement.setString(2, "June");
                }
                if(month == 6){
                    statement.setString(2, "July");
                }
                if(month == 7){
                    statement.setString(2, "August");
                }
                if(month == 8){
                    statement.setString(2, "September");
                }
                if(month == 9){
                    statement.setString(2, "Octomber");
                }
                if(month == 10){
                    statement.setString(2, "November");
                }
                if(month == 11){
                    statement.setString(2, "December");
                }
                statement.setInt(3,Integer.parseInt(jTextField14.getText()));

                statement.setInt(4,Integer.parseInt(jTextField9.getText()));

                statement.setInt(5,Integer.parseInt(jTextField11.getText()));

                statement.executeUpdate();

                //refreshTableAttendance(employeeList);
                JOptionPane.showMessageDialog(null,"Attendence details Successfully Inserted!");

                DefaultTableModel m1 = (DefaultTableModel)jTable1.getModel();
                m1.setRowCount(0);
                String q = "SELECT a.ATTENDECEID, a.DATE, e.EMPLOYEEID,e.EMPLOYEENAME,e.CURRENTJOBROLE, a.WORKEDHOURS,a.OVERTIMEHOURS FROM ATTENDENCE a, EMPLOYEE e WHERE e.EMPLOYEEID=a.EMPLOYEEID";
                PreparedStatement pst = connection.prepareStatement(q);
                ResultSet rs = pst.executeQuery();

                while(rs.next()){

                    m1.insertRow(0, new Object[]{
                        rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getString(4), rs.getString(5),rs.getInt(6),rs.getInt(7)});
            }
            jTable1.setModel(m1);

        }
        catch(Exception e){
          e.printStackTrace();
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //Attendance update

        String workedhours = jTextField14.getText().toString();
        String othrs = jTextField9.getText().toString();

        if( jTextField10.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null,"No Attendance ID Selected!");
        }
        else if(workedhours.equals("")){
            JOptionPane.showMessageDialog(null,"Worked Hours is mandotory");
        }else if(othrs.equals("")){
            JOptionPane.showMessageDialog(null,"OT Hours is mandotory");
        }else{
            try{

                String sql="UPDATE ATTENDENCE SET DATE=?,MONTH=?,WORKEDHOURS=?,OVERTIMEHOURS=?,EMPLOYEEID=? WHERE ATTENDECEID=?";
                PreparedStatement statement = connection.prepareStatement(sql);

                java.sql.Date d1  = new java.sql.Date(jDateChooser2.getDate().getTime());
                statement.setDate(1, d1);
                int month =jDateChooser2.getDate().getMonth();
                if(month == 0){
                    statement.setString(2, "January");
                }
                if(month == 1){
                    statement.setString(2, "February");
                }
                if(month == 2){
                    statement.setString(2, "March");
                }
                if(month == 3){
                    statement.setString(2, "April");
                }
                if(month == 4){
                    statement.setString(2, "May");
                }
                if(month == 5){
                    statement.setString(2, "June");
                }
                if(month == 6){
                    statement.setString(2, "July");
                }
                if(month == 7){
                    statement.setString(2, "August");
                }
                if(month == 8){
                    statement.setString(2, "September");
                }
                if(month == 9){
                    statement.setString(2, "Octomber");
                }
                if(month == 10){
                    statement.setString(2, "November");
                }
                if(month == 11){
                    statement.setString(2, "December");
                }

                statement.setInt(3,Integer.parseInt(jTextField14.getText()));
                statement.setInt(4,Integer.parseInt(jTextField9.getText()));
                statement.setInt(5,Integer.parseInt(jTextField11.getText()));
                statement.setInt(6,Integer.parseInt(jTextField10.getText()));

                statement.executeUpdate();
                //refreshTableAttendance(employeeList);

                JOptionPane.showMessageDialog(null, " Data updated successfully.");

                DefaultTableModel m1 = (DefaultTableModel)jTable1.getModel();

                String q = "SELECT a.ATTENDECEID, a.DATE, e.EMPLOYEEID,e.EMPLOYEENAME,e.CURRENTJOBROLE, a.WORKEDHOURS,a.OVERTIMEHOURS FROM ATTENDENCE a, EMPLOYEE e WHERE e.EMPLOYEEID=a.EMPLOYEEID";
                PreparedStatement pst = connection.prepareStatement(q);
                ResultSet rs = pst.executeQuery();
                m1.setRowCount(0);

                while(rs.next()){

                    m1.insertRow(0, new Object[]{
                        rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getString(4), rs.getString(5),rs.getInt(6),rs.getInt(7)});
            }
            jTable1.setModel(m1);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //attendance details delete

        if( jTextField10.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null,"No Attendance ID Selected!");
        }
        else{
            int dialogboxresult= JOptionPane.showConfirmDialog(this,"Are you sure to delete", "Confirm", JOptionPane.YES_NO_OPTION);
            if(dialogboxresult == JOptionPane.YES_OPTION){
                try{
                    String sql = "DELETE FROM ATTENDENCE WHERE ATTENDECEID=?";
                    PreparedStatement statement= connection.prepareStatement(sql);
                    statement.setInt(1,Integer.parseInt(jTextField10.getText()));
                    statement.executeUpdate();
                    clearfields();

                    DefaultTableModel m1 = (DefaultTableModel)jTable1.getModel();

                    String q = "SELECT a.ATTENDECEID, a.DATE, e.EMPLOYEEID,e.EMPLOYEENAME,e.CURRENTJOBROLE, a.WORKEDHOURS,a.OVERTIMEHOURS FROM ATTENDENCE a, EMPLOYEE e WHERE e.EMPLOYEEID=a.EMPLOYEEID";
                    PreparedStatement pst = connection.prepareStatement(q);
                    ResultSet rs = pst.executeQuery();

                    while(rs.next()){

                        m1.insertRow(0, new Object[]{
                            rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getString(4), rs.getString(5),rs.getInt(6),rs.getInt(7)});
                }
                jTable1.setModel(m1);

            }
            catch(Exception e){

                System.out.println(e.getMessage());
            }
        }
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        clearfields();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        jTextField11.setText(jComboBox2.getSelectedItem().toString());
        try
        {
            String sq2 = "SELECT EMPLOYEENAME,CURRENTJOBROLE from EMPLOYEE WHERE EMPLOYEEID=?";
            PreparedStatement st = connection.prepareStatement(sq2);

            st.setInt(1,Integer.parseInt(jTextField11.getText()));

            ResultSet rs3 = st.executeQuery();

            while(rs3.next())
            {
                String ename  = rs3.getString("EMPLOYEENAME");
                String jrole  = rs3.getString("CURRENTJOBROLE");
                jTextField12.setText(ename);
                jTextField15.setText(jrole);

                System.out.println(ename);
            }

        }
        catch(SQLException ex)
        {
            ex.getStackTrace();
        }
        catch(NumberFormatException e){

        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jComboBox2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox2KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int s = jTable1.getSelectedRow();

        jTextField10.setText(model.getValueAt(s, 0).toString());
        jDateChooser3.setDate((Date) model.getValueAt(s,1));
        jTextField11.setText(model.getValueAt(s, 2).toString());
        jTextField12.setText(model.getValueAt(s, 3).toString());
        jTextField15.setText(model.getValueAt(s, 4).toString());
        jTextField14.setText(model.getValueAt(s, 5).toString());
        jTextField9.setText(model.getValueAt(s, 6).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MousePressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //Attendance search

        jTextField13.getText();
        try{
            int attendenceid  = Integer.parseInt(jTextField13.getText());
            DefaultTableModel m1 = (DefaultTableModel)jTable1.getModel();
            m1.setRowCount(0);

            String q = "SELECT a.ATTENDECEID, a.DATE, e.EMPLOYEEID,e.EMPLOYEENAME,e.CURRENTJOBROLE, a.WORKEDHOURS,a.OVERTIMEHOURS FROM ATTENDENCE a, EMPLOYEE e WHERE e.EMPLOYEEID=a.EMPLOYEEID and a.ATTENDECEID=?";

            PreparedStatement pst = connection.prepareStatement(q);
            // pst.setInt(1, Integer.parseInt(jTextField13.getText()));
            pst.setInt(1,attendenceid);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){

                m1.insertRow(0, new Object[]{
                    rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getString(4), rs.getString(5),rs.getInt(6),rs.getInt(7)});
        }
        jTable1.setModel(m1);

        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpdfActionPerformed
        //Employee PDE GENERATE

        String path = "";
        JFileChooser j = new JFileChooser();
        int x = j.showSaveDialog(this);
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if(x==JFileChooser.APPROVE_OPTION)
        {
            path = j.getSelectedFile().getPath();

        }

        Document doc  = new Document(PageSize.A4.rotate());
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + ".pdf"));

            doc.open();

            doc.add(new Paragraph("\n                                                                   Generated Employee Details Report\n\n\n"));
            doc.add(new Paragraph("**********************************************************************************************************************************************************"));

            //Paragraph p=new Paragraph("======================="+jLabel67.getText().toString()+"===============================");

            Paragraph p1=new Paragraph("Total No of Employees :   "+jTextField16.getText().toString()+"\n\n\n");
            doc.add(new Paragraph("\n"));

            PdfPTable tb = new PdfPTable(9);

            PdfPCell cell = new PdfPCell(new Paragraph("Employee Details Report"));
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.BLUE);
            cell.setPadding(10.0f);

            tb.addCell(cell);
            tb.addCell("Employee Id");
            tb.addCell("Employee Name");
            tb.addCell("NIC/Passport Number");
            tb.addCell("Date of Birth");
            tb.addCell("Marital State");
            tb.addCell("Address");
            tb.addCell("Gender");
            tb.addCell("Contact number");
            tb.addCell("Job Role");

            for (int i = 0; i < jTable2.getRowCount(); i++) {

                String id = jTable2.getValueAt(i,0).toString();
                String name = jTable2.getValueAt(i,1).toString();
                String nicPassport = jTable2.getValueAt(i,2).toString();
                String dob = jTable2.getValueAt(i,3).toString();
                String maritalState = jTable2.getValueAt(i,4).toString();
                String address = jTable2.getValueAt(i,5).toString();
                String gender = jTable2.getValueAt(i,6).toString();
                String contactnumber = jTable2.getValueAt(i,7).toString();
                String jobrole = jTable2.getValueAt(i,8).toString();

                tb.addCell(id);
                tb.addCell(name);
                tb.addCell(nicPassport);
                tb.addCell(dob);
                tb.addCell(maritalState);
                tb.addCell(address);
                tb.addCell(gender);
                tb.addCell(contactnumber);
                tb.addCell(jobrole);

            }

            // doc.add(p);
            doc.add(p1);
            doc.add(tb);
            JOptionPane.showMessageDialog(rootPane, "Report Generated Successfully", "ALERT MESSAGE", 1);
            //  JOptionPane.showMessageDialog(null,"Report Generated Successfully", "ALERT MESSAGE", JOptionPane.);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        doc.close();

    }//GEN-LAST:event_btnpdfActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        //GENERATE JOB MANAGEMENT REPORT PDF

        String path = "";
        JFileChooser j = new JFileChooser();
        int x = j.showSaveDialog(this);
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if(x==JFileChooser.APPROVE_OPTION)
        {
            path = j.getSelectedFile().getPath();

        }

        Document doc  = new Document(PageSize.A4.rotate());
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + ".pdf"));

            doc.open();

            doc.add(new Paragraph("\n                                                                   Generated Job Management Report\n\n\n"));
            doc.add(new Paragraph("**********************************************************************************************************************************************************"));

            //Paragraph p=new Paragraph("======================="+jLabel67.getText().toString()+"===============================");

            Paragraph p1=new Paragraph("Total No of Job Roles :   "+jTextField19.getText().toString()+"\n\n\n");
            doc.add(new Paragraph("\n"));

            PdfPTable tb = new PdfPTable(4);

            PdfPCell cell = new PdfPCell(new Paragraph("Job Management Details Report"));
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.BLUE);
            cell.setPadding(10.0f);

            tb.addCell(cell);
            tb.addCell("Job Id");
            tb.addCell("Job Role Name");
            tb.addCell("Basic Salary");
            tb.addCell("OT Rate");

            for (int i = 0; i < jTable6.getRowCount(); i++) {

                String jid = jTable6.getValueAt(i,0).toString();
                String jobname = jTable6.getValueAt(i,1).toString();
                String basicsalary = jTable6.getValueAt(i,2).toString();
                String otrate = jTable6.getValueAt(i,3).toString();

                tb.addCell(jid);
                tb.addCell(jobname);
                tb.addCell(basicsalary);
                tb.addCell(otrate);

            }

            // doc.add(p);
            doc.add(p1);
            doc.add(tb);
            JOptionPane.showMessageDialog(rootPane, "Report Generated Successfully", "ALERT MESSAGE", 1);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        doc.close();

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
     
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
    int i = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to log out?");
        if (i == JOptionPane.YES_OPTION) {
            
            dispose();
            SplashView sp = new SplashView();
            sp.setVisible(true);
            
            Login l = new Login();
            l.setSpalshView(sp); 
            l.setVisible(true);
            
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseClicked
      dispose();
      loginnav l1 = new loginnav();
      l1.setVisible(true);
    }//GEN-LAST:event_jButton14MouseClicked

    private void jButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15MouseClicked

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
            java.util.logging.Logger.getLogger(EmployeeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeManagement().setVisible(true);
            }
        });
    }

    
    //Clear Fields
    public void clearfields()
    {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jDateChooser1.setDate(null);
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        jTextField5.setText("");
        jTextField4.setText("");
        txtJobRole.setText("");
        txtBasicSal.setText("");
        txtHourlyRate.setText("");
        txtJobRole1.setText("");
        jTextField10.setText("");
        jDateChooser3.setDate(null);
        jTextField12.setText("");
        jTextField14.setText("");
        jTextField11.setText("");
        jTextField9.setText("");
        jTextField15.setText("");
        txtSalaryManOt1.setText("");
        jLabel66.setText("");
        jLabel65.setText("");
        
        txtSalaryEmpId.setText("");
        jDateChooser3.setDate(null);
        txtSalaryManOt1.setText("");
        txtSalaryManOt.setText("");
        jTextField6.setText("");
        jTextField17.setText("");
        txtSalaryMnEmpname.setText("");
        jTextField18.setText("");
        txtSalarManOverHour.setText("");
        txtSalarManOverAmount.setText("");
        txtSalaryManTotal.setText("");
        
        
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AttandencejPanel7;
    private javax.swing.JPanel EmpDetailsjPanel6;
    private javax.persistence.EntityManager HotelManagementSystemPUEntityManager;
    private javax.swing.JPanel JobManajPanel5;
    private javax.swing.JPanel SalaryManjPanel8;
    private javax.swing.JPanel ViewReportsjPanel12;
    private javax.swing.JButton btnEClear;
    private javax.swing.JButton btnEDelete;
    private javax.swing.JButton btnENewEmp;
    private javax.swing.JButton btnEUpdate;
    private javax.swing.JButton btnJClear;
    private javax.swing.JButton btnJDelete;
    private javax.swing.JButton btnJInsert;
    private javax.swing.JButton btnJUpdate;
    private javax.swing.JButton btnpdf;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel d1;
    private java.util.List<employeeManagementFunction.Employee> employeeList;
    private java.util.List<employeeManagementFunction.Employee> employeeList1;
    private javax.persistence.Query employeeQuery;
    private javax.persistence.Query employeeQuery1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
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
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
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
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private java.util.List<employeeManagementFunction.Job> jobList;
    private java.util.List<employeeManagementFunction.Job> jobList1;
    private java.util.List<employeeManagementFunction.Job> jobList2;
    private javax.persistence.Query jobQuery;
    private javax.persistence.Query jobQuery1;
    private javax.persistence.Query jobQuery2;
    private javax.swing.JLabel show_validation_here1;
    private javax.swing.JLabel t1;
    private javax.swing.JTextField txtBasicSal;
    private javax.swing.JTextField txtHourlyRate;
    private javax.swing.JTextField txtJobRole;
    private javax.swing.JTextField txtJobRole1;
    private javax.swing.JPanel txtSaaryManBasicSal;
    private javax.swing.JTextField txtSalarManOverAmount;
    private javax.swing.JTextField txtSalarManOverHour;
    private javax.swing.JTextField txtSalaryEmpId;
    private javax.swing.JTextField txtSalaryManOt;
    private javax.swing.JTextField txtSalaryManOt1;
    private javax.swing.JTextField txtSalaryManTotal;
    private javax.swing.JTextField txtSalaryMnEmpname;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
