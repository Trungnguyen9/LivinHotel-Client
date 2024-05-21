/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Class để thực hiện các thao tác Insert, Update, Delete trên database.
 */
public class InsertUpdateDelete {
    public static void setData(String query, String msg) {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionProvider.getCon();
            if (con != null) {
                st = con.createStatement();
                st.executeUpdate(query);
                if (!msg.equals("")) {
                    JOptionPane.showMessageDialog(null, msg);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Connection failed.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}