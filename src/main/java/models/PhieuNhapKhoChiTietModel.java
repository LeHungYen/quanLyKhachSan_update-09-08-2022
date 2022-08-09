package models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import entities.NhanVien;
import entities.PhieuNhapKho;
import entities.PhieuNhapKhoChiTiet;
import entities.SanPhamVaDichVu;

public class PhieuNhapKhoChiTietModel {
	private PhieuNhapKhoModel phieuNhapKhoModel;
	private DonViChiTietModel donViChiTietModel;
	private int soLuong;
	private double giaNhap;
	private String ghiChu;
	public PhieuNhapKhoChiTietModel(PhieuNhapKhoModel phieuNhapKhoModel, DonViChiTietModel donViChiTietModel,
			int soLuong, double giaNhap, String ghiChu) {
		this.phieuNhapKhoModel = phieuNhapKhoModel;
		this.donViChiTietModel = donViChiTietModel;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.ghiChu = ghiChu;
	}
	public PhieuNhapKhoChiTietModel() {
	}
	public PhieuNhapKhoModel getPhieuNhapKhoModel() {
		return phieuNhapKhoModel;
	}
	public void setPhieuNhapKhoModel(PhieuNhapKhoModel phieuNhapKhoModel) {
		this.phieuNhapKhoModel = phieuNhapKhoModel;
	}
	public DonViChiTietModel getDonViChiTietModel() {
		return donViChiTietModel;
	}
	public void setDonViChiTietModel(DonViChiTietModel donViChiTietModel) {
		this.donViChiTietModel = donViChiTietModel;
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