package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {

    String pin;
    JButton button;
    String cardno;

    Mini(String pin, String cardno){
        this.pin = pin;
        this.cardno = cardno;

        getContentPane().setBackground(new Color(255,204,204));
        setSize(400,1080);
        setLocation(20,20);
        setLayout(null);

        JLabel label1 = new JLabel();
        label1.setBounds(20,40,400,650);
        add(label1);

        JLabel label2 = new JLabel();
        label2.setFont(new Font("System",Font.BOLD,15));
        label2.setBounds(150,20,200,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,20,300,20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20,700,300,20);
        add(label4);

        try{
            Connection connection = new Connection();
            ResultSet resultSet = connection.statement.executeQuery("select * from login where pin = '"+pin+"' and  card_number = '"+cardno+"'");
            while (resultSet.next()){
                label3.setText("Card Number: "+ resultSet.getString("card_number").substring(0,4)+"XXXXXXXX"+resultSet.getString("card_number").substring(12));

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        try{
            int balance = 0;
            Connection connection = new Connection();

            ResultSet resultSet = connection.statement.executeQuery("select * from bank where pin = '"+pin+"' and card_number = '"+cardno+"'");


            while (resultSet.next()){

                label1.setText(label1.
                        getText()+"<html>"+resultSet.
                        getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.
                        getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.
                        getString("amount")+"<br><br><html>");



                if(resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }




            label4.setText("Your Total Balance is Rs "+balance);



        }catch (Exception exception){
            exception.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20,750,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Mini("","");
    }
}
