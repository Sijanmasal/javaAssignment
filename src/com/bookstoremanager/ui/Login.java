package com.bookstoremanager.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.bookstoremanager.Auth;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {
    private JButton loginButton;
    private JTextField usernameField;
    private JLabel usernameLabel;
    private JPasswordField passwordField;
    private JLabel passwordLabel;

//    private JLabel loginLabel;
    private ImageIcon imgA;


    public Login() {
        initComponents();
        // On login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = usernameField.getText();
                String password = new String(passwordField.getPassword());
                Auth auth = new Auth();
                boolean loggedIn = auth.checkLogin(userName, password);
                System.out.println(loggedIn);
                // If Logged In
                if(loggedIn){

                    openDashboard();

                }else {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Invalid username or password");
                }
            }
        });
    }

    private void openDashboard(){
        dispose();
        Dashboard dashboard = new Dashboard();







    }


    public void initComponents() {

        this.setTitle("Book Store Sign In  ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(500, 400);

//        loginLabel = new JLabel("Welcome to BookStore Manager");
//        loginLabel.setBounds(50,50,200,30);




        usernameField = new JTextField();
        usernameLabel = new JLabel("Enter Username: ");
        usernameLabel.setBounds(5,100,200,25);

        usernameField.setBounds(120,100,200,30);

        passwordField = new JPasswordField();
        passwordLabel = new JLabel("Enter password: ");
        passwordLabel.setBounds(5,150,200,30);
        passwordField.setBounds(120,150,200,30);

        loginButton = new JButton("Sign in to your account");
        loginButton.setForeground(Color.red);
        loginButton.setBackground(Color.yellow);
        loginButton.setBounds(120, 250, 200, 40);

//        loginButton.setForeground(Color.black);

        loginButton.setToolTipText("click here to login");


        this.add(usernameField);
        this.add(passwordField);
//        this.add(loginLabel);
        this.add(loginButton);
        this.add(usernameLabel);
        this.add(passwordLabel);

        JLabel background;
        imgA =new ImageIcon("tree.jpg");
        background=new JLabel("",imgA,JLabel.CENTER);
        background.setBounds(0,0,500,400);
        add(background);



        this.setLayout(null);
        this.setVisible(true);






    }
}
