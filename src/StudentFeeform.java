import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeeform extends JFrame implements ActionListener {

    Choice cid;
    JComboBox cbcourse,cbbranch,cbsemester;
    JLabel labeltotal;
    JButton update, pay, back;



    StudentFeeform(){

        setSize(900,500);
        setLocation(300,100);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);

        JLabel lblid = new JLabel("Select ID");
        lblid.setBounds(40,60,150,20);
        lblid.setFont(new Font("Tohoma",Font.BOLD, 20));
        add(lblid);

        cid = new Choice();
        cid.setBounds(200,60,150,20);
        add(cid);

        try{

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                cid.add(rs.getString("id"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40,100,150,20);
        lblname.setFont(new Font("Tohoma",Font.BOLD, 16));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200,100,150,20);
        labelname.setFont(new Font("Tohoma",Font.PLAIN, 16));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40,140,150,20);
        lblfname.setFont(new Font("Tohoma",Font.BOLD, 16));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(200,140,150,20);
        labelfname.setFont(new Font("Tohoma",Font.PLAIN, 16));
        add(labelfname);

        try{

            Conn c = new Conn();
            String query = "Select * from student where id='"+cid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){

                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        cid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {

                try{

                    Conn c = new Conn();
                    String query = "Select * from student where id='"+cid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){

                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));

                    }

                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        JLabel lbcourse = new JLabel("Course");
        lbcourse.setBounds(40,180,150,20);
        lbcourse.setFont(new Font("Tohoma",Font.BOLD, 16));
        add(lbcourse);

        String course[] = {"....", "BTech", "BCA", "BBA", "Bsc", "Msc", "MBA", "MCA", "M.Tech"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,180,150,20);

        add(cbcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(40,220,150,20);
        lblbranch.setFont(new Font("Tohoma",Font.BOLD, 16));
        add(lblbranch);

        String branch[] = {"....", "Computer Science", "Electrical", "Mechanical", "Civil", "IT", "ECE"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200,220,150,20);
        add(cbbranch);

        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(40,260,150,20);
        lblsemester.setFont(new Font("Tohoma",Font.BOLD, 16));
        add(lblsemester);



        String semester[] = {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200,260,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40,300,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD, 16));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(200,300,150,20);
        labeltotal.setFont(new Font("Tahoma",Font.PLAIN, 16));
        add(labeltotal);

        update = new JButton("Update");
        update.setBounds(30,380,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay");
        pay.setBounds(150,380,100,25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back ");
        back.setBounds(270,380,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);






        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            try {
                Conn  c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"' ");
                while ((rs.next())){
                    labeltotal.setText(rs.getString(semester));
                }


            }catch(Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==pay) {

            String id = cid.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String total = labeltotal.getText();

            try {
                Conn  c = new Conn();
                String query = "insert into collegefee values('"+id+"', '"+course+"', '"+branch+"', '"+semester+"', '"+total+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "College fees Submitted Successfully");



                }catch(Exception e){
                e.printStackTrace();
                }


        }else {
            setVisible(false);
        }

    }




    public static void main(String[] args){
        new StudentFeeform();
    }


}
