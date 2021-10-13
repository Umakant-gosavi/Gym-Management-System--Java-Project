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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Add_Product extends JFrame {
	
	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;

	private JPanel contentPane;
	public JTextField txtPid;
	public JTextField txtPname;
	private JTextField txtCost;
	private JTextField txtSelling;
	private JTextField txtOpening;
	private JTextField txtDescription;
	public JButton btnSave;
	public JLabel lblAddingNewProduct;
	private JComboBox comboCategory;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Add_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Product frame = new Add_Product();
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
	/*public void updating(String id)
	{
		con=Connect.connectDb();
		 String sql="select * from product where product_id='"+txtPid+"'";
	       try {
		    	pst=con.prepareStatement(sql);
		        rs=pst.executeQuery();
			        rs.next();
			        {
			        	txtPid.setText(rs.getString("product_id"));
			        	txtPname.setText(rs.getString("product_name"));
			        	comboCategory.setSelectedItem(rs.getString("category"));
			        	txtCost.setText(rs.getString("cost_price"));
			        	txtSelling.setText(rs.getString("sell_price"));
			        	txtOpening.setText(rs.getString("opening_stock"));
			        	txtDescription.setText(rs.getString("description"));
			        }
		        }
	       catch(Exception msg)
	       {
	    	   
	       }
	}*/
	public Add_Product() {
		setResizable(false);
		setTitle("Mass Gym || Add New Product");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(460, 150, 312, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 204));
		panel.setBounds(0, 0, 306, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddingNewProduct = new JLabel("Adding New Product");
		lblAddingNewProduct.setForeground(new Color(128, 0, 0));
		lblAddingNewProduct.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddingNewProduct.setBounds(64, 11, 179, 19);
		panel.add(lblAddingNewProduct);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(211, 211, 211));
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(60, 179, 113), 2), "Product Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(6, 52, 293, 265);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblProductId = new JLabel("Product ID:");
		lblProductId.setBounds(6, 16, 96, 14);
		panel_2.add(lblProductId);
		lblProductId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblProductName = new JLabel("Product name");
		lblProductName.setBounds(6, 43, 96, 14);
		panel_2.add(lblProductName);
		lblProductName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(6, 65, 96, 18);
		panel_2.add(lblCategory);
		lblCategory.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblPrice = new JLabel("Cost Price");
		lblPrice.setBounds(6, 90, 96, 14);
		panel_2.add(lblPrice);
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblSellingPrice = new JLabel("Selling Price");
		lblSellingPrice.setBounds(6, 114, 96, 20);
		panel_2.add(lblSellingPrice);
		lblSellingPrice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(6, 168, 96, 14);
		panel_2.add(lblDescription);
		lblDescription.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblOpeningStock = new JLabel("Opening Stock");
		lblOpeningStock.setBounds(6, 134, 96, 26);
		panel_2.add(lblOpeningStock);
		lblOpeningStock.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JComboBox comboCategory = new JComboBox();
		comboCategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboCategory.setModel(new DefaultComboBoxModel(new String[] {"Protein Powder", "Gainer Powder", "Energy Drink", "Creatine", "Fat Burners", "T-Shirt", "Hand-Gloves", "Suppoter", "Skipping Rope", "Grips", "Gym-Belt"}));
		comboCategory.setBounds(109, 66, 167, 20);
		panel_2.add(comboCategory);
		
		txtPid = new JTextField();
		txtPid.setEditable(false);
		txtPid.setEnabled(false);
		try{con=Connect.connectDb();
		
		String sql1="Select product_id from product";
		pst=con.prepareStatement(sql1);
		rs=pst.executeQuery();
		int a=0;
		while(rs.next())
		{
			a=rs.getInt("Product_id");
		}
		a=a+1;
		String aa=String.valueOf(a);
		txtPid.setText(aa);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		txtPid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPid.setBounds(109, 16, 167, 20);
		panel_2.add(txtPid);
		txtPid.setColumns(10);
		
		txtPname = new JTextField();
		txtPname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPname.setBounds(109, 42, 167, 20);
		panel_2.add(txtPname);
		txtPname.setColumns(10);
		
		txtCost = new JTextField();
		txtCost.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCost.setBounds(109, 89, 167, 20);
		panel_2.add(txtCost);
		txtCost.setColumns(10);
		
		txtSelling = new JTextField();
		txtSelling.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSelling.setBounds(109, 114, 167, 20);
		panel_2.add(txtSelling);
		txtSelling.setColumns(10);
		
		txtOpening = new JTextField();
		txtOpening.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtOpening.setBounds(109, 137, 167, 20);
		panel_2.add(txtOpening);
		txtOpening.setColumns(10);
		
		JLabel pn = new JLabel("");
		pn.setForeground(new Color(255, 0, 0));
		pn.setBounds(282, 42, 24, 20);
		panel_2.add(pn);
		
		JLabel cp = new JLabel("");
		cp.setForeground(Color.RED);
		cp.setBounds(282, 90, 24, 20);
		panel_2.add(cp);
		
		JLabel sp = new JLabel("");
		sp.setForeground(Color.RED);
		sp.setBounds(282, 114, 24, 20);
		panel_2.add(sp);
		
		JLabel os = new JLabel("");
		os.setForeground(Color.RED);
		os.setBounds(282, 140, 24, 18);
		panel_2.add(os);
		
		txtDescription = new JTextField();
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDescription.setColumns(10);
		txtDescription.setBounds(109, 167, 167, 20);
		panel_2.add(txtDescription);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(new LineBorder(new Color(60, 179, 113), 2));
		panel_1.setBounds(10, 335, 286, 46);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				con=Connect.connectDb();
				String sql=null;
				
				if(btnSave.getText().equals("Save"))
				{
					 sql="Insert into product(product_id,product_name,category,cost_price,sell_price,opening_stock,description)values(?,?,?,?,?,?,?)";

				}
				
				else if(btnSave.getText().equals("Update"))
				{
					sql ="update product set product_id=?,product_name=?,category=?,cost_price=?,sell_price=?,opening_stock=?,description=? where product_id="+txtPid.getText()+"";
				}
				else {}
				try{
					if(txtPname.getText().equals(""))
						pn.setText("*");
					if(txtCost.getText().equals(""))
						cp.setText("*");
					if(txtSelling.getText().equals(""))
						sp.setText("*");
					if(txtOpening.getText().equals(""))
						os.setText("*");
					else {
					con=Connect.connectDb();
								
					 //sql="Insert into product(product_id,product_name,category,cost_price,sell_price,opening_stock,description)values(?,?,?,?,?,?,?)";
					
					pst=con.prepareStatement(sql);
					
					pst.setString(1, txtPid.getText());
					
					if(!Pattern.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)?$", txtPname.getText()))		//Only Characters
			        {	
			        	JOptionPane.showMessageDialog(null, "Enter Only Charecter in Product Name");
			        }
					else {
					pst.setString(2, txtPname.getText());
					}
					
					pst.setString(3, comboCategory.getSelectedItem().toString());
					
					if(!Pattern.matches("^[0-9]+$", txtCost.getText()))			//Only Numbers
			        {
			        	JOptionPane.showMessageDialog(null, "Enter Only Numbers in Cost Price");
			        }
					else {
					pst.setString(4, txtCost.getText());
					}
					
					if(!Pattern.matches("^[0-9]+$", txtSelling.getText()))			//Only Numbers
			        {
			        	JOptionPane.showMessageDialog(null, "Enter Only Numbers in Selling Price");
			        }
					else {
					pst.setString(5, txtSelling.getText());
					}
					
					if(!Pattern.matches("^[0-9]+$", txtOpening.getText()))			//Only Numbers
			        {
			        	JOptionPane.showMessageDialog(null, "Enter Only Numbers in Opening Stock");
			        }
					else {
					pst.setString(6, txtOpening.getText());
					}
					
					
					pst.setString(7, txtDescription.getText());
					
					if(pst.execute())
					{
						JOptionPane.showMessageDialog(null,"Data are not Inserted");
						
						
					}
					else {
							JOptionPane.showMessageDialog(null,"Inserted Succesfully");
							int pid=Integer.parseInt(txtPid.getText())+1;
							txtPid.setText(String.valueOf(pid));
							txtPname.setText("");
							comboCategory.setSelectedItem(comboCategory);
							txtCost.setText("");
							txtSelling.setText("");
							txtOpening.setText("");
						
					 	 }
					}
					if(btnSave.getText().equals("Update"))
					{
						JOptionPane.showMessageDialog(null, "Data updated successfully");
					}
					}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setIcon(new ImageIcon(Add_Product.class.getResource("/images/add product.png")));
		btnSave.setBounds(77, 11, 89, 23);
		panel_1.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setIcon(new ImageIcon(Add_Product.class.getResource("/images/cancel.png")));
		btnCancel.setBounds(176, 11, 107, 23);
		panel_1.add(btnCancel);
	}
}
