package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HoaDon extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDon frame = new HoaDon();
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
	public HoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1264, 681);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 1264, 64);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("H\u00D3A \u0110\u01A0N");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1264, 64);
		panel_1.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(120, 75, 195, 28);
		panel.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(120, 114, 195, 28);
		panel.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(120, 153, 195, 28);
		panel.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(120, 192, 195, 28);
		panel.add(textArea_3);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng");
		lblNewLabel_1.setBounds(10, 75, 100, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sdt");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(325, 73, 100, 28);
		panel.add(lblNewLabel_1_1);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(435, 75, 195, 28);
		panel.add(textArea_4);
		
		JTextArea textArea_4_1 = new JTextArea();
		textArea_4_1.setBounds(750, 75, 195, 28);
		panel.add(textArea_4_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("T\u1ED5ng ti\u1EC1n");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(640, 73, 100, 28);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Ph\u1EE5 thu");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setBounds(325, 112, 100, 28);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Vat(%)");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setBounds(325, 151, 100, 28);
		panel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Ng\u00E0y check");
		lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_4.setBounds(325, 190, 100, 28);
		panel.add(lblNewLabel_1_1_4);
		
		JTextArea textArea_4_2 = new JTextArea();
		textArea_4_2.setBounds(435, 114, 195, 28);
		panel.add(textArea_4_2);
		
		JTextArea textArea_4_3 = new JTextArea();
		textArea_4_3.setBounds(435, 153, 195, 28);
		panel.add(textArea_4_3);
		
		JTextArea textArea_4_4 = new JTextArea();
		textArea_4_4.setBounds(435, 192, 195, 28);
		panel.add(textArea_4_4);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Th\u1EF1c thu");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setBounds(640, 112, 100, 28);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Tr\u1EA3 tr\u01B0\u1EDBc");
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2.setBounds(640, 151, 100, 28);
		panel.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("C\u00F2n thi\u1EBFu");
		lblNewLabel_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_3.setBounds(640, 190, 100, 28);
		panel.add(lblNewLabel_1_1_1_3);
		
		JTextArea textArea_4_1_1 = new JTextArea();
		textArea_4_1_1.setBounds(750, 114, 195, 28);
		panel.add(textArea_4_1_1);
		
		JTextArea textArea_4_1_2 = new JTextArea();
		textArea_4_1_2.setBounds(750, 153, 195, 28);
		panel.add(textArea_4_1_2);
		
		JTextArea textArea_4_1_3 = new JTextArea();
		textArea_4_1_3.setBounds(750, 192, 195, 28);
		panel.add(textArea_4_1_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 231, 1244, 102);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 1224, 70);
		panel_2.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Stt", "Ph\u00F2ng", "nl", "te", "Check in", "Check out", "Ti\u1EC1n sp&dv", "Ti\u1EC1n ph\u00F2ng", "T\u1ED5ng ti\u1EC1n"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch d\u1ECBch v\u1EE5 & s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1.setBounds(10, 332, 1244, 299);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 1224, 267);
		panel_2_1.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Stt", "Ti\u1EC1n s\u1EA3n ph\u1EA9m", "D\u1ECBch v\u1EE5", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Check out");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(828, 642, 131, 28);
		panel.add(btnNewButton);
		
		JButton btnTchHan = new JButton("T\u00E1ch h\u00F3a \u0111\u01A1n");
		btnTchHan.setBackground(Color.WHITE);
		btnTchHan.setBounds(969, 642, 131, 28);
		panel.add(btnTchHan);
		
		JButton btnGiaHnPhng = new JButton("Gia h\u1EA1n ph\u00F2ng");
		btnGiaHnPhng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGiaHnPhng.setBackground(Color.WHITE);
		btnGiaHnPhng.setBounds(1110, 642, 131, 28);
		panel.add(btnGiaHnPhng);
		
		JLabel lblNewLabel_1_2 = new JLabel("L\u1EBB/theo \u0111o\u00E0n");
		lblNewLabel_1_2.setBounds(10, 114, 100, 28);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ghi ch\u00FA");
		lblNewLabel_1_3.setBounds(10, 151, 100, 28);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ng\u00E0y check in");
		lblNewLabel_1_4.setBounds(10, 190, 100, 28);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_1_1_4 = new JLabel("Kh\u00E1ch tr\u1EA3");
		lblNewLabel_1_1_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_4.setBounds(955, 75, 93, 28);
		panel.add(lblNewLabel_1_1_1_4);
		
		JTextArea textArea_4_1_4 = new JTextArea();
		textArea_4_1_4.setBounds(1059, 75, 195, 28);
		panel.add(textArea_4_1_4);
	}
}
