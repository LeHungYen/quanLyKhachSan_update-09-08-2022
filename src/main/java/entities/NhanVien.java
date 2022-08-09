package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dao.NhanVienDao;


@Entity 
public class NhanVien{
	@Id
	private String maNV;
	private String tenNV;
	private String sdt;
	private String gioiTinh;
	private String email;
	@ManyToOne
	private ChucVu chucVu;
	private String trangThai;
	private String cmnd;
	private String userName;
	private String password;
	private Date ngaySinh;
	@OneToMany (mappedBy = "nhanVien")
	private List<PhieuNhapKho> listPhieuNhapKho;
	@OneToMany (mappedBy = "nhanVien")
	private List<PhieuKiemKho> listPhieuKiemKho;
	@OneToMany (mappedBy = "nhanVien")
	private List<HoaDon> listHoaDon;
	@OneToMany (mappedBy = "nhanVien")
	private List<History> listHistory;
	
	public NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String email, ChucVu chucVu,
			String trangThai, String cmnd, String userName, String password, Date ngaySinh,
			List<PhieuNhapKho> listPhieuNhapKho, List<PhieuKiemKho> listPhieuKiemKho, List<HoaDon> listHoaDon,
			List<History> listHistory) {
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.chucVu = chucVu;
		this.trangThai = trangThai;
		this.cmnd = cmnd;
		this.userName = userName;
		this.password = password;
		this.ngaySinh = ngaySinh;
		this.listPhieuNhapKho = listPhieuNhapKho;
		this.listPhieuKiemKho = listPhieuKiemKho;
		this.listHoaDon = listHoaDon;
		this.listHistory = listHistory;
	}
	
	public NhanVien() {
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ChucVu getChucVu() {
		return chucVu;
	}

	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public List<PhieuNhapKho> getListPhieuNhapKho() {
		return listPhieuNhapKho;
	}

	public void setListPhieuNhapKho(List<PhieuNhapKho> listPhieuNhapKho) {
		this.listPhieuNhapKho = listPhieuNhapKho;
	}

	public List<PhieuKiemKho> getListPhieuKiemKho() {
		return listPhieuKiemKho;
	}

	public void setListPhieuKiemKho(List<PhieuKiemKho> listPhieuKiemKho) {
		this.listPhieuKiemKho = listPhieuKiemKho;
	}

	public List<HoaDon> getListHoaDon() {
		return listHoaDon;
	}

	public void setListHoaDon(List<HoaDon> listHoaDon) {
		this.listHoaDon = listHoaDon;
	}

	public List<History> getListHistory() {
		return listHistory;
	}

	public void setListHistory(List<History> listHistory) {
		this.listHistory = listHistory;
	}
	
	
	
	
	
	
	
}
