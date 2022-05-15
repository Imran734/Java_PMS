import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Admin extends JFrame implements MouseListener, ActionListener
{
	private JLabel CLabel, Welcome, ELabel;
	private JTextField EmailTextField;
	private JButton b1, b2 ,b3, b4, b5, b6;
	private JPanel panel;
	
	public Admin()
	{
		super("Admin Index");
		this.setSize(1300,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		CLabel = new JLabel("Pharmaceutical Management Portal");
		CLabel.setBounds(300, 20, 1000, 50);
		CLabel.setFont(new Font("Forte", 0, 40));
		panel.add(CLabel);
		
		ELabel = new JLabel("Email :");
		ELabel.setBounds(350, 200, 50, 40);
		ELabel.setVisible(false);
		ELabel.setEnabled(false);
		panel.add(ELabel);
		
		EmailTextField = new JTextField();
		EmailTextField.setBounds(420, 200, 350, 40);
		EmailTextField.setVisible(false);
		EmailTextField.setEnabled(false);
		panel.add(EmailTextField);
		
		b1 = new JButton("Home");
		b1.setBounds(50, 100, 200, 30);
		b1.addActionListener(this);
		panel.add(b1);
		
		b2 = new JButton("Delete Account");
		b2.setBounds(50, 150, 200, 30);
		b2.addActionListener(this);
		panel.add(b2);
		
		b4 = new JButton("Back");
		b4.setBounds(50, 600, 100, 30);
		b4.setBackground(Color.GREEN);
		b4.addMouseListener(this);
		b4.addActionListener(this);
		panel.add(b4);
		
		Welcome = new JLabel("Welcome");
		Welcome.setBounds(1050, 20, 60, 20);
		panel.add(Welcome);
		
		b5 = new JButton("Log out");
		b5.setBounds(1120, 20, 100, 20);
		b5.setBackground(Color.BLUE);
		b5.addMouseListener(this);
		b5.addActionListener(this);
		panel.add(b5);
		
		b6 = new JButton("Delete");
		b6.setBounds(650, 300, 80, 30);
		b6.setBackground(Color.RED);
		b6.addActionListener(this);
		b6.setVisible(false);
		b6.setEnabled(false);
		panel.add(b6);
		
		this.add(panel);
	}
	
	public void mouseClicked(MouseEvent m){}
	public void mousePressed(MouseEvent m){}
	public void mouseReleased(MouseEvent m){}
	public void mouseEntered(MouseEvent m)
	{
		JButton b = (JButton) m.getComponent();
		if(b==b4)
		{
			b4.setBackground(Color.RED);
		}
		else if(b==b5)
		{
			b5.setBackground(Color.RED);
		}
		else{}
	}
	public void mouseExited(MouseEvent m)
	{
		JButton b = (JButton) m.getComponent();
		if(b==b4)
		{
			b4.setBackground(Color.GREEN);
		}
		else if(b==b5)
		{
			b5.setBackground(Color.BLUE);
		}
		else{}
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String button = a.getActionCommand();
		
		if(button.equals("Log out"))
		{
			System.out.println("Log out Clicked");
			Login l = new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(button.equals("Back"))
		{
			System.out.println("Back Clicked");
			Login l = new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(button.equals("Delete Account"))
		{
			ELabel.setVisible(true);
			ELabel.setEnabled(true);
			EmailTextField.setVisible(true);
			EmailTextField.setEnabled(true);
			b6.setVisible(true);
			b6.setEnabled(true);
		}
		else if(button.equals("Delete"))
		{
			System.out.println("Delete Clicked");
			deleteFromDB();
			JOptionPane.showMessageDialog(this, "Account Deleted");
		}
		else if(button.equals("Home"))
		{
			ELabel.setVisible(false);
			ELabel.setEnabled(false);
			EmailTextField.setVisible(false);
			EmailTextField.setEnabled(false);
			b6.setVisible(false);
			b6.setEnabled(false);
		}
		else{}
	}
	public void deleteFromDB()
	{
		String query = "DELETE from account where Email='"+EmailTextField.getText()+"';";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharma", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			stm.close();
			con.close();
					
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
    }
}