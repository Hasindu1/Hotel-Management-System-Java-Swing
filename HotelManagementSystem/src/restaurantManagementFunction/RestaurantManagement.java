/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantManagementFunction;
//import com.itextpdf.layout.element.Paragraph;
import UIChanges.NavigationColour;
import com.itextpdf.awt.DefaultFontMapper;
import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.placeholder.PlaceHolder;
import com.toedter.calendar.JDateChooser;
import databaseConnectivity.DBHandler;
import diu.swe.habib.JavaToast.JToast;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import loginnav.loginnav;
import org.apache.derby.client.am.SqlException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import static supplierManagement.SupplierManagementFunction.homeStatus;
import userLoginFunction.Login;
import userLoginFunction.HotelManagementSystem;
import userLoginFunction.SplashView;

/**
 *
 * @author Hasindu
 */
public class RestaurantManagement extends javax.swing.JFrame {
     private ImageIcon img ;
      PlaceHolder holder;
      private ArrayList<String> comboList;
    private int row;
    private int riceCount;
    private int soupCount;
    private int noodlesCount;
    private int meatDishesCount;
    private int seaFoodCount;
    private int beveragesCount;
    private int vegetableDishesCount;
    private int puddingsCount;
    private int menusCount;
    private int otherCount;
    private boolean validation1, validation2, validation3, validation5, validation6, validation7, validation8, validation20, validation21;
    private boolean validation22,validation23,validation24,validation25,validation26,validation27,validation30;
    private NavigationColour nColour;
    public static boolean homeStatus;
   
    /**
     * Creates new form RestaurantManagement
     */
    Connection connection = DBHandler.getDBConnection();

    {
        validation1 = true;
        validation2 = true;
        validation3 = true;
        validation5 = false;
        validation6 = false;
        validation7 = false;
        validation8 = true;
        validation20 = true;
        validation21 = true;
        validation24=true;
        validation25=true;
        validation26=true;
        validation27 = true;
        validation30 = true;
       
    }
   

    public RestaurantManagement() {
        
        initComponents();
           img= new ImageIcon(getClass().getResource("/icons/HotelManager.png"));
        this.setIconImage(img.getImage());
        showTime();
        showDate();
        jButton22.setVisible(false);
         displayHome();
        jComboBox1.addItem(comboList.get(0));
        jComboBox1.addItem(comboList.get(1));
        jComboBox1.addItem(comboList.get(2));
        jComboBox1.addItem(comboList.get(3));
        jComboBox1.addItem(comboList.get(4));
        jComboBox1.addItem(comboList.get(5));
        jComboBox1.addItem(comboList.get(6));
        jComboBox1.addItem(comboList.get(7));
        jComboBox1.addItem(comboList.get(8));
        jComboBox1.addItem(comboList.get(9));
        jLabel92.setText("                                                  ");
        jLabel97.setText("                                                  ");
        jLabel38.setText("                                                  ");
        jLabel76.setText("                    ");
        jLabel47.setText("                                                         ");
        jLabel99.setText("                                                  ");
        jLabel89.setText("                                                  ");
        jLabel78.setText("                                                  ");
        jLabel203.setText("                                                  ");
        jLabel116.setText("                                                   ");
        jLabel214.setText("                          ");
        jLabel225.setText("                           ");
        jLabel226.setText("                            ");
        jLabel227.setText("                         ");
        jLabel208.setText("                                                     ");
        jLabel228.setText("                                                     ");
        jLabel191.setText("                                                     ");
        jLabel83.setText("                                                       ");
        jLabel137.setText("                       ");
        jLabel80.setText("                         ");
        jLabel138.setText("                                                  ");
        jLabel139.setText("                       ");
         jLabel143.setText("                      ");
         jLabel140.setText("                      ");
         jLabel144.setText("                      ");
          jLabel146.setText("                     ");
          jLabel149.setText("                      ");
          jLabel150.setText("                               ");
          jLabel151.setText("                      ");
         jCheckBox4.setVisible(false);
        jCheckBox5.setVisible(false);
jCheckBox6.setVisible(false);
jCheckBox7.setVisible(false);
jCheckBox8.setVisible(false);
jCheckBox9.setVisible(false);
jCheckBox10.setVisible(false);
jCheckBox16.setVisible(false);
jCheckBox15.setVisible(false);
jCheckBox17.setVisible(false);
jCheckBox14.setVisible(false);
jCheckBox13.setVisible(false);
jCheckBox12.setVisible(false);
jCheckBox11.setVisible(false);
jCheckBox21.setVisible(false);
jCheckBox19.setVisible(false);
jCheckBox18.setVisible(false);
jCheckBox20.setVisible(false);
        itemTableHeader(jTable1);
        positionTableContentCenter(0, jTable1);
        //positionTableContentCenter(1, jTable1);
        positionTableContentCenter(2, jTable1);
        // positionTableContentCenter(3, jTable1);
        positionTableContentCenter(4, jTable1);
        itemTableHeader(jTable3);
        positionTableContentCenter(0, jTable3);
        positionTableContentCenter(2, jTable3);
        positionTableContentCenter(4, jTable3);
        itemTableHeader(jTable2);
        positionTableContentCenter(0, jTable2);
        positionTableContentCenter(3, jTable2);
        positionTableContentCenter(4, jTable2);
        positionTableContentRight(5, jTable2);
        itemTableHeader(jTable5);
        positionTableContentCenter(0, jTable5);
        positionTableContentCenter(1, jTable5);
        positionTableContentCenter(2, jTable5);
        positionTableContentCenter(3, jTable5);
        positionTableContentCenter(4, jTable5);
        positionTableContentCenter(5, jTable5);

        customerDetailsTablePosition();
        nColour = new NavigationColour();
        jPanel14.setBackground(new Color(54,33,89));
        jPanel9.setBackground(new Color(54,33,89));
        jPanel10.setBackground(new Color(54,33,89));
        jPanel18.setBackground(new Color(54,33,89));
        jPanel8.setBackground(new Color(54,33,89));
        jPanel21.setBackground(new Color(54,33,89));
        jPanel4.setBackground(new Color(54,33,89));
         
        
        
        
        
        
        
        
       
      //  holder = new PlaceHolder(jTextField10, "Enter NIC/Passport");
        
        // holder.setFont("Thoma");

       
        
        
    }

    void ViewPanel(String cname) {
        CardLayout c1 = (CardLayout) jPanel5.getLayout();
        c1.show(jPanel5, cname);
    }
      public void displayHome(){
        if(homeStatus){
            jButton22.setVisible(true);
        }
    }

    private void resetFields() {//restting values in Items management interface

        jTable1.clearSelection();

        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        buttonGroup3.clearSelection();
    }
    private void resetfield1(){
        jTable3.clearSelection();
        jTable2.clearSelection();
         buttonGroup4.clearSelection();
        buttonGroup5.clearSelection();
        buttonGroup6.clearSelection();
        
    }

    private void resetFieldsOrders() {
        jTable3.clearSelection();

        buttonGroup4.clearSelection();
        buttonGroup5.clearSelection();
        buttonGroup6.clearSelection();
    }

    private boolean restaurantUserValidation() {
        boolean validation4 = true;
        boolean validationResult = false;
       
        if (jTextField19.getText().isEmpty() || jTextField23.getText().isEmpty() || jTextField21.getText().isEmpty() || jTextField22.getText().isEmpty()) {
            jLabel208.setText("*Please fill all the fields");

            validation4 = false;
        } else {
            jLabel208.setText("                                  ");

        }

        if (validation1 && validation2 && validation3 && validation4 && validation8  ) {
            validationResult = true;
        }
        return validationResult;
    }
  

    {

        comboList = new ArrayList<String>();
        comboList.add(0, "Rice");
        comboList.add(1, "Soup");
        comboList.add(2, "Noodles");
        comboList.add(3, "Meat Dish");
        comboList.add(4, "Sea food");
        comboList.add(5, "Beverages");
        comboList.add(6, "Vegetable Dish");
        comboList.add(7, "Puddings");
        comboList.add(8, "Menus");
        comboList.add(9, "Other");

    }

    private void itemTableHeader(JTable jTable) {
        JTableHeader thead = jTable.getTableHeader();
        thead.setForeground(Color.BLACK);

        thead.setFont(new Font("Tahome", Font.BOLD, 16));

    }

    private void positionTableContentCenter(int columnIndex, JTable jTable) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);

    }

    private void positionTableContentRight(int columnIndex, JTable jTable) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        jTable.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);

    }

    private void customerDetailsTablePosition() {
        itemTableHeader(jTable4);
        positionTableContentCenter(0, jTable4);

        positionTableContentCenter(5, jTable4);

        positionTableContentCenter(6, jTable4);
        positionTableContentCenter(7, jTable4);
        positionTableContentCenter(8, jTable4);
        positionTableContentCenter(9, jTable4);
        positionTableContentCenter(10, jTable4);
        positionTableContentCenter(11, jTable4);
        positionTableContentCenter(12, jTable4);
        positionTableContentCenter(13, jTable4);
        positionTableContentCenter(14, jTable4);
        positionTableContentCenter(15, jTable4);

    }

    private void refreshTable3(List ordersList) {
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, ordersList, jTable5);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderid}"));
        columnBinding.setColumnName("Orderid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${guestid}"));
        columnBinding.setColumnName("Guestid");
        columnBinding.setColumnClass(restaurantManagementFunction.Restaurantuser.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${total}"));
        columnBinding.setColumnName("Total");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${handledstatus}"));
        columnBinding.setColumnName("Handledstatus");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${handleddate}"));
        columnBinding.setColumnName("Handleddate");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderdate}"));
        columnBinding.setColumnName("Orderdate");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }

    public void refreshTable2(List restaurantuserList) {
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, restaurantuserList, jTable4);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${guestid}"));
        columnBinding.setColumnName("Guestid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fullname}"));
        columnBinding.setColumnName("Fullname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nicpassport}"));
        columnBinding.setColumnName("Nicpassport");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contactnumber}"));
        columnBinding.setColumnName("Contact");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${preference}"));
        columnBinding.setColumnName("Preference");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${rice}"));
        columnBinding.setColumnName("Rice");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${soup}"));
        columnBinding.setColumnName("Soup");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${noodles}"));
        columnBinding.setColumnName("Noodles");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${meatdishes}"));
        columnBinding.setColumnName("Meat Dishes");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${seafood}"));
        columnBinding.setColumnName("Seafood");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${beverages}"));
        columnBinding.setColumnName("Beverages");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vegetabledishes}"));
        columnBinding.setColumnName("Veg Dishes");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${puddings}"));
        columnBinding.setColumnName("Puddings");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${menus}"));
        columnBinding.setColumnName("Menus");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${other}"));
        columnBinding.setColumnName("Other");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }

    public void refreshTable1(List resItemList) {
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, resitemList1, jTable3);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemid}"));
        columnBinding.setColumnName("Itemid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemname}"));
        columnBinding.setColumnName("Itemname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${price}"));
        columnBinding.setColumnName("Price");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${category}"));
        columnBinding.setColumnName("Category");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${qtyonhand}"));
        columnBinding.setColumnName("Qtyonhand");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }

    public void refreshTable(List resItemList) {
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, resitemList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemid}"));
        columnBinding.setColumnName("Itemid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemname}"));
        columnBinding.setColumnName("Itemname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${price}"));
        columnBinding.setColumnName("Price");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${category}"));
        columnBinding.setColumnName("Category");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${qtyonhand}"));
        columnBinding.setColumnName("Qtyonhand");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }
    public void refreshTableOrderReport(List ordersList1){
        org.jdesktop.swingbinding.JTableBinding jTableBinding= org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, ordersList1, jTable6);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderid}"));
        columnBinding.setColumnName("Orderid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${guestid}"));
        columnBinding.setColumnName("Guestid");
        columnBinding.setColumnClass(restaurantManagementFunction.Restaurantuser.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${handledstatus}"));
        columnBinding.setColumnName("Handledstatus");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderdate}"));
        columnBinding.setColumnName("Orderdate");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${handleddate}"));
        columnBinding.setColumnName("Handleddate");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${total}"));
        columnBinding.setColumnName("Total");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }

    private void resItemsSearch() {
        boolean Selected = true;
        boolean validSearch1 = true;
        boolean validSearch2 = true;
        boolean validSearch3 = true;
        boolean validSearch4 = true;
        if ((buttonGroup1.getSelection() == null) && (buttonGroup2.getSelection() == null) && (buttonGroup3.getSelection() == null)) {
            jLabel97.setText("*Please Select a Type to search");
            Selected = false;
        }
        if (buttonGroup1.getSelection() != null) {
            if ((buttonGroup2.getSelection() != null) && (buttonGroup3.getSelection() != null)) {
                JOptionPane.showMessageDialog(this, "You can't use Advanced search and normal search both at once", "Error", JOptionPane.ERROR_MESSAGE);
                validSearch3 = false;
            } else if (buttonGroup2.getSelection() != null) {
                JOptionPane.showMessageDialog(this, "You can't use Advanced search and normal search both at once", "Error", JOptionPane.ERROR_MESSAGE);
                validSearch1 = false;

            } else if (buttonGroup3.getSelection() != null) {

                JOptionPane.showMessageDialog(this, "You can't use Advanced search and normal search both at once", "Error", JOptionPane.ERROR_MESSAGE);

                validSearch2 = false;
            }
        }

        if ((buttonGroup1.getSelection() != null) && jTextField1.getText().isEmpty()) {

            jLabel92.setText("*Type something to search");
        }
        if (!(jRadioButton30.isSelected() || jRadioButton31.isSelected())) {
            validSearch4 = false;
            jLabel97.setText("*Please Select a Type to search");
        }
//if((jRadioButton30.isSelected() || jRadioButton31.isSelected()||jRadioButton1.isSelected()||)&&!(jTextField1.getText().isEmpty())){
//if((buttonGroup1.getSelection() ==null ^ buttonGroup3.getSelection()!=null) ||(buttonGroup1.getSelection() != null ^ buttonGroup2.getSelection()!=null)){
//    JOptionPane.showMessageDialog(this, "You can't use Advanced search and normal search both at once", "Error", JOptionPane.ERROR_MESSAGE);
//}    

        if (Selected && validSearch1 && validSearch2 && validSearch3) {
            jLabel92.setText("                                                  ");
            jLabel97.setText("                                                  ");
            try {
                String sql = null;
                if (jRadioButton1.isSelected() && jRadioButton8.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Rice'";
                    System.out.println("Executed1");
                } else if (jRadioButton1.isSelected() && jRadioButton12.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Soup'";

                } else if (jRadioButton1.isSelected() && jRadioButton7.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Noodles'";

                } else if (jRadioButton1.isSelected() && jRadioButton6.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Meat Dish'";

                } else if (jRadioButton1.isSelected() && jRadioButton14.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Sea food'";

                } else if (jRadioButton1.isSelected() && jRadioButton13.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Beverages'";

                } else if (jRadioButton1.isSelected() && jRadioButton10.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Vegetable Dish'";

                } else if (jRadioButton1.isSelected() && jRadioButton11.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Puddings'";

                } else if (jRadioButton1.isSelected() && jRadioButton9.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Menus'";

                } else if (jRadioButton1.isSelected() && jRadioButton29.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Other'";

                } else if (jRadioButton2.isSelected() && jRadioButton8.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Rice'";
                } else if (jRadioButton2.isSelected() && jRadioButton12.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Soup'";
                } else if (jRadioButton2.isSelected() && jRadioButton7.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Noodles'";
                } else if (jRadioButton2.isSelected() && jRadioButton6.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Meat Dish'";
                } else if (jRadioButton2.isSelected() && jRadioButton10.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Vegetable Dish'";
                } else if (jRadioButton2.isSelected() && jRadioButton11.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Puddings'";
                } else if (jRadioButton2.isSelected() && jRadioButton9.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Menus'";
                } else if (jRadioButton2.isSelected() && jRadioButton29.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Other'";
                } else if (jRadioButton3.isSelected() && jRadioButton8.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Rice'";
                } else if (jRadioButton3.isSelected() && jRadioButton12.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Soup'";
                } else if (jRadioButton3.isSelected() && jRadioButton7.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Noodles'";
                } else if (jRadioButton3.isSelected() && jRadioButton6.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Meat Dish'";
                } else if (jRadioButton3.isSelected() && jRadioButton14.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Sea food'";
                } else if (jRadioButton3.isSelected() && jRadioButton13.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Beverages'";
                } else if (jRadioButton3.isSelected() && jRadioButton10.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Vegetable Dish'";
                } else if (jRadioButton3.isSelected() && jRadioButton11.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Puddings'";
                } else if (jRadioButton3.isSelected() && jRadioButton9.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Menus'";
                } else if (jRadioButton3.isSelected() && jRadioButton29.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Other'";
                } else if (jRadioButton4.isSelected() && jRadioButton8.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Rice'";
                } else if (jRadioButton4.isSelected() && jRadioButton12.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Soup'";
                } else if (jRadioButton4.isSelected() && jRadioButton7.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Noodles'";
                } else if (jRadioButton4.isSelected() && jRadioButton6.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Meat Dish'";
                } else if (jRadioButton4.isSelected() && jRadioButton14.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Sea food'";
                } else if (jRadioButton4.isSelected() && jRadioButton13.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Beverages'";
                } else if (jRadioButton4.isSelected() && jRadioButton10.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Vegetable Dish'";
                } else if (jRadioButton4.isSelected() && jRadioButton11.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Puddings'";
                } else if (jRadioButton4.isSelected() && jRadioButton9.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Menus'";
                } else if (jRadioButton4.isSelected() && jRadioButton29.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Other'";
                } else if (jRadioButton1.isSelected()) {

                    sql = "Select * FROM resItem WHERE price between 100 AND 2000";

                } else if (jRadioButton2.isSelected()) {

                    sql = "Select * FROM resItem WHERE price between 2000 AND 4000";

                } else if (jRadioButton3.isSelected()) {

                    sql = "Select * FROM resItem WHERE price between 4000 AND 7500";

                } else if (jRadioButton4.isSelected()) {

                    sql = "Select * FROM resItem WHERE price>7500";

                } else if (jRadioButton8.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Rice'";;

                } else if (jRadioButton12.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Soup'";;

                } else if (jRadioButton7.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Noodles'";;

                } else if (jRadioButton6.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Meat Dish'";;

                } else if (jRadioButton14.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Sea food'";;

                } else if (jRadioButton13.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Beverages'";;

                } else if (jRadioButton10.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Vegetable Dish'";;

                } else if (jRadioButton11.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Puddings'";;

                } else if (jRadioButton9.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Menus'";;

                } else if (jRadioButton29.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Other'";;

                } else if (jRadioButton30.isSelected() && !(jTextField1.getText().isEmpty())) {
                    sql = "SELECT * FROM resItem WHERE ItemId=" + Integer.parseInt(jTextField1.getText()) + "";
                } else if (jRadioButton31.isSelected() && !(jTextField1.getText().isEmpty())) {
                    sql = "SELECT * FROM resItem WHERE ItemName='" + jTextField1.getText() + "'";
                }
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                resitemList.clear();
                while (rs.next()) {
                    Resitem resItem = new Resitem();
                    resItem.setItemid(rs.getInt(1));
                    resItem.setCategory(rs.getString(2));
                    resItem.setItemname(rs.getString(3));
                    resItem.setPrice(rs.getDouble(4));
                    resItem.setQtyonhand(rs.getInt(5));
                    resitemList.add(resItem);

                }
                refreshTable(resitemList);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("only numbers Allowed");
            }
        }
    }
    private void resItemValidity(){
        validation22 = false;
        try{
             String sql3 = "SELECT ItemName FROM resITEM";
         
            PreparedStatement statement2 = connection.prepareStatement(sql3);
            ResultSet rs1 = statement2.executeQuery();
            while(rs1.next()){
        if ((rs1.getString(1).replaceAll(" ", "").equalsIgnoreCase(jTextField2.getText().replaceAll(" ", "")))) {
                     jLabel38.setText("*Item name already exsists");
                    validation22 = true;
                    break;
                }
        else{
            jLabel38.setText("                                     ");
        }
            }
    }
        catch(SQLException e){
                System.out.println(e.getMessage());
                }
    }
    private void  tableBookingInsertion(int restableId,int orderId,Timestamp now){
        try{
        String sql = "INSERT INTO BookedTable(restableId,orderId,bookeddatetime)VALUES(?,?,?)";
            System.out.println("Booked");
            PreparedStatement statement = connection.prepareStatement(sql);
            int i1 = 1;
            int i2 = 1;
            statement.setInt(1, restableId);
            statement.setInt(2, orderId);
            //java.util.Date today = jDateChooser2.getDate();
            //java.sql.Timestamp(today.getTime());
           // Timestamp t1 = new Timestamp(today.getTime());
            statement.setTimestamp(3, now);
            // statement.setInt(4,Integer.parseInt(jTextField5.getText()));

            statement.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void calculatingTotalBill(){
         NumberFormat formatter = new DecimalFormat("0.00");

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Double subTotal = 0.0;
        try {
            for (int i = 0; i < model.getRowCount(); i++) {

                subTotal = subTotal + Double.parseDouble(model.getValueAt(i, 5).toString());
            }

        } catch (Exception e) {

        }
        jTextField8.setText(formatter.format(subTotal));
    }
    private double resIncome(JDateChooser jDateChooser1){
          double sum = 0;
         java.util.Date startingDate =jDateChooser1.getDate();
             startingDate.setYear(jDateChooser1.getDate().getYear());
             startingDate.setMonth(jDateChooser1.getDate().getMonth());
             startingDate.setDate(0);
             
            
             
             System.out.println(startingDate);
                     
       java.util.Date endingDate = jDateChooser1.getDate();
       int monthNo= jDateChooser1.getDate().getMonth();
       int endingDateDay = 0;
       int endingMonth = 0;
       String monthName = null;
       if(monthNo == 0){
            endingMonth = 1;
           endingDateDay = 1;
          
       }
       else if(monthNo == 1){
           endingMonth = 2;
           endingDateDay = 1;
       }
       else if(monthNo == 2){
           endingMonth = 3;
           endingDateDay = 1;
       }
       else if(monthNo == 3){
             endingMonth = 4;
           endingDateDay = 1;
       }
       else if(monthNo == 4){
             endingMonth = 5;
           endingDateDay = 1;
       }
       else if(monthNo == 5){
           endingMonth=6;
           endingDateDay = 1;
       }
       else if(monthNo == 6){
           endingDateDay = 1;
           endingMonth=7;
       }
       else if(monthNo == 7){
        endingDateDay = 1;
        endingMonth =8;
        }
       else if(monthNo == 8){
           endingDateDay = 1;
           endingMonth = 9;
       }else if(monthNo == 9){
           endingDateDay = 1;
           endingMonth=10;
       }
       else if(monthNo == 10){
           endingMonth =11;
           endingDateDay = 1;
       }
       else{
           endingMonth=11;
           endingDateDay= 30;
       }
       endingDate.setYear(jDateChooser1.getDate().getYear());
             endingDate.setMonth(endingMonth);
             endingDate.setDate(endingDateDay);
             
        System.out.println("ending Date: " + endingDate);
        
            java.sql.Date d1 = null;
            d1 = new java.sql.Date(startingDate.getTime());
           java.sql.Date d2 = null;
            d2 = new java.sql.Date(endingDate.getTime());
            
            
        try{
           String sql3="SELECT SUM(Total) FROM Orders WHERE orderDate BETWEEN '"+d1+"' AND '"+d2+"' AND handledstatus=true";     
                       PreparedStatement pst3 = connection.prepareStatement(sql3);
             // pst2.setBoolean(1,false);
                ResultSet rs3 = pst3.executeQuery();
              
                while(rs3.next()){
                 sum=  rs3.getDouble(1);
                }
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }   
        System.out.println("Sum:" + sum);
        return sum;
    
}
      
     public void showDate(){
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-YYYY");
        jLabel169.setText(s.format(d));

    }
    
    public void showTime(){
        new Timer(0,new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh : mm : ss a");
                
            jLabel170.setText(s.format(d));

            }
    }).start();
    }
    private String showMonth(JDateChooser jDateChooser){
           String monthName = null;
        if(!(jDateChooser.getDate() == null)){
            int month = -1;
         
            month = jDateChooser.getDate().getMonth();
            if(month == 0){
                monthName = "January";
            }
            else if(month == 1){
                monthName ="February";
            }
            else if(month == 2){
                monthName ="March";
            }
            else if(month ==3){
                monthName ="April";
            }
            else if(month ==4){
                monthName ="May";
            }
            else if(month == 5){
                monthName ="June";
            }
            else if(month == 6){
                monthName ="July";
            }
            else if(month ==7){
                monthName ="August";
            }
            else if(month ==8){
                monthName ="September";
            }
            else if(month == 9){
                monthName ="October";
            }
            else if(month == 10){
                monthName ="November";
            }
            else{
                monthName ="December";
            }
        }
        return monthName;
        
    }
    private double monthEndIncome(int start,int end){
        double sum44 = 0;
        try{ 
        java.util.Date firstMonthStart = new Date();
                firstMonthStart.setMonth(start);
                firstMonthStart.setDate(0);
                
                java.util.Date firstMonthEnd = new Date();
                firstMonthEnd.setMonth(end);
                firstMonthEnd.setDate(1);
                
              java.sql.Date firstMonthStartDate = null;
            firstMonthStartDate= new java.sql.Date(firstMonthStart.getTime());
            
                    java.sql.Date firstMonthEndDate = null;
             firstMonthEndDate= new java.sql.Date(firstMonthEnd.getTime());
               String sql44 = "SELECT SUM(Total) FROM Orders WHERE orderDate BETWEEN '"+firstMonthStartDate+"' AND '"+firstMonthEndDate+"' AND handledstatus=true";
                PreparedStatement pst44 = connection.prepareStatement(sql44);
               ResultSet rs44 = pst44.executeQuery();
                //double sum44 = 0;
                while(rs44.next()){
                 sum44=  rs44.getDouble(1);
                }
               
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
         return sum44;
    }
    private  void countCategory(){
       int sum44=0;
       int sum45 =0;
       int sum46=0;
       int sum47 =0;
       int sum48 =0;
       int sum49=0;
       int sum50=0;
       int sum51 =0;
       int sum52=0;
        try{ 
        String sql44 = "SELECT SUM(RICE) FROM RestaurantUser" ;
                PreparedStatement pst44 = connection.prepareStatement(sql44);
               ResultSet rs44 = pst44.executeQuery();
                //double sum44 = 0;
                while(rs44.next()){
                 sum44=  rs44.getInt(1);
                }
                
          String sql45 = "SELECT SUM(SOUP) FROM RestaurantUser" ;
                PreparedStatement pst45 = connection.prepareStatement(sql45);
               ResultSet rs45 = pst45.executeQuery();
                //double sum44 = 0;
                while(rs45.next()){
                 sum45=  rs45.getInt(1);
                }       
         String sql46 = "SELECT SUM(NOODLES) FROM RestaurantUser" ;
                PreparedStatement pst46 = connection.prepareStatement(sql46);
               ResultSet rs46 = pst46.executeQuery();
                //double sum44 = 0;
                while(rs46.next()){
                 sum46=  rs46.getInt(1);
                }              
             String sql47= "SELECT SUM(MEATDISHES) FROM RestaurantUser" ;
                PreparedStatement pst47 = connection.prepareStatement(sql47);
               ResultSet rs47 = pst47.executeQuery();
                //double sum44 = 0;
                while(rs47.next()){
                 sum47=  rs47.getInt(1);
                }  
              String sql48= "SELECT SUM(SEAFOOD) FROM RestaurantUser" ;
                PreparedStatement pst48 = connection.prepareStatement(sql48);
               ResultSet rs48 = pst48.executeQuery();
                //double sum44 = 0;
                while(rs48.next()){
                 sum48=  rs48.getInt(1);
                }  
                
                String sql49= "SELECT SUM(BEVERAGES) FROM RestaurantUser" ;
                PreparedStatement pst49 = connection.prepareStatement(sql49);
               ResultSet rs49 = pst49.executeQuery();
                //double sum44 = 0;
                while(rs49.next()){
                 sum49=  rs49.getInt(1);
                } 
                 String sql50= "SELECT SUM(VEGETABLEDISHES) FROM RestaurantUser" ;
                PreparedStatement pst50 = connection.prepareStatement(sql50);
               ResultSet rs50 = pst50.executeQuery();
                //double sum44 = 0;
                while(rs50.next()){
                 sum50=  rs50.getInt(1);
                } 
                 String sql51= "SELECT SUM(PUDDINGS) FROM RestaurantUser" ;
                PreparedStatement pst51 = connection.prepareStatement(sql51);
               ResultSet rs51 = pst51.executeQuery();
                //double sum44 = 0;
                while(rs51.next()){
                 sum51=  rs51.getInt(1);
                } 
                 String sql52= "SELECT SUM(MENUS) FROM RestaurantUser" ;
                PreparedStatement pst52 = connection.prepareStatement(sql52);
               ResultSet rs52 = pst52.executeQuery();
                //double sum44 = 0;
                while(rs52.next()){
                 sum52=  rs52.getInt(1);
                } 
                   
                
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void covertPdfReport(){
        String path="";
        JFileChooser j=new JFileChooser();
        int x=j.showOpenDialog(this);
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //int x=j.showOpenDialog(this);
        
        if(x==JFileChooser.APPROVE_OPTION){
            
            path=j.getSelectedFile().getPath();
        }
          int width=640; /* Width of our chart */
                int height=480;
       // Document doc=new Document(new Rectangle(width,height));
        Document doc=new Document();
        //JFreeChart my2DChart=ChartFactory.createBarChart("Mark Details","Subject","Marks",mychartData,PlotOrientation.VERTICAL,false,true,false);
                /* 2D Chart created till this point, this can be moved into iText PDF */
//                int width=640; /* Width of our chart */
//                int height=480; /* Height of our chart */
//                Document document1=new Document(new Rectangle(width,height)); /* Create a New Document Object */
                /* Create PDF Writer Object that will write the chart information for us */
                //PdfWriter writer=PdfWriter.getInstance(document,new FileOutputStream("Insert_2d_Chart_in_PDF.pdf"));
//                  String path="";
//        JFileChooser j=new JFileChooser();
//        int x=j.showOpenDialog(this);
//        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        //int x=j.showOpenDialog(this);
//        
//        if(x==JFileChooser.APPROVE_OPTION){
//            
//            path=j.getSelectedFile().getPath();
//        }

       // Document doc=new Document();
        
       
            //PdfWriter.getInstance(doc,new FileOutputStream("C:\\Users\\kavee\\OneDrive\\Desktop\\Report.pdf"));
//           PdfWriter writer= PdfWriter.getInstance(document,new FileOutputStream(path + ".pdf")); 
//            
//                /* Open the Document Object for adding contents */
//                document.open();
                /* Get Direct Content of the PDF document for writing */
              
        try{
//             double val1=resIncome(jDateChooser1);
//        double val2 = resIncome(jDateChooser4);
//        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
//        dataSet.setValue(val1,"Income",showMonth(jDateChooser1));
//        dataSet.setValue(val2,"Income",showMonth(jDateChooser4));
//        
//        JFreeChart chart= ChartFactory.createBarChart("Income Comparision Chart","Month", "Value", dataSet, PlotOrientation.VERTICAL, false,true,false);
//        CategoryPlot p =chart.getCategoryPlot();
//        p.setRangeGridlinePaint(Color.black);
//        ChartPanel panel = new ChartPanel(chart);
//       
//        ChartFrame frame = new ChartFrame("Income Comparision Chart",chart);
//        frame.setVisible(true);
//        frame.setSize(450,350);
//        frame.setLocationRelativeTo(null);
//            
//            //PdfWriter.getInstance(doc,new FileOutputStream("C:\\Users\\kavee\\OneDrive\\Desktop\\Report.pdf"));
//              PdfWriter writer= PdfWriter.getInstance(doc,new FileOutputStream(path + ".pdf"));  
            doc.open();
//            
//              PdfContentByte Add_Chart_Content= writer.getDirectContent();
//                /* Create a template using the PdfContent Byte object */
//                PdfTemplate template_Chart_Holder=Add_Chart_Content.createTemplate(width,height);
//                /* Create a 2D graphics object to write on the template */
//                Graphics2D Graphics_Chart=template_Chart_Holder.createGraphics(width,height,new DefaultFontMapper());
//                /* Create a Rectangle object */
//                Rectangle2D Chart_Region=new Rectangle2D.Double(0,0,540,380);
//                /* Invoke the draw method passing the Graphics and Rectangle 2D object to draw the chart */
//                chart.draw(Graphics_Chart,Chart_Region);            
//                Graphics_Chart.dispose();
//                /* Add template to PdfContentByte and then to the PDF document */
//                Add_Chart_Content.addTemplate(template_Chart_Holder,0,0);
//        
//            
          
           Paragraph poo=new Paragraph("No of Orders: " + jTextField36.getText());
         
            
            Paragraph p1=new Paragraph("No of unhandled Orders : "+jTextField34.getText());
            
            Paragraph p2=new Paragraph("Pending Income: " + jTextField35.getText());
               Paragraph p3=new Paragraph("Income: " + jTextField37.getText());
            
            
            
         
            PdfPTable tb=new PdfPTable(6);
          
                tb.addCell("Order ID");
                tb.addCell("Guest ID");
                tb.addCell("Handled Status");
                tb.addCell("Order Date");
                tb.addCell("Handled Date");
                tb.addCell("Total");
                //tb.addCell("Total Payment");
                doc.setPageSize(PageSize.LETTER);

                for(int i=0;i<jTable6.getRowCount();i++){
                    System.out.println("r1");

                    //Integer id=Integer.parseInt(jTable4.getValueAt(i,0).toString());
                    String id=jTable6.getValueAt(i,0).toString();
                    String nic=jTable6.getValueAt(i,1).toString();
                    String fname=jTable6.getValueAt(i,2).toString();
                    String lname=jTable6.getValueAt(i,3).toString();
                    String checkin=jTable6.getValueAt(i,4).toString();
                    String checkout=jTable6.getValueAt(i,5).toString();
                    //String tot=jTable6.getValueAt(i,6).toString();

                    System.out.println("r2");

                tb.addCell(id);
                tb.addCell(nic);
                tb.addCell(fname);
                tb.addCell(lname);
                tb.addCell(checkin);
                tb.addCell(checkout);
               // tb.addCell(tot);

                    System.out.println("r3" + jTable6.getRowCount());

                }
            
            doc.add(tb);
            doc.add(poo);
           doc.add(p1);
            doc.add(p2);
            doc.add(p3);
            
            JOptionPane.showMessageDialog(null,"Report Generated Successfully","AlERT MESSAGE",JOptionPane.WARNING_MESSAGE);
         
//        }catch(FileNotFoundException ex){
//             Logger.getLogger(RestaurantManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(RestaurantManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         doc.close();
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
        resitemQuery = java.beans.Beans.isDesignTime() ? null : HotelManagementSystemPUEntityManager.createQuery("SELECT r FROM Resitem r");
        resitemList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : resitemQuery.getResultList();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        resitemQuery1 = java.beans.Beans.isDesignTime() ? null : HotelManagementSystemPUEntityManager.createQuery("SELECT r FROM Resitem r");
        resitemList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : resitemQuery1.getResultList();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        restaurantuserQuery = java.beans.Beans.isDesignTime() ? null : HotelManagementSystemPUEntityManager.createQuery("SELECT r FROM Restaurantuser r");
        restaurantuserList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : restaurantuserQuery.getResultList();
        buttonGroup7 = new javax.swing.ButtonGroup();
        ordersQuery = java.beans.Beans.isDesignTime() ? null : HotelManagementSystemPUEntityManager.createQuery("SELECT o FROM Orders o");
        ordersList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : ordersQuery.getResultList();
        ordersQuery1 = java.beans.Beans.isDesignTime() ? null : HotelManagementSystemPUEntityManager.createQuery("SELECT o FROM Orders o");
        ordersList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : ordersQuery1.getResultList();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jRadioButton29 = new javax.swing.JRadioButton();
        jLabel213 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jRadioButton30 = new javax.swing.JRadioButton();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jRadioButton31 = new javax.swing.JRadioButton();
        jLabel92 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jRadioButton20 = new javax.swing.JRadioButton();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jRadioButton23 = new javax.swing.JRadioButton();
        jRadioButton24 = new javax.swing.JRadioButton();
        jRadioButton25 = new javax.swing.JRadioButton();
        jRadioButton26 = new javax.swing.JRadioButton();
        jRadioButton27 = new javax.swing.JRadioButton();
        jRadioButton28 = new javax.swing.JRadioButton();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jRadioButton19 = new javax.swing.JRadioButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel70 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel84 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel151 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel212 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton32 = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jLabel174 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jPanel43 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jCheckBox8 = new javax.swing.JCheckBox();
        jPanel71 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jPanel70 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jPanel69 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jPanel72 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel73 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jCheckBox21 = new javax.swing.JCheckBox();
        jPanel74 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jCheckBox15 = new javax.swing.JCheckBox();
        jPanel75 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jCheckBox16 = new javax.swing.JCheckBox();
        jPanel76 = new javax.swing.JPanel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jPanel77 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jCheckBox17 = new javax.swing.JCheckBox();
        jPanel78 = new javax.swing.JPanel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jCheckBox14 = new javax.swing.JCheckBox();
        jPanel79 = new javax.swing.JPanel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jPanel80 = new javax.swing.JPanel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jCheckBox12 = new javax.swing.JCheckBox();
        jPanel81 = new javax.swing.JPanel();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jPanel82 = new javax.swing.JPanel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jCheckBox19 = new javax.swing.JCheckBox();
        jPanel83 = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jCheckBox18 = new javax.swing.JCheckBox();
        jPanel84 = new javax.swing.JPanel();
        jLabel183 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jCheckBox20 = new javax.swing.JCheckBox();
        jLabel209 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel229 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel190 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton18 = new javax.swing.JButton();
        jLabel191 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel221 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel218 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jTextField17 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jTextField32 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel149 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jLabel223 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton8 = new javax.swing.JButton();
        jLabel144 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel77 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jRadioButton33 = new javax.swing.JRadioButton();
        jRadioButton34 = new javax.swing.JRadioButton();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel156 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jLabel163 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 1009));

        jPanel4.setBackground(new java.awt.Color(85, 68, 118));
        jPanel4.setToolTipText("");
        jPanel4.setPreferredSize(new java.awt.Dimension(304, 67));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/resFood.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("   Items and Menus");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel9.setBackground(new java.awt.Color(85, 68, 118));
        jPanel9.setToolTipText("");
        jPanel9.setPreferredSize(new java.awt.Dimension(271, 67));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/resOrder.png"))); // NOI18N
        jLabel7.setText("jLabel4");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("    Order Handling");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel10.setBackground(new java.awt.Color(85, 68, 118));
        jPanel10.setToolTipText("");
        jPanel10.setPreferredSize(new java.awt.Dimension(300, 67));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/OrderInfo.png"))); // NOI18N
        jLabel9.setText("jLabel4");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("    Order Details");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(13, 13, 13))
        );

        jPanel8.setBackground(new java.awt.Color(85, 68, 118));
        jPanel8.setToolTipText("");
        jPanel8.setPreferredSize(new java.awt.Dimension(280, 67));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/TableReservation.png"))); // NOI18N
        jLabel5.setText("jLabel4");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("   Table Avialability");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 3, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("     Restaurant ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("   Management");

        jPanel18.setBackground(new java.awt.Color(85, 68, 118));
        jPanel18.setToolTipText("");
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel18MouseExited(evt);
            }
        });

        jLabel201.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ResUser.png"))); // NOI18N
        jLabel201.setText("jLabel4");

        jLabel202.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(255, 255, 255));
        jLabel202.setText("   Customer Details");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel201, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel202, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel201, javax.swing.GroupLayout.PREFERRED_SIZE, 66, Short.MAX_VALUE)
                .addComponent(jLabel202))
        );

        jPanel21.setBackground(new java.awt.Color(85, 68, 118));
        jPanel21.setToolTipText("");
        jPanel21.setPreferredSize(new java.awt.Dimension(300, 67));
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel21MouseExited(evt);
            }
        });

        jLabel152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ReportsFinal.png"))); // NOI18N
        jLabel152.setText("jLabel4");

        jLabel155.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(255, 255, 255));
        jLabel155.setText("  Restaurant Reports");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel155, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel155)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(59, 59, 59)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(986, Short.MAX_VALUE))
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

        jLabel121.setFont(new java.awt.Font("Segoe UI", 0, 80)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 255, 255));
        jLabel121.setText("H o t e l  K a b a l a n a");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 836, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel167.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo (1).png"))); // NOI18N
        jLabel167.setText("jLabel167");

        jLabel168.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(255, 255, 255));
        jLabel168.setText("Matara Rd, Ahangama 80650");

        jLabel169.setBackground(new java.awt.Color(255, 255, 255));
        jLabel169.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(255, 255, 255));
        jLabel169.setText("jLabel169");

        jLabel170.setBackground(new java.awt.Color(255, 255, 255));
        jLabel170.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(255, 255, 255));
        jLabel170.setText("jLabel170");

        jButton22.setBackground(new java.awt.Color(54, 33, 89));
        jButton22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("Home");
        jButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton22MouseClicked(evt);
            }
        });
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(54, 33, 89));
        jButton23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("Log Out");
        jButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton23MouseClicked(evt);
            }
        });
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jLabel167, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel168, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel170)
                    .addComponent(jLabel169))
                .addGap(0, 3466, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
            .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jLabel169)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel170)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jLabel168, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel167, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 2, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.CardLayout());

        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel24.setText("Item name:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel31.setText("Item type:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel32.setText("Item price:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.itemname}"), jTextField2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.price}"), jTextField3, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Remove");
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

        jTable1.setBorder(new javax.swing.border.MatteBorder(null));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, resitemList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemid}"));
        columnBinding.setColumnName("Itemid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemname}"));
        columnBinding.setColumnName("Itemname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${price}"));
        columnBinding.setColumnName("Price");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${category}"));
        columnBinding.setColumnName("Category");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${qtyonhand}"));
        columnBinding.setColumnName("Qtyonhand");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel7.setLayout(new java.awt.CardLayout());

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AdvancedSearch.png"))); // NOI18N
        jLabel33.setText("jLabel12");

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/up.png"))); // NOI18N
        jLabel35.setText("jLabel34");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel36.setText("Advanced Search");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Price Ranges");

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("jRadioButton1");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setText("100-2000");

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("jRadioButton2");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel16.setText("2000-4000");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("jRadioButton2");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel17.setText("4000-7500");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("jRadioButton2");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel18.setText("7500>");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Categories");

        buttonGroup3.add(jRadioButton8);
        jRadioButton8.setText("jRadioButton6");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel21.setText("Rice");

        buttonGroup3.add(jRadioButton12);
        jRadioButton12.setText("jRadioButton6");

        buttonGroup3.add(jRadioButton7);
        jRadioButton7.setText("jRadioButton6");

        buttonGroup3.add(jRadioButton6);
        jRadioButton6.setText("jRadioButton6");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton14);
        jRadioButton14.setText("jRadioButton13");

        buttonGroup3.add(jRadioButton13);
        jRadioButton13.setText("jRadioButton13");

        buttonGroup3.add(jRadioButton10);
        jRadioButton10.setText("jRadioButton6");
        jRadioButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton10ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton11);
        jRadioButton11.setText("jRadioButton6");

        buttonGroup3.add(jRadioButton9);
        jRadioButton9.setText("jRadioButton6");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel23.setText("Soup");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel22.setText("Noodles");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel29.setText("Meat Dish");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel25.setText("Sea food");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel26.setText("Beverages");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel30.setText(" Vegetable Dish");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel28.setText("Puddings");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel27.setText("Menus");

        buttonGroup3.add(jRadioButton29);
        jRadioButton29.setText("jRadioButton29");
        jRadioButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton29ActionPerformed(evt);
            }
        });

        jLabel213.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel213.setText("Other");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15))
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jRadioButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel28))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jRadioButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jRadioButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jRadioButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jRadioButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jRadioButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jRadioButton29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jRadioButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel213)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jRadioButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton2)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton3)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(jLabel18))
                        .addGap(62, 62, 62)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton8)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton12)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton7)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton6)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton14)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton13)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton10)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton11))
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton9)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton29)
                    .addComponent(jLabel213))
                .addContainerGap(941, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel13, "card3");

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AdvancedSearch.png"))); // NOI18N
        jLabel12.setText("jLabel12");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("Advanced Search");

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Down.png"))); // NOI18N
        jLabel34.setText("jLabel34");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel34))
                .addContainerGap(1551, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel12, "card2");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel37.setText("Qty on hand:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.qtyonhand}"), jTextField5, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 0, 51));
        jLabel38.setText("*Item name already exsists");

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 0, 51));
        jLabel76.setText("*Please fill all the fields");

        buttonGroup1.add(jRadioButton30);
        jRadioButton30.setText("jRadioButton30");
        jRadioButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton30ActionPerformed(evt);
            }
        });

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel90.setText("Search by Name");

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel91.setText("Search by ID");

        buttonGroup1.add(jRadioButton31);
        jRadioButton31.setText("jRadioButton31");

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 0, 51));
        jLabel92.setText("*Type something to search");

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 0, 51));
        jLabel97.setText("*Please select a type to search");

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 0, 51));
        jLabel80.setText("*please enter a valid Qty");

        jLabel137.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(255, 0, 51));
        jLabel137.setText("*Please enter valid Price");

        jLabel138.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(255, 0, 51));
        jLabel138.setText("*please select a row");

        jLabel173.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel173.setText("Items and Menus");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(732, 732, 732)
                        .addComponent(jLabel32)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel24))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(175, 175, 175)
                        .addComponent(jLabel37)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel80)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel92, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel91)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel90)))
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(3829, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel97))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel92)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton30)
                    .addComponent(jLabel90)
                    .addComponent(jLabel91)
                    .addComponent(jRadioButton31))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel138)
                .addGap(64, 64, 64)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel80))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jLabel137))
                .addGap(48, 48, 48)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(359, 359, 359))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, "card2");

        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });

        jPanel14.setLayout(new java.awt.CardLayout());

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel63.setText("Advanced Search");

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/up.png"))); // NOI18N
        jLabel64.setText("jLabel34");

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AdvancedSearch.png"))); // NOI18N
        jLabel61.setText("jLabel12");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setText("Price Ranges");

        buttonGroup5.add(jRadioButton15);
        jRadioButton15.setText("jRadioButton1");

        buttonGroup5.add(jRadioButton16);
        jRadioButton16.setText("jRadioButton2");

        buttonGroup5.add(jRadioButton17);
        jRadioButton17.setText("jRadioButton2");

        buttonGroup5.add(jRadioButton18);
        jRadioButton18.setText("jRadioButton2");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel43.setText("100-2000");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel44.setText("2000-4000");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel45.setText("4000-7500");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel46.setText(">7500");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel48.setText("Categories");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel49.setText("Rice");

        buttonGroup6.add(jRadioButton20);
        jRadioButton20.setText("jRadioButton6");

        buttonGroup6.add(jRadioButton21);
        jRadioButton21.setText("jRadioButton6");

        buttonGroup6.add(jRadioButton22);
        jRadioButton22.setText("jRadioButton6");

        buttonGroup6.add(jRadioButton23);
        jRadioButton23.setText("jRadioButton6");

        buttonGroup6.add(jRadioButton24);
        jRadioButton24.setText("jRadioButton13");

        buttonGroup6.add(jRadioButton25);
        jRadioButton25.setText("jRadioButton13");

        buttonGroup6.add(jRadioButton26);
        jRadioButton26.setText("jRadioButton6");

        buttonGroup6.add(jRadioButton27);
        jRadioButton27.setText("jRadioButton6");

        buttonGroup6.add(jRadioButton28);
        jRadioButton28.setText("jRadioButton6");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel50.setText("Soup");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel51.setText("Noodels");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel52.setText("Meat Dishes");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel53.setText("Sea food");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel54.setText("Beverages");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel55.setText("Vegetable Dishes");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel56.setText("Puddings");

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel57.setText("Menus");

        jRadioButton19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jRadioButton19.setText("Other");
        jRadioButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jRadioButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(jRadioButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel43))
                                    .addComponent(jLabel42)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(jRadioButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel44))
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(jRadioButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(22, 22, 22))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jRadioButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel57))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jRadioButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel56))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jRadioButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel55))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jRadioButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel54))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jRadioButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jRadioButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel48)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jRadioButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                                    .addComponent(jRadioButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                                    .addComponent(jRadioButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel52))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel63))
                            .addComponent(jRadioButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel61)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64))
                .addGap(18, 18, 18)
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton15)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton16)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton17)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton18)
                    .addComponent(jLabel46))
                .addGap(56, 56, 56)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton21)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton22)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton23)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton24)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton25)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton26)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton27)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton28)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton19)
                .addContainerGap(912, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel17, "card3");

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AdvancedSearch.png"))); // NOI18N
        jLabel58.setText("jLabel12");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel59.setText("Advanced Search");

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Down.png"))); // NOI18N
        jLabel60.setText("jLabel34");

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AdvancedSearch.png"))); // NOI18N
        jLabel39.setText("jLabel12");

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/up.png"))); // NOI18N
        jLabel40.setText("jLabel34");
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel41.setText("Advanced Search");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41)
                        .addGap(41, 41, 41)))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel59)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel58)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(jLabel60)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41))))
                .addContainerGap(1524, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel16, "card2");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Id", "Item Name", "Item Type", "Qty", "Item Price", "Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel69.setText("NIC/Passport:");

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel68.setText("Customer name:");

        jTextField11.setEditable(false);
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel75.setText("Most preffered type:");

        jTextField13.setEditable(false);

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 0, 51));
        jLabel89.setText("*Not a previous Customer");

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel107.setText("GuestID:");

        jTextField29.setEditable(false);
        jTextField29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel68)
                            .addComponent(jLabel69))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel107)
                            .addComponent(jLabel75))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel89))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel107)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabel89)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel66.setText("Item  name:");

        jTextField9.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.itemname}"), jTextField9, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel72.setText("ItemType:");

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel65.setText("Item Price:");

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel67.setText("Qty on hand:");

        jTextField12.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.qtyonhand}"), jTextField12, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel71.setText("Qty:");

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 0, 51));
        jLabel78.setText("*Please fill all the fields");

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setText("Add");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTextField6.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.category}"), jTextField6, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField14KeyReleased(evt);
            }
        });

        jTextField15.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.price}"), jTextField15, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setText("Update");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton12.setText("Remove");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel84.setText("ItemId:");

        jTextField26.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.itemid}"), jTextField26, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });

        jLabel122.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel122.setText("Handling");

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("jCheckBox3");

        jLabel151.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(255, 0, 51));
        jLabel151.setText("*only allowed numbers");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66)
                            .addComponent(jLabel72)
                            .addComponent(jLabel65)
                            .addComponent(jLabel67)
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel84))
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel24Layout.createSequentialGroup()
                                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                            .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel122)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel24Layout.createSequentialGroup()
                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jButton6))))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12))))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84)
                    .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3))
                .addGap(12, 12, 12)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel151))
                .addGap(15, 15, 15)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton9)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel78))
        );

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, resitemList1, jTable3);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemid}"));
        columnBinding.setColumnName("Itemid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemname}"));
        columnBinding.setColumnName("Itemname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${price}"));
        columnBinding.setColumnName("Price");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${category}"));
        columnBinding.setColumnName("Category");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${qtyonhand}"));
        columnBinding.setColumnName("Qtyonhand");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane3.setViewportView(jTable3);

        jLabel212.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel212.setText("Total amount:");

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setText("View Total");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        buttonGroup4.add(jRadioButton5);
        jRadioButton5.setText("jRadioButton5");

        buttonGroup4.add(jRadioButton32);
        jRadioButton32.setText("jRadioButton32");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setText("Search by ID");

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel98.setText("Search by Name");

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 0, 51));
        jLabel99.setText("*Please select a type to search");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 0, 51));
        jLabel47.setText("*Type something to search");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton16.setText("Proceed");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel174.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel174.setText("Order Handling");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel70))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel212)
                            .addGap(27, 27, 27)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addGap(157, 157, 157)
                                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addGap(75, 75, 75)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(77, 77, 77)
                                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(jLabel174, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1656, 3492, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel174)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jLabel99))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jLabel19)
                    .addComponent(jLabel98)
                    .addComponent(jRadioButton32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jLabel212))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jButton16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel70)
                .addContainerGap())
        );

        jPanel5.add(jPanel11, "card3");

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));

        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel88.setText("jLabel82");

        jLabel220.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel220.setText("3");

        jCheckBox6.setText("jCheckBox6");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel87)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel220)
                        .addGap(57, 57, 57)
                        .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox6)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel220)))
                .addGap(18, 18, 18)
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel82.setText("jLabel82");

        jLabel134.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel134.setText(" 5");

        jCheckBox8.setText("jCheckBox8");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel134)
                        .addGap(56, 56, 56)
                        .addComponent(jCheckBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel134))
                    .addComponent(jCheckBox8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));

        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel106.setText("jLabel82");

        jLabel192.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel192.setText("       6");

        jCheckBox9.setText("jCheckBox9");

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel71Layout.createSequentialGroup()
                        .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel71Layout.createSequentialGroup()
                            .addComponent(jLabel192)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel71Layout.createSequentialGroup()
                            .addComponent(jLabel105)
                            .addGap(21, 21, 21)))))
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel192))
                    .addComponent(jCheckBox9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel105)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));

        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel94.setText("jLabel82");

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel101.setText("     4");

        jCheckBox7.setText("jCheckBox7");

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel101)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel70Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel70Layout.createSequentialGroup()
                        .addComponent(jLabel93)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel70Layout.createSequentialGroup()
                        .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel70Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel101))
                    .addComponent(jCheckBox7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel93)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel69.setBackground(new java.awt.Color(255, 255, 255));

        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel96.setText("jLabel82");

        jLabel210.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel210.setText(" 2");

        jCheckBox5.setText("jCheckBox5");

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel69Layout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel69Layout.createSequentialGroup()
                        .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel69Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel210)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel69Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel210))
                    .addComponent(jCheckBox5))
                .addGap(18, 18, 18)
                .addComponent(jLabel95)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel72.setBackground(new java.awt.Color(255, 255, 255));

        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel112.setText("jLabel82");

        jLabel207.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel207.setText("   1");

        jCheckBox4.setText("jCheckBox4");

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel207)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                        .addComponent(jLabel111)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                        .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addComponent(jCheckBox4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel207)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel111)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel73.setBackground(new java.awt.Color(255, 255, 255));
        jPanel73.setPreferredSize(new java.awt.Dimension(159, 245));

        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel118.setText("jLabel82");

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel125.setText("     15");

        jCheckBox21.setText("jCheckBox21");

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel73Layout.createSequentialGroup()
                        .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel73Layout.createSequentialGroup()
                        .addComponent(jLabel117)
                        .addContainerGap())
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel125)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox21, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel125))
                    .addComponent(jCheckBox21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel117)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jPanel74.setBackground(new java.awt.Color(255, 255, 255));
        jPanel74.setPreferredSize(new java.awt.Dimension(159, 245));

        jLabel123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N

        jLabel145.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel145.setText("9");

        jCheckBox15.setText("jCheckBox15");

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel123, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel145))
                    .addComponent(jCheckBox15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel123)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jPanel75.setBackground(new java.awt.Color(255, 255, 255));

        jLabel129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel130.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel130.setText("jLabel82");

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel102.setText("   8");

        jCheckBox16.setText("jCheckBox16");

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel75Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel102)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox16, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel75Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel75Layout.createSequentialGroup()
                        .addComponent(jLabel129)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel75Layout.createSequentialGroup()
                        .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel75Layout.createSequentialGroup()
                        .addComponent(jCheckBox16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel75Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jLabel102)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel129)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jPanel76.setBackground(new java.awt.Color(255, 255, 255));

        jLabel135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel136.setText("jLabel82");

        jLabel193.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel193.setText("      7");

        jCheckBox10.setText("jCheckBox10");

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel193)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel76Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel76Layout.createSequentialGroup()
                        .addComponent(jLabel135)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel76Layout.createSequentialGroup()
                        .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel76Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel193))
                    .addComponent(jCheckBox10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel135)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel77.setBackground(new java.awt.Color(255, 255, 255));
        jPanel77.setPreferredSize(new java.awt.Dimension(159, 245));

        jLabel141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel142.setText("jLabel82");

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel103.setText("       10");

        jCheckBox17.setText("jCheckBox17");

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel77Layout.createSequentialGroup()
                        .addComponent(jLabel103)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel77Layout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel77Layout.createSequentialGroup()
                                .addComponent(jLabel141)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel77Layout.createSequentialGroup()
                                .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))))))
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel77Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel103))
                    .addComponent(jCheckBox17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel141)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        jPanel78.setBackground(new java.awt.Color(255, 255, 255));

        jLabel147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel148.setText("jLabel82");

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel104.setText("     11");

        jCheckBox14.setText("jCheckBox14");

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel104)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel78Layout.createSequentialGroup()
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel78Layout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(jLabel147))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel78Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel78Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel104))
                    .addComponent(jCheckBox14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel147)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel79.setBackground(new java.awt.Color(255, 255, 255));

        jLabel153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel154.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel154.setText("jLabel82");

        jLabel131.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel131.setText("     12 ");

        jCheckBox13.setText("jCheckBox13");

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel131)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel79Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel79Layout.createSequentialGroup()
                        .addComponent(jLabel153)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel79Layout.createSequentialGroup()
                        .addComponent(jLabel154, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel79Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel131))
                    .addComponent(jCheckBox13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel153)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel154, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel80.setBackground(new java.awt.Color(255, 255, 255));

        jLabel159.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel160.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel160.setText("jLabel82");

        jLabel132.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel132.setText("      13");

        jCheckBox12.setText("jCheckBox12");

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel80Layout.createSequentialGroup()
                        .addComponent(jLabel159)
                        .addContainerGap())
                    .addGroup(jPanel80Layout.createSequentialGroup()
                        .addComponent(jLabel132)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel80Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel160, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel80Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel132))
                    .addComponent(jCheckBox12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel159)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel160, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel81.setBackground(new java.awt.Color(255, 255, 255));

        jLabel165.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel166.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel166.setText("jLabel82");

        jLabel133.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel133.setText("     14");

        jCheckBox11.setText("jCheckBox11");

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel133)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel81Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel165)
                .addContainerGap())
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel81Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel133))
                    .addGroup(jPanel81Layout.createSequentialGroup()
                        .addComponent(jCheckBox11)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel165)
                .addGap(1, 1, 1)
                .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel82.setBackground(new java.awt.Color(255, 255, 255));
        jPanel82.setPreferredSize(new java.awt.Dimension(159, 245));

        jLabel171.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel172.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel172.setText("jLabel82");

        jLabel126.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel126.setText("     16");

        jCheckBox19.setText("jCheckBox19");

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel82Layout.createSequentialGroup()
                        .addComponent(jLabel171)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel82Layout.createSequentialGroup()
                        .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel82Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel126)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel82Layout.setVerticalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox19)
                    .addGroup(jPanel82Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel126)))
                .addGap(13, 13, 13)
                .addComponent(jLabel171)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel83.setBackground(new java.awt.Color(255, 255, 255));
        jPanel83.setPreferredSize(new java.awt.Dimension(159, 245));

        jLabel177.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel178.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel178.setText("jLabel82");

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel127.setText("    17");

        jCheckBox18.setText("jCheckBox18");

        javax.swing.GroupLayout jPanel83Layout = new javax.swing.GroupLayout(jPanel83);
        jPanel83.setLayout(jPanel83Layout);
        jPanel83Layout.setHorizontalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel127)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel83Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel83Layout.createSequentialGroup()
                        .addComponent(jLabel178, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel83Layout.createSequentialGroup()
                        .addComponent(jLabel177)
                        .addContainerGap())))
        );
        jPanel83Layout.setVerticalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel83Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel127))
                    .addGroup(jPanel83Layout.createSequentialGroup()
                        .addComponent(jCheckBox18)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel177)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel178, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel84.setBackground(new java.awt.Color(255, 255, 255));
        jPanel84.setPreferredSize(new java.awt.Dimension(159, 245));

        jLabel183.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restaurant tables.png"))); // NOI18N

        jLabel184.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reserved.png"))); // NOI18N
        jLabel184.setText("jLabel82");

        jLabel128.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel128.setText("      18");

        jCheckBox20.setText("jCheckBox20");

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel84Layout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(jLabel183))
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel184, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel128)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel128))
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addComponent(jCheckBox20)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel183)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel184, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel229.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel229.setText("Date");

        jLabel189.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel189.setText("Hour:");

        jDateChooser2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jDateChooser2MouseReleased(evt);
            }
        });

        jLabel190.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel190.setText("Number of Persons:");

        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });
        jTextField25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField25KeyReleased(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jComboBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBox3MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox3MouseReleased(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton18.setText("Check Availability");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel191.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(255, 0, 51));
        jLabel191.setText("                  Available");

        jButton19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton19.setText("Book");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 0, 51));
        jLabel83.setText("*only numbers are allowed to this field");

        jLabel139.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(255, 0, 51));
        jLabel139.setText("*Please choose a valid date");

        jLabel143.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(255, 0, 51));
        jLabel143.setText("*please select a Hour");

        jLabel140.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(255, 0, 51));
        jLabel140.setText("*please fill all fields");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButton19)
                        .addGap(33, 33, 33)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel191, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel190, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel140, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel229, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField25))
                        .addGap(79, 79, 79)
                        .addComponent(jLabel189))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(146, 146, 146))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel189)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel229)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGap(2, 2, 2)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel139)
                    .addComponent(jLabel143))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel190)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel83)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel191)
                    .addComponent(jLabel140))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jButton19))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel79, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 126, 126)))
                .addComponent(jLabel209)
                .addContainerGap(3324, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel70, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel69, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jLabel209))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel75, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel74, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                .addComponent(jPanel77, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel73, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel80, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(831, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel15, "card4");

        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel218.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel218.setText("Total:");

        jLabel222.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel222.setText("Guest ID:");

        jTextField4.setEditable(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton10.setText("Update");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jTextField17.setEditable(false);

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel81.setText("Handeld Date:");

        jTextField16.setEditable(false);
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jLabel110.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel110.setText("Order ID:");

        jLabel119.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel119.setText("Order Date:");

        jLabel120.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel120.setText("Handeld Status:");

        jCheckBox2.setText("jCheckBox2");

        jTextField32.setEditable(false);

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton11.setText("Remove");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel149.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(255, 0, 51));
        jLabel149.setText("*select a valid date");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jButton10))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel120)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addComponent(jButton11))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel25Layout.createSequentialGroup()
                                    .addComponent(jLabel81)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel25Layout.createSequentialGroup()
                                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                                .addComponent(jLabel119)
                                                .addGap(18, 18, 18))
                                            .addGroup(jPanel25Layout.createSequentialGroup()
                                                .addComponent(jLabel218, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)))
                                        .addGroup(jPanel25Layout.createSequentialGroup()
                                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel110)
                                                .addComponent(jLabel222))
                                            .addGap(32, 32, 32)))
                                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel222)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel218)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel119)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel81)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel120)
                            .addComponent(jCheckBox2)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel149)))
                .addGap(14, 14, 14)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, ordersList, jTable5);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderid}"));
        columnBinding.setColumnName("Orderid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${guestid}"));
        columnBinding.setColumnName("Guestid");
        columnBinding.setColumnClass(restaurantManagementFunction.Restaurantuser.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${total}"));
        columnBinding.setColumnName("Total");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${handledstatus}"));
        columnBinding.setColumnName("Handledstatus");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${handleddate}"));
        columnBinding.setColumnName("Handleddate");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderdate}"));
        columnBinding.setColumnName("Orderdate");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jPanel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel85.setText("GuestID:");

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel86.setText("Total:");

        jLabel108.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel108.setText("Order Date:");

        jLabel109.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel109.setText("Handled date:");

        jTextField27.setEditable(false);

        jTextField28.setEditable(false);
        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField28ActionPerformed(evt);
            }
        });

        jTextField30.setEditable(false);
        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });

        jTextField31.setEditable(false);

        jLabel223.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel223.setText("Handled Status:");

        jCheckBox1.setText("jCheckBox1");
        jCheckBox1.setEnabled(false);

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton8.setText("Place Order");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel85)
                            .addComponent(jLabel86))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField27)
                            .addComponent(jTextField28)))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel108)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField30)))
                .addGap(61, 61, 61))
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel109)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel223)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jButton8)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel108)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel109)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel223)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(26, 26, 26))
        );

        jLabel144.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(255, 0, 51));
        jLabel144.setText("*Please select a row");

        jLabel146.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(255, 0, 51));
        jLabel146.setText("*please fill all fields");

        jLabel175.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel175.setText("Order Details");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel224))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(181, 181, 181)
                                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3449, Short.MAX_VALUE)
                .addComponent(jLabel221)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(694, 694, 694)
                .addComponent(jLabel175, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jLabel221)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel224)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel175, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel144)
                            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel146)
                .addGap(840, 840, 840))
        );

        jPanel5.add(jPanel19, "card5");

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, restaurantuserList, jTable4);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${guestid}"));
        columnBinding.setColumnName("Guestid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fullname}"));
        columnBinding.setColumnName("Fullname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nicpassport}"));
        columnBinding.setColumnName("Nic/pass.");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contactnumber}"));
        columnBinding.setColumnName("Contact");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${preference}"));
        columnBinding.setColumnName("Preference");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${rice}"));
        columnBinding.setColumnName("Rice");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${soup}"));
        columnBinding.setColumnName("Soup");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${noodles}"));
        columnBinding.setColumnName("Noodles");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${meatdishes}"));
        columnBinding.setColumnName("MeatD.");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${seafood}"));
        columnBinding.setColumnName("Seafood");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${beverages}"));
        columnBinding.setColumnName("Beverages");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vegetabledishes}"));
        columnBinding.setColumnName("Veg Dishes");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${puddings}"));
        columnBinding.setColumnName("Puddings");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${menus}"));
        columnBinding.setColumnName("Menus");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${other}"));
        columnBinding.setColumnName("Other");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane4.setViewportView(jTable4);

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel73.setText("Guest Id:");

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel74.setText("Full Name:");

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel79.setText("NIC/Passport:");

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel100.setText("Contact:");

        jTextField18.setEditable(false);
        jTextField18.setToolTipText("AutoGenerated");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.guestid}"), jTextField18, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fullname}"), jTextField19, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField19KeyReleased(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nicpassport}"), jTextField21, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField21KeyReleased(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.contactnumber}"), jTextField22, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField22KeyReleased(evt);
            }
        });

        jLabel113.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel113.setText("Email:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.email}"), jTextField23, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField23KeyReleased(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton13.setText("Add");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton14.setText("Update");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton15.setText("Delete");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel77.setText("Preference:");

        jTextField20.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, jTable4, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.preference}"), jTextField20, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton17.setText("Search");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        buttonGroup7.add(jRadioButton33);
        jRadioButton33.setText("jRadioButton33");

        buttonGroup7.add(jRadioButton34);
        jRadioButton34.setText("jRadioButton34");

        jLabel114.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel114.setText("Search by ID");

        jLabel115.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel115.setText("Search by Name");

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(255, 0, 51));
        jLabel116.setText("*Type something to search");

        jLabel203.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel203.setForeground(new java.awt.Color(255, 0, 51));
        jLabel203.setText("*Select a type to search");

        jLabel208.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel208.setForeground(new java.awt.Color(255, 0, 51));
        jLabel208.setText("*Please fill all the fields");

        jLabel214.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(255, 0, 51));
        jLabel214.setText("*Please enter a valid name");

        jLabel225.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(255, 0, 51));
        jLabel225.setText("*Please enter a valid NIC/Passport number");

        jLabel226.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel226.setForeground(new java.awt.Color(255, 0, 51));
        jLabel226.setText("*Please enter a valid contact number");

        jLabel227.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel227.setForeground(new java.awt.Color(255, 0, 51));
        jLabel227.setText("*Please enter a valid Email");

        jLabel228.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel228.setForeground(new java.awt.Color(255, 0, 51));
        jLabel228.setText("*Please select a row from the table to update");

        jLabel150.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(255, 0, 51));
        jLabel150.setText("*NIC/Passport NO already exsists");

        jLabel176.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel176.setText("Customer Details");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel114)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel115)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel116)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel203))))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel208, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel214, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel73)
                                    .addComponent(jLabel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField18)
                                    .addComponent(jTextField19)
                                    .addComponent(jTextField23, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                                .addGap(137, 137, 137)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel226, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                                            .addGroup(jPanel20Layout.createSequentialGroup()
                                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel225, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addComponent(jLabel77)
                                        .addGap(37, 37, 37)
                                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addGap(104, 104, 104)
                                        .addComponent(jLabel150, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jLabel227, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1613, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel228, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3216, 3216, 3216))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(571, 571, 571)
                .addComponent(jLabel176, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel176)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17)
                    .addComponent(jLabel203))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel116)
                .addGap(2, 2, 2)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(jRadioButton33)
                    .addComponent(jLabel115)
                    .addComponent(jRadioButton34))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel228)
                .addGap(16, 16, 16)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel225, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)
                    .addComponent(jLabel100)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel214)
                    .addComponent(jLabel226))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel227)
                    .addComponent(jLabel150))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel208, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jButton14)
                    .addComponent(jButton15))
                .addContainerGap(754, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel20, "card6");

        jPanel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTable6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, ordersList1, jTable6);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderid}"));
        columnBinding.setColumnName("Orderid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${guestid}"));
        columnBinding.setColumnName("Guestid");
        columnBinding.setColumnClass(restaurantManagementFunction.Restaurantuser.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${handledstatus}"));
        columnBinding.setColumnName("Handledstatus");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderdate}"));
        columnBinding.setColumnName("Orderdate");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${handleddate}"));
        columnBinding.setColumnName("Handleddate");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${total}"));
        columnBinding.setColumnName("Total");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane6.setViewportView(jTable6);

        jLabel156.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel156.setText("Order Details Report");

        jLabel157.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel157.setText("From");

        jLabel158.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel158.setText("To");

        jLabel161.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel161.setText("Unhandled orders:");

        jLabel162.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel162.setText("Pending Income:");

        jLabel163.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel163.setText("No of Orders: ");

        jTextField36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField36ActionPerformed(evt);
            }
        });

        jLabel164.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel164.setText("Income:");

        jButton20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton20.setText("Generate Report");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton21.setText("Income Chart");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(522, 522, 522)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addComponent(jLabel163)
                                    .addGap(38, 38, 38)
                                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel162, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel158)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel164, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel161)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(500, 500, 500)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(586, 586, 586)
                        .addComponent(jButton20)
                        .addGap(152, 152, 152)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(605, 605, 605)
                        .addComponent(jLabel156, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(764, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel156)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel158, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel157, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(32, 32, 32)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel163)
                    .addComponent(jLabel161)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel164)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel162)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20)
                    .addComponent(jButton21))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(3099, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(940, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel22, "card7");

        jPanel30.setLayout(new java.awt.BorderLayout());
        jPanel5.add(jPanel30, "card8");

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resItemsSearch();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTable1.getSelectedRow() < 0) {
//            JOptionPane.showMessageDialog(this, "Please select a row", "Error", JOptionPane.ERROR_MESSAGE);
            jLabel138.setText("*Please select a row");
        }
        else{
            jLabel138.setText("                                                  ");
        }
        if ((jTextField2.getText().isEmpty()) || (jTextField3.getText().isEmpty()) || (jTextField5.getText().isEmpty())) {
           jLabel138.setText("*Please select a row");
        }

        if ((jTable1.getSelectedRow() >= 0) && !(jTextField2.getText().isEmpty()) && !(jTextField3.getText().isEmpty()) && !(jTextField5.getText().isEmpty())) {
            try {
               jLabel138.setText("                                                  ");
                TableModel model = jTable1.getModel();
                int selectedRowNo = jTable1.getSelectedRow();
                  String sql22 = "DELETE FROM resItem_Orders WHERE ItemId=?";
                PreparedStatement statement22 = connection.prepareStatement(sql22);
                statement22.setInt(1, Integer.parseInt((model.getValueAt(selectedRowNo, 0).toString())));
                statement22.executeUpdate();
                  String sql = "DELETE FROM resItem WHERE ItemId=?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt((model.getValueAt(selectedRowNo, 0).toString())));
                statement.executeUpdate();
              
                String sql1 = "SELECT * FROM ResItem";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                //statement1.executeUpdate();
                ResultSet rs = statement1.executeQuery();
                resitemList.clear();

                while (rs.next()) {
                    Resitem resItem = new Resitem();
                    resItem.setItemid(rs.getInt(1));
                    resItem.setCategory(rs.getString(2));
                    resItem.setItemname(rs.getString(3));
                    resItem.setPrice(rs.getDouble(4));
                    resItem.setQtyonhand(rs.getInt(5));
                    resitemList.add(resItem);
                }

                refreshTable(resitemList);
                new JToast().makeToast(this, "Deleted Succesfully", 1, JToast.type_of_succes);

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTable1.getSelectedRow() < 0) {
            //JOptionPane.showMessageDialog(this, "Please select a row", "Error", JOptionPane.ERROR_MESSAGE);
            jLabel138.setText("Please select a row");
        }
        else{
            jLabel138.setText("                                                  ");
        }
        if ((jTextField2.getText().isEmpty()) || (jTextField3.getText().isEmpty()) || (jTextField5.getText().isEmpty())) {
            jLabel76.setText("*Please fill all the fields");
        }
        if ((jTable1.getSelectedRow() >= 0) && !(jTextField2.getText().isEmpty()) && !(jTextField3.getText().isEmpty()) && !(jTextField5.getText().isEmpty())&& validation20 && validation21  && !(validation23) ){
            try {
                jLabel76.setText("                      ");
                
                TableModel model = jTable1.getModel();
                int selectedRowNo = jTable1.getSelectedRow();
                String sql = "UPDATE resItem SET Category=?,ItemName=?,Price=?,QtyOnHand=? WHERE ItemId=?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, jComboBox1.getSelectedItem().toString());
                statement.setString(2, jTextField2.getText());
                statement.setDouble(3, Double.parseDouble(jTextField3.getText()));
                statement.setInt(4, Integer.parseInt(jTextField5.getText()));
                statement.setInt(5, Integer.parseInt((model.getValueAt(selectedRowNo, 0).toString())));
                statement.executeUpdate();
                String sql1 = "SELECT * FROM ResItem";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                //statement1.executeUpdate();
                ResultSet rs = statement1.executeQuery();
                resitemList.clear();

                while (rs.next()) {
                    Resitem resItem = new Resitem();
                    resItem.setItemid(rs.getInt(1));
                    resItem.setCategory(rs.getString(2));
                    resItem.setItemname(rs.getString(3));
                    resItem.setPrice(rs.getDouble(4));
                    resItem.setQtyonhand(rs.getInt(5));
                    resitemList.add(resItem);
                }

                refreshTable(resitemList);
                new JToast().makeToast(this, "Updated Succesfully", 1, JToast.type_of_succes);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jLabel38.setText("                                                  ");
        jLabel80.setText("                                                  ");
        jLabel137.setText("                                                  ");
        jLabel76.setText("                                                  ");        
            
        TableModel model = jTable1.getModel();
        int selectedRowNo = jTable1.getSelectedRow();
        for (int i = 0; i < 10; i++) {
            if (comboList.get(i).equals((model.getValueAt(selectedRowNo, 3).toString()))) {
                comboList.set(i, comboList.get(0));
                comboList.set(0, model.getValueAt(selectedRowNo, 3).toString());

                jComboBox1.removeAllItems();
                jComboBox1.addItem(comboList.get(0));
                jComboBox1.addItem(comboList.get(1));
                jComboBox1.addItem(comboList.get(2));
                jComboBox1.addItem(comboList.get(3));
                jComboBox1.addItem(comboList.get(4));
                jComboBox1.addItem(comboList.get(5));
                jComboBox1.addItem(comboList.get(6));
                jComboBox1.addItem(comboList.get(7));
                jComboBox1.addItem(comboList.get(8));
                jComboBox1.addItem(comboList.get(9));

            }
        }
        //jComboBox1.addItem(model.getValueAt(selectedRowNo,3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jRadioButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton29ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        jTable1.getSelectedRow();

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        boolean sameItem = false;
        boolean invalidQuantity = false;
        boolean emptyFields = false;

        if (jTextField9.getText().isEmpty() || jTextField6.getText().isEmpty() || jTextField15.getText().isEmpty() || jTextField12.getText().isEmpty() || jTextField14.getText().isEmpty()) {
            emptyFields = true;
            jLabel78.setText("*Please fill all the fields");

        }
        if (emptyFields == false) {
            try {
                if (model2.getRowCount() > 0) {
                    System.out.println("AWAAAA");
                    for (int i = 0; i < model2.getRowCount(); i++) {
                        System.out.println("1");
                        if ((model2.getValueAt(i, 1)).equals(jTextField9.getText())) {
                            JOptionPane.showMessageDialog(this, "Avoid adding the same item again", "Error", JOptionPane.ERROR_MESSAGE);
                            System.out.println("2");
                            sameItem = true;
                            System.out.println("3");
                        }
                    }
                    System.out.println("4");
                    if (sameItem) {
                        System.out.println("5");
                        JOptionPane.showMessageDialog(this, "Avoid adding the same item again", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } catch (Exception e) {
                        
            }

        }
        if ((emptyFields == false)) {
            try{
            if (Integer.parseInt(jTextField12.getText()) < Integer.parseInt(jTextField14.getText())) {
                JOptionPane.showMessageDialog(this, "Qty on Hand is not sufficent", "Error", JOptionPane.ERROR_MESSAGE);
                invalidQuantity = true;
            }
            }catch(NumberFormatException e){
                jLabel151.setText("*only allowed numbers");
            }

        }
        if ((invalidQuantity == false) && (sameItem == false) && (emptyFields == false) && validation30) {
            try {

                jLabel78.setText("                                                  ");

                DecimalFormat formatter = new DecimalFormat("0.00");
                double total = (Integer.parseInt(jTextField14.getText())) * (Double.parseDouble(jTextField15.getText()));

                model2.insertRow(row, new Object[]{Integer.parseInt(jTextField26.getText()), jTextField9.getText(), jTextField6.getText(), Integer.parseInt(jTextField14.getText()), formatter.format(Double.parseDouble(jTextField15.getText())), formatter.format(total).toString()});

                row++;

                jTable2.setModel(model2);
            
            
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       calculatingTotalBill();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int row = 0;
        boolean validity = false;
        try {
            if (!(jTextField9.getText().isEmpty())) {
                for (row = 0; row < model.getRowCount(); row++) {
                    if (model.getValueAt(row, 1).equals(jTextField9.getText())) {
                        validity = true;
                        break;
                    }
                }

            }
        } catch (Exception e) {

        }
        if (validity == false) {
            JOptionPane.showMessageDialog(this, "Please select an exsisiting item to delete", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            model.removeRow(row);
            this.row--;
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            long millis=System.currentTimeMillis();
            java.util.Date currentDate=new java.util.Date(millis);
            boolean validation29 =true;
            boolean validation30 =true;
            if(jDateChooser3.getDate() == null){
                jLabel146.setText("*Please fill all fields");
                validation29 =false;
            }
            else{
                jLabel146.setText("                        ");
            }
            if(validation29){
            if(jDateChooser3.getDate().compareTo(currentDate) <0){
                validation30=false;
                jLabel149.setText("*Select a valid date");
                
            }
            else{
                jLabel149.setText("                     ");
                
            }
            }
            if(validation29 && validation30){
                 jLabel146.setText("                        ");
                 jLabel149.setText("                     ");

//            jLabel76.setVisible(false);
            TableModel model = jTable5.getModel();
            int selectedRowNo = jTable5.getSelectedRow();
            String sql = "UPDATE orders SET HandledStatus=?,HandledDate=? WHERE orderId=?";
            System.out.println("1");
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println("2");
            if (jCheckBox2.isSelected()) {
                statement.setBoolean(1, true);
            } else {
                statement.setBoolean(1, false);
            }
            //statement.setBoolean(1,Boolean.parseBoolean(jTextField17.getText().toString()));
            java.sql.Date d1 = null;
            java.util.Date date1 = jDateChooser3.getDate();
            if (date1 == null) {
                System.out.println("No date specified!");
            } else {
                d1 = new java.sql.Date(date1.getTime());
                // Do something with sqldate
            }
            statement.setDate(2, d1);
            statement.setInt(3, Integer.parseInt(jTextField4.getText()));
            System.out.println("3");
//        statement.setInt(4,Integer.parseInt(jTextField5.getText()));
//        statement.setInt(5,Integer.parseInt((model.getValueAt(selectedRowNo,0).toString())));
            statement.executeUpdate();
            System.out.println("4");
//          statement.executeUpdate();
            String sql1 = "SELECT * FROM Orders";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            //statement1.executeUpdate();
                ResultSet rs = statement1.executeQuery();
                ordersList.clear();
                
                while(rs.next()){
                   
                   Orders order = new Orders();
                    order.setOrderid(rs.getInt(1));
                    order.setTotal(rs.getDouble(2));
                    order.setOrderdate(rs.getDate(3));
                    order.setHandledstatus(rs.getBoolean(4));
                    order.setHandleddate(rs.getDate(5));
                    Restaurantuser user = new Restaurantuser();
                   user.setGuestid(rs.getInt(6));
                    order.setGuestid(user);
                   
                        
                       ordersList.add(order);
                    
                
                }
                
                refreshTable3(ordersList);
                 new JToast().makeToast(this, "Updated Succesfully", 1, JToast.type_of_succes);
                
        }
//        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            boolean error = false;
            boolean emptyFields = false;
            validation23 = false;
            jLabel138.setText("                                                  ");
//            String sql3 = "SELECT ItemName FROM resITEM";
//            PreparedStatement statement2 = connection.prepareStatement(sql3);
//            ResultSet rs1 = statement2.executeQuery();
//            while (rs1.next()) {
                if (jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty() || jTextField5.getText().isEmpty()) {
                    validation23 = true;
                }
//                } else if ((rs1.getString(1).replaceAll(" ", "").equalsIgnoreCase(jTextField2.getText().replaceAll(" ", "")))) {
//                    error = true;
//                }
              resItemValidity();
           // }
            if(validation23){
               jLabel76.setText("*Please fill all the fields"); 
            }

//            if (error && emptyFields) {
//                jLabel38.setText("*Item name already exsists");
//                jLabel76.setText("*Please fill all the fields");
//            } else if (error) {
//                jLabel38.setText("*Item name already exsists");
//                jLabel76.setText("                                                  ");
//
//            } else if (emptyFields) {
//                jLabel76.setText("*Please fill all the fields");
//                jLabel38.setText("                                                  ");
             else if (validation20 && validation21 && !(validation22) && !(validation23)) {
//                jLabel38.setVisible(false);
                jLabel38.setText("                                                  ");
                jLabel76.setText("                                                  ");
                jLabel80.setText("                                                  ");
                jLabel137.setText("                                                 ");

                String sql = "INSERT INTO ResItem(Category,ItemName,Price,QtyonHand)VALUES(?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, jComboBox1.getSelectedItem().toString());
                statement.setString(2, jTextField2.getText());
                statement.setDouble(3, Double.parseDouble(jTextField3.getText()));
                statement.setInt(4, Integer.parseInt(jTextField5.getText()));

                statement.executeUpdate();
                String sql1 = "SELECT * FROM ResItem";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                //statement1.executeUpdate();
                ResultSet rs = statement1.executeQuery();
                resitemList.clear();

                while (rs.next()) {
                    Resitem resItem = new Resitem();
                    resItem.setItemid(rs.getInt(1));
                    resItem.setCategory(rs.getString(2));
                    resItem.setItemname(rs.getString(3));
                    resItem.setPrice(rs.getDouble(4));
                    resItem.setQtyonhand(rs.getInt(5));
                    resitemList.add(resItem);
                }

                refreshTable(resitemList);
                new JToast().makeToast(this, "Inserted Succesfully", 1, JToast.type_of_succes);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Please insert only relevant value types for Qty On Hand and Item Price fields", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton30ActionPerformed

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        resetFields();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        boolean Selected = true;
        boolean validSearch1 = true;
        boolean validSearch2 = true;
        boolean validSearch3 = true;
        boolean validSearch4 = true;
        boolean validSearch5 = true;
        if ((buttonGroup4.getSelection() == null) && (buttonGroup5.getSelection() == null) && (buttonGroup6.getSelection() == null)) {
            jLabel99.setText("*Please Select a Type to search");
            Selected = false;
        }
        if (buttonGroup4.getSelection() != null) {
            if ((buttonGroup4.getSelection() != null) && (buttonGroup6.getSelection() != null)) {
                JOptionPane.showMessageDialog(this, "You can't use Advanced search and normal search both at once", "Error", JOptionPane.ERROR_MESSAGE);
                validSearch3 = false;
            } else if (buttonGroup5.getSelection() != null) {
                JOptionPane.showMessageDialog(this, "You can't use Advanced search and normal search both at once", "Error", JOptionPane.ERROR_MESSAGE);
                validSearch1 = false;

            } else if (buttonGroup6.getSelection() != null) {

                JOptionPane.showMessageDialog(this, "You can't use Advanced search and normal search both at once", "Error", JOptionPane.ERROR_MESSAGE);

                validSearch2 = false;
            }
        }

        if ((buttonGroup4.getSelection() != null) && jTextField7.getText().isEmpty()) {

            jLabel47.setText("*Type something to search");
            validSearch5 =false;
        }
        if (!(jRadioButton5.isSelected() || jRadioButton32.isSelected())) {
            validSearch4 = false;
            jLabel99.setText("*Please Select a Type to search");
        }
//if((jRadioButton30.isSelected() || jRadioButton31.isSelected()||jRadioButton1.isSelected()||)&&!(jTextField1.getText().isEmpty())){
//if((buttonGroup1.getSelection() ==null ^ buttonGroup3.getSelection()!=null) ||(buttonGroup1.getSelection() != null ^ buttonGroup2.getSelection()!=null)){
//    JOptionPane.showMessageDialog(this, "You can't use Advanced search and normal search both at once", "Error", JOptionPane.ERROR_MESSAGE);
//}    

        if (Selected && validSearch1 && validSearch2 && validSearch3 && validSearch5) {
            jLabel47.setText("                                                  ");
            jLabel99.setText("                                                  ");
            try {
                String sql = null;
                if (jRadioButton15.isSelected() && jRadioButton20.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Rice'";
                    System.out.println("Executed1");
                } else if (jRadioButton15.isSelected() && jRadioButton21.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Soup'";

                } else if (jRadioButton15.isSelected() && jRadioButton22.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Noodles'";

                } else if (jRadioButton15.isSelected() && jRadioButton23.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Meat Dish'";

                } else if (jRadioButton15.isSelected() && jRadioButton24.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Sea food'";

                } else if (jRadioButton15.isSelected() && jRadioButton25.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Beverages'";

                } else if (jRadioButton15.isSelected() && jRadioButton26.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Vegetable Dish'";

                } else if (jRadioButton15.isSelected() && jRadioButton27.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Puddings'";

                } else if (jRadioButton15.isSelected() && jRadioButton28.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Menus'";

                } else if (jRadioButton15.isSelected() && jRadioButton19.isSelected()) {

                    //String val2="Rice";
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 100 AND 2000 AND category='Other'";

                } else if (jRadioButton16.isSelected() && jRadioButton20.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Rice'";
                } else if (jRadioButton16.isSelected() && jRadioButton21.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Soup'";
                } else if (jRadioButton16.isSelected() && jRadioButton22.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Noodles'";
                } else if (jRadioButton16.isSelected() && jRadioButton23.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Meat Dish'";
                } else if (jRadioButton16.isSelected() && jRadioButton26.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Vegetable Dish'";
                } else if (jRadioButton16.isSelected() && jRadioButton27.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Puddings'";
                } else if (jRadioButton16.isSelected() && jRadioButton28.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Menus'";
                } else if (jRadioButton16.isSelected() && jRadioButton19.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 2000 AND 4000 AND category='Other'";
                } else if (jRadioButton16.isSelected() && jRadioButton20.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Rice'";
                } else if (jRadioButton17.isSelected() && jRadioButton21.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Soup'";
                } else if (jRadioButton17.isSelected() && jRadioButton22.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Noodles'";
                } else if (jRadioButton17.isSelected() && jRadioButton23.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Meat Dish'";
                } else if (jRadioButton17.isSelected() && jRadioButton24.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Sea food'";
                } else if (jRadioButton17.isSelected() && jRadioButton25.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Beverages'";
                } else if (jRadioButton17.isSelected() && jRadioButton26.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Vegetable Dish'";
                } else if (jRadioButton17.isSelected() && jRadioButton27.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Puddings'";
                } else if (jRadioButton17.isSelected() && jRadioButton28.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Menus'";
                } else if (jRadioButton17.isSelected() && jRadioButton19.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price BETWEEN 4000 AND 7500 AND category='Other'";
                } else if (jRadioButton18.isSelected() && jRadioButton20.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Rice'";
                } else if (jRadioButton18.isSelected() && jRadioButton21.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Soup'";
                } else if (jRadioButton18.isSelected() && jRadioButton22.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Noodles'";
                } else if (jRadioButton18.isSelected() && jRadioButton23.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Meat Dish'";
                } else if (jRadioButton18.isSelected() && jRadioButton24.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Sea food'";
                } else if (jRadioButton18.isSelected() && jRadioButton25.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Beverages'";
                } else if (jRadioButton18.isSelected() && jRadioButton26.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Vegetable Dish'";
                } else if (jRadioButton18.isSelected() && jRadioButton27.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Puddings'";
                } else if (jRadioButton18.isSelected() && jRadioButton28.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Menus'";
                } else if (jRadioButton18.isSelected() && jRadioButton19.isSelected()) {
                    sql = "SELECT * FROM resItem WHERE price>7500 AND category='Other'";
                } else if (jRadioButton15.isSelected()) {

                    sql = "Select * FROM resItem WHERE price between 100 AND 2000";

                } else if (jRadioButton16.isSelected()) {

                    sql = "Select * FROM resItem WHERE price between 2000 AND 4000";

                } else if (jRadioButton17.isSelected()) {

                    sql = "Select * FROM resItem WHERE price between 4000 AND 7500";

                } else if (jRadioButton18.isSelected()) {

                    sql = "Select * FROM resItem WHERE price>7500";

                } else if (jRadioButton20.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Rice'";;

                } else if (jRadioButton21.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Soup'";;

                } else if (jRadioButton22.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Noodles'";;

                } else if (jRadioButton23.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Meat Dish'";;

                } else if (jRadioButton24.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Sea food'";;

                } else if (jRadioButton25.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Beverages'";;

                } else if (jRadioButton26.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Vegetable Dish'";;

                } else if (jRadioButton27.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Puddings'";;

                } else if (jRadioButton28.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Menus'";;

                } else if (jRadioButton19.isSelected()) {

                    sql = "Select * FROM resItem WHERE category='Other'";;

                } else if (jRadioButton5.isSelected() && !(jTextField7.getText().isEmpty())) {
                    sql = "SELECT * FROM resItem WHERE ItemId=" + Integer.parseInt(jTextField7.getText()) + "";
                } else if (jRadioButton32.isSelected() && !(jTextField7.getText().isEmpty())) {
                    sql = "SELECT * FROM resItem WHERE ItemName='" + jTextField7.getText() + "'";
                }
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                resitemList1.clear();
                while (rs.next()) {
                    Resitem resItem = new Resitem();
                    resItem.setItemid(rs.getInt(1));
                    resItem.setCategory(rs.getString(2));
                    resItem.setItemname(rs.getString(3));
                    resItem.setPrice(rs.getDouble(4));
                    resItem.setQtyonhand(rs.getInt(5));
                    resitemList1.add(resItem);

                }
                refreshTable1(resitemList1);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("only numbers Allowed");
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jRadioButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton19ActionPerformed

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        ViewPanel("card3");
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        //ViewPanelSearch();
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        if (!(jTextField10.getText().isEmpty())) {
            boolean resultSet = false;
            try {
                String sql = "SELECT FullName,Preference,guestID FROM RestaurantUser WHERE NicPassport='" + jTextField10.getText() + "'";
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
//        if(rs == null){
//            jTextField11.setText("hasi ");
//            jTextField13.setText(" ");
//        }
//            if (!rs.isBeforeFirst() ) {    
//    System.out.println("No data"); 
//} 
                if (resultSet == false) {
                    jTextField11.setText(" ");
                    jTextField13.setText(" ");
                    jTextField29.setText(" ");
                    if (!(jTextField10.getText().isEmpty())) {
                        jLabel89.setText("*Not a previous Customer");
                    }
                }
                while (rs.next()) {
                    resultSet = true;
                    jTextField11.setText(rs.getString(1));
                    jTextField13.setText(rs.getString(2));
                    Integer i = rs.getInt(3);
                    jTextField29.setText(i.toString());
                    jLabel89.setText("                                                  ");

                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            jTextField11.setText(" ");
            jTextField13.setText(" ");
            jTextField29.setText(" ");
            jLabel89.setText(" ");
        }

    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int row = 0;
        boolean validity = false;
        try {
            if (!(jTextField9.getText().isEmpty())) {
                for (row = 0; row < model.getRowCount(); row++) {
                    if (model.getValueAt(row, 1).equals(jTextField9.getText())) {
                        validity = true;
                        break;
                    }
                }

            }
        } catch (Exception e) {

        }
        if (validity == false) {
            JOptionPane.showMessageDialog(this, "Please select an exsisiting item to update", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            if (!(jTextField14.getText().isEmpty())) {
                if (Integer.parseInt(jTextField12.getText()) < Integer.parseInt(jTextField14.getText())) {
                    JOptionPane.showMessageDialog(this, "Qty on Hand is not sufficent", "Error", JOptionPane.ERROR_MESSAGE);

                } else {

                    DecimalFormat formatter = new DecimalFormat("0.00");
                    Double newTotal = (Double.parseDouble(jTextField15.getText())) * (Integer.parseInt(jTextField14.getText()));
                    model.setValueAt(jTextField14.getText(), row, 3);
                    model.setValueAt(Double.parseDouble(formatter.format(newTotal)), row, 5);
                }

            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        TableModel model = jTable2.getModel();
        int selectedRowNo = jTable2.getSelectedRow();
        jTextField26.setText(model.getValueAt(selectedRowNo, 0).toString());
        jTextField9.setText(model.getValueAt(selectedRowNo, 1).toString());
        jTextField6.setText(model.getValueAt(selectedRowNo, 2).toString());
        jTextField15.setText(model.getValueAt(selectedRowNo, 4).toString());
        jTextField14.setText(model.getValueAt(selectedRowNo, 3).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
            boolean validation5 =true;
       
             try{
             if(!(jTextField21.getText().isEmpty())) {   
             String sql = "SELECT * FROM RESTAURANTUSER WHERE NICPASSPORT=?";
             PreparedStatement statement = connection.prepareStatement(sql);
             statement.setString(1,jTextField21.getText());
             ResultSet rs =statement.executeQuery();
             int count =0;
             while(rs.next()){
                 count++;
             }
             if(count > 0){
                validation5 =false; 
                jLabel150.setText("*NIC/Passport NO already exsists");
             }
             else{
                  jLabel150.setText("                               ");
             }
             }
           
            
            if (restaurantUserValidation() && validation5) {
                jLabel214.setText("                          ");
                jLabel225.setText("                                                     ");
                jLabel226.setText("                                                     ");
                jLabel227.setText("                          ");
                jLabel208.setText("                                                     ");

                String sql = "INSERT INTO RestaurantUser(NicPassport,Email,ContactNumber,FullName)VALUES(?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, jTextField21.getText());
                statement.setString(2, jTextField23.getText());
                statement.setString(3, jTextField22.getText());
                statement.setString(4, jTextField19.getText());

                statement.executeUpdate();
                String sql1 = "SELECT * FROM RestaurantUser";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                //statement1.executeUpdate();
                ResultSet rs = statement1.executeQuery();
                restaurantuserList.clear();

                while (rs.next()) {
                    Restaurantuser resUser = new Restaurantuser();
                    resUser.setGuestid(rs.getInt(1));
                    resUser.setNicpassport(rs.getString(2));
                    resUser.setEmail(rs.getString(3));
                    resUser.setContactnumber(rs.getString(4));
                    resUser.setFullname(rs.getString(5));
                    resUser.setRice(rs.getInt(6));
                    resUser.setSoup(rs.getInt(7));
                    resUser.setNoodles(rs.getInt(8));
                    resUser.setMeatdishes(rs.getInt(9));
                    resUser.setSeafood(rs.getInt(10));
                    resUser.setBeverages(rs.getInt(11));
                    resUser.setVegetabledishes(rs.getInt(12));
                    resUser.setPuddings(rs.getInt(13));
                    resUser.setMenus(rs.getInt(14));
                    resUser.setOther(rs.getInt(15));
                    resUser.setPreference(rs.getString(16));

                    restaurantuserList.add(resUser);

                }

                refreshTable2(restaurantuserList);
                customerDetailsTablePosition();
                new JToast().makeToast(this, "Inserted Succesfully", 1, JToast.type_of_succes);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Please insert only relevant value types for Qty On Hand and Item Price fields", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        calculatingTotalBill();
        if (!(jTextField29.getText().isEmpty())) {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                
            if (model.getRowCount()>0) {
              
                
                
                jTextField27.setText(jTextField29.getText());
                jTextField28.setText(jTextField8.getText());
                Date date = new Date();
                SimpleDateFormat d1 = new SimpleDateFormat("dd/MM/yyy");
                jTextField30.setText(d1.format(date));
                if (jCheckBox3.isSelected()) {
                    jTextField31.setText(d1.format(date));
                    jCheckBox1.setSelected(true);
                }
                else{
                     jTextField31.setText(" ");
                    jCheckBox1.setSelected(false);
                }
                try {

                    for (int i = 0; i < model.getRowCount(); i++) {
                        if (model.getValueAt(i, 1).equals("Rice")) {
                            riceCount++;
                        }
                        if (model.getValueAt(i, 1).equals("Soup")) {
                            soupCount++;
                        }
                        if (model.getValueAt(i, 1).equals("Noodles")) {
                            noodlesCount++;
                        }
                        if (model.getValueAt(i, 1).equals("Meat Dishes")) {
                            meatDishesCount++;
                        }
                        if (model.getValueAt(i, 1).equals("Sea Food")) {
                            seaFoodCount++;
                        }
                        if (model.getValueAt(i, 1).equals("Beverages")) {
                            beveragesCount++;
                        }
                        if (model.getValueAt(i, 1).equals("Vegetable Dishes")) {
                            vegetableDishesCount++;
                        }
                        if (model.getValueAt(i, 1).equals("Puddings")) {
                            puddingsCount++;
                        }
                        if (model.getValueAt(i, 1).equals("Menus")) {
                            menusCount++;
                        }
                        if (model.getValueAt(i, 1).equals("Other")) {
                            otherCount++;
                        }
                    }
                } catch (Exception e) {

                }
                ViewPanel("card5");
            } else {
                JOptionPane.showMessageDialog(this, "Please place an order", "Erro", 2);

            }
        } else {
            JOptionPane.showMessageDialog(this, "please select an exsisting customer", "Erro", 2);
        }
        //String path="";
      

    }//GEN-LAST:event_jButton16ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked
        ViewPanel("card6");
    }//GEN-LAST:event_jPanel18MouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (jTextField18.getText().isEmpty()) {
            jLabel228.setText("*Please select a row from the table to update");
        }
        try {

            if (restaurantUserValidation() && !(jTextField18.getText().isEmpty())) {
                jLabel214.setText("                          ");
                jLabel225.setText("                                                     ");
                jLabel226.setText("                                                     ");
                jLabel227.setText("                          ");
                jLabel208.setText("                                                     ");
                jLabel228.setText("                                                     ");

                String sql = "UPDATE restaurantUser SET NICPassport=?,Email=?,ContactNumber=?,FullName=? WHERE GuestId=?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, jTextField21.getText());
                statement.setString(2, jTextField23.getText());
                statement.setString(3, jTextField22.getText());
                statement.setString(4, jTextField19.getText());
                statement.setInt(5, Integer.parseInt(jTextField18.getText()));
                
                statement.executeUpdate();
                String sql1 = "SELECT * FROM restaurantUser";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                //statement1.executeUpdate();
                ResultSet rs = statement1.executeQuery();
                restaurantuserList.clear();

                while (rs.next()) {
                    Restaurantuser resUser = new Restaurantuser();
                    resUser.setGuestid(rs.getInt(1));
                    resUser.setNicpassport(rs.getString(2));
                    resUser.setEmail(rs.getString(3));
                    resUser.setContactnumber(rs.getString(4));
                    resUser.setFullname(rs.getString(5));
                    resUser.setRice(rs.getInt(6));
                    resUser.setSoup(rs.getInt(7));
                    resUser.setNoodles(rs.getInt(8));
                    resUser.setMeatdishes(rs.getInt(9));
                    resUser.setSeafood(rs.getInt(10));
                    resUser.setBeverages(rs.getInt(11));
                    resUser.setVegetabledishes(rs.getInt(12));
                    resUser.setPuddings(rs.getInt(13));
                    resUser.setMenus(rs.getInt(14));
                    resUser.setOther(rs.getInt(15));
                    resUser.setPreference(rs.getString(16));

                    restaurantuserList.add(resUser);

                }
                refreshTable2(restaurantuserList);
                customerDetailsTablePosition();
                new JToast().makeToast(this, "Updated Succesfully", 1, JToast.type_of_succes);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if (jTextField18.getText().isEmpty()) {
            jLabel228.setText("*Please select a row from the table to delete");
        }
        try {
            if (restaurantUserValidation() && !(jTextField18.getText().isEmpty())) {
                jLabel214.setText("                          ");
                jLabel225.setText("                                                     ");
                jLabel226.setText("                                                     ");
                jLabel227.setText("                          ");
                jLabel208.setText("                                                     ");
                jLabel228.setText("                                                     ");
               
                String sql4 = "SELECT orderID FROM ORDERS WHERE guestID=?";
                  
                PreparedStatement statement2= connection.prepareStatement(sql4);
                  statement2.setInt(1,Integer.parseInt(jTextField18.getText()));
                ResultSet rs44 = statement2.executeQuery();
                ArrayList<Integer> orderIDList = new ArrayList<Integer>();
                while(rs44.next()){
                   orderIDList.add(rs44.getInt(1));
                }
                for(int i = 0 ; i < orderIDList.size() ; i++){
                 String sql = "DELETE FROM BOOKEDTABLE WHERE orderID=?";
                  PreparedStatement statement33 = connection.prepareStatement(sql);
                  statement33.setInt(1,orderIDList.get(i));
                  statement33.executeUpdate();
                }
                 String sql3 = "DELETE FROM ORDERS WHERE guestId=?";
                 PreparedStatement statement100= connection.prepareStatement(sql3);
                 statement100.setInt(1,Integer.parseInt(jTextField18.getText()));
                 statement100.executeUpdate();
                
                int selectedRowNo = jTable1.getSelectedRow();
                String sql = "DELETE FROM restaurantUser WHERE guestId=?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt(jTextField18.getText()));
                statement.executeUpdate();
                String sql1 = "SELECT * FROM restaurantUser";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                //statement1.executeUpdate();
                ResultSet rs = statement1.executeQuery();
                restaurantuserList.clear();

                while (rs.next()) {
                    Restaurantuser resUser = new Restaurantuser();
                    resUser.setGuestid(rs.getInt(1));
                    resUser.setNicpassport(rs.getString(2));
                    resUser.setEmail(rs.getString(3));
                    resUser.setContactnumber(rs.getString(4));
                    resUser.setFullname(rs.getString(5));
                    resUser.setRice(rs.getInt(6));
                    resUser.setSoup(rs.getInt(7));
                    resUser.setNoodles(rs.getInt(8));
                    resUser.setMeatdishes(rs.getInt(9));
                    resUser.setSeafood(rs.getInt(10));
                    resUser.setBeverages(rs.getInt(11));
                    resUser.setVegetabledishes(rs.getInt(12));
                    resUser.setPuddings(rs.getInt(13));
                    resUser.setMenus(rs.getInt(14));
                    resUser.setOther(rs.getInt(15));
                    resUser.setPreference(rs.getString(16));

                    restaurantuserList.add(resUser);

                }
                refreshTable2(restaurantuserList);
                customerDetailsTablePosition();

                new JToast().makeToast(this, "Deleted Succesfully", 1, JToast.type_of_succes);

            }
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if (jTextField24.getText().isEmpty()) {
            jLabel203.setText("*Type something to search");
        }
        if ((buttonGroup7.getSelection() == null)) {
            jLabel116.setText("*Select a type to search");
        }
        if ((!(jTextField24.getText().isEmpty()) && buttonGroup7.getSelection() != null)) {
            try {
                String sql = null;
                if (jRadioButton33.isSelected()) {
                    sql = "SELECT * FROM restaurantUser WHERE guestId=" + Integer.parseInt(jTextField24.getText()) + "";

                } else if (jRadioButton34.isSelected()) {
                    sql = "SELECT * FROM restaurantUser WHERE fullName='" + (jTextField24.getText()) + "'";

                }

                PreparedStatement statement = connection.prepareStatement(sql);

                ResultSet rs = statement.executeQuery();
                restaurantuserList.clear();
                while (rs.next()) {
                    jLabel203.setText("                                                  ");
                    jLabel116.setText("                                                   ");
                    Restaurantuser resUser = new Restaurantuser();
                    resUser.setGuestid(rs.getInt(1));
                    resUser.setNicpassport(rs.getString(2));
                    resUser.setEmail(rs.getString(3));
                    resUser.setContactnumber(rs.getString(4));
                    resUser.setFullname(rs.getString(5));
                    resUser.setRice(rs.getInt(6));
                    resUser.setSoup(rs.getInt(7));
                    resUser.setNoodles(rs.getInt(8));
                    resUser.setMeatdishes(rs.getInt(9));
                    resUser.setSeafood(rs.getInt(10));
                    resUser.setBeverages(rs.getInt(11));
                    resUser.setVegetabledishes(rs.getInt(12));
                    resUser.setPuddings(rs.getInt(13));
                    resUser.setMenus(rs.getInt(14));
                    resUser.setOther(rs.getInt(15));
                    resUser.setPreference(rs.getString(16));

                    restaurantuserList.add(resUser);

                }
                refreshTable2(restaurantuserList);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "please enter a valid gusetId", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton10ActionPerformed

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        ViewPanel("card4");
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
     validation27 = true;
     boolean available = false;
     if(jTextField25.getText().isEmpty() || jDateChooser2.getDate() == null || jComboBox3.getSelectedIndex() == 0){
         validation27 = false;
         jLabel140.setText("*Please fill all fields");
     }
     else{
          jLabel140.setText("                       ");
     }
        validation26 = true;
        if(jComboBox3.getSelectedIndex()== 0){
          validation26 = false;
          jLabel143.setText("*Please select a hour");
      }
        else{
            jLabel143.setText("                       ");
        }
      
        validation24 = true;
        long millis=System.currentTimeMillis();
        java.util.Date currentDate=new java.util.Date(millis);
        try{
        if(jDateChooser2.getDate().compareTo(currentDate) <0){
            validation24 = false;
            System.out.println("came to date validation");
             jLabel139.setText("*Please select a valid date");
            
        }
        else{
              jLabel139.setText("                       ");
        }
        }
        catch(NullPointerException e){
            jLabel139.setText("*Please select a valid date");
            
        }
        
        if(validation24 && validation25 && validation26 && validation27){
        try {
             jLabel140.setText("                       ");
            jLabel143.setText("                       ");
            System.out.println("came");
           

            Date date = new Date();
            Timestamp ts = new Timestamp(jDateChooser2.getDate().getTime());
            System.out.println(ts);
            String time = jComboBox3.getSelectedItem().toString();
            Timestamp today= new Timestamp(date.getTime());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(jDateChooser2.getDate());
            calendar.set(Calendar.AM_PM, Calendar.AM);
            calendar.set(Calendar.HOUR, Integer.parseInt(time));
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date fDate = calendar.getTime();
            Timestamp fDateTime = new Timestamp(fDate.getTime());
            System.out.println(fDateTime);
            // jDateChooser1.getDate()
            String q = "Select r.tableNo FROM RESTABLES as R,BOOKEDTABLE as b WHERE r.restableId =b.restableId AND b.bookedDateTime <> '" + fDateTime + "'OR r.restableId NOT IN(SELECT restableId FROM BOOKEDTABLE)";

// String q ="Select r.tableNo FROM RESTABLES as R,BOOKEDTABLE as b WHERE r.restableId =b.tableId AND b.bookedDate <> '"+now+"'OR r.restableId NOT IN(SELECT tableId FROM BOOKEDTABLE)";
            //String q2="Select r.tableNo FROM RESTABLES as R WHERE r.restableId NOT IN(SELECT tableId FROM BOOKEDTABLE)";
            PreparedStatement pst = connection.prepareStatement(q);
            //PreparedStatement pst1 = con.prepareStatement(q2);
            ResultSet rs = pst.executeQuery();
            // int count =0;
            int count = 0;
            while (rs.next()) {
                int tableNo = (rs.getInt(1));
                if (tableNo == 1) {
                    System.out.println("awaaaa");
                    jLabel112.setVisible(false);
                    jCheckBox4.setVisible(true);
                    count++;
                }
                if (tableNo == 2) {
                    jLabel96.setVisible(false);
                    jCheckBox5.setVisible(true);
                    count++;
                }
                if (tableNo == 3) {
                    jLabel88.setVisible(false);
                     jCheckBox6.setVisible(true);
                    count++;
                }
                if (tableNo == 4) {
                    jLabel94.setVisible(false);
                     jCheckBox7.setVisible(true);
                    count++;
                }
                if (tableNo == 5) {
                    jLabel82.setVisible(false);
                     jCheckBox8.setVisible(true);
                    count++;
                }
                if (tableNo == 6) {
                    jLabel106.setVisible(false);
                     jCheckBox9.setVisible(true);
                    count++;
                }
                if (tableNo == 7) {
                    jLabel136.setVisible(false);
                     jCheckBox10.setVisible(true);
                    count++;
                }
                if (tableNo == 8) {
                    jLabel130.setVisible(false);
                     jCheckBox16.setVisible(true);
                    count++;
                }
                if (tableNo == 9) {
                    jLabel124.setVisible(false);
                     jCheckBox15.setVisible(true);
                    count++;
                }
                if (tableNo == 10) {
                    jLabel142.setVisible(false);
                     jCheckBox17.setVisible(true);
                    count++;
                }
                if (tableNo == 11) {
                    jLabel148.setVisible(false);
                     jCheckBox14.setVisible(true);
                    count++;
                }
                if (tableNo == 12) {
                    jLabel154.setVisible(false);
                     jCheckBox13.setVisible(true);
                    count++;
                }
                if (tableNo == 13) {
                    jLabel160.setVisible(false);
                     jCheckBox12.setVisible(true);
                    count++;
                }
                if (tableNo == 14) {
                    jLabel166.setVisible(false);
                     jCheckBox11.setVisible(true);
                    count++;
                }
                if (tableNo == 15) {
                    jLabel118.setVisible(false);
                     jCheckBox21.setVisible(true);
                    count++;
                }
                if (tableNo == 16) {
                    jLabel172.setVisible(false);
                     jCheckBox19.setVisible(true);
                    count++;
                }
                if (tableNo == 17) {
                    jLabel178.setVisible(false);
                     jCheckBox18.setVisible(true);
                    count++;
                }
                if (tableNo == 18) {
                    jLabel184.setVisible(false);
                     jCheckBox20.setVisible(true);
                    count++;
                }
                System.out.println("tableNo:" + tableNo);

            }
            try {
                if (!(jTextField25.getText().isEmpty())) {
                    if (Integer.parseInt(jTextField25.getText()) <= (count * 4)) {
                        jLabel191.setText("Available");
                        available =true;
                    } else {
                          jCheckBox4.setVisible(false);
        jCheckBox5.setVisible(false);
jCheckBox6.setVisible(false);
jCheckBox7.setVisible(false);
jCheckBox8.setVisible(false);
jCheckBox9.setVisible(false);
jCheckBox10.setVisible(false);
jCheckBox16.setVisible(false);
jCheckBox15.setVisible(false);
jCheckBox17.setVisible(false);
jCheckBox14.setVisible(false);
jCheckBox13.setVisible(false);
jCheckBox12.setVisible(false);
jCheckBox11.setVisible(false);
jCheckBox21.setVisible(false);
jCheckBox19.setVisible(false);
jCheckBox18.setVisible(false);
jCheckBox20.setVisible(false);
                        jLabel191.setText("Not available");
                         
                    }
                }
            } catch (NumberFormatException e) {
                jLabel83.setText("*only numbers are allowed to this field");
            }
            //ResultSet rs1 = pst1.executeQuery();
            // int count =0;

            // while(rs1.next()){
            //^System.out.println(rs1.getInt(1));
            // }
            //java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       }
        System.out.println("Successful");
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        if(jCheckBox4.isSelected() ||  jCheckBox5.isSelected() || jCheckBox6.isSelected() || jCheckBox7.isSelected() || jCheckBox8.isSelected()|| jCheckBox9.isSelected() || jCheckBox10.isSelected() || jCheckBox16.isSelected() || jCheckBox15.isSelected() || jCheckBox17.isSelected() || jCheckBox14.isSelected()|| jCheckBox13.isSelected()
                || jCheckBox12.isSelected() || jCheckBox11.isSelected() || jCheckBox21.isSelected() || jCheckBox19.isSelected() || jCheckBox18.isSelected() || jCheckBox20.isSelected()){
        try {
            Date date = new Date();
            Timestamp ts = new Timestamp(jDateChooser2.getDate().getTime());
            System.out.println(ts);
            String time = jComboBox3.getSelectedItem().toString();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(jDateChooser2.getDate());
            calendar.set(Calendar.AM_PM, Calendar.AM);
            calendar.set(Calendar.HOUR, Integer.parseInt(time));
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date today = calendar.getTime();
            Timestamp now = new Timestamp(today.getTime());
            String sql1 = "SELECT MAX(orderId) From Orders";
             
            
            
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            ResultSet rs = statement1.executeQuery();
            int orderId = 0;
            while(rs.next()){
               orderId= rs.getInt(1);
            }
             int rowCount =  jTable2.getRowCount();
           for(int i = 0; i< jTable2.getRowCount() ; i++){
              int itemId= Integer.parseInt(jTable2.getValueAt(i, 0).toString());
              String sql2 = "INSERT INTO RESITEM_ORDERS(ItemID,OrderID)VALUES(?,?)";
               PreparedStatement statement2 = connection.prepareStatement(sql2);
               statement2.setInt(1, itemId);
               statement2.setInt(2,orderId);
               statement2.executeUpdate();
              
           }
             new JToast().makeToast(this, "Booked Succesfully", 1, JToast.type_of_succes);
            
           
            if(jCheckBox4.isSelected()){
                tableBookingInsertion(1, orderId, now);
            }
             if(jCheckBox5.isSelected()){
                tableBookingInsertion(2, orderId, now);
            }
             if(jCheckBox6.isSelected()){
                tableBookingInsertion(3, orderId, now);
            }
              if(jCheckBox7.isSelected()){
                tableBookingInsertion(4, orderId, now);
            }
               if(jCheckBox8.isSelected()){
                tableBookingInsertion(5, orderId, now);
            }
                if(jCheckBox9.isSelected()){
                tableBookingInsertion(6, orderId, now);
            }
                 if(jCheckBox10.isSelected()){
                tableBookingInsertion(7, orderId, now);
            }
                       if(jCheckBox16.isSelected()){
                tableBookingInsertion(8, orderId, now);
            }
                   if(jCheckBox15.isSelected()){
                tableBookingInsertion(9, orderId, now);
            }          
                          if(jCheckBox17.isSelected()){
                tableBookingInsertion(10, orderId, now);
            }
                   if(jCheckBox14.isSelected()){
                tableBookingInsertion(11, orderId, now);
            }       
                        if(jCheckBox13.isSelected()){
                tableBookingInsertion(12, orderId, now);
            }    
                        if(jCheckBox12.isSelected()){
                tableBookingInsertion(13, orderId, now);
            }          
            
                        if(jCheckBox11.isSelected()){
                tableBookingInsertion(14, orderId, now);
            }   
                          if(jCheckBox21.isSelected()){
                tableBookingInsertion(15, orderId, now);
            }            if(jCheckBox19.isSelected()){
                tableBookingInsertion(16, orderId, now);
            }            if(jCheckBox18.isSelected()){
                tableBookingInsertion(17, orderId, now);
            }            if(jCheckBox20.isSelected()){
                tableBookingInsertion(18, orderId, now);
            } 
             String emailText1 = "Thank you your payment has been successfully received"; 
             String emailText2="OrderID :" + orderId;
             String emailText3 ="Total Payement: " + jTextField8.getText();
            String emailText4 ="Unhadled Payment";
            String emailText5="Unhadled Payement:   "+jTextField8.getText();
                refreshTable3(ordersList);
                new JToast().makeToast(this, "Inserted Succesfully", 1, JToast.type_of_succes);
                String sql50 = "SELECT EMAIL FROM RESTAURANTUSER WHERE GUESTID=?";
                PreparedStatement statement50 = connection.prepareStatement(sql50);
                statement50.setInt(1,Integer.parseInt(jTextField29.getText()));
                ResultSet rs50 = statement50.executeQuery();
                String userEmail = null;
                while(rs50.next()){
                   userEmail= rs50.getString(1);
                }
                System.out.println("This is email" +userEmail);
                
                if(jCheckBox1.isSelected()){
                EmailProcess m1=new EmailProcess(emailText1,emailText2,emailText3,userEmail);  
                Thread t1 =new Thread(m1);  
            t1.start();  
new JToast().makeToast(this, "Email sent Succesfully", 1, JToast.type_of_succes);
                }
                else{
                     EmailProcess m1=new EmailProcess(emailText4,emailText2,emailText5,userEmail);  
                Thread t1 =new Thread(m1);  
            t1.start();  
new JToast().makeToast(this, "Email sent Succesfully", 1, JToast.type_of_succes);
                }
            
            
//            
//            String path="";
//        JFileChooser j=new JFileChooser();
//        int x=j.showOpenDialog(this);
//        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        //int x=j.showOpenDialog(this);
//        
//        if(x==JFileChooser.APPROVE_OPTION){
//            
//            path=j.getSelectedFile().getPath();
//        }
//
//        Document doc=new Document();
//        
//        try{
//            
//            //PdfWriter.getInstance(doc,new FileOutputStream("C:\\Users\\kavee\\OneDrive\\Desktop\\Report.pdf"));
//            PdfWriter.getInstance(doc,new FileOutputStream(path + ".pdf")); 
//            
//            doc.open();
//            
//           // Paragraph p=new Paragraph(jLabel40.getText().toString());
//            //Paragraph p1=new Paragraph("No of Guests : "+jTextField1.getText().toString());
//            //Paragraph p2=new Paragraph("Income of the Month : "+jTextField2.getText().toString());
//            
//            
//         
//            PdfPTable tb=new PdfPTable(7);
//            
//                tb.addCell("Item Id");
//                tb.addCell("Item Name");
//                tb.addCell("Item Type");
//                tb.addCell("Qty");
//                tb.addCell("Item Price");
//                tb.addCell("Totoal");
//               
//                doc.setPageSize(PageSize.LETTER);
//
//                for(int i=0;i<jTable2.getRowCount();i++){
//                    System.out.println("r1");
//
//                    //Integer id=Integer.parseInt(jTable4.getValueAt(i,0).toString());
//                    String id=jTable2.getValueAt(i,0).toString();
//                    String nic=jTable2.getValueAt(i,1).toString();
//                    String fname=jTable2.getValueAt(i,2).toString();
//                    String lname=jTable2.getValueAt(i,3).toString();
//                    String checkin=jTable2.getValueAt(i,4).toString();
//                    String checkout=jTable4.getValueAt(i,5).toString();
//                    //String tot=jTable4.getValueAt(i,6).toString();
//
//                    System.out.println("r2");
//
//                tb.addCell(id);
//                tb.addCell(nic);
//                tb.addCell(fname);
//                tb.addCell(lname);
//                tb.addCell(checkin);
//                tb.addCell(checkout);
//               // tb.addCell(tot);
//
//                    System.out.println("r3");
//
//                }
//            
//            doc.add(tb);
//            doc.add(p);
//            doc.add(p1);
//            doc.add(p2);
//            
//            JOptionPane.showMessageDialog(null,"Report Generated Successfully","AlERT MESSAGE",JOptionPane.WARNING_MESSAGE);
//         
//        }catch(FileNotFoundException ex){
//             Logger.getLogger(RestaurantManagement.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (DocumentException ex) {
//            Logger.getLogger(RestaurantManagement.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//         doc.close();
            
            
            
                   
            
//            String sql = "INSERT INTO BookedTable(restableId,orderId,bookeddatetime)VALUES(?,?,?)";
//            System.out.println("Booked");
//            PreparedStatement statement = connection.prepareStatement(sql);
//            int i1 = 1;
//            int i2 = 1;
//            statement.setInt(1, i1);
//            statement.setInt(2, orderId);
//            //java.util.Date today = jDateChooser2.getDate();
//            //java.sql.Timestamp(today.getTime());
//            Timestamp t1 = new Timestamp(today.getTime());
//            statement.setTimestamp(3, now);
//            // statement.setInt(4,Integer.parseInt(jTextField5.getText()));
//
//            statement.executeUpdate();
        } catch (Exception e) {
             e. printStackTrace();
        }
        }else{
             JOptionPane.showMessageDialog(this, "please book a table to continue!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        ViewPanel("card5");
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(!(jTextField27.getText().isEmpty())){
        try {
            String sDate1 = jTextField30.getText();
            Date datehandled = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            java.util.Date date2 = datehandled;
            java.sql.Date d2 = null;
            d2 = new java.sql.Date(date2.getTime());
            String sql = "INSERT INTO Orders(Total,OrderDate,HandledStatus,HandledDate,guestId)VALUES(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, Double.parseDouble(jTextField28.getText()));
            statement.setDate(2, d2);
            statement.setBoolean(3, true);
            statement.setDate(4, d2);
            statement.setInt(5, Integer.parseInt(jTextField27.getText()));

            statement.executeUpdate();
            String sql1 = "SELECT * FROM Orders";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            
            //statement1.executeUpdate();
            ResultSet rs = statement1.executeQuery();
            ordersList.clear();

            while (rs.next()) {

                Orders order = new Orders();
                order.setOrderid(rs.getInt(1));
                order.setTotal(rs.getDouble(2));
                order.setOrderdate(rs.getDate(3));
                order.setHandledstatus(rs.getBoolean(4));
                order.setHandleddate(rs.getDate(5));
                Restaurantuser user = new Restaurantuser();
                user.setGuestid(rs.getInt(6));
                order.setGuestid(user);

                ordersList.add(order);
            }
            for(int i = 0 ; i < jTable2.getRowCount() ; i++){
                
            }
//            String emailText = "sdsd";
//         
//            
//                refreshTable3(ordersList);
//                new JToast().makeToast(this, "Inserted Succesfully", 1, JToast.type_of_succes);
//                EmailProcess m1=new EmailProcess();  
//                Thread t1 =new Thread(m1);  
//            t1.start();  
//new JToast().makeToast(this, "Email sent Succesfully", 1, JToast.type_of_succes);
//            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Please insert only relevant value types for Qty On Hand and Item Price fields", "Error", JOptionPane.ERROR_MESSAGE);

        } catch (ParseException ex) {
            Logger.getLogger(RestaurantManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
           String path="";
        JFileChooser j=new JFileChooser();
        int x=j.showOpenDialog(this);
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
          Document doc=new Document();
        //int x=j.showOpenDialog(this);
        try{
        if(x==JFileChooser.APPROVE_OPTION){
            
            path=j.getSelectedFile().getPath();
        
      
        
       
            
            //PdfWriter.getInstance(doc,new FileOutputStream("C:\\Users\\kavee\\OneDrive\\Desktop\\Report.pdf"));
            PdfWriter.getInstance(doc,new FileOutputStream(path + ".pdf")); 
            
            doc.open();
           // Paragraph p1 =new Paragraph();
              doc.add(new Paragraph("                         Hotel Kabalana Restaurant Payment Bill", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.RED)));
            doc.add(new Paragraph( "                                  "+                                         new Date().toString()));
            doc.add(new Paragraph("                          ---------------------------------------------------------------------------------------"));
           Paragraph p=new Paragraph("                                                                                                                        Total:" + jTextField8.getText().toString());
          

            //Paragraph p1=new Paragraph("No of Guests : "+jTextField1.getText().toString());
            //Paragraph p2=new Paragraph("Income of the Month : "+jTextField2.getText().toString());
            
            
         
            PdfPTable tb=new PdfPTable(6);
            
                tb.addCell("Item Id");
                tb.addCell("Item Name");
                tb.addCell("Item Type");
                tb.addCell("Qty");
                tb.addCell("Item Price");
                tb.addCell("Totoal");
               
                doc.setPageSize(PageSize.LETTER);
                 int count = 0;
                for(int i=0;i<jTable2.getRowCount();i++){
                    System.out.println("r1");
                    count ++;
                    //Integer id=Integer.parseInt(jTable4.getValueAt(i,0).toString());
                    String id=jTable2.getValueAt(i,0).toString();
                    String nic=jTable2.getValueAt(i,1).toString();
                    String fname=jTable2.getValueAt(i,2).toString();
                    String lname=jTable2.getValueAt(i,3).toString();
                    String checkin=jTable2.getValueAt(i,4).toString();
                    String checkout=jTable2.getValueAt(i,5).toString();
                    //String tot=jTable4.getValueAt(i,6).toString();

                    System.out.println("r2");

                tb.addCell(id);
                tb.addCell(nic);
                tb.addCell(fname);
                tb.addCell(lname);
                tb.addCell(checkin);
                tb.addCell(checkout);
               // tb.addCell(tot);

                    System.out.println("r3");

                }
                System.out.println("Count" + count);
            
            doc.add(tb);
            doc.add(p);
            
            
            //doc.add(p);
            //doc.add(p1);
           // doc.add(p2);
            
            JOptionPane.showMessageDialog(null,"Report Generated Successfully","INFO",1);
        }
       
        }catch(FileNotFoundException ex){
             Logger.getLogger(RestaurantManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(RestaurantManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         doc.close();
        }else{
           JOptionPane.showMessageDialog(this, "No order has been placed to confirm", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField28ActionPerformed

    }//GEN-LAST:event_jTextField28ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField29ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        try {
            TableModel model = jTable5.getModel();

            int selectedRowNo = jTable5.getSelectedRow();
            Integer val1 = Integer.parseInt(model.getValueAt(selectedRowNo, 1).toString());
            //Date date = new Date((long)model.getValueAt(selectedRowNo,5) * 1000);
            System.out.println("This is it: " + model.getValueAt(selectedRowNo, 5).getClass());
            jTextField17.setText(val1.toString());
            jTextField4.setText(model.getValueAt(selectedRowNo, 0).toString());
            jTextField16.setText(model.getValueAt(selectedRowNo, 2).toString());
            jTextField32.setText(new SimpleDateFormat("yyyy-MM-dd").format(model.getValueAt(selectedRowNo, 5)));
            //model.getValueAt(selectedRowNo,4).toString();
//      String sDate1=model.getValueAt(selectedRowNo,4).toString(); 
//       try {  
//           Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
//            jDateChooser3.setDate(date1);
//
//       } catch (ParseException ex) {
//           Logger.getLogger(RestaurantManagement.class.getName()).log(Level.SEVERE, null, ex);
//       }
            model.getValueAt(selectedRowNo, 4);
            jDateChooser3.setDate((Date) model.getValueAt(selectedRowNo, 4));
            if ((boolean) model.getValueAt(selectedRowNo, 3)) {
                jCheckBox2.setSelected(true);
            } else {
                jCheckBox2.setSelected(false);
            }
            System.out.println("Cameee");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("cam11");


    }//GEN-LAST:event_jTable5MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        ViewPanel("card2");
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jTextField22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyReleased
        validation1 = true;
        if (!(jTextField22.getText().matches("[0-9]+"))) {

            jLabel226.setText("*Please enter a valid contact number");
            validation1 = false;
        } else {
            jLabel226.setText("                           ");
        }
        if (jTextField22.getText().isEmpty()) {
            jLabel226.setText("                           ");
        }
    }//GEN-LAST:event_jTextField22KeyReleased

    private void jTextField19KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField19KeyReleased
        validation2 = true;
        if (!(jTextField19.getText().matches("[a-zA-Z]+"))) {
            jLabel214.setText("Please enter a valid name");
            validation2 = false;
        } else {
            jLabel214.setText("                                       ");
        }
        if (jTextField19.getText().isEmpty()) {
            jLabel214.setText("                                       ");
        }
    }//GEN-LAST:event_jTextField19KeyReleased

    private void jTextField23KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField23KeyReleased
        validation3 = true;
        if (!(jTextField23.getText().contains("@") && jTextField23.getText().contains("gmail.com"))) {
            jLabel227.setText("*Please enter a valid Email");
            validation3 = false;

        } else {
            jLabel227.setText("                                         ");
        }
        if (jTextField23.getText().isEmpty()) {
            jLabel227.setText("                                         ");
        }

    }//GEN-LAST:event_jTextField23KeyReleased

    private void jTextField21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyReleased
        validation5 = false;
        validation6 = false;
        validation7 = false;
        validation8 = true;

        if (!(jTextField21.getText().isEmpty())) {
            if (jTextField21.getText().length() == 10) {
//             for(int i= 0; i<9;i++){
//                 if(jTextField21.getText().charAt(i).matches("[a-zA-Z]+")){
//                     
//                 }
//             }
                if (jTextField21.getText().substring(0, 8).matches("[0-9]+") && jTextField21.getText().substring(9, 10).equals("V")) {
                    //validation5 = false;
                    validation5 = true;
                    System.out.println("valid1");
                }

            } //if(!(jTextField21.getText().isEmpty())){
            else if (jTextField21.getText().length() == 8) {
                if (jTextField21.getText().substring(0, 1).matches("[a-zA-Z]+") && jTextField21.getText().substring(1, 8).matches("[0-9]+")) {

                    validation6 = true;
                    System.out.println("valid2");
                }

            } else if (jTextField21.getText().length() == 11) {
                if (jTextField21.getText().matches("[0-9]+")) {
                    validation7 = true;
                    System.out.println("valid3");
                }
            }

        }

        if (!((validation7) || (validation5) || (validation6))) {

            jLabel225.setText("*Please enter a valid NIC/Passport number");
            System.out.println("Yessssss");
            validation8 = false;
        } else {
            jLabel225.setText("                           ");
        }
        if (jTextField21.getText().isEmpty()) {
            jLabel225.setText("                           ");
        }
    }//GEN-LAST:event_jTextField21KeyReleased

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        validation20 = true;
        if (!(jTextField5.getText().matches("[0-9]+"))) {
            jLabel80.setText("*Please enter a valid Qty");
            validation20 = false;
        }
        else{
             jLabel80.setText("                             ");
        }
        if (jTextField5.getText().isEmpty()) {
            jLabel80.setText("                             ");
        }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        validation21 = true;
        if (!(jTextField3.getText().matches("[0-9]+"))) {
            System.out.println("camee");
            jLabel137.setText("*Please enter a valid Price");
            validation21 = false;
        }
        else{
             jLabel137.setText("                             ");
        }
        if (jTextField3.getText().isEmpty()) {
            jLabel137.setText("                             ");
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        resItemValidity();
         
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jDateChooser2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser2MouseReleased
        validation24 = false;
        long millis=System.currentTimeMillis();
        java.util.Date currentDate=new java.util.Date(millis);
        if(jDateChooser2.getDate().compareTo(currentDate) <0){
            validation24 = false;
            System.out.println("came to date validation");
             jLabel139.setText("*Please select a valid date");
            
        }
        else{
              jLabel139.setText("                                                  ");
        }
    }//GEN-LAST:event_jDateChooser2MouseReleased

    private void jTextField25KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField25KeyReleased
       validation25 =true;
        if(!(jTextField25.getText().matches("[0-9]+"))){
            jLabel83.setText("*only numbers are allowed to this field");
            validation25 = false;
        }
        else{
             jLabel83.setText("                       ");
        }
    }//GEN-LAST:event_jTextField25KeyReleased

    private void jComboBox3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseReleased
      
    }//GEN-LAST:event_jComboBox3MouseReleased

    private void jComboBox3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseExited
      
      
    }//GEN-LAST:event_jComboBox3MouseExited

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
            validation26 = true;
        if(jComboBox3.getSelectedIndex()== 0){
          validation26 = false;
          jLabel143.setText("*Please select a hour");
      }
        else{
            jLabel143.setText("                       ");
        }
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
         resetfield1(); //reseting all selected values to empty on order handling
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
      boolean validation29 = true;
      TableModel model =(TableModel)jTable5.getModel();
      
        if(jTable5.getSelectedRowCount() == 0){
           jLabel144.setText("*please select a row");
           validation29 = false;
           
       }
        else{
            jLabel144.setText("                      ");
        }
        if(validation29){
            try{
               // int orderId= Integer.parseInt((jTable5.getValueAt(jTable5.getSelectedRow(),0)));
               int orderId = Integer.parseInt((model.getValueAt(jTable5.getSelectedRow(),0).toString()));
                System.out.println("rowww:" + (jTable5.getValueAt(jTable5.getSelectedRow(),0)).getClass() );
                  String sql = "DELETE FROM BOOKEDTABLE WHERE orderID=?";
                  PreparedStatement statement = connection.prepareStatement(sql);
                  statement.setInt(1,orderId);
                  statement.executeUpdate();
                  String sql1 = "DELETE FROM ORDERS WHERE orderID=?";
                   PreparedStatement statement1 = connection.prepareStatement(sql1);
                  statement1.setInt(1,orderId);
                   statement1.executeUpdate();
                   new JToast().makeToast(this, "Deleted Succesfully", 1, JToast.type_of_succes);
                  
                  
      
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
            }
                }  
            
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyReleased
       validation30 = true;
        if(!(jTextField14.getText().isEmpty())){
           if(!(jTextField14.getText().matches("[0-9]+"))){
               validation30 = false;
               jLabel151.setText("*only allowed numbers");
           }
        
           
       }
        if(jTextField14.getText().isEmpty()){
            jLabel151.setText("                     ");
        }
    }//GEN-LAST:event_jTextField14KeyReleased

    private void jPanel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseClicked
        ViewPanel("card7");
    }//GEN-LAST:event_jPanel21MouseClicked

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
     try{
        java.util.Date startingDate =jDateChooser1.getDate();
       java.util.Date endingDate = jDateChooser4.getDate();
            java.sql.Date d1 = null;
            d1 = new java.sql.Date(startingDate.getTime());
           java.sql.Date d2 = null;
            d2 = new java.sql.Date(endingDate.getTime());
            try {
        String sql = "SELECT * FROM orders WHERE orderDate BETWEEN '"+d1+"' AND '"+d2+"' ";
          
              PreparedStatement pst = connection.prepareStatement(sql);
              ResultSet rs = pst.executeQuery();
              ordersList1.clear();
              while(rs.next()){
                  Orders order = new Orders();
                  order.setOrderid(rs.getInt(1));
                  order.setTotal(rs.getDouble(2));
                  order.setOrderdate(rs.getDate(3));
                  order.setHandledstatus(rs.getBoolean(4));
                  order.setHandleddate(rs.getDate(5));
                  Restaurantuser resUser = new Restaurantuser();
                  resUser.setGuestid(rs.getInt(6));
                  order.setGuestid(resUser);
                  ordersList1.add(order);
                  
              }
                refreshTableOrderReport(ordersList1);
                
         String sql1 = "SELECT COUNT(orderId) FROM Orders WHERE orderDate BETWEEN '"+d1+"' AND '"+d2+"' ";
         
              PreparedStatement pst1 = connection.prepareStatement(sql);
                ResultSet rs1 = pst1.executeQuery();
                int count = 0;
                while(rs1.next()){
                    
                   // count = rs1.getInt(1);
                    count++;
                }
                jTextField36.setText(((Integer)count).toString());
                   
         String sql2= "SELECT orderId FROM Orders WHERE orderDate BETWEEN '"+d1+"' AND '"+d2+"' AND handledstatus=false";
                System.out.println("came3");
                
              PreparedStatement pst2 = connection.prepareStatement(sql2);
             // pst2.setBoolean(1,false);
                ResultSet rs2 = pst2.executeQuery();
                int count1 = 0;
                while(rs2.next()){
                     System.out.println("came2");
                    count1++;
                }
       
                jTextField34.setText(((Integer)count1).toString());   
                
                   String sql3="SELECT SUM(Total) FROM Orders WHERE orderDate BETWEEN '"+d1+"' AND '"+d2+"' AND handledstatus=false";     
                       PreparedStatement pst3 = connection.prepareStatement(sql3);
             // pst2.setBoolean(1,false);
                ResultSet rs3 = pst3.executeQuery();
                double sum = 0;
                while(rs3.next()){
                 sum=  rs3.getDouble(1);
                }
       
                jTextField35.setText(((Double)sum).toString());   
                    String sql4="SELECT SUM(Total) FROM Orders WHERE orderDate BETWEEN '"+d1+"' AND '"+d2+"' AND handledstatus=true";     
                       PreparedStatement pst4 = connection.prepareStatement(sql4);
             // pst2.setBoolean(1,false);
                ResultSet rs4 = pst4.executeQuery();
                double sum1 = 0;
                while(rs4.next()){
                 sum1=  rs4.getDouble(1);
                }
       
               jTextField37.setText(((Double)sum1).toString());
//                covertPdfReport();
   String path="";
        JFileChooser j=new JFileChooser();
        int x=j.showOpenDialog(this);
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //int x=j.showOpenDialog(this);
        
        if(x==JFileChooser.APPROVE_OPTION){
            
            path=j.getSelectedFile().getPath();
        }
        Document doc=new Document();
        
        try{
            
            //PdfWriter.getInstance(doc,new FileOutputStream("C:\\Users\\kavee\\OneDrive\\Desktop\\Report.pdf"));
            PdfWriter.getInstance(doc,new FileOutputStream(path + ".pdf")); 
            
            doc.open();
           // Paragraph p1 =new Paragraph();
              doc.add(new Paragraph("                         Hotel Kabalana Restaurant Month end Report", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.RED)));
            doc.add(new Paragraph( "                                  "+                                         new Date().toString()));
            doc.add(new Paragraph("                          ---------------------------------------------------------------------------------------"));
           Paragraph p=new Paragraph("               No of Orders:" + jTextField36.getText().toString());
           Paragraph p1=new Paragraph("              unhandled Orders:" + jTextField34.getText().toString());
            Paragraph p2=new Paragraph("               Pending Income:" + jTextField35.getText().toString());
           Paragraph p3=new Paragraph("              Income:" + jTextField37.getText().toString());


            //Paragraph p1=new Paragraph("No of Guests : "+jTextField1.getText().toString());
            //Paragraph p2=new Paragraph("Income of the Month : "+jTextField2.getText().toString());
            
            
         
            PdfPTable tb=new PdfPTable(6);
            
                tb.addCell("orderId Id");
                tb.addCell("Guest Id");
                tb.addCell("handled Status");
                tb.addCell("Order Date");
                tb.addCell("Handled Date");
                tb.addCell("Total");
               
                doc.setPageSize(PageSize.LETTER);
                 int count11 = 0;
                for(int i=0;i<jTable6.getRowCount();i++){
                    System.out.println("r1");
                    count11 ++;
                    //Integer id=Integer.parseInt(jTable4.getValueAt(i,0).toString());
                    String id=jTable6.getValueAt(i,0).toString();
                    String nic=jTable6.getValueAt(i,1).toString();
                    String fname=jTable6.getValueAt(i,2).toString();
                    String lname=jTable6.getValueAt(i,3).toString();
                    String checkin=jTable6.getValueAt(i,4).toString();
                    String checkout=jTable6.getValueAt(i,5).toString();
                    //String tot=jTable4.getValueAt(i,6).toString();

                    System.out.println("r2");

                tb.addCell(id);
                tb.addCell(nic);
                tb.addCell(fname);
                tb.addCell(lname);
                tb.addCell(checkin);
                tb.addCell(checkout);
               // tb.addCell(tot);

                    System.out.println("r3");

                }
                System.out.println("Count" + count);
            
            doc.add(tb);
            doc.add(p);
            doc.add(p1);doc.add(p2);doc.add(p3);
            
            
            
            //doc.add(p);
            //doc.add(p1);
           // doc.add(p2);
            
            JOptionPane.showMessageDialog(null,"Report Generated Successfully","AlERT MESSAGE",JOptionPane.WARNING_MESSAGE);
         
        }catch(FileNotFoundException ex){
             Logger.getLogger(RestaurantManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(RestaurantManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
         doc.close();
         
          

             
               
//                java.util.Date firstMonthStart = new Date();
//                firstMonthStart.setMonth(0);
//                firstMonthStart.setDate(0);
//                
//                java.util.Date firstMonthEnd = new Date();
//                firstMonthEnd.setMonth(0);
//                firstMonthEnd.setDate(0);
//                
//              java.sql.Date firstMonthStartDate = null;
//            firstMonthStartDate= new java.sql.Date(firstMonthStart.getTime());
//            
//                    java.sql.Date firstMonthEndDate = null;
//             firstMonthEndDate= new java.sql.Date(firstMonthEnd.getTime());
//               String sql44 = "SELECT SUM(Total) FROM Orders WHERE orderDate BETWEEN '"+firstMonthStart+"' AND '"+firstMonthEndDate+"' AND handledstatus=true";
//                PreparedStatement pst44 = connection.prepareStatement(sql44);
//               ResultSet rs44 = pst44.executeQuery();
//                double sum44 = 0;
//                while(rs44.next()){
//                 sum44=  rs44.getDouble(1);
//                }
System.out.println("123");
//            double january =  monthEndIncome(0,1);
//            System.out.println("11");
//            double feb=  monthEndIncome(1,2);
//            double mar =  monthEndIncome(2,3);
//            double april =  monthEndIncome(3,4);
//            double may =  monthEndIncome(4,5);
//            double june =  monthEndIncome(5,6);
//            double jul= monthEndIncome(6,7);
//            double aug =  monthEndIncome(7,8);
//            double sep =  monthEndIncome(8,9);
//            double oct= monthEndIncome(9,10);
//            double nov = monthEndIncome(10,11);
//            double dec =  monthEndIncome(11,0);
//              DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
//        dataSet.setValue(january,"Income","January");
//        dataSet.setValue(feb,"Income","Februrary");
//        dataSet.setValue(mar,"Income","March");
//        dataSet.setValue(april,"Income","April");
//        dataSet.setValue(may,"Income","May");
//        dataSet.setValue(june,"Income","June");
//         dataSet.setValue(jul,"Income","July");
//        dataSet.setValue(aug,"Income","August");
//        dataSet.setValue(sep,"Income","September");
//        dataSet.setValue(oct,"Income","October");
//        dataSet.setValue(nov,"Income","November");
//        dataSet.setValue(dec,"Income","December");
//        
//        
//        JFreeChart chart= ChartFactory.createBarChart("Income Comparision Chart","Month", "Value", dataSet, PlotOrientation.VERTICAL, false,true,false);
//        CategoryPlot p =chart.getCategoryPlot();
//        p.setRangeGridlinePaint(Color.black);
//        ChartPanel panel = new ChartPanel(chart);
//       
//        ChartFrame frame = new ChartFrame("Income Comparision Chart",chart);
//        frame.setVisible(true);
//        frame.setSize(1400,500);
//        frame.setLocationRelativeTo(null);
                   
          } catch (SQLException e) {
                System.out.println(e.getMessage());
          }
              }
               catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, "please fill all the relavant fields", "Error", JOptionPane.ERROR_MESSAGE);

        }
//            
//             int sum44=0;
//       int sum45 =0;
//       int sum46=0;
//       int sum47 =0;
//       int sum48 =0;
//       int sum49=0;
//       int sum50=0;
//       int sum51 =0;
//       int sum52=0;
//        try{ 
//        String sql44 = "SELECT SUM(RICE) FROM RestaurantUser" ;
//                PreparedStatement pst44 = connection.prepareStatement(sql44);
//               ResultSet rs44 = pst44.executeQuery();
//                //double sum44 = 0;
//                while(rs44.next()){
//                 sum44=  rs44.getInt(1);
//                }
//                
//          String sql45 = "SELECT SUM(SOUP) FROM RestaurantUser" ;
//                PreparedStatement pst45 = connection.prepareStatement(sql45);
//               ResultSet rs45 = pst45.executeQuery();
//                //double sum44 = 0;
//                while(rs45.next()){
//                 sum45=  rs45.getInt(1);
//                }       
//         String sql46 = "SELECT SUM(NOODLES) FROM RestaurantUser" ;
//                PreparedStatement pst46 = connection.prepareStatement(sql46);
//               ResultSet rs46 = pst46.executeQuery();
//                //double sum44 = 0;
//                while(rs46.next()){
//                 sum46=  rs46.getInt(1);
//                }              
//             String sql47= "SELECT SUM(MEATDISHES) FROM RestaurantUser" ;
//                PreparedStatement pst47 = connection.prepareStatement(sql47);
//               ResultSet rs47 = pst47.executeQuery();
//                //double sum44 = 0;
//                while(rs47.next()){
//                 sum47=  rs47.getInt(1);
//                }  
//              String sql48= "SELECT SUM(SEAFOOD) FROM RestaurantUser" ;
//                PreparedStatement pst48 = connection.prepareStatement(sql48);
//               ResultSet rs48 = pst48.executeQuery();
//                //double sum44 = 0;
//                while(rs48.next()){
//                 sum48=  rs48.getInt(1);
//                }  
//                
//                String sql49= "SELECT SUM(BEVERAGES) FROM RestaurantUser" ;
//                PreparedStatement pst49 = connection.prepareStatement(sql49);
//               ResultSet rs49 = pst49.executeQuery();
//                //double sum44 = 0;
//                while(rs49.next()){
//                 sum49=  rs49.getInt(1);
//                } 
//                 String sql50= "SELECT SUM(VEGETABLEDISHES) FROM RestaurantUser" ;
//                PreparedStatement pst50 = connection.prepareStatement(sql50);
//               ResultSet rs50 = pst50.executeQuery();
//                //double sum44 = 0;
//                while(rs50.next()){
//                 sum50=  rs50.getInt(1);
//                } 
//                 String sql51= "SELECT SUM(PUDDINGS) FROM RestaurantUser" ;
//                PreparedStatement pst51 = connection.prepareStatement(sql51);
//               ResultSet rs51 = pst51.executeQuery();
//                //double sum44 = 0;
//                while(rs51.next()){
//                 sum51=  rs51.getInt(1);
//                } 
//                 String sql52= "SELECT SUM(MENUS) FROM RestaurantUser" ;
//                PreparedStatement pst52 = connection.prepareStatement(sql52);
//               ResultSet rs52 = pst52.executeQuery();
//                //double sum44 = 0;
//                while(rs52.next()){
//                 sum52=  rs52.getInt(1);
//                } 
//                         DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
//        dataSet.setValue(sum44,"Income","January");
//        dataSet.setValue(sum45,"Income","Februrary");
//        dataSet.setValue(sum46,"Income","March");
//        dataSet.setValue(sum47,"Income","April");
//        dataSet.setValue(sum48,"Income","May");
//        dataSet.setValue(sum49,"Income","June");
//         dataSet.setValue(sum50,"Income","July");
//        dataSet.setValue(sum51,"Income","August");
//        dataSet.setValue(sum52,"Income","September");
////        dataSet.setValue(53,"Income","October");
////        dataSet.setValue(nov,"Income","November");
////        dataSet.setValue(dec,"Income","December");
//        
//        
//        JFreeChart chart2= ChartFactory.createBarChart("Income Comparision Chart","Month", "Value", dataSet, PlotOrientation.VERTICAL, false,true,false);
//        CategoryPlot p1 =chart2.getCategoryPlot();
//        p1.setRangeGridlinePaint(Color.black);
//        ChartPanel panel = new ChartPanel(chart2);
//       
//        ChartFrame frame1 = new ChartFrame("Income Comparision Chart",chart2);
//        frame1.setVisible(true);
//        frame1.setSize(1400,500);
//        frame1.setLocationRelativeTo(null);
//                   
//                
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
        
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
       try{ 
        double val1=resIncome(jDateChooser1);
        double val2 = resIncome(jDateChooser4);
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.setValue(val1,"Income",showMonth(jDateChooser1));
        dataSet.setValue(val2,"Income",showMonth(jDateChooser4));
        
        JFreeChart chart= ChartFactory.createBarChart("Income Comparision Chart","Month", "Value", dataSet, PlotOrientation.VERTICAL, false,true,false);
        CategoryPlot p =chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartPanel panel = new ChartPanel(chart);
       
        ChartFrame frame = new ChartFrame("Income Comparision Chart",chart);
        frame.setVisible(true);
        frame.setSize(450,350);
        frame.setLocationRelativeTo(null);
         //JFreeChart my2DChart=ChartFactory.createBarChart("Mark Details","Subject","Marks",mychartData,PlotOrientation.VERTICAL,false,true,false);
                /* 2D Chart created till this point, this can be moved into iText PDF */
                int width=640; /* Width of our chart */
                int height=480; /* Height of our chart */
                Document document=new Document(new Rectangle(width,height)); /* Create a New Document Object */
                /* Create PDF Writer Object that will write the chart information for us */
                //PdfWriter writer=PdfWriter.getInstance(document,new FileOutputStream("Insert_2d_Chart_in_PDF.pdf"));
                  String path="";
        JFileChooser j=new JFileChooser();
        int x=j.showOpenDialog(this);
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //int x=j.showOpenDialog(this);
        
        if(x==JFileChooser.APPROVE_OPTION){
            
            path=j.getSelectedFile().getPath();
        }

       // Document doc=new Document();
        
       
            //PdfWriter.getInstance(doc,new FileOutputStream("C:\\Users\\kavee\\OneDrive\\Desktop\\Report.pdf"));
           PdfWriter writer= PdfWriter.getInstance(document,new FileOutputStream(path + ".pdf")); 
            
                /* Open the Document Object for adding contents */
                document.open();
                /* Get Direct Content of the PDF document for writing */
                PdfContentByte Add_Chart_Content= writer.getDirectContent();
                /* Create a template using the PdfContent Byte object */
                PdfTemplate template_Chart_Holder=Add_Chart_Content.createTemplate(width,height);
                /* Create a 2D graphics object to write on the template */
                Graphics2D Graphics_Chart=template_Chart_Holder.createGraphics(width,height,new DefaultFontMapper());
                /* Create a Rectangle object */
                Rectangle2D Chart_Region=new Rectangle2D.Double(0,0,540,380);
                /* Invoke the draw method passing the Graphics and Rectangle 2D object to draw the chart */
                chart.draw(Graphics_Chart,Chart_Region);            
                Graphics_Chart.dispose();
                /* Add template to PdfContentByte and then to the PDF document */
                Add_Chart_Content.addTemplate(template_Chart_Holder,0,0);
                /* Close the Document, writer will create a beautiful 2D chart inside the PDF document */
           document.close();
       }
        catch(NullPointerException e){
                 JOptionPane.showMessageDialog(this, "Please choose a date to continue", "Error", JOptionPane.ERROR_MESSAGE);

                 }       
       catch(Exception e){
           System.out.println(e.getMessage());
       }
        
        
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        
        nColour.mouseEntered(jPanel4);
        
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        nColour.mouseExsited(jPanel4);
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
       
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
       nColour.mouseEntered(jPanel9);
    }//GEN-LAST:event_jPanel9MouseEntered

    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
        // TODO add your handling code here:
        nColour.mouseExsited(jPanel9);
                                      
    }//GEN-LAST:event_jPanel9MouseExited

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
         nColour.mouseEntered(jPanel10);
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
         nColour.mouseExsited(jPanel10);
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseEntered
      nColour.mouseEntered(jPanel18);
    }//GEN-LAST:event_jPanel18MouseEntered

    private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited
        nColour.mouseExsited(jPanel18);
    }//GEN-LAST:event_jPanel18MouseExited

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
          nColour.mouseEntered(jPanel8);
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        nColour.mouseExsited(jPanel8);
    }//GEN-LAST:event_jPanel8MouseExited

    private void jPanel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseEntered
       nColour.mouseEntered(jPanel21);
    }//GEN-LAST:event_jPanel21MouseEntered

    private void jPanel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseExited
         nColour.mouseExsited(jPanel21);
    }//GEN-LAST:event_jPanel21MouseExited

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jTextField36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField36ActionPerformed

    private void jButton22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton22MouseClicked
      dispose();
      loginnav log1 = new loginnav();
      log1.setVisible(true);
    }//GEN-LAST:event_jButton22MouseClicked

    private void jButton23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23MouseClicked

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
         int i = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to log out?");
        if (i == JOptionPane.YES_OPTION) {
            
            dispose();
            SplashView sp = new SplashView();
            sp.setVisible(true);
            
            Login l = new Login();
            l.setSpalshView(sp); 
            l.setVisible(true);
            
        }        // TODO add your
    }//GEN-LAST:event_jButton23ActionPerformed

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
            java.util.logging.Logger.getLogger(RestaurantManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurantManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurantManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurantManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurantManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager HotelManagementSystemPUEntityManager;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
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
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
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
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JRadioButton jRadioButton24;
    private javax.swing.JRadioButton jRadioButton25;
    private javax.swing.JRadioButton jRadioButton26;
    private javax.swing.JRadioButton jRadioButton27;
    private javax.swing.JRadioButton jRadioButton28;
    private javax.swing.JRadioButton jRadioButton29;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton30;
    private javax.swing.JRadioButton jRadioButton31;
    private javax.swing.JRadioButton jRadioButton32;
    private javax.swing.JRadioButton jRadioButton33;
    private javax.swing.JRadioButton jRadioButton34;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
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
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private java.util.List<restaurantManagementFunction.Orders> ordersList;
    private java.util.List<restaurantManagementFunction.Orders> ordersList1;
    private javax.persistence.Query ordersQuery;
    private javax.persistence.Query ordersQuery1;
    private java.util.List<restaurantManagementFunction.Resitem> resitemList;
    private java.util.List<restaurantManagementFunction.Resitem> resitemList1;
    private javax.persistence.Query resitemQuery;
    private javax.persistence.Query resitemQuery1;
    private java.util.List<restaurantManagementFunction.Restaurantuser> restaurantuserList;
    private javax.persistence.Query restaurantuserQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
