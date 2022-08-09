package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dao.ChucVuDao;

@Entity 
public class ChucVu {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int maChucVu;
	private String tenChucVu;
	private String trangThai;
	@OneToMany (mappedBy = "chucVu")
	private List<Quyen_cv> listQuyen_cv;
	@OneToMany (mappedBy = "chucVu")
	private List<NhanVien> listNhanVien;
	
	public ChucVu(int maChucVu, String tenChucVu, String trangThai, List<Quyen_cv> listQuyen_cv,
			List<NhanVien> listNhanVien) {
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
		this.trangThai = trangThai;
		this.listQuyen_cv = listQuyen_cv;
		this.listNhanVien = listNhanVien;
	}
	
	public ChucVu() {
	}

	public int getMaChucVu() {
		return maChucVu;
	}

	public void setMaChucVu(int maChucVu) {
		this.maChucVu = maChucVu;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public List<Quyen_cv> getListQuyen_cv() {
		return listQuyen_cv;
	}

	public void setListQuyen_cv(List<Quyen_cv> listQuyen_cv) {
		this.listQuyen_cv = listQuyen_cv;
	}

	public List<NhanVien> getListNhanVien() {
		return listNhanVien;
	}

	public void setListNhanVien(List<NhanVien> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}

	@Override
	public String toString() {
		return "ChucVu [maChucVu=" + maChucVu + ", tenChucVu=" + tenChucVu + ", trangThai=" + trangThai
				+ ", listQuyen_cv=" + listQuyen_cv + ", listNhanVien=" + listNhanVien + "]";
	}
	
	
}
