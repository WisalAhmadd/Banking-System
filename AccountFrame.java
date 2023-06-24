/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybanksystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class AccountFrame extends JFrame {
    
    
    private static final String FILE_PATH = "accounts.txt";

    JLabel accNoLBL, ownerLBL, balanceLBL, cityLBL, amountLBL, genderLBL;
    JTextField accNoTXT, ownerTXT, balanceTXT, cityTXT, amountTXT, genderTXT;
    JComboBox<City> citiesCMB;
    JButton newBTN, saveBTN, showBTN, quitBTN, depositBTN, withdrawBTN;
    JRadioButton maleRDB, femaleRDB;
    ButtonGroup genderBTNGRP;
    JList<Account> accountsLST;
    JPanel p1, p2, p3, p4, p5;
    Set<Account> accountSet = new TreeSet<>();
    Account acc, x;
    boolean newRec = true;
    DefaultComboBoxModel<City> citiesCMBMDL;
    DefaultListModel<Account> accountsLSTMDL;
    JTable table;
    DefaultTableModel tableModel;
    ArrayList<Transaction> translist = new ArrayList<>();
    
    

    public AccountFrame() {
        super("                                                           Banking Software By Ims");
        
        setLayout(null);
        setSize(620, 430);
        setResizable(false);
        setLocationRelativeTo(null);
//        setBackground(Color.BLACK);
        
//        setVisible(true);
        

        // Components are Here>>>>>>.
        accNoLBL = new JLabel("Account: ");
        ownerLBL = new JLabel("Owner: ");
        balanceLBL = new JLabel("Balance: ");
        cityLBL = new JLabel("City: ");
        genderLBL = new JLabel("Gender: ");
        amountLBL = new JLabel("Amount");

        // ADDING TEXT FIELDS
        accNoTXT = new JTextField();
        accNoTXT.setBackground(Color.WHITE);
        accNoTXT.setEditable(false);
        
        ownerTXT = new JTextField();
        ownerTXT.setBackground(Color.WHITE);
        balanceTXT = new JTextField();
        balanceTXT.setBackground(Color.WHITE);
        balanceTXT.setEditable(false);
        amountTXT = new JTextField();
        amountTXT.setBackground(Color.WHITE);
        amountTXT.setPreferredSize(new Dimension(150, 25));

        // Creating And Adding Items to Combo Box
        citiesCMBMDL = new DefaultComboBoxModel<>();
        citiesCMBMDL.addElement(new City("",""));
        citiesCMBMDL.addElement(new City("Pesh", "Hytabd"));
        citiesCMBMDL.addElement(new City("Pesh", "Kohat Road"));
        citiesCMBMDL.addElement(new City("Pesh", "Mall Road"));
        citiesCMBMDL.addElement(new City("Pesh", "Uni Road"));
        citiesCMBMDL.addElement(new City("Pesh", "GullBahar"));
        citiesCMBMDL.addElement(new City("Pesh", "Dabgari"));
        citiesCMBMDL.addElement(new City("Pesh", "Saddar"));

        // Combo Box Management
        citiesCMB = new JComboBox<>(citiesCMBMDL);
        citiesCMB.setBackground(Color.cyan);


        // Radio buttons
        maleRDB = new JRadioButton("Male", true);
        femaleRDB = new JRadioButton("Female", false);
        genderBTNGRP = new ButtonGroup();
        genderBTNGRP.add(maleRDB);
        genderBTNGRP.add(femaleRDB);
        maleRDB.setBackground(Color.LIGHT_GRAY);
        femaleRDB.setBackground(Color.LIGHT_GRAY);
        

        // Now Adding Buttons
        newBTN = new JButton("New");
        newBTN.setBackground(Color.blue);

        saveBTN = new JButton("Save");
        saveBTN.setBackground(Color.GREEN);

        
        showBTN = new JButton("Show");
        quitBTN = new JButton("Quit");
        quitBTN.setBackground(Color.RED);

        
        quitBTN.setBackground(Color.RED);

        
        depositBTN = new JButton("Deposit");
        depositBTN.setBackground(Color.GREEN);

        withdrawBTN = new JButton("Withdraw");
        withdrawBTN.setBackground(Color.RED);


        // 6 - Table
        accountsLSTMDL = new DefaultListModel<>();
        

        accountsLST = new JList<>(accountsLSTMDL);

        
        accountsLST.setBackground(Color.GRAY);
        
        
        // 7- Panels
        p1 = new JPanel();
        p1.setBackground(Color.LIGHT_GRAY);
        p1.setBounds(5, 5, 300, 150);
        p1.setLayout(new GridLayout(5, 2));

        p2 = new JPanel();
        p2.setBackground(Color.LIGHT_GRAY);
        p2.setBounds(5, 155, 300, 40);
        p2.setLayout(new FlowLayout());

        p3 = new JPanel();
        p3.setBackground(Color.LIGHT_GRAY);
        p3.setBounds(5, 195, 600, 40);
        p3.setLayout(new FlowLayout());

        p4 = new JPanel();
        
        p4.setBackground(Color.LIGHT_GRAY);

        p4.setBounds(305, 5, 300, 190);
        p4.setLayout(new BorderLayout());

        p5 = new JPanel();
        p5.setBackground(Color.LIGHT_GRAY);

//        p5.setBackground(Color.LIGHT_GRAY);

        p5.setBounds(5, 240, 580, 120);
        p5.setLayout(new BorderLayout());

        // Adding Components TO Panels
        p1.add(accNoLBL);
        p1.add(accNoTXT);
        p1.add(ownerLBL);
        p1.add(ownerTXT);
        p1.add(balanceLBL);
        p1.add(balanceTXT);
        p1.add(cityLBL);
        p1.add(citiesCMB);
        p1.add(maleRDB);
        p1.add(femaleRDB);

        p2.add(newBTN);
        p2.add(saveBTN);
        p2.add(showBTN);
        p2.add(quitBTN);

        p3.add(amountTXT);
        p3.add(amountLBL);
        p3.add(depositBTN);
        p3.add(withdrawBTN);

        p4.add(accountsLST);

        // Adding Panels To Frames
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);

        // CREATING TABLE
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        table.setBackground(Color.magenta);
        
//        tableModel.setEditable(false);

        tableModel.addColumn("Transaction");
        tableModel.addColumn("Date");
        tableModel.addColumn("Type");
        tableModel.addColumn("Amount");
        JScrollPane scrollPane = new JScrollPane(table);

        p5.add(scrollPane);
      

        
        
//        p5.setBackground(Color.GREEN);

        
        
        /// ADDING FUNCTIONALITY
        newBTN.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                accNoTXT.setText("");
                ownerTXT.setText("");
                citiesCMB.setSelectedIndex(0);
                maleRDB.setSelected(true);
                balanceTXT.setText("");
                amountTXT.setText("");
                newRec = true;
                
                
            }
        });
        
            saveBTN.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
             if (newRec){
                 if (ownerTXT.getText().length() !=0){
                     acc = new Account(
                             ownerTXT.getText(),
                             (City) citiesCMB.getSelectedItem(),
                             maleRDB.isSelected()? 'M':'F');
                     
                     accNoTXT.setText(String.valueOf(acc.accNo));
                     accountSet.add(acc);
                     accountsLSTMDL.addElement(acc);
                     newRec = false;   
                }else{
                     JOptionPane.showMessageDialog(null,"Please Fill Add Fields ");
                        }
            }else{
                    accountSet.remove(acc);
                    
                    int a = Integer.parseInt(accNoTXT.getText()); 
                    
                    String o= ownerTXT.getText();
                    City c = (City) citiesCMB.getSelectedItem();
                    char g = maleRDB.isSelected()?'M':'F';
                    double b = Double.parseDouble(balanceTXT.getText());
                    
                    acc = new Account (a,o,c, b,g); accountSet.add(acc);
                    accountsLSTMDL.setElementAt(acc, accountsLST.getSelectedIndex());
                    newRec = false;
                }
             
            JOptionPane.showMessageDialog(null,"\n Account Successfull Created Summary \n \n Account ID " +acc.accNo+ "\n \n Holder : "+acc.Owner +" \n \n                                                      ~ Digisol®  ");

            }
        });
        
        
//     }
    

    
    
    
    
    
    
//        JOptionPane.showMessageDialog(null,"Welcome To Account Management System  \n         ~ Digisol®  ");

    
    
    
    
    
    
    
    
    
    
    
    
//        // Save button ActionListener
//        saveBTN.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                saveAccount();
//            }
//        });
//
//        // Show button ActionListener
//        showBTN.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                showAccounts();
//            }
//        });
//        



        showBTN.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String s = "";
                Iterator<Account> it = accountSet.iterator();
                while(it.hasNext()){
                    s += it.next().toString()+"\n";
                    JOptionPane.showMessageDialog(null,s);
                }
            }
        });
        
        depositBTN.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (!newRec && amountTXT.getText().length()!=0)
                {
                    
                    //Adding Transaction to Table
                    
                    Transaction t = new Transaction(acc,LocalDate.now(),
                    Double.parseDouble(amountTXT.getText()),'D');
                    
                    DisplayTransactionsInTable(t);
                    
                //Desposit From Account 
                
                
                    acc.deposit(Double.parseDouble(amountTXT.getText()));
                    
                    balanceTXT.setText(String.valueOf(acc.balance));
                    
                    
                    
                }
                
                JOptionPane.showMessageDialog(null,amountTXT.getText() + "\n Deposit Successfull Summary \n \n Account ID " +acc.accNo+ "\n \n Holder : "+acc.Owner +" \n\n                                                      ~ Digisol®  ");

            }
        });
        
          quitBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null,"\n Data Saved Ready To Quit! \n\n                   ~ Digisol®  ");
            try{
                Save(acc.accNo ,acc.Owner ,acc.balance );
                System.exit(0);

               }
               
               catch(FileNotFoundException a)
               {
               System.exit(0);
               }
            }
        });
        
        withdrawBTN.addActionListener(new ActionListener() {
                
        @Override
        public void actionPerformed (ActionEvent e) {
             
             if (!newRec && amountTXT.getText().length() != 0){
                 
    // Adding Transaction to table 
    
    
                Transaction t = new Transaction(  acc, LocalDate.now(), Double.parseDouble(amountTXT.getText()),'W');
//                setBackground(Color.RED);
                
                DisplayTransactionsInTable(t);
                
                acc.withdraw(Double.parseDouble(amountTXT.getText())); 
                balanceTXT.setText(String.valueOf(acc.balance));
                                                                }
                JOptionPane.showMessageDialog(null,amountTXT.getText() + "Rs  \n \nWithDraw Successfull Summary \n \n Account ID " +acc.accNo+ "\n\n  Holder : "+acc.Owner +" \n \n                                                      ~ Digisol®  ");

                                                   }
        
        
        });
        
    accountsLST.addListSelectionListener(new ListSelectionListener()
    {
    @Override
    public void valueChanged(ListSelectionEvent e) 
    {
        acc = x = accountsLST.getSelectedValue();
        accNoTXT.setText(String.valueOf(acc.accNo));
        ownerTXT.setText(acc.Owner); citiesCMB.setSelectedItem(acc.city);
        if 
            (acc.gender == 'M')
            maleRDB.setSelected(true); 
        
        else
        
            femaleRDB.setSelected(true);
             
//        ERROR THROWing 
        
        balanceTXT.setText(String.valueOf(acc.balance));  
        amountTXT.setEnabled(true); 
        depositBTN.setEnabled(true);
        newRec = false;
        
        for(int i = tableModel.getRowCount() -1 ; i>=0;i--){
            tableModel.removeRow(i);
        }
    
        SearchTransactionList(acc.accNo);
        
                 }
     });
    
    
    JOptionPane.showMessageDialog(null,"\n Welcome To Account Management System \n \n Click Enter To Continue... \n \n                                                      ~ Digisol®  ");

        
    
        
    }

    
   

    private void Save(int id , String Owner ,double amount ) throws FileNotFoundException
    {
//            private static final String FILE_PATH = "DATA.txt";
//                accNoTXT.setText("");
//                ownerTXT.setText("");
//                citiesCMB.setSelectedIndex(0);
//                maleRDB.setSelected(true);
//                balanceTXT.setText("");
//                amountTXT.setText("");

        PrintWriter file = new PrintWriter(Owner +".txt");
        file.write(acc.accNo + " " +acc.Owner + " " + acc.balance );
        file.close();
        
        
        

    }
    






   private void SearchTransactionList(int accNo)
   {
       ArrayList<Transaction> filteredList =  new ArrayList<>();
       
       for(Transaction t: translist){
           
           if(t.getAcc().accNo == accNo){
               filteredList.add(t);
           }
           
       }
       
//               filteredList.setEditable(false);

       
       for (int i = 0 ; i < filteredList.size();i++)
       {
           tableModel.addRow(new Object[]{
               filteredList.get(i).getTransactionNumber(),
               filteredList.get(i).getDate(),
               filteredList.get(i).getOperation(),
               filteredList.get(i).getAmount()
               
                              
           });
       }
       
   }

    
    
    
    private void DisplayTransactionsInTable(Transaction t)
    {
//       Displaying Data
        tableModel.addRow(new Object[]
        {
            t.getTransactionNumber(),
            t.getDate(),
            t.getOperation(),
            t.getAmount(),
            
        });
        // ADding objects to arraylist
        translist.add(t);
//        setEditable(false);

    }


    
    
    
     
    
    
    
    
    

    public static void main(String[] args) {
        AccountFrame AF = new AccountFrame();

        AF.setVisible(true);
        AF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
