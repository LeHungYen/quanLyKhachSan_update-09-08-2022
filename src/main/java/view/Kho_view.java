package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import com.toedter.calendar.JDateChooser;

import models.ChucVuModel;
import models.KhoModel;
import models.NhanVienModel;
import models.PhieuKiemKhoModel;
import models.SanPhamVaDichVuModel;
import services.ChucVuService;
import services.KhoService;
import services.NhanVienService;
import utils.IoCContainer;
import utils.Utilities;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.DefaultComboBoxModel;

public class Kho_view extends JFrame {
	private IoCContainer _ioCContainer  = new IoCContainer();
	private KhoService _khoService = (KhoService) _ioCContainer.getBean(KhoService.class+"");
	private List<KhoModel> _listKhoModels = new ArrayList<KhoModel>();
//	private int _sttNhanVienEditing;
	
	private JPanel contentPane;
	private JTextField txt_tenKho;
	private JTextField txt_timKiem;
	private JTable table;
	private JButton btnSua;
	private JButton btnThem;
	private JTextField txt_maKho;
	private JComboBox cbx_trangThai_danhSach;
	private JComboBox cbx_trangThai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kho_view frame = new Kho_view();
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
	public Kho_view() {
		_khoService.updateListKhoModel();
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
		tabbedPane.setBounds(10, 11, 1244, 659);
		panel_1.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Danh Sách", null, panel_3, null);
		panel_3.setLayout(null);
		
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(190, 19, 321, 51);
		panel_3.add(panel_2_1);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "T\u00EAn kho", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		txt_tenKho = new JTextField();
		txt_tenKho.setText("Nhập tên kho");
		txt_tenKho.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Utilities.setTextFocusGained(txt_tenKho, "Nhập tên kho");
			}
			@Override
			public void focusLost(FocusEvent e) {
				Utilities.setTextFocusLost(txt_tenKho, "Nhập tên kho");
			}
		});
		txt_tenKho.setBackground(Color.WHITE);
		txt_tenKho.setBounds(10, 18, 301, 29);
		panel_2_1.add(txt_tenKho);
		((JComponent) txt_tenKho).setBorder(null);
		txt_tenKho.setColumns(10);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Danh s\u00E1ch kho", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1.setBackground(new Color(204, 204, 204));
		panel_2_1_1_1.setBounds(10, 81, 1219, 539);
		panel_3.add(panel_2_1_1_1);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_2.setBackground(Color.WHITE);
		panel_2_1_2.setBounds(207, 21, 1002, 51);
		panel_2_1_1_1.add(panel_2_1_2);
		txt_timKiem = new JTextField();
		txt_timKiem.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				timKiem();
			}
		});
		txt_timKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Utilities.setTextFocusGained(txt_timKiem, "Nhập tên để tìm kiếm");
			}
			@Override
			public void focusLost(FocusEvent e) {
				Utilities.setTextFocusLost(txt_timKiem, "Nhập tên để tìm kiếm");
			}
		});
		txt_timKiem.setText("Nhập tên để tìm kiếm");
		txt_timKiem.setColumns(10);
		txt_timKiem.setBorder(null);
		txt_timKiem.setBackground(Color.WHITE);
		txt_timKiem.setBounds(10, 18, 982, 29);
		panel_2_1_2.add(txt_timKiem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 1199, 431);
		panel_2_1_1_1.add(scrollPane);
		
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
		panel_2_2_1_1_1.setBounds(10, 21, 187, 51);
		panel_2_1_1_1.add(panel_2_2_1_1_1);
		
		cbx_trangThai_danhSach = new JComboBox();
		cbx_trangThai_danhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});
		cbx_trangThai_danhSach.setModel(new DefaultComboBoxModel(new String[] {"Hoat Dong", "Khong Hoat Dong"}));
		cbx_trangThai_danhSach.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_trangThai_danhSach.setBackground(Color.WHITE);
		cbx_trangThai_danhSach.setBounds(10, 18, 167, 28);
		panel_2_2_1_1_1.add(cbx_trangThai_danhSach);
		
		 btnThem = new JButton("Thêm");
		 btnThem.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		KhoModel khoModel = getInforFromFormIntoKhoModel();
		 		_khoService.them_sua(khoModel);
		 		updateTable();
		 		clearForm();
		 	}
		 });
		btnThem.setBackground(new Color(255, 204, 0));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(813, 19, 128, 51);
		panel_3.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhoModel khoModel = getInforFromFormIntoKhoModel();
		 		_khoService.them_sua(khoModel);
		 		updateTable();
		 		clearForm();
			}
		});
		btnSua.setEnabled(false);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBackground(new Color(255, 204, 0));
		btnSua.setBounds(951, 19, 128, 51);
		panel_3.add(btnSua);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBackground(new Color(255, 204, 0));
		btnClear.setBounds(1089, 19, 140, 51);
		panel_3.add(btnClear);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "M\u00E3 kho", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setBounds(10, 19, 170, 51);
		panel_3.add(panel_2_1_1);
		
		txt_maKho = new JTextField();
		txt_maKho.setEditable(false);
		txt_maKho.setColumns(10);
		txt_maKho.setBorder(null);
		txt_maKho.setBackground(Color.WHITE);
		txt_maKho.setBounds(10, 18, 150, 29);
		panel_2_1_1.add(txt_maKho);
		
		JPanel panel_2_2_1_1 = new JPanel();
		panel_2_2_1_1.setLayout(null);
		panel_2_2_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Tr\u1EA1ng th\u00E1i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1.setBounds(521, 19, 187, 51);
		panel_3.add(panel_2_2_1_1);
		
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
		txt_maKho.setText("");
		txt_tenKho.setText("Nhập tên kho");
		btnSua.setEnabled(false);
		btnThem.setEnabled(true);
	}
	
	public void doClickOnTable() {
		txt_maKho.setText(table.getModel().getValueAt(table.getSelectedRow(), 1)+"");
		txt_tenKho.setText(table.getModel().getValueAt(table.getSelectedRow(), 2)+"");
		String trangThai = table.getModel().getValueAt(table.getSelectedRow(), 3)+"";
		cbx_trangThai.setSelectedItem(trangThai);
		btnThem.setEnabled(false);
		btnSua.setEnabled(true);
	}
	
	public void updateTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("MÃ KHO");
		model.addColumn("TÊN KHO");
		model.addColumn("TRẠNG THÁI");
		List<KhoModel> listKhoModel = _khoService.getListKhoModel();
		int stt = 1;
		
			if(cbx_trangThai_danhSach.getSelectedItem().toString().equals("Hoat Dong")) {
				for (KhoModel khoModel : listKhoModel) {
					if(khoModel.getTrangThai().equals("Hoat Dong")) {
						model.addRow(new Object[] {stt,khoModel.getMaKho(),khoModel.getTenKho(),khoModel.getTrangThai()});
						stt++;
					}
				}
			}
			if(cbx_trangThai_danhSach.getSelectedItem().toString().equals("Khong Hoat Dong")) {
				for (KhoModel khoModel : listKhoModel) {
					if(khoModel.getTrangThai().equals("Khong Hoat Dong")) {
						model.addRow(new Object[] {stt,khoModel.getMaKho(),khoModel.getTenKho(),khoModel.getTrangThai()});
						stt++;
					}
				}
			}
		
		table.setModel(model);
	}
	
	public void timKiem() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("MÃ KHO");
		model.addColumn("TÊN KHO");
		model.addColumn("TRẠNG THÁI");
		List<KhoModel> listKhoModel = _khoService.getListKhoModel();
		int stt = 1;
		
		
			if(cbx_trangThai_danhSach.getSelectedItem().toString().equals("Hoat Dong")) {
				for (KhoModel khoModel : listKhoModel) {
					if(khoModel.getTrangThai().equals("Hoat Dong")) {
						if(txt_timKiem.getText().equals("Nhập tên để tìm kiếm") || txt_timKiem.getText().equals("")) {
							model.addRow(new Object[] {stt,khoModel.getMaKho(),khoModel.getTenKho(),khoModel.getTrangThai()});
							stt++;
						}else {
							String keySearch = txt_timKiem.getText().trim();
							if(khoModel.toString().contains(keySearch));{
								model.addRow(new Object[] {stt,khoModel.getMaKho(),khoModel.getTenKho(),khoModel.getTrangThai()});
								stt++;
							}
						}
						
					}
				}
			}
			if(cbx_trangThai_danhSach.getSelectedItem().toString().equals("Khong Hoat Dong")) {
				for (KhoModel khoModel : listKhoModel) {
					if(khoModel.getTrangThai().equals("Khong Hoat Dong")) {
						if(txt_timKiem.getText().equals("Nhập tên để tìm kiếm")) {
							model.addRow(new Object[] {stt,khoModel.getMaKho(),khoModel.getTenKho(),khoModel.getTrangThai()});
							stt++;
						}else {
							String keySearch = txt_timKiem.getText().trim();
							if(khoModel.toString().contains(keySearch));{
								model.addRow(new Object[] {stt,khoModel.getMaKho(),khoModel.getTenKho(),khoModel.getTrangThai()});
								stt++;
							}
						}
					}
				}
			}
		
		table.setModel(model);
	}
	
	public KhoModel getInforFromFormIntoKhoModel() {
		int maKho = 0;
		if(txt_maKho.getText().equals("")) {
			maKho = 0;
		}else {
			maKho = Integer.parseInt(txt_maKho.getText());
		}
		String trangThai = cbx_trangThai.getSelectedItem().toString();
		String tenKho = txt_tenKho.getText().trim();
		List<PhieuKiemKhoModel> listPhieuKiemKhoModel = new ArrayList<PhieuKiemKhoModel>();
		List<SanPhamVaDichVuModel> listSanPhamVaDichVuModel = new ArrayList<SanPhamVaDichVuModel>();
		KhoModel khoModel = new KhoModel( maKho, tenKho, trangThai);
		return khoModel;
	}
}