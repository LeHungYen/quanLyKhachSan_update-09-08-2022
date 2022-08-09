package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.LoaiPhongDao;
import entities.KhachTrongPhong;
import models.ChucVuModel;
import models.DichVuPhongModel;
import models.DonViChiTietModel;
import models.DonViTinhModel;
import models.HoaDonModel;
import models.KhachHangModel;
import models.KhachSanModel;
import models.KhachTrongPhongModel;
import models.LoaiPhongModel;
import models.NhanVienModel;
import models.PhongModel;
import models.SanPhamVaDichVuModel;
import models.TangModel;
import services.DichVuPhongService;
import services.DonViChiTietService;
import services.DonViTinhService;
import services.LoaiPhongService;
import services.SanPhamVaDichVuService;
import utils.IoCContainer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class HoaDonMinibar extends JFrame {
	private IoCContainer _ioCContainer = new IoCContainer();
	private SanPhamVaDichVuService _sanPhamVaDichVuService = (SanPhamVaDichVuService) _ioCContainer.getBean(SanPhamVaDichVuService.class+"");
	private List<SanPhamVaDichVuModel> _listSanPhamVaDichVuModels = new ArrayList<SanPhamVaDichVuModel>();
	private List<DichVuPhongModel> _listCart = new ArrayList<DichVuPhongModel>();
	private DichVuPhongService _dichVuPhongService = (DichVuPhongService) _ioCContainer.getBean(DichVuPhongService.class+"");
	private DonViChiTietService _donViChiTietService = (DonViChiTietService) _ioCContainer.getBean(DonViChiTietService.class+"");
	private List<DonViChiTietModel> _listDonViChiTietModels = new ArrayList<DonViChiTietModel>();
	private KhachTrongPhongModel _ktpm;
	
	private JPanel contentPane;
	private JTable table_product;
	private javax.swing.JOptionPane JOptionPane;
	private JTable table_cart;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachTrongPhongModel ktpm = new KhachTrongPhongModel();
					ktpm.setMaKhachTrongPhong(1);
					PhongModel pm = new PhongModel();
					pm.setMaPhong(1);
					TangModel tm = new TangModel();
					tm.setMaTang(1);
					KhachSanModel ksm = new KhachSanModel();
					ksm.setMaKhachSan(1);
					tm.setKhachSanModel(ksm);
					pm.setTangModel(tm);
					
					LoaiPhongModel lpm = new LoaiPhongModel();
					lpm.setMaLoaiPhong(1);
					pm.setLoaiPhongModel(lpm);
					
					ktpm.setPhongModel(pm);
					KhachHangModel khm = new KhachHangModel();
					khm.setMaKhachHang(1);
					ktpm.setKhachHangModel(khm);
					HoaDonModel hdm = new HoaDonModel();
					hdm.setMaHoaDon(1);
					NhanVienModel nvm = new NhanVienModel();
					nvm.setMaNV(1+"");
					ChucVuModel cvm = new ChucVuModel();
					cvm.setMaChucVu(1);
					nvm.setChucVuModel(cvm);
					hdm.setNhanVienModel(nvm);
					ktpm.setHoaDonModel(hdm);
					HoaDonMinibar frame = new HoaDonMinibar(ktpm);
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
	public HoaDonMinibar(KhachTrongPhongModel ktpm) {
		_ktpm = ktpm;
		_dichVuPhongService.updateListDichVuPhongModel();
		_listCart = _dichVuPhongService.getListDichVuPhongModel();
		_sanPhamVaDichVuService.updateListSanPhamVaDichVuModel("Hoat Dong");
		_donViChiTietService.updateListDonViChiTietModel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 634, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 81, 598, 373);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 63, 578, 299);
		panel.add(scrollPane_1);
		
	
		
		table_product = new JTable();
		table_product.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pressTableProduct();
				
			}
		});
		scrollPane_1.setViewportView(table_product);
		
		JTextField textField = new JTextField();
		textField.setBounds(10, 22, 311, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Gi\u1ECF h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 465, 598, 178);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 578, 146);
		panel_1.add(scrollPane);
		
		table_cart = new JTable();
		
		scrollPane.setViewportView(table_cart);
		
		
		
		JLabel lblNewLabel = new JLabel("Th\u00EAm H\u00F3a \u0110\u01A1n MiniBar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(70, 11, 473, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("T\u1EA1o H\u00F3a \u0110\u01A1n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taoHoaDon();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 698, 244, 54);
		contentPane.add(btnNewButton);
		
		JButton btnHy = new JButton("H\u1EE7y");
		btnHy.setBackground(Color.WHITE);
		btnHy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHy.setBounds(364, 698, 244, 54);
		contentPane.add(btnHy);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng tiền:");
		lblNewLabel_1.setBounds(344, 640, 264, 35);
		contentPane.add(lblNewLabel_1);
		this.setVisible(false);
		this.setVisible(true);
		updateTableProduct();
		updateTableCart();
	}

	public void updateTableProduct() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("Mã");
		model.addColumn("Tên hàng hóa");
		model.addColumn("S.Lg tồn");
		model.addColumn("Giá bán");
		
		_listSanPhamVaDichVuModels = _sanPhamVaDichVuService.getListSanPhamVaDichVuModel_active();
		int stt =1;
		for (SanPhamVaDichVuModel spvdvm : _listSanPhamVaDichVuModels) {
				DonViChiTietModel dvctm = _sanPhamVaDichVuService.getDonViMacDinh(spvdvm);
				DonViTinhModel dvtm = dvctm.getDonViTinhModel();
				System.out.println(dvtm.toString());
				String tenDonVi = dvtm.getTenDonVi();
				String giaBan = dvctm.getGiaBan() +"/"+tenDonVi;
				model.addRow(new Object[] {stt , spvdvm.getMaDichVu() , spvdvm.getTenHangHoa() , spvdvm.getSoLuongTon(),giaBan});
				stt++;
		}
		table_product.setModel(model);
	}
	
	public void pressTableProduct() {
		int maSp = Integer.parseInt(table_product.getModel().getValueAt(table_product.getSelectedRow(), 1)+"");
		String tenSP = table_product.getModel().getValueAt(table_product.getSelectedRow(), 2)+"";
		int soLuongTon = Integer.parseInt(table_product.getModel().getValueAt(table_product.getSelectedRow(), 3)+"");
		
		String gia = table_product.getModel().getValueAt(table_product.getSelectedRow(), 4)+"";
		int indexSplit = gia.indexOf("/");
		String tenDonVi = gia.substring(indexSplit+1, gia.length());
		gia = gia.substring(0,indexSplit);
		double price = Double.parseDouble(gia);
		String soLuong = JOptionPane.showInputDialog(null, "Nhập số lượng");
		int slg = Integer.parseInt(soLuong);
		
//		if(soLuongTon-slg<0) {
//			JOptionPane.showMessageDialog(null, "Kho không đủ hàng");
//			return;
//		}
//		
		for (int i=0 ; i<_listCart.size(); i++) {
			if(_listCart.get(i).getSanPhamVaDichVuModel().getMaDichVu() == maSp) {
				_listCart.get(i).setSoLuong(_listCart.get(i).getSoLuong()+slg);
				updateTableCart();
				return;
			}
		}
		
		SanPhamVaDichVuModel spvdvm = new SanPhamVaDichVuModel();
		for (SanPhamVaDichVuModel spvdvm1 : _listSanPhamVaDichVuModels) {
			if(spvdvm1.getMaDichVu() == (maSp)) {
				spvdvm = spvdvm1;
				break;
			}
		}
		DichVuPhongModel dvpm = new DichVuPhongModel(0, spvdvm, _ktpm , price, slg);
		_listCart.add(dvpm);
		updateTableCart();
	}
	
	public void taoHoaDon() {
		DichVuPhongService dvps = new DichVuPhongService();
		dvps.updateListDichVuPhongModel();
		List<DichVuPhongModel> listDVPM = dvps.getListDichVuPhongModel();
		
		for(int i=0; i<_listCart.size();i++) {
			
			boolean check = true;
			for(int j=0 ; j<listDVPM.size();j++) {
				if(_listCart.get(i).getSanPhamVaDichVuModel().getMaDichVu() == listDVPM.get(j).getSanPhamVaDichVuModel().getMaDichVu()) {
					SanPhamVaDichVuModel spvdvnm = _listCart.get(i).getSanPhamVaDichVuModel();
					int soluongCL = _listCart.get(i).getSoLuong()-listDVPM.get(j).getSoLuong();
					int soLuongTon = spvdvnm.getSoLuongTon();
					soLuongTon = soLuongTon - soluongCL;
					spvdvnm.setSoLuongTon(soLuongTon);
					_sanPhamVaDichVuService.them_sua(spvdvnm , "Hoat Dong");
					check = false;
					break;
				}
			}
			if(check) {
				SanPhamVaDichVuModel spvdvnm = _listCart.get(i).getSanPhamVaDichVuModel();
				int soluongCL = _listCart.get(i).getSoLuong();
				int soLuongTon = spvdvnm.getSoLuongTon();
				soLuongTon = soLuongTon - soluongCL;
				spvdvnm.setSoLuongTon(soLuongTon);
				_sanPhamVaDichVuService.them_sua(spvdvnm , "Hoat Dong");
				check = true;
			}
			dvps.them_sua(_listCart.get(i));
			updateTableProduct();
		}
	}
	
	public void updateTableCart() {
		DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("Stt");
		model1.addColumn("Mã SP");
		model1.addColumn("Tên SP");
		model1.addColumn("Giá");
		model1.addColumn("Số Lượng");
		model1.addColumn("Tổng Tiền");
		
		int stt =1;
		for (DichVuPhongModel dvpm : _listCart) {
			if(dvpm.getKhachTrongPhongModel().getMaKhachTrongPhong() == _ktpm.getMaKhachTrongPhong()) {
				SanPhamVaDichVuModel spvdvm = dvpm.getSanPhamVaDichVuModel();
				double tongTien = dvpm.getGiaBan() * dvpm.getSoLuong();
				model1.addRow(new Object[] {stt ,spvdvm.getMaDichVu(), spvdvm.getTenHangHoa() , dvpm.getGiaBan() , dvpm.getSoLuong() , tongTien});
				stt++;
			}
		}
		table_cart.setModel(model1);
	}
	
}
