package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tang {
	@Id
	private int maTang;
	@ManyToOne
	private KhachSan khachSan;
	private String trangThai;
	@OneToMany (mappedBy = "tang")
	private List<Phong> listPhong ;
	
	public Tang(int maTang, KhachSan khachSan, String trangThai, List<Phong> listPhong) {
		this.maTang = maTang;
		this.khachSan = khachSan;
		this.trangThai = trangThai;
		this.listPhong = listPhong;
	}
	public Tang() {
		
	}
	public int getMaTang() {
		return maTang;
	}
	public void setMaTang(int maTang) {
		this.maTang = maTang;
	}
	public KhachSan getKhachSan() {
		return khachSan;
	}
	public void setKhachSan(KhachSan khachSan) {
		this.khachSan = khachSan;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public List<Phong> getListPhong() {
		return listPhong;
	}
	public void setListPhong(List<Phong> listPhong) {
		this.listPhong = listPhong;
	}
	@Override
	public String toString() {
		return "Tang [maTang=" + maTang + ", khachSan=" + khachSan + ", trangThai=" + trangThai + ", listPhong="
				+ listPhong + "]";
	}
	
	
}
