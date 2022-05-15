import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements MouseListener, ActionListener
{
	private JLabel PLabel,UserNameLabel,PasswordNameLabel,Access,Lang;
	private JTextField LoginTextField;
	private JPasswordField LoginPasswordField;
	private JButton LoginButton1, LoginButton2;
	//private JRadioButton LoginRadioButton1, LoginRadioButton2, LoginRadioButton3;
	//private ButtonGroup LoginButtonGroup1;
	private JCheckBox LoginCheckBox1;
	private JComboBox LoginCombo1;
	private JPanel panel;
	private boolean flag;
	private String Language[] = {"English","Bangla","Hindi"};
	
	public Login()
	{
		super("Online Login");
		this.setSize(1300,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.orange);
		panel.setLayout(null);
		
		PLabel = new JLabel("Pharmaceutical Management");
		PLabel.setBounds(300, 50, 1300, 90);
		PLabel.setFont(new Font("Forte", 0, 40));
		panel.add(PLabel);
		
		UserNameLabel = new JLabel("User Name");
		UserNameLabel.setBounds(300, 160, 350, 10);
		panel.add(UserNameLabel);
		
		LoginTextField = new JTextField();
		LoginTextField.setBounds(300, 180, 400, 40);
		LoginTextField.setBackground(Color.YELLOW);
		panel.add(LoginTextField);
		
		PasswordNameLabel = new JLabel("Password");
		PasswordNameLabel.setBounds(300, 230, 350, 10);
		panel.add(PasswordNameLabel);
		
		LoginPasswordField = new JPasswordField();
		LoginPasswordField.setBounds(300, 250, 400, 40);
		LoginPasswordField.setBackground(Color.YELLOW);
		panel.add(LoginPasswordField);
		
		LoginButton1 = new JButton("Log In");
		LoginButton1.setBounds(300, 300, 100, 30);
		LoginButton1.setFont(new Font("Cooper Black", 0, 16));
		LoginButton1.setBackground(Color.BLUE);
		LoginButton1.addMouseListener(this);
		LoginButton1.addActionListener(this);
		panel.add(LoginButton1);
		
		LoginButton2 = new JButton("Sign up");
		LoginButton2.setBounds(450, 300, 100, 30);
		LoginButton2.setFont(new Font("Cooper Black", 0, 16));
		LoginButton2.setBackground(Color.GREEN);
		LoginButton2.addMouseListener(this);
		LoginButton2.addActionListener(this);
		panel.add(LoginButton2);
		
		/*LoginCheckBox1 = new JCheckBox("Remember me");
		LoginCheckBox1.setBounds(600, 300, 120, 30);
		panel.add(LoginCheckBox1);*/
		
		Access = new JLabel("Can't access your account");
		Access.setBounds(300, 350, 350, 15);
		panel.add(Access);
		
		
		/*LoginRadioButton1 = new JRadioButton("Admin");
		LoginRadioButton1.setBounds(300, 380, 100, 25);
		LoginRadioButton1.setBackground(Color.CYAN);
		LoginRadioButton1.addActionListener(this);
		panel.add(LoginRadioButton1);
		
		LoginRadioButton2 = new JRadioButton("Manager");
		LoginRadioButton2.setBounds(450, 380, 100, 25);
		LoginRadioButton2.setBackground(Color.CYAN);
		LoginRadioButton2.addActionListener(this);
		panel.add(LoginRadioButton2);
		
		LoginRadioButton3 = new JRadioButton("Customer");
		LoginRadioButton3.setBounds(600, 380, 100, 25);
		LoginRadioButton3.setBackground(Color.CYAN);
		LoginRadioButton3.addActionListener(this);
		panel.add(LoginRadioButton3);
		
		LoginButtonGroup1 = new ButtonGroup();
		LoginButtonGroup1.add(LoginRadioButton1);
		LoginButtonGroup1.add(LoginRadioButton2);
		LoginButtonGroup1.add(LoginRadioButton3);*/
		
		
		UserNameLabel = new JLabel("Language");
		UserNameLabel.setBounds(990, 600, 60, 15);
		panel.add(UserNameLabel);
		
		LoginCombo1 = new JComboBox(Language);
		LoginCombo1.setBounds(1060, 600, 100, 20);
		panel.add(LoginCombo1);
		
		this.add(panel);
		
	}
	
	public void mouseClicked(MouseEvent m){}
	public void mousePressed(MouseEvent m){}
	public void mouseReleased(MouseEvent m){}
	public void mouseEntered(MouseEvent m)
	{
		JButton b = (JButton) m.getComponent();
		if(b==LoginButton1)
		{
			LoginButton1.setBackground(Color.RED);
		}
		else if(b==LoginButton2)
		{
			LoginButton2.setBackground(Color.RED);
		}
	}
	public void mouseExited(MouseEvent m)
	{
		JButton b = (JButton) m.getComponent();
		if(b==LoginButton1)
		{
			LoginButton1.setBackground(Color.BLUE);
		}
		else if(b==LoginButton2)
		{
			LoginButton2.setBackground(Color.GREEN);
		}
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String button = a.getActionCommand();
		
		if(button.equals("Sign up"))
		{
			System.out.println("Sign up Clicked");
			SignUp sign = new SignUp();
			sign.setVisible(true);
			this.setVisible(false);
		}
		else if(button.equals("Log In"))
		{
			System.out.println("hello");
			flag=true;
			check();
			/*if(LoginRadioButton1.isSelected())
			{
				System.out.println("Admin Login");
				Admin ad = new Admin();
				ad.setVisible(true);
				this.setVisible(false);
			}
			else if(LoginRadioButton2.isSelected())
			{
				System.out.println("Manager Login");
				Manager m = new Manager();
				m.setVisible(true);
				this.setVisible(false);
			}
			else if(LoginRadioButton3.isSelected())
			{
				System.out.println("Customer Login");
				Customer c = new Customer();
				c.setVisible(true);
				this.setVisible(false);
			}
			else{}*/
		}
		else{}
	}
	
	public void check()
	{
        String query = "SELECT `Name`, `Password`, `Email`, `Mobile Number`, `Gender`, `Type` FROM `account`;";     
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
                String Name = rs.getString("Name");
                String password = rs.getString("Password");
				String Email = rs.getString("Email");
				String MobileNumber = rs.getString("Mobile Number");
				String Gender = rs.getString("Gender");
				String Type = rs.getString("Type");
				
				if(Name.equals(LoginTextField.getText()))
				{
					flag=false;
					if(password.equals(LoginPasswordField.getText()))
					{
						if(Type.equals("Customer"))
						{
							Customer c = new Customer();
							this.setVisible(false);
							c.setVisible(true);
						}
						else if(Type.equals("Admin"))
						{
							Admin a = new Admin();
							this.setVisible(false);
							a.setVisible(true);
						}
						else if(Type.equals("Product Manager"))
						{
							PManager pm = new PManager();
							this.setVisible(false);
							pm.setVisible(true);
						}
						else if(Type.equals("Sales Manager"))
						{
							SManager sm = new SManager(0,0);
							this.setVisible(false);
							sm.setVisible(true);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Invalid pass"); 
					}
				}			
			}
			if(flag){JOptionPane.showMessageDialog(this,"Invalid name"); }
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
}