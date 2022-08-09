package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import entities.PhieuNhapKhoChiTiet;
import entities.HoaDon;
import entities.NhanVien;

public class PhieuNhapKhoModel {
	private int maNhap;
	private String ngayNhap;
	private String tinhTrang;
	private NhanVienModel nhanVienModel;
	private double giamGia;
	private double vat;
	private double phiShip;
	
	public PhieuNhapKhoModel(int maNhap, String ngayNhap, String tinhTrang,
			NhanVienModel nhanVienModel, double giamGia, double vat, double phiShip) {
		this.maNhap = maNhap;
		this.ngayNhap = ngayNhap;
		this.tinhTrang = tinhTrang;
		this.nhanVienModel = nhanVienModel;
		this.giamGia = giamGia;
		this.vat = vat;
		this.phiShip = phiShip;
	}
	public PhieuNhapKhoModel() {
		
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
	public NhanVienModel getNhanVienModel() {
		return nhanVienModel;
	}
	public void setNhanVienModel(NhanVienModel nhanVienModel) {
		this.nhanVienModel = nhanVienModel;
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
	
	
	
}
