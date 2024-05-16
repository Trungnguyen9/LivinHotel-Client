/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contact;

/**
 *
 * @author ASUS
 */
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatClient extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private PrintWriter out;

    public ChatClient(String serverAddress) {
        // Thiết lập giao diện
        setTitle("Chat Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        inputField = new JTextField();
        add(inputField, BorderLayout.SOUTH);

        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                chatArea.append("Bạn: " + message + "\n");
                out.println(message);
                inputField.setText("");
            }
        });

        setVisible(true);

        // Thiết lập kết nối
        new Thread(new Runnable() {
            public void run() {
                try (Socket socket = new Socket(serverAddress, 12345)) {
                    chatArea.append("Đã kết nối tới " + serverAddress + " tại cổng 12345\n");

                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream(), true);

                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        chatArea.append("Máy chủ: " + serverMessage + "\n");
                    }
                } catch (IOException e) {
                    chatArea.append("Lỗi: " + e.getMessage() + "\n");
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        String serverAddress = JOptionPane.showInputDialog(
                "Nhập địa chỉ IP của máy chủ:");
        new ChatClient(serverAddress);
    }
}