package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener{

    String pin;
    TextField textField;
    JButton b1,b2;
    String cardno;

    Withdrawal(String pin, String cardno){

        this.pin = pin;
        this.cardno = cardno;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);


        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL AMOUNT IS RS.10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("SYSTEM",Font.BOLD,16));
        label1.setBounds(460,180,700,35);
        l3.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("SYSTEM",Font.BOLD,16));
        label2.setBounds(460,220,400,35);
        l3.add(label2);

        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,260,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char alphabets = e.getKeyChar();
                if(!Character.isDigit(alphabets) && alphabets != KeyEvent.VK_BACK_SPACE && alphabets != KeyEvent.VK_DELETE){
                    e.consume();
                }
                if(textField.getText().length() >= 7){
                    e.consume();
                }

            }
        });
        l3.add(textField);

        b1 = new JButton("WITHDRAWAL");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {


            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter an amount you want to withdraw");
                } else {
                    Connection connection = new Connection();
                    ResultSet resultSet = connection.statement.executeQuery("select * from bank where pin = '" + pin + "' and card_number = '"+cardno+"'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    connection.statement.executeUpdate("insert into bank values('"+cardno+"', '" + pin + "','" + date + "','Withdrawal','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited successfully");
                    setVisible(false);
                    new Main_Class(pin,cardno);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
            new Main_Class(pin,cardno);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("","");
    }
}
