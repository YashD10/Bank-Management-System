package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;

public class Signup2 extends JFrame implements ActionListener {

    JComboBox comboBox, comboBox2, comboBox3, comboBox4,comboBox5;
    JTextField textPAN, textAADHAR;
    JRadioButton r1,r2 , e1,e2;
    JButton next;
    int yearDiff;

    String formno;
    Date ageDate;

    Signup2(String formno, Date date){

        super("APPLICATION FORM");
        this.ageDate = date;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        this.formno = formno;

        JLabel l1 = new JLabel("Page 2 : -");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(300,30,600,40);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(300,60,600,40);
        add(l2);

        JLabel l3 = new JLabel("Religion : ");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100,120,100,30);
        add(l3);

        String religion[] = {"Hindu", "Sikh", "Christian", "Muslim", "Other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(252,208,76));
        comboBox.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox.setBounds(350,120,320,30);
        add(comboBox);

        JLabel l4 = new JLabel("Category : ");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100,170,100,30);
        add(l4);

        String category[] = {"General", "SC", "ST", "OBC", "Other"};
        comboBox2 = new JComboBox(category);
        comboBox2.setBackground(new Color(252,208,76));
        comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox2.setBounds(350,170,320,30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income : ");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        l5.setBounds(100,220,100,30);
        add(l5);

        String income[] = {"0 - 1,50,000","1,50,001 - 2,50,000", "2,50,001 - 5,00,000","5,00,001 - 10,00,000", "More than 10,00,000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(new Color(252,208,76));
        comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox3.setBounds(350,220,320,30);
        add(comboBox3);

        JLabel l6 = new JLabel("Educational : ");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(100,270,150,30);
        add(l6);

        String education[] = {"Non-Graduate", "Graduate", "Post-Graduate","Doctorate","Others"};
        comboBox4 = new JComboBox(education);
        comboBox4.setBackground(new Color(252,208,76));
        comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox4.setBounds(350,270,320,30);
        add(comboBox4);


        JLabel l7 = new JLabel("Occupation : ");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100,320,150,30);
        add(l7);

        String occupation[] = {"Salaried","Self-Employed","Business","Retired","Student","Other"};
        comboBox5 = new JComboBox(occupation);
        comboBox5.setBackground(new Color(252,208,76));
        comboBox5.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox5.setBounds(350,320,320,30);
        add(comboBox5);

        JLabel l8 = new JLabel("PAN Number : ");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100,370,150,30);
        add(l8);

        textPAN = new JTextField();
        textPAN.setFont(new Font("Raleway",Font.BOLD,18));
        textPAN.setBounds(350,370,320,30);
        textPAN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char alphabet = e.getKeyChar();
                if((!Character.isDigit(alphabet) && !Character.isLetter(alphabet) && alphabet != KeyEvent.VK_BACK_SPACE && alphabet != KeyEvent.VK_DELETE) || textPAN.getText().length() >= 10){
                    e.consume();
                }else if(Character.isLowerCase(alphabet)) {
                    e.setKeyChar(Character.toUpperCase(alphabet));
                }
            }
        });
        add(textPAN);

        JLabel l9 = new JLabel("AADHAR Number : ");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(100,420,200,30);
        add(l9);

        textAADHAR = new JTextField();
        textAADHAR.setFont(new Font("Raleway",Font.BOLD,18));
        textAADHAR.setBounds(350,420,320,30);
        textAADHAR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char alphabet = e.getKeyChar();
                if(!Character.isDigit(alphabet) && alphabet != KeyEvent.VK_BACK_SPACE && alphabet != KeyEvent.VK_DELETE){
                    e.consume();
                }
                if(textAADHAR.getText().length() >= 12){
                    e.consume();
                }
            }
        });
        add(textAADHAR);

        JLabel l10 = new JLabel("Senior citizen : ");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100,470,180,30);
        add(l10);

        Date currDate = new Date();
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD,14));
        r1.setBackground(new Color(252,208,76));
        r1.setBounds(350,470,100,30);
        r1.setEnabled(false);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD,14));
        r2.setBackground(new Color(252,208,76));
        r2.setBounds(460,470,100,30);
        r2.setEnabled(false);
        add(r2);

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(ageDate);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(currDate);

        int yearDiff = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);

//        ButtonGroup buttonGroup1 = new ButtonGroup();
//        buttonGroup1.add(r1);
//        buttonGroup1.add(r2);
        if(yearDiff >= 60){
            r1.setSelected(true);
        } else{
            r2.setSelected(true);
        }

        JLabel l11 = new JLabel("Existing Account : ");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(100,520,180,30);
        add(l11);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway", Font.BOLD,14));
        e1.setBackground(new Color(252,208,76));
        e1.setBounds(350,520,100,30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway", Font.BOLD,14));
        e2.setBackground(new Color(252,208,76));
        e2.setBounds(460,520,100,30);
        add(e2);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(e1);
        buttonGroup2.add(e2);

        JLabel l12 = new JLabel("Form No : ");
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(700,10,150,30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 14));
        l13.setBounds(770,10,60,30);
        add(l13);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(570,640,100,30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(252,208,76));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox4.getSelectedItem();

        String pan = textPAN.getText();
        String aadhar = textAADHAR.getText();

        String scitizen = "";
        if(r1.isSelected()){
            scitizen = "Yes";
        } else if(r2.isSelected()){
            scitizen = "No";
        }

        String eAccount = "";
        if(e1.isSelected()){
            eAccount = "Yes";
        } else if (e2.isSelected()) {
            eAccount = "No";
        }

        try{
            if(textPAN.getText().equals("") || textAADHAR.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            } else if (textPAN.getText().length() < 10) {
                JOptionPane.showMessageDialog(null,"PAN number should be of 10 digits");
            } else if (textAADHAR.getText().length() < 12) {
                JOptionPane.showMessageDialog(null,"Aadhar number should be of 12 digits");
            } else{
                Connection c1 = new Connection();
                String query = "insert into Signuptwo values('"+formno+"','"+rel+"','"+cate+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eAccount+"')";
                c1.statement.executeUpdate(query);
                new Signup3(formno);
                setVisible(false);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup2("",new Date(12,12,2024));
    }
}
