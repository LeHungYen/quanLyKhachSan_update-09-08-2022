package entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
public class PhieuNhapKho {
	@Id
	private int maNhap;
	private String ngayNhap;
	private String tinhTrang;
	@ManyToOne
	private NhanVien nhanVien;
	private double giamGia;
	private double vat;
	private double phiShip;
	@OneToMany (mappedBy = "phieuNhapKho")
	private List<PhieuNhapKhoChiTiet> listPhieuNhapKhoChiTiet;
	public PhieuNhapKho(int maNhap, String ngayNhap, String tinhTrang, NhanVien nhanVien, double giamGia,
			double vat, double phiShip, List<PhieuNhapKhoChiTiet> listPhieuNhapKhoChiTiet) {
		this.maNhap = maNhap;
		this.ngayNhap = ngayNhap;
		this.tinhTrang = tinhTrang;
		this.nhanVien = nhanVien;
		this.giamGia = giamGia;
		this.vat = vat;
		this.phiShip = phiShip;
		this.listPhieuNhapKhoChiTiet = listPhieuNhapKhoChiTiet;
	}
	public PhieuNhapKho() {
		
	}
	public int getMaNhap() {
		return maNhap;
	}
	public void setMaNhap(int maNhap) {
		this.maNhap = maNhap;
	}
	public String getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public double getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}
	public double getPhiShip() {
		return phiShip;
	}
	public void setPhiShip(double phiShip) {
		this.phiShip = phiShip;
	}
	public List<PhieuNhapKhoChiTiet> getListPhieuNhapKhoChiTiet() {
		return listPhieuNhapKhoChiTiet;
	}
	public void setListPhieuNhapKhoChiTiet(List<PhieuNhapKhoChiTiet> listPhieuNhapKhoChiTiet) {
		this.listPhieuNhapKhoChiTiet = listPhieuNhapKhoChiTiet;
	}
	
	
}


