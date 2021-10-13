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
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Pay_Fees extends JFrame {
	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;

	private JPanel contentPane;
	private JTextField totfee;
	private JTextField pfee;
	private JTextField balfee;
	private JTextField pay;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
	         UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	 
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Pay_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Pay_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Pay_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Pay_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pay_Fees frame = new Pay_Fees();
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
	public Pay_Fees() {
		setTitle("Mass Gym || Fee Pay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 281, 56);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Paying Fees");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(45, 11, 169, 22);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Fee Information", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(0, 57, 281, 266);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("Total Fees");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 110, 95, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Paid Fees");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 143, 95, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Balance Fees");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 183, 95, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Now Pay");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(10, 212, 95, 19);
		panel_1.add(label_4);
		
		totfee = new JTextField();
		totfee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totfee.setColumns(10);
		totfee.setBounds(106, 106, 153, 23);
		panel_1.add(totfee);
		
		pfee = new JTextField();
		pfee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pfee.setColumns(10);
		pfee.setBounds(106, 140, 153, 23);
		panel_1.add(pfee);
		
		balfee = new JTextField();
		balfee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		balfee.setColumns(10);
		balfee.setBounds(106, 179, 153, 23);
		panel_1.add(balfee);
		
		pay = new JTextField();
		pay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pay.setColumns(10);
		pay.setBounds(106, 211, 153, 23);
		panel_1.add(pay);
		
		JLabel label_5 = new JLabel("Date");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(10, 75, 64, 14);
		panel_1.add(label_5);
		
		JDateChooser date = new JDateChooser();
		date.setBounds(107, 69, 152, 20);
		panel_1.add(date);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFullName.setBounds(10, 28, 95, 19);
		panel_1.add(lblFullName);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setColumns(10);
		name.setBounds(106, 27, 153, 28);
		panel_1.add(name);
		
		JButton bpay = new JButton("Paid Fee");
		bpay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					con=Connect.connectDb();
					
					SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		            String paydate = dateformat.format(date.getDate());
		            
		            String sql="insert into payfees(Name,Date,Totalfee,Paidfee,Balancefee,Pay)"+"values(?,?,?,?,?,?)";
		            pst=con.prepareStatement(sql);
		            
		            pst.setString(1,name.getText());
		            pst.setString(2,paydate);
		            pst.setString(3,totfee.getText());
		            pst.setString(4,pfee.getText());
		            pst.setString(5,balfee.getText());
		            pst.setString(6,pay.getText());
		            
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null,"Fees Paid");
					
				}
				catch(Exception e0)
				{
					JOptionPane.showMessageDialog(null, e0);
				}
			}
		});
		bpay.setFont(new Font("Tahoma", Font.BOLD, 14));
		bpay.setBounds(10, 349, 102, 23);
		contentPane.add(bpay);
		
		JButton bcan = new JButton("Cancel");
		bcan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		bcan.setFont(new Font("Tahoma", Font.BOLD, 14));
		bcan.setBounds(141, 349, 89, 23);
		contentPane.add(bcan);
	}
}
