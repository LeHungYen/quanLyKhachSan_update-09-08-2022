package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class DonViChiTiet {
	@Id
	private int maDonViChiTiet;
	@ManyToOne
	DonViTinh donViTinh;
	@ManyToOne
	SanPhamVaDichVu sanPhamVaDichVu;
	private int giaTriQuyDoi;
	private double giaBan;
	private String macDinhBanHang;
	private String trangThai;
	private int donViMacDinh;
	@OneToMany (mappedBy = "donViChiTiet")
	private List<PhieuNhapKhoChiTiet> listPhieuNhapKhoChiTiet;
	
	
	
	public DonViChiTiet(int maDonViChiTiet, DonViTinh donViTinh, SanPhamVaDichVu sanPhamVaDichVu, int giaTriQuyDoi,
			double giaBan, String macDinhBanHang, String trangThai, int donViMacDinh, 
			List<PhieuNhapKhoChiTiet> listPhieuNhapKhoChiTiet) {
		this.maDonViChiTiet = maDonViChiTiet;
		this.donViTinh = donViTinh;
		this.sanPhamVaDichVu = sanPhamVaDichVu;
		this.giaTriQuyDoi = giaTriQuyDoi;
		this.giaBan = giaBan;
		this.macDinhBanHang = macDinhBanHang;
		this.trangThai = trangThai;
		this.donViMacDinh = donViMacDinh;
		this.listPhieuNhapKhoChiTiet = listPhieuNhapKhoChiTiet;
	}
	
	public DonViChiTiet() {
	}
	public int getMaDonViChiTiet() {
		return maDonViChiTiet;
	}
	public void setMaDonViChiTiet(int maDonViChiTiet) {
		this.maDonViChiTiet = maDonViChiTiet;
	}
	
	public int getDonViMacDinh() {
		return donViMacDinh;
	}

	public void setDonViMacDinh(int donViMacDinh) {
		this.donViMacDinh = donViMacDinh;
	}

	public DonViTinh getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(DonViTinh donViTinh) {
		this.donViTinh = donViTinh;
	}
	public SanPhamVaDichVu getSanPhamVaDichVu() {
		return sanPhamVaDichVu;
	}
	public void setSanPhamVaDichVu(SanPhamVaDichVu sanPhamVaDichVu) {
		this.sanPhamVaDichVu = sanPhamVaDichVu;
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
	public String getMacDinhBanHang() {
		return macDinhBanHang;
	}
	public void setMacDinhBanHang(String macDinhBanHang) {
		this.macDinhBanHang = macDinhBanHang;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public List<PhieuNhapKhoChiTiet> getListPhieuNhapKhoChiTiet() {
		return listPhieuNhapKhoChiTiet;
	}
	public void setListPhieuNhapKhoChiTiet(List<PhieuNhapKhoChiTiet> listPhieuNhapKhoChiTiet) {
		this.listPhieuNhapKhoChiTiet = listPhieuNhapKhoChiTiet;
	}
	
	
	
	
	
	
}
