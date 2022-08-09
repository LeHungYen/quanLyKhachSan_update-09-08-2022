package entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class HoaDon {
	@Id
	private int maHoaDon;
	private String trangThai;
	private Date ngayCheckIn;
	@ManyToOne
	private NhanVien nhanVien;
	private Date ngayTao;
	private double vat;
	private double giamGia;
	private double tienCoc;
	@OneToMany(mappedBy = "hoaDon")
	private List<KhachTrongPhong> listKhachTrongPhong;

	public HoaDon(int maHoaDon, String trangThai, Date ngayCheckIn, NhanVien nhanVien, Date ngayTao, double vat,
			double giamGia, double tienCoc, List<KhachTrongPhong> listKhachTrongPhong) {
		this.maHoaDon = maHoaDon;
		this.trangThai = trangThai;
		this.ngayCheckIn = ngayCheckIn;
		this.nhanVien = nhanVien;
		this.ngayTao = ngayTao;
		this.vat = vat;
		this.giamGia = giamGia;
		this.tienCoc = tienCoc;
		this.listKhachTrongPhong = listKhachTrongPhong;
	}

	public HoaDon() {

	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Date getNgayCheckIn() {
		return ngayCheckIn;
	}

	public void setNgayCheckIn(Date ngayCheckIn) {
		this.ngayCheckIn = ngayCheckIn;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public double getTienCoc() {
		return tienCoc;
	}

	public void setTienCoc(double tienCoc) {
		this.tienCoc = tienCoc;
	}


	public List<KhachTrongPhong> getListKhachTrongPhong() {
		return listKhachTrongPhong;
	}

	public void setListKhachTrongPhong(List<KhachTrongPhong> listKhachTrongPhong) {
		this.listKhachTrongPhong = listKhachTrongPhong;
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", trangThai=" + trangThai + ", ngayCheckIn=" + ngayCheckIn
				+ ", nhanVien=" + nhanVien + ", ngayTao=" + ngayTao + ", vat=" + vat + ", giamGia=" + giamGia
				+ ", tienCoc=" + tienCoc + ", listKhachTrongPhong=" + listKhachTrongPhong + "]";
	}


}
