package models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import entities.PhieuKiemKho;
import entities.SanPhamVaDichVu;

public class PhieuKiemKhoChiTietModel {
	private PhieuKiemKhoModel phieuKiemKhoModel;
	private SanPhamVaDichVuModel sanPhamVaDichVuModel;
	private int soLuongTruocKhiKiem;
	private int soLuongThucTe;
	private int soLuongChenhLech;
	private String ghiChuLiDoChenhLech;
	
	public PhieuKiemKhoChiTietModel(PhieuKiemKhoModel phieuKiemKhoModel, SanPhamVaDichVuModel sanPhamVaDichVuModel,
			int soLuongTruocKhiKiem, int soLuongThucTe, int soLuongChenhLech, String ghiChuLiDoChenhLech) {
		this.phieuKiemKhoModel = phieuKiemKhoModel;
		this.sanPhamVaDichVuModel = sanPhamVaDichVuModel;
		this.soLuongTruocKhiKiem = soLuongTruocKhiKiem;
		this.soLuongThucTe = soLuongThucTe;
		this.soLuongChenhLech = soLuongChenhLech;
		this.ghiChuLiDoChenhLech = ghiChuLiDoChenhLech;
	}
	
	public PhieuKiemKhoChiTietModel() {
	}

	public PhieuKiemKhoModel getPhieuKiemKhoModel() {
		return phieuKiemKhoModel;
	}

	public void setPhieuKiemKhoModel(PhieuKiemKhoModel phieuKiemKhoModel) {
		this.phieuKiemKhoModel = phieuKiemKhoModel;
	}

	public SanPhamVaDichVuModel getSanPhamVaDichVuModel() {
		return sanPhamVaDichVuModel;
	}

	public void setSanPhamVaDichVuModel(SanPhamVaDichVuModel sanPhamVaDichVuModel) {
		this.sanPhamVaDichVuModel = sanPhamVaDichVuModel;
	}

	public int getSoLuongTruocKhiKiem() {
		return soLuongTruocKhiKiem;
	}

	public void setSoLuongTruocKhiKiem(int soLuongTruocKhiKiem) {
		this.soLuongTruocKhiKiem = soLuongTruocKhiKiem;
	}

	public int getSoLuongThucTe() {
		return soLuongThucTe;
	}

	public void setSoLuongThucTe(int soLuongThucTe) {
		this.soLuongThucTe = soLuongThucTe;
	}

	public int getSoLuongChenhLech() {
		return soLuongChenhLech;
	}

	public void setSoLuongChenhLech(int soLuongChenhLech) {
		this.soLuongChenhLech = soLuongChenhLech;
	}

	public String getGhiChuLiDoChenhLech() {
		return ghiChuLiDoChenhLech;
	}

	public void setGhiChuLiDoChenhLech(String ghiChuLiDoChenhLech) {
		this.ghiChuLiDoChenhLech = ghiChuLiDoChenhLech;
	}

	@Override
	public String toString() {
		return "PhieuKiemKhoChiTietModel [phieuKiemKhoModel=" + phieuKiemKhoModel + ", sanPhamVaDichVuModel="
				+ sanPhamVaDichVuModel + ", soLuongTruocKhiKiem=" + soLuongTruocKhiKiem + ", soLuongThucTe="
				+ soLuongThucTe + ", soLuongChenhLech=" + soLuongChenhLech + ", ghiChuLiDoChenhLech="
				+ ghiChuLiDoChenhLech + "]";
	}
	
	
}
