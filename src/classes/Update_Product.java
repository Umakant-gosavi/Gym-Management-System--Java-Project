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
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class Update_Product extends JFrame {

	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	 
	private JPanel contentPane;
	private JTextField proid;
	private JTextField proname;
	private JTextField costp;
	private JTextField sellp;
	private JTextField stockp;
	private JTextField des;

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
					Update_Product frame = new Update_Product();
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
	public Update_Product() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Update_Product.class.getResource("/images/update.png")));
		setTitle("Mass Gym || Updating Product");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 354, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(0, 0, 343, 333);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(102, 204, 204));
		panel_1.setBounds(0, 0, 333, 41);
		panel.add(panel_1);
		
		JLabel lblUpdateProduct = new JLabel("Update Product");
		lblUpdateProduct.setForeground(new Color(128, 0, 0));
		lblUpdateProduct.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUpdateProduct.setBounds(100, 11, 179, 19);
		panel_1.add(lblUpdateProduct);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(60, 179, 113), 2), "Product Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(211, 211, 211));
		panel_2.setBounds(6, 52, 327, 214);
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel("Product ID:");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_1.setBounds(6, 16, 96, 14);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Product name");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_2.setBounds(6, 43, 96, 14);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Category");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_3.setBounds(6, 65, 96, 18);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Cost Price");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_4.setBounds(6, 90, 96, 14);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Selling Price");
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_5.setBounds(6, 114, 96, 20);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Description");
		label_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_6.setBounds(6, 168, 96, 14);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Opening Stock");
		label_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_7.setBounds(6, 134, 96, 26);
		panel_2.add(label_7);
		
		JComboBox combocat = new JComboBox();
		combocat.setModel(new DefaultComboBoxModel(new String[] {"Protein Powder", "Gainer Powder", "Energy Drink", "Creatine", "Fat Burners", "T-Shirt", "Hand-Gloves", "Suppoter", "Skipping Rope", "Grips", "Gym-Belt"}));
		combocat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		combocat.setBounds(109, 66, 167, 20);
		panel_2.add(combocat);
		
		proid = new JTextField();
		proid.setText("1");
		proid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		proid.setColumns(10);
		proid.setBounds(109, 16, 167, 20);
		panel_2.add(proid);
		
		proname = new JTextField();
		proname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		proname.setColumns(10);
		proname.setBounds(109, 42, 167, 20);
		panel_2.add(proname);
		
		costp = new JTextField();
		costp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		costp.setColumns(10);
		costp.setBounds(109, 89, 167, 20);
		panel_2.add(costp);
		
		sellp = new JTextField();
		sellp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sellp.setColumns(10);
		sellp.setBounds(109, 114, 167, 20);
		panel_2.add(sellp);
		
		stockp = new JTextField();
		stockp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		stockp.setColumns(10);
		stockp.setBounds(109, 137, 167, 20);
		panel_2.add(stockp);
		
		JLabel label_8 = new JLabel("");
		label_8.setForeground(Color.RED);
		label_8.setBounds(282, 42, 24, 20);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setForeground(Color.RED);
		label_9.setBounds(282, 90, 24, 20);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setForeground(Color.RED);
		label_10.setBounds(282, 114, 24, 20);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setForeground(Color.RED);
		label_11.setBounds(282, 140, 24, 18);
		panel_2.add(label_11);
		
		des = new JTextField();
		des.setFont(new Font("Tahoma", Font.PLAIN, 12));
		des.setColumns(10);
		des.setBounds(109, 167, 167, 20);
		panel_2.add(des);
		
		JButton btmsearch = new JButton("");
		btmsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				con=Connect.connectDb();
				String sql = "select product_name,category,cost_price,sell_price,opening_stock,description from product where product_id ='"+proid.getText()+"'";
				
				try{
			         pst=con.prepareStatement(sql);
			         rs=pst.executeQuery();
			         while(rs.next())
			         {
			        	 proname.setText(rs.getString("product_name"));
			        	 combocat.setSelectedItem(rs.getString("category"));
			        	 costp.setText(rs.getString("cost_price"));
			        	 sellp.setText(rs.getString("sell_price"));
			        	 stockp.setText(rs.getString("opening_stock"));
			        	 des.setText(rs.getString("description"));
			         }
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btmsearch.setIcon(new ImageIcon(Update_Product.class.getResource("/images/search member.png")));
		btmsearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btmsearch.setBounds(282, 16, 38, 20);
		panel_2.add(btmsearch);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setOpaque(false);
		panel_3.setBorder(new LineBorder(new Color(60, 179, 113), 2));
		panel_3.setBounds(10, 277, 317, 46);
		panel.add(panel_3);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(77, 11, 89, 23);
		panel_3.add(btnUpdate);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBounds(176, 11, 107, 23);
		panel_3.add(button_1);
	}
}
