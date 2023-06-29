package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton rsO, rsF, rsOH, rsTH, rsFH, rsOT, exit;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        rsO = new JButton("RS 100");
        rsO.setBounds(170, 415, 150, 30);
        rsO.addActionListener(this);
        image.add(rsO);

        rsF = new JButton("RS 500");
        rsF.setBounds(335, 415, 150, 30);
        rsF.addActionListener(this);
        image.add(rsF);

        rsOH = new JButton("RS 1000");
        rsOH.setBounds(170, 450, 150, 30);
        rsOH.addActionListener(this);
        image.add(rsOH);

        rsTH = new JButton("RS 2000");
        rsTH.setBounds(335, 450, 150, 30);
        rsTH.addActionListener(this);
        image.add(rsTH);

        rsFH = new JButton("RS 5000");
        rsFH.setBounds(170, 485, 150, 30);
        rsFH.addActionListener(this);
        image.add(rsFH);

        rsOT = new JButton("RS 10,000");
        rsOT.setBounds(335, 485, 150, 30);
        rsOT.addActionListener(this);
        image.add(rsOT);

        exit = new JButton("Back");
        exit.setBounds(335, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber ='" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insuficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawl','" + amount + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "RS " + amount + " Debited Successful");

                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public static void main(String args[]) {
        new FastCash("");// TODO code application logic here
    }
}
