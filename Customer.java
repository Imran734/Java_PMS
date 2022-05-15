import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Customer extends JFrame implements MouseListener, ActionListener
{
	private JLabel CLabel, Welcome, PName, QName, ArrayName;
	private JTextField PTextField, QTextField, PayTextField;
	private JTable table;
	private JScrollPane tableScrollPane;
	private JButton b1, b2 ,b3, b4, b5, b6, b7;
	private JRadioButton RadioButton1, RadioButton2, RadioButton3;
	private ButtonGroup ButtonGroup;
	private JPanel panel;
	private String[] columnNames = {"Product Name", "Product ID", "Price", "Quantity"};
	private Object[][] data={{"Drinks", "345", "40.0", "200"},
							{"Medicine", "123", "500.0", "400"}};
	ArrayList ar = new ArrayList();

	public Customer()
	{
		super("Customer Index");
		this.setSize(1300,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		CLabel = new JLabel("Pharmaceutical Management Portal");
		CLabel.setBounds(300, 20, 1000, 50);
		CLabel.setFont(new Font("Forte", 0, 40));
		panel.add(CLabel);
		
		PName = new JLabel("Product Name");
		PName.setBounds(350, 500, 100, 30);
		PName.setVisible(false);
		PName.setEnabled(false);
		panel.add(PName);
		
		PTextField = new JTextField();
		PTextField.setBounds(460, 500, 200, 30);
		PTextField.setVisible(false);
		PTextField.setEnabled(false);
		panel.add(PTextField);
		
		QName = new JLabel("Quantity");
		QName.setBounds(350, 550, 100, 30);
		QName.setVisible(false);
		QName.setEnabled(false);
		panel.add(QName);
		
		QTextField = new JTextField();
		QTextField.setBounds(460, 550, 200, 30);
		QTextField.setVisible(false);
		QTextField.setEnabled(false);
		panel.add(QTextField);
		
		table = new JTable(data, columnNames);
		table.setBackground(Color.ORANGE);
		tableScrollPane = new JScrollPane(table);
		tableScrollPane.setBounds(350, 150, 500, 300);
		tableScrollPane.setViewportView(table);
		tableScrollPane.setVisible(false);
		tableScrollPane.setEnabled(false);
		panel.add(tableScrollPane);
		
		b1 = new JButton("Order Product");
		b1.setBounds(50, 100, 200, 30);
		b1.addActionListener(this);
		panel.add(b1);
		
		b2 = new JButton("Order Details");
		b2.setBounds(50, 150, 200, 30);
		b2.addActionListener(this);
		panel.add(b2);
		
		b3 = new JButton("Payment");
		b3.setBounds(50, 200, 200, 30);
		b3.addActionListener(this);
		panel.add(b3);
		
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
		
		b6 = new JButton("Order");
		b6.setBounds(700, 520, 100, 30);
		b6.setBackground(Color.YELLOW);
		b6.addMouseListener(this);
		b6.addActionListener(this);
		b6.setVisible(false);
		b6.setEnabled(false);
		panel.add(b6);
		
		PayTextField = new JTextField();
		PayTextField.setBounds(400, 130, 200, 30);
		PayTextField.setVisible(false);
		PayTextField.setEnabled(false);
		panel.add(PayTextField);
		
		RadioButton1 = new JRadioButton("Cash");
		RadioButton1.setBounds(400, 180, 100, 25);
		RadioButton1.setBackground(Color.BLUE);
		RadioButton1.addActionListener(this);
		RadioButton1.setVisible(false);
		RadioButton1.setEnabled(false);
		panel.add(RadioButton1);
		
		RadioButton2 = new JRadioButton("Credit");
		RadioButton2.setBounds(400, 220, 100, 25);
		RadioButton2.setBackground(Color.BLUE);
		RadioButton2.addActionListener(this);
		RadioButton2.setVisible(false);
		RadioButton2.setEnabled(false);
		panel.add(RadioButton2);
		
		RadioButton3 = new JRadioButton("BKash");
		RadioButton3.setBounds(400, 260, 100, 25);
		RadioButton3.setBackground(Color.BLUE);
		RadioButton3.addActionListener(this);
		RadioButton3.setVisible(false);
		RadioButton3.setEnabled(false);
		panel.add(RadioButton3);
		
		ButtonGroup = new ButtonGroup();
		ButtonGroup.add(RadioButton1);
		ButtonGroup.add(RadioButton2);
		ButtonGroup.add(RadioButton3);
		
		b7 = new JButton("Ok");
		b7.setBounds(500, 310, 60, 30);
		b7.setBackground(Color.YELLOW);
		b7.addMouseListener(this);
		b7.addActionListener(this);
		b7.setVisible(false);
		b7.setEnabled(false);
		panel.add(b7);
		
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
		else if(button.equals("Order Product"))
		{
			tableScrollPane.setVisible(true);
			tableScrollPane.setEnabled(true);
			PName.setVisible(true);
			PName.setEnabled(true);
			PTextField.setVisible(true);
			PTextField.setEnabled(true);
			QName.setVisible(true);
			QName.setEnabled(true);
			QTextField.setVisible(true);
			QTextField.setEnabled(true);
			b6.setVisible(true);
			b6.setEnabled(true);
			ArrayName.setVisible(false);
			ArrayName.setEnabled(false);
			PayTextField.setVisible(false);
			PayTextField.setEnabled(false);
			RadioButton1.setVisible(false);
			RadioButton1.setEnabled(false);
			RadioButton2.setVisible(false);
			RadioButton2.setEnabled(false);
			RadioButton3.setVisible(false);
			RadioButton3.setEnabled(false);
			b7.setVisible(false);
			b7.setEnabled(false);
		}
		else if(button.equals("Order Details"))
		{
			tableScrollPane.setVisible(false);
			tableScrollPane.setEnabled(false);
			PName.setVisible(false);
			PName.setEnabled(false);
			PTextField.setVisible(false);
			PTextField.setEnabled(false);
			QName.setVisible(false);
			QName.setEnabled(false);
			QTextField.setVisible(false);
			QTextField.setEnabled(false);
			b6.setVisible(false);
			b6.setEnabled(false);
			PayTextField.setVisible(false);
			PayTextField.setEnabled(false);
			RadioButton1.setVisible(false);
			RadioButton1.setEnabled(false);
			RadioButton2.setVisible(false);
			RadioButton2.setEnabled(false);
			RadioButton3.setVisible(false);
			RadioButton3.setEnabled(false);
			b7.setVisible(false);
			b7.setEnabled(false);
		}
		else if(button.equals("Order"))
		{
			String s1 = PTextField.getText();
			String s2 = QTextField.getText();
			insert();
			ar.add(s1);
			ar.add(s2);
			ArrayName = new JLabel("Details : "+ar);
			ArrayName.setBounds(350, 200, 900, 30);
			ArrayName.setFont(new Font("Comic Sans MS", 0, 15));
			panel.add(ArrayName);
			insert();
			JOptionPane.showMessageDialog(this, "Order Received");
			
		}
		else if(button.equals("Payment"))
		{
			tableScrollPane.setVisible(false);
			tableScrollPane.setEnabled(false);
			PName.setVisible(false);
			PName.setEnabled(false);
			PTextField.setVisible(false);
			PTextField.setEnabled(false);
			QName.setVisible(false);
			QName.setEnabled(false);
			QTextField.setVisible(false);
			QTextField.setEnabled(false);
			b6.setVisible(false);
			b6.setEnabled(false);
			PayTextField.setVisible(true);
			PayTextField.setEnabled(true);
			RadioButton1.setVisible(true);
			RadioButton1.setEnabled(true);
			RadioButton2.setVisible(true);
			RadioButton2.setEnabled(true);
			RadioButton3.setVisible(true);
			RadioButton3.setEnabled(true);
			b7.setVisible(true);
			b7.setEnabled(true);
			
		}
		else if(button.equals("Ok"))
		{
			JOptionPane.showMessageDialog(this, "Successful");
		}
		else{}
	}
	
	/*public void test()
	{
        String query = "SELECT `ProductName`, `ProductID`, `ProductPrice`, `ProductQuantity` FROM `product1`;";
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
                String ProductName = rs.getString("ProductName");
                String ProductID = rs.getString("ProductID");
				double ProductPrice = rs.getDouble("ProductPrice");
				int ProductQuantity = rs.getInt("ProductQuantity");
				
				System.out.println("Product ID " +ProductID);
				System.out.println("Product Price " +ProductPrice);
				System.out.println("Product Quantity " +ProductQuantity);
				
				//int i,j;
				Object[][] data ={{},{},{},{}};
				//Object[][] data;
				for(int i=0;i<2;i++)
				{
					data[i][0] = rs.getString("ProductName");
					data[i][1] = rs.getString("ProductID");
					data[i][2] = rs.getDouble("ProductPrice");
					data[i][3] = rs.getInt("ProductQuantity");
				}
				for(int a=0;a<2;a++)
				{
					for(int b=0;b<4;b++)
					{
						System.out.print(data[a][b]+" ");  
					}
				}
				
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
    }*/
	
	public void insert()
	{
		double sales=0, sales1=0, sa1=0, sa=0;
		String query = "SELECT `ProductName`, `ProductID`, `ProductPrice`, `ProductQuantity` FROM `product1` where ProductName='"+PTextField.getText()+"';";
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
				
				String ProductName = rs.getString("ProductName");
                String ProductID = rs.getString("ProductID");
				double ProductPrice = rs.getDouble("ProductPrice");
				int ProductQuantity = rs.getInt("ProductQuantity");
				
				sa=Integer.parseInt(QTextField.getText().toString());
				sales = ProductPrice*sa;
				System.out.println("Sales " +sales);
				
			}
		}
		catch(Exception e){}
		sa1=sa;
		sales1=sales;
		try
		{
			String query1 = "SELECT `Price`, `Quantity`, `ID` FROM `sales` where `ID`="+1+";";
			rs = st.executeQuery(query1);//getting result
			System.out.println("results received");
					
			while(rs.next())
			{

                String ID = rs.getString("ID");
				double Price = rs.getDouble("Price");
				double Quantity = rs.getInt("Quantity");
				
				
				sa1=Quantity+sa1;
				sales1 = Price+sales1;
				System.out.println("Sales " +sales1);
				
			}
			System.out.println(".");
			query1 = "UPDATE sales SET Price="+sales1+" where ID="+1;
			st.executeUpdate(query1);
			query1 = "UPDATE sales SET Quantity="+sa1+" where ID="+1;
			st.executeUpdate(query1);
			st.close();
			con.close();
			rs.close();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}