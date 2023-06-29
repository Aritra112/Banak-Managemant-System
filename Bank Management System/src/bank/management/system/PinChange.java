package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons//atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color.white);
        text.setFont(new Font("Ralweys", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel pintext = new JLabel("New Pin");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("Ralweys", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Ralweys", Font.BOLD, 16));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        JLabel repintext = new JLabel("Re Enter Your Pin");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("Ralweys", Font.BOLD, 16));
        repintext.setBounds(165, 380, 200, 25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Ralweys", Font.BOLD, 16));
        repin.setBounds(330, 380, 180, 25);
        image.add(repin);

        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {

            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Enter the Correct Pin");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter the new Pin");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter your new Pin");
                    return;
                }

                Conn c = new Conn();
                String query1 = "update bank set pinnumber = '" + rpin + "' where pinnumber = '" + pinnumber + "'";
                String query2 = "update login set pinnumber = '" + rpin + "' where pinnumber = '" + pinnumber + "'";
                String query3 = "update signupthree set pinnumber = '" + rpin + "' where pinnumber = '" + pinnumber + "'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Pin Change Successfuly");

                setVisible(false);
                new Transaction(rpin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }

    }

    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
