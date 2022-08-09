package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import models.ChucVuModel;
import models.SanPhamVaDichVuModel;
import models.NhanVienModel;
import services.ChucVuService;
import services.NhanVienService;
import utils.IoCContainer;
import utils.Utilities;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class NhanVien_view extends JFrame {
	private IoCContainer _ioCContainer  = new IoCContainer();
	private NhanVienService _nhanVienService = (NhanVienService) _ioCContainer.getBean(NhanVienService.class+"");
	private ChucVuService _chucVuService = (ChucVuService) _ioCContainer.getBean(ChucVuService.class+"");
	private List<NhanVienModel> _listNhanVienModels = new ArrayList<NhanVienModel>();
	private List<ChucVuModel> _listChucVuModels = new ArrayList<ChucVuModel>();
	private int _maxID;
	private int _sttNhanVienEditing;
	private boolean _thaoTac = true;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField txt_maNhanVien;
	private JTextField txt_tenNhanVien;
	private JTextField txt_soDienThoai;
	private JTextField txt_email;
	private JTextField txt_cmnd;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdb_nam;
	private JRadioButton rdb_nu;
	private JComboBox cbx_chucVu;
	private JDateChooser dateChooser_ngaySinh;
	private JTextField txt_matKhau;
	private JButton btn_them;
	private JButton btn_sua;
	private JComboBox cbx_trangThai;
	private JComboBox cbx_trangThai_danhSach;
	private JTextField txt_taiKhoan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien_view frame = new NhanVien_view();
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
	public NhanVien_view() {
		_chucVuService.updateListChucVuModel();
		_listChucVuModels = _chucVuService.getListChucVuModel();
		_nhanVienService.updateListNhanVienModel();
		_maxID = _nhanVienService.getMaxID();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQunLNhn = new JLabel("Quản lý nhân viên");
		lblQunLNhn.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQunLNhn.setBounds(0, 0, 1264, 64);
		contentPane.add(lblQunLNhn);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 80, 1264, 601);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cập nhật nhân viên", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Giới tính");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 210, 109, 41);
		panel.add(lblNewLabel);
		
		txt_maNhanVien = new JTextField();
		txt_maNhanVien.setEditable(false);
		txt_maNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_maNhanVien.setBounds(129, 38, 344, 41);
		panel.add(txt_maNhanVien);
		txt_maNhanVien.setColumns(10);
		
		txt_tenNhanVien = new JTextField();
		txt_tenNhanVien.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(_thaoTac)
				setMaNhanVien();
			}
		});
		txt_tenNhanVien.setColumns(10);
		txt_tenNhanVien.setBounds(129, 99, 344, 41);
		panel.add(txt_tenNhanVien);
		
		txt_soDienThoai = new JTextField();
		txt_soDienThoai.setColumns(10);
		txt_soDienThoai.setBounds(129, 162, 344, 41);
		panel.add(txt_soDienThoai);
		
		txt_email = new JTextField();
		txt_email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_email.setColumns(10);
		txt_email.setBounds(129, 258, 344, 41);
		panel.add(txt_email);
		
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
		
		 cbx_chucVu = new JComboBox();
		cbx_chucVu.setBackground(Color.WHITE);
		cbx_chucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbx_chucVu.setBounds(129, 321, 344, 41);
		panel.add(cbx_chucVu);
		
		txt_cmnd = new JTextField();
		txt_cmnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_cmnd.setColumns(10);
		txt_cmnd.setBounds(730, 97, 344, 41);
		panel.add(txt_cmnd);
		
		 dateChooser_ngaySinh = new JDateChooser();
		dateChooser_ngaySinh.setBounds(730, 38, 344, 41);
		panel.add(dateChooser_ngaySinh);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(10, 258, 109, 41);
		panel.add(lblEmail);
		
		JButton btnNewButton = new JButton("Làm mới");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(1073, 482, 153, 47);
		panel.add(btnNewButton);
		
		 btn_them = new JButton("Thêm");
		 btn_them.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NhanVienModel nhanVienModel = getInforFromFormIntoNhanVienModel();
					if(nhanVienModel == null) {
						return;
					}
					_nhanVienService.them_sua(nhanVienModel);
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					updateTable();
					_maxID++;
					clearForm();
				}
			});
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_them.setBackground(Color.WHITE);
		btn_them.setBounds(747, 482, 153, 47);
		panel.add(btn_them);
		
		 btn_sua = new JButton("Sửa");
		 btn_sua.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		NhanVienModel nhanVienModel = getInforFromFormIntoNhanVienModel();
		 		if(nhanVienModel == null) {
					return;
				}
				_nhanVienService.them_sua(nhanVienModel);
				JOptionPane.showMessageDialog(null, "Sửa thành công");
				clearForm();
				updateTable();
				_thaoTac = true;
		 	}
		 });
		btn_sua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_sua.setBackground(Color.WHITE);
		btn_sua.setBounds(910, 482, 153, 47);
		panel.add(btn_sua);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMNhnVin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMNhnVin.setBounds(10, 38, 109, 41);
		panel.add(lblMNhnVin);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnNhnVin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnNhnVin.setBounds(10, 99, 109, 41);
		panel.add(lblTnNhnVin);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi.setBounds(10, 162, 109, 41);
		panel.add(lblSinThoi);
		
		JLabel lblChcV = new JLabel("Chức vụ");
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChcV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChcV.setBounds(10, 321, 109, 41);
		panel.add(lblChcV);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgySinh.setBounds(611, 38, 109, 41);
		panel.add(lblNgySinh);
		
		JLabel lblCmnd = new JLabel("Cmnd");
		lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCmnd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCmnd.setBounds(611, 97, 109, 41);
		panel.add(lblCmnd);
		
		txt_matKhau = new JTextField();
		txt_matKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_matKhau.setColumns(10);
		txt_matKhau.setBounds(730, 228, 344, 41);
		panel.add(txt_matKhau);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMtKhu.setBounds(611, 228, 109, 41);
		panel.add(lblMtKhu);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Danh sách", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(51, 22, 1044, 36);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 1239, 493);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				doClickOnTable();
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(NhanVien_view.class.getResource("Search-icon.png"))));
		lblNewLabel_1.setBounds(10, 22, 43, 36);
		panel_1.add(lblNewLabel_1);
		
		cbx_trangThai_danhSach = new JComboBox();
		cbx_trangThai_danhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});
		cbx_trangThai_danhSach.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Hoat Dong", "Khong Hoat Dong"}));
		cbx_trangThai_danhSach.setBackground(Color.WHITE);
		cbx_trangThai_danhSach.setBounds(1105, 22, 144, 36);
		panel_1.add(cbx_trangThai_danhSach);
		btn_sua.setEnabled(false);
		updateCbxChucVu();
		updateTable();
		txt_maNhanVien.setText(_maxID+"");
		
		cbx_trangThai = new JComboBox();
		cbx_trangThai.setBackground(Color.WHITE);
		cbx_trangThai.setModel(new DefaultComboBoxModel(new String[] {"Hoat Dong", "Khong Hoat Dong"}));
		cbx_trangThai.setBounds(730, 292, 344, 41);
		panel.add(cbx_trangThai);
		
		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrngThi.setBounds(611, 290, 109, 41);
		panel.add(lblTrngThi);
		
		txt_taiKhoan = new JTextField();
		txt_taiKhoan.setEditable(false);
		txt_taiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_taiKhoan.setColumns(10);
		txt_taiKhoan.setBounds(730, 160, 344, 41);
		panel.add(txt_taiKhoan);
		
		JLabel lblTiKhon = new JLabel("Tài khoản");
		lblTiKhon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTiKhon.setBounds(611, 160, 109, 41);
		panel.add(lblTiKhon);
	}
	
	public void updateCbxChucVu() {
		String arrayChucVu[] = new String[_listChucVuModels.size()+1];
		int index =1;
		arrayChucVu[0] = "Chức vụ";
		for (ChucVuModel chucVuModel : _listChucVuModels) {
			arrayChucVu[index] = chucVuModel.getTenChucVu();
			index++;
		}
		cbx_chucVu.setModel(new DefaultComboBoxModel(arrayChucVu));
	}
	
	public void setMaNhanVien() {
		String tenNhanVien = txt_tenNhanVien.getText().trim();
		
		if(new utils.Utilities().regexCheckFullName(tenNhanVien).equals("false")) {
			JOptionPane.showMessageDialog(contentPane, "họ tên bạn nhập không hợp lệ");
			return;
		}
		String maNhanVien = Utilities.getIdByNameAndID(_maxID, tenNhanVien);
//		txt_maNhanVien.setText(maNhanVien);
		txt_taiKhoan.setText(maNhanVien);
	}
	
	public void clearForm() {
		txt_maNhanVien.setText(_maxID+"");
		txt_tenNhanVien.setText("");
		txt_soDienThoai.setText("");
		buttonGroup.clearSelection();
		txt_email.setText("");
		cbx_chucVu.setSelectedIndex(0);
//		txt_diaChi.setText("");
		dateChooser_ngaySinh.setDate(null);
		txt_cmnd.setText("");
		txt_matKhau.setText("");
		txt_matKhau.setEditable(true);
		btn_sua.setEnabled(false);
		btn_them.setEnabled(true);
		_thaoTac=true;
	}
	
	public void doClickOnTable() {
		_sttNhanVienEditing = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0)+"")-1;
		txt_maNhanVien.setText(_listNhanVienModels.get(_sttNhanVienEditing).getMaNV()+"");
		txt_tenNhanVien.setText(_listNhanVienModels.get(_sttNhanVienEditing).getTenNV());
		txt_soDienThoai.setText(_listNhanVienModels.get(_sttNhanVienEditing).getSdt());
		String gioiTinh =_listNhanVienModels.get(_sttNhanVienEditing).getGioiTinh();
		if(gioiTinh.equals("Nam")) {
			rdb_nam.setSelected(true);
		}else
			rdb_nu.setSelected(true);
		txt_email.setText(_listNhanVienModels.get(_sttNhanVienEditing).getEmail());
		String chucVu = _listNhanVienModels.get(_sttNhanVienEditing).getChucVuModel().getTenChucVu();
		cbx_chucVu.setSelectedItem(chucVu);
//		txt_diaChi.setText(_listNhanVienModels.get(_sttNhanVienEditing).getDiaChi());
		Date date = new Date(Utilities.splitYear(_listNhanVienModels.get(_sttNhanVienEditing).getNgaySinh()+"")-1900, Utilities.splitMonth(_listNhanVienModels.get(_sttNhanVienEditing).getNgaySinh()+"")-1, Utilities.splitDate(_listNhanVienModels.get(_sttNhanVienEditing).getNgaySinh()+""));
		dateChooser_ngaySinh.setDate(date);
		txt_cmnd.setText(_listNhanVienModels.get(_sttNhanVienEditing).getCmnd());
		txt_matKhau.setText(_listNhanVienModels.get(_sttNhanVienEditing).getPassword());
		txt_matKhau.setEditable(false);
		btn_them.setEnabled(false);
		btn_sua.setEnabled(true);
		_thaoTac=false;
	}
	
	public void updateTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("Tên nhân viên");
		model.addColumn("Số điện thoại");
		model.addColumn("Giới tính");
		model.addColumn("Email");
		model.addColumn("Chức vụ");
		model.addColumn("Ngày sinh");
		model.addColumn("Cmnd");
		model.addColumn("Mật khẩu");
		model.addColumn("Trạng thái");
		_listNhanVienModels = _nhanVienService.getListNhanVienModel();
		int stt= 1;
		
		String trangThai = cbx_trangThai_danhSach.getSelectedItem().toString();
		if(trangThai.equals("Tất cả")) {
			for (NhanVienModel nhanVienModel : _listNhanVienModels) {
				model.addRow(new Object[] {stt,nhanVienModel.getTenNV(),nhanVienModel.getSdt(),nhanVienModel.getGioiTinh(),nhanVienModel.getEmail(),nhanVienModel.getChucVuModel().getTenChucVu(),nhanVienModel.getNgaySinh(),nhanVienModel.getCmnd(),nhanVienModel.getPassword(),nhanVienModel.getTrangThai()});
				stt++;
			}
		}
		if(trangThai.equals("Hoat Dong")) {
			for (NhanVienModel nhanVienModel : _listNhanVienModels) {
				if(nhanVienModel.getTrangThai().equals("Hoat Dong")) {
					model.addRow(new Object[] {stt,nhanVienModel.getTenNV(),nhanVienModel.getSdt(),nhanVienModel.getGioiTinh(),nhanVienModel.getEmail(),nhanVienModel.getChucVuModel().getTenChucVu(),nhanVienModel.getNgaySinh(),nhanVienModel.getCmnd(),nhanVienModel.getPassword(),nhanVienModel.getTrangThai()});
					stt++;
				}
			}
		}
		if(trangThai.equals("Khong Hoat Dong")) {
			for (NhanVienModel nhanVienModel : _listNhanVienModels) {
				if(nhanVienModel.getTrangThai().equals("Khong Hoat Dong")) {
					model.addRow(new Object[] {stt,nhanVienModel.getTenNV(),nhanVienModel.getSdt(),nhanVienModel.getGioiTinh(),nhanVienModel.getEmail(),nhanVienModel.getChucVuModel().getTenChucVu(),nhanVienModel.getNgaySinh(),nhanVienModel.getCmnd(),nhanVienModel.getPassword(),nhanVienModel.getTrangThai()});
					stt++;
				}
			}
		}
		table.setModel(model);
	}
	
	public NhanVienModel getInforFromFormIntoNhanVienModel() {
		
		String maNhanVien = txt_maNhanVien.getText().trim();
		
		String tenNhanVien = txt_tenNhanVien.getText().trim();
		
		if(tenNhanVien.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập họ tên");
			return null;
		}
		
		if(Utilities.regexCheckFullName(tenNhanVien).equals("false")) {
			JOptionPane.showMessageDialog(contentPane, "họ tên bạn nhập không hợp lệ");
			return null;
		}
		
		String soDienThoai = txt_soDienThoai.getText().trim();
		System.out.println(soDienThoai);
		if(soDienThoai.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập sdt");
			return null;
		}
		
		if(Utilities.regexCheckPhoneNumber(soDienThoai).equals("false")) {
			JOptionPane.showMessageDialog(contentPane, "sdt bạn nhập không hợp lệ");
			return null;
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
			return null;
		}
		
		String email = txt_email.getText().trim();
		
		if(email.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập email");
			return null;
		}
		
		if(Utilities.regexCheckGmail(email).equals("false")) {
			JOptionPane.showMessageDialog(contentPane, "email bạn nhập không hợp lệ");
			return null;
		}
		
		int chucVu_form =cbx_chucVu.getSelectedIndex();
		
		if(chucVu_form == 0) {
			JOptionPane.showMessageDialog(contentPane, "Xin vui lòng chọn chức vụ");
			return null;
		}
		
		ChucVuModel chucVuModel = _listChucVuModels.get(chucVu_form-1);
		int maChucVu = chucVuModel.getMaChucVu();
		
//		String diaChi = txt_diaChi.getText().trim();
		String ngaySinh ="";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			ngaySinh = simpleDateFormat.format(dateChooser_ngaySinh.getDate());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập ngày sinh");
			return null;
		}
		Date date = new Date(Utilities.splitYear(ngaySinh)-1900, Utilities.splitMonth(ngaySinh)-1, Utilities.splitDate(ngaySinh));
		String cmnd = txt_cmnd.getText().trim();
		
		if(cmnd.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập cmnd");
			return null;
		}
		
		if(Utilities.regexCheckIdentityCardNumber(cmnd).equals("false")) {
			JOptionPane.showMessageDialog(contentPane, "Cmnd bạn nhập không hợp lệ");
			return null;
		}
		
		String matKhau = txt_matKhau.getText().trim();
		if(matKhau.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Xin vui lòng nhập mật khẩu");
			return null;
		}
		if(!matKhau.equals("")) {
			matKhau = utils.Utilities.hashingPassword(matKhau);
		}
		
		String trangThai = cbx_trangThai.getSelectedItem().toString();
		String taiKhoan = txt_taiKhoan.getText().trim();
		
		NhanVienModel nvm = new NhanVienModel(maNhanVien, tenNhanVien, soDienThoai, gioiTinh, email, chucVuModel,trangThai, cmnd,taiKhoan, matKhau, date);
		return nvm;
	}
}