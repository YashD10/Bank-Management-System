package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Services extends JFrame implements ActionListener {

    String cardno, pin;
    JButton b7,b8;
    JCheckBox c1,c2,c3,c4,c5,c6;

    Services(String pin, String cardno){
        this.cardno = cardno;
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label = new JLabel("Your services :");
        label.setBounds(430,180,700,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,28));
        l3.add(label);


        c1 = new JCheckBox("ATM CARD");
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(65,125,128));
        c1.setFont(new Font("Raleway",Font.BOLD,13));
        c1.setBounds(410,274,150,35);
        l3.add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setForeground(Color.WHITE);
        c2.setBackground(new Color(65,125,128));
        c2.setFont(new Font("Raleway",Font.BOLD,13));
        c2.setBounds(700,274,150,35);
        l3.add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setForeground(Color.WHITE);
        c3.setBackground(new Color(65,125,128));
        c3.setFont(new Font("Raleway",Font.BOLD,13));
        c3.setBounds(410,318,150,35);
        l3.add(c3);

        c4 = new JCheckBox("Email Alerts");
        c4.setForeground(Color.WHITE);
        c4.setBackground(new Color(65,125,128));
        c4.setFont(new Font("Raleway",Font.BOLD,13));
        c4.setBounds(700,318,150,35);
        l3.add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setForeground(Color.WHITE);
        c5.setBackground(new Color(65,125,128));
        c5.setFont(new Font("Raleway",Font.BOLD,13));
        c5.setBounds(410,362,150,35);
        l3.add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setForeground(Color.WHITE);
        c6.setBackground(new Color(65,125,128));
        c6.setFont(new Font("Raleway",Font.BOLD,13));
        c6.setBounds(700,362,150,35);
        l3.add(c6);


        b7 = new JButton("SUBMIT");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65,125,128));
        b7.setBounds(700,406,150,35);
        b7.addActionListener(this);
        l3.add(b7);

        b8 = new JButton("BACK");
        b8.setForeground(Color.WHITE);
        b8.setBackground(new Color(65,125,128));
        b8.setBounds(410,406,150,35);
        b8.addActionListener(this);
        l3.add(b8);

        try{
            Connection connection = new Connection();
            String query = "select facility from signupthree where pin = '"+pin+"' and card_number = '"+cardno+"'";
            ResultSet resultSet = connection.statement.executeQuery(query);
            String facility = "";

            while (resultSet.next()){
                facility = ""+resultSet.getString("facility");
            }

            if(facility.contains("ATM")){
                c1.setSelected(true);
            }
            if(facility.contains("Internet")){
                c2.setSelected(true);
            }
            if(facility.contains("Mobile")){
                c3.setSelected(true);
            }
            if(facility.contains("Email")){
                c4.setSelected(true);
            }
            if(facility.contains("Cheque")){
                c5.setSelected(true);
            }
            if(facility.contains("Statement")){
                c6.setSelected(true);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }



        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b8){
            new Main_Class(pin,cardno);
        }
        if(e.getSource() == b7){
            ArrayList<String> facility = new ArrayList<>();

            if(c1.isSelected()){
                facility.add("ATM Card");
            }
            if (c2.isSelected()) {
                facility.add("Internet Banking");
            }
            if (c3.isSelected()) {
                facility.add("Mobile Banking");
            }
            if (c4.isSelected()) {
                facility.add("Email Alerts");
            }
            if (c5.isSelected()) {
                facility.add("Cheque Book");
            }
            if (c6.isSelected()) {
                facility.add("E-Statement");
            }

            try{
                Connection connection = new Connection();
                String query = "update signupthree set fagit cility = '"+facility+"' where pin = '"+pin+"' and card_number = '"+cardno+"'";
                connection.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Services are updated");
                setVisible(false);
                new Main_Class(pin,cardno);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Services("","");
    }
}
