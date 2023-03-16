import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {




    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfaadhar;
    JLabel labelid;
    JDateChooser dcdob;
    JComboBox cbcourse, cbbranch;
    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent(){

        setSize(900, 700);
        setLocation(350, 50);

        setLayout(null);


        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);


        JLabel lblid = new JLabel("ID");
        lblid.setBounds(50,200,200,30);
        lblid.setFont(new Font("serif",Font.BOLD, 20));
        add(lblid);

        labelid = new JLabel("1100"+first4);
        labelid.setBounds(200,200,200,30);
        labelid.setFont(new Font("serif",Font.BOLD, 20));
        add(labelid);


        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);


        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,550,30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(50,300,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200,300,150,30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(400,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(600,300,150,30);
        add(tfemail);

        JLabel lblx = new JLabel("10th %");
        lblx.setBounds(50,350,200,30);
        lblx.setFont(new Font("serif",Font.BOLD, 20));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(200,350,150,30);
        add(tfx);

        JLabel lblxii = new JLabel("12th %");
        lblxii.setBounds(400,350,200,30);
        lblxii.setFont(new Font("serif",Font.BOLD, 20));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(600,350,150,30);
        add(tfxii);

        JLabel lbaadhar = new JLabel("Aadhar No.");
        lbaadhar.setBounds(50,400,200,30);
        lbaadhar.setFont(new Font("serif",Font.BOLD, 20));
        add(lbaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,400,150,30);
        add(tfaadhar);

        JLabel lbcourse = new JLabel("Course");
        lbcourse.setBounds(50,450,200,30);
        lbcourse.setFont(new Font("serif",Font.BOLD, 20));
        add(lbcourse);

        String course[] = {"....", "B.Tech", "BCA", "BBA", "Bsc", "Msc", "MBA", "MCA", "M.Tech"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,450,150,30);

        add(cbcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400,450,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD, 20));
        add(lblbranch);

        String branch[] = {"....", "Computer Science", "Electrical", "Mechanical", "Civil", "IT", "ECE"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600,450,150,30);
        add(cbbranch);

        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(cancel);








        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String name = tfname.getText();
            String fname = tffname.getText();
            String id = labelid.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String aadhar = tfaadhar.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();

            try{
                String query = "insert into student values('"+name+"', '"+fname+"', '"+id+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+aadhar+"', '"+course+"', '"+branch+"')";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Student Details Inserted Successfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }


    public static void main(String[] args){

        new AddStudent();

    }


}
