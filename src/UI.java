import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UI extends JFrame implements ActionListener
{
    JTextField field1,field2;
    JLabel fname,lname,year1,department1;
    JButton btn;
    JLabel start,submit;
    JComboBox cb,ct;
    public UI()
    {
        Font f=new Font("SansSerif",Font.BOLD,30);
        Font f1=new Font("SansSerif",Font.BOLD,15);


        super.setTitle("Email Generation System For NITP");
        super.setIconImage(new ImageIcon("img/nitp.jpg").getImage());
        super.setBounds(100, 20, 550, 550);
        ////////////////////////////////////////////////
        int x=90;
        int h=25;
        start = new JLabel("Welcome to NIT Patna");
        start.setBounds(50, 10, 450, h);
        super.add(start);
        start.setFont(f);


        fname=new JLabel("Enter Your First Name");
        fname.setBounds(x,70, 300, h);
        super.add(fname);
        field1=new JTextField("");
        field1.setBounds(x,100, 300, h+5);
        super.add(field1);
        fname.setFont(f1);


        lname=new JLabel("Enter Your Last Name");
        lname.setBounds(x,150, 300, h);
        super.add(lname);
        lname.setFont(f1);


        field2=new JTextField("");
        field2.setBounds(x,180, 300, h+5);
        super.add(field2);

        year1=new JLabel("Select Your Year");
        year1.setBounds(x,220, 300, h);
        super.add(year1);
        year1.setFont(f1);


        String[] department= {"18","19","20","21"};
        cb=new JComboBox(department);
        cb.setBounds(x,250, 200, h+5);
        super.add(cb);

        department1=new JLabel("Select Your Depeartment");
        department1.setBounds(x,290, 300, h);
        super.add(department1);
        department1.setFont(f1);


        String[] departments= {"cse","me","ce","ece","ee"};
        ct=new JComboBox(departments);
        ct.setBounds(x,320, 200, h+5);
        super.add(ct);

        submit=new JLabel("Hit the Submit button to generate your Official Gmail ID and Password ");
        submit.setBounds(x-10,360,500, h);
        super.add(submit);


        btn=new JButton("Submit");
        btn.setBounds(x,400, 150, h+20);
        super.add(btn);
        btn.addActionListener(this);










        //////////////////////////////////////////
        super.setResizable(false);
        super.setLayout(null);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        //JOptionPane.showMessageDialog(this,cb.getSelectedItem());
        //generateEmail(field1.getText(),field2.getText(),cb.getSelectedItem().toString())
        JOptionPane.showMessageDialog(this,generateEmail(field1.getText(),field2.getText(),cb.getSelectedItem().toString(),ct.getSelectedItem().toString()));
        ;		this.dispose();
    }





    private String generateEmail(String fname, String lname,String yr,String dept)
    {
        String email=fname+lname.charAt(0)+"."+"ug"+yr+"."+dept+"@"+"nitp.ac.in";
        //call methood which generate password
        int length=8;

        return "Your generated email id--\n"+email+"\nPassword for your Email ID is ---\n"+setpassword(length);



    }
    private String setpassword(int length)
    {
        String s_alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String c_alpha=s_alpha.toLowerCase();
        String num="1234567890";
        String symbol="!@#$%^&*()=+><?\"|";
        String value=s_alpha+c_alpha+num+symbol;



        char[] pass=new char[length];
        for (int i = 0; i <length; i++)
        {
            int random=(int) (Math.random() * value.length());
            pass[i]=value.charAt(random);
        }
        return new String(pass);
    }


    public static void main(String[] args)
    {
        UI u=new UI();


    }
}