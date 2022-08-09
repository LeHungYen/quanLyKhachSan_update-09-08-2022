package entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class KhachTrongPhong {
	@Id
	private int maKhachTrongPhong;
	@ManyToOne
	private KhachHang khachHang;
	@ManyToOne
	private HoaDon hoaDon;
	@ManyToOne
	private Phong phong;
	private Date ngayCheckOut;
	private double giaPhong;
	private double phuPhi;
	private String ghiChu;
	@OneToMany(mappedBy = "khachTrongPhong")
	private List<DichVuPhong> listDichVuPhong;

	public KhachTrongPhong(int maKhachTrongPhong, KhachHang khachHang, HoaDon hoaDon, Phong phong, Date ngayCheckOut,
			double giaPhong, double phuPhi, String ghiChu, List<DichVuPhong> listDichVuPhong) {
		this.maKhachTrongPhong = maKhachTrongPhong;
		this.khachHang = khachHang;
		this.hoaDon = hoaDon;
		this.phong = phong;
		this.ngayCheckOut = ngayCheckOut;
		this.giaPhong = giaPhong;
		this.phuPhi = phuPhi;
		this.ghiChu = ghiChu;
		this.listDichVuPhong = listDichVuPhong;
	}

	public KhachTrongPhong() {

	}

	public int getMaKhachTrongPhong() {
		return maKhachTrongPhong;
	}

	public void setMaKhachTrongPhong(int maKhachTrongPhong) {
		this.maKhachTrongPhong = maKhachTrongPhong;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public Date getNgayCheckOut() {
		return ngayCheckOut;
	}

	public void setNgayCheckOut(Date ngayCheckOut) {
		this.ngayCheckOut = ngayCheckOut;
	}

	public double getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}

	public double getPhuPhi() {
		return phuPhi;
	}

	public void setPhuPhi(double phuPhi) {
		this.phuPhi = phuPhi;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public List<DichVuPhong> getListDichVuPhong() {
		return listDichVuPhong;
	}

	public void setListDichVuPhong(List<DichVuPhong> listDichVuPhong) {
		this.listDichVuPhong = listDichVuPhong;
	}

	@Override
	public String toString() {
		return "KhachTrongPhong [maKhachTrongPhong=" + maKhachTrongPhong + ", khachHang=" + khachHang + ", hoaDon="
				+ hoaDon + ", phong=" + phong + ", ngayCheckOut=" + ngayCheckOut + ", giaPhong=" + giaPhong
				+ ", phuPhi=" + phuPhi + ", ghiChu=" + ghiChu + ", listDichVuPhong=" + listDichVuPhong + "]";
	}

}
