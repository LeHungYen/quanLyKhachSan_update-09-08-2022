package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class PhieuNhapKhoChiTiet implements Serializable{
	@Id
	@ManyToOne
	private PhieuNhapKho phieuNhapKho;
	@Id
	@ManyToOne
	private DonViChiTiet donViChiTiet;
	private int soLuong;
	private double giaNhap;
	private String ghiChu;
	public PhieuNhapKhoChiTiet(PhieuNhapKho phieuNhapKho, DonViChiTiet donViChiTiet, int soLuong, double giaNhap,
			String ghiChu) {
		this.phieuNhapKho = phieuNhapKho;
		this.donViChiTiet = donViChiTiet;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.ghiChu = ghiChu;
	}
	public PhieuNhapKhoChiTiet() {
		
	}
	public PhieuNhapKho getPhieuNhapKho() {
		return phieuNhapKho;
	}
	public void setPhieuNhapKho(PhieuNhapKho phieuNhapKho) {
		this.phieuNhapKho = phieuNhapKho;
	}
	public DonViChiTiet getDonViChiTiet() {
		return donViChiTiet;
	}
	public void setDonViChiTiet(DonViChiTiet donViChiTiet) {
		this.donViChiTiet = donViChiTiet;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}


	
	
	
}
