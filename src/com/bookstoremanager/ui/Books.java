package com.bookstoremanager.ui;
import com.bookstoremanager.Searching;
import com.bookstoremanager.Sorting;
import com.bookstoremanager.Utils;
import com.bookstoremanager.dao.Book;
import jdk.jshell.execution.Util;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Books extends JFrame {

    JTable table;
    JScrollPane pane;
    JLabel loginLabel;
    ImageIcon imgA;
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<LinkedHashMap<String,String>> bookListData;




    public Books(ArrayList<LinkedHashMap<String,String>> bookListData){
        this.bookListData = bookListData;

        this.setTitle("Books");






        System.out.println("Reloaded Class");
        System.out.println(bookListData);




        // Build Table Data
        if(!bookListData.isEmpty()) {
            model = getTableModel(bookListData);
            table = buildTable(model);
        }
        // create JTextFields
        JTextField textId = new JTextField("Enter Id");
        JTextField textBookName = new JTextField("Enter name of book");
        JTextField textBookPublisher = new JTextField("Enter Publisher name");
        JTextField textBookGenre = new JTextField("Enter Genre");
        JTextField textPublishedDate = new JTextField("Enter Date of publishing book");

        JTextField textSearchBookName = new JTextField("Search by name of book");
        JTextField textSearchPublisherName = new JTextField("Search by name of publisher");
        JTextField textSearchPublishedDate = new JTextField("Search by year of publication");


        // create JButtons
        JButton btnAdd = new JButton("Add details");
        JButton btnDelete = new JButton("Delete details");
        JButton btnUpdate = new JButton("Update details");
        JButton btnSortAsc = new JButton("Sort by Ascending order");
        JButton btnReset = new JButton("Reset details");
        JButton btnSortDesc = new JButton("Sort by Descending order");

        JButton btnSearch = new JButton("Search now");

        textId.setBounds(20, 220, 200, 25);
        textBookName.setBounds(20, 250, 200, 25);
        textBookPublisher.setBounds(20, 280, 200, 25);
        textBookGenre.setBounds(20, 310, 200, 25);
        textPublishedDate.setBounds(20,340,200,25);

        btnAdd.setBounds(20, 420, 100, 35);
        btnAdd.setForeground(Color.red);
        btnAdd.setBackground(Color.yellow);
        btnUpdate.setBounds(130, 420, 120, 35);
        btnUpdate.setForeground(Color.red);
        btnUpdate.setBackground(Color.yellow);
        btnDelete.setBounds(260, 420, 120, 35);
        btnDelete.setForeground(Color.red);
        btnDelete.setBackground(Color.yellow);
        btnSortAsc.setBounds(690, 220, 185, 25 );
        btnSortAsc.setForeground(Color.red);
        btnSortAsc.setBackground(Color.yellow);
        btnReset.setBounds(690, 250, 185, 25);
        btnReset.setForeground(Color.red);
        btnReset.setBackground(Color.yellow);
        btnSortDesc.setBounds(690,280,185,25);
        btnSortDesc.setForeground(Color.red);
        btnSortDesc.setBackground(Color.yellow);

        textSearchBookName.setBounds(420, 220, 200, 25);
        textSearchPublisherName.setBounds(420,250,200,25);
        textSearchPublishedDate.setBounds(420, 280, 200, 25);

        btnSearch.setBounds(420, 310, 200, 35);
        btnSearch.setForeground(Color.red);
        btnSearch.setBackground(Color.yellow);




        // add JTextFields to the jthis
        this.add(textId);
        this.add(textBookName);
        this.add(textBookPublisher);
        this.add(textBookGenre);
        this.add(textPublishedDate);
        this.add(textSearchBookName);
        this.add(textSearchPublisherName);
        this.add(textSearchPublishedDate);

        // add JButtons to the jthis
        this.add(btnAdd);
        this.add(btnDelete);
        this.add(btnUpdate);
        this.add(btnSortAsc);
        this.add(btnReset);
        this.add(btnSortDesc);
        this.add(btnSearch);






        // create an array of objects to set the row data
        Object[] row = new Object[5];

        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                String id = textId.getText();
                String bookName = textBookName.getText();
                String bookAuthor = textBookPublisher.getText();
                String bookGenre = textBookGenre.getText();
                String publishedDate = textPublishedDate.getText();

                // add to database
                boolean bookCreated = new Book().add(id,bookName,bookAuthor,bookGenre,publishedDate);

                if(bookCreated){
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Successfully Added Book");

                    row[0] = id;
                    row[1] = bookName;
                    row[2] = bookAuthor;
                    row[3] = bookGenre;
                    row[4] = publishedDate;

                    // add row to the model
                    model.addRow(row);

                    disposeFrame();
                    Books books = new Books(new Book().getAllBooks());
                }

            }
        });

        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();

                String bookId = table.getModel().getValueAt(i,0).toString();

                // Delete from database
                if(i >= 0){
                    // remove a row from jtable
                    boolean bookDeleted = new Book().delete(bookId);
                    if(bookDeleted) {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Successfully Deleted");
                        model.removeRow(i);
                    }else{
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Something went wrong!!");
                    }
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });

        if(!bookListData.isEmpty()) {
            // get selected row data From table to textfields
            table.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    // i = the index of the selected row
                    int i = table.getSelectedRow();

                    String bookId = model.getValueAt(i, 0).toString();
                    String bookName = model.getValueAt(i, 1).toString();
                    String bookAuthor = model.getValueAt(i, 2).toString();
                    String bookGenre = model.getValueAt(i, 3).toString();
                    String publishedDate = model.getValueAt(i, 4).toString();


                    textId.setText(bookId);
                    textBookName.setText(bookName);
                    textBookPublisher.setText(bookAuthor);
                    textBookGenre.setText(bookGenre);
                    textPublishedDate.setText(publishedDate);

                }
            });
        }

        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();


                String bookId = textId.getText();
                String bookName = textBookName.getText();
                String bookAuthor = textBookPublisher.getText();
                String bookGenre = textBookGenre.getText();
                String publishedDate = textPublishedDate.getText();

                // Update database
                boolean updatedBook = new Book().update(bookId,bookName,bookAuthor,bookGenre,publishedDate);


                if(i >= 0)
                {
                    if(updatedBook){
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Successfully Updated");

                        model.setValueAt(textId.getText(), i, 0);
                        model.setValueAt(textBookName.getText(), i, 1);
                        model.setValueAt(textBookPublisher.getText(), i, 2);
                        model.setValueAt(textBookGenre.getText(), i, 3);
                        model.setValueAt(textPublishedDate.getText(),i,4);
                    }else{
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Something Went Wrong");

                    }
                }
                else{
                    System.out.println("Update Error");
                }
            }

        });


        // Sort ascending button
        btnSortAsc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<LinkedHashMap<String,String>> sortedBooksData = new Sorting().ascSortArrayListOfHashMap(bookListData);
                System.out.println(bookListData);
                disposeFrame();
                Books books = new Books(sortedBooksData);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<LinkedHashMap<String,String>> booksData = new Book().getAllBooks();
                disposeFrame();
                Books books = new Books(booksData);

            }
        });

        // Sort descending button
        btnSortDesc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<LinkedHashMap<String,String>> sortedBooksData = new Sorting().descSortArrayListOfHashMap(bookListData);
                System.out.println(bookListData);
                disposeFrame();
                Books books = new Books(sortedBooksData);
            }
        });

        // Search Button
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookNameSearch = textSearchBookName.getText();
                String bookPublisherName = textSearchPublisherName.getText();
                String publishedDate = textSearchPublishedDate.getText();

                ArrayList<LinkedHashMap<String,String>> searchResult = new Searching().search(
                        bookListData,bookNameSearch,bookPublisherName,publishedDate);
                disposeFrame();
                Books books = new Books(searchResult);

            }
        });

        // Check if data is present
        // create JScrollPane
        if(bookListData.isEmpty()){
            JLabel jLabel = new JLabel("No data found.");
            pane = new JScrollPane(jLabel);

        }else {
            pane = new JScrollPane(table);
        }
        pane.setBounds(0, 0, 880, 200);




        this.setLayout(null);




        this.add(pane);
        JLabel background;
        imgA =new ImageIcon("wide.jpg");
        background=new JLabel("",imgA,JLabel.CENTER);
        background.setBounds(0,0,900,522);
        add(background);

        table.setForeground(Color.red);
        table.setBackground(Color.yellow);


        this.setSize(900,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);






        this.setVisible(true);

    }

    public void disposeFrame(){
        this.dispose();
    }


    private DefaultTableModel getTableModel(ArrayList<LinkedHashMap<String,String>> data){
        ArrayList<ArrayList<String>> columnData = new Utils().getAllColumnData(data);
        // create a table model and set a Column Identifiers to this model
        Object[] columns = new Utils().getColumnName(data.get(0)).toArray();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        // Set Initial Columns
        for(int i = 0; i < columnData.toArray().length ; i++){
            model.addRow(new Utils().getObject(columnData.get(i)));
        }
        return model;
    }


    private JTable buildTable(DefaultTableModel tableModel){
        JTable table = new JTable();
        // set the model to the table
        table.setModel(tableModel);




        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);






        return table;



    }
}
