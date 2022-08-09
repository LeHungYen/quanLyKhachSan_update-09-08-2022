package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.ChucVuModel;
import models.NhanVienModel;
import services.NhanVienService;
import utils.IoCContainer;
import utils.Utilities;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;

public class MainMenu extends JFrame {

	private IoCContainer _ioCContainer  = new IoCContainer();
	private NhanVienService _nhanVienService = (NhanVienService) _ioCContainer.getBean(NhanVienService.class+"");
	private NhanVienModel _userAreUsing;
	private JPanel contentPane;
	private JPanel panel_tong;
	private JTextField txt_maNhanVien;
	private JTextField txt_tenNhanVien;
	private JTextField txt_soDienThoai;
	private JTextField txt_email;
	private JTextField txt_cmnd;
	private JTextField txt_matKhau;
	private JTextField txt_taiKhoan;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdb_nam;
	private JRadioButton rdb_nu;
	private JDateChooser dateChooser_ngaySinh;
	private JPasswordField txt_matKhauCu;
	private JTextField txt_matKhauMoi;
	private JPasswordField txt_xacNhanMatKhauMoi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu(NhanVienModel nhanVienModel) {
		_userAreUsing = nhanVienModel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 834);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_tong = new JPanel();
		panel_tong.setBounds(60, 72, 1280, 720);
		contentPane.add(panel_tong);
		panel_tong.setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 11, 1159, 50);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Tài Khoản");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Thông tin tài khoản");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quanLyTaiKhoan(_userAreUsing);
			}
		});
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Đổi mật khẩu");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiMatKhau();
			}
		});
		mntmNewMenuItem_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.add(mntmNewMenuItem_1_1);
		
		JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("Đăng xuất");
		mntmNewMenuItem_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.add(mntmNewMenuItem_1_1_1);
		
		JMenu mnNewMenu_1 = new JMenu("Khách Sạn");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("Thuê Phòng");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Nhân Viên");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Quản lý nhân viên");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien_view nvv = new NhanVien_view();
				nvv.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("New menu item");
		mnNewMenu_3.add(mntmNewMenuItem_2_1);
		
		JMenu mnNewMenu_3_2 = new JMenu("Khách Hàng");
		menuBar.add(mnNewMenu_3_2);
		
		JMenu mnNewMenu_3_3 = new JMenu("Loại Phòng");
		menuBar.add(mnNewMenu_3_3);
		
		JMenu mnNewMenu_3_4 = new JMenu("Sản Phẩm Và Dịch Vụ");
		menuBar.add(mnNewMenu_3_4);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Quản lý sản phẩm và dịch vụ");
		mnNewMenu_3_4.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_3_1 = new JMenuItem("Quản lý nhóm sản phẩm");
		mnNewMenu_3_4.add(mntmNewMenuItem_3_1);
		
		JMenuItem mntmNewMenuItem_3_1_1 = new JMenuItem("Quản lý đơn vị tính");
		mnNewMenu_3_4.add(mntmNewMenuItem_3_1_1);
		
		JMenu mnNewMenu_4 = new JMenu("Quản lý kho");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_4_1_1 = new JMenuItem("Quản lý kho");
		mnNewMenu_4.add(mntmNewMenuItem_4_1_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Thêm phiếu nhập hàng");
		mnNewMenu_4.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_4_1 = new JMenuItem("Thêm phiếu kiểm kho");
		mnNewMenu_4.add(mntmNewMenuItem_4_1);
		
		JMenu mnNewMenu_3_4_1 = new JMenu("Thống Kê");
		menuBar.add(mnNewMenu_3_4_1);
		
		JMenu menu = new JMenu("New menu");
		menu.setBounds(172, 11, 115, 26);
		contentPane.add(menu);

		
	}
	
	public void quanLyTaiKhoan(NhanVienModel nhanVienModel) {
		panel_tong.removeAll();
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 1280, 720);
		panel_tong.add(contentPane_1);
		
		JLabel lblThngTinTi = new JLabel("Thông tin tài khoản");
		lblThngTinTi.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinTi.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblThngTinTi.setBounds(10, 11, 1254, 64);
		contentPane_1.add(lblThngTinTi);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 100, 1259, 609);
		contentPane_1.add(panel);
		
		JLabel lblNewLabel = new JLabel("Giới tính");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 210, 109, 41);
		panel.add(lblNewLabel);
		
		txt_maNhanVien = new JTextField();
		txt_maNhanVien.setText(nhanVienModel.getMaNV());
		txt_maNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_maNhanVien.setEditable(false);
		txt_maNhanVien.setColumns(10);
		txt_maNhanVien.setBounds(129, 38, 344, 41);
		panel.add(txt_maNhanVien);
		
		txt_tenNhanVien = new JTextField();
		txt_tenNhanVien.setText(nhanVienModel.getTenNV());
		txt_tenNhanVien.setColumns(10);
		txt_tenNhanVien.setBounds(129, 99, 344, 41);
		panel.add(txt_tenNhanVien);
		
		txt_soDienThoai = new JTextField();
		txt_soDienThoai.setText(nhanVienModel.getSdt());
		txt_soDienThoai.setColumns(10);
		txt_soDienThoai.setBounds(129, 162, 344, 41);
		panel.add(txt_soDienThoai);
		
		txt_email = new JTextField();
		txt_email.setText(nhanVienModel.getEmail());
		txt_email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_email.setColumns(10);
		txt_email.setBounds(129, 258, 344, 41);
		panel.add(txt_email);
		
		String gioiTinh = nhanVienModel.getGioiTinh();
		rdb_nam = new JRadioButton("Nam");
		buttonGroup.add(rdb_nam);
		rdb_nam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdb_nam.setBounds(129, 210, 74, 41);
		panel.add(rdb_nam);
		
		rdb_nu = new JRadioButton("Nu");
		buttonGroup.add(rdb_nu);
		rdb_nu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdb_nu.setBounds(205, 212, 94, 41);
		panel.add(rdb_nu);
		
		if(gioiTinh.equals("Nam")) {
			rdb_nam.setSelected(true);
		}else {
			rdb_nu.setSelected(true);
		}
		
		String chucVu = nhanVienModel.getChucVuModel().getTenChucVu();
		
		JComboBox cbx_chucVu = new JComboBox();
		cbx_chucVu.setModel(new DefaultComboBoxModel(new String[] {chucVu}));
		cbx_chucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbx_chucVu.setBackground(Color.WHITE);
		cbx_chucVu.setBounds(129, 321, 344, 41);
		panel.add(cbx_chucVu);
		
		txt_cmnd = new JTextField();
		txt_cmnd.setText(nhanVienModel.getCmnd());
		txt_cmnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_cmnd.setColumns(10);
		txt_cmnd.setBounds(730, 97, 344, 41);
		panel.add(txt_cmnd);
		
		dateChooser_ngaySinh = new JDateChooser();
		dateChooser_ngaySinh.setBounds(730, 38, 344, 41);
		panel.add(dateChooser_ngaySinh);
		
		Date date = new Date(Utilities.splitYear(nhanVienModel.getNgaySinh()+"")-1900, Utilities.splitMonth(nhanVienModel.getNgaySinh()+"")-1, Utilities.splitDate(nhanVienModel.getNgaySinh()+""));
		dateChooser_ngaySinh.setDate(date);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(10, 258, 109, 41);
		panel.add(lblEmail);
		
		JButton btnQuayLi = new JButton("Quay Lại");
		btnQuayLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_tong.removeAll();
				revalidate();
				repaint();
			}
		});
		btnQuayLi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnQuayLi.setBackground(Color.WHITE);
		btnQuayLi.setBounds(1073, 482, 153, 47);
		panel.add(btnQuayLi);
		
		JButton btn_sua = new JButton("Sửa");
		btn_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenNhanVien = txt_tenNhanVien.getText().trim();
				
				if(tenNhanVien.equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập họ tên");
					return;
				}
				
				if(Utilities.regexCheckFullName(tenNhanVien).equals("false")) {
					JOptionPane.showMessageDialog(contentPane, "họ tên bạn nhập không hợp lệ");
					return;
				}
				
				String soDienThoai = txt_soDienThoai.getText().trim();
				if(soDienThoai.equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập sdt");
					return;
				}
				
				if(Utilities.regexCheckPhoneNumber(soDienThoai).equals("false")) {
					JOptionPane.showMessageDialog(contentPane, "sdt bạn nhập không hợp lệ");
					return;
				}
				
				String gioiTinh = "";
				Enumeration<AbstractButton> button  = buttonGroup.getElements();
				while (button.hasMoreElements()) {
					AbstractButton abstractButton = (AbstractButton) button.nextElement();
					if(abstractButton.isSelected()) {
						gioiTinh= abstractButton.getActionCommand();
						break;
					}
				}
				
				if(gioiTinh.equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Xin vui lòng chọn giới tính");
					return;
				}
				
				String email = txt_email.getText().trim();
				
				if(email.equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập email");
					return;
				}
				
				if(Utilities.regexCheckGmail(email).equals("false")) {
					JOptionPane.showMessageDialog(contentPane, "email bạn nhập không hợp lệ");
					return;
				}
				
				
				String ngaySinh ="";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					ngaySinh = simpleDateFormat.format(dateChooser_ngaySinh.getDate());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập ngày sinh");
					return;
				}
				Date date = new Date(Utilities.splitYear(ngaySinh)-1900, Utilities.splitMonth(ngaySinh)-1, Utilities.splitDate(ngaySinh));
				String cmnd = txt_cmnd.getText().trim();
				
				if(cmnd.equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập cmnd");
					return;
				}
				
				if(Utilities.regexCheckIdentityCardNumber(cmnd).equals("false")) {
					JOptionPane.showMessageDialog(contentPane, "Cmnd bạn nhập không hợp lệ");
					return;
				}
				
				String taiKhoan = txt_taiKhoan.getText().trim();
				_userAreUsing.setTenNV(tenNhanVien);
				_userAreUsing.setSdt(soDienThoai);
				_userAreUsing.setGioiTinh(gioiTinh);
				_userAreUsing.setEmail(email);
				_userAreUsing.setCmnd(cmnd);
				_userAreUsing.setUserName(taiKhoan);
				_userAreUsing.setNgaySinh(date);
				_nhanVienService.them_sua(_userAreUsing);
				JOptionPane.showMessageDialog(null, "Sửa thành công");
				panel_tong.removeAll();
				revalidate();
				repaint();
			}
		});
		btn_sua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_sua.setBackground(Color.WHITE);
		btn_sua.setBounds(910, 482, 153, 47);
		panel.add(btn_sua);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên");
		lblMNhnVin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMNhnVin.setBounds(10, 38, 109, 41);
		panel.add(lblMNhnVin);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
		lblTnNhnVin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnNhnVin.setBounds(10, 99, 109, 41);
		panel.add(lblTnNhnVin);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinThoi.setBounds(10, 162, 109, 41);
		panel.add(lblSinThoi);
		
		JLabel lblChcV = new JLabel("Chức vụ");
		lblChcV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChcV.setBounds(10, 321, 109, 41);
		panel.add(lblChcV);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgySinh.setBounds(611, 38, 109, 41);
		panel.add(lblNgySinh);
		
		JLabel lblCmnd = new JLabel("Cmnd");
		lblCmnd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCmnd.setBounds(611, 97, 109, 41);
		panel.add(lblCmnd);
		
		txt_matKhau = new JTextField();
		txt_matKhau.setText(nhanVienModel.getPassword());
		txt_matKhau.setEditable(false);
		txt_matKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_matKhau.setColumns(10);
		txt_matKhau.setBounds(730, 229, 344, 41);
		panel.add(txt_matKhau);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMtKhu.setBounds(611, 229, 109, 41);
		panel.add(lblMtKhu);
		
		txt_taiKhoan = new JTextField();
		txt_taiKhoan.setText(nhanVienModel.getUserName());
		txt_taiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_taiKhoan.setEditable(false);
		txt_taiKhoan.setColumns(10);
		txt_taiKhoan.setBounds(730, 162, 344, 41);
		panel.add(txt_taiKhoan);
		
		JLabel lblTaiKhoan = new JLabel("Tai khoan");
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTaiKhoan.setBounds(611, 160, 109, 41);
		panel.add(lblTaiKhoan);
		revalidate();
		repaint();
	}

	public void doiMatKhau() {
		panel_tong.removeAll();
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(257, 112, 704, 441);
		panel_tong.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 702, 78);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u1ED4I M\u1EACT KH\u1EA8U");
		lblNewLabel.setBounds(10, 11, 682, 56);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TÀI KHOẢN");
		lblNewLabel_1.setBounds(10, 89, 164, 38);
		panel.add(lblNewLabel_1);
		
		txt_taiKhoan = new JTextField();
		txt_taiKhoan.setText(_userAreUsing.getUserName());
		txt_taiKhoan.setEditable(false);
		txt_taiKhoan.setBounds(195, 89, 372, 38);
		panel.add(txt_taiKhoan);
		txt_taiKhoan.setColumns(10);
		
		txt_matKhauCu = new JPasswordField();
		txt_matKhauCu.setColumns(10);
		txt_matKhauCu.setBounds(195, 138, 372, 38);
		panel.add(txt_matKhauCu);
		
		txt_matKhauMoi = new JPasswordField();
		txt_matKhauMoi.setColumns(10);
		txt_matKhauMoi.setBounds(195, 187, 372, 38);
		panel.add(txt_matKhauMoi);
		
		txt_xacNhanMatKhauMoi = new JPasswordField();
		txt_xacNhanMatKhauMoi.setColumns(10);
		txt_xacNhanMatKhauMoi.setBounds(195, 236, 372, 38);
		panel.add(txt_xacNhanMatKhauMoi);
		
		JLabel lblNewLabel_1_1 = new JLabel("M\u1EACT KH\u1EA8U C\u0168");
		lblNewLabel_1_1.setBounds(10, 138, 164, 38);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("M\u1EACT KH\u1EA8U M\u1EDAI");
		lblNewLabel_1_2.setBounds(10, 187, 164, 38);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("X\u00C1C NH\u1EACN M\u1EACT KH\u1EA8U");
		lblNewLabel_1_3.setBounds(10, 236, 164, 38);
		panel.add(lblNewLabel_1_3);
		
		JButton btnNewButton = new JButton("L\u01AFU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matKhauCu = txt_matKhauCu.getText().trim();
				matKhauCu = Utilities.hashingPassword(matKhauCu);
				if(!matKhauCu.equals(_userAreUsing.getPassword())) {
					JOptionPane.showMessageDialog(null, "Mật khẩu cũ không chính xác");
					return;
				}
				String matKhauMoi = txt_matKhauMoi.getText().trim();
				String xacNhanMatKhauMoi = txt_xacNhanMatKhauMoi.getText().trim();
				if(!matKhauMoi.equals(xacNhanMatKhauMoi)) {
					JOptionPane.showMessageDialog(null, "Mật mật khẩu mới và mật khẩu xác nhận không khớp nhau");
					return;
				}
				matKhauMoi = Utilities.hashingPassword(matKhauMoi);
				_userAreUsing.setPassword(matKhauMoi);
				_nhanVienService.them_sua(_userAreUsing);
				JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
				panel_tong.removeAll();
				revalidate();
				repaint();
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(224, 346, 133, 30);
		panel.add(btnNewButton);
		
		JButton btnHy = new JButton("HỦY");
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_tong.removeAll();
				revalidate();
				repaint();
			}
		});
		btnHy.setBackground(Color.WHITE);
		btnHy.setBounds(367, 346, 133, 30);
		panel.add(btnHy);
		revalidate();
		repaint();
	}
}
