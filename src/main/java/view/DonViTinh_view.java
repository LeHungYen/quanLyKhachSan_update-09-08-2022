package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import models.DonViChiTietModel;
import models.DonViTinhModel;
import models.KhoModel;
import services.DonViTinhService;
import services.KhoService;
import utils.IoCContainer;
import utils.Utilities;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DonViTinh_view extends JFrame {
	private IoCContainer _ioCContainer  = new IoCContainer();
	private DonViTinhService _donViTinhService = (DonViTinhService) _ioCContainer.getBean(DonViTinhService.class+"");
	private List<DonViTinhModel> _listDonViTinhModels = new ArrayList<DonViTinhModel>();
	
	private JPanel contentPane;
	private JTextField txt_timKiem;
	private JTextField txt_tenDonVi;
	private JTextField txtMaDonVi;
	private JButton btn_them;
	private JButton btn_sua;
	private JTable table;
	private JComboBox cbx_trangThai_danhSach;
	private JComboBox cbx_trangThai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonViTinh_view frame = new DonViTinh_view();
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
	public DonViTinh_view() {
		_donViTinhService.updateListDonViTinhModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1264, 681);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 116, 1244, 554);
		panel_1.add(tabbedPane);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Danh sách đơn vị tính", null, panel_4, null);
		panel_4.setLayout(null);
		
		JButton btnThm = new JButton("Làm mới");
		btnThm.setBackground(new Color(255, 204, 102));
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThm.setBounds(1077, 578, 152, 42);
		panel_4.add(btnThm);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSa.setBackground(new Color(255, 204, 102));
		btnSa.setBounds(915, 578, 152, 42);
		panel_4.add(btnSa);
		
		JButton btnThm_2 = new JButton("Thêm");
		btnThm_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThm_2.setBackground(new Color(255, 204, 102));
		btnThm_2.setBounds(753, 578, 152, 42);
		panel_4.add(btnThm_2);
		
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(184, 11, 1045, 51);
		panel_4.add(panel_2_1);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "T\u00ECm ki\u1EBFm Theo t\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		txt_timKiem = new JTextField();
		txt_timKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Utilities.setTextFocusGained(txt_timKiem, "Nhập tên đơn vị muốn tìm");
			}
			@Override
			public void focusLost(FocusEvent e) {
				Utilities.setTextFocusLost(txt_timKiem, "Nhập tên đơn vị muốn tìm");
			}
		});
		txt_timKiem.setText("Nhập tên đơn vị muốn tìm");
		txt_timKiem.setBackground(Color.WHITE);
		txt_timKiem.setBounds(10, 18, 1199, 29);
		panel_2_1.add(txt_timKiem);
		txt_timKiem.setBorder(null);
		txt_timKiem.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 1219, 422);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				doClickOnTable();
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_2_2_1_1_1 = new JPanel();
		panel_2_2_1_1_1.setLayout(null);
		panel_2_2_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Tr\u1EA1ng th\u00E1i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2_1_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1_1.setBounds(10, 11, 164, 51);
		panel_4.add(panel_2_2_1_1_1);
		
		cbx_trangThai_danhSach = new JComboBox();
		cbx_trangThai_danhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});
		cbx_trangThai_danhSach.setModel(new DefaultComboBoxModel(new String[] {"Hoat Dong", "Khong Hoat Dong"}));
		cbx_trangThai_danhSach.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_trangThai_danhSach.setBackground(Color.WHITE);
		cbx_trangThai_danhSach.setBounds(10, 18, 144, 28);
		panel_2_2_1_1_1.add(cbx_trangThai_danhSach);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "T\u00EAn \u0111\u01A1n v\u1ECB", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setBounds(418, 30, 475, 51);
		panel_1.add(panel_2_1_1);
		
		txt_tenDonVi = new JTextField();
		txt_tenDonVi.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Utilities.setTextFocusGained(txt_tenDonVi, "Nhập tên đơn vị");
			}
			@Override
			public void focusLost(FocusEvent e) {
				Utilities.setTextFocusLost(txt_tenDonVi, "Nhập tên đơn vị");
			}
		});
		txt_tenDonVi.setText("Nhập tên đơn vị");
		txt_tenDonVi.setColumns(10);
		txt_tenDonVi.setBorder(null);
		txt_tenDonVi.setBackground(Color.WHITE);
		txt_tenDonVi.setBounds(10, 18, 455, 29);
		panel_2_1_1.add(txt_tenDonVi);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "M\u00E3 \u0111\u01A1n v\u1ECB", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1.setBackground(Color.WHITE);
		panel_2_1_1_1.setBounds(10, 30, 398, 51);
		panel_1.add(panel_2_1_1_1);
		
		txtMaDonVi = new JTextField();
		txtMaDonVi.setEditable(false);
		txtMaDonVi.setColumns(10);
		txtMaDonVi.setBorder(null);
		txtMaDonVi.setBackground(Color.WHITE);
		txtMaDonVi.setBounds(10, 18, 378, 29);
		panel_2_1_1_1.add(txtMaDonVi);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(1165, 82, 89, 23);
		panel_1.add(btnNewButton);
		
		 btn_sua = new JButton("Sửa");
		 btn_sua.setEnabled(false);
		 btn_sua.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		DonViTinhModel donViTinhModel = getInforFromFormIntoDonViTinhModel();
		 		_donViTinhService.them_sua(donViTinhModel);
		 		clearForm();
		 		updateTable();
		 	}
		 });
		btn_sua.setBackground(Color.ORANGE);
		btn_sua.setBounds(1165, 56, 89, 23);
		panel_1.add(btn_sua);
		
		 btn_them = new JButton("Thêm");
		 btn_them.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		DonViTinhModel donViTinhModel = getInforFromFormIntoDonViTinhModel();
		 		_donViTinhService.them_sua(donViTinhModel);
		 		clearForm();
		 		updateTable();
		 	}
		 });
		btn_them.setBackground(Color.ORANGE);
		btn_them.setBounds(1165, 30, 89, 23);
		panel_1.add(btn_them);
		
		JPanel panel_2_2_1_1 = new JPanel();
		panel_2_2_1_1.setLayout(null);
		panel_2_2_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Tr\u1EA1ng th\u00E1i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1.setBounds(903, 30, 187, 51);
		panel_1.add(panel_2_2_1_1);
		
		cbx_trangThai = new JComboBox();
		cbx_trangThai.setModel(new DefaultComboBoxModel(new String[] {"Hoat Dong", "Khong Hoat Dong"}));
		cbx_trangThai.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_trangThai.setBackground(Color.WHITE);
		cbx_trangThai.setBounds(10, 18, 167, 28);
		panel_2_2_1_1.add(cbx_trangThai);
		updateTable();
	}
	
	public void clearForm() {
		cbx_trangThai.setSelectedIndex(0);
		txtMaDonVi.setText("");
		txt_tenDonVi.setText("Nhập tên đơn vị");
		btn_sua.setEnabled(false);
		btn_them.setEnabled(true);
	}
	
	public void doClickOnTable() {
		txtMaDonVi.setText(table.getModel().getValueAt(table.getSelectedRow(), 1)+"");
		txt_tenDonVi.setText(table.getModel().getValueAt(table.getSelectedRow(), 2)+"");
		String trangThai = table.getModel().getValueAt(table.getSelectedRow(), 3)+"";
		cbx_trangThai.setSelectedItem(trangThai);
		btn_them.setEnabled(false);
		btn_sua.setEnabled(true);
	}
	
	public void updateTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("MÃ ĐƠN VỊ");
		model.addColumn("TÊN ĐƠN VỊ");
		model.addColumn("TRẠNG THÁI");
		_listDonViTinhModels = _donViTinhService.getListDonViTinhModel();
		int stt = 1;
		
		if(cbx_trangThai_danhSach.getSelectedItem().toString().equals("Hoat Dong")) {
			for (DonViTinhModel donViTinhModel : _listDonViTinhModels) {
				if(donViTinhModel.getTrangThai().equals("Hoat Dong")) {
					model.addRow(new Object[] {stt,donViTinhModel.getMaDonVi(),donViTinhModel.getTenDonVi(),donViTinhModel.getTrangThai()});
					stt++;
				}
			}
				
		}
		if(cbx_trangThai_danhSach.getSelectedItem().toString().equals("Khong Hoat Dong")) {
			for (DonViTinhModel donViTinhModel : _listDonViTinhModels) {
				if(donViTinhModel.getTrangThai().equals("Khong Hoat Dong")) {
					model.addRow(new Object[] {stt,donViTinhModel.getMaDonVi(),donViTinhModel.getTenDonVi(),donViTinhModel.getTrangThai()});
					stt++;
				}
			}
			
		}
		table.setModel(model);
	}
	
	public DonViTinhModel getInforFromFormIntoDonViTinhModel() {
		int maDonVi = 0;
		if(txtMaDonVi.getText().equals("")) {
			maDonVi = 0;
		}else {
			maDonVi = Integer.parseInt(txtMaDonVi.getText());
		}
		String trangThai = cbx_trangThai.getSelectedItem().toString();
		String tenDonVi = txt_tenDonVi.getText().trim();
		List<DonViChiTietModel> listViChiTietModels = new ArrayList<DonViChiTietModel>();
		DonViTinhModel donViTinhModel = new DonViTinhModel(maDonVi, tenDonVi, trangThai);
		return donViTinhModel;
	}
}
