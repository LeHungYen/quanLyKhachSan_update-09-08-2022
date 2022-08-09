package view;

import java.awt.BorderLayout;
import java.awt.Color;
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
import models.KhoModel;
import models.NhanVienModel;
import models.NhomSPVaDichVuModel;
import models.PhieuKiemKhoChiTietModel;
import models.PhieuKiemKhoModel;
import models.PhieuNhapKhoModel;
import models.SanPhamVaDichVuModel;
import services.DonViChiTietService;
import services.DonViTinhService;
import services.KhoService;
import services.NhomSPVaDichVuService;
import services.PhieuKiemKhoChiTietService;
import services.PhieuKiemKhoService;
import services.PhieuNhapKhoChiTietService;
import services.PhieuNhapKhoService;
import services.SanPhamVaDichVuService;
import utils.IoCContainer;
import utils.Utilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JSpinner;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class KiemKho_view extends JFrame {
	private IoCContainer _ioCContainer = new IoCContainer();
	private SanPhamVaDichVuService _sanPhamVaDichVuService = (SanPhamVaDichVuService) _ioCContainer
			.getBean(SanPhamVaDichVuService.class + "");
	private static NhanVienModel _userAreUsing;
	private PhieuKiemKhoService _phieuKiemKhoService = (PhieuKiemKhoService) _ioCContainer
			.getBean(PhieuKiemKhoService.class + "");
	private List<PhieuKiemKhoModel> _listPhieuKiemKhoModels = new ArrayList<PhieuKiemKhoModel>();
	private PhieuKiemKhoChiTietService _phieuKiemKhoChiTietService = (PhieuKiemKhoChiTietService) _ioCContainer
			.getBean(PhieuKiemKhoChiTietService.class + "");
	private List<PhieuKiemKhoChiTietModel> _listPhieuKiemKhoChiTietModels = new ArrayList<PhieuKiemKhoChiTietModel>();
	private List<DonViChiTietModel> _listDonViChiTietModels = new ArrayList<DonViChiTietModel>();
	private List<SanPhamVaDichVuModel> _listSanPhamVaDichVuModels = new ArrayList<SanPhamVaDichVuModel>();
	private KhoService _khoService = (KhoService) _ioCContainer.getBean(KhoService.class + "");
	private List<KhoModel> _listKhoModels_active = new ArrayList<KhoModel>();

	private JPanel contentPane;
	private JTable table_sanPham;
	private JTextField textField_8;
	private JTable table_danhSachSPKK;
	private JTextField textField_7;
	private JTextField txt_soLuongCL;
	private JTextField txt_soLuongTK;
	private JTextField txt_tenSp;
	private JTextField txt_maSp;
	private JTextField txt_ghiChu;
	private JTextField txt_hoTenNhanVien;
	private JTextField txt_maKiemKho;
	private JTable table_PKK;
	private JTextField txtTmKimTheo;
	private JTextField txtTmKimTheo_1;
	private JTextField txt_soLuongTT;
	private JTextField txt_thoiGian;
	private JTextField txt_soLuongTheoDV;
	private JComboBox cbx_kho;
	private JComboBox cbx_donVi;
	private SanPhamVaDichVuModel _spvdvm_selected;
	private JTextArea txt_ghiChuDieuChinh;
	private JButton btn_luu;
	private JButton btn_themPKKCT;
	private JButton btn_suaPKKCT;
	private JButton btn_xoaPKKCT;
	private JButton btn_themSoLuong;
	private int _index_PKKCT_Selected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		_userAreUsing = new NhanVienModel("2", "2", "2", "2", "2", new ChucVuModel(1, "2", "2"), "2", "2", "2", "2", null);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KiemKho_view frame = new KiemKho_view(_userAreUsing);
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
	public KiemKho_view(NhanVienModel userAreUsing) {
		_khoService.updateListKhoModel("Hoat Dong");
		_phieuKiemKhoService.updateListPhieuKiemKhoModel();
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
		panel_2_1.setBounds(274, 19, 490, 51);
		panel_3.add(panel_2_1);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"T\u00ECm ki\u1EBFm theo h\u00E0ng h\u00F3a", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));

		txtTmKimTheo = new JTextField();
		txtTmKimTheo.setText("tìm kiếm theo hàng hóa hoặc mã hàng hóa");
		txtTmKimTheo.setBackground(Color.WHITE);
		txtTmKimTheo.setBounds(10, 18, 435, 29);
		panel_2_1.add(txtTmKimTheo);
		((JComponent) txtTmKimTheo).setBorder(null);
		txtTmKimTheo.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 1219, 539);
		panel_3.add(scrollPane);

		table_PKK = new JTable();
		table_PKK.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				doClickOnTablePKK();
			}
		});
		scrollPane.setViewportView(table_PKK);

		JPanel panel_2_1_1_1_2 = new JPanel();
		panel_2_1_1_1_2.setLayout(null);
		panel_2_1_1_1_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"Th\u1EDDi gian", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_2.setBackground(Color.WHITE);
		panel_2_1_1_1_2.setBounds(10, 19, 254, 51);
		panel_3.add(panel_2_1_1_1_2);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(10, 20, 234, 20);
		panel_2_1_1_1_2.add(dateChooser_1);

		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"t\u00ECm ki\u1EBFm theo m\u00E3 phi\u1EBFu", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2_1_2.setBackground(Color.WHITE);
		panel_2_1_2.setBounds(774, 19, 455, 51);
		panel_3.add(panel_2_1_2);

		txtTmKimTheo_1 = new JTextField();
		txtTmKimTheo_1.setText("Tìm kiếm theo mã kiểm kho");
		txtTmKimTheo_1.setColumns(10);
		txtTmKimTheo_1.setBorder(null);
		txtTmKimTheo_1.setBackground(Color.WHITE);
		txtTmKimTheo_1.setBounds(10, 18, 435, 29);
		panel_2_1_2.add(txtTmKimTheo_1);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Cập Nhật Nhóm Sản Phẩm", null, panel_4, null);
		panel_4.setLayout(null);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"M\u00C3 KI\u1EC2M KHO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setBounds(10, 11, 94, 51);
		panel_4.add(panel_2_1_1);

		txt_maKiemKho = new JTextField();
		txt_maKiemKho.setEditable(false);
		txt_maKiemKho.setColumns(10);
		txt_maKiemKho.setBorder(null);
		txt_maKiemKho.setBackground(Color.WHITE);
		txt_maKiemKho.setBounds(10, 18, 74, 29);
		panel_2_1_1.add(txt_maKiemKho);

		JPanel panel_2_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"H\u1ECC T\u00CAN NH\u00C2N VI\u00CAN", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2_1_1_1_1.setBackground(Color.WHITE);
		panel_2_1_1_1_1.setBounds(300, 11, 155, 51);
		panel_4.add(panel_2_1_1_1_1);

		txt_hoTenNhanVien = new JTextField();
		txt_hoTenNhanVien.setEditable(false);
		txt_hoTenNhanVien.setColumns(10);
		txt_hoTenNhanVien.setBorder(null);
		txt_hoTenNhanVien.setBackground(Color.WHITE);
		txt_hoTenNhanVien.setBounds(10, 18, 135, 29);
		panel_2_1_1_1_1.add(txt_hoTenNhanVien);

		JPanel panel_2_1_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"GHI CH\u00DA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_1_1.setBackground(Color.WHITE);
		panel_2_1_1_1_1_1.setBounds(613, 11, 318, 51);
		panel_4.add(panel_2_1_1_1_1_1);

		txt_ghiChu = new JTextField();
		txt_ghiChu.setColumns(10);
		txt_ghiChu.setBorder(null);
		txt_ghiChu.setBackground(Color.WHITE);
		txt_ghiChu.setBounds(10, 18, 298, 29);
		panel_2_1_1_1_1_1.add(txt_ghiChu);

		btn_luu = new JButton("Lưu");
		btn_luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themPKK();
			}
		});
		btn_luu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_luu.setBackground(new Color(255, 204, 0));
		btn_luu.setBounds(941, 13, 139, 49);
		panel_4.add(btn_luu);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFormPNK();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBackground(new Color(255, 204, 0));
		btnClear.setBounds(1090, 13, 139, 49);
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

		txt_maSp = new JTextField();
		txt_maSp.setEditable(false);
		txt_maSp.setColumns(10);
		txt_maSp.setBorder(null);
		txt_maSp.setBackground(Color.WHITE);
		txt_maSp.setBounds(10, 18, 112, 29);
		panel_2_1_1_2.add(txt_maSp);

		JPanel panel_2_1_1_2_1 = new JPanel();
		panel_2_1_1_2_1.setLayout(null);
		panel_2_1_1_2_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"T\u00CAN S\u1EA2N PH\u1EA8M", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2_1.setBackground(Color.WHITE);
		panel_2_1_1_2_1.setBounds(152, 21, 242, 51);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2_1);

		txt_tenSp = new JTextField();
		txt_tenSp.setEditable(false);
		txt_tenSp.setColumns(10);
		txt_tenSp.setBorder(null);
		txt_tenSp.setBackground(Color.WHITE);
		txt_tenSp.setBounds(10, 18, 222, 29);
		panel_2_1_1_2_1.add(txt_tenSp);

		JPanel panel_2_1_1_2_2 = new JPanel();
		panel_2_1_1_2_2.setLayout(null);
		panel_2_1_1_2_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"S.LG TR\u01AF\u1EDAC KI\u1EC2M", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2_2.setBackground(Color.WHITE);
		panel_2_1_1_2_2.setBounds(404, 21, 132, 51);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2_2);

		txt_soLuongTK = new JTextField();
		txt_soLuongTK.setEditable(false);
		txt_soLuongTK.setColumns(10);
		txt_soLuongTK.setBorder(null);
		txt_soLuongTK.setBackground(Color.WHITE);
		txt_soLuongTK.setBounds(10, 18, 112, 29);
		panel_2_1_1_2_2.add(txt_soLuongTK);

		btn_themPKKCT = new JButton("Thêm");
		btn_themPKKCT.setEnabled(false);
		btn_themPKKCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themPKKCT();
			}
		});
		btn_themPKKCT.setBackground(new Color(255, 255, 255));
		btn_themPKKCT.setBounds(1120, 17, 89, 31);
		panel_2_1_1_1_1_2.add(btn_themPKKCT);

		btn_suaPKKCT = new JButton("Sửa");
		btn_suaPKKCT.setEnabled(false);
		btn_suaPKKCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaPKKCT();
			}
		});
		btn_suaPKKCT.setBackground(new Color(255, 255, 255));
		btn_suaPKKCT.setBounds(1120, 59, 89, 31);
		panel_2_1_1_1_1_2.add(btn_suaPKKCT);

		btn_xoaPKKCT = new JButton("Xóa");
		btn_xoaPKKCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaPKKCT();
			}
		});
		btn_xoaPKKCT.setEnabled(false);
		btn_xoaPKKCT.setBackground(new Color(255, 255, 255));
		btn_xoaPKKCT.setBounds(1120, 101, 89, 31);
		panel_2_1_1_1_1_2.add(btn_xoaPKKCT);

		JButton btnNewButton_1_3 = new JButton("Clear");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFormTTSP();
			}
		});
		btnNewButton_1_3.setBackground(new Color(255, 255, 255));
		btnNewButton_1_3.setBounds(1120, 143, 89, 31);
		panel_2_1_1_1_1_2.add(btnNewButton_1_3);

		JLabel lblNewLabel_1_2_1 = new JLabel("GHI CHÚ ĐIỀU CHỈNH:");
		lblNewLabel_1_2_1.setBounds(10, 83, 185, 22);
		panel_2_1_1_1_1_2.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));

		txt_ghiChuDieuChinh = new JTextArea();
		txt_ghiChuDieuChinh.setBounds(10, 104, 526, 65);
		panel_2_1_1_1_1_2.add(txt_ghiChuDieuChinh);

		JPanel panel_2_1_1_2_2_1 = new JPanel();
		panel_2_1_1_2_2_1.setLayout(null);
		panel_2_1_1_2_2_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"S.LG CH\u00CANH L\u1EC6CH", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2_2_1.setBackground(Color.WHITE);
		panel_2_1_1_2_2_1.setBounds(914, 21, 143, 51);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2_2_1);

		txt_soLuongCL = new JTextField();
		txt_soLuongCL.setForeground(Color.ORANGE);
		txt_soLuongCL.setText("0");
		txt_soLuongCL.setEditable(false);
		txt_soLuongCL.setColumns(10);
		txt_soLuongCL.setBorder(null);
		txt_soLuongCL.setBackground(Color.WHITE);
		txt_soLuongCL.setBounds(10, 18, 123, 29);
		panel_2_1_1_2_2_1.add(txt_soLuongCL);

		JPanel panel_2_1_1_2_2_3 = new JPanel();
		panel_2_1_1_2_2_3.setLayout(null);
		panel_2_1_1_2_2_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"S.LG TH\u1EF0C T\u1EBE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2_2_3.setBackground(Color.WHITE);
		panel_2_1_1_2_2_3.setBounds(772, 21, 132, 51);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2_2_3);

		txt_soLuongTT = new JTextField();
		txt_soLuongTT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Utilities.setTextFocusGained(txt_soLuongTT, "0");
			}
			@Override
			public void focusLost(FocusEvent e) {
				Utilities.setTextFocusLost(txt_soLuongTT, "0");
			}
		});
		txt_soLuongTT.setText("0");
		txt_soLuongTT.setEditable(false);
		txt_soLuongTT.setColumns(10);
		txt_soLuongTT.setBorder(null);
		txt_soLuongTT.setBackground(Color.WHITE);
		txt_soLuongTT.setBounds(10, 18, 112, 29);
		panel_2_1_1_2_2_3.add(txt_soLuongTT);

		JPanel panel_2_1_1_2_2_3_1 = new JPanel();
		panel_2_1_1_2_2_3_1.setLayout(null);
		panel_2_1_1_2_2_3_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"S.LG THEO \u0110\u01A0N V\u1ECA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2_2_3_1.setBackground(Color.WHITE);
		panel_2_1_1_2_2_3_1.setBounds(551, 21, 211, 148);
		panel_2_1_1_1_1_2.add(panel_2_1_1_2_2_3_1);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(10, 21, 191, 51);
		panel_2_1_1_2_2_3_1.add(panel_2_2);
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"\u0110\u01A0N V\u1ECA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2.setBackground(Color.WHITE);

		cbx_donVi = new JComboBox();
		cbx_donVi.setModel(new DefaultComboBoxModel(new String[] {"--Chọn đơn vị--"}));
		cbx_donVi.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_donVi.setBackground(Color.WHITE);
		cbx_donVi.setBounds(10, 18, 171, 28);
		panel_2_2.add(cbx_donVi);

		JPanel panel_2_1_1_2_2_2 = new JPanel();
		panel_2_1_1_2_2_2.setLayout(null);
		panel_2_1_1_2_2_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"S\u1ED0 L\u01AF\u1EE2NG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_2_2_2.setBackground(Color.WHITE);
		panel_2_1_1_2_2_2.setBounds(10, 83, 112, 51);
		panel_2_1_1_2_2_3_1.add(panel_2_1_1_2_2_2);

		txt_soLuongTheoDV = new JTextField();
		txt_soLuongTheoDV.setText("0");
		txt_soLuongTheoDV.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Utilities.setTextFocusGained(txt_soLuongTheoDV, "0");
			}
			@Override
			public void focusLost(FocusEvent e) {
				Utilities.setTextFocusLost(txt_soLuongTheoDV, "0");
			}
		});
		txt_soLuongTheoDV.setColumns(10);
		txt_soLuongTheoDV.setBorder(null);
		txt_soLuongTheoDV.setBackground(Color.WHITE);
		txt_soLuongTheoDV.setBounds(10, 18, 92, 29);
		panel_2_1_1_2_2_2.add(txt_soLuongTheoDV);

		btn_themSoLuong = new JButton("Thêm");
		btn_themSoLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSLGTheoDV();
			}
		});
		btn_themSoLuong.setBackground(Color.WHITE);
		btn_themSoLuong.setBounds(132, 103, 69, 31);
		panel_2_1_1_2_2_3_1.add(btn_themSoLuong);

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

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBackground(Color.WHITE);
		textField_7.setBounds(10, 18, 559, 29);
		panel_2_1_1_4.add(textField_7);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 84, 579, 261);
		panel_2_1_1_3.add(scrollPane_1);

		table_danhSachSPKK = new JTable();
		table_danhSachSPKK.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				doClickOnTable_danhSachSPKK();
			}
		});
		scrollPane_1.setViewportView(table_danhSachSPKK);

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

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBorder(null);
		textField_8.setBackground(Color.WHITE);
		textField_8.setBounds(10, 18, 559, 29);
		panel_2_1_1_4_1.add(textField_8);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 84, 579, 261);
		panel_2_1_1_3_1.add(scrollPane_1_1);

		table_sanPham = new JTable();
		table_sanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				doClickOnTableSP();
			}
		});
		scrollPane_1_1.setViewportView(table_sanPham);

		JPanel panel_2_1_1_1_1_3 = new JPanel();
		panel_2_1_1_1_1_3.setLayout(null);
		panel_2_1_1_1_1_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)),
				"TH\u1EDCI GIAN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1_1_1_1_3.setBackground(Color.WHITE);
		panel_2_1_1_1_1_3.setBounds(114, 11, 176, 51);
		panel_4.add(panel_2_1_1_1_1_3);

		txt_thoiGian = new JTextField();
		txt_thoiGian.setEditable(false);
		txt_thoiGian.setColumns(10);
		txt_thoiGian.setBorder(null);
		txt_thoiGian.setBackground(Color.WHITE);
		txt_thoiGian.setBounds(10, 18, 156, 29);
		panel_2_1_1_1_1_3.add(txt_thoiGian);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "KHO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2_1.setBackground(Color.WHITE);
		panel_2_2_1.setBounds(465, 11, 138, 51);
		panel_4.add(panel_2_2_1);
		
		cbx_kho = new JComboBox();
		cbx_kho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable_SanPham();
			}
		});
		cbx_kho.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_kho.setBackground(Color.WHITE);
		cbx_kho.setBounds(10, 18, 118, 28);
		panel_2_2_1.add(cbx_kho);
		updateCbx_kho();
		getCurrentDateTime();
		getMaKK();
		txt_hoTenNhanVien.setText(_userAreUsing.getTenNV());
		updateTable_PKK();
	}
	
	public void updateCbx_kho() {
		_listKhoModels_active = _khoService.getListKhoModel_active();
		String arrayKho[] = new String[_listKhoModels_active.size()+1];
		arrayKho[0] = "--Chọn kho--";
		int index =1;
		for (KhoModel khoModel : _listKhoModels_active) {
			arrayKho[index] = khoModel.getTenKho();
			index++;
		}
		cbx_kho.setModel(new DefaultComboBoxModel(arrayKho));
	}
	
	public void getMaKK() {
		txt_maKiemKho.setText(_phieuKiemKhoService.getMaxID()+"");
	}

	public void updateTable_SanPham() {
		int index = cbx_kho.getSelectedIndex()-1;
		KhoModel khoModel = _listKhoModels_active.get(index);
		_listSanPhamVaDichVuModels = _khoService.getListSPVDVM(khoModel);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("MÃ SẢN PHẨM");
		model.addColumn("TÊN SẢN PHẨM");
		model.addColumn("NHÓM SẢN PHẨM");
		model.addColumn("TRẠNG THÁI");
		int stt = 1;
		for (SanPhamVaDichVuModel sanPhamVaDichVuModel : _listSanPhamVaDichVuModels) {
			model.addRow(new Object[] { stt, sanPhamVaDichVuModel.getMaDichVu(), sanPhamVaDichVuModel.getTenHangHoa(),
					sanPhamVaDichVuModel.getNhomSPVaDichVuModel().getTenNhomSP(),
					sanPhamVaDichVuModel.getTrangThai() });
			stt++;
		}

		table_sanPham.setModel(model);
	}
	
	public void updateTable_PKK() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("STT");
		model.addColumn("MÃ KIỂM KHO");
		model.addColumn("THỜI GIAN");
		model.addColumn("NHÂN VIÊN");
		model.addColumn("KHO");
		model.addColumn("GHI CHÚ");
		int stt =1;
		_listPhieuKiemKhoModels = _phieuKiemKhoService.getListPhieuKiemKhoModel();
		for (PhieuKiemKhoModel pkkm : _listPhieuKiemKhoModels) {
			model.addRow(new Object[] {stt,pkkm.getMaKiemKho(),pkkm.getNgayKiemKho(), pkkm.getNhanVienModel().getTenNV() , pkkm.getKhoModel().getTenKho(), pkkm.getGhiChu()});
			stt++;
		}
		table_PKK.setModel(model);
	}
	
	public void updateTable_danhSachSPKK() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("STT");
		model.addColumn("MÃ SP");
		model.addColumn("TÊN SP");
		model.addColumn("S.LG TRƯỚC KIỂM");
		model.addColumn("S.LG THỰC TẾ");
		model.addColumn("S.LG CHÊNH LỆCH");
		int stt =1;
		for (PhieuKiemKhoChiTietModel pkkctm : _listPhieuKiemKhoChiTietModels) {
			model.addRow(new Object[] {stt,pkkctm.getSanPhamVaDichVuModel().getMaDichVu(), pkkctm.getSanPhamVaDichVuModel().getTenHangHoa(), pkkctm.getSoLuongTruocKhiKiem(), pkkctm.getSoLuongThucTe() , pkkctm.getSoLuongChenhLech()});
			stt++;
		}
		table_danhSachSPKK.setModel(model);
	}
	
	public void doClickOnTablePKK() {
		int index = Integer.parseInt(table_PKK.getModel().getValueAt(table_PKK.getSelectedRow(), 0)+"")-1;
		PhieuKiemKhoModel pkkm = _listPhieuKiemKhoModels.get(index);
		txt_maKiemKho.setText(pkkm.getMaKiemKho()+"");
		txt_thoiGian.setText(pkkm.getNgayKiemKho());
		txt_hoTenNhanVien.setText(pkkm.getNhanVienModel().getTenNV());
		String tenKho = pkkm.getKhoModel().getTenKho();
		cbx_kho.setModel(new DefaultComboBoxModel(new String[] {tenKho}));
		txt_ghiChu.setText(pkkm.getGhiChu());
		_listPhieuKiemKhoChiTietModels =_phieuKiemKhoService.getListPKKCTM(pkkm);
		updateTable_danhSachSPKK();
		cbx_kho.setEnabled(false);
		txt_ghiChu.setEditable(false);
		btn_luu.setEnabled(false);
		btn_themPKKCT.setEnabled(false);
		btn_suaPKKCT.setEnabled(false);
		btn_xoaPKKCT.setEnabled(false);
		btn_themSoLuong.setEnabled(false);
	}
	
	public void doClickOnTableSP() {
		int index = Integer.parseInt(table_sanPham.getModel().getValueAt(table_sanPham.getSelectedRow(), 0)+"")-1;
		_spvdvm_selected = _listSanPhamVaDichVuModels.get(index);
		_listDonViChiTietModels = _khoService.getListDVCTM(_spvdvm_selected);
		updateCbx_donViTinh(_listDonViChiTietModels);
		txt_maSp.setText(_spvdvm_selected.getMaDichVu()+"");
		txt_tenSp.setText(_spvdvm_selected.getTenHangHoa());
		txt_soLuongTK.setText(_spvdvm_selected.getSoLuongTon()+"");
		if(btn_luu.isEnabled()) {
			btn_themPKKCT.setEnabled(true);
		}
	}
	
	public void doClickOnTable_danhSachSPKK() {
		_index_PKKCT_Selected = Integer.parseInt(table_danhSachSPKK.getModel().getValueAt(table_danhSachSPKK.getSelectedRow(), 0)+"")-1;
		 PhieuKiemKhoChiTietModel pkkctm = _listPhieuKiemKhoChiTietModels.get(_index_PKKCT_Selected);
		txt_maSp.setText(pkkctm.getSanPhamVaDichVuModel().getMaDichVu()+"");
		txt_tenSp.setText(pkkctm.getSanPhamVaDichVuModel().getTenHangHoa());
		txt_soLuongTK.setText(pkkctm.getSoLuongTruocKhiKiem()+"");
		txt_soLuongTT.setText(pkkctm.getSoLuongThucTe()+"");
		txt_soLuongCL.setText(pkkctm.getSoLuongChenhLech()+"");
		setColorSLgChenhLech(pkkctm.getSoLuongChenhLech());
		_listDonViChiTietModels = _khoService.getListDVCTM(pkkctm.getSanPhamVaDichVuModel());
		updateCbx_donViTinh(_listDonViChiTietModels);
		if(btn_luu.isEnabled()) {
			btn_themPKKCT.setEnabled(false);
			btn_suaPKKCT.setEnabled(true);
			btn_xoaPKKCT.setEnabled(true);
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
		
		cbx_donVi.setModel(new DefaultComboBoxModel(arrayDonViTinh));
	}
	
	public void themSLGTheoDV() {
		int index = cbx_donVi.getSelectedIndex()-1;
		if(index <0) {
			JOptionPane.showMessageDialog(null, "Xin vui lòng chọn đơn vị");
			return;
		}
		int giaTriQuyDoi = _listDonViChiTietModels.get(index).getGiaTriQuyDoi();
		int soLuong = Integer.parseInt(txt_soLuongTheoDV.getText().trim());
		if(soLuong <0) {
			JOptionPane.showMessageDialog(null, "Số lượng phải >=0");
			return;
		}
		int soLuongTTTDV = giaTriQuyDoi*soLuong;
		int soLuongTT = Integer.parseInt(txt_soLuongTT.getText().trim());
		soLuongTT += soLuongTTTDV;
		txt_soLuongTT.setText(soLuongTT+"");
		int soLuongTK = Integer.parseInt(txt_soLuongTK.getText().trim());
		int soLuongCL = soLuongTT-soLuongTK;
		txt_soLuongCL.setText(soLuongCL+"");
		setColorSLgChenhLech(soLuongCL);
	}
	
	public void setColorSLgChenhLech(int soLuongCL) {
		if(soLuongCL<0) {
			txt_soLuongCL.setForeground(Color.red);
		}else if(soLuongCL>0) {
			txt_soLuongCL.setForeground(Color.green);
		}else {
			txt_soLuongCL.setForeground(Color.ORANGE);
		}
	}
	
	public PhieuKiemKhoModel formToPKKM() {
		int maKK = Integer.parseInt(txt_maKiemKho.getText().trim());
		String ngayKiemKho = txt_thoiGian.getText().trim();
		int index = cbx_kho.getSelectedIndex()-1;
		KhoModel khoModel = _listKhoModels_active.get(index);
		String ghiChu = txt_ghiChu.getText().trim();
		PhieuKiemKhoModel pkkm = new PhieuKiemKhoModel(maKK, ngayKiemKho, _userAreUsing, khoModel, ghiChu);
		return pkkm;
	}
	
	public PhieuKiemKhoChiTietModel formToPKKCTM () {
		PhieuKiemKhoModel pkkm = formToPKKM();
		cbx_kho.setEnabled(false);
		int soLuongTK = Integer.parseInt(txt_soLuongTK.getText().trim());
		int soLuongTT = Integer.parseInt(txt_soLuongTT.getText().trim());
		int soLuongCL = Integer.parseInt(txt_soLuongCL.getText().trim());
		String ghiChuDC = txt_ghiChuDieuChinh.getText().trim();
		PhieuKiemKhoChiTietModel pkkctm = new PhieuKiemKhoChiTietModel(pkkm, _spvdvm_selected, soLuongTK, soLuongTT, soLuongCL, ghiChuDC);
		return pkkctm;
	}
	
	public void themPKKCT() {
		PhieuKiemKhoChiTietModel pkkctm = formToPKKCTM();
		_listPhieuKiemKhoChiTietModels.add(pkkctm);
		clearFormTTSP();
		updateTable_danhSachSPKK();
	}
	public void suaPKKCT() {
		PhieuKiemKhoChiTietModel pkkctm = formToPKKCTM();
		_listPhieuKiemKhoChiTietModels.get(_index_PKKCT_Selected).setSoLuongTruocKhiKiem(pkkctm.getSoLuongTruocKhiKiem());
		_listPhieuKiemKhoChiTietModels.get(_index_PKKCT_Selected).setSoLuongThucTe(pkkctm.getSoLuongThucTe());
		_listPhieuKiemKhoChiTietModels.get(_index_PKKCT_Selected).setSoLuongChenhLech(pkkctm.getSoLuongChenhLech());
		clearFormTTSP();
		updateTable_danhSachSPKK();
	}
	public void xoaPKKCT() {
		_listPhieuKiemKhoChiTietModels.remove(_index_PKKCT_Selected);
		clearFormTTSP();
		updateTable_danhSachSPKK();
	}
	
	public void clearFormTTSP() {
		txt_maSp.setText("");
		txt_tenSp.setText("");
		txt_soLuongTK.setText("0");
		txt_soLuongTT.setText("0");
		txt_soLuongCL.setText("0");
		cbx_donVi.setModel(new DefaultComboBoxModel(new String[] {"--Chọn đơn vị--"}));
		txt_soLuongTheoDV.setText("0");
		btn_themPKKCT.setEnabled(false);
		btn_suaPKKCT.setEnabled(false);
		btn_xoaPKKCT.setEnabled(false);
	}
	
	public void getCurrentDateTime() {
		Date date = new Date(System.currentTimeMillis());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd     HH:mm:ss");
		txt_thoiGian.setText(dateFormat.format(date));
	}
	
	public void clearFormPNK() {
		getCurrentDateTime();
//		cbx_kho.setSelectedIndex(0);
		txt_ghiChu.setText("");
		clearFormTTSP();
		_listPhieuKiemKhoChiTietModels = new ArrayList<PhieuKiemKhoChiTietModel>();
		
		DefaultTableModel model = new DefaultTableModel();
		table_sanPham.setModel(model);
		
		updateCbx_kho();
		getMaKK();
		txt_ghiChu.setEditable(true);
		btn_luu.setEnabled(true);
		btn_suaPKKCT.setEnabled(false);
		btn_themPKKCT.setEnabled(false);
		btn_xoaPKKCT.setEnabled(false);
		btn_themSoLuong.setEnabled(true);
		updateTable_danhSachSPKK();
		cbx_kho.setEnabled(true);
	}
	
	
	public void themPKK() {
		PhieuKiemKhoModel pkkm = formToPKKM();
		_phieuKiemKhoService.them_sua(pkkm);
		for (PhieuKiemKhoChiTietModel pkkctm : _listPhieuKiemKhoChiTietModels) {
			_phieuKiemKhoChiTietService.them_sua(pkkctm);
			 pkkctm.getSanPhamVaDichVuModel().setSoLuongTon(pkkctm.getSoLuongThucTe());
			_sanPhamVaDichVuService.them_sua(pkkctm.getSanPhamVaDichVuModel());
		}
		clearFormPNK();
		updateTable_PKK();
	}
}
