package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class DichVuPhong {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int maDichVuPhong;
	@ManyToOne
	private SanPhamVaDichVu sanPhamVaDichVu;
	@ManyToOne
	private KhachTrongPhong khachTrongPhong;
	private double giaBan;
	private int soLuong;
	
	public DichVuPhong(int maDichVuPhong, SanPhamVaDichVu sanPhamVaDichVu, KhachTrongPhong khachTrongPhong, double giaBan,
			int soLuong) {
		this.maDichVuPhong = maDichVuPhong;
		this.sanPhamVaDichVu = sanPhamVaDichVu;
		this.khachTrongPhong = khachTrongPhong;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
	}
	public DichVuPhong() {
		
	}
	public int getMaDichVuPhong() {
		return maDichVuPhong;
	}
	public void setMaDichVuPhong(int maDichVuPhong) {
		this.maDichVuPhong = maDichVuPhong;
	}
	public SanPhamVaDichVu getSanPhamVaDichVu() {
		return sanPhamVaDichVu;
	}
	public void setSanPhamVaDichVu(SanPhamVaDichVu sanPhamVaDichVu) {
		this.sanPhamVaDichVu = sanPhamVaDichVu;
	}
	public KhachTrongPhong getKhachTrongPhong() {
		return khachTrongPhong;
	}
	public void setKhachTrongPhong(KhachTrongPhong khachTrongPhong) {
		this.khachTrongPhong = khachTrongPhong;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "DichVuPhong [maDichVuPhong=" + maDichVuPhong + ", sanPhamVaDichVu=" + sanPhamVaDichVu + ", khachTrongPhong="
				+ khachTrongPhong + ", giaBan=" + giaBan + ", soLuong=" + soLuong + "]";
	}
	
	
	
	
}