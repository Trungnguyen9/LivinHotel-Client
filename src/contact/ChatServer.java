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

public class ChatServer extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private PrintWriter out;

    public ChatServer() {
        // Thiết lập giao diện
        setTitle("Chat Server");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        inputField = new JTextField();
        inputField.setEditable(false);
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
                try (ServerSocket serverSocket = new ServerSocket(12345)) {
                    chatArea.append("Server đang lắng nghe tại cổng 12345...\n");
                    Socket clientSocket = serverSocket.accept();
                    chatArea.append("Đã kết nối với " + clientSocket.getInetAddress() + "\n");

                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    inputField.setEditable(true);

                    String clientMessage;
                    while ((clientMessage = in.readLine()) != null) {
                        chatArea.append("Máy khách: " + clientMessage + "\n");
                    }
                } catch (IOException e) {
                    chatArea.append("Lỗi: " + e.getMessage() + "\n");
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}