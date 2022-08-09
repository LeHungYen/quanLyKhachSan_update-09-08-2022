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
public class PhieuKiemKhoChiTiet implements Serializable{
	@Id
	@ManyToOne
	private PhieuKiemKho phieuKiemKho;
	@Id
	@ManyToOne
	private SanPhamVaDichVu sanPhamVaDichVu;
	private int soLuongTruocKhiKiem;
	private int soLuongThucTe;
	private int soLuongChenhLech;
	private String ghiChuLiDoChenhLech;
	public PhieuKiemKhoChiTiet(PhieuKiemKho phieuKiemKho, SanPhamVaDichVu sanPhamVaDichVu, int soLuongTruocKhiKiem,
			int soLuongThucTe, int soLuongChenhLech, String ghiChuLiDoChenhLech) {
		this.phieuKiemKho = phieuKiemKho;
		this.sanPhamVaDichVu = sanPhamVaDichVu;
		this.soLuongTruocKhiKiem = soLuongTruocKhiKiem;
		this.soLuongThucTe = soLuongThucTe;
		this.soLuongChenhLech = soLuongChenhLech;
		this.ghiChuLiDoChenhLech = ghiChuLiDoChenhLech;
	}
	public PhieuKiemKhoChiTiet() {
	}
	public PhieuKiemKho getPhieuKiemKho() {
		return phieuKiemKho;
	}
	public void setPhieuKiemKho(PhieuKiemKho phieuKiemKho) {
		this.phieuKiemKho = phieuKiemKho;
	}
	public SanPhamVaDichVu getSanPhamVaDichVu() {
		return sanPhamVaDichVu;
	}
	public void setSanPhamVaDichVu(SanPhamVaDichVu sanPhamVaDichVu) {
		this.sanPhamVaDichVu = sanPhamVaDichVu;
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
	
	
	
	
}
