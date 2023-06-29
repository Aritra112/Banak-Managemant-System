package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan, aadhar;
    JButton next;
    JRadioButton eyes, eno, syes, sno;
    JComboBox religion, caregory, income, education, occupation;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionallDetails = new JLabel("PAGE 2 : ADDITIONAL DETAILS");
        additionallDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionallDetails.setBounds(290, 80, 400, 30);
        add(additionallDetails);

        JLabel re = new JLabel("RELIGION: ");
        re.setFont(new Font("Raleway", Font.BOLD, 20));
        re.setBounds(100, 140, 100, 30);
        add(re);

        String valreligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valreligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel cat = new JLabel("CATEGORY: ");
        cat.setFont(new Font("Raleway", Font.BOLD, 20));
        cat.setBounds(100, 190, 200, 30);
        add(cat);

        String valcategory[] = {"Genarel", "OBC", "SC", "ST", "Other"};
        caregory = new JComboBox(valcategory);
        caregory.setBounds(300, 190, 400, 30);
        caregory.setBackground(Color.white);
        add(caregory);

        JLabel in = new JLabel("INCOME: ");
        in.setFont(new Font("Raleway", Font.BOLD, 20));
        in.setBounds(100, 240, 200, 30);
        add(in);

        String valincome[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        income = new JComboBox(valincome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);

        JLabel ed = new JLabel("EDUCATIONAL");
        ed.setFont(new Font("Raleway", Font.BOLD, 20));
        ed.setBounds(100, 290, 200, 30);
        add(ed);

        JLabel qua = new JLabel("QUALIFICATION: ");
        qua.setFont(new Font("Raleway", Font.BOLD, 20));
        qua.setBounds(100, 315, 200, 30);
        add(qua);

        String eduvcationval[] = {"Non-Graduation", "Graguate", "Post Graduation", "PHD", "Others"};
        education = new JComboBox(eduvcationval);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);

        JLabel occ = new JLabel("OCCUPATION : ");
        occ.setFont(new Font("Raleway", Font.BOLD, 20));
        occ.setBounds(100, 390, 200, 30);
        add(occ);

        String occupationval[] = {"Salaried", "Self-Employed", "Bussiness Man", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationval);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel pn = new JLabel("PAN NUMBER: ");
        pn.setFont(new Font("Raleway", Font.BOLD, 20));
        pn.setBounds(100, 440, 200, 30);
        add(pn);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel an = new JLabel("AADHAR NO: ");
        an.setFont(new Font("Raleway", Font.BOLD, 20));
        an.setBounds(100, 490, 200, 30);
        add(an);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel sc = new JLabel("SENIOR CITIZEN:");
        sc.setFont(new Font("Raleway", Font.BOLD, 20));
        sc.setBounds(100, 540, 200, 30);
        add(sc);

        syes = new JRadioButton("YES");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup scgroup = new ButtonGroup();
        scgroup.add(syes);
        scgroup.add(sno);

        JLabel exa = new JLabel("EX ACCOUNT:");
        exa.setFont(new Font("Raleway", Font.BOLD, 20));
        exa.setBounds(100, 590, 300, 30);
        add(exa);

        eyes = new JRadioButton("YES");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup exaccgroup = new ButtonGroup();
        exaccgroup.add(eyes);
        exaccgroup.add(eno);

        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scaregory = (String) caregory.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "YES";
        } else if (sno.isSelected()) {
            seniorcitizen = "NO";
        }
        String existingacc = "null";
        if (eyes.isSelected()) {
            existingacc = "YES";
        } else if (eno.isSelected()) {
            existingacc = "NO";
        }
        String panno = pan.getText();
        String aadharno = aadhar.getText();

        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scaregory + "',"
                    + "'" + sincome + "','" + seducation + "','" + soccupation + "','" + seniorcitizen + "','" + existingacc + "',"
                    + "'" + panno + "','" + aadharno + "')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignupThree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String args[]) {
        new SignupTwo("");
    }
}
