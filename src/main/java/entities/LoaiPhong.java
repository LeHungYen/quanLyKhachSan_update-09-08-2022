package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LoaiPhong {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int maLoaiPhong;
	private String tenLoai;
	private int soNguoiToiDa;
	private double gia;
	private double giaQuaDem;
	private double giaTheoGio;
	private String trangThai;
	@OneToMany (mappedBy = "loaiPhong")
	private List<Phong> listPhong;
	


	public LoaiPhong(int maLoaiPhong, String tenLoai, int soNguoiToiDa, double gia, double giaQuaDem, double giaTheoGio,
			String trangThai, List<Phong> listPhong) {
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoai = tenLoai;
		this.soNguoiToiDa = soNguoiToiDa;
		this.gia = gia;
		this.giaQuaDem = giaQuaDem;
		this.giaTheoGio = giaTheoGio;
		this.trangThai = trangThai;
		this.listPhong = listPhong;
	}
	public LoaiPhong() {
		
	}
	public int getMaLoaiPhong() {
		return maLoaiPhong;
	}
	public void setMaLoaiPhong(int maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public int getSoNguoiToiDa() {
		return soNguoiToiDa;
	}
	
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public void setSoNguoiToiDa(int soNguoiToiDa) {
		this.soNguoiToiDa = soNguoiToiDa;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public double getGiaQuaDem() {
		return giaQuaDem;
	}
	public void setGiaQuaDem(double giaQuaDem) {
		this.giaQuaDem = giaQuaDem;
	}
	public double getGiaTheoGio() {
		return giaTheoGio;
	}
	public void setGiaTheoGio(double giaTheoGio) {
		this.giaTheoGio = giaTheoGio;
	}
	public List<Phong> getListPhong() {
		return listPhong;
	}
	public void setListPhong(List<Phong> listPhong) {
		this.listPhong = listPhong;
	}
	
	
	
}
