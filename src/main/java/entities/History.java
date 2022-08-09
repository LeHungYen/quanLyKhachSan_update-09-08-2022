package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class History {
	@Id
	private int id;
	@ManyToOne
	private NhanVien nhanVien;
	private String doiTuong;
	private String hanhDong;
	private String ghiChu;
	public History(int id, NhanVien nhanVien, String doiTuong, String hanhDong, String ghiChu) {
		this.id = id;
		this.nhanVien = nhanVien;
		this.doiTuong = doiTuong;
		this.hanhDong = hanhDong;
		this.ghiChu = ghiChu;
	}
	
	public History() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getDoiTuong() {
		return doiTuong;
	}

	public void setDoiTuong(String doiTuong) {
		this.doiTuong = doiTuong;
	}

	public String getHanhDong() {
		return hanhDong;
	}

	public void setHanhDong(String hanhDong) {
		this.hanhDong = hanhDong;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", nhanVien=" + nhanVien + ", doiTuong=" + doiTuong + ", hanhDong=" + hanhDong
				+ ", ghiChu=" + ghiChu + "]";
	}
	
	
}
