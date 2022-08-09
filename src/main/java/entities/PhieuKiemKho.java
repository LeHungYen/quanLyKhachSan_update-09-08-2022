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
public class PhieuKiemKho {
	@Id
	private int maKiemKho;
	private String ngayKiemKho;
	@ManyToOne
	private NhanVien nhanVien;
	@ManyToOne
	private Kho kho;
	private String ghiChu;
	@OneToMany (mappedBy = "phieuKiemKho")
	private List<PhieuKiemKhoChiTiet> listPhieuKiemKhoChiTiet;
	public PhieuKiemKho(int maKiemKho, String ngayKiemKho, NhanVien nhanVien, Kho kho, String ghiChu,
			List<PhieuKiemKhoChiTiet> listPhieuKiemKhoChiTiet) {
		this.maKiemKho = maKiemKho;
		this.ngayKiemKho = ngayKiemKho;
		this.nhanVien = nhanVien;
		this.kho = kho;
		this.ghiChu = ghiChu;
		this.listPhieuKiemKhoChiTiet = listPhieuKiemKhoChiTiet;
	}
	public PhieuKiemKho() {
	
	}
	public int getMaKiemKho() {
		return maKiemKho;
	}
	public void setMaKiemKho(int maKiemKho) {
		this.maKiemKho = maKiemKho;
	}
	public String getNgayKiemKho() {
		return ngayKiemKho;
	}
	public void setNgayKiemKho(String ngayKiemKho) {
		this.ngayKiemKho = ngayKiemKho;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public Kho getKho() {
		return kho;
	}
	public void setKho(Kho kho) {
		this.kho = kho;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public List<PhieuKiemKhoChiTiet> getListPhieuKiemKhoChiTiet() {
		return listPhieuKiemKhoChiTiet;
	}
	public void setListPhieuKiemKhoChiTiet(List<PhieuKiemKhoChiTiet> listPhieuKiemKhoChiTiet) {
		this.listPhieuKiemKhoChiTiet = listPhieuKiemKhoChiTiet;
	}
	
	

	
}
