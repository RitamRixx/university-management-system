import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About(){
        setSize(750,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,300,200);
        add(image);

        JLabel heading =new JLabel("<html>University<br/>Management System</html");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font("Tohoma", Font.BOLD, 30));
        add(heading);

        JLabel name =new JLabel("Developed By: Ritam Rakshit");
        name.setBounds(130,220,550,40);
        name.setFont(new Font("Tohoma", Font.BOLD, 30));
        add(name);

        JLabel contact =new JLabel("Contact: ritamrakshit2022@gmail.com");
        contact.setBounds(170,250,550,40);
        contact.setFont(new Font("Tohoma", Font.PLAIN, 20));
        add(contact);




        setLayout(null);

        setVisible(true);
    }



    public static void main(String[] args){
        new About();
    }
}
