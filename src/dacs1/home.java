/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dacs1;

import java.awt.CardLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.table.TableModel;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author ASUS
 */
public class home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    public home() {
        initComponents();
        tfCheckINDateCCI.setEditable(false);
        tfPriceCCI.setEditable(false);
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        tfCheckINDateCCI.setText(myFormat.format(cal.getTime()));

        tfSearchCheckOUTDateCDB.setText(myFormat.format(cal.getTime()));

        tfCustomerNameCCO.setEditable(false);
        tfCheckINDateCCO.setEditable(false);
        tfCheckOUTDateCCO.setEditable(false);
        tfCustomerMNCCO.setEditable(false);
        tfPricePerDayCCO.setEditable(false);
        tfNumDaysStayCCO.setEditable(false);
        tfTotalAmountCCO.setEditable(false);
        tfEmailCCO.setEditable(false);
    }

    String bed;
    String roomType;
    String roomNo;
    String price;

    int id = 0;
    String Query;
//    String roomTypeCCO;
//    String bedCCO;
//    String roomNoCCO;

    public void roomDetails() {
        cbRoomNumCCI.removeAllItems();
        cbRoomNumCCI.removeAllItems();
        tfPriceCCI.setText("");
        bed = (String) cbBedCCI.getSelectedItem();
        roomType = (String) cbRoomTypeCCI.getSelectedItem();
        try {
            ResultSet rs = Select.getData("select * from room where bed = '" + bed + "' and roomType = '" + roomType + "' and status = 'Not Booked'");
            while (rs.next()) {
                cbRoomNumCCI.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    int witdth = 250;
    int height = 768;

    void openMenubar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < witdth; i++) {
                    jpnSlideMenu.setSize(i, height);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    void closeMenubar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = witdth; i > 0; i--) {
                    jpnSlideMenu.setSize(i, height);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    private void refreshRoomTable() {
        DefaultTableModel model = (DefaultTableModel) jtbManageRoom.getModel();
        model.setRowCount(0); // Xóa hết các dòng hiện tại trên bảng

        // Lấy dữ liệu từ cơ sở dữ liệu và thêm vào bảng
        ResultSet rs = Select.getData("SELECT * FROM room");
        try {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        jpnContainer = new javax.swing.JPanel();
        jpnSlideMenu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbCloseMenu = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbCustomerDetailsBill = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbLogout = new javax.swing.JLabel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        lbCustomerCheckOut = new javax.swing.JLabel();
        lbCustomerCheckIn = new javax.swing.JLabel();
        lbManageRoom = new javax.swing.JLabel();
        lbHomePage = new javax.swing.JLabel();
        jpnMenuBar = new javax.swing.JPanel();
        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        lbOpenMenu = new javax.swing.JLabel();
        jpnMain = new javax.swing.JPanel();
        cardTrangchu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cardManageRoom = new javax.swing.JPanel();
        kGPBackground1 = new com.k33ptoo.components.KGradientPanel();
        lbMRLogo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbManageRoom = new javax.swing.JTable();
        lbRoomNumberM = new javax.swing.JLabel();
        tfRoomNumberM = new javax.swing.JTextField();
        lbRoomTypeM = new javax.swing.JLabel();
        cbRoomTypeM = new javax.swing.JComboBox<>();
        lbBedM = new javax.swing.JLabel();
        cbBedM = new javax.swing.JComboBox<>();
        lbPriceM = new javax.swing.JLabel();
        tfPriceM = new javax.swing.JTextField();
        kbtnAddRoom = new com.k33ptoo.components.KButton();
        kbtnDeleteRoom = new com.k33ptoo.components.KButton();
        kbtnUpdateRoom = new com.k33ptoo.components.KButton();
        kbtnFindRoom = new com.k33ptoo.components.KButton();
        kbtnResetMR = new com.k33ptoo.components.KButton();
        lbPicture = new javax.swing.JLabel();
        lbImgContainer = new javax.swing.JLabel();
        cardCustomerCheckIn = new javax.swing.JPanel();
        kGPBackground2 = new com.k33ptoo.components.KGradientPanel();
        lbCCILogo = new javax.swing.JLabel();
        lbNameCCI = new javax.swing.JLabel();
        tfNameCCI = new javax.swing.JTextField();
        lbMobileNumCCI = new javax.swing.JLabel();
        tfMobileNumCCI = new javax.swing.JTextField();
        lbNationalityCCI = new javax.swing.JLabel();
        tfNationalityCCI = new javax.swing.JTextField();
        lbGenderCCI = new javax.swing.JLabel();
        cbGenderCCI = new javax.swing.JComboBox<>();
        lbEmailCCI = new javax.swing.JLabel();
        tfEmailCCI = new javax.swing.JTextField();
        lbIDProofCCI = new javax.swing.JLabel();
        tfIDProofCCI = new javax.swing.JTextField();
        lbAddressCCI = new javax.swing.JLabel();
        tfAddressCCI = new javax.swing.JTextField();
        lbCheckINDateCCI = new javax.swing.JLabel();
        tfCheckINDateCCI = new javax.swing.JTextField();
        lbBedCCI = new javax.swing.JLabel();
        cbBedCCI = new javax.swing.JComboBox<>();
        lbRoomTypeCCI = new javax.swing.JLabel();
        cbRoomTypeCCI = new javax.swing.JComboBox<>();
        lbRoomNumCCI = new javax.swing.JLabel();
        cbRoomNumCCI = new javax.swing.JComboBox<>();
        lbPriceCCI = new javax.swing.JLabel();
        tfPriceCCI = new javax.swing.JTextField();
        kbtnAlloteRoomCCI = new com.k33ptoo.components.KButton();
        kbtnClearCCI = new com.k33ptoo.components.KButton();
        kbtnXMLCCI = new com.k33ptoo.components.KButton();
        cardCustomerCheckOut = new javax.swing.JPanel();
        kGPBackground3 = new com.k33ptoo.components.KGradientPanel();
        lbCCOLogo = new javax.swing.JLabel();
        lbRoomNumCCO = new javax.swing.JLabel();
        tfRoomNumCCO = new javax.swing.JTextField();
        kbtnSearchCCO = new com.k33ptoo.components.KButton();
        lbCustomerNameCCO = new javax.swing.JLabel();
        tfCustomerNameCCO = new javax.swing.JTextField();
        lbPricePerDayCCO = new javax.swing.JLabel();
        tfPricePerDayCCO = new javax.swing.JTextField();
        lbCheckINDateCCO = new javax.swing.JLabel();
        tfCheckINDateCCO = new javax.swing.JTextField();
        lbNumDaysStayCCO = new javax.swing.JLabel();
        tfNumDaysStayCCO = new javax.swing.JTextField();
        lbCheckOUTDateCCO = new javax.swing.JLabel();
        tfCheckOUTDateCCO = new javax.swing.JTextField();
        lbTotalAmountCCO = new javax.swing.JLabel();
        tfTotalAmountCCO = new javax.swing.JTextField();
        lbCustomerMNCCO = new javax.swing.JLabel();
        tfCustomerMNCCO = new javax.swing.JTextField();
        lbEmailCCO = new javax.swing.JLabel();
        tfEmailCCO = new javax.swing.JTextField();
        kbtnCheckOutCCO = new com.k33ptoo.components.KButton();
        kbtnClearCCO = new com.k33ptoo.components.KButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbCustomerCheckOut = new javax.swing.JTable();
        kbtnImportCCO = new com.k33ptoo.components.KButton();
        kbtnviewXMLCCO = new com.k33ptoo.components.KButton();
        cardCustomerDetailsBill = new javax.swing.JPanel();
        kGPBackground4 = new com.k33ptoo.components.KGradientPanel();
        lbCDBLogo = new javax.swing.JLabel();
        lbSearchCheckOUTDateCDB = new javax.swing.JLabel();
        tfSearchCheckOUTDateCDB = new javax.swing.JTextField();
        kbtnSearchCDB = new com.k33ptoo.components.KButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbCustomerDetailsBill = new javax.swing.JTable();
        lbClickCDB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnContainer.setBackground(new java.awt.Color(255, 255, 255));
        jpnContainer.setMinimumSize(new java.awt.Dimension(1366, 768));
        jpnContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnSlideMenu.setBackground(new java.awt.Color(204, 255, 255));
        jpnSlideMenu.setMinimumSize(new java.awt.Dimension(250, 768));
        jpnSlideMenu.setPreferredSize(new java.awt.Dimension(250, 768));
        jpnSlideMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/z5490001851864_73817121c6231aa9a43ad51786b97620.jpg"))); // NOI18N

        lbCloseMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        lbCloseMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMenuMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel3.setText("Livin Hotel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lbCloseMenu)
                .addGap(19, 19, 19))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCloseMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jpnSlideMenu.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 240));

        lbCustomerDetailsBill.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        lbCustomerDetailsBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Customer Details Bill.png"))); // NOI18N
        lbCustomerDetailsBill.setText("Customer Details Bill");
        lbCustomerDetailsBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCustomerDetailsBillMouseClicked(evt);
            }
        });
        jpnSlideMenu.add(lbCustomerDetailsBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, -1, -1));
        jpnSlideMenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 250, 10));

        lbLogout.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        lbLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        lbLogout.setText("Logout");
        lbLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogoutMouseClicked(evt);
            }
        });
        jpnSlideMenu.add(lbLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 700, -1, -1));

        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(102, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 102, 255));

        lbCustomerCheckOut.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        lbCustomerCheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Customer Check Out.png"))); // NOI18N
        lbCustomerCheckOut.setText("Customer Check Out");
        lbCustomerCheckOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCustomerCheckOutMouseClicked(evt);
            }
        });

        lbCustomerCheckIn.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        lbCustomerCheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Customer Registration & Check IN.png"))); // NOI18N
        lbCustomerCheckIn.setText("Customer Check In");
        lbCustomerCheckIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCustomerCheckInMouseClicked(evt);
            }
        });

        lbManageRoom.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        lbManageRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manage room.png"))); // NOI18N
        lbManageRoom.setText("Manage Room");
        lbManageRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbManageRoomMouseClicked(evt);
            }
        });

        lbHomePage.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        lbHomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Customer Check Out.png"))); // NOI18N
        lbHomePage.setText("Home");
        lbHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHomePageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHomePage)
                    .addComponent(lbManageRoom)
                    .addComponent(lbCustomerCheckOut)
                    .addComponent(lbCustomerCheckIn))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(262, Short.MAX_VALUE)
                .addComponent(lbHomePage)
                .addGap(28, 28, 28)
                .addComponent(lbManageRoom)
                .addGap(29, 29, 29)
                .addComponent(lbCustomerCheckIn)
                .addGap(33, 33, 33)
                .addComponent(lbCustomerCheckOut)
                .addGap(216, 216, 216))
        );

        jpnSlideMenu.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 768));

        jpnContainer.add(jpnSlideMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 768));

        jpnMenuBar.setBackground(new java.awt.Color(255, 255, 255));
        jpnMenuBar.setPreferredSize(new java.awt.Dimension(1366, 100));

        kGradientPanel3.setkBorderRadius(0);
        kGradientPanel3.setkEndColor(new java.awt.Color(51, 153, 255));
        kGradientPanel3.setkGradientFocus(900);
        kGradientPanel3.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setPreferredSize(new java.awt.Dimension(1366, 100));

        lbOpenMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu.png"))); // NOI18N
        lbOpenMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbOpenMenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbOpenMenu)
                .addContainerGap(1304, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbOpenMenu)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnMenuBarLayout = new javax.swing.GroupLayout(jpnMenuBar);
        jpnMenuBar.setLayout(jpnMenuBarLayout);
        jpnMenuBarLayout.setHorizontalGroup(
            jpnMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuBarLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jpnMenuBarLayout.setVerticalGroup(
            jpnMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnContainer.add(jpnMenuBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 60));

        jpnMain.setLayout(new java.awt.CardLayout());

        cardTrangchu.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N

        javax.swing.GroupLayout cardTrangchuLayout = new javax.swing.GroupLayout(cardTrangchu);
        cardTrangchu.setLayout(cardTrangchuLayout);
        cardTrangchuLayout.setHorizontalGroup(
            cardTrangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardTrangchuLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        cardTrangchuLayout.setVerticalGroup(
            cardTrangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardTrangchuLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnMain.add(cardTrangchu, "card2");

        cardManageRoom.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cardManageRoomComponentShown(evt);
            }
        });

        kGPBackground1.setkBorderRadius(0);
        kGPBackground1.setkEndColor(new java.awt.Color(102, 255, 153));
        kGPBackground1.setkGradientFocus(900);
        kGPBackground1.setkStartColor(new java.awt.Color(51, 153, 255));
        kGPBackground1.setOpaque(false);

        lbMRLogo.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        lbMRLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manage room.png"))); // NOI18N
        lbMRLogo.setText("Manage Room");

        jtbManageRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room Number", "Room Type", "Bed", "Price", "Status"
            }
        ));
        jtbManageRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbManageRoomMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbManageRoom);

        lbRoomNumberM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbRoomNumberM.setText("Room Number:");

        tfRoomNumberM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbRoomTypeM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbRoomTypeM.setText("RoomType       :");

        cbRoomTypeM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbRoomTypeM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "None-AC" }));

        lbBedM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbBedM.setText("Bed                   :");

        cbBedM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbBedM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double", "Triple" }));

        lbPriceM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPriceM.setText("Price                 :");

        tfPriceM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        kbtnAddRoom.setText("Add Room");
        kbtnAddRoom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kbtnAddRoom.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        kbtnAddRoom.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kbtnAddRoom.setkHoverStartColor(new java.awt.Color(153, 255, 0));
        kbtnAddRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbtnAddRoomActionPerformed(evt);
            }
        });

        kbtnDeleteRoom.setText("Delete Room");
        kbtnDeleteRoom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kbtnDeleteRoom.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        kbtnDeleteRoom.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kbtnDeleteRoom.setkHoverStartColor(new java.awt.Color(135, 255, 0));
        kbtnDeleteRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbtnDeleteRoomActionPerformed(evt);
            }
        });

        kbtnUpdateRoom.setText("Update Room");
        kbtnUpdateRoom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kbtnUpdateRoom.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        kbtnUpdateRoom.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kbtnUpdateRoom.setkHoverStartColor(new java.awt.Color(135, 255, 0));
        kbtnUpdateRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbtnUpdateRoomActionPerformed(evt);
            }
        });

        kbtnFindRoom.setText("Find Room");
        kbtnFindRoom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kbtnFindRoom.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        kbtnFindRoom.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kbtnFindRoom.setkHoverStartColor(new java.awt.Color(135, 255, 0));
        kbtnFindRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbtnFindRoomActionPerformed(evt);
            }
        });

        kbtnResetMR.setText("Reset");
        kbtnResetMR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kbtnResetMR.setkEndColor(new java.awt.Color(255, 204, 255));
        kbtnResetMR.setkHoverEndColor(new java.awt.Color(255, 102, 153));
        kbtnResetMR.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kbtnResetMR.setkHoverStartColor(new java.awt.Color(255, 204, 204));
        kbtnResetMR.setkStartColor(new java.awt.Color(255, 102, 102));
        kbtnResetMR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbtnResetMRActionPerformed(evt);
            }
        });

        lbPicture.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        lbPicture.setText("Livin Hotel");

        lbImgContainer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/best-hotels-booking-pool-vacation-wallpaper-preview.jpg"))); // NOI18N
        lbImgContainer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout kGPBackground1Layout = new javax.swing.GroupLayout(kGPBackground1);
        kGPBackground1.setLayout(kGPBackground1Layout);
        kGPBackground1Layout.setHorizontalGroup(
            kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGPBackground1Layout.createSequentialGroup()
                .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(kGPBackground1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGPBackground1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbMRLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(kbtnAddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbRoomTypeM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbRoomNumberM)
                                    .addComponent(lbPriceM)
                                    .addComponent(lbBedM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGPBackground1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGPBackground1Layout.createSequentialGroup()
                                        .addComponent(kbtnDeleteRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(kbtnUpdateRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(kbtnFindRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(kbtnResetMR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfRoomNumberM)
                                        .addComponent(cbRoomTypeM, 0, 200, Short.MAX_VALUE)
                                        .addComponent(cbBedM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfPriceM)))
                                .addGap(228, 228, 228)
                                .addComponent(lbImgContainer))
                            .addGroup(kGPBackground1Layout.createSequentialGroup()
                                .addGap(839, 839, 839)
                                .addComponent(lbPicture)))
                        .addGap(621, 621, 621)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGPBackground1Layout.setVerticalGroup(
            kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGPBackground1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGPBackground1Layout.createSequentialGroup()
                        .addComponent(lbMRLogo)
                        .addGap(13, 13, 13)
                        .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbRoomNumberM)
                            .addComponent(tfRoomNumberM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbRoomTypeM)
                            .addComponent(cbRoomTypeM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGPBackground1Layout.createSequentialGroup()
                                .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbBedM, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbBedM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbPriceM)
                                    .addComponent(tfPriceM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(kbtnResetMR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(kGPBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kbtnAddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kbtnDeleteRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(kbtnUpdateRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(kbtnFindRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(kGPBackground1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbPicture)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbImgContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout cardManageRoomLayout = new javax.swing.GroupLayout(cardManageRoom);
        cardManageRoom.setLayout(cardManageRoomLayout);
        cardManageRoomLayout.setHorizontalGroup(
            cardManageRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGPBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardManageRoomLayout.setVerticalGroup(
            cardManageRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGPBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnMain.add(cardManageRoom, "card3");

        kGPBackground2.setkBorderRadius(0);
        kGPBackground2.setkEndColor(new java.awt.Color(102, 255, 153));
        kGPBackground2.setkGradientFocus(900);
        kGPBackground2.setkStartColor(new java.awt.Color(51, 153, 255));
        kGPBackground2.setPreferredSize(new java.awt.Dimension(1370, 710));

        lbCCILogo.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        lbCCILogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Customer Registration & Check IN.png"))); // NOI18N
        lbCCILogo.setText("Customer Check In");

        lbNameCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNameCCI.setText("Name:");

        tfNameCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbMobileNumCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbMobileNumCCI.setText("Mobile Number:");

        tfMobileNumCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbNationalityCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNationalityCCI.setText("Nationality:");

        tfNationalityCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbGenderCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbGenderCCI.setText("Gender:");

        cbGenderCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbGenderCCI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));

        lbEmailCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEmailCCI.setText("Email:");

        tfEmailCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbIDProofCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbIDProofCCI.setText("ID Proof:");

        tfIDProofCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbAddressCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbAddressCCI.setText("Address:");

        tfAddressCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbCheckINDateCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbCheckINDateCCI.setText("Check IN Date (Today):");

        tfCheckINDateCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbBedCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbBedCCI.setText("Bed:");

        cbBedCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbBedCCI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double", "Triple" }));
        cbBedCCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBedCCIActionPerformed(evt);
            }
        });

        lbRoomTypeCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbRoomTypeCCI.setText("Room Type:");

        cbRoomTypeCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbRoomTypeCCI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "None-AC" }));
        cbRoomTypeCCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRoomTypeCCIActionPerformed(evt);
            }
        });

        lbRoomNumCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbRoomNumCCI.setText("Room Number:");

        cbRoomNumCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbRoomNumCCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRoomNumCCIActionPerformed(evt);
            }
        });

        lbPriceCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPriceCCI.setText("Price:");

        tfPriceCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        kbtnAlloteRoomCCI.setText("Allote Room");
        kbtnAlloteRoomCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kbtnAlloteRoomCCI.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        kbtnAlloteRoomCCI.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kbtnAlloteRoomCCI.setkHoverStartColor(new java.awt.Color(153, 255, 0));
        kbtnAlloteRoomCCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbtnAlloteRoomCCIActionPerformed(evt);
            }
        });

        kbtnClearCCI.setText("Clear");
        kbtnClearCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kbtnClearCCI.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        kbtnClearCCI.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kbtnClearCCI.setkHoverStartColor(new java.awt.Color(153, 255, 0));
        kbtnClearCCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbtnClearCCIActionPerformed(evt);
            }
        });

        kbtnXMLCCI.setText("XML");
        kbtnXMLCCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kbtnXMLCCI.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        kbtnXMLCCI.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kbtnXMLCCI.setkHoverStartColor(new java.awt.Color(153, 255, 0));
        kbtnXMLCCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbtnXMLCCIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGPBackground2Layout = new javax.swing.GroupLayout(kGPBackground2);
        kGPBackground2.setLayout(kGPBackground2Layout);
        kGPBackground2Layout.setHorizontalGroup(
            kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGPBackground2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCCILogo)
                    .addComponent(tfNameCCI)
                    .addComponent(tfMobileNumCCI)
                    .addComponent(tfNationalityCCI)
                    .addComponent(cbGenderCCI, 0, 350, Short.MAX_VALUE)
                    .addComponent(tfEmailCCI)
                    .addComponent(lbNameCCI)
                    .addComponent(lbMobileNumCCI)
                    .addComponent(lbNationalityCCI)
                    .addComponent(lbGenderCCI)
                    .addComponent(lbEmailCCI))
                .addGap(136, 136, 136)
                .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfIDProofCCI)
                    .addComponent(tfAddressCCI)
                    .addComponent(tfCheckINDateCCI, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(lbIDProofCCI)
                    .addComponent(lbAddressCCI)
                    .addComponent(lbCheckINDateCCI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbBedCCI, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbRoomTypeCCI, 0, 350, Short.MAX_VALUE)
                        .addComponent(cbRoomNumCCI, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbPriceCCI, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfPriceCCI)
                        .addComponent(lbRoomTypeCCI)
                        .addComponent(lbBedCCI)
                        .addComponent(lbRoomNumCCI))
                    .addGroup(kGPBackground2Layout.createSequentialGroup()
                        .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(kbtnClearCCI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(kbtnAlloteRoomCCI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(kbtnXMLCCI, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        kGPBackground2Layout.setVerticalGroup(
            kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGPBackground2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbCCILogo)
                .addGap(76, 76, 76)
                .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNameCCI)
                    .addComponent(lbIDProofCCI)
                    .addComponent(lbBedCCI))
                .addGap(18, 18, 18)
                .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfIDProofCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfNameCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbBedCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMobileNumCCI)
                    .addComponent(lbAddressCCI)
                    .addComponent(lbRoomTypeCCI))
                .addGap(18, 18, 18)
                .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMobileNumCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAddressCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRoomTypeCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNationalityCCI)
                    .addComponent(lbCheckINDateCCI)
                    .addComponent(lbRoomNumCCI))
                .addGap(18, 18, 18)
                .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNationalityCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCheckINDateCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRoomNumCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGenderCCI)
                    .addComponent(lbPriceCCI))
                .addGap(18, 18, 18)
                .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGenderCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPriceCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGPBackground2Layout.createSequentialGroup()
                        .addComponent(lbEmailCCI)
                        .addGap(18, 18, 18)
                        .addComponent(tfEmailCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGPBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kbtnAlloteRoomCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kbtnXMLCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(kbtnClearCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardCustomerCheckInLayout = new javax.swing.GroupLayout(cardCustomerCheckIn);
        cardCustomerCheckIn.setLayout(cardCustomerCheckInLayout);
        cardCustomerCheckInLayout.setHorizontalGroup(
            cardCustomerCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCustomerCheckInLayout.createSequentialGroup()
                .addComponent(kGPBackground2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        cardCustomerCheckInLayout.setVerticalGroup(
            cardCustomerCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCustomerCheckInLayout.createSequentialGroup()
                .addComponent(kGPBackground2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnMain.add(cardCustomerCheckIn, "card4");

        cardCustomerCheckOut.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cardCustomerCheckOutComponentShown(evt);
            }
        });

        kGPBackground3.setkBorderRadius(0);
        kGPBackground3.setkEndColor(new java.awt.Color(102, 255, 153));
        kGPBackground3.setkGradientFocus(900);
        kGPBackground3.setkStartColor(new java.awt.Color(51, 153, 255));
        kGPBackground3.setPreferredSize(new java.awt.Dimension(1370, 710));

        lbCCOLogo.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        lbCCOLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Customer Check Out.png"))); // NOI18N
        lbCCOLogo.setText("Customer Check Out");

        lbRoomNumCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbRoomNumCCO.setText("Room Number:");

        tfRoomNumCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        kbtnSearchCCO.setText("Search");
        kbtnSearchCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kbtnSearchCCO.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        kbtnSearchCCO.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kbtnSearchCCO.setkHoverStartColor(new java.awt.Color(153, 255, 0));
        kbtnSearchCCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbtnSearchCCOActionPerformed(evt);
            }
        });

        lbCustomerNameCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbCustomerNameCCO.setText("Customer Name:");

        tfCustomerNameCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbPricePerDayCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPricePerDayCCO.setText("Price Per Day:");

        tfPricePerDayCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbCheckINDateCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbCheckINDateCCO.setText("Check IN Date:");

        tfCheckINDateCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbNumDaysStayCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNumDaysStayCCO.setText("Number Of Days Stay:");

        tfNumDaysStayCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbCheckOUTDateCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbCheckOUTDateCCO.setText("Check OUT Date (Today):");

        tfCheckOUTDateCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbTotalAmountCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTotalAmountCCO.setText("Total Amount to Collect From Customer:");

        tfTotalAmountCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbCustomerMNCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbCustomerMNCCO.setText("Customer Mobile Number:");

        tfCustomerMNCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbEmailCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEmailCCO.setText("Email:");

        tfEmailCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        kbtnCheckOutCCO.setText("Check Out");
        kbtnCheckOutCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kbtnCheckOutCCO.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        kbtnCheckOutCCO.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kbtnCheckOutCCO.setkHoverStartColor(new java.awt.Color(153, 255, 0));
        kbtnCheckOutCCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbtnCheckOutCCOActionPerformed(evt);
            }
        });

        kbtnClearCCO.setText("Clear");
        kbtnClearCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kbtnClearCCO.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        kbtnClearCCO.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kbtnClearCCO.setkHoverStartColor(new java.awt.Color(153, 255, 0));
        kbtnClearCCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbtnClearCCOActionPerformed(evt);
            }
        });

        jtbCustomerCheckOut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile Number", "Nationality", "Gender", "Email", "ID Proof", "Address", "CheckIn Date", "Room Number", "Bed", "Room Type", "Price Per Day"
            }
        ));
        jScrollPane2.setViewportView(jtbCustomerCheckOut);

        kbtnImportCCO.setText("Import XML");
        kbtnImportCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kbtnImportCCO.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        kbtnImportCCO.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kbtnImportCCO.setkHoverStartColor(new java.awt.Color(153, 255, 0));
        kbtnImportCCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbtnImportCCOActionPerformed(evt);
            }
        });

        kbtnviewXMLCCO.setText("Click to view XML file");
        kbtnviewXMLCCO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kbtnviewXMLCCO.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        kbtnviewXMLCCO.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kbtnviewXMLCCO.setkHoverStartColor(new java.awt.Color(153, 255, 0));

        javax.swing.GroupLayout kGPBackground3Layout = new javax.swing.GroupLayout(kGPBackground3);
        kGPBackground3.setLayout(kGPBackground3Layout);
        kGPBackground3Layout.setHorizontalGroup(
            kGPBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGPBackground3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(kGPBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGPBackground3Layout.createSequentialGroup()
                        .addGroup(kGPBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGPBackground3Layout.createSequentialGroup()
                                .addGap(410, 410, 410)
                                .addComponent(lbRoomNumCCO)
                                .addGap(82, 82, 82)
                                .addComponent(tfRoomNumCCO, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(kbtnSearchCCO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(kGPBackground3Layout.createSequentialGroup()
                                .addGroup(kGPBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(kGPBackground3Layout.createSequentialGroup()
                                        .addComponent(kbtnCheckOutCCO, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(kbtnClearCCO, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbCCOLogo)
                                    .addComponent(lbCustomerNameCCO)
                                    .addComponent(tfCustomerNameCCO)
                                    .addComponent(lbPricePerDayCCO)
                                    .addComponent(tfPricePerDayCCO, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(kGPBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfCheckINDateCCO)
                                    .addComponent(tfNumDaysStayCCO, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbCheckINDateCCO)
                                    .addComponent(lbNumDaysStayCCO))
                                .addGap(94, 94, 94)
                                .addGroup(kGPBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCheckOUTDateCCO)
                                    .addComponent(lbTotalAmountCCO)
                                    .addComponent(tfCheckOUTDateCCO, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTotalAmountCCO, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)))
                        .addGroup(kGPBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfEmailCCO, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbCustomerMNCCO)
                            .addComponent(lbEmailCCO)
                            .addComponent(tfCustomerMNCCO, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGPBackground3Layout.createSequentialGroup()
                                .addComponent(kbtnImportCCO, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(kbtnviewXMLCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        kGPBackground3Layout.setVerticalGroup(
            kGPBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGPBackground3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbCCOLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGPBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRoomNumCCO)
                    .addComponent(tfRoomNumCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kbtnSearchCCO, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGPBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCustomerNameCCO)
                    .addComponent(lbCheckINDateCCO)
                    .addComponent(lbCheckOUTDateCCO)
                    .addComponent(lbCustomerMNCCO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGPBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCustomerNameCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCheckINDateCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCheckOUTDateCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCustomerMNCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGPBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPricePerDayCCO)
                    .addComponent(lbNumDaysStayCCO)
                    .addComponent(lbTotalAmountCCO)
                    .addComponent(lbEmailCCO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGPBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPricePerDayCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumDaysStayCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTotalAmountCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEmailCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGPBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kbtnCheckOutCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kbtnClearCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kbtnImportCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kbtnviewXMLCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardCustomerCheckOutLayout = new javax.swing.GroupLayout(cardCustomerCheckOut);
        cardCustomerCheckOut.setLayout(cardCustomerCheckOutLayout);
        cardCustomerCheckOutLayout.setHorizontalGroup(
            cardCustomerCheckOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
            .addGroup(cardCustomerCheckOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cardCustomerCheckOutLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(kGPBackground3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        cardCustomerCheckOutLayout.setVerticalGroup(
            cardCustomerCheckOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
            .addGroup(cardCustomerCheckOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cardCustomerCheckOutLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(kGPBackground3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jpnMain.add(cardCustomerCheckOut, "card5");

        cardCustomerDetailsBill.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cardCustomerDetailsBillComponentShown(evt);
            }
        });

        kGPBackground4.setkBorderRadius(0);
        kGPBackground4.setkEndColor(new java.awt.Color(102, 255, 153));
        kGPBackground4.setkGradientFocus(900);
        kGPBackground4.setkStartColor(new java.awt.Color(51, 153, 255));
        kGPBackground4.setPreferredSize(new java.awt.Dimension(1370, 710));

        lbCDBLogo.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        lbCDBLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Customer Details Bill.png"))); // NOI18N
        lbCDBLogo.setText("Customer Details Bill");

        lbSearchCheckOUTDateCDB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbSearchCheckOUTDateCDB.setText("Search By Check OUT Date:");

        tfSearchCheckOUTDateCDB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        kbtnSearchCDB.setText("Search");
        kbtnSearchCDB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kbtnSearchCDB.setkHoverEndColor(new java.awt.Color(0, 204, 204));
        kbtnSearchCDB.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kbtnSearchCDB.setkHoverStartColor(new java.awt.Color(153, 255, 0));
        kbtnSearchCDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbtnSearchCDBActionPerformed(evt);
            }
        });

        jtbCustomerDetailsBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile Number", "Nationality", "Gender", "Email", "IDProof", "Address", "Check IN Date", "Room Number", "Bed", "Room Type", "Price Per Day", "Number Of Days Stay", "Total Amount", "Check OUT Date"
            }
        ));
        jtbCustomerDetailsBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCustomerDetailsBillMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtbCustomerDetailsBill);

        lbClickCDB.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        lbClickCDB.setText("*Click on Table Row to Open bill ");

        javax.swing.GroupLayout kGPBackground4Layout = new javax.swing.GroupLayout(kGPBackground4);
        kGPBackground4.setLayout(kGPBackground4Layout);
        kGPBackground4Layout.setHorizontalGroup(
            kGPBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGPBackground4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbSearchCheckOUTDateCDB)
                .addGap(62, 62, 62)
                .addComponent(tfSearchCheckOUTDateCDB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(kbtnSearchCDB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(369, 369, 369))
            .addGroup(kGPBackground4Layout.createSequentialGroup()
                .addGroup(kGPBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGPBackground4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(kGPBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCDBLogo)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGPBackground4Layout.createSequentialGroup()
                        .addGap(458, 458, 458)
                        .addComponent(lbClickCDB)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        kGPBackground4Layout.setVerticalGroup(
            kGPBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGPBackground4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbCDBLogo)
                .addGap(18, 18, 18)
                .addGroup(kGPBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSearchCheckOUTDateCDB)
                    .addComponent(tfSearchCheckOUTDateCDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kbtnSearchCDB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(lbClickCDB)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout cardCustomerDetailsBillLayout = new javax.swing.GroupLayout(cardCustomerDetailsBill);
        cardCustomerDetailsBill.setLayout(cardCustomerDetailsBillLayout);
        cardCustomerDetailsBillLayout.setHorizontalGroup(
            cardCustomerDetailsBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
            .addGroup(cardCustomerDetailsBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cardCustomerDetailsBillLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(kGPBackground4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        cardCustomerDetailsBillLayout.setVerticalGroup(
            cardCustomerDetailsBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
            .addGroup(cardCustomerDetailsBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cardCustomerDetailsBillLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(kGPBackground4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jpnMain.add(cardCustomerDetailsBill, "card6");

        jpnContainer.add(jpnMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1370, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbOpenMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOpenMenuMouseClicked
        // TODO add your handling code here:
        openMenubar();
    }//GEN-LAST:event_lbOpenMenuMouseClicked

    private void lbCloseMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMenuMouseClicked
        // TODO add your handling code here:
        closeMenubar();
    }//GEN-LAST:event_lbCloseMenuMouseClicked

    private void lbManageRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbManageRoomMouseClicked
        // TODO add your handling code here:
        cardTrangchu.setVisible(false);
        cardManageRoom.setVisible(true);
        cardCustomerCheckIn.setVisible(false);
        cardCustomerCheckOut.setVisible(false);
        cardCustomerDetailsBill.setVisible(false);
    }//GEN-LAST:event_lbManageRoomMouseClicked

    private void lbCustomerCheckInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCustomerCheckInMouseClicked
        // TODO add your handling code here:
        cardTrangchu.setVisible(false);
        cardManageRoom.setVisible(false);
        cardCustomerCheckIn.setVisible(true);
        cardCustomerCheckOut.setVisible(false);
        cardCustomerDetailsBill.setVisible(false);
    }//GEN-LAST:event_lbCustomerCheckInMouseClicked

    private void lbHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHomePageMouseClicked
        // TODO add your handling code here:
        cardTrangchu.setVisible(true);
        cardManageRoom.setVisible(false);
        cardCustomerCheckOut.setVisible(false);
        cardCustomerCheckIn.setVisible(false);
        cardCustomerDetailsBill.setVisible(false);
    }//GEN-LAST:event_lbHomePageMouseClicked

    private void kbtnAddRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbtnAddRoomActionPerformed
        // TODO add your handling code here:
        String roomNo = tfRoomNumberM.getText();
        String roomType = (String) cbRoomTypeM.getSelectedItem();
        String bed = (String) cbBedM.getSelectedItem();
        String price = tfPriceM.getText();

        // Kiểm tra các giá trị trống hoặc null
        if (roomNo.isEmpty() || roomType == null || bed == null || price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Incomplete Information", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra tính hợp lệ của giá trị price
        int priceText = 0;
        try {
            priceText = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid integer for price.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return; // Dừng lại nếu giá trị không hợp lệ
        }

        // Nếu tất cả các giá trị đều hợp lệ, thực hiện truy vấn SQL
        String Query = "INSERT INTO room VALUES('" + roomNo + "', '" + roomType + "', '" + bed + "', '" + priceText + "', 'Not Booked')";
        InsertUpdateDelete.setData(Query, "Successfully Updated");

        // Làm mới dữ liệu trên bảng sau khi thêm phòng thành công
        refreshRoomTable();

        // Chuyển sang card quản lý phòng
        CardLayout cardLayout = (CardLayout) jpnMain.getLayout();
        cardLayout.show(jpnMain, "cardManageRoom");
    }//GEN-LAST:event_kbtnAddRoomActionPerformed

    private void cardManageRoomComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cardManageRoomComponentShown
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jtbManageRoom.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trong bảng
        ResultSet rs = Select.getData("select * from room");
        try {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cardManageRoomComponentShown

    private void kbtnClearCCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbtnClearCCIActionPerformed
        // TODO add your handling code here:
        tfNameCCI.setText("");
        tfMobileNumCCI.setText("");
        tfNationalityCCI.setText("");
        tfEmailCCI.setText("");
        tfIDProofCCI.setText("");
        tfAddressCCI.setText("");
//    tfCheckINDateCCI.setText("");
        tfPriceCCI.setText("");

        // Đảm bảo rằng JComboBox có mục trước khi đặt chỉ mục
        if (cbGenderCCI.getItemCount() > 0) {
            cbGenderCCI.setSelectedIndex(0);
        }
        if (cbBedCCI.getItemCount() > 0) {
            cbBedCCI.setSelectedIndex(0);
        }
        if (cbRoomTypeCCI.getItemCount() > 0) {
            cbRoomTypeCCI.setSelectedIndex(0);
        }
        if (cbRoomNumCCI.getItemCount() > 0) {
            cbRoomNumCCI.setSelectedIndex(0);
        }

        CardLayout cardLayout = (CardLayout) jpnMain.getLayout();
        cardLayout.show(jpnMain, "cardCustomerCheckIn");
    }//GEN-LAST:event_kbtnClearCCIActionPerformed

    private void cbBedCCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBedCCIActionPerformed
        // TODO add your handling code here:
        roomDetails();
    }//GEN-LAST:event_cbBedCCIActionPerformed

    private void cbRoomTypeCCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRoomTypeCCIActionPerformed
        // TODO add your handling code here:
        roomDetails();
    }//GEN-LAST:event_cbRoomTypeCCIActionPerformed

    private void cbRoomNumCCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRoomNumCCIActionPerformed
        // TODO add your handling code here:
        roomNo = (String) cbRoomNumCCI.getSelectedItem();
        try {
            ResultSet rs = Select.getData("select * from room where roomNo = '" + roomNo + "'");
            while (rs.next()) {
                tfPriceCCI.setText(rs.getString(4));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cbRoomNumCCIActionPerformed

    private void kbtnAlloteRoomCCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbtnAlloteRoomCCIActionPerformed
        // TODO add your handling code here:
        // Kiểm tra các ô để đảm bảo người dùng đã điền thông tin vào tất cả các ô
        if (tfNameCCI.getText().isEmpty() || tfMobileNumCCI.getText().isEmpty()
                || tfNationalityCCI.getText().isEmpty() || tfEmailCCI.getText().isEmpty()
                || tfIDProofCCI.getText().isEmpty() || tfAddressCCI.getText().isEmpty()
                || tfCheckINDateCCI.getText().isEmpty() || tfPriceCCI.getText().isEmpty()
                || cbGenderCCI.getSelectedItem() == null || cbBedCCI.getSelectedItem() == null
                || cbRoomTypeCCI.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin và chọn phòng trước khi thêm khách hàng mới!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return; // Dừng lại nếu có ô nào bị trống hoặc chưa chọn phòng
        }

        // Kiểm tra riêng nếu người dùng chưa chọn phòng
        if (cbRoomNumCCI.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng trước khi thêm khách hàng mới!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return; // Dừng lại nếu chưa chọn phòng
        }
        int id = 1;
        String name = tfNameCCI.getText();
        String mobileNumber = tfMobileNumCCI.getText();
        String nationality = tfNationalityCCI.getText();
        String gender = (String) cbGenderCCI.getSelectedItem();
        String email = tfEmailCCI.getText();
        String idProof = tfIDProofCCI.getText();
        String address = tfAddressCCI.getText();
        String checkIN = tfCheckINDateCCI.getText();
        String bed = (String) cbBedCCI.getSelectedItem();
        String roomType = (String) cbRoomTypeCCI.getSelectedItem();
        String roomNo = (String) cbRoomNumCCI.getSelectedItem();
        String price = tfPriceCCI.getText();
        String Query = "select max(id) from customer";
        try {
            ResultSet rs = Select.getData(Query);
            while (rs.next()) {
                id = rs.getInt(1);
            }
            id = id + 1;

            if (!price.equals("")) {
                Query = "update room set status = 'Booked' where roomNo = '" + roomNo + "'";
                InsertUpdateDelete.setData(Query, "");
                Query = "insert into customer(id, name, mobileNumber, nationality, gender, email, idProof, address, checkIn, roomNo, bed, roomType, pricePerDay) values(" + id + ", '" + name + "','" + mobileNumber + "', '" + nationality + "', '" + gender + "', '" + email + "', '" + idProof + "', '" + address + "', '" + checkIN + "', '" + roomNo + "', '" + bed + "', '" + roomType + "', '" + price + "')";
                InsertUpdateDelete.setData(Query, "Customer Check IN Successfully");

                CardLayout cardLayout = (CardLayout) jpnMain.getLayout();
                cardLayout.show(jpnMain, "cardCustomerCheckIn");
//                setVisible(false);
//                new CustomerCheckIn().setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_kbtnAlloteRoomCCIActionPerformed

    private void cardCustomerCheckOutComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cardCustomerCheckOutComponentShown
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jtbCustomerCheckOut.getModel();
        model.setRowCount(0);
        ResultSet rs = Select.getData("select * from customer where checkOut is NULL");
        try {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)});
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cardCustomerCheckOutComponentShown

    private void kbtnSearchCCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbtnSearchCCOActionPerformed
        // TODO add your handling code here:
        String roomNo = tfRoomNumCCO.getText();
        try {
            ResultSet rs = Select.getData("select * from customer where roomNo = '" + roomNo + "' and checkout is NULL");
            if (rs.next()) {
                tfRoomNumCCO.setEditable(false);
                id = rs.getInt(1);
                tfCustomerNameCCO.setText(rs.getString(2));
                tfCheckINDateCCO.setText(rs.getString(9));
                tfCustomerMNCCO.setText(rs.getString(3));
                tfPricePerDayCCO.setText(rs.getString(13));

                SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
                Calendar cal = Calendar.getInstance();
                tfCheckOUTDateCCO.setText(myFormat.format(cal.getTime()));
                String dateBeforeString = rs.getString(9);
                java.util.Date dateBefore = myFormat.parse(dateBeforeString);
                String dateAfterString = myFormat.format(cal.getTime());
                java.util.Date dateAfter = myFormat.parse(dateAfterString);
                long difference = dateAfter.getTime() - dateBefore.getTime();
                int noOfDayStay = (int) (difference / (1000 * 60 * 60 * 24));
                if (noOfDayStay == 0) {
                    noOfDayStay = 1;
                }
                tfNumDaysStayCCO.setText(String.valueOf(noOfDayStay));
                float price = Float.parseFloat(tfPricePerDayCCO.getText());

                tfTotalAmountCCO.setText(String.valueOf(noOfDayStay * price));
                tfEmailCCO.setText(rs.getString(6));
                roomType = rs.getString(12);
                bed = rs.getString(11);
            } else {
                JOptionPane.showMessageDialog(null, "Room Number is not Booked or Room Number does not Exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_kbtnSearchCCOActionPerformed

    private void kbtnClearCCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbtnClearCCOActionPerformed
        // TODO add your handling code here:
        tfRoomNumCCO.setEditable(true);
        tfRoomNumCCO.setText("");
        tfCustomerNameCCO.setText("");
        tfCheckINDateCCO.setText("");
        tfCheckOUTDateCCO.setText("");
        tfCustomerMNCCO.setText("");
        tfPricePerDayCCO.setText("");
        tfNumDaysStayCCO.setText("");
        tfTotalAmountCCO.setText("");
        tfEmailCCO.setText("");

        CardLayout cardLayout = (CardLayout) jpnMain.getLayout();
        cardLayout.show(jpnMain, "cardCustomerCheckOut");
//        setVisible(false);
//        new CustomerCheckOut().setVisible(true);
    }//GEN-LAST:event_kbtnClearCCOActionPerformed

    private void kbtnCheckOutCCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbtnCheckOutCCOActionPerformed
        // TODO add your handling code here:
        String name = tfCustomerNameCCO.getText();
        String mobileNumber = tfCustomerMNCCO.getText();
        String email = tfEmailCCO.getText();

        String checkOut = tfCheckOUTDateCCO.getText();
        String numberOfDaysStay = tfNumDaysStayCCO.getText();
        String totalAmount = tfTotalAmountCCO.getText();
        roomNo = tfRoomNumCCO.getText();

        // Kiểm tra các giá trị trống hoặc null
        if (name.isEmpty() || mobileNumber.isEmpty() || email.isEmpty() || checkOut.isEmpty()
                || numberOfDaysStay.isEmpty() || totalAmount.isEmpty() || roomNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the room number to Check out", "Incomplete Information", JOptionPane.ERROR_MESSAGE);
            return; // Dừng lại nếu có trường trống
        }
        Query = "update customer set numberOfDaysStay = '" + numberOfDaysStay + "', totalAmount = '" + totalAmount + "', checkOut = '" + checkOut + "' where id = '" + id + "'";
        InsertUpdateDelete.setData(Query, "");
        Query = "update room set Status = 'Not Booked' where roomNo = '" + roomNo + "'";
        InsertUpdateDelete.setData(Query, "");

        String path = "D:\\";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "" + id + ".pdf"));
            doc.open();
            Paragraph paragraph1 = new Paragraph("                                                                  LIVIN Hotel\n");
            doc.add(paragraph1);
            Paragraph paragraph2 = new Paragraph("****************************************************************************************************************");
            doc.add(paragraph2);
            Paragraph paragraph3 = new Paragraph("\tBill ID: " + id + "\nCustomer Details:\nName: " + name + "\nMobile Number: " + mobileNumber + "\nEmail: " + email + "\n");
            doc.add(paragraph3);
            doc.add(paragraph2);
            Paragraph paragraph4 = new Paragraph("\tRoom Details:\nNumber: " + tfRoomNumCCO.getText() + "\nType: " + roomType + "\nBed: " + bed + "\nPrice Per Day: " + tfPricePerDayCCO.getText() + "");
            doc.add(paragraph4);
            doc.add(paragraph2);
            PdfPTable tb1 = new PdfPTable(4);
            tb1.addCell("Check IN Date: " + tfCheckINDateCCO.getText());
            tb1.addCell("Check OUT Date: " + checkOut);
            tb1.addCell("No of Days Stay: " + numberOfDaysStay);
            tb1.addCell("Total Amount Paid: " + totalAmount);
            doc.add(tb1);
            doc.add(paragraph2);
            Paragraph paragraph5 = new Paragraph("Thank You, See you again.");
            doc.add(paragraph5);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        doc.close();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to Print Bill", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            try {
                if ((new File("D:\\" + id + ".pdf")).exists()) {
                    Process p = Runtime
                            .getRuntime()
                            .exec("rundll32 url.dll, FileProtocolHandler D:\\" + id + ".pdf");
                } else {
                    System.out.println("File is not Exists");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

        refreshRoomTable();
        CardLayout cardLayout = (CardLayout) jpnMain.getLayout();
        cardLayout.show(jpnMain, "cardCustomerCheckOut");
//        setVisible(false);
//        new CustomerCheckOut().setVisible(true);
    }//GEN-LAST:event_kbtnCheckOutCCOActionPerformed

    private void lbCustomerCheckOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCustomerCheckOutMouseClicked
        // TODO add your handling code here:
        cardTrangchu.setVisible(false);
        cardManageRoom.setVisible(false);
        cardCustomerCheckIn.setVisible(false);
        cardCustomerCheckOut.setVisible(true);
        cardCustomerDetailsBill.setVisible(false);
    }//GEN-LAST:event_lbCustomerCheckOutMouseClicked

    private void cardCustomerDetailsBillComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cardCustomerDetailsBillComponentShown
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jtbCustomerDetailsBill.getModel();
        model.setRowCount(0);
        ResultSet rs = Select.getData("select * from customer where checkOut is not NULL");
        try {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)});
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cardCustomerDetailsBillComponentShown

    private void kbtnSearchCDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbtnSearchCDBActionPerformed
        // TODO add your handling code here:
        String checkoutDate = tfSearchCheckOUTDateCDB.getText();
        ResultSet rs = Select.getData("select * from customer where checkOut = '" + checkoutDate + "'");
        DefaultTableModel model = (DefaultTableModel) jtbCustomerDetailsBill.getModel();
        model.setRowCount(0);
        try {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)});
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_kbtnSearchCDBActionPerformed

    private void jtbCustomerDetailsBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCustomerDetailsBillMouseClicked
        // TODO add your handling code here:
        int index = jtbCustomerDetailsBill.getSelectedRow();
        TableModel model = jtbCustomerDetailsBill.getModel();
        String id = model.getValueAt(index, 0).toString();
        try {
            if ((new File("D:\\" + id + ".pdf")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll, FileProtocolHandler D:\\" + id + ".pdf");
            } else {
                JOptionPane.showMessageDialog(null, "File is not Exists");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jtbCustomerDetailsBillMouseClicked

    private void lbCustomerDetailsBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCustomerDetailsBillMouseClicked
        // TODO add your handling code here:
        cardTrangchu.setVisible(false);
        cardManageRoom.setVisible(false);
        cardCustomerCheckIn.setVisible(false);
        cardCustomerCheckOut.setVisible(false);
        cardCustomerDetailsBill.setVisible(true);
    }//GEN-LAST:event_lbCustomerDetailsBillMouseClicked

    private void lbLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoutMouseClicked
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            setVisible(false);
            new login().setVisible(true);
        }
    }//GEN-LAST:event_lbLogoutMouseClicked

    private void jtbManageRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbManageRoomMouseClicked
        // TODO add your handling code here:
        // Lấy chỉ số hàng được chọn
        int selectedRow = jtbManageRoom.getSelectedRow();
        // Kiểm tra xem có hàng được chọn không
        if (selectedRow >= 0) {
            // Lấy dữ liệu từ các cột của hàng được chọn
            String roomNo = jtbManageRoom.getValueAt(selectedRow, 0).toString();
            // Thực hiện truy vấn cơ sở dữ liệu để lấy thông tin chi tiết của phòng
            String query = "SELECT * FROM room WHERE RoomNo='" + roomNo + "'";
            ResultSet rs = Select.getData(query);
            try {
                if (rs.next()) {
                    // Hiển thị thông tin chi tiết của phòng
                    tfRoomNumberM.setText(rs.getString(1)); // Room Number
                    cbRoomTypeM.setSelectedItem(rs.getString(2)); // Room Type
                    cbBedM.setSelectedItem(rs.getString(3)); // Bed
                    tfPriceM.setText(rs.getString(4)); // Price
                }
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jtbManageRoomMouseClicked

    private void kbtnResetMRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbtnResetMRActionPerformed
        // TODO add your handling code here:
        // Xóa dữ liệu trong các trường TextField và ComboBox
        tfRoomNumberM.setText("");
        cbRoomTypeM.setSelectedIndex(0);
        cbBedM.setSelectedIndex(0);
        tfPriceM.setText("");

        // Cập nhật lại dữ liệu trong bảng jTable1
        DefaultTableModel model = (DefaultTableModel) jtbManageRoom.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng trong bảng

        // Thực hiện truy vấn cơ sở dữ liệu để lấy lại dữ liệu mới cho bảng
        ResultSet rs = Select.getData("select * from room");
        try {
            while (rs.next()) {
                // Thêm dữ liệu vào table model mà không liên quan tới hình ảnh
                model.addRow(new Object[]{
                    rs.getString(1), // roomNo
                    rs.getString(2), // roomType
                    rs.getString(3), // bed
                    rs.getInt(4), // price
                    rs.getString(5),});
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_kbtnResetMRActionPerformed

    private void kbtnDeleteRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbtnDeleteRoomActionPerformed
        // TODO add your handling code here:
        // Lấy số phòng được chọn trong bảng
        int selectedRow = jtbManageRoom.getSelectedRow();
        if (selectedRow >= 0) {
            // Lấy số phòng từ hàng được chọn
            String roomNo = jtbManageRoom.getValueAt(selectedRow, 0).toString();
            // Xác nhận việc xóa phòng
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete room " + roomNo + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Nếu người dùng đồng ý, thực hiện xóa dữ liệu từ cơ sở dữ liệu
                String query = "DELETE FROM room WHERE RoomNo='" + roomNo + "'";
                InsertUpdateDelete.setData(query, "Room deleted successfully");
                // Cập nhật lại giao diện
                refreshRoomTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a room to delete.", "No Room Selected", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_kbtnDeleteRoomActionPerformed

    private void kbtnUpdateRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbtnUpdateRoomActionPerformed
        // TODO add your handling code here:
        // Lấy thông tin phòng từ các trường dữ liệu
        String roomNo = tfRoomNumberM.getText().trim();
        String roomType = (String) cbRoomTypeM.getSelectedItem();
        String bed = (String) cbBedM.getSelectedItem();
        String priceText = tfPriceM.getText().trim();

        // Kiểm tra tính hợp lệ của giá trị price
        int price = 0;
        try {
            price = Integer.parseInt(priceText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid integer for price.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return; // Dừng lại nếu giá trị không hợp lệ
        }

        // Câu lệnh SQL để cập nhật dữ liệu phòng
        String query = "UPDATE room SET roomType='" + roomType + "', bed='" + bed + "', price=" + price + " WHERE RoomNo='" + roomNo + "'";
        InsertUpdateDelete.setData(query, "Room updated successfully");

        // Cập nhật lại giao diện
        refreshRoomTable();
    }//GEN-LAST:event_kbtnUpdateRoomActionPerformed

    private void kbtnFindRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbtnFindRoomActionPerformed
        // TODO add your handling code here:
        // Lấy số phòng nhập vào từ TextField
        String roomNo = tfRoomNumberM.getText().trim();
        // Kiểm tra xem người dùng đã nhập số phòng hay chưa
        if (!roomNo.isEmpty()) {
            // Xóa tất cả các hàng trong bảng
            DefaultTableModel model = (DefaultTableModel) jtbManageRoom.getModel();
            model.setRowCount(0);
            // Thực hiện truy vấn cơ sở dữ liệu để tìm kiếm phòng
            String query = "SELECT * FROM room WHERE RoomNo='" + roomNo + "'";
            ResultSet rs = Select.getData(query);
            try {
                if (rs.next()) {
                    // Hiển thị thông tin chi tiết của phòng
                    cbRoomTypeM.setSelectedItem(rs.getString("roomType")); // Room Type
                    cbBedM.setSelectedItem(rs.getString("bed")); // Bed
                    tfPriceM.setText(rs.getString("price")); // Price

                    // Thêm hàng tìm thấy vào bảng
                    model.addRow(new Object[]{
                        rs.getString("roomNo"),
                        rs.getString("roomType"),
                        rs.getString("bed"),
                        rs.getInt("price"),
                        rs.getString("status")
                    });
                } else {
                    JOptionPane.showMessageDialog(this, "Room not found.", "Not Found", JOptionPane.WARNING_MESSAGE);
                }
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter room number to find.", "Empty Field", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_kbtnFindRoomActionPerformed

    private void kbtnXMLCCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbtnXMLCCIActionPerformed
        // TODO add your handling code here:
        try {
            // Đường dẫn tới tệp XML
            File xmlFile = new File("C:\\Users\\ACER\\OneDrive\\Documents\\NetBeansProjects\\LIVINHotel\\src\\XML\\usershotel.xml");
            Document document;

            // Lấy dữ liệu từ các JTextField
            String name = tfNameCCI.getText();
            String mobileNumber = tfMobileNumCCI.getText();
            String nationality = tfNationalityCCI.getText();
            String gender = (String) cbGenderCCI.getSelectedItem();
            String email = tfEmailCCI.getText();
            String idProof = tfIDProofCCI.getText();
            String address = tfAddressCCI.getText();
            String checkIN = tfCheckINDateCCI.getText();
            String bed = (String) cbBedCCI.getSelectedItem();
            String roomType = (String) cbRoomTypeCCI.getSelectedItem();
            String roomNo = (String) cbRoomNumCCI.getSelectedItem();
            String price = tfPriceCCI.getText();

            if (xmlFile.exists()) {
                // Nếu tệp đã tồn tại, load tài liệu XML từ tệp đó
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                document = docBuilder.parse(xmlFile);

                // Tìm phần tử gốc <users>
                Element usersElement = (Element) document.getElementsByTagName("users").item(0);

                // Tạo các phần tử con và gắn chúng vào phần tử gốc
                Element userElement = document.createElement("user");
                usersElement.appendChild(userElement);

                createElement(document, userElement, "name", name);
                createElement(document, userElement, "mobileNumber", mobileNumber);
                createElement(document, userElement, "nationality", nationality);
                createElement(document, userElement, "gender", gender);
                createElement(document, userElement, "email", email);
                createElement(document, userElement, "idProof", idProof);
                createElement(document, userElement, "address", address);
                createElement(document, userElement, "checkIN", checkIN);
                createElement(document, userElement, "bed", bed);
                createElement(document, userElement, "roomType", roomType);
                createElement(document, userElement, "roomNo", roomNo);
                createElement(document, userElement, "price", price);
            } else {
                // Nếu tệp chưa tồn tại, tạo một tài liệu XML mới và thêm dữ liệu vào đó
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                document = docBuilder.newDocument();

                // Tạo phần tử gốc <users>
                Element usersElement = document.createElement("users");
                document.appendChild(usersElement);

                // Tạo các phần tử con và gắn chúng vào phần tử gốc
                Element userElement = document.createElement("user");
                usersElement.appendChild(userElement);

                createElement(document, userElement, "name", name);
                createElement(document, userElement, "mobileNumber", mobileNumber);
                createElement(document, userElement, "nationality", nationality);
                createElement(document, userElement, "gender", gender);
                createElement(document, userElement, "email", email);
                createElement(document, userElement, "idProof", idProof);
                createElement(document, userElement, "address", address);
                createElement(document, userElement, "checkIN", checkIN);
                createElement(document, userElement, "bed", bed);
                createElement(document, userElement, "roomType", roomType);
                createElement(document, userElement, "roomNo", roomNo);
                createElement(document, userElement, "price", price);
            }

            // Tạo một đối tượng Transformer để ghi tài liệu XML đã cập nhật hoặc mới vào tệp
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Ghi tài liệu XML vào tệp
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);

            // Thông báo khi lưu thành công
            JOptionPane.showMessageDialog(null, "Data saved to XML successfully!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

// Phương thức tạo và gắn phần tử con vào phần tử cha
    private void createElement(Document document, Element parent, String tagName, String textContent) {
        Element element = document.createElement(tagName);
        element.appendChild(document.createTextNode(textContent));
        parent.appendChild(element);
    }//GEN-LAST:event_kbtnXMLCCIActionPerformed

    private void kbtnImportCCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbtnImportCCOActionPerformed
        // TODO add your handling code here:
         try {
        // Sử dụng JFileChooser để chọn tệp XML
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn tệp XML để import");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("XML files", "xml"));

        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File xmlFile = fileChooser.getSelectedFile();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(xmlFile);

            // Tìm phần tử gốc <users>
            Element usersElement = (Element) document.getElementsByTagName("users").item(0);
            NodeList userList = usersElement.getElementsByTagName("user");

            // Tạo cột cho bảng
            String[] columnNames = {
                "Name", "Mobile Number", "Nationality", "Gender", 
                "Email", "ID Proof", "Address", "Check-IN", 
                "Bed", "Room Type", "Room Number", "Price"
            };
            Object[][] data = new Object[userList.getLength()][12];

            // Lặp qua các phần tử <user> và thêm dữ liệu vào mảng data
            for (int i = 0; i < userList.getLength(); i++) {
                Element userElement = (Element) userList.item(i);

                data[i][0] = getElementTextContent(userElement, "name");
                data[i][1] = getElementTextContent(userElement, "mobileNumber");
                data[i][2] = getElementTextContent(userElement, "nationality");
                data[i][3] = getElementTextContent(userElement, "gender");
                data[i][4] = getElementTextContent(userElement, "email");
                data[i][5] = getElementTextContent(userElement, "idProof");
                data[i][6] = getElementTextContent(userElement, "address");
                data[i][7] = getElementTextContent(userElement, "checkIN");
                data[i][8] = getElementTextContent(userElement, "bed");
                data[i][9] = getElementTextContent(userElement, "roomType");
                data[i][10] = getElementTextContent(userElement, "roomNo");
                data[i][11] = getElementTextContent(userElement, "price");
            }

            // Tạo mô hình bảng với dữ liệu
            DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
            jtbCustomerCheckOut.setModel(tableModel);

            // Hiển thị thông báo khi nhập dữ liệu thành công
            JOptionPane.showMessageDialog(null, "Data imported from XML successfully!");
            } else {
            // Người dùng đã hủy bỏ chọn tệp
            JOptionPane.showMessageDialog(this, "Import canceled.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error reading XML file.", "Error", JOptionPane.ERROR_MESSAGE);
    }
} 

private String getElementTextContent(Element parent, String tagName) {
    NodeList nodeList = parent.getElementsByTagName(tagName);
    if (nodeList.getLength() > 0) {
        Node node = nodeList.item(0);
        if (node != null) {
            return node.getTextContent();
        }
    }
    return ""; // Return an empty string if the element or its content is missing
    }//GEN-LAST:event_kbtnImportCCOActionPerformed

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardCustomerCheckIn;
    private javax.swing.JPanel cardCustomerCheckOut;
    private javax.swing.JPanel cardCustomerDetailsBill;
    private javax.swing.JPanel cardManageRoom;
    private javax.swing.JPanel cardTrangchu;
    private javax.swing.JComboBox<String> cbBedCCI;
    private javax.swing.JComboBox<String> cbBedM;
    private javax.swing.JComboBox<String> cbGenderCCI;
    private javax.swing.JComboBox<String> cbRoomNumCCI;
    private javax.swing.JComboBox<String> cbRoomTypeCCI;
    private javax.swing.JComboBox<String> cbRoomTypeM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpnContainer;
    private javax.swing.JPanel jpnMain;
    private javax.swing.JPanel jpnMenuBar;
    private javax.swing.JPanel jpnSlideMenu;
    private javax.swing.JTable jtbCustomerCheckOut;
    private javax.swing.JTable jtbCustomerDetailsBill;
    private javax.swing.JTable jtbManageRoom;
    private com.k33ptoo.components.KGradientPanel kGPBackground1;
    private com.k33ptoo.components.KGradientPanel kGPBackground2;
    private com.k33ptoo.components.KGradientPanel kGPBackground3;
    private com.k33ptoo.components.KGradientPanel kGPBackground4;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private com.k33ptoo.components.KButton kbtnAddRoom;
    private com.k33ptoo.components.KButton kbtnAlloteRoomCCI;
    private com.k33ptoo.components.KButton kbtnCheckOutCCO;
    private com.k33ptoo.components.KButton kbtnClearCCI;
    private com.k33ptoo.components.KButton kbtnClearCCO;
    private com.k33ptoo.components.KButton kbtnDeleteRoom;
    private com.k33ptoo.components.KButton kbtnFindRoom;
    private com.k33ptoo.components.KButton kbtnImportCCO;
    private com.k33ptoo.components.KButton kbtnResetMR;
    private com.k33ptoo.components.KButton kbtnSearchCCO;
    private com.k33ptoo.components.KButton kbtnSearchCDB;
    private com.k33ptoo.components.KButton kbtnUpdateRoom;
    private com.k33ptoo.components.KButton kbtnXMLCCI;
    private com.k33ptoo.components.KButton kbtnviewXMLCCO;
    private javax.swing.JLabel lbAddressCCI;
    private javax.swing.JLabel lbBedCCI;
    private javax.swing.JLabel lbBedM;
    private javax.swing.JLabel lbCCILogo;
    private javax.swing.JLabel lbCCOLogo;
    private javax.swing.JLabel lbCDBLogo;
    private javax.swing.JLabel lbCheckINDateCCI;
    private javax.swing.JLabel lbCheckINDateCCO;
    private javax.swing.JLabel lbCheckOUTDateCCO;
    private javax.swing.JLabel lbClickCDB;
    private javax.swing.JLabel lbCloseMenu;
    private javax.swing.JLabel lbCustomerCheckIn;
    private javax.swing.JLabel lbCustomerCheckOut;
    private javax.swing.JLabel lbCustomerDetailsBill;
    private javax.swing.JLabel lbCustomerMNCCO;
    private javax.swing.JLabel lbCustomerNameCCO;
    private javax.swing.JLabel lbEmailCCI;
    private javax.swing.JLabel lbEmailCCO;
    private javax.swing.JLabel lbGenderCCI;
    private javax.swing.JLabel lbHomePage;
    private javax.swing.JLabel lbIDProofCCI;
    private javax.swing.JLabel lbImgContainer;
    private javax.swing.JLabel lbLogout;
    private javax.swing.JLabel lbMRLogo;
    private javax.swing.JLabel lbManageRoom;
    private javax.swing.JLabel lbMobileNumCCI;
    private javax.swing.JLabel lbNameCCI;
    private javax.swing.JLabel lbNationalityCCI;
    private javax.swing.JLabel lbNumDaysStayCCO;
    private javax.swing.JLabel lbOpenMenu;
    private javax.swing.JLabel lbPicture;
    private javax.swing.JLabel lbPriceCCI;
    private javax.swing.JLabel lbPriceM;
    private javax.swing.JLabel lbPricePerDayCCO;
    private javax.swing.JLabel lbRoomNumCCI;
    private javax.swing.JLabel lbRoomNumCCO;
    private javax.swing.JLabel lbRoomNumberM;
    private javax.swing.JLabel lbRoomTypeCCI;
    private javax.swing.JLabel lbRoomTypeM;
    private javax.swing.JLabel lbSearchCheckOUTDateCDB;
    private javax.swing.JLabel lbTotalAmountCCO;
    private javax.swing.JTextField tfAddressCCI;
    private javax.swing.JTextField tfCheckINDateCCI;
    private javax.swing.JTextField tfCheckINDateCCO;
    private javax.swing.JTextField tfCheckOUTDateCCO;
    private javax.swing.JTextField tfCustomerMNCCO;
    private javax.swing.JTextField tfCustomerNameCCO;
    private javax.swing.JTextField tfEmailCCI;
    private javax.swing.JTextField tfEmailCCO;
    private javax.swing.JTextField tfIDProofCCI;
    private javax.swing.JTextField tfMobileNumCCI;
    private javax.swing.JTextField tfNameCCI;
    private javax.swing.JTextField tfNationalityCCI;
    private javax.swing.JTextField tfNumDaysStayCCO;
    private javax.swing.JTextField tfPriceCCI;
    private javax.swing.JTextField tfPriceM;
    private javax.swing.JTextField tfPricePerDayCCO;
    private javax.swing.JTextField tfRoomNumCCO;
    private javax.swing.JTextField tfRoomNumberM;
    private javax.swing.JTextField tfSearchCheckOUTDateCDB;
    private javax.swing.JTextField tfTotalAmountCCO;
    // End of variables declaration//GEN-END:variables
}
