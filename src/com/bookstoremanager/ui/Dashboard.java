package com.bookstoremanager.ui;

import com.bookstoremanager.dao.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dashboard extends JFrame{
    private JPanel dashboardPanel;
    private JLabel dashboardText;
    public JButton booksButton;
    private JButton salesButton;


    private JLabel loginLabel;
    private ImageIcon imgA;

    public Dashboard() {

        this.setTitle("Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(500, 400);
        this.setVisible(true);


        booksButton = new JButton("Books");
        booksButton.setForeground(Color.red);
        booksButton.setBackground(Color.yellow);
        booksButton.setBounds(130,250,200,40);
        booksButton.setToolTipText("click here to add books");


        salesButton = new JButton("Sales");
        salesButton.setForeground(Color.red);
        salesButton.setBackground(Color.yellow);
        salesButton.setBounds(130,150,200,40);
        salesButton.setToolTipText("click here for sales");



        this.add(booksButton);
        this.add(salesButton);


        this.setLayout(null);




        JLabel background;
        imgA =new ImageIcon("tree.jpg");
        background=new JLabel("",imgA,JLabel.CENTER);
        background.setBounds(0,0,500,400);
        add(background);

        booksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endFrame();

                Books books = new Books(new Book().getAllBooks());

            }
        });

        salesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endFrame();

                Sales sales = new Sales();
            }
        });


    }



    public void endFrame(){
        this.dispose();
    }
}
