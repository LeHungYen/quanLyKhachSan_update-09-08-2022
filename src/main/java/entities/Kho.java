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
@Entity
public class Kho {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int maKho;
	private String tenKho;
	private String trangThai;
	@OneToMany (mappedBy = "kho")
	private List<PhieuKiemKho> listPhieuKiemKho;
	@OneToMany (mappedBy = "kho")
	private List<SanPhamVaDichVu> listSanPhamVaDichVu;
	
	public Kho(int maKho, String tenKho, String trangThai, List<PhieuKiemKho> listPhieuKiemKho,
			List<SanPhamVaDichVu> listSanPhamVaDichVu) {
		this.maKho = maKho;
		this.tenKho = tenKho;
		this.trangThai = trangThai;
		this.listPhieuKiemKho = listPhieuKiemKho;
		this.listSanPhamVaDichVu = listSanPhamVaDichVu;
	}
	public Kho() {
		
	}
	public int getMaKho() {
		return maKho;
	}
	public void setMaKho(int maKho) {
		this.maKho = maKho;
	}
	public String getTenKho() {
		return tenKho;
	}
	public void setTenKho(String tenKho) {
		this.tenKho = tenKho;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public List<PhieuKiemKho> getListPhieuKiemKho() {
		return listPhieuKiemKho;
	}
	public void setListPhieuKiemKho(List<PhieuKiemKho> listPhieuKiemKho) {
		this.listPhieuKiemKho = listPhieuKiemKho;
	}
	public List<SanPhamVaDichVu> getListSanPhamVaDichVu() {
		return listSanPhamVaDichVu;
	}
	public void setListSanPhamVaDichVu(List<SanPhamVaDichVu> listSanPhamVaDichVu) {
		this.listSanPhamVaDichVu = listSanPhamVaDichVu;
	}
	@Override
	public String toString() {
		return "Kho [maKho=" + maKho + ", tenKho=" + tenKho + ", trangThai=" + trangThai + ", listPhieuKiemKho="
				+ listPhieuKiemKho + ", listSanPhamVaDichVu=" + listSanPhamVaDichVu + "]";
	}
	
	
	
	
	
	
	
	
}
