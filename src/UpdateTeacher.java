import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateTeacher extends JFrame implements ActionListener {




    JTextField tfcourse, tfaddress, tfphone, tfemail, tfbranch;
    JLabel labelempid;


    JButton submit, cancel;
    Choice cempid;



    UpdateTeacher(){

        setSize(900, 650);
        setLocation(350, 50);

        setLayout(null);


        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma",Font.ITALIC, 35));
        add(heading);

        JLabel lblid = new JLabel("Select ID");
        lblid.setBounds(50,100,200,20);
        lblid.setFont(new Font("serif",Font.PLAIN, 20));
        add(lblid);

        cempid = new Choice();
        cempid.setBounds(250,100,200,20);
        add(cempid);

        try{

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD, 20));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("Tohoma",Font.PLAIN, 18));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD, 20));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(600,150,150,30);
        labelfname.setFont(new Font("Tohoma",Font.PLAIN, 18));
        add(labelfname);


        lblid = new JLabel("Employee ID");
        lblid.setBounds(50,200,200,30);
        lblid.setFont(new Font("serif",Font.BOLD, 20));
        add(lblid);

        labelempid = new JLabel();
        labelempid.setBounds(200,200,200,30);
        labelempid.setFont(new Font("serif",Font.PLAIN, 18));
        add(labelempid);


        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD, 20));
        add(lbldob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(600,200,150,30);
        labeldob.setFont(new Font("Tohoma",Font.PLAIN, 18));
        add(labeldob);


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

        JLabel labelx = new JLabel();
        labelx.setBounds(200,350,150,30);
        labelx.setFont(new Font("Tohoma",Font.PLAIN, 18));
        add(labelx);

        JLabel lblxii = new JLabel("12th %");
        lblxii.setBounds(400,350,200,30);
        lblxii.setFont(new Font("serif",Font.BOLD, 20));
        add(lblxii);

        JLabel labelxii = new JLabel();
        labelxii.setBounds(600,350,150,30);
        labelxii.setFont(new Font("Tohoma",Font.PLAIN, 18));
        add(labelxii);

        JLabel lbaadhar = new JLabel("Aadhar No.");
        lbaadhar.setBounds(50,400,200,30);
        lbaadhar.setFont(new Font("serif",Font.BOLD, 20));
        add(lbaadhar);

        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(200,400,150,30);
        labelaadhar.setFont(new Font("Tohoma",Font.PLAIN, 18));
        add(labelaadhar);

        JLabel lbcourse = new JLabel("Education");
        lbcourse.setBounds(50,450,200,30);
        lbcourse.setFont(new Font("serif",Font.BOLD, 20));
        add(lbcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(200,450,150,30);
        add(tfcourse);

        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400,450,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD, 20));
        add(lblbranch);

        tfbranch = new JTextField();
        tfbranch.setBounds(600,450,150,30);
        add(tfbranch);

        try{

            Conn c = new Conn();
            String query = "Select * from teacher where empid='"+ cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){

                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("class_x"));
                labelxii.setText(rs.getString("class_xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelempid.setText(rs.getString("empid"));
                tfcourse.setText(rs.getString("education"));
                tfbranch.setText(rs.getString("department"));






            }

        }catch(Exception e){
            e.printStackTrace();
        }

        cempid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {

                try{

                    Conn c = new Conn();
                    String query = "Select * from teacher where empid='"+ cempid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){

                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("class_x"));
                        labelxii.setText(rs.getString("class_xii"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        labelempid.setText(rs.getString("empid"));
                        tfcourse.setText(rs.getString("education"));
                        tfbranch.setText(rs.getString("department"));






                    }

                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        submit = new JButton("Update");
        submit.setBounds(250,500,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(cancel);








        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String empid = labelempid.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course =tfcourse.getText();
            String branch = tfbranch.getText();

            try{
                String query = "update techer set address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+course+"', department = '"+branch+"' where empid = '"+empid+"'";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Student Details Updated Successfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }


    public static void main(String[] args){

        new UpdateTeacher();

    }


}
