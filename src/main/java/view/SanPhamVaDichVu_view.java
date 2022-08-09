package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import entities.PhieuNhapKhoChiTiet;
import models.DichVuPhongModel;
import models.DonViChiTietModel;
import models.DonViTinhModel;
import models.KhoModel;
import models.NhomSPVaDichVuModel;
import models.PhieuKiemKhoChiTietModel;
import models.PhieuNhapKhoChiTietModel;
import models.SanPhamVaDichVuModel;
import services.DonViChiTietService;
import services.DonViTinhService;
import services.KhoService;
import services.NhomSPVaDichVuService;
import services.SanPhamVaDichVuService;
import utils.IoCContainer;
import utils.Utilities;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class SanPhamVaDichVu_view extends JFrame {
	private IoCContainer _ioCContainer  = new IoCContainer();
	private SanPhamVaDichVuService _sanPhamVaDichVuService = (SanPhamVaDichVuService) _ioCContainer.getBean(SanPhamVaDichVuService.class+"");
	private List<SanPhamVaDichVuModel> _listSanPhamVaDichVuModels = new ArrayList<SanPhamVaDichVuModel>();
	private NhomSPVaDichVuService _nhomSPVaDichVuService = (NhomSPVaDichVuService) _ioCContainer.getBean(NhomSPVaDichVuService.class+"");
	private List<NhomSPVaDichVuModel> _listNhomSPVaDichVuModels_active = new ArrayList<NhomSPVaDichVuModel>();
	private DonViTinhService _donViTinhService = (DonViTinhService) _ioCContainer.getBean(DonViTinhService.class+"");
	private List<DonViTinhModel> _listDonViTinhModels_active = new ArrayList<DonViTinhModel>();
	private DonViChiTietService _donViChiTietService = (DonViChiTietService) _ioCContainer.getBean(DonViChiTietService.class+"");
	private KhoService _khoService = (KhoService) _ioCContainer.getBean(KhoService.class+"");
	private List<KhoModel> _listKhoModels_active = new ArrayList<KhoModel>();
	//
	private List<DonViChiTietModel> _listDonViChiTietModels = new ArrayList<DonViChiTietModel>();
	private int maxID_sanSPVaDichVu;
	private int maxID_donViChiTiet;
	private int maxID_donViChiTiet1;
	
	private JPanel contentPane;
	private JTextField txt_search;
	private JTable table_danhSachSanPhamVaDichVu;
	private JTextField txt_tenHangHoa;
	private JTextField txt_maSanPham;
	private JTextField txt_giaTriQuyDoi;
	private JTextField txt_giaBan;
	private JTable table_danhSachDonViTinhActive;
	private JTable table_danhSachDonViTinhInactive;
	private JComboBox cbx_nhomSanPham;
	private JTextArea txt_moTa;
	private JTextField txt_soLuongTon;
	private JTextField txt_giaVon;
	private JComboBox cbx_kho;
	private JButton btn_suaSanPham;
	private JButton btn_themSanPham;
	private JComboBox cbx_donViTinh;
	private JButton btn_suaDonVi;
	private JButton btn_themDonVi;
	private JTextField txt_maDonVi;
	private JButton btn_xoaDonVi;
	private JPanel panel_donViTinh;
	private JCheckBox ckb_donViCoBan;
	private JComboBox cbx_trangThai_danhSach;
	private JComboBox cbx_kho_danhSach;
	private JComboBox cbx_nhomSanPham_danhSach;
	private JComboBox cbx_nhomHangHoa;
	private JComboBox cbx_sapXep;
	private JComboBox cbx_trangThai_sanPham;
	private JComboBox cbx_trangThai_donVi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SanPhamVaDichVu_view frame = new SanPhamVaDichVu_view();
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
	public SanPhamVaDichVu_view() {
		_donViChiTietService.updateListDonViChiTietModel();
		maxID_donViChiTiet = _donViChiTietService.getMaxID();
		maxID_donViChiTiet1 = _donViChiTietService.getMaxID();
		
		_sanPhamVaDichVuService.updateListSanPhamVaDichVuModel();
		maxID_sanSPVaDichVu = _sanPhamVaDichVuService.getMaxID();
		_nhomSPVaDichVuService.updateListNhomSPVaDichVuModel("Hoat Dong");
		_donViTinhService.updateListDonViTinhModel_active();
		_khoService.updateListKhoModel("Hoat Dong");
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(730, 19, 338, 51);
		panel_3.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Nh\u00F3m s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setLayout(null);
		
		cbx_nhomSanPham_danhSach = new JComboBox();
		cbx_nhomSanPham_danhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable_danhSachSanPhamVaDichVu();
			}
		});
		cbx_nhomSanPham_danhSach.setModel(new DefaultComboBoxModel(new String[] {"Tất cả"}));
		cbx_nhomSanPham_danhSach.setBackground(Color.WHITE);
		cbx_nhomSanPham_danhSach.setBounds(10, 18, 318, 28);
		cbx_nhomSanPham_danhSach.setBorder(new EmptyBorder(-11, -4, -11, -1));
		panel_2.add(cbx_nhomSanPham_danhSach);
		
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(10, 81, 610, 51);
		panel_3.add(panel_2_1);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "T\u00ECm ki\u1EBFm Theo t\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		txt_search = new JTextField();
		txt_search.setBackground(Color.WHITE);
		txt_search.setBounds(10, 18, 543, 29);
		panel_2_1.add(txt_search);
		txt_search.setBorder(null);
		txt_search.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 137, 1219, 483);
		panel_3.add(scrollPane);
		
		table_danhSachSanPhamVaDichVu = new JTable();
		table_danhSachSanPhamVaDichVu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				doClickOnTable_danhSachSanPhamVaDichVu();
			}
		});
		scrollPane.setViewportView(table_danhSachSanPhamVaDichVu);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Nh\u00F3m h\u00E0ng h\u00F3a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(378, 19, 338, 51);
		panel_3.add(panel_2_2);
		
		cbx_nhomHangHoa = new JComboBox();
		cbx_nhomHangHoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable_danhSachSanPhamVaDichVu();
			}
		});
		cbx_nhomHangHoa.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "San pham", "Dich vu"}));
		cbx_nhomHangHoa.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_nhomHangHoa.setBackground(Color.WHITE);
		cbx_nhomHangHoa.setBounds(10, 18, 318, 28);
		panel_2_2.add(cbx_nhomHangHoa);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "S\u1EAFp x\u1EBFp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_3.setBackground(Color.WHITE);
		panel_2_3.setBounds(891, 81, 338, 51);
		panel_3.add(panel_2_3);
		
		cbx_sapXep = new JComboBox();
		cbx_sapXep.setModel(new DefaultComboBoxModel(new String[] {"Tên A => Z", "Tên Z => A", "Giá: Thấp => Cao", "Giá: Cao => Thấp"}));
		cbx_sapXep.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_sapXep.setBackground(Color.WHITE);
		cbx_sapXep.setBounds(10, 18, 318, 28);
		panel_2_3.add(cbx_sapXep);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Kho", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2_1.setBackground(Color.WHITE);
		panel_2_2_1.setBounds(207, 19, 161, 51);
		panel_3.add(panel_2_2_1);
		
		cbx_kho_danhSach = new JComboBox();
		cbx_kho_danhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable_danhSachSanPhamVaDichVu();
			}
		});
		cbx_kho_danhSach.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_kho_danhSach.setBackground(Color.WHITE);
		cbx_kho_danhSach.setBounds(10, 18, 141, 28);
		panel_2_2_1.add(cbx_kho_danhSach);
		
		JPanel panel_2_2_1_1 = new JPanel();
		panel_2_2_1_1.setLayout(null);
		panel_2_2_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Tr\u1EA1ng th\u00E1i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1.setBounds(10, 19, 187, 51);
		panel_3.add(panel_2_2_1_1);
		
		cbx_trangThai_danhSach = new JComboBox();
		cbx_trangThai_danhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable_danhSachSanPhamVaDichVu();
			}
		});
		cbx_trangThai_danhSach.setModel(new DefaultComboBoxModel(new String[] {"Hoat Dong", "Khong Hoat Dong"}));
		cbx_trangThai_danhSach.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_trangThai_danhSach.setBackground(Color.WHITE);
		cbx_trangThai_danhSach.setBounds(10, 18, 167, 28);
		panel_2_2_1_1.add(cbx_trangThai_danhSach);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Cập Nhật Sản Phẩm - Dịch Vụ", null, panel_4, null);
		panel_4.setLayout(null);
		
		 txt_moTa = new JTextArea();
		txt_moTa.setBounds(10, 198, 1207, 78);
		panel_4.add(txt_moTa);
		
		JButton btnThm = new JButton("Làm mới");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFormSanPham();
			}
		});
		btnThm.setBackground(new Color(255, 204, 102));
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThm.setBounds(1077, 588, 152, 32);
		panel_4.add(btnThm);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("MÔ TẢ");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(10, 167, 185, 32);
		panel_4.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Thông tin chung");
		lblNewLabel_1_3.setForeground(new Color(255, 153, 102));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(10, 0, 371, 32);
		panel_4.add(lblNewLabel_1_3);
		
		JPanel panel_2_4 = new JPanel();
		panel_2_4.setLayout(null);
		panel_2_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Nh\u00F3m s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_4.setBackground(Color.WHITE);
		panel_2_4.setBounds(760, 43, 324, 51);
		panel_4.add(panel_2_4);
		
		cbx_nhomSanPham = new JComboBox();
		cbx_nhomSanPham.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_nhomSanPham.setBackground(Color.WHITE);
		cbx_nhomSanPham.setBounds(10, 18, 304, 28);
		panel_2_4.add(cbx_nhomSanPham);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "T\u00EAn H\u00E0ng H\u00F3a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setBounds(306, 43, 444, 51);
		panel_4.add(panel_2_1_1);
		
		txt_tenHangHoa = new JTextField("Nhập tên hàng hóa");
		txt_tenHangHoa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Utilities.setTextFocusGained(txt_tenHangHoa, "Nhập tên hàng hóa");
			}
			@Override
			public void focusLost(FocusEvent e) {
				Utilities.setTextFocusLost(txt_tenHangHoa, "Nhập tên hàng hóa");
			}
		});
		txt_tenHangHoa.setColumns(10);
		txt_tenHangHoa.setBorder(null);
		txt_tenHangHoa.setBackground(Color.WHITE);
		txt_tenHangHoa.setBounds(10, 18, 424, 29);
		panel_2_1_1.add(txt_tenHangHoa);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "M\u00E3 s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_2.setBackground(Color.WHITE);
		panel_2_1_2.setBounds(10, 43, 286, 51);
		panel_4.add(panel_2_1_2);
		
		txt_maSanPham = new JTextField();
		txt_maSanPham.setEditable(false);
		txt_maSanPham.setColumns(10);
		txt_maSanPham.setBorder(null);
		txt_maSanPham.setBackground(Color.WHITE);
		txt_maSanPham.setBounds(10, 18, 266, 29);
		panel_2_1_2.add(txt_maSanPham);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "\u0110\u01A1n v\u1ECB t\u00EDnh", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 287, 1219, 290);
		panel_4.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 120, 577, 159);
		panel.add(scrollPane_1);
		
		table_danhSachDonViTinhActive = new JTable();
		table_danhSachDonViTinhActive.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				doClickOnTable_danhSachDonViTinh(table_danhSachDonViTinhActive,"Hoat Dong");
			}
		});
		scrollPane_1.setViewportView(table_danhSachDonViTinhActive);
		
		JLabel lblNewLabel_1 = new JLabel("Đơn vị tính đã chọn - Hoạt động");
		lblNewLabel_1.setBounds(10, 105, 225, 14);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Gi\u00E1 tr\u1ECB quy \u0111\u1ED5i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_1.setBackground(Color.WHITE);
		panel_2_1_1_1_1.setBounds(315, 27, 102, 51);
		panel.add(panel_2_1_1_1_1);
		
		txt_giaTriQuyDoi = new JTextField();
		txt_giaTriQuyDoi.setEditable(false);
		txt_giaTriQuyDoi.setText("1");
		txt_giaTriQuyDoi.setColumns(10);
		txt_giaTriQuyDoi.setBorder(null);
		txt_giaTriQuyDoi.setBackground(Color.WHITE);
		txt_giaTriQuyDoi.setBounds(10, 18, 80, 22);
		panel_2_1_1_1_1.add(txt_giaTriQuyDoi);
		
		JPanel panel_2_1_1_1_3 = new JPanel();
		panel_2_1_1_1_3.setLayout(null);
		panel_2_1_1_1_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Gi\u00E1 b\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_3.setBackground(Color.WHITE);
		panel_2_1_1_1_3.setBounds(427, 27, 152, 51);
		panel.add(panel_2_1_1_1_3);
		
		txt_giaBan = new JTextField("Nhập giá bán");
		txt_giaBan.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Utilities.setTextFocusGained(txt_giaBan, "Nhập giá bán");
			}
			@Override
			public void focusLost(FocusEvent e) {
				Utilities.setTextFocusLost(txt_giaBan, "Nhập giá bán");
			}
		});
		txt_giaBan.setColumns(10);
		txt_giaBan.setBorder(null);
		txt_giaBan.setBackground(Color.WHITE);
		txt_giaBan.setBounds(10, 18, 127, 22);
		panel_2_1_1_1_3.add(txt_giaBan);
		
		 panel_donViTinh = new JPanel();
		panel_donViTinh.setLayout(null);
		panel_donViTinh.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "\u0110\u01A1n v\u1ECB c\u01A1 b\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_donViTinh.setBackground(Color.WHITE);
		panel_donViTinh.setBounds(100, 27, 205, 51);
		panel.add(panel_donViTinh);
		
		cbx_donViTinh = new JComboBox();
		cbx_donViTinh.setModel(new DefaultComboBoxModel(new String[] {"Chọn đơn vị tính"}));
		cbx_donViTinh.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_donViTinh.setBackground(Color.WHITE);
		cbx_donViTinh.setBounds(10, 18, 185, 28);
		panel_donViTinh.add(cbx_donViTinh);
		
		JButton btnNewButton = new JButton("Làm mới");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFormDonViTinh();
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(1122, 40, 87, 38);
		panel.add(btnNewButton);
		
		btn_suaDonVi = new JButton("Sửa");
		btn_suaDonVi.setEnabled(false);
		btn_suaDonVi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaDonViTinh();
				updateTable_danhSachDonViTinhActive(_listDonViChiTietModels);
				updateTable_danhSachDonViTinhInactive(_listDonViChiTietModels);
			}
		});
		btn_suaDonVi.setBackground(Color.ORANGE);
		btn_suaDonVi.setBounds(928, 40, 87, 38);
		panel.add(btn_suaDonVi);
		
		btn_themDonVi = new JButton("Thêm");
		btn_themDonVi.setBackground(Color.ORANGE);
		btn_themDonVi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themDonViTinh();
				updateTable_danhSachDonViTinhInactive(_listDonViChiTietModels);
				updateTable_danhSachDonViTinhActive(_listDonViChiTietModels);
//				clearFormDonViTinh();
			}
		});
		btn_themDonVi.setBounds(831, 40, 87, 38);
		panel.add(btn_themDonVi);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(632, 120, 577, 159);
		panel.add(scrollPane_1_1);
		
		table_danhSachDonViTinhInactive = new JTable();
		table_danhSachDonViTinhInactive.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				doClickOnTable_danhSachDonViTinh(table_danhSachDonViTinhInactive,"Khong Hoat Dong");
			}
		});
		scrollPane_1_1.setViewportView(table_danhSachDonViTinhInactive);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đơn vị tính đã chọn - Không hoạt động");
		lblNewLabel_1_1.setBounds(632, 105, 263, 14);
		panel.add(lblNewLabel_1_1);
		
		JPanel panel_2_1_1_1_3_1 = new JPanel();
		panel_2_1_1_1_3_1.setLayout(null);
		panel_2_1_1_1_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "M\u00E3 \u0111\u01A1n v\u1ECB", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_3_1.setBackground(Color.WHITE);
		panel_2_1_1_1_3_1.setBounds(10, 27, 80, 51);
		panel.add(panel_2_1_1_1_3_1);
		
		txt_maDonVi = new JTextField("");
		txt_maDonVi.setEditable(false);
		txt_maDonVi.setColumns(10);
		txt_maDonVi.setBorder(null);
		txt_maDonVi.setBackground(Color.WHITE);
		txt_maDonVi.setBounds(10, 18, 57, 22);
		panel_2_1_1_1_3_1.add(txt_maDonVi);
		
		btn_suaSanPham = new JButton("Sửa");
		btn_suaSanPham.setEnabled(false);
		btn_suaSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them_suaSanPham();
			}
		});
		btn_suaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_suaSanPham.setBackground(new Color(255, 204, 102));
		btn_suaSanPham.setBounds(915, 588, 152, 32);
		panel_4.add(btn_suaSanPham);
		
		btn_themSanPham = new JButton("Thêm");
		btn_themSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them_suaSanPham();
				maxID_sanSPVaDichVu++;
				clearFormSanPham();
			}
		});
		btn_themSanPham.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_themSanPham.setBackground(new Color(255, 204, 102));
		btn_themSanPham.setBounds(753, 588, 152, 32);
		panel_4.add(btn_themSanPham);
		
		JPanel panel_2_4_1 = new JPanel();
		panel_2_4_1.setLayout(null);
		panel_2_4_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Kho", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_4_1.setBackground(Color.WHITE);
		panel_2_4_1.setBounds(10, 116, 286, 51);
		panel_4.add(panel_2_4_1);
		
		cbx_kho = new JComboBox();
		cbx_kho.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_kho.setBackground(Color.WHITE);
		cbx_kho.setBounds(10, 18, 266, 28);
		panel_2_4_1.add(cbx_kho);
		
		JPanel panel_2_1_2_1 = new JPanel();
		panel_2_1_2_1.setLayout(null);
		panel_2_1_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "S\u1ED1 l\u01B0\u1EE3ng t\u1ED3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_2_1.setBackground(Color.WHITE);
		panel_2_1_2_1.setBounds(306, 116, 286, 51);
		panel_4.add(panel_2_1_2_1);
		
		txt_soLuongTon = new JTextField();
		txt_soLuongTon.setEditable(false);
		txt_soLuongTon.setText("0");
		txt_soLuongTon.setColumns(10);
		txt_soLuongTon.setBorder(null);
		txt_soLuongTon.setBackground(Color.WHITE);
		txt_soLuongTon.setBounds(10, 18, 266, 29);
		panel_2_1_2_1.add(txt_soLuongTon);
		
		JPanel panel_2_1_2_1_1 = new JPanel();
		panel_2_1_2_1_1.setLayout(null);
		panel_2_1_2_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Gi\u00E1 v\u1ED1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_2_1_1.setBackground(Color.WHITE);
		panel_2_1_2_1_1.setBounds(602, 116, 286, 51);
		panel_4.add(panel_2_1_2_1_1);
		
		txt_giaVon = new JTextField();
		txt_giaVon.setEditable(false);
		txt_giaVon.setText("0");
		txt_giaVon.setColumns(10);
		txt_giaVon.setBorder(null);
		txt_giaVon.setBackground(Color.WHITE);
		txt_giaVon.setBounds(10, 18, 266, 29);
		panel_2_1_2_1_1.add(txt_giaVon);
		updateCbx_nhomSanPham("cbx_nhomSanPham");
		updateCbx_nhomSanPham("cbx_nhomSanPham_danhSach");
		updateCbx_doViTinh();
		
		txt_maDonVi.setText(maxID_donViChiTiet+"");
		
		btn_xoaDonVi = new JButton("Xóa");
		btn_xoaDonVi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaDonViTinh();
			}
		});
		btn_xoaDonVi.setEnabled(false);
		btn_xoaDonVi.setBackground(Color.ORANGE);
		btn_xoaDonVi.setBounds(1025, 40, 87, 38);
		panel.add(btn_xoaDonVi);
		
		ckb_donViCoBan = new JCheckBox("Đơn vị cơ bản");
		ckb_donViCoBan.setSelected(true);
		ckb_donViCoBan.setEnabled(false);
		ckb_donViCoBan.setBounds(714, 40, 111, 38);
		panel.add(ckb_donViCoBan);
		
		JPanel panel_2_2_1_1_1_1 = new JPanel();
		panel_2_2_1_1_1_1.setBounds(589, 27, 119, 51);
		panel.add(panel_2_2_1_1_1_1);
		panel_2_2_1_1_1_1.setLayout(null);
		panel_2_2_1_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Tr\u1EA1ng th\u00E1i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2_1_1_1_1.setBackground(Color.WHITE);
		
		cbx_trangThai_donVi = new JComboBox();
		cbx_trangThai_donVi.setModel(new DefaultComboBoxModel(new String[] {"Hoat Dong", "Khong Hoat Dong"}));
		cbx_trangThai_donVi.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_trangThai_donVi.setBackground(Color.WHITE);
		cbx_trangThai_donVi.setBounds(10, 18, 99, 28);
		panel_2_2_1_1_1_1.add(cbx_trangThai_donVi);
		
		JPanel panel_2_2_1_1_1 = new JPanel();
		panel_2_2_1_1_1.setLayout(null);
		panel_2_2_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Tr\u1EA1ng th\u00E1i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2_1_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1_1.setBounds(1094, 43, 133, 51);
		panel_4.add(panel_2_2_1_1_1);
		
		cbx_trangThai_sanPham = new JComboBox();
		cbx_trangThai_sanPham.setModel(new DefaultComboBoxModel(new String[] {"Hoat Dong", "Khong Hoat Dong"}));
		cbx_trangThai_sanPham.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_trangThai_sanPham.setBackground(Color.WHITE);
		cbx_trangThai_sanPham.setBounds(10, 18, 113, 28);
		panel_2_2_1_1_1.add(cbx_trangThai_sanPham);
		updateTxt_maSanPham();
		updateCbx_kho("cbx_kho");
		updateCbx_kho("cbx_kho_danhSach");
		updateTable_danhSachSanPhamVaDichVu();
	}
	
	public void updateTxt_maSanPham() {
		txt_maSanPham.setText(maxID_sanSPVaDichVu+"");
	}
	public void updateCbx_nhomSanPham(String tenCbxNhomSanPham) {
		_listNhomSPVaDichVuModels_active = _nhomSPVaDichVuService.getListNhomSPVaDichVuModelActive();
		String arrayNhomSPVaDichVu[] = new String[_listNhomSPVaDichVuModels_active.size()+1];
		
		int index =1;
		for (NhomSPVaDichVuModel nhomSPVaDichVuModel : _listNhomSPVaDichVuModels_active) {
			arrayNhomSPVaDichVu[index] = nhomSPVaDichVuModel.getTenNhomSP();
			index++;
		}
		if(tenCbxNhomSanPham.equals("cbx_nhomSanPham")) {
			arrayNhomSPVaDichVu[0] = "--Chọn nhóm--";
			cbx_nhomSanPham.setModel(new DefaultComboBoxModel(arrayNhomSPVaDichVu));
		}
		if(tenCbxNhomSanPham.equals("cbx_nhomSanPham_danhSach")) {
			arrayNhomSPVaDichVu[0] = "Tất cả";
			cbx_nhomSanPham_danhSach.setModel(new DefaultComboBoxModel(arrayNhomSPVaDichVu));
		}
		
	}
	
	public void updateCbx_kho(String cbxKho) {
		_listKhoModels_active = _khoService.getListKhoModel_active();
		String arrayKho[] = new String[_listKhoModels_active.size()+1];
		int index =1;
		for (KhoModel khoModel : _listKhoModels_active) {
			arrayKho[index] = khoModel.getTenKho();
			index++;
		}
		if(cbxKho.equals("cbx_kho")) {
			arrayKho[0] = "--Chọn kho--";
			cbx_kho.setModel(new DefaultComboBoxModel(arrayKho));
		}
		if(cbxKho.equals("cbx_kho_danhSach")) {
			arrayKho[0] = "Tất cả";
			cbx_kho_danhSach.setModel(new DefaultComboBoxModel(arrayKho));
		}
	}
	
	public void updateCbx_doViTinh() {
		_listDonViTinhModels_active = _donViTinhService.getListDonViTinhModel_active();
		String arrayDonViTinh[] = new String[_listDonViTinhModels_active.size()+1];
		arrayDonViTinh[0] = "--Chọn đơn vị tính--";
		int index =1;
		for (DonViTinhModel donViTinhModel : _listDonViTinhModels_active) {
			arrayDonViTinh[index] = donViTinhModel.getTenDonVi();
			index++;
		}
		cbx_donViTinh.setModel(new DefaultComboBoxModel(arrayDonViTinh));
	}
	
	public void clearFormSanPham() {
		cbx_trangThai_sanPham.setSelectedIndex(0);
		cbx_trangThai_donVi.setSelectedIndex(0);
//		switchButton_nhap.setSelected(true);
//		switchButton_nhapDonViTinh.setSelected(true);
		txt_maSanPham.setText("");
		txt_tenHangHoa.setText("Nhập tên hàng hóa");
		cbx_nhomSanPham.setSelectedIndex(0);
		cbx_kho.setSelectedIndex(0);
		txt_soLuongTon.setText("0");
		txt_giaVon.setText("0");
		txt_moTa.setText("");
		_listDonViChiTietModels = new ArrayList<DonViChiTietModel>();
		updateTable_danhSachDonViTinhActive(_listDonViChiTietModels);
		updateTable_danhSachDonViTinhInactive(_listDonViChiTietModels);
		btn_suaSanPham.setEnabled(false);
		btn_themSanPham.setEnabled(true);
		updateTxt_maSanPham();
		clearFormDonViTinh();
	}
	
	public void clearFormDonViTinh() {
		
		if(_listDonViChiTietModels.size() ==0) {
			txt_giaTriQuyDoi.setEditable(false);
			txt_giaTriQuyDoi.setText("1");
			
		}else {
			txt_giaTriQuyDoi.setEditable(true);
		}
		txt_maDonVi.setText(maxID_donViChiTiet1+"");
		cbx_donViTinh.setSelectedIndex(0);
		txt_giaBan.setText("Nhập giá bán");
		cbx_donViTinh.setSelectedIndex(0);
//		switchButton_nhapDonViTinh.setSelected(true);
		btn_suaDonVi.setEnabled(false);
		btn_xoaDonVi.setEnabled(false);
		btn_themDonVi.setEnabled(true);
		checkDonViCoBan();
		
	}
	
	public void doClickOnTable_danhSachSanPhamVaDichVu() {
		int maSanPham = Integer.parseInt(table_danhSachSanPhamVaDichVu.getModel().getValueAt(table_danhSachSanPhamVaDichVu.getSelectedRow(), 1)+"");
		for (SanPhamVaDichVuModel sanPhamVaDichVuModel : _listSanPhamVaDichVuModels) {
			if(sanPhamVaDichVuModel.getMaDichVu() == maSanPham) {
				txt_maSanPham.setText(sanPhamVaDichVuModel.getMaDichVu()+"");
				txt_tenHangHoa.setText(sanPhamVaDichVuModel.getTenHangHoa());
				cbx_nhomSanPham.setSelectedItem(sanPhamVaDichVuModel.getNhomSPVaDichVuModel().getTenNhomSP());
//				if(.equals("Hoat Dong")) {
//					switchButton_nhap.setSelected(true);
//				}else {
//					switchButton_nhap.setSelected(false);
//				}
				
				cbx_trangThai_sanPham.setSelectedItem(sanPhamVaDichVuModel.getTrangThai());
				
				cbx_kho.setSelectedItem(sanPhamVaDichVuModel.getKhoModel().getTenKho());
				txt_soLuongTon.setText(sanPhamVaDichVuModel.getSoLuongTon()+"");
				txt_giaVon.setText(sanPhamVaDichVuModel.getGiaVon()+"");
				txt_moTa.setText(sanPhamVaDichVuModel.getMoTa());
				
				_listDonViChiTietModels = _sanPhamVaDichVuService.getListDVCTM(sanPhamVaDichVuModel);
				updateTable_danhSachDonViTinhActive(_listDonViChiTietModels);
				updateTable_danhSachDonViTinhInactive(_listDonViChiTietModels);
			}
			btn_suaSanPham.setEnabled(true);
			btn_themSanPham.setEnabled(false);
			clearFormDonViTinh();
//			checkDonViCoBan();
//			stt_SPSelected++;
		}
	}
	
	public void doClickOnTable_danhSachDonViTinh(JTable tableDonViTinh , String trangThaiTable) {
		int maDonVi = Integer.parseInt(tableDonViTinh.getModel().getValueAt(tableDonViTinh.getSelectedRow(), 1)+"");
		txt_maDonVi.setText(maDonVi+"");
		cbx_donViTinh.setSelectedItem(tableDonViTinh.getModel().getValueAt(tableDonViTinh.getSelectedRow(), 2));
		txt_giaTriQuyDoi.setText(tableDonViTinh.getModel().getValueAt(tableDonViTinh.getSelectedRow(), 3)+"");
		txt_giaBan.setText(tableDonViTinh.getModel().getValueAt(tableDonViTinh.getSelectedRow(), 4)+"");
		
		String trangThai="";
		if(trangThaiTable.equals("Hoat Dong")) {
			String donViCoBan = tableDonViTinh.getModel().getValueAt(tableDonViTinh.getSelectedRow(), 5)+"";
			if(donViCoBan.equals("true")) {
				ckb_donViCoBan.setSelected(true);
			}else {
				ckb_donViCoBan.setSelected(false);
			}
			trangThai =tableDonViTinh.getModel().getValueAt(tableDonViTinh.getSelectedRow(), 6)+"";
		}else {
			trangThai =tableDonViTinh.getModel().getValueAt(tableDonViTinh.getSelectedRow(), 5)+"";
			ckb_donViCoBan.setSelected(false);
		}
		
//		if(trangThai.equals("Hoat Dong")) {
//			switchButton_nhapDonViTinh.setSelected(true);
//		}else {
//			switchButton_nhapDonViTinh.setSelected(false);
//		}
		cbx_trangThai_donVi.setSelectedItem(trangThai);
		
		if(maDonVi>=maxID_donViChiTiet) {
			btn_xoaDonVi.setEnabled(true);
		}
		
		btn_suaDonVi.setEnabled(true);
		btn_themDonVi.setEnabled(false);
		if(txt_giaTriQuyDoi.getText().equals("1")) { ///////////////////////bug
			panel_donViTinh.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Đơn vị cơ bản", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			txt_giaTriQuyDoi.setEditable(false);
		}else {
			panel_donViTinh.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Đơn vị quy đổi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			txt_giaTriQuyDoi.setEditable(true);
		}
	}
	
	public void updateTable_danhSachDonViTinhActive(List<DonViChiTietModel> listDonViChiTietModels){
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("STT");
		model.addColumn("MÃ ĐƠN VỊ");
		model.addColumn("TÊN ĐƠN VỊ");
		model.addColumn("GIÁ TRỊ QUY ĐỔI");
		model.addColumn("GIÁ BÁN");
		model.addColumn("ĐƠN VỊ CƠ BẢN");
		model.addColumn("TRẠNG THÁI");
		int stt =1;
		for (DonViChiTietModel donViChiTietModel : listDonViChiTietModels) {
			if(donViChiTietModel.getTrangThai().equals("Hoat Dong")) {
				String donViCoBan = donViChiTietModel.getDonViMacDinh()+"";
				if(donViCoBan.equals("1")) {
					donViCoBan = "true";
				}
				if(donViCoBan.equals("0")) {
					donViCoBan = "false";
				}
				model.addRow(new Object[] {stt,donViChiTietModel.getMaDonViChiTiet(),donViChiTietModel.getDonViTinhModel().getTenDonVi(),donViChiTietModel.getGiaTriQuyDoi(),donViChiTietModel.getGiaBan(),donViCoBan,donViChiTietModel.getTrangThai()});
			}
		}
		table_danhSachDonViTinhActive.setModel(model);
	}
	
	public void updateTable_danhSachDonViTinhInactive(List<DonViChiTietModel> listDonViChiTietModels) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("STT");
		model.addColumn("MÃ ĐƠN VỊ");
		model.addColumn("TÊN ĐƠN VỊ");
		model.addColumn("GIÁ TRỊ QUY ĐỔI");
		model.addColumn("GIÁ BÁN");
		model.addColumn("TRẠNG THÁI");
		int stt =1;
		for (DonViChiTietModel donViChiTietModel : listDonViChiTietModels) {
			if(donViChiTietModel.getTrangThai().equals("Khong Hoat Dong")) {
				model.addRow(new Object[] {stt,donViChiTietModel.getMaDonViChiTiet(),donViChiTietModel.getDonViTinhModel().getTenDonVi(),donViChiTietModel.getGiaTriQuyDoi(),donViChiTietModel.getGiaBan(),donViChiTietModel.getTrangThai()});
			}
		}
		table_danhSachDonViTinhInactive.setModel(model);
	}
	
	public void updateTable_danhSachSanPhamVaDichVu() {
		String tenKho = cbx_kho_danhSach.getSelectedItem().toString();
		String nhomHangHoa = cbx_nhomHangHoa.getSelectedItem().toString();
		String nhomSanPham = cbx_nhomSanPham_danhSach.getSelectedItem().toString();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("MÃ DỊCH VỤ");
		model.addColumn("TÊN HÀNG HÓA");
		model.addColumn("NHÓM SP");
		model.addColumn("SỐ LƯỢNG TỒN");
		model.addColumn("GIÁ VỐN");
		model.addColumn("KHO");
		model.addColumn("TRẠNG THÁI");
		
		_listSanPhamVaDichVuModels = _sanPhamVaDichVuService.getListSanPhamVaDichVuModel();
	
			int stt =1;
			List<SanPhamVaDichVuModel> listSPVDVM = new ArrayList<SanPhamVaDichVuModel>();
			if(cbx_trangThai_danhSach.getSelectedItem().toString().equals("Hoat Dong")) {
				for (SanPhamVaDichVuModel spvdvm : _listSanPhamVaDichVuModels) {
					if(spvdvm.getTrangThai().equals("Hoat Dong") && tenKho.equals("Tất cả") && nhomHangHoa.equals("Tất cả") && nhomSanPham.equals("Tất cả")) {
						listSPVDVM.add(spvdvm);
					}
					
					if(spvdvm.getTrangThai().equals("Hoat Dong") && !tenKho.equals("Tất cả") && nhomHangHoa.equals("Tất cả") && nhomSanPham.equals("Tất cả")) {
						if(spvdvm.getKhoModel().getTenKho().equals(tenKho)) {
							listSPVDVM.add(spvdvm);
						}
					}
					
					if(spvdvm.getTrangThai().equals("Hoat Dong") && tenKho.equals("Tất cả") && !nhomHangHoa.equals("Tất cả") && nhomSanPham.equals("Tất cả")) {
						if(spvdvm.getNhomSPVaDichVuModel().getNhomHangHoa().equals(nhomHangHoa)) {
							listSPVDVM.add(spvdvm);
						}
					}
					
					if(spvdvm.getTrangThai().equals("Hoat Dong") && tenKho.equals("Tất cả") && nhomHangHoa.equals("Tất cả") && !nhomSanPham.equals("Tất cả")) {
						if(spvdvm.getNhomSPVaDichVuModel().getTenNhomSP().equals(nhomSanPham)) {
							listSPVDVM.add(spvdvm);
						}
					}
					
					if(spvdvm.getTrangThai().equals("Hoat Dong") && !tenKho.equals("Tất cả") && !nhomHangHoa.equals("Tất cả") && nhomSanPham.equals("Tất cả")) {
						if(spvdvm.getKhoModel().getTenKho().equals(tenKho)) {
							if(spvdvm.getNhomSPVaDichVuModel().getNhomHangHoa().equals(nhomHangHoa)) {
								listSPVDVM.add(spvdvm);
							}
						}
					}
					
					if(spvdvm.getTrangThai().equals("Hoat Dong") && !tenKho.equals("Tất cả") && nhomHangHoa.equals("Tất cả") && !nhomSanPham.equals("Tất cả")) {
						if(spvdvm.getKhoModel().getTenKho().equals(tenKho)) {
							if(spvdvm.getNhomSPVaDichVuModel().getTenNhomSP().equals(nhomSanPham)) {
								listSPVDVM.add(spvdvm);
							}
						}
					}
					
					if(spvdvm.getTrangThai().equals("Hoat Dong") && tenKho.equals("Tất cả") && !nhomHangHoa.equals("Tất cả") && !nhomSanPham.equals("Tất cả")) {
						if(spvdvm.getNhomSPVaDichVuModel().getNhomHangHoa().equals(nhomHangHoa)) {
							if(spvdvm.getNhomSPVaDichVuModel().getTenNhomSP().equals(nhomSanPham)) {
								listSPVDVM.add(spvdvm);
							}
						}
					}
					
					if(spvdvm.getTrangThai().equals("Hoat Dong") && !tenKho.equals("Tất cả") && !nhomHangHoa.equals("Tất cả") && !nhomSanPham.equals("Tất cả")) {
						if(spvdvm.getKhoModel().getTenKho().equals(tenKho)) {
							if(spvdvm.getNhomSPVaDichVuModel().getNhomHangHoa().equals(nhomHangHoa)) {
								if(spvdvm.getNhomSPVaDichVuModel().getTenNhomSP().equals(nhomSanPham)) {
									listSPVDVM.add(spvdvm);
								}
							}
						}
					}
				}
			}
				
			if(cbx_trangThai_danhSach.getSelectedItem().toString().equals("Khong Hoat Dong")) {
				for (SanPhamVaDichVuModel spvdvm : _listSanPhamVaDichVuModels) {
					
					if(spvdvm.getTrangThai().equals("Khong Hoat Dong") && tenKho.equals("Tất cả") && nhomHangHoa.equals("Tất cả") && nhomSanPham.equals("Tất cả")) {
						listSPVDVM.add(spvdvm);
					}
					
					if(spvdvm.getTrangThai().equals("Khong Hoat Dong") && !tenKho.equals("Tất cả") && nhomHangHoa.equals("Tất cả") && nhomSanPham.equals("Tất cả")) {
						if(spvdvm.getKhoModel().getTenKho().equals(tenKho)) {
							listSPVDVM.add(spvdvm);
						}
					}
					
					if(spvdvm.getTrangThai().equals("Khong Hoat Dong") && tenKho.equals("Tất cả") && !nhomHangHoa.equals("Tất cả") && nhomSanPham.equals("Tất cả")) {
						if(spvdvm.getNhomSPVaDichVuModel().getNhomHangHoa().equals(nhomHangHoa)) {
							listSPVDVM.add(spvdvm);
						}
					}
					
					if(spvdvm.getTrangThai().equals("Khong Hoat Dong") && tenKho.equals("Tất cả") && nhomHangHoa.equals("Tất cả") && !nhomSanPham.equals("Tất cả")) {
						if(spvdvm.getNhomSPVaDichVuModel().getTenNhomSP().equals(nhomSanPham)) {
							listSPVDVM.add(spvdvm);
						}
					}
					
					if(spvdvm.getTrangThai().equals("Khong Hoat Dong") && !tenKho.equals("Tất cả") && !nhomHangHoa.equals("Tất cả") && nhomSanPham.equals("Tất cả")) {
						if(spvdvm.getKhoModel().getTenKho().equals(tenKho)) {
							if(spvdvm.getNhomSPVaDichVuModel().getNhomHangHoa().equals(nhomHangHoa)) {
								listSPVDVM.add(spvdvm);
							}
						}
					}
					
					if(spvdvm.getTrangThai().equals("Khong Hoat Dong") && !tenKho.equals("Tất cả") && nhomHangHoa.equals("Tất cả") && !nhomSanPham.equals("Tất cả")) {
						if(spvdvm.getKhoModel().getTenKho().equals(tenKho)) {
							if(spvdvm.getNhomSPVaDichVuModel().getTenNhomSP().equals(nhomSanPham)) {
								listSPVDVM.add(spvdvm);
							}
						}
					}
					
					if(spvdvm.getTrangThai().equals("Khong Hoat Dong") && tenKho.equals("Tất cả") && !nhomHangHoa.equals("Tất cả") && !nhomSanPham.equals("Tất cả")) {
						if(spvdvm.getNhomSPVaDichVuModel().getNhomHangHoa().equals(nhomHangHoa)) {
							if(spvdvm.getNhomSPVaDichVuModel().getTenNhomSP().equals(nhomSanPham)) {
								listSPVDVM.add(spvdvm);
							}
						}
					}
					
					if(spvdvm.getTrangThai().equals("Khong Hoat Dong") && !tenKho.equals("Tất cả") && !nhomHangHoa.equals("Tất cả") && !nhomSanPham.equals("Tất cả")) {
						if(spvdvm.getKhoModel().getTenKho().equals(tenKho)) {
							if(spvdvm.getNhomSPVaDichVuModel().getNhomHangHoa().equals(nhomHangHoa)) {
								if(spvdvm.getNhomSPVaDichVuModel().getTenNhomSP().equals(nhomSanPham)) {
									listSPVDVM.add(spvdvm);
								}
							}
						}
					}
				}
			}
			
			for (SanPhamVaDichVuModel spvdvm : listSPVDVM) {
				String sapXep = cbx_sapXep.getSelectedItem().toString();
				model.addRow(new Object[] {stt, spvdvm.getMaDichVu(), spvdvm.getTenHangHoa() , spvdvm.getNhomSPVaDichVuModel().getTenNhomSP(), spvdvm.getSoLuongTon(), spvdvm.getGiaVon(), spvdvm.getKhoModel().getTenKho() , spvdvm.getTrangThai()});
			
			}
			
		table_danhSachSanPhamVaDichVu.setModel(model);
	}
	
	public void themDonViTinh() {
		DonViChiTietModel donViChiTietModel = getInforFromFormIntoDonViChiTietModel();
		if(donViChiTietModel == null) {
			return;
		}
		for (DonViChiTietModel dvctm : _listDonViChiTietModels) {
			if(dvctm.getDonViTinhModel().getMaDonVi() == donViChiTietModel.getDonViTinhModel().getMaDonVi()) {
				JOptionPane.showMessageDialog(null, "Đơn vị bạn chọn đã có trong danh sách , Vui lòng ktra lại!");
				return;
			}
		}
		if(checkDonViChiTietExsisted(donViChiTietModel)) {
			_listDonViChiTietModels.add(donViChiTietModel);
			maxID_donViChiTiet1++;
			txt_maDonVi.setText(maxID_donViChiTiet1+"");
			panel_donViTinh.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Đơn vị quy đổi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			clearFormDonViTinh();
		}
	}
	
	public boolean checkDonViChiTietExsisted(DonViChiTietModel dvctm) {
		boolean check = true;
		for (DonViChiTietModel dvctm1 : _listDonViChiTietModels) {
			if(dvctm1.getMaDonViChiTiet() == dvctm.getMaDonViChiTiet()) {
				continue;
			}
			if(dvctm1.getDonViTinhModel().getMaDonVi() == dvctm.getDonViTinhModel().getMaDonVi()) {
				JOptionPane.showMessageDialog(null, "Đơn vị bạn chọn đã có trong danh sách , Vui lòng ktra lại!");
				check = false;
			}
		}
		return check;
	}
	
	public boolean checkDonViCoBan() {
		boolean check = true;
		for (DonViChiTietModel donViChiTietModel : _listDonViChiTietModels) {
			if(donViChiTietModel.getDonViMacDinh() == 1) {
				txt_giaTriQuyDoi.setEditable(true);
				ckb_donViCoBan.setSelected(false);
				check = false;
				break;
			}
		}
		if(check) {
			panel_donViTinh.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Đơn vị cơ bản", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			txt_giaTriQuyDoi.setEditable(false);
			ckb_donViCoBan.setSelected(true);
		}
		return true;
	}
	
	public void suaDonViTinh() {
		DonViChiTietModel donViChiTietModel = getInforFromFormIntoDonViChiTietModel();
		if(donViChiTietModel == null) {
			return;
		}
	
		if(checkDonViChiTietExsisted(donViChiTietModel)) {
			for(int i =0 ; i<_listDonViChiTietModels.size() ; i++) {
				if(_listDonViChiTietModels.get(i).getMaDonViChiTiet() == donViChiTietModel.getMaDonViChiTiet()) {
					_listDonViChiTietModels.get(i).setGiaTriQuyDoi(donViChiTietModel.getGiaTriQuyDoi());
					_listDonViChiTietModels.get(i).setGiaBan(donViChiTietModel.getGiaBan());
					_listDonViChiTietModels.get(i).setTrangThai(donViChiTietModel.getTrangThai());
					break;
				}
			}
			clearFormDonViTinh();
		}
	}
	public void xoaDonViTinh() 
	{
		if(ckb_donViCoBan.isSelected()) {
			JOptionPane.showMessageDialog(null, "Không thể xóa đơn vị cơ bản của sản phẩm");
			return;
		}
		int maDonViChiTiet = Integer.parseInt(txt_maDonVi.getText().trim());
		for(int i =0 ; i<_listDonViChiTietModels.size() ; i++) {
			if(_listDonViChiTietModels.get(i).getMaDonViChiTiet() == maDonViChiTiet) {
				_listDonViChiTietModels.remove(i);
				break;
			}
		}
		clearFormDonViTinh();
		updateTable_danhSachDonViTinhInactive(_listDonViChiTietModels);
		updateTable_danhSachDonViTinhActive(_listDonViChiTietModels);
	}
	
//	public String checkSwitchButton(SwitchButton sw) {
//		String trangThai ="";
//		if(switchButton_nhapDonViTinh.isSelected()) {
//			trangThai = "Hoat Dong";
//		}else {
//			trangThai = "Khong Hoat Dong";
//		}
//		return trangThai;
//	}
	
	public DonViChiTietModel getInforFromFormIntoDonViChiTietModel() {
		SanPhamVaDichVuModel sanPhamVaDichVuModel = getInforFromFormIntoSanPhamVaDichVuModel();
		if(sanPhamVaDichVuModel == null) {
			return null;
		}
		
		int maDonViChiTiet = Integer.parseInt(txt_maDonVi.getText().trim());
		
		int indexDonViTinhSelected = cbx_donViTinh.getSelectedIndex()-1;
		if(indexDonViTinhSelected <0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn đơn vị");
			return null;
		}
		
		DonViTinhModel donViTinhModel = _listDonViTinhModels_active.get(indexDonViTinhSelected);
		int giaTriQuyDoi ;
		try {
			giaTriQuyDoi = Integer.parseInt(txt_giaTriQuyDoi.getText().trim());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "giá trị quy đổi phải là số nguyên");
			return null;
		}
		if(giaTriQuyDoi<=0) {
			JOptionPane.showMessageDialog(null, "giá trị quy đổi phải lớn hơn 0");
			return null;
		}
		
		if(Utilities.regexCheckDouble(txt_giaBan.getText().trim()+"").equals("false")) {
			JOptionPane.showMessageDialog(null, "Xin vui lòng kiểm tra lại giá bán");
			return null;
		}
		
		double giaBan = Double.parseDouble(txt_giaBan.getText().trim());
		
		if(giaBan <0) {
			JOptionPane.showMessageDialog(null, "Giá bán phải lớn hơn 0");
			return null;
		}
		
		int donViCoBan =-1;
		if(ckb_donViCoBan.isSelected()) {
			donViCoBan = 1;
		}else {
			donViCoBan = 0;
		}
		
		if(donViCoBan != 1 && giaTriQuyDoi ==1) {
			JOptionPane.showMessageDialog(null, "Chỉ đơn vị cơ bản mới có giá trị quy đổi là 1");
			return null;
		}
		
		
		String trangThai =cbx_trangThai_donVi.getSelectedItem().toString();
		
		if(donViCoBan ==1 && trangThai.equals("Khong Hoat Dong")) {
			JOptionPane.showMessageDialog(null, "Đơn vị cơ bản không được để trạng thái không hoạt động");
			return null;
		}
		
		DonViChiTietModel dvctm = new DonViChiTietModel(maDonViChiTiet, donViTinhModel, sanPhamVaDichVuModel, giaTriQuyDoi, giaBan, trangThai , donViCoBan);
		return dvctm;
	}
	
	public SanPhamVaDichVuModel getInforFromFormIntoSanPhamVaDichVuModel() {
		int maDichVu = maDichVu = Integer.parseInt(txt_maSanPham.getText());;
		String trangThai = cbx_trangThai_sanPham.getSelectedItem().toString();
		String tenHangHoa = txt_tenHangHoa.getText().trim();
		if(tenHangHoa.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập tên hàng hóa");
			return null;
		}
		
		int sttNhomSPSelected = cbx_nhomSanPham.getSelectedIndex()-1;
		
		if(sttNhomSPSelected <0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn nhóm sản phẩm");
			return null;
		}
			
		NhomSPVaDichVuModel nhomSPVaDichVuModel = _listNhomSPVaDichVuModels_active.get(sttNhomSPSelected);
		
		int sttKhoSelected = cbx_kho.getSelectedIndex()-1;
		
		if(sttKhoSelected <0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn kho chứa sản phẩm");
			return null;
		}
		
		KhoModel khoModel = _listKhoModels_active.get(sttKhoSelected);
		
		int soLuongTon = Integer.parseInt(txt_soLuongTon.getText().trim());
		double giaVon = Double.parseDouble(txt_giaVon.getText());
		String moTa = txt_moTa.getText().trim();
		
		SanPhamVaDichVuModel spvdvm= new SanPhamVaDichVuModel(maDichVu, tenHangHoa, nhomSPVaDichVuModel, soLuongTon, giaVon, khoModel, moTa, trangThai);
		return spvdvm;
	}

	public void them_suaSanPham() {
		if(_listDonViChiTietModels.size()==0) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đơn vị cho sản phẩm");
			return;
		}
		SanPhamVaDichVuModel sanPhamVaDichVuModel = getInforFromFormIntoSanPhamVaDichVuModel();
		_sanPhamVaDichVuService.them_sua(sanPhamVaDichVuModel);
		for (DonViChiTietModel donViChiTietModel : _listDonViChiTietModels) {
			_donViChiTietService.them_sua(donViChiTietModel);
		}
		updateTable_danhSachSanPhamVaDichVu();
	}
}
