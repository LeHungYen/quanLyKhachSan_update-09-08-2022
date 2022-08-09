package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class QuenMatKhau extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuenMatKhau frame = new QuenMatKhau();
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
	public QuenMatKhau() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640,720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 621, 680);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Qu\u00EAn m\u1EADt kh\u1EA9u");
		lblNewLabel_1.setBounds(81, 339, 454, 55);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 38));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(81, 56, 454, 277);
		panel_1.setForeground(Color.GRAY);
		panel_1.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("M\u00E3 x\u00E1c nh\u1EADn");
		lblNewLabel_2_1_1.setBounds(81, 528, 84, 33);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email");
		lblNewLabel_2_1.setBounds(81, 489, 84, 33);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn");
		lblNewLabel_2.setBounds(81, 443, 71, 35);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setBounds(175, 529, 255, 37);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 484, 255, 36);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(175, 443, 255, 35);
		textField_2.setColumns(10);
		
		JButton btnXcNhn = new JButton("X\u00E1c nh\u1EADn");
		btnXcNhn.setBounds(436, 531, 99, 35);
		btnXcNhn.setForeground(Color.WHITE);
		btnXcNhn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXcNhn.setBackground(Color.RED);
		
		JButton btnNewButton = new JButton("G\u1EEDi");
		btnNewButton.setBounds(436, 484, 99, 35);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(Color.RED);
		panel.setLayout(null);
		panel.add(lblNewLabel_1);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u1EA2nh logo th\u01B0\u01A1ng hi\u1EC7u");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 454, 277);
		panel_1.add(lblNewLabel);
		panel.add(lblNewLabel_2_1_1);
		panel.add(lblNewLabel_2_1);
		panel.add(lblNewLabel_2);
		panel.add(textField);
		panel.add(textField_1);
		panel.add(textField_2);
		panel.add(btnXcNhn);
		panel.add(btnNewButton);
	}

}
