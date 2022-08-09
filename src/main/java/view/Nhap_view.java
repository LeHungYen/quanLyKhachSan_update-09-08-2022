package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
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
import models.DonViChiTietModel;
import models.DonViTinhModel;
import models.NhanVienModel;
import models.NhomSPVaDichVuModel;
import models.PhieuNhapKhoChiTietModel;
import models.PhieuNhapKhoModel;
import models.SanPhamVaDichVuModel;
import services.PhieuNhapKhoChiTietService;
import services.PhieuNhapKhoService;
import services.SanPhamVaDichVuService;
import utils.IoCContainer;
import utils.Utilities;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Nhap_view extends JFrame {
	private IoCContainer _ioCContainer = new IoCContainer();
	private SanPhamVaDichVuService _sanPhamVaDichVuService = (SanPhamVaDichVuService) _ioCContainer
			.getBean(SanPhamVaDichVuService.class + "");
	private PhieuNhapKhoService _phieuNhapKhoService = (PhieuNhapKhoService) _ioCContainer
			.getBean(PhieuNhapKhoService.class + "");
	private List<PhieuNhapKhoModel> _listPhieuNhapKhoModel ;
	private PhieuNhapKhoChiTietService _phieuNhapKhoChiTietService = (PhieuNhapKhoChiTietService) _ioCContainer
			.getBean(PhieuNhapKhoChiTietService.class + "");
	private List<SanPhamVaDichVuModel> _lisSanPhamVaDichVuModels_active = new ArrayList<SanPhamVaDichVuModel>();
	private List<DonViChiTietModel> _listDonViChiTietModel_editing = new ArrayList<DonViChiTietModel>();
	private List<PhieuNhapKhoChiTietModel> _listPhieuNhapKhoChiTietModel = new ArrayList<PhieuNhapKhoChiTietModel>();
	private static NhanVienModel _userAreUsing;
	private int maxID;
	
	
	private JPanel contentPane;
	private JTextField textField;
	private JTable table_phieuNhapKho;
	private JTextField txt_maPhieuNhapKho;
	private JTextField txt_hoTenNhanVien;
	private JTextField txt_tongTienHang;
	private JTextField txt_maSanPham;
	private JTextField txt_tenSanPham;
	private JTextField txt_soLuong;
	private JTextField txt_timKiemSanPhamInserted;
	private JTextField txt_timKiemSanPham;
	private JTable table_sanPhamInserted;
	private JTable table_SanPham;
	private JTextField txt_giaNhap;
	private JTextField txt_tongCong;
	private JTextField txt_ngayGioTaoHD;
	private JTextField txt_giamGia;
	private JTextField txt_vat;
	private JTextField txt_phiShip;
	private JComboBox cbx_donViTinh;
	private JButton btn_themSP;
	private JButton btn_suaSP;
	private JButton btn_xoaSP;
	private JTextArea txt_ghiChu;
	private JButton btn_sua;
	private JButton btn_them;
	private int _index_SPInsert_Selected;
	private JComboBox cbx_trangThai;
	private JComboBox cbx_trangThai_danhSach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		_userAreUsing = new NhanVienModel("2", "2", "2", "2", "2", new ChucVuModel(1, "2", "2"), "2", "2", "2", "2", null);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Nhap_view frame = new Nhap_view(_userAreUsing);
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
	public Nhap_view(NhanVienModel userAreUsing) {
		_userAreUsing = userAreUsing;
		_phieuNhapKhoService.updateListPhieuNhapKhoModel();
		maxID = _phieuNhapKhoService.getMaxID();
		_listPhieuNhapKhoModel = _phieuNhapKhoService.getListPhieuNhapKhoModel();
		_sanPhamVaDichVuService.updateListSanPhamVaDichVuModel("Hoat Dong");
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
		panel_2_1.setBounds(10, 19, 615, 51);
		panel_3.add(panel_2_1);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(10, 18, 512, 29);
		panel_2_1.add(textField);
		((JComponent) textField).setBorder(null);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 1219, 539);
		panel_3.add(scrollPane);

		table_phieuNhapKho = new JTable();
		table_phieuNhapKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				doClickOnTablePhieuNhapKho();
			}
		});
		scrollPane.setViewportView(table_phieuNhapKho);
		
		JPanel panel_2_2_1_1_1 = new JPanel();
		panel_2_2_1_1_1.setLayout(null);
		panel_2_2_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Tr\u1EA1ng th\u00E1i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2_1_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1_1.setBounds(635, 19, 171, 51);
		panel_3.add(panel_2_2_1_1_1);
		
		cbx_trangThai_danhSach = new JComboBox();
		cbx_trangThai_danhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable_phieuNhapKho();
			}
		});
		cbx_trangThai_danhSach.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Da Thanh Toan", "Chua Thanh Toan"}));
		cbx_trangThai_danhSach.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_trangThai_danhSach.setBackground(Color.WHITE);
		cbx_trangThai_danhSach.setBounds(10, 18, 151, 28);
		panel_2_2_1_1_1.add(cbx_trangThai_danhSach);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Cập Nhật Phiếu Nhập Kho", null, panel_4, null);
		panel_4.setLayout(null);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"M\u00C3 NH\u1EACP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setBounds(10, 11, 78, 51);
		panel_4.add(panel_2_1_1);

		txt_maPhieuNhapKho = new JTextField();
		txt_maPhieuNhapKho.setEditable(false);
		txt_maPhieuNhapKho.setColumns(10);
		txt_maPhieuNhapKho.setBorder(null);
		txt_maPhieuNhapKho.setBackground(Color.WHITE);
		txt_maPhieuNhapKho.setBounds(10, 18, 58, 29);
		panel_2_1_1.add(txt_maPhieuNhapKho);

		JPanel panel_2_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"H\u1ECC T\u00CAN NH\u00C2N VI\u00CAN", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2_1_1_1_1.setBackground(Color.WHITE);
		panel_2_1_1_1_1.setBounds(268, 11, 139, 51);
		panel_4.add(panel_2_1_1_1_1);

		txt_hoTenNhanVien = new JTextField();
		txt_hoTenNhanVien.setEditable(false);
		txt_hoTenNhanVien.setColumns(10);
		txt_hoTenNhanVien.setBorder(null);
		txt_hoTenNhanVien.setBackground(Color.WHITE);
		txt_hoTenNhanVien.setBounds(10, 18, 119, 29);
		panel_2_1_1_1_1.add(txt_hoTenNhanVien);

		JPanel panel_2_1_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"T\u1ED4NG TI\u1EC0N H\u00C0NG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_1_1.setBackground(Color.WHITE);
		panel_2_1_1_1_1_1.setBounds(674, 11, 124, 51);
		panel_4.add(panel_2_1_1_1_1_1);

		txt_tongTienHang = new JTextField();
		txt_tongTienHang.setEditable(false);
		txt_tongTienHang.setColumns(10);
		txt_tongTienHang.setBorder(null);
		txt_tongTienHang.setBackground(Color.WHITE);
		txt_tongTienHang.setBounds(10, 18, 104, 29);
		panel_2_1_1_1_1_1.add(txt_tongTienHang);
		
		btn_them = new JButton("Thêm hóa đơn");
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themPhieuNhapKho();
			}
		});
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_them.setBackground(new Color(255, 204, 0));
		btn_them.setBounds(937, 13, 132, 49);
		panel_4.add(btn_them);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFormPhieuNhapKho();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.setBackground(new Color(255, 204, 0));
		btnClear.setBounds(1159, 13, 70, 49);
		panel_4.add(btnClear);

		JPanel panel_2_1_1_1_1_2 = new JPanel();
		panel_2_1_1_1_1_2.setLayout(null);
		panel_2_1_1_1_1_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"Th\u00F4ng tin s\u1EA3n ph\u1EA9m nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2_1_1_1_1_2.setBackground(new Color(204, 204, 204));
		panel_2_1_1_1_1_2.setBounds(10, 73, 1219, 180);
		panel_4.add(panel_2_1_1_1_1_2);

		JPanel panel_2_1_1_2 = new JPanel();
		panel_2_1_1_2.setLayout(null);
		panel_2_1_1_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"M\u00C3 S\u1EA2N PH\u1EA8M", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2.setBackground(Color.WHITE);
		panel_2_1_1_2.setBounds(10, 21, 132, 51);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2);

		txt_maSanPham = new JTextField();
		txt_maSanPham.setEditable(false);
		txt_maSanPham.setColumns(10);
		txt_maSanPham.setBorder(null);
		txt_maSanPham.setBackground(Color.WHITE);
		txt_maSanPham.setBounds(10, 18, 112, 29);
		panel_2_1_1_2.add(txt_maSanPham);

		JPanel panel_2_1_1_2_1 = new JPanel();
		panel_2_1_1_2_1.setLayout(null);
		panel_2_1_1_2_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"T\u00CAN S\u1EA2N PH\u1EA8M", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2_1.setBackground(Color.WHITE);
		panel_2_1_1_2_1.setBounds(152, 21, 242, 51);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2_1);

		txt_tenSanPham = new JTextField();
		txt_tenSanPham.setEditable(false);
		txt_tenSanPham.setColumns(10);
		txt_tenSanPham.setBorder(null);
		txt_tenSanPham.setBackground(Color.WHITE);
		txt_tenSanPham.setBounds(10, 18, 222, 29);
		panel_2_1_1_2_1.add(txt_tenSanPham);

		JPanel panel_2_1_1_2_2 = new JPanel();
		panel_2_1_1_2_2.setLayout(null);
		panel_2_1_1_2_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"S\u1ED0 L\u01AF\u1EE2NG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2_2.setBackground(Color.WHITE);
		panel_2_1_1_2_2.setBounds(404, 21, 132, 51);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2_2);

		txt_soLuong = new JTextField();
		txt_soLuong.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int soLuong;
				if(Utilities.regexCheckSoNguyenDuong(txt_soLuong.getText().trim()).equals("false")) {
					JOptionPane.showMessageDialog(null, "Số lượng phải là số nguyên và >=0");
					return;
				}
				soLuong = Integer.parseInt(txt_soLuong.getText().trim());
				if(Utilities.regexCheckSoNguyenDuong(txt_giaNhap.getText().trim()).equals("true")) {
					int giaNhap = Integer.parseInt(txt_giaNhap.getText().trim());
					int tongCong = giaNhap*soLuong;
					txt_tongCong.setText(tongCong+"");
				}
			}
		});
		txt_soLuong.setColumns(10);
		txt_soLuong.setBorder(null);
		txt_soLuong.setBackground(Color.WHITE);
		txt_soLuong.setBounds(10, 18, 112, 29);
		panel_2_1_1_2_2.add(txt_soLuong);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"\u0110\u01A0N V\u1ECA T\u00CDNH", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(546, 21, 159, 51);
		panel_2_1_1_1_1_2.add(panel_2_2);

		cbx_donViTinh = new JComboBox();
		cbx_donViTinh.setModel(new DefaultComboBoxModel(new String[] {"--Chọn đơn vị--"}));
		cbx_donViTinh.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_donViTinh.setBackground(Color.WHITE);
		cbx_donViTinh.setBounds(3, 18, 148, 28);
		panel_2_2.add(cbx_donViTinh);

		 btn_themSP = new JButton("Thêm");
		btn_themSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSP();
			}
		});
		btn_themSP.setBackground(new Color(255, 255, 255));
		btn_themSP.setBounds(1120, 17, 89, 31);
		panel_2_1_1_1_1_2.add(btn_themSP);

		 btn_suaSP = new JButton("Sửa");
		 btn_suaSP.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		suaPhieuNhapKhoCT();
		 	}
		 });
		btn_suaSP.setBackground(new Color(255, 255, 255));
		btn_suaSP.setBounds(1120, 59, 89, 31);
		panel_2_1_1_1_1_2.add(btn_suaSP);

		 btn_xoaSP = new JButton("Xóa");
		 btn_xoaSP.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		xoaPhieuNhapKhoCT();
		 	}
		 });
		btn_xoaSP.setBackground(new Color(255, 255, 255));
		btn_xoaSP.setBounds(1120, 101, 89, 31);
		panel_2_1_1_1_1_2.add(btn_xoaSP);

		JButton btnNewButton_1_3 = new JButton("Clear");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFormSanPham();
			}
		});
		btnNewButton_1_3.setBackground(new Color(255, 255, 255));
		btnNewButton_1_3.setBounds(1120, 143, 89, 31);
		panel_2_1_1_1_1_2.add(btnNewButton_1_3);

		JLabel lblNewLabel_1_2_1 = new JLabel("Ghi chú:");
		lblNewLabel_1_2_1.setBounds(10, 83, 185, 22);
		panel_2_1_1_1_1_2.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txt_ghiChu = new JTextArea();
		txt_ghiChu.setBounds(10, 104, 1059, 65);
		panel_2_1_1_1_1_2.add(txt_ghiChu);

		JPanel panel_2_1_1_2_2_1 = new JPanel();
		panel_2_1_1_2_2_1.setLayout(null);
		panel_2_1_1_2_2_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"GI\u00C1 NH\u1EACP/SP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2_2_1.setBackground(Color.WHITE);
		panel_2_1_1_2_2_1.setBounds(715, 21, 159, 51);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2_2_1);

		txt_giaNhap = new JTextField();
		txt_giaNhap.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int soLuong;
				if(Utilities.regexCheckSoNguyenDuong(txt_giaNhap.getText().trim()).equals("false")) {
					JOptionPane.showMessageDialog(null, "Giá nhập phải là số nguyên và >=0");
					return;
				}
				int giaNhap = Integer.parseInt(txt_giaNhap.getText().trim());
				
				if(Utilities.regexCheckSoNguyenDuong(txt_soLuong.getText().trim()).equals("true")) {
					soLuong = Integer.parseInt(txt_soLuong.getText().trim());
					int tongCong = giaNhap*soLuong;
					txt_tongCong.setText(tongCong+"");
				}
			}
		});
		txt_giaNhap.setColumns(10);
		txt_giaNhap.setBorder(null);
		txt_giaNhap.setBackground(Color.WHITE);
		txt_giaNhap.setBounds(10, 18, 139, 29);
		panel_2_1_1_2_2_1.add(txt_giaNhap);

		JPanel panel_2_1_1_2_2_2 = new JPanel();
		panel_2_1_1_2_2_2.setLayout(null);
		panel_2_1_1_2_2_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"T\u1ED4NG C\u1ED8NG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2_2_2.setBackground(Color.WHITE);
		panel_2_1_1_2_2_2.setBounds(884, 21, 185, 51);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2_2_2);

		txt_tongCong = new JTextField();
		txt_tongCong.setEditable(false);
		txt_tongCong.setColumns(10);
		txt_tongCong.setBorder(null);
		txt_tongCong.setBackground(Color.WHITE);
		txt_tongCong.setBounds(10, 18, 165, 29);
		panel_2_1_1_2_2_2.add(txt_tongCong);

		JPanel panel_2_1_1_3 = new JPanel();
		panel_2_1_1_3.setLayout(null);
		panel_2_1_1_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"Danh s\u00E1ch s\u1EA3n ph\u1EA9m nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2_1_1_3.setBackground(new Color(204, 204, 204));
		panel_2_1_1_3.setBounds(10, 264, 599, 356);
		panel_4.add(panel_2_1_1_3);

		JPanel panel_2_1_1_4 = new JPanel();
		panel_2_1_1_4.setLayout(null);
		panel_2_1_1_4.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_4.setBackground(Color.WHITE);
		panel_2_1_1_4.setBounds(10, 22, 579, 51);
		panel_2_1_1_3.add(panel_2_1_1_4);

		txt_timKiemSanPhamInserted = new JTextField();
		txt_timKiemSanPhamInserted.setColumns(10);
		txt_timKiemSanPhamInserted.setBorder(null);
		txt_timKiemSanPhamInserted.setBackground(Color.WHITE);
		txt_timKiemSanPhamInserted.setBounds(10, 18, 559, 29);
		panel_2_1_1_4.add(txt_timKiemSanPhamInserted);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 84, 579, 261);
		panel_2_1_1_3.add(scrollPane_1);

		table_sanPhamInserted = new JTable();
		table_sanPhamInserted.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				doClickOnTable_SanPham_inserted();
			}
		});
		scrollPane_1.setViewportView(table_sanPhamInserted);

		JPanel panel_2_1_1_3_1 = new JPanel();
		panel_2_1_1_3_1.setLayout(null);
		panel_2_1_1_3_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_3_1.setBackground(new Color(204, 204, 204));
		panel_2_1_1_3_1.setBounds(630, 264, 599, 356);
		panel_4.add(panel_2_1_1_3_1);

		JPanel panel_2_1_1_4_1 = new JPanel();
		panel_2_1_1_4_1.setLayout(null);
		panel_2_1_1_4_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_4_1.setBackground(Color.WHITE);
		panel_2_1_1_4_1.setBounds(10, 22, 579, 51);
		panel_2_1_1_3_1.add(panel_2_1_1_4_1);

		txt_timKiemSanPham = new JTextField();
		txt_timKiemSanPham.setColumns(10);
		txt_timKiemSanPham.setBorder(null);
		txt_timKiemSanPham.setBackground(Color.WHITE);
		txt_timKiemSanPham.setBounds(10, 18, 559, 29);
		panel_2_1_1_4_1.add(txt_timKiemSanPham);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 84, 579, 261);
		panel_2_1_1_3_1.add(scrollPane_1_1);

		table_SanPham = new JTable();
		table_SanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				doClickOnTable_SanPham();
			}
		});
		scrollPane_1_1.setViewportView(table_SanPham);
		
		JPanel panel_2_1_1_1_1_3 = new JPanel();
		panel_2_1_1_1_1_3.setLayout(null);
		panel_2_1_1_1_1_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "NG\u00C0Y GI\u1EDC T\u1EA0O HD NH\u1EACP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_1_3.setBackground(Color.WHITE);
		panel_2_1_1_1_1_3.setBounds(98, 11, 160, 51);
		panel_4.add(panel_2_1_1_1_1_3);
		
		txt_ngayGioTaoHD = new JTextField();
		txt_ngayGioTaoHD.setEditable(false);
		txt_ngayGioTaoHD.setColumns(10);
		txt_ngayGioTaoHD.setBorder(null);
		txt_ngayGioTaoHD.setBackground(Color.WHITE);
		txt_ngayGioTaoHD.setBounds(10, 18, 140, 29);
		panel_2_1_1_1_1_3.add(txt_ngayGioTaoHD);
		
		JPanel panel_2_1_1_1_1_4 = new JPanel();
		panel_2_1_1_1_1_4.setLayout(null);
		panel_2_1_1_1_1_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "GI\u1EA2M GI\u00C1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_1_4.setBackground(Color.WHITE);
		panel_2_1_1_1_1_4.setBounds(417, 10, 72, 51);
		panel_4.add(panel_2_1_1_1_1_4);
		
		txt_giamGia = new JTextField();
		txt_giamGia.setText("0");
		txt_giamGia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Utilities.setTextFocusGained(txt_giamGia, "0");
			}
			@Override
			public void focusLost(FocusEvent e) {
				Utilities.setTextFocusLost(txt_giamGia, "0");
				tongTienHang();
			}
		});
		txt_giamGia.setColumns(10);
		txt_giamGia.setBorder(null);
		txt_giamGia.setBackground(Color.WHITE);
		txt_giamGia.setBounds(10, 18, 52, 29);
		panel_2_1_1_1_1_4.add(txt_giamGia);
		
		JPanel panel_2_1_1_1_1_4_1 = new JPanel();
		panel_2_1_1_1_1_4_1.setLayout(null);
		panel_2_1_1_1_1_4_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "VAT", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_1_4_1.setBackground(Color.WHITE);
		panel_2_1_1_1_1_4_1.setBounds(499, 11, 60, 51);
		panel_4.add(panel_2_1_1_1_1_4_1);
		
		txt_vat = new JTextField();
		txt_vat.setText("0");
		txt_vat.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Utilities.setTextFocusGained(txt_vat, "0");
			}
			@Override
			public void focusLost(FocusEvent e) {
				Utilities.setTextFocusLost(txt_vat, "0");
				tongTienHang();
			}
		});
		txt_vat.setColumns(10);
		txt_vat.setBorder(null);
		txt_vat.setBackground(Color.WHITE);
		txt_vat.setBounds(10, 18, 40, 29);
		panel_2_1_1_1_1_4_1.add(txt_vat);
		
		JPanel panel_2_1_1_1_1_4_1_1 = new JPanel();
		panel_2_1_1_1_1_4_1_1.setLayout(null);
		panel_2_1_1_1_1_4_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "PH\u00CD SHIP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_1_4_1_1.setBackground(Color.WHITE);
		panel_2_1_1_1_1_4_1_1.setBounds(569, 11, 95, 51);
		panel_4.add(panel_2_1_1_1_1_4_1_1);
		
		txt_phiShip = new JTextField();
		txt_phiShip.setText("0");
		txt_phiShip.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Utilities.setTextFocusGained(txt_phiShip, "0");
			}
			@Override
			public void focusLost(FocusEvent e) {
				Utilities.setTextFocusLost(txt_phiShip, "0");
				tongTienHang();
			}
		});
		txt_phiShip.setColumns(10);
		txt_phiShip.setBorder(null);
		txt_phiShip.setBackground(Color.WHITE);
		txt_phiShip.setBounds(10, 18, 75, 29);
		panel_2_1_1_1_1_4_1_1.add(txt_phiShip);
		
		btn_sua = new JButton("Sửa");
		btn_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_sua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_sua.setBackground(new Color(255, 204, 0));
		btn_sua.setBounds(1079, 13, 70, 49);
		panel_4.add(btn_sua);
		updateTable_SanPham();
		getCurrentDateTime();
		updateTable_phieuNhapKho();
		updateTxt_maNhapKho();
		txt_hoTenNhanVien.setText(_userAreUsing.getTenNV());
		
		JPanel panel_2_2_1_1 = new JPanel();
		panel_2_2_1_1.setLayout(null);
		panel_2_2_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Tr\u1EA1ng th\u00E1i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1.setBounds(808, 11, 119, 51);
		panel_4.add(panel_2_2_1_1);
		
		cbx_trangThai = new JComboBox();
		cbx_trangThai.setModel(new DefaultComboBoxModel(new String[] {"Trạng thái", "Da Thanh Toan", "Chua Thanh Toan"}));
		cbx_trangThai.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_trangThai.setBackground(Color.WHITE);
		cbx_trangThai.setBounds(10, 18, 99, 28);
		panel_2_2_1_1.add(cbx_trangThai);
	}

	public void updateTable_SanPham() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("MÃ SẢN PHẨM");
		model.addColumn("TÊN SẢN PHẨM");
		model.addColumn("NHÓM SẢN PHẨM");
		model.addColumn("TRẠNG THÁI");
		int stt = 1;
		_lisSanPhamVaDichVuModels_active = _sanPhamVaDichVuService.getListSanPhamVaDichVuModel_active();
		for (SanPhamVaDichVuModel sanPhamVaDichVuModel : _lisSanPhamVaDichVuModels_active) {
			model.addRow(new Object[] { stt, sanPhamVaDichVuModel.getMaDichVu(), sanPhamVaDichVuModel.getTenHangHoa(),
					sanPhamVaDichVuModel.getNhomSPVaDichVuModel().getTenNhomSP(),
					sanPhamVaDichVuModel.getTrangThai() });
			stt++;
		}

		table_SanPham.setModel(model);
	}
	
	public void updateTable_phieuNhapKho() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("STT");
		model.addColumn("NGÀY TẠO");
		model.addColumn("MÃ PHIẾU");
		model.addColumn("TỔNG TIỀN HÀNG");
		model.addColumn("TRẠNG THÁI");
		model.addColumn("MÃ NV TẠO");
		_listPhieuNhapKhoModel = _phieuNhapKhoService.getListPhieuNhapKhoModel();
		int stt = 1;
		
//		String ngayTaoHoaDon = 
		if(cbx_trangThai_danhSach.getSelectedItem().toString().equals("Tất cả")) {
				for (PhieuNhapKhoModel pnkm : _listPhieuNhapKhoModel) {
					double tongTienHang = tongTienHang(pnkm);
					model.addRow(new Object[] {stt,pnkm.getNgayNhap(),pnkm.getMaNhap(),tongTienHang, pnkm.getTinhTrang() , pnkm.getNhanVienModel().getMaNV()});
					stt++;
			}
		}
		if(cbx_trangThai_danhSach.getSelectedItem().toString().equals("Da Thanh Toan")) {
			for (PhieuNhapKhoModel pnkm : _listPhieuNhapKhoModel) {
				if(pnkm.getTinhTrang().equals("Da Thanh Toan")) {
					double tongTienHang = tongTienHang(pnkm);
					model.addRow(new Object[] {stt,pnkm.getNgayNhap(),pnkm.getMaNhap(),tongTienHang, pnkm.getTinhTrang() , pnkm.getNhanVienModel().getMaNV()});
					stt++;
				}
			}
		}
		
		if(cbx_trangThai_danhSach.getSelectedItem().toString().equals("Chua Thanh Toan")) {
			for (PhieuNhapKhoModel pnkm : _listPhieuNhapKhoModel) {
				if(pnkm.getTinhTrang().equals("Chua Thanh Toan")) {
					double tongTienHang = tongTienHang(pnkm);
					model.addRow(new Object[] {stt,pnkm.getNgayNhap(),pnkm.getMaNhap(),tongTienHang, pnkm.getTinhTrang() , pnkm.getNhanVienModel().getMaNV()});
					stt++;
				}
			}
		}
		
		table_phieuNhapKho.setModel(model);
	}
	
	public double tongTienHang(PhieuNhapKhoModel pnkm) {
		double tongTienHang = 0;
		for (PhieuNhapKhoChiTietModel pnkctm : _listPhieuNhapKhoChiTietModel) {
			double tongCong = tongCong(pnkctm);
			tongTienHang +=tongCong;
		}
		double giamGia = (pnkm.getGiamGia()/100)*tongTienHang;
		double vat = (pnkm.getVat()/100)*tongTienHang;
		tongTienHang = tongTienHang + vat - giamGia + pnkm.getPhiShip();
		return tongTienHang;
	}
	public void tongTienHang() {
		if(Utilities.regexCheckDouble(txt_giamGia.getText().trim()).equals("false")) {
			JOptionPane.showMessageDialog(null, "Bạn đã nhập sai % giảm giá");
			return;
		}
		if(Utilities.regexCheckDouble(txt_vat.getText().trim()).equals("false")) {
			JOptionPane.showMessageDialog(null, "Bạn đã nhập sai % vat");
			return;
		}
		if(Utilities.regexCheckSoNguyenDuong(txt_phiShip.getText().trim()).equals("false")) {
			JOptionPane.showMessageDialog(null, "Phí ship phải là số nguyên dương");
			return;
		}
		double tongTienHang = 0;
		for (PhieuNhapKhoChiTietModel pnkctm : _listPhieuNhapKhoChiTietModel) {
			double tongCong = tongCong(pnkctm);
			tongTienHang +=tongCong;
		}
		double percentDiscount = Double.parseDouble(txt_giamGia.getText().trim());
		double percentVat = Double.parseDouble(txt_vat.getText().trim());
		int phiShip = Integer.parseInt(txt_phiShip.getText().trim());
		double giamGia = (percentDiscount/100)*tongTienHang;
		double vat = (percentVat/100)*tongTienHang;
		tongTienHang = tongTienHang + vat - giamGia + phiShip;
		txt_tongTienHang.setText(tongTienHang+"");
	}
	
	public void updateTxt_maNhapKho() {
		txt_maPhieuNhapKho.setText(maxID+"");
	}
	
	public void updateTable_sanPhamInserted() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("STT");
		model.addColumn("MÃ SP");
		model.addColumn("TÊN SP");
		model.addColumn("S.LG");
		model.addColumn("ĐƠN VỊ TÍNH");
		model.addColumn("GIÁ NHẬP/SP");
		model.addColumn("TỔNG CỘNG");
//		model.addColumn("GIÁ VỐN/SP");
		
		int stt =1;
		
		for (PhieuNhapKhoChiTietModel pnkct : _listPhieuNhapKhoChiTietModel) {
			double tongCong = tongCong(pnkct);
			model.addRow(new Object[] {stt,pnkct.getDonViChiTietModel().getSanPhamVaDichVuModel().getMaDichVu(), pnkct.getDonViChiTietModel().getSanPhamVaDichVuModel().getTenHangHoa(),pnkct.getSoLuong(),pnkct.getDonViChiTietModel().getDonViTinhModel().getTenDonVi(),pnkct.getGiaNhap(),tongCong});
			stt++;
		}
		table_sanPhamInserted.setModel(model);
	}
	
	public void giaVon1SP () {
		
	}
	
	public double tongCong(PhieuNhapKhoChiTietModel pnkctm) {
		int soLuong = pnkctm.getSoLuong();
		double giaNhap1sp = pnkctm.getGiaNhap();
		double tongCong = giaNhap1sp*soLuong; 
		return tongCong;
	}
	
	public void doClickOnTablePhieuNhapKho() {
		int maPhieu = Integer.parseInt(table_phieuNhapKho.getModel().getValueAt(table_phieuNhapKho.getSelectedRow(), 2)+"");
		for (PhieuNhapKhoModel pnkm : _listPhieuNhapKhoModel) {
			if(pnkm.getMaNhap() == maPhieu) {
				txt_maPhieuNhapKho.setText(maPhieu+"");
				txt_ngayGioTaoHD.setText(pnkm.getNgayNhap());
				txt_hoTenNhanVien.setText(pnkm.getNhanVienModel().getTenNV());
				txt_giamGia.setText(pnkm.getGiamGia()+"");
				txt_vat.setText(pnkm.getVat()+"");
				txt_phiShip.setText(pnkm.getPhiShip()+"");
//				if(pnkm.getTinhTrang().equals("Da Thanh Toan")) {
//					switchButton_nhap.setSelected(true);
//				}else {
//					switchButton_nhap.setSelected(false);
//				}
				cbx_trangThai.setSelectedItem(pnkm.getTinhTrang());
				_listPhieuNhapKhoChiTietModel = _phieuNhapKhoService.getListPNKCTM(pnkm);
				updateTable_sanPhamInserted();
				txt_tongTienHang.setText(tongTienHang(pnkm)+"");
				break;
			}
		}
		txt_giamGia.setEditable(false);
		txt_vat.setEditable(false);
		txt_phiShip.setEditable(false);
		btn_them.setEnabled(false);
		btn_sua.setEnabled(true);
		btn_themSP.setEnabled(false);
		btn_suaSP.setEnabled(false);
		btn_xoaSP.setEnabled(false);
	}
	
	public void doClickOnTable_SanPham_inserted() {
		_index_SPInsert_Selected = Integer.parseInt(table_sanPhamInserted.getModel().getValueAt(table_sanPhamInserted.getSelectedRow(), 0)+"")-1;
		PhieuNhapKhoChiTietModel pnkctm = _listPhieuNhapKhoChiTietModel.get(_index_SPInsert_Selected);
		txt_maSanPham.setText(pnkctm.getDonViChiTietModel().getSanPhamVaDichVuModel().getMaDichVu()+"");
		txt_tenSanPham.setText(pnkctm.getDonViChiTietModel().getSanPhamVaDichVuModel().getTenHangHoa());
		txt_soLuong.setText(pnkctm.getSoLuong()+"");
		cbx_donViTinh.setModel(new DefaultComboBoxModel(new String[] {pnkctm.getDonViChiTietModel().getDonViTinhModel().getTenDonVi()}));
		txt_giaNhap.setText(pnkctm.getGiaNhap()+"");
		txt_tongCong.setText(tongCong(pnkctm)+"");
		if(btn_them.isEnabled()) {
			btn_themSP.setEnabled(false);
			btn_suaSP.setEnabled(true);
			btn_xoaSP.setEnabled(true);
		}
	}
	
	public void doClickOnTable_SanPham() {
		int stt = Integer.parseInt(table_SanPham.getModel().getValueAt(table_SanPham.getSelectedRow(), 0)+"")-1;
		txt_maSanPham.setText(_lisSanPhamVaDichVuModels_active.get(stt).getMaDichVu()+"");
		txt_tenSanPham.setText(_lisSanPhamVaDichVuModels_active.get(stt).getTenHangHoa());
		List<DonViChiTietModel> listViChiTietModels = _sanPhamVaDichVuService.getListDVCTM(_lisSanPhamVaDichVuModels_active.get(stt)); 
		_listDonViChiTietModel_editing = new ArrayList<DonViChiTietModel>();
		for (DonViChiTietModel donViChiTietModel : listViChiTietModels) {
			System.out.println(donViChiTietModel.toString());
			if(donViChiTietModel.getTrangThai().equals("Hoat Dong")) {
				
				_listDonViChiTietModel_editing.add(donViChiTietModel);
			}
		}
		updateCbx_donViTinh(_listDonViChiTietModel_editing);
		if(btn_them.isEnabled()) {
			btn_themSP.setEnabled(true);
			btn_suaSP.setEnabled(false);
			btn_xoaSP.setEnabled(false);
		}
	}
	
	public void updateCbx_donViTinh(List<DonViChiTietModel> listDonViChiTietModel) {
		String arrayDonViTinh[] = new String[listDonViChiTietModel.size()+1];
		arrayDonViTinh[0] = "--Chọn đơn vị tính--";
		int index =1;
		for (DonViChiTietModel donViChiTietModel : listDonViChiTietModel) {
			arrayDonViTinh[index] = donViChiTietModel.getDonViTinhModel().getTenDonVi();
			index++;
		}
		cbx_donViTinh.setModel(new DefaultComboBoxModel(arrayDonViTinh));
	}

	public void clearFormPhieuNhapKho() {
		_listPhieuNhapKhoChiTietModel = new ArrayList<PhieuNhapKhoChiTietModel>();
		updateTable_sanPhamInserted();
		txt_maPhieuNhapKho.setText("");
		txt_ngayGioTaoHD.setText("");
		txt_hoTenNhanVien.setText(_userAreUsing.getTenNV());
		txt_giamGia.setText("0");
		txt_vat.setText("0");
		txt_phiShip.setText("0");
		txt_tongTienHang.setText("0");
//		switchButton_nhap.setSelected(true);
		cbx_trangThai.setSelectedIndex(0);
		clearFormSanPham();
		_listPhieuNhapKhoChiTietModel = new ArrayList<PhieuNhapKhoChiTietModel>();
		table_sanPhamInserted = new JTable();
		getCurrentDateTime();
		updateTxt_maNhapKho();
		btn_sua.setEnabled(false);
		btn_them.setEnabled(true);
		txt_giamGia.setEditable(true);
		txt_vat.setEditable(true);
		txt_phiShip.setEditable(true);
		//
		btn_themSP.setEnabled(true);
	}
	
	public void clearFormSanPham() {
		txt_maSanPham.setText("");
		txt_tenSanPham.setText("");
		txt_soLuong.setText("");
		cbx_donViTinh.setModel(new DefaultComboBoxModel(new String[] {"--Chọn đơn vị--"}));
		txt_giaNhap.setText("");
		txt_tongCong.setText("");
		txt_ghiChu.setText("");
		if(!btn_themSP.isEnabled() && !btn_suaSP.isEnabled() && !btn_xoaSP.isEnabled()) {
		}else {
			btn_suaSP.setEnabled(false);
			btn_xoaSP.setEnabled(false);
			btn_themSP.setEnabled(false);
		}
	}
	
	public void getCurrentDateTime() {
		Date date = new Date(System.currentTimeMillis());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd     HH:mm:ss");
		txt_ngayGioTaoHD.setText(dateFormat.format(date));
	}
	
	public PhieuNhapKhoModel formToPhieuNhapKhoModel() {
		int maPhieuNhapKho = Integer.parseInt(txt_maPhieuNhapKho.getText().trim());
		String ngayNhap = txt_ngayGioTaoHD.getText().trim();
		String tinhTrang = cbx_trangThai.getSelectedItem().toString();
		if(tinhTrang.equals("Trạng thái")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn trạng thái");
			return null;
		}
		
		if(Utilities.regexCheckDouble(txt_giamGia.getText().trim()).equals("false")) {
			JOptionPane.showMessageDialog(null, "% giảm giá phải là số và không được < 0");
			return null;
		}
		
		double giamGia = Double.parseDouble(txt_giamGia.getText().trim());
		
		if(giamGia<0) {
			JOptionPane.showMessageDialog(null, "% giảm giá phải là số và không được < 0");
			return null;
		}
		
		if(Utilities.regexCheckDouble(txt_vat.getText().trim()).equals("false")) {
			JOptionPane.showMessageDialog(null, "% vat phải là số và không được < 0");
			return null;
		}
		
		double vat = Double.parseDouble(txt_vat.getText().trim());
		
		if(vat<0) {
			JOptionPane.showMessageDialog(null, "% vat phải là số và không được < 0");
			return null;
		}
		
		if(Utilities.regexCheckDouble(txt_phiShip.getText().trim()).equals("false")) {
			JOptionPane.showMessageDialog(null, "tiền ship phải là số và không được < 0");
			return null;
		}
		
		double phiShip = Double.parseDouble(txt_phiShip.getText().trim());
		
		if(phiShip<0) {
			JOptionPane.showMessageDialog(null, "tiền ship phải là số và không được < 0");
			return null;
		}
		
		_userAreUsing = new NhanVienModel("2", tinhTrang, tinhTrang, tinhTrang, tinhTrang, new ChucVuModel(1, ngayNhap, tinhTrang), tinhTrang, tinhTrang, ngayNhap, tinhTrang, null);
		PhieuNhapKhoModel phieuNhapKhoModel = new PhieuNhapKhoModel(maPhieuNhapKho, ngayNhap, tinhTrang, _userAreUsing, giamGia, vat, phiShip);
		return phieuNhapKhoModel;
	}
	
	public PhieuNhapKhoChiTietModel formToPhieuNhapKhoChiTietModel() {
		PhieuNhapKhoModel phieuNhapKhoModel = formToPhieuNhapKhoModel();
		if(phieuNhapKhoModel == null) {
			return null;
		}
		
		
		if(Utilities.regexCheckSoNguyenDuong(txt_soLuong.getText().trim()).equals("false")) {
			JOptionPane.showMessageDialog(null, "Số lượng phải là số nguyên và >=0");
			return null;
		}
		
		int soLuong = Integer.parseInt(txt_soLuong.getText().trim());
		
		if(Utilities.regexCheckSoNguyenDuong(txt_giaNhap.getText().trim()).equals("false")) {
			JOptionPane.showMessageDialog(null, "Giá nhập phải là số và không được < 0");
			return null;
		}
		
		double giaNhap = Double.parseDouble(txt_giaNhap.getText().trim());
		
		if(giaNhap<0) {
			JOptionPane.showMessageDialog(null, "Giá nhập phải là số và không được < 0");
			return null;
		}
		
		String ghiChu = txt_ghiChu.getText().trim();
		int indexDVCTM = cbx_donViTinh.getSelectedIndex()-1;
		DonViChiTietModel dvctmd =_listDonViChiTietModel_editing.get(indexDVCTM);
		PhieuNhapKhoChiTietModel pnkctm = new PhieuNhapKhoChiTietModel(phieuNhapKhoModel, dvctmd, soLuong, giaNhap, ghiChu);
		return pnkctm;
	}
	public void themSP() {
		PhieuNhapKhoChiTietModel pnkctm = formToPhieuNhapKhoChiTietModel();
		if(pnkctm == null) {
			return;
		}
		_listPhieuNhapKhoChiTietModel.add(pnkctm);
		updateTable_sanPhamInserted();
		clearFormSanPham();
		tongTienHang();
	}
	
	public void suaPhieuNhapKhoCT() {
		int soLuong = Integer.parseInt(txt_soLuong.getText().trim());
		double giaNhap = Double.parseDouble(txt_giaNhap.getText().trim());
		String ghiChu = txt_ghiChu.getText().trim();
		_listPhieuNhapKhoChiTietModel.get(_index_SPInsert_Selected).setSoLuong(soLuong);
		_listPhieuNhapKhoChiTietModel.get(_index_SPInsert_Selected).setGiaNhap(soLuong);
		_listPhieuNhapKhoChiTietModel.get(_index_SPInsert_Selected).setGhiChu(ghiChu);
		clearFormSanPham();
		updateTable_sanPhamInserted();
	}
	public void xoaPhieuNhapKhoCT() {
		_listPhieuNhapKhoChiTietModel.remove(_index_SPInsert_Selected);
		clearFormSanPham();
		updateTable_sanPhamInserted();
	}
	public void themPhieuNhapKho() {
		PhieuNhapKhoModel pnkm = formToPhieuNhapKhoModel();
		if(pnkm == null) {
			return;
		}
		_phieuNhapKhoService.them_sua(pnkm);
		for (PhieuNhapKhoChiTietModel pnkctm : _listPhieuNhapKhoChiTietModel) {
			_phieuNhapKhoChiTietService.them_sua(pnkctm);
			DonViChiTietModel dvctm = pnkctm.getDonViChiTietModel();
			int giaTriQuyDoi = dvctm.getGiaTriQuyDoi();
			int soLuongNhap = pnkctm.getSoLuong();
			double giaNhap = pnkctm.getGiaNhap();
			int quyDoiSoLuongNhap = soLuongNhap*giaTriQuyDoi;
			
			double tongGiaTriKhoHienTai = (giaNhap/giaTriQuyDoi) * quyDoiSoLuongNhap;
			
			SanPhamVaDichVuModel spvdvm = dvctm.getSanPhamVaDichVuModel();
			int soLuongTon = spvdvm.getSoLuongTon();
			double giaVon = spvdvm.getGiaVon();
			
			double tongGiaTriKhoBanDau = giaVon*soLuongTon;
			
			soLuongTon = soLuongTon + quyDoiSoLuongNhap;
			
			double giaVonSauKhiNhap = (tongGiaTriKhoBanDau+tongGiaTriKhoHienTai)/soLuongTon;
			
			spvdvm.setSoLuongTon(soLuongTon);
			spvdvm.setGiaVon(giaVonSauKhiNhap);
			System.out.println(giaVonSauKhiNhap);
			SanPhamVaDichVuService spvdvs = new SanPhamVaDichVuService();
			spvdvs.them_sua(spvdvm);
			for (int i=0 ;i< _listPhieuNhapKhoChiTietModel.size() ; i++) {
				if(_listPhieuNhapKhoChiTietModel.get(i).getDonViChiTietModel().getSanPhamVaDichVuModel().getMaDichVu() ==  spvdvm.getMaDichVu()) {
					_listPhieuNhapKhoChiTietModel.get(i).getDonViChiTietModel().setSanPhamVaDichVuModel(spvdvm);
				}
			}
		}
		maxID++;
		clearFormPhieuNhapKho();
		updateTable_phieuNhapKho();
	}
}

