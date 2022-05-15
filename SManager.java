import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SManager extends JFrame implements MouseListener, ActionListener
{
	private JLabel SaLabel, Welcome, S1, S2;
	private JButton b1, b2, b5, b6;
	private JPanel panel;
	private double sales=0;
	private double quantity=0;
	
	public SManager(){}
	public SManager(double p, double q)
	{
		super("Sales Index");
		this.setSize(1300,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		SaLabel = new JLabel("Pharmaceutical Management Portal");
		SaLabel.setBounds(300, 20, 1000, 50);
		SaLabel.setFont(new Font("Forte", 0, 40));
		panel.add(SaLabel);
		
		sales=p;
		quantity=q;
		
		S1 = new JLabel("Total Price : "+sales);
		S1.setBounds(350, 150, 400, 40);
		S1.setFont(new Font("Comic Sans MS", 0, 20));
		S1.setVisible(false);
		S1.setEnabled(false);
		panel.add(S1);
		
		S2 = new JLabel("Total Quantity Sales : "+quantity);
		S2.setBounds(350, 250, 400, 40);
		S2.setFont(new Font("Comic Sans MS", 0, 20));
		S2.setVisible(false);
		S2.setEnabled(false);
		panel.add(S2);
		
		b1 = new JButton("Targeted Sales Record");
		b1.setBounds(50, 100, 200, 30);
		b1.addActionListener(this);
		panel.add(b1);
		
		b2 = new JButton("Sales History");
		b2.setBounds(50, 150, 200, 30);
		b2.addActionListener(this);
		panel.add(b2);
		
		b5 = new JButton("Log out");
		b5.setBounds(1120, 20, 100, 20);
		b5.setBackground(Color.BLUE);
		b5.addMouseListener(this);
		b5.addActionListener(this);
		panel.add(b5);
		
		Welcome = new JLabel("Welcome");
		Welcome.setBounds(1050, 20, 60, 20);
		panel.add(Welcome);
		
		b6 = new JButton("Back");
		b6.setBounds(50, 600, 100, 30);
		b6.setBackground(Color.GREEN);
		b6.addMouseListener(this);
		b6.addActionListener(this);
		panel.add(b6);
		
		this.add(panel);
	}
	
	public void mouseClicked(MouseEvent m){}
	public void mousePressed(MouseEvent m){}
	public void mouseReleased(MouseEvent m){}
	public void mouseEntered(MouseEvent m)
	{
		JButton b = (JButton) m.getComponent();
		if(b==b5)
		{
			b5.setBackground(Color.RED);
		}
		else if(b==b6)
		{
			b6.setBackground(Color.RED);
		}
		else{}
	}
	public void mouseExited(MouseEvent m)
	{
		JButton b = (JButton) m.getComponent();
		if(b==b5)
		{
			b5.setBackground(Color.BLUE);
		}
		else if(b==b6)
		{
			b6.setBackground(Color.GREEN);
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
		else if(button.equals("Targeted Sales Record"))
		{
			test();
			S1.setVisible(true);
			S1.setEnabled(true);
		}
		else if(button.equals("Sales History"))
		{
			test();
			S2.setVisible(true);
			S2.setEnabled(true);
		}
		else{}
	}
	public void test()
	{
		String query = "SELECT `Price`, `Quantity`, `ID` FROM `sales`;";
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharma","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
					
			while(rs.next())
			{
				
				String ID = rs.getString("ID");
				double Price = rs.getDouble("Price");
				double Quan = rs.getDouble("Quantity");
				
				sales = Price;
				quantity = Quan;
				
			}
		}
		catch(Exception e){}
		try
		{
			System.out.println(".");
			st.close();
			con.close();
			rs.close();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}