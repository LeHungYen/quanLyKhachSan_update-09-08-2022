package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import models.ChucVuModel;
import models.LoaiPhongModel;
import models.NhanVienModel;
import services.ChucVuService;
import services.LoaiPhongService;
import services.NhanVienService;
import utils.IoCContainer;
import utils.Utilities;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class QuanLyLoaiPhong extends JFrame {
	private IoCContainer _ioCContainer  = new IoCContainer();
	private LoaiPhongService _loaiPhongService = (LoaiPhongService) _ioCContainer.getBean(LoaiPhongService.class+"");
	private List<LoaiPhongModel> _listLoaiPhongModels = new ArrayList<LoaiPhongModel>();
	private boolean _thaoTac = true;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField txt_maLoaiPhong;
	private JTextField txt_tenLoaiPhong;
	private JTextField txt_soNguoiToiDa;
	private JTextField txt_giaQuaDem;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btn_them;
	private JButton btn_sua;
	private JTextField txt_giaTheoGio;
	private JTextField txt_gia;
	private JComboBox cbx_trangThai;
	private JComboBox cbx_trangThai_danhSach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyLoaiPhong frame = new QuanLyLoaiPhong();
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
	public QuanLyLoaiPhong() {
		_loaiPhongService.updateListLoaiPhongModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQunLNhn = new JLabel("Quản lý loại phòng");
		lblQunLNhn.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQunLNhn.setBounds(0, 0, 1264, 64);
		contentPane.add(lblQunLNhn);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 80, 1264, 601);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cập nhật loại phòng", null, panel, null);
		panel.setLayout(null);
		
		txt_maLoaiPhong = new JTextField();
		txt_maLoaiPhong.setEditable(false);
		txt_maLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_maLoaiPhong.setBounds(129, 38, 344, 41);
		panel.add(txt_maLoaiPhong);
		txt_maLoaiPhong.setColumns(10);
		
		txt_tenLoaiPhong = new JTextField();
		txt_tenLoaiPhong.setColumns(10);
		txt_tenLoaiPhong.setBounds(129, 99, 344, 41);
		panel.add(txt_tenLoaiPhong);
		
		txt_soNguoiToiDa = new JTextField();
		txt_soNguoiToiDa.setColumns(10);
		txt_soNguoiToiDa.setBounds(129, 162, 344, 41);
		panel.add(txt_soNguoiToiDa);
		
		txt_giaQuaDem = new JTextField();
		txt_giaQuaDem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_giaQuaDem.setColumns(10);
		txt_giaQuaDem.setBounds(730, 38, 344, 41);
		panel.add(txt_giaQuaDem);
		
		JButton btnNewButton = new JButton("Làm mới");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(1082, 482, 153, 47);
		panel.add(btnNewButton);
		
		 btn_them = new JButton("Thêm");
		 btn_them.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoaiPhongModel loaiPhongModel = getInforFromFormIntoLoaiPhongModel();
					if(loaiPhongModel == null) {
						return;
					}
					_loaiPhongService.them_sua(loaiPhongModel);
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					clearForm();
					updateTable();
				}
			});
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_them.setBackground(Color.WHITE);
		btn_them.setBounds(756, 482, 153, 47);
		panel.add(btn_them);
		
		 btn_sua = new JButton("Sửa");
		 btn_sua.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		LoaiPhongModel loaiPhongModel = getInforFromFormIntoLoaiPhongModel();
		 		if(loaiPhongModel == null) {
					return;
				}
				_loaiPhongService.them_sua(loaiPhongModel);
				JOptionPane.showMessageDialog(null, "Sửa thành công");
				clearForm();
				updateTable();
				_thaoTac = true;
		 	}
		 });
		btn_sua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_sua.setBackground(Color.WHITE);
		btn_sua.setBounds(919, 482, 153, 47);
		panel.add(btn_sua);
		
		JLabel lblMNhnVin = new JLabel("Mã loại phòng");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMNhnVin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMNhnVin.setBounds(10, 38, 109, 41);
		panel.add(lblMNhnVin);
		
		JLabel lblTnNhnVin = new JLabel("Tên loại phòng");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnNhnVin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnNhnVin.setBounds(10, 99, 109, 41);
		panel.add(lblTnNhnVin);
		
		JLabel lblSinThoi = new JLabel("Số người tối đa");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinThoi.setBounds(10, 162, 109, 41);
		panel.add(lblSinThoi);
		
		JLabel lblNgySinh = new JLabel("Giá theo giờ");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgySinh.setBounds(567, 99, 153, 41);
		panel.add(lblNgySinh);
		
		JLabel lblaCh = new JLabel("Giá qua đêm");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblaCh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh.setBounds(536, 38, 184, 41);
		panel.add(lblaCh);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Danh sách", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(51, 22, 991, 36);
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
		
		JPanel panel_2_2_1_1 = new JPanel();
		panel_2_2_1_1.setLayout(null);
		panel_2_2_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(192, 192, 192)), "Tr\u1EA1ng th\u00E1i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1.setBounds(1062, 11, 187, 51);
		panel_1.add(panel_2_2_1_1);
		
		cbx_trangThai_danhSach = new JComboBox();
		cbx_trangThai_danhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});
		cbx_trangThai_danhSach.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Hoat Dong", "Khong Hoat Dong"}));
		cbx_trangThai_danhSach.setBorder(new EmptyBorder(-11, -4, -11, -1));
		cbx_trangThai_danhSach.setBackground(Color.WHITE);
		cbx_trangThai_danhSach.setBounds(10, 18, 167, 28);
		panel_2_2_1_1.add(cbx_trangThai_danhSach);
		btn_sua.setEnabled(false);
		updateTable();
		
		txt_giaTheoGio = new JTextField();
		txt_giaTheoGio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_giaTheoGio.setColumns(10);
		txt_giaTheoGio.setBounds(730, 99, 344, 41);
		panel.add(txt_giaTheoGio);
		
		cbx_trangThai = new JComboBox();
		cbx_trangThai.setBackground(Color.WHITE);
		cbx_trangThai.setModel(new DefaultComboBoxModel(new String[] {"Hoat Dong", "Khong Hoat Dong"}));
		cbx_trangThai.setBounds(730, 162, 338, 41);
		panel.add(cbx_trangThai);
		
		JLabel lblMGi = new JLabel("Trạng thái");
		lblMGi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMGi.setBounds(611, 162, 109, 41);
		panel.add(lblMGi);
		
		JLabel lblGi = new JLabel("Giá");
		lblGi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGi.setBounds(10, 227, 109, 41);
		panel.add(lblGi);
		
		txt_gia = new JTextField();
		txt_gia.setColumns(10);
		txt_gia.setBounds(129, 227, 344, 41);
		panel.add(txt_gia);
	}
	
	

	
	public void clearForm() {
		txt_maLoaiPhong.setText("");
		txt_tenLoaiPhong.setText("");
		txt_soNguoiToiDa.setText("");
		txt_gia.setText("");
		txt_giaQuaDem.setText("");
		txt_giaTheoGio.setText("");
		cbx_trangThai.setSelectedIndex(0);
		btn_sua.setEnabled(false);
		btn_them.setEnabled(true);
		_thaoTac=true;
	}
	
	public void doClickOnTable() {
		txt_maLoaiPhong.setText(table.getModel().getValueAt(table.getSelectedRow(), 1)+"");
		txt_tenLoaiPhong.setText(table.getModel().getValueAt(table.getSelectedRow(), 2)+"");
		txt_soNguoiToiDa.setText(table.getModel().getValueAt(table.getSelectedRow(), 3)+"");
		txt_gia.setText(table.getModel().getValueAt(table.getSelectedRow(), 4)+"");
		txt_giaQuaDem.setText(table.getModel().getValueAt(table.getSelectedRow(), 5)+"");
		txt_giaTheoGio.setText(table.getModel().getValueAt(table.getSelectedRow(), 6)+"");
		cbx_trangThai.setSelectedItem(table.getModel().getValueAt(table.getSelectedRow(), 7)+"");
		btn_them.setEnabled(false);
		btn_sua.setEnabled(true);
		_thaoTac=false;
	}
	
	public void updateTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("Mã loại phòng");
		model.addColumn("Tên loại phòng");
		model.addColumn("Số người tối đa");
		model.addColumn("Giá");
		model.addColumn("Giá qua đêm");
		model.addColumn("Giá theo giờ");
		model.addColumn("Trạng thái");
		_listLoaiPhongModels = _loaiPhongService.getListLoaiPhongModel();
		int stt= 1;
		
		String trangThai = cbx_trangThai_danhSach.getSelectedItem().toString();
		if(trangThai.equals("Tất cả")) {
			for (LoaiPhongModel lpm : _listLoaiPhongModels) {
				model.addRow(new Object[] {stt, lpm.getMaLoaiPhong(),lpm.getTenLoai(),lpm.getSoNguoiToiDa(),lpm.getGia(),lpm.getGiaQuaDem(),lpm.getGiaTheoGio(),lpm.getTrangThai()});
				stt++;
			}
		}
		
		if(trangThai.equals("Hoat Dong")) {
			for (LoaiPhongModel lpm : _listLoaiPhongModels) {
				if(lpm.getTrangThai().equals("Hoat Dong")) {
					model.addRow(new Object[] {stt, lpm.getMaLoaiPhong(),lpm.getTenLoai(),lpm.getSoNguoiToiDa(),lpm.getGia(),lpm.getGiaQuaDem(),lpm.getGiaTheoGio(),lpm.getTrangThai()});
					stt++;
				}
			}
		}
		if(trangThai.equals("Khong Hoat Dong")) {
			for (LoaiPhongModel lpm : _listLoaiPhongModels) {
				if(lpm.getTrangThai().equals("Khong Hoat Dong")) {
					model.addRow(new Object[] {stt, lpm.getMaLoaiPhong(),lpm.getTenLoai(),lpm.getSoNguoiToiDa(),lpm.getGia(),lpm.getGiaQuaDem(),lpm.getGiaTheoGio(),lpm.getTrangThai()});
					stt++;
				}
			}
		}
		table.setModel(model);
	}
	
	public LoaiPhongModel getInforFromFormIntoLoaiPhongModel() {
		
		String malp = txt_maLoaiPhong.getText().trim();
		int maLoaiPhong;
		if(malp.equals("")) {
			maLoaiPhong =0;
		}else {
			maLoaiPhong  = Integer.parseInt(malp);
		}
		
		
		String tenLoaiPhong = txt_tenLoaiPhong.getText().trim();
		
		if(Utilities.regexCheckSoNguyenDuong(txt_soNguoiToiDa.getText().trim()).equals("false")) {
		JOptionPane.showMessageDialog(null, "Số người tối đa phải là số nguyên dương");
		return null;
		}
		
		int soNguoiToiDa = Integer.parseInt(txt_soNguoiToiDa.getText().trim());
		
		if(soNguoiToiDa <0) {
			JOptionPane.showMessageDialog(null, "Số người tối đa phải là số nguyên dương");
			return null;
			}
		
		if(Utilities.regexCheckDouble(txt_gia.getText().trim()).equals("false")) {
			JOptionPane.showMessageDialog(null, "Giá phải là số và không được < 0");
			return null;
		}
		
		double gia = Double.parseDouble(txt_gia.getText().trim());
		
		if(gia<0) {
			JOptionPane.showMessageDialog(null, "Giá phải là số và không được < 0");
			return null;
		}
		
		if(Utilities.regexCheckDouble(txt_giaQuaDem.getText().trim()).equals("false")) {
			JOptionPane.showMessageDialog(null, "Giá qua đêm phải là số và không được < 0");
			return null;
		}
		
		double giaQuaDem = Double.parseDouble(txt_giaQuaDem.getText().trim());
		
		if(giaQuaDem<0) {
			JOptionPane.showMessageDialog(null, "Giá qua đêm phải là số và không được < 0");
			return null;
		}
		
		if(Utilities.regexCheckDouble(txt_giaTheoGio.getText().trim()).equals("false")) {
			JOptionPane.showMessageDialog(null, "Giá theo giờ phải là số và không được < 0");
			return null;
		}
		
		double giaTheoGio = Double.parseDouble(txt_giaTheoGio.getText().trim());
		
		if(giaTheoGio<0) {
			JOptionPane.showMessageDialog(null, "Giá theo giờ phải là số và không được < 0");
			return null;
		}
		
		String trangThai = cbx_trangThai.getSelectedItem().toString();
		
		LoaiPhongModel lpm = new LoaiPhongModel(maLoaiPhong, tenLoaiPhong, soNguoiToiDa, gia, giaQuaDem, giaTheoGio, trangThai);
		return lpm;
	}
}