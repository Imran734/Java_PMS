import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PManager extends JFrame implements MouseListener, ActionListener
{
	private JLabel PLabel, NLabel, ILabel, PriLabel, QLabel, Welcome, IDLabel;
	private JTable table;
	private JScrollPane tableScrollPane;
	private JTextField NameTextField, IDTextField, PriceTextField, QuantityTextField, IDfield;
	private JButton Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9;
	private JPanel panel;
	private String[] columnNames = {"Product Name", "Product ID", "Price", "Quantity"};
	
	public PManager()
	{
		super("Product Index");
		this.setSize(1300,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		PLabel = new JLabel("Pharmaceutical Management Portal");
		PLabel.setBounds(300, 20, 1000, 50);
		PLabel.setFont(new Font("Forte", 0, 40));
		panel.add(PLabel);
		
		NLabel = new JLabel("Product Name");
		NLabel.setBounds(350, 100, 100, 30);
		NLabel.setVisible(false);
		NLabel.setEnabled(false);
		panel.add(NLabel);
		
		NameTextField = new JTextField();
		NameTextField.setBounds(460, 100, 300, 30);
		NameTextField.setVisible(false);
		NameTextField.setEnabled(false);
		panel.add(NameTextField);
		
		ILabel = new JLabel("Product ID");
		ILabel.setBounds(350, 150, 100, 30);
		ILabel.setVisible(false);
		ILabel.setEnabled(false);
		panel.add(ILabel);
		
		IDTextField = new JTextField();
		IDTextField.setBounds(460, 150, 300, 30);
		IDTextField.setVisible(false);
		IDTextField.setEnabled(false);
		panel.add(IDTextField);
		
		PriLabel = new JLabel("Product Price");
		PriLabel.setBounds(350, 200, 100, 30);
		PriLabel.setVisible(false);
		PriLabel.setEnabled(false);
		panel.add(PriLabel);
		
		PriceTextField = new JTextField();
		PriceTextField.setBounds(460, 200, 300, 30);
		PriceTextField.setVisible(false);
		PriceTextField.setEnabled(false);
		panel.add(PriceTextField);
		
		QLabel = new JLabel("Product Quantity");
		QLabel.setBounds(350, 250, 100, 30);
		QLabel.setVisible(false);
		QLabel.setEnabled(false);
		panel.add(QLabel);
		
		QuantityTextField = new JTextField();
		QuantityTextField.setBounds(460, 250, 300, 30);
		QuantityTextField.setVisible(false);
		QuantityTextField.setEnabled(false);
		panel.add(QuantityTextField);
		
		Button1 = new JButton("Home");
		Button1.setBounds(50, 100, 200, 30);
		Button1.addActionListener(this);
		panel.add(Button1);
		
		Button2 = new JButton("Add Product");
		Button2.setBounds(50, 150, 200, 30);
		Button2.addActionListener(this);
		panel.add(Button2);
		
		Button3 = new JButton("Delete Product");
		Button3.setBounds(50, 200, 200, 30);
		Button3.addActionListener(this);
		panel.add(Button3);
		
		IDLabel = new JLabel("Enter Product ID");
		IDLabel.setBounds(350, 400, 100, 30);
		IDLabel.setVisible(false);
		IDLabel.setEnabled(false);
		panel.add(IDLabel);
		
		IDfield = new JTextField();
		IDfield.setBounds(460, 400, 300, 30);
		IDfield.setVisible(false);
		IDfield.setEnabled(false);
		panel.add(IDfield);
		
		Button6 = new JButton("Add Product Features");
		Button6.setBounds(50, 250, 200, 30);
		Button6.addActionListener(this);
		panel.add(Button6);
		
		Button7 = new JButton("Add");
		Button7.setBounds(700, 300, 60, 30);
		Button7.setBackground(Color.YELLOW);
		Button7.addActionListener(this);
		Button7.setVisible(false);
		Button7.setEnabled(false);
		panel.add(Button7);
		
		Button9 = new JButton("Ok");
		Button9.setBounds(700, 300, 60, 30);
		Button9.setBackground(Color.YELLOW);
		Button9.addActionListener(this);
		Button9.setVisible(false);
		Button9.setEnabled(false);
		panel.add(Button9);
		
		Button8 = new JButton("Delete");
		Button8.setBounds(680, 450, 80, 30);
		Button8.setBackground(Color.RED);
		Button8.addActionListener(this);
		Button8.setVisible(false);
		Button8.setEnabled(false);
		panel.add(Button8);
		
		Button4 = new JButton("Log out");
		Button4.setBounds(1120, 20, 100, 20);
		Button4.setBackground(Color.BLUE);
		Button4.addMouseListener(this);
		Button4.addActionListener(this);
		panel.add(Button4);
		
		Welcome = new JLabel("Welcome");
		Welcome.setBounds(1050, 20, 60, 20);
		panel.add(Welcome);
		
		Button5 = new JButton("Back");
		Button5.setBounds(50, 600, 100, 30);
		Button5.setBackground(Color.GREEN);
		Button5.addMouseListener(this);
		Button5.addActionListener(this);
		panel.add(Button5);
		
		this.add(panel);
		
	}
	
	public void mouseClicked(MouseEvent m){}
	public void mousePressed(MouseEvent m){}
	public void mouseReleased(MouseEvent m){}
	public void mouseEntered(MouseEvent m)
	{
		JButton b = (JButton) m.getComponent();
		if(b==Button4)
		{
			Button4.setBackground(Color.RED);
		}
		else if(b==Button5)
		{
			Button5.setBackground(Color.RED);
		}
		else{}
	}
	public void mouseExited(MouseEvent m)
	{
		JButton b = (JButton) m.getComponent();
		if(b==Button4)
		{
			Button4.setBackground(Color.BLUE);
		}
		else if(b==Button5)
		{
			Button5.setBackground(Color.GREEN);
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
		else if(button.equals("Add Product"))
		{
			NLabel.setVisible(true);
			NLabel.setEnabled(true);
			ILabel.setVisible(true);
			ILabel.setEnabled(true);
			PriLabel.setVisible(true);
			PriLabel.setEnabled(true);
			QLabel.setVisible(true);
			QLabel.setEnabled(true);
			NameTextField.setVisible(true);
			NameTextField.setEnabled(true);
			IDTextField.setVisible(true);
			IDTextField.setEnabled(true);
			PriceTextField.setVisible(true);
			PriceTextField.setEnabled(true);
			QuantityTextField.setVisible(true);
			QuantityTextField.setEnabled(true);
			Button7.setVisible(true);
			Button7.setEnabled(true);
			Button9.setVisible(false);
			Button9.setEnabled(false);
		
		}
		else if(button.equals("Add Product Features"))
		{
			ILabel.setVisible(true);
			ILabel.setEnabled(true);
			PriLabel.setVisible(true);
			PriLabel.setEnabled(true);
			QLabel.setVisible(true);
			QLabel.setEnabled(true);
			IDTextField.setVisible(true);
			IDTextField.setEnabled(true);
			PriceTextField.setVisible(true);
			PriceTextField.setEnabled(true);
			QuantityTextField.setVisible(true);
			QuantityTextField.setEnabled(true);
			Button9.setVisible(true);
			Button9.setEnabled(true);
			Button7.setVisible(false);
			Button7.setEnabled(false);
			NLabel.setVisible(false);
			NLabel.setEnabled(false);
			NameTextField.setVisible(false);
			NameTextField.setEnabled(false);
			IDLabel.setVisible(false);
			IDLabel.setEnabled(false);
			IDfield.setVisible(false);
			IDfield.setEnabled(false);
			Button8.setVisible(false);
			Button8.setEnabled(false);
		
		}
		else if(button.equals("Add"))
		{
			insertIntoDB();
			JOptionPane.showMessageDialog(this, "Product Added");
		}
		else if(button.equals("Ok"))
		{
			updateInDB();
			JOptionPane.showMessageDialog(this, "Features Added");
		}
		else if(button.equals("Delete Product"))
		{
			IDLabel.setVisible(true);
			IDLabel.setEnabled(true);
			IDfield.setVisible(true);
			IDfield.setEnabled(true);
			Button8.setVisible(true);
			Button8.setEnabled(true);
		}
		else if(button.equals("Delete"))
		{
			deleteFromDB();
			JOptionPane.showMessageDialog(this, "Product Deleted");
		}
		else if(button.equals("Home"))
		{
			NLabel.setVisible(false);
			NLabel.setEnabled(false);
			ILabel.setVisible(false);
			ILabel.setEnabled(false);
			PriLabel.setVisible(false);
			PriLabel.setEnabled(false);
			QLabel.setVisible(false);
			QLabel.setEnabled(false);
			NameTextField.setVisible(false);
			NameTextField.setEnabled(false);
			IDTextField.setVisible(false);
			IDTextField.setEnabled(false);
			PriceTextField.setVisible(false);
			PriceTextField.setEnabled(false);
			QuantityTextField.setVisible(false);
			QuantityTextField.setEnabled(false);
			Button7.setVisible(false);
			Button7.setEnabled(false);
			IDLabel.setVisible(false);
			IDLabel.setEnabled(false);
			IDfield.setVisible(false);
			IDfield.setEnabled(false);
			Button8.setVisible(false);
			Button8.setEnabled(false);
			Button9.setVisible(false);
			Button9.setEnabled(false);
		
		}
		else{}
	}
	
	public void test()
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
			System.out.println("Product Name \t\t Product ID \t Product Price \t Product Quantity  ");
					
			
			while(rs.next())
			{
                String ProductName = rs.getString("ProductName");
                String ProductID = rs.getString("ProductID");
				double ProductPrice = rs.getDouble("ProductPrice");
				int ProductQuantity = rs.getInt("ProductQuantity");
				
				/*System.out.println(ProductName+" \t\t "+ProductID+" \t\t "+ProductPrice+" \t\t "+ProductQuantity);
				System.out.println("Product ID " +ProductID);
				System.out.println("Product Price " +ProductPrice);
				System.out.println("Product Quantity " +ProductQuantity);*/
				
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
    }
	
	public void insertIntoDB()
	{
		String query = "INSERT INTO product1 VALUES ('"+NameTextField.getText()+"','"+IDTextField.getText()+"',"+PriceTextField.getText()+","+QuantityTextField.getText()+");";
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
	
	public void updateInDB()
	{
		int quantity=0;
		double price=0;
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
				
				quantity = Integer.parseInt(QuantityTextField.getText());
				price = Double.parseDouble(PriceTextField.getText());
			}
		}
		catch(Exception e){}
		try
		{
			System.out.println(".");
			query = "UPDATE product1 SET ProductPrice="+price+" where ProductID="+IDTextField.getText();
			st.executeUpdate(query);
			query = "UPDATE product1 SET ProductQuantity="+quantity+" where ProductID="+IDTextField.getText();
			st.executeUpdate(query);
			st.close();
			con.close();
			rs.close();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	public void deleteFromDB()
	{
		String query = "DELETE from product1 where ProductID='"+IDfield.getText()+"';";
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

