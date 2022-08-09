package entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class NhomSPVaDichVu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNhomSP;
	private String tenNhomSP;
	private String nhomHangHoa;
	private String ghiChu;
	private String trangThai;
	@OneToMany(mappedBy = "nhomSPVaDichVu")
	private List<SanPhamVaDichVu> listSanPhamVaDichVu;
	
	public NhomSPVaDichVu(int maNhomSP, String tenNhomSP, String nhomHangHoa, String ghiChu, String trangThai,
			List<SanPhamVaDichVu> listSanPhamVaDichVu) {
		this.maNhomSP = maNhomSP;
		this.tenNhomSP = tenNhomSP;
		this.nhomHangHoa = nhomHangHoa;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
		this.listSanPhamVaDichVu = listSanPhamVaDichVu;
	}
	public NhomSPVaDichVu() {
		
	}
	public int getMaNhomSP() {
		return maNhomSP;
	}
	public void setMaNhomSP(int maNhomSP) {
		this.maNhomSP = maNhomSP;
	}
	public String getTenNhomSP() {
		return tenNhomSP;
	}
	public void setTenNhomSP(String tenNhomSP) {
		this.tenNhomSP = tenNhomSP;
	}
	public String getNhomHangHoa() {
		return nhomHangHoa;
	}
	public void setNhomHangHoa(String nhomHangHoa) {
		this.nhomHangHoa = nhomHangHoa;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public List<SanPhamVaDichVu> getListSanPhamVaDichVu() {
		return listSanPhamVaDichVu;
	}
	public void setListSanPhamVaDichVu(List<SanPhamVaDichVu> listSanPhamVaDichVu) {
		this.listSanPhamVaDichVu = listSanPhamVaDichVu;
	}

	
	
	
}
