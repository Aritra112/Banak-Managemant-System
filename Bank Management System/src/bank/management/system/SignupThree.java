package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton savingAcc, fdAcc, currentAcc, rdAcc;
    JCheckBox atm, netbank, mobbank, emailalt, checkbook, estat, declare;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type :");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        savingAcc = new JRadioButton("Saving Account");
        savingAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        savingAcc.setBackground(Color.WHITE);
        savingAcc.setBounds(100, 180, 150, 20);
        add(savingAcc);

        fdAcc = new JRadioButton("Fixed Deposit");
        fdAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        fdAcc.setBackground(Color.WHITE);
        fdAcc.setBounds(350, 180, 150, 20);
        add(fdAcc);

        currentAcc = new JRadioButton("Current Account");
        currentAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        currentAcc.setBackground(Color.WHITE);
        currentAcc.setBounds(100, 220, 250, 20);
        add(currentAcc);

        rdAcc = new JRadioButton("Recurring Deposit");
        rdAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        rdAcc.setBackground(Color.WHITE);
        rdAcc.setBounds(350, 220, 250, 20);
        add(rdAcc);

        ButtonGroup account = new ButtonGroup();
        account.add(savingAcc);
        account.add(fdAcc);
        account.add(currentAcc);
        account.add(rdAcc);

        JLabel cardno = new JLabel("Card Number :");
        cardno.setFont(new Font("Raleway", Font.BOLD, 22));
        cardno.setBounds(100, 300, 200, 30);
        add(cardno);

        JLabel number = new JLabel("XXXX-XXXX-XXX-4814");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel carddetail = new JLabel("Your 16 digit card number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100, 330, 300, 20);
        add(carddetail);

        JLabel pin = new JLabel("Pin Number :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinnumber.setBounds(330, 370, 300, 30);
        add(pinnumber);

        JLabel pindetail = new JLabel("Your 4 digit pin number");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(100, 400, 300, 20);
        add(pindetail);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 400, 30);
        add(services);

        atm = new JCheckBox("ATM CARD");
        atm.setBackground(Color.WHITE);
        atm.setFont(new Font("Raleway", Font.BOLD, 16));
        atm.setBounds(100, 500, 200, 30);
        add(atm);

        netbank = new JCheckBox("NET BANKING");
        netbank.setBackground(Color.WHITE);
        netbank.setFont(new Font("Raleway", Font.BOLD, 16));
        netbank.setBounds(350, 500, 200, 30);
        add(netbank);

        mobbank = new JCheckBox("MOBILE BANKING");
        mobbank.setBackground(Color.WHITE);
        mobbank.setFont(new Font("Raleway", Font.BOLD, 16));
        mobbank.setBounds(100, 550, 200, 30);
        add(mobbank);

        emailalt = new JCheckBox("EMAIL ALART");
        emailalt.setBackground(Color.WHITE);
        emailalt.setFont(new Font("Raleway", Font.BOLD, 16));
        emailalt.setBounds(350, 550, 200, 30);
        add(emailalt);

        checkbook = new JCheckBox("CHECK BOOK");
        checkbook.setBackground(Color.WHITE);
        checkbook.setFont(new Font("Raleway", Font.BOLD, 16));
        checkbook.setBounds(100, 600, 200, 30);
        add(checkbook);

        estat = new JCheckBox("E STATEMENT");
        estat.setBackground(Color.WHITE);
        estat.setFont(new Font("Raleway", Font.BOLD, 16));
        estat.setBounds(350, 600, 200, 30);
        add(estat);

        declare = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.", true);
        declare.setBackground(Color.WHITE);
        declare.setFont(new Font("Raleway", Font.BOLD, 12));
        declare.setBounds(100, 680, 600, 30);
        add(declare);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (savingAcc.isSelected()) {
                accountType = "Saving Account";
            } else if (fdAcc.isSelected()) {
                accountType = "Fixed Deposit";
            } else if (currentAcc.isSelected()) {
                accountType = "Current Account";
            } else if (rdAcc.isSelected()) {
                accountType = "Reccuring Deposit";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 9000000L) + 5040936000000000L);

            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (atm.isSelected()) {
                facility = facility + " ATM Card";
            } else if (netbank.isSelected()) {
                facility = facility + " NET Banking";
            } else if (mobbank.isSelected()) {
                facility = facility + " Mobile Banking";
            } else if (emailalt.isSelected()) {
                facility = facility + " Email & SMS Alerts";
            } else if (checkbook.isSelected()) {
                facility = facility + " Check Book";
            } else if (estat.isSelected()) {
                facility = facility + " E-Statement";
            }

            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                } else {
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                    String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n pin :" + pinnumber);
                }

                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String args[]) {
        // TODO code application logic here
        new SignupThree("");
    }
}
