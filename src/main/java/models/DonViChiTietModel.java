package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import entities.DichVuPhong;
import entities.DonViTinh;
import entities.PhieuNhapKhoChiTiet;
import entities.SanPhamVaDichVu;

public class DonViChiTietModel {
	private int maDonViChiTiet;
	private DonViTinhModel donViTinhModel;
	private SanPhamVaDichVuModel sanPhamVaDichVuModel;
	private int giaTriQuyDoi;
	private double giaBan;
	private String trangThai;
	private int donViMacDinh;
	
	
	public DonViChiTietModel(int maDonViChiTiet, DonViTinhModel donViTinhModel,
			SanPhamVaDichVuModel sanPhamVaDichVuModel, int giaTriQuyDoi, double giaBan, String trangThai,
			int donViMacDinh) {
		this.maDonViChiTiet = maDonViChiTiet;
		this.donViTinhModel = donViTinhModel;
		this.sanPhamVaDichVuModel = sanPhamVaDichVuModel;
		this.giaTriQuyDoi = giaTriQuyDoi;
		this.giaBan = giaBan;
		this.trangThai = trangThai;
		this.donViMacDinh = donViMacDinh;
	}
	public int getDonViMacDinh() {
		return donViMacDinh;
	}
	public void setDonViMacDinh(int donViMacDinh) {
		this.donViMacDinh = donViMacDinh;
	}
	public DonViChiTietModel() {
	}
	public int getMaDonViChiTiet() {
		return maDonViChiTiet;
	}
	public void setMaDonViChiTiet(int maDonViChiTiet) {
		this.maDonViChiTiet = maDonViChiTiet;
	}
	public DonViTinhModel getDonViTinhModel() {
		return donViTinhModel;
	}
	public void setDonViTinhModel(DonViTinhModel donViTinhModel) {
		this.donViTinhModel = donViTinhModel;
	}
	public SanPhamVaDichVuModel getSanPhamVaDichVuModel() {
		return sanPhamVaDichVuModel;
	}
	public void setSanPhamVaDichVuModel(SanPhamVaDichVuModel sanPhamVaDichVuModel) {
		this.sanPhamVaDichVuModel = sanPhamVaDichVuModel;
	}
	public int getGiaTriQuyDoi() {
		return giaTriQuyDoi;
	}
	public void setGiaTriQuyDoi(int giaTriQuyDoi) {
		this.giaTriQuyDoi = giaTriQuyDoi;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "DonViChiTietModel [maDonViChiTiet=" + maDonViChiTiet + ", donViTinhModel=" + donViTinhModel
				+ ", sanPhamVaDichVuModel=" + sanPhamVaDichVuModel + ", giaTriQuyDoi=" + giaTriQuyDoi + ", giaBan="
				+ giaBan + ", trangThai=" + trangThai + "]";
	}
	
	
	
	
	
}
