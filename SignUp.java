import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUp extends JFrame implements MouseListener, ActionListener
{
	private JLabel SLabel1, SLabel2, SLabel3, SLabel4, SLabel5, SLabel6, SLabel7, SLabel8;
	private JTextField NameTextField, EmailTextField, MoNumTextField, TypeTextField, GenderTextField;
	private JPasswordField PasswordField;
	private JButton Button1, Button2;
	//private JRadioButton SRadioButton1, SRadioButton2;
	//private ButtonGroup SButtonGroup1;
	private JComboBox Combo1, Combo2, Combo3;
	private JPanel panel;
	//private String date[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	//private String month[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	//private String year[] = {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017"};
	
	public SignUp()
	{
		super("Index");
		this.setSize(1300,700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.orange);
		panel.setLayout(null);
		
		SLabel1 = new JLabel("Pharmaceutical Management");
		SLabel1.setBounds(300, 30, 1300, 90);
		SLabel1.setFont(new Font("Forte", 300, 50));
		panel.add(SLabel1);
		
		SLabel2 = new JLabel("Create New Account");
		SLabel2.setBounds(300, 140, 300, 30);
		panel.add(SLabel2);
		
		SLabel3 = new JLabel("Name");
		SLabel3.setBounds(180, 180, 90, 30);
		panel.add(SLabel3);
		
		NameTextField = new JTextField();
		NameTextField.setBounds(300, 180, 300, 30);
		panel.add(NameTextField);
		
		SLabel6 = new JLabel("Password");
		SLabel6.setBounds(180, 240, 90, 30);
		panel.add(SLabel6);
		
		PasswordField = new JPasswordField();
		PasswordField.setBounds(300, 240, 300, 30);
		panel.add(PasswordField);
		
		SLabel4 = new JLabel("Email");
		SLabel4.setBounds(180, 300, 90, 30);
		panel.add(SLabel4);
		
		EmailTextField = new JTextField();
		EmailTextField.setBounds(300, 300, 300, 30);
		panel.add(EmailTextField);
		
		SLabel4 = new JLabel("Mobile Number");
		SLabel4.setBounds(180, 360, 90, 30);
		panel.add(SLabel4);
		
		MoNumTextField = new JTextField();
		MoNumTextField.setBounds(300, 360, 300, 30);
		panel.add(MoNumTextField);
		
		SLabel8 = new JLabel("Type");
		SLabel8.setBounds(180, 420, 90, 30);
		panel.add(SLabel8);
		
		TypeTextField = new JTextField();
		TypeTextField.setBounds(300, 420, 300, 30);
		panel.add(TypeTextField);
		
		/*SLabel5 = new JLabel("Date of Birth");
		SLabel5.setBounds(180, 420, 90, 30);
		panel.add(SLabel5);
		
		Combo1 = new JComboBox(year);
		Combo1.setBounds(300, 420, 100, 30);
		panel.add(Combo1);
		
		Combo2 = new JComboBox(month);
		Combo2.setBounds(420, 420, 100, 30);
		panel.add(Combo2);
		
		Combo3 = new JComboBox(date);
		Combo3.setBounds(540, 420, 50, 30);
		panel.add(Combo3);*/
		
		SLabel7 = new JLabel("Gender");
		SLabel7.setBounds(180, 480, 90, 30);
		panel.add(SLabel7);
		
		GenderTextField = new JTextField();
		GenderTextField.setBounds(300, 480, 300, 30);
		panel.add(GenderTextField);
		
		/*SRadioButton1 = new JRadioButton("Male");
		SRadioButton1.setBounds(300, 480, 80, 30);
		panel.add(SRadioButton1);
		
		SRadioButton2 = new JRadioButton("Female");
		SRadioButton2.setBounds(420, 480, 80, 30);
		panel.add(SRadioButton2);
		
		SButtonGroup1 = new ButtonGroup();
		SButtonGroup1.add(SRadioButton1);
		SButtonGroup1.add(SRadioButton2);*/
		
		Button1 = new JButton("Create Account");
		Button1.setBounds(300, 540, 300, 30);
		Button1.setBackground(Color.BLUE);
		Button1.addMouseListener(this);
		Button1.addActionListener(this);
		panel.add(Button1);
		
		Button2 = new JButton("Back");
		Button2.setBounds(50, 600, 100, 30);
		Button2.setBackground(Color.GREEN);
		Button2.addMouseListener(this);
		Button2.addActionListener(this);
		panel.add(Button2);
		
		this.add(panel);
	
	}
	
	public void mouseClicked(MouseEvent m){}
	public void mousePressed(MouseEvent m){}
	public void mouseReleased(MouseEvent m){}
	public void mouseEntered(MouseEvent m)
	{
		JButton b = (JButton) m.getComponent();
		if(b==Button1)
		{
			Button1.setBackground(Color.RED);
		}
		else if(b==Button2)
		{
			Button2.setBackground(Color.RED);
		}
	}
	public void mouseExited(MouseEvent m)
	{
		JButton b = (JButton) m.getComponent();
		if(b==Button1)
		{
			Button1.setBackground(Color.BLUE);
		}
		else if(b==Button2)
		{
			Button2.setBackground(Color.GREEN);
		}
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String button = a.getActionCommand();
		
		if(button.equals("Create Account"))
		{
			System.out.println("Create Clicked");
			JOptionPane.showMessageDialog(this, "Account Created");
			insertIntoDB();
		}
		else if(button.equals("Back"))
		{
			System.out.println("Back Clicked");
			Login l = new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
	public void insertIntoDB()
	{
		String query = "INSERT INTO account VALUES ('"+NameTextField.getText()+"','"+PasswordField.getText()+"','"+EmailTextField.getText()+"','"+MoNumTextField.getText()+"','"+GenderTextField.getText()+"','"+TypeTextField.getText()+"');";
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