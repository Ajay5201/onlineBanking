/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinenetbanking;

/**
 *
 * @author ajay
 */import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SIGNUP extends JFrame {

   JLabel l1,l2,l3;
		JTextField t1,t3;
		JPasswordField t2;
		JButton b1;
		SIGNUP(){
			Font f=new Font("Arial",Font.BOLD,24);
			l1=new JLabel("SignUp Page");
			l1.setFont(f);
			l2=new JLabel("UserName");
			t1=new JTextField();
			l3=new JLabel("Password");
			t2=new JPasswordField();
			b1=new JButton("Login");
                        t3=new JTextField();
			l1.setBounds(70,40,200,40);
			l2.setBounds(70,100,100,20);//UserName Label
			t1.setBounds(70,120,200,30);//TextField 
			l3.setBounds(70,170,100,20);
			t2.setBounds(70,190,200,30);
                        t3.setBounds(70,250,200,30);

			b1.setBounds(270,300,100,30);
			add(l1);
			add(l2);
			add(t1);
			add(l3);
			add(t2);
                        add(t3);
			add(b1);
			setLayout(null);
			setVisible(true);
			setSize(400,400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
                                            
                                            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","swetha123");
                                           // String sql="select * from tlogin where user_name='"+t1.getText()+"' and password='"+t2.getText()+"'";
                                          
                                            String sql="insert into tlogin values (?, ?, ?)";
                                            PreparedStatement ps=conn.prepareStatement(sql);
                                            ps.setString(1,t1.getText());
                                             ps.setString(2,t2.getText());
                                             ps.setString(3, t3.getText());
                                            
                                            /*ResultSet rs=ps.executeQuery();
                                            if(rs.next()){
                                                JOptionPane.showMessageDialog(null,"LOGINNNNNNNNNNNNN");
                                                
                                            }
                                            else
                                            {
                                                 JOptionPane.showMessageDialog(null,"LOGINNNNNNNNNNNNNooooo");
                                            }*/
                                            ps.executeUpdate();
                                            JOptionPane.showMessageDialog(null, "done uh");
                                            conn.close();
                               LOGIN2 lllk=new LOGIN2();
                                            lllk.setVisible(true);
                                        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                                        
                                        
				}
			});
		}
    public static void main(String[] args) {
       SIGNUP login1=new SIGNUP();
    }
    
}
