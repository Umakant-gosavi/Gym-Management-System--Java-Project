package classes;

import java.awt.BorderLayout;
import java.util.regex.*;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.Image;

import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Add_Trainer extends JFrame {
	
	Connection con=null;
	
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	private JPanel contentPane;
	private JTextField tid;
	private JTextField tname;
	private JTextField tage;
	private JTextField tnum;
	private JTextField temail;
	private JTextField tsalary;
	private JTextField tcer;
	private JTextField texp;
	private JTextField tadd;
	private JTextField tedu;
	private JComboBox occ;
	private JRadioButton rmale;
	 private JRadioButton rfemale;
	 private ImageIcon finalImage;
	 private String filename;
	 
	 private final ButtonGroup buttonGroup = new ButtonGroup();
	 private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	 private JTextField path;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
	         UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	 
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Add_Trainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Add_Trainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Add_Trainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Add_Trainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Trainer frame = new Add_Trainer();
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
	public Add_Trainer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 869, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 102, 0), 2));
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(10, -71, 784, 43);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Adding Trainer");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(47, 79, 79));
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Enter Information", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBackground(new Color(119, 136, 153));
		panel_1.setBounds(201, 43, 652, 380);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("Trainer ID");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(10, 26, 78, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Full Name");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(10, 53, 78, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Gender");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(10, 78, 78, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Birth Date");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(10, 107, 78, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Age");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(10, 132, 64, 20);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("Address");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(374, 53, 78, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("Contact No");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(10, 166, 89, 14);
		panel_1.add(label_7);
		
		tid = new JTextField();
		tid.setEditable(false);
		tid.setEnabled(false);
		try{con=Connect.connectDb();
		
		String sql1="Select id from trainer";
		pst=con.prepareStatement(sql1);
		rs=pst.executeQuery();
		int a=0;
		while(rs.next())
		{
			a=rs.getInt("id");
		}
		a=a+1;
		String aa=String.valueOf(a);
		tid.setText(aa);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		tid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tid.setColumns(10);
		tid.setBounds(136, 20, 185, 20);
		panel_1.add(tid);
		
		tname = new JTextField();
		tname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tname.setColumns(10);
		tname.setBounds(136, 50, 185, 20);
		panel_1.add(tname);
		
		JRadioButton rmale = new JRadioButton("Male");
		buttonGroup.add(rmale);
		rmale.setBounds(136, 74, 70, 23);
		panel_1.add(rmale);
		
		JDateChooser dob = new JDateChooser();
		dob.setBounds(136, 101, 185, 20);
		panel_1.add(dob);
		
		tage = new JTextField();
		tage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MMMMMM-dd");
				String s=format.format(dob.getDate());
				String arr[]=s.split("-");
				int year=Integer.parseInt(arr[0]);
				Month month=(Month.valueOf(arr[1].toUpperCase()));
				int day=Integer.parseInt(arr[2]);
				
				LocalDate localDate=LocalDate.now();
				LocalDate birthday=LocalDate.of(year, month, day);
				
				Period p=Period.between(birthday, localDate);
				int curAge=p.getYears();
				String curAge1=String.valueOf(curAge);
				tage.setText(curAge1);	
			}
		});
		tage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tage.setColumns(10);
		tage.setBounds(136, 132, 185, 20);
		panel_1.add(tage);
		
		tnum = new JTextField();
		tnum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tnum.setColumns(10);
		tnum.setBounds(136, 163, 185, 20);
		panel_1.add(tnum);
		
		JRadioButton rfemale = new JRadioButton("Female");
		buttonGroup.add(rfemale);
		rfemale.setBounds(232, 76, 89, 23);
		panel_1.add(rfemale);
		
		JLabel label_8 = new JLabel("Email ID");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(10, 200, 78, 14);
		panel_1.add(label_8);
		
		temail = new JTextField();
		temail.setColumns(10);
		temail.setBounds(136, 194, 185, 20);
		panel_1.add(temail);
		
		JLabel label_9 = new JLabel("Occupasion");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_9.setBounds(364, 21, 89, 19);
		panel_1.add(label_9);
		
		JLabel label_11 = new JLabel("Join Date");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_11.setBounds(364, 107, 123, 14);
		panel_1.add(label_11);
		
		JDateChooser jdate = new JDateChooser();
		jdate.setBounds(497, 107, 138, 20);
		panel_1.add(jdate);
		
		JComboBox occ = new JComboBox();
		occ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		occ.setModel(new DefaultComboBoxModel(new String[] {"Bodybuider", "Part Time Trainer", "Professional Trainer", "Student"}));
		occ.setBounds(497, 25, 130, 20);
		panel_1.add(occ);
		
		JComboBox combtype = new JComboBox();
		combtype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		combtype.setModel(new DefaultComboBoxModel(new String[] {"Personal Trainer", "Nutritionist", "Gym Boy"}));
		combtype.setBounds(497, 224, 138, 23);
		panel_1.add(combtype);
		
		JButton badd = new JButton("Add");
		badd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*try {
					con=Connect.connectDb();
				int idno = Integer.parseInt(tid.getText());
				
		         String fname = tname.getText();
		         
		         String gender = null;
		        
		         if(rmale.isSelected())
		         {
		        	 gender="Male";
		         }
		         else
		         {
		        	 gender="Female";
		         }
		         SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		         String bdate = dateformat.format(dob.getDate());
		         
		         int age = Integer.parseInt(tage.getText());
		         Double monum = Double.parseDouble(tnum.getText());
		         String mail = temail.getText();
		         String occp = oc.getText();
		         String address = tadd.getText();
		         String edu = tedu.getText();
		         
		         SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM-dd");
		         String joindate = dateformat.format(jdate.getDate());
		         
		         float salary = Float.parseFloat(tsalary.getText());
		         String cer = tcer.getText();
		         String exp = texp.getText();
		         String type =ttype.getText();
		         String imgpath = path.getText();
		         
		         String sql = "insert into trainer(id,trainer_name,gender,birth_date,age,contact_No,emailid,occupasion,address,education,join_date,salary,certification,experience,type,image) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		        		 
		        pst=con.prepareStatement(sql);
		        
		        pst.setLong(1,idno);
		        pst.setString(2,fname);
		        pst.setString(3,gender);
		        pst.setString(4,bdate);
		        pst.setInt(5, age);
		        pst.setDouble(6,monum);
		        pst.setString(7,mail);
		        pst.setString(8,occp);
		        pst.setString(9,address);
		        pst.setString(10,edu);
		        pst.setString(11,joindate);
		        pst.setFloat(12,salary);
		        pst.setString(13,cer);
		        pst.setString(14,exp);
		        pst.setString(15,type);
		        pst.setString(16,imgpath);
		        
		        pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Trainer Added");
				}
				catch(Exception msg)
				{
					JOptionPane.showMessageDialog(null, msg);
				}	*/
				
				try
				{
					con=Connect.connectDb();
					String sql = "insert into trainer(id,trainer_name,gender,birth_date,age,contact_No,emailid,occupasion,address,education,join_date,salary,certification,experience,type,image) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			        pst=con.prepareStatement(sql);
			      
			        if(!Pattern.matches("^[0-9]+$", tid.getText()))			//Only Numbers
			        {
			        	JOptionPane.showMessageDialog(null, "Enter Only Numbers");
			        }
			        else
			        {
			        	pst.setString(1,tid.getText());
			        }
			       
			        if(!Pattern.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)?$", tname.getText()))		//Only Characters
			        {
			        	JOptionPane.showMessageDialog(null, "Full Name is Incorrect");
			        }
			        else
			        {
			        	
			        	pst.setString(2,tname.getText());
			        }
			        
			        String gender = null;
			        
			         if(rmale.isSelected())
			         {
			        	 gender="Male";
			         }
			         else
			         {
			        	 gender="Female";
			         }
			         pst.setString(3,gender);
			         
			         SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			         String bdate = dateformat.format(dob.getDate());
			         pst.setString(4,bdate);
			         
			         
			         if(!Pattern.matches("^[0-9]+$", tage.getText()))		//Only Digits
				        {
			        	 JOptionPane.showMessageDialog(null, "Enter Only Number in Age");
				        }
				        else
				        {
				        	int age = Integer.parseInt(tage.getText());
			        	 	if(age <= 50)
			        	 	{
			        	 		pst.setString(5,tage.getText());
			        	 	}
			        	 	else
			        	 	{
			        	 		JOptionPane.showMessageDialog(null, "Invalid Age");
			        	 	}
				        }
			         
			         if(!Pattern.matches("(0/91)?[7-9][0-9]{9}",tnum.getText())) 		//For Mobile no
				     {
				    	 JOptionPane.showMessageDialog(null,"Contact Number is Incorrect");
				     }
			         else
			         {
			        	 pst.setString(6,tnum.getText());
			         }
			         
			         if(!Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",temail.getText()))  //For Email
				     {
				    	 JOptionPane.showMessageDialog(null,"Email is Incorrect");
				     }
				     else
			         {
			        	 pst.setString(7,temail.getText());
			         }
			         
			         /*if(!Pattern.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)?$", oc.getText()))		
				        {
				        	JOptionPane.showMessageDialog(null, "Enter Only Charecters in Occupasion");
				        }
				        else
				        {
				        	
				        	pst.setString(8,oc.getText());
				        }*/
			         String ocp = (String)occ.getSelectedItem();
			         pst.setString(8, ocp);
			         
			         pst.setString(9,tadd.getText());
			         	
			         if(!Pattern.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)?$", tedu.getText()))
				        {
				        	JOptionPane.showMessageDialog(null, "Enter Only Chareters in Education");
				        }
				        else
				        {
				        	
				        	pst.setString(10,tedu.getText());
				        }
			         
			         SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM-dd");
			         String joindate = dateformat.format(jdate.getDate());
			         pst.setString(11,joindate);
			         
			         if(!Pattern.matches("^[0-9]+$",tsalary.getText()))
				     {
				    	 JOptionPane.showMessageDialog(null,"Enter Only numbers in salary");
				     }
			         else
			         {
			        	 pst.setString(12,tsalary.getText());
			         }
			         
			         if(!Pattern.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)?$", tcer.getText()))
				        {
				        	JOptionPane.showMessageDialog(null, "Enter Only Chareters in Certificate");
				        }
				        else
				        {
				        	
				        	pst.setString(13,tcer.getText());
				        }
			         						
			         if(!Pattern.matches("^[a-zA-Z0-9]+(\\s[a-zA-Z]+)?$", texp.getText()))		//Characters & digits
				        {
				        	JOptionPane.showMessageDialog(null, "Invalid Data in Experience");
				        }
				        else
				        {
				        	
				        	pst.setString(14,texp.getText());
				        }
			         
			         /*if(!Pattern.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)?$", ttype.getText()))
				        {
				        	JOptionPane.showMessageDialog(null, "Enter Only Charecters in Type");
				        }
				        else
				        {
				        	
				        	pst.setString(15,ttype.getText());
				        }*/
			         pst.setString(15, (String)combtype.getSelectedItem());
			         
			         String imgpath = path.getText();
			         if(!imgpath.equals(""))
			         {
			         
			         pst.setString(16,imgpath);
			         }
			         else
			         {
			        	 JOptionPane.showMessageDialog(null, "Please Select Image");
			         }
			         
			         pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Trainer Added");
				}
				catch(Exception msg)
				{
					JOptionPane.showMessageDialog(null, msg);
				}
		       
			}
		});
		badd.setForeground(Color.BLACK);
		badd.setFont(new Font("Tahoma", Font.BOLD, 15));
		badd.setBounds(10, 317, 89, 23);
		panel_1.add(badd);
		
		JButton button_2 = new JButton("Cancel");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBounds(192, 329, 89, 23);
		panel_1.add(button_2);
		
		JLabel label_15 = new JLabel("Salary");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_15.setBounds(364, 132, 123, 20);
		panel_1.add(label_15);
		
		JLabel label_16 = new JLabel("Education");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_16.setBounds(363, 76, 89, 19);
		panel_1.add(label_16);
		
		JLabel label_17 = new JLabel("Certification");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_17.setBounds(364, 160, 123, 20);
		panel_1.add(label_17);
		
		JLabel label_18 = new JLabel("Experience");
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_18.setBounds(364, 191, 123, 20);
		panel_1.add(label_18);
		
		tsalary = new JTextField();
		tsalary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tsalary.setColumns(10);
		tsalary.setBounds(497, 132, 138, 20);
		panel_1.add(tsalary);
		
		tcer = new JTextField();
		tcer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tcer.setColumns(10);
		tcer.setBounds(497, 163, 138, 20);
		panel_1.add(tcer);
		
		texp = new JTextField();
		texp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		texp.setColumns(10);
		texp.setBounds(497, 192, 138, 20);
		panel_1.add(texp);
		
		JLabel label_19 = new JLabel("Type");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_19.setBounds(374, 222, 46, 20);
		panel_1.add(label_19);
		
		tadd = new JTextField();
		tadd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tadd.setColumns(10);
		tadd.setBounds(496, 49, 138, 20);
		panel_1.add(tadd);
		
		tedu = new JTextField();
		tedu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tedu.setColumns(10);
		tedu.setBounds(496, 80, 138, 20);
		panel_1.add(tedu);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Insert Image", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		panel_2.setBackground(new Color(102, 205, 170));
		panel_2.setBounds(0, 43, 199, 380);
		contentPane.add(panel_2);
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setIcon(new ImageIcon(Add_Memberfail.class.getResource("/images/man.png")));
		lblPhoto.setBounds(10, 38, 184, 213);
		panel_2.add(lblPhoto);
		
		JButton upload = new JButton("Upload");
		upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser imgchooser=new JFileChooser();
				imgchooser.showOpenDialog(null);
				File f= new File(imgchooser.getSelectedFile().getPath());
				filename=f.getAbsolutePath();
				ImageIcon myImage= new ImageIcon(filename);
				Image  img= myImage.getImage();
				Image newImage=img.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(),Image.SCALE_SMOOTH);
				finalImage=new ImageIcon(newImage);
				lblPhoto.setIcon(finalImage);
				
				path.setText(filename);
			}
		});
		upload.setFont(new Font("Tahoma", Font.BOLD, 14));
		upload.setBounds(10, 310, 121, 23);
		panel_2.add(upload);
		
		path = new JTextField();
		path.setBounds(26, 277, 149, 20);
		panel_2.add(path);
		path.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(255, 102, 0), 2));
		panel_3.setBackground(new Color(102, 205, 170));
		panel_3.setBounds(0, 0, 853, 43);
		contentPane.add(panel_3);
		
		JLabel label_22 = new JLabel("Adding Trainer");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setForeground(new Color(47, 79, 79));
		label_22.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_3.add(label_22);
	}
}
