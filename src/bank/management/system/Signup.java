package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

public class Signup  extends JFrame implements ActionListener {
    JRadioButton r1,r2, r3, m1, m2, m3;

    JButton next;

    JTextField textName, textFname, textEmail, textAdd, textCity, textPin, textState;
    JDateChooser dateChooser;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;

    String first = " "+ Math.abs(first4);

    Signup(){
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO." + first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Ralway", Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Ralway",Font.BOLD,22));
        label2.setBounds(380,70,600,30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Ralway",Font.BOLD,22));
        label3.setBounds(330,100,600,30);
        add(label3);

        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Ralway",Font.BOLD,20));
        labelName.setBounds(100,190,100,30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Ralway",Font.BOLD,14));
        textName.setBounds(300,190,400,30);
        add(textName);

        JLabel labelFname = new JLabel("Father's Name :");
        labelFname.setFont(new Font("Ralway",Font.BOLD,20));
        labelFname.setBounds(100,240,200,30);
        add(labelFname);

        textFname = new JTextField();
        textFname.setFont(new Font("Ralway",Font.BOLD,14));
        textFname.setBounds(300,240,400,30);
        add(textFname);

        JLabel DOB = new JLabel("Date of Birth :");
        DOB.setFont(new Font("Ralway",Font.BOLD,20));
        DOB.setBounds(100,340,200,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(Color.white);
        dateChooser.setBounds(300,340,400,30);
        dateChooser.getDateEditor().setEnabled(false); // Disables typing

        dateChooser.getDateEditor().getUiComponent().setForeground(Color.WHITE); // Set selected date text color
        dateChooser.setFont(new Font("Raleway",Font.BOLD,15));
        dateChooser.getDateEditor().getUiComponent().setBackground(Color.DARK_GRAY);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender :");
        labelG.setFont(new Font("Ralway",Font.BOLD,20));
        labelG.setBounds(100,290,200,30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Ralway",Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,290,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Ralway",Font.BOLD,14));
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(450,290,100,30);
        add(r2);

        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Ralway",Font.BOLD,14));
        r3.setBackground(new Color(222,255,228));
        r3.setBounds(600,290,100,30);
        add(r3);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);
        buttonGroup1.add(r3);


        JLabel labelEmail = new JLabel("Email address :");
        labelEmail.setFont(new Font("Ralway",Font.BOLD,20));
        labelEmail.setBounds(100,390,200,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Ralway",Font.BOLD,14));
        textEmail.setBounds(300,390,400,30);
        add(textEmail);


        JLabel labelMS = new JLabel("Marital Status :");
        labelMS.setFont(new Font("Ralway",Font.BOLD,20));
        labelMS.setBounds(100,440,200,30);
        add(labelMS);

//        textMS = new JTextField();
//        textMS.setFont(new Font("Ralway",Font.BOLD,14));
//        textMS.setBounds(300,440,400,30);
//        add(textMS);

        m1 = new JRadioButton("Married");
        m1.setFont(new Font("Ralway",Font.BOLD,14));
        m1.setBackground(new Color(222,255,228));
        m1.setBounds(300,440,100,30);
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setFont(new Font("Ralway",Font.BOLD,14));
        m2.setBackground(new Color(222,255,228));
        m2.setBounds(450,440,100,30);
        add(m2);

        m3 = new JRadioButton("Divorced");
        m3.setFont(new Font("Ralway",Font.BOLD,14));
        m3.setBackground(new Color(222,255,228));
        m3.setBounds(600,440,100,30);
        add(m3);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(m1);
        buttonGroup2.add(m2);
        buttonGroup2.add(m3);


        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Ralway",Font.BOLD,20));
        labelAdd.setBounds(100,490,200,30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Ralway",Font.BOLD,14));
        textAdd.setBounds(300,490,400,30);
        add(textAdd);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Ralway",Font.BOLD,20));
        labelCity.setBounds(100,540,200,30);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Ralway",Font.BOLD,14));
        textCity.setBounds(300,540,400,30);
        add(textCity);


        JLabel labelPin = new JLabel("Pin Code :");
        labelPin.setFont(new Font("Ralway",Font.BOLD,20));
        labelPin.setBounds(100,590,200,30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Ralway",Font.BOLD,14));
        textPin.setBounds(300,590,400,30);
        textPin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char alphabets = e.getKeyChar();
                if(!Character.isDigit(alphabets) && alphabets != KeyEvent.VK_BACK_SPACE && alphabets != KeyEvent.VK_DELETE){
                    e.consume();
                }
                if(textPin.getText().length() >= 6){
                    e.consume();
                }
            }
        });
        add(textPin);

        JLabel labelState = new JLabel("State :");
        labelState.setFont(new Font("Ralway",Font.BOLD,20));
        labelState.setBounds(100,640,200,30);
        add(labelState);

        textState = new JTextField();
        textState.setFont(new Font("Ralway",Font.BOLD,14));
        textState.setBounds(300,640,400,30);
        add(textState);

        next = new JButton("Next");
        next.setFont(new Font("Ralway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,710,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        Date selectedDate = dateChooser.getDate();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }
        else if(r2.isSelected()){
            gender = "Female";
        }
        else if(r3.isSelected()){
            gender = "Other";
        }


        String email = textEmail.getText();
        String marital = null;
        if(m1.isSelected()){
            marital = "Married";
        }
        else if(m2.isSelected()){
            marital = "Unmarried";
        }
        else if(m3.isSelected()){
            marital = "Divorced";
        }

        String address = textAdd.getText();
        String city = textCity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        try {
            if(!textEmail.getText().contains("@")){
                JOptionPane.showMessageDialog(null,"Invalid Email address");
            }
            else if(textName.getText().trim().isEmpty() ||  textFname.getText().trim().isEmpty() || dob.trim().isEmpty() || gender.trim().isEmpty() || marital.trim().isEmpty() || address.trim().isEmpty() || city.trim().isEmpty() || pincode.trim().isEmpty() || state.trim().isEmpty()){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            } else if (textPin.getText().length() < 6) {
                JOptionPane.showMessageDialog(null,"Pin Code should be of 6 digits");
            } else{
                Connection connection = new Connection();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                connection.statement.executeUpdate(query);
                new Signup2(formno,selectedDate);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }


}
