package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Add_Enquiry extends JFrame {
	
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement pst=null;

	private JPanel contentPane;
	private JTextField txteid;
	private JTextField name;
	private JTextField add;
	private JTextField num;
	private JTextField mail;
	private JDateChooser date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
         UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Add_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Enquiry frame = new Add_Enquiry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Add_Enquiry() {
		setTitle("Mass Gym || Adding Enquiry ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 260, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 257, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdjust = new JLabel("Adding Enquiry");
		lblAdjust.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdjust.setBounds(63, 11, 150, 30);
		panel.add(lblAdjust);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 2), "Add Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(0, 54, 251, 215);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEnquiryId = new JLabel("Enquiry ID:");
		lblEnquiryId.setBounds(6, 16, 80, 23);
		panel_1.add(lblEnquiryId);
		lblEnquiryId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setBounds(6, 41, 80, 14);
		panel_1.add(lblFullName);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(6, 66, 80, 14);
		panel_1.add(lblAddress);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblConactNo = new JLabel("Conact No:");
		lblConactNo.setBounds(6, 91, 80, 14);
		panel_1.add(lblConactNo);
		lblConactNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEnquryFor = new JLabel("Enqury For:");
		lblEnquryFor.setBounds(6, 116, 80, 23);
		panel_1.add(lblEnquryFor);
		lblEnquryFor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(6, 143, 80, 14);
		panel_1.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txteid = new JTextField();
		txteid.setEditable(false);
		txteid.setEnabled(false);
		try{
			con=Connect.connectDb();
		
		String sql1="Select id from enquiry";
		pst=con.prepareStatement(sql1);
		rs=pst.executeQuery();
		int a=0;
		while(rs.next())
		{
			a=rs.getInt("id");
		}
		a=a+1;
		String aa=String.valueOf(a);
		txteid.setText(aa);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		txteid.setBounds(96, 19, 132, 20);
		panel_1.add(txteid);
		txteid.setForeground(new Color(0, 128, 128));
		txteid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txteid.setColumns(10);
		
		name = new JTextField();
		name.setBounds(96, 40, 132, 20);
		panel_1.add(name);
		name.setForeground(new Color(0, 128, 128));
		name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		name.setColumns(10);
		
		add = new JTextField();
		add.setBounds(96, 65, 132, 20);
		panel_1.add(add);
		add.setForeground(new Color(0, 128, 128));
		add.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add.setColumns(10);
		
		num = new JTextField();
		num.setBounds(96, 90, 132, 20);
		panel_1.add(num);
		num.setForeground(new Color(0, 128, 128));
		num.setFont(new Font("Tahoma", Font.PLAIN, 13));
		num.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(96, 142, 132, 20);
		panel_1.add(mail);
		mail.setForeground(new Color(0, 128, 128));
		mail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mail.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(6, 172, 80, 14);
		panel_1.add(lblDate);
		
		JDateChooser date = new JDateChooser();
		date.setDateFormatString("yyyy-MM-dd");
		date.setBounds(96, 166, 132, 20);
		panel_1.add(date);
		Date ddd=new Date();
		date.setDate(ddd);
		
		JComboBox ecombo = new JComboBox();
		ecombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ecombo.setModel(new DefaultComboBoxModel(new String[] {"Join Gym", "Fee Enquiry", "Product Purchase", "Visit"}));
		ecombo.setBounds(96, 119, 132, 20);
		panel_1.add(ecombo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		panel_2.setBounds(0, 280, 257, 46);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					  con=Connect.connectDb();
					 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			          String enqdate = dateformat.format(date.getDate());
						
			       
			        String sql="Insert into enquiry(id,fullname,address,contact,enquiry_for,email,date) values(?,?,?,?,?,?,?)";

					pst=con.prepareStatement(sql);
					
					pst.setString(1,txteid.getText());
			  
					if(!Pattern.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)?$", name.getText()))		//Only Characters
			        {
			        	JOptionPane.showMessageDialog(null, "Full Name is Incorrect");
			        }
			        else
			        {
			        	
			        	pst.setString(2,name.getText());
			        }
					
					if(!Pattern.matches("^[a-zA-Z0-9]+(\\s[a-zA-Z]+)?$", add.getText()))		//Characters & digits
			        {
			        	JOptionPane.showMessageDialog(null, "Invalid data in Address");
			        }
			        else
			        {
			        	
			        	pst.setString(3,add.getText());
			        }
					
					 if(!Pattern.matches("^[0-9]+$", num.getText()))			//Only Numbers
				        {
				        	JOptionPane.showMessageDialog(null, "Enter Only Numbers");
				        }
				        else
				        {
				        	pst.setString(4,num.getText());
				        }
					 
					 pst.setString(5, (String)ecombo.getSelectedItem());
					 
					 if(!Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",mail.getText()))  //For Email
				     {
				    	 JOptionPane.showMessageDialog(null,"Email is Incorrect");
				     }
				     else
			         {
			        	 pst.setString(6,mail.getText());
			         }
					 
					 pst.setString (7, ((JTextField)date.getDateEditor().getUiComponent()).getText());
					 
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "New enquiry is Inserted");
					hide();
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
				
				
			}
		});
		btnSave.setIcon(new ImageIcon(Add_Enquiry.class.getResource("/images/save.png")));
		btnSave.setBounds(27, 11, 89, 23);
		panel_2.add(btnSave);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(Add_Enquiry.class.getResource("/images/cancel.png")));
		btnCancel.setBounds(118, 11, 103, 23);
		panel_2.add(btnCancel);
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
	}
}
