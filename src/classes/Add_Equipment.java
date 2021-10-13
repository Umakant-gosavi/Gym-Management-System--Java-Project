package classes;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Add_Equipment extends JFrame {
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement pst=null;

	private JPanel contentPane;
	private JTextField eid;
	private JTextField name;
	private JTextField cost;
	private JTextField dname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
	         UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	 
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Add_Equipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Add_Equipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Add_Equipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Add_Equipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Equipment frame = new Add_Equipment();
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
	public Add_Equipment() {
		setTitle("Add Equipment");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 277, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 257, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddNewEquipment = new JLabel("Add New Equipment");
		lblAddNewEquipment.setBounds(30, 11, 182, 22);
		lblAddNewEquipment.setForeground(new Color(0, 0, 255));
		lblAddNewEquipment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewEquipment.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblAddNewEquipment);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 49, 257, 269);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Adding Equipment Information", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setBounds(0, 11, 257, 189);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Equipment ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 28, 95, 17);
		panel_2.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(10, 53, 95, 14);
		panel_2.add(lblName);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCost.setBounds(10, 77, 95, 14);
		panel_2.add(lblCost);
		
		JLabel lblPurchaseDate = new JLabel("Purchase Date");
		lblPurchaseDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPurchaseDate.setBounds(10, 105, 95, 14);
		panel_2.add(lblPurchaseDate);
		
		JLabel lblDealerName = new JLabel("Dealer Name");
		lblDealerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDealerName.setBounds(10, 130, 95, 19);
		panel_2.add(lblDealerName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblType.setBounds(10, 157, 95, 17);
		panel_2.add(lblType);
		
		eid = new JTextField();
		eid.setEditable(false);
		eid.setEnabled(false);
		try{con=Connect.connectDb();
		
		String sql1="Select ID from equipment";
		pst=con.prepareStatement(sql1);
		rs=pst.executeQuery();
		int a=0;
		while(rs.next())
		{
			a=rs.getInt("ID");
		}
		a=a+1;
		String aa=String.valueOf(a);
		eid.setText(aa);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		eid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		eid.setBounds(125, 28, 118, 20);
		panel_2.add(eid);
		eid.setColumns(10);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setColumns(10);
		name.setBounds(125, 52, 118, 20);
		panel_2.add(name);
		
		cost = new JTextField();
		cost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cost.setColumns(10);
		cost.setBounds(125, 76, 118, 20);
		panel_2.add(cost);
		
		dname = new JTextField();
		dname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dname.setColumns(10);
		dname.setBounds(125, 129, 118, 20);
		panel_2.add(dname);
		
		JDateChooser purdate = new JDateChooser();
		purdate.setBounds(125, 99, 118, 20);
		panel_2.add(purdate);
		
		JComboBox ctype = new JComboBox();
		ctype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ctype.setModel(new DefaultComboBoxModel(new String[] {"Electronic", "Non-Electronic"}));
		ctype.setBounds(125, 157, 118, 23);
		panel_2.add(ctype);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Confirm", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(204, 204, 255));
		panel_3.setBounds(0, 211, 256, 58);
		panel_1.add(panel_3);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					con=Connect.connectDb();
					 
			         String sql = " insert into equipment (ID,Name,Price, Purdate, Dealer_name, Type)"
								+ " values (?, ?, ?, ?,?,?)";
			         
			         pst=con.prepareStatement(sql);
			         
			         pst.setString(1, eid.getText());
			         
			         if(!Pattern.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)?$", name.getText()))		//Only Characters
				        {	
				        	JOptionPane.showMessageDialog(null, "Enter Only Charecter in Equipment Name");
				        }
					else 
						{
						pst.setString(2, name.getText());
						}
			         
			         if(!Pattern.matches("^[0-9]+$", cost.getText()))			//Only Numbers
				        {
				        	JOptionPane.showMessageDialog(null, "Enter Only Numbers in Cost");
				        }
					else 
					{
						pst.setString(3, cost.getText());
					}
			         
			         SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			         String enqdate = dateformat.format(purdate.getDate());
			         pst.setString(4, enqdate);
			         
			         if(!Pattern.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)?$",  dname.getText()))		//Only Characters
				        {	
				        	JOptionPane.showMessageDialog(null, "Enter Only Charecter in Dealert Name");
				        }
					else 
						{
						pst.setString(5,  dname.getText());
						}
			        
			         pst.setString(6, (String)ctype.getSelectedItem());
			         
			         pst.executeUpdate();
				      JOptionPane.showMessageDialog(null, "Equipment Added");
				      pst.close();
				      con.close();
				}
				catch(Exception msg)
				{
					JOptionPane.showMessageDialog(null, msg);
				}
			}
		});
		btnAdd.setForeground(new Color(0, 0, 255));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(10, 24, 72, 23);
		panel_3.add(btnAdd);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(0, 0, 255));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBounds(84, 24, 72, 23);
		panel_3.add(btnClear);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setForeground(new Color(0, 0, 255));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(166, 24, 83, 23);
		panel_3.add(btnCancel);
	}
}
