package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.DonViChiTiet;
import entities.NhanVien;
import entities.PhieuKiemKhoChiTiet;
import entities.SanPhamVaDichVu;
import utils.DB_Connection;

public class SanPhamVaDichVuDao{
	
	private static List<SanPhamVaDichVu> _listSanPhamVaDichVus = new ArrayList<SanPhamVaDichVu>();
	private static List<SanPhamVaDichVu> _listSanPhamVaDichVus_active = new ArrayList<SanPhamVaDichVu>();
	private static List<SanPhamVaDichVu> _listSanPhamVaDichVus_inactive = new ArrayList<SanPhamVaDichVu>();
	private int maxID;
	
	public void them_sua(SanPhamVaDichVu sanPhamVaDichVu) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(sanPhamVaDichVu);
		session.getTransaction().commit();
		session.close();
	}
	

	public void updateListSanPhamVaDichVu() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from SanPhamVaDichVu");
		query.addEntity(SanPhamVaDichVu.class);
		_listSanPhamVaDichVus = (ArrayList<SanPhamVaDichVu>) query.list();
		session.getTransaction().commit();
		session.close();
		getMaxID(_listSanPhamVaDichVus);
	}
	
	public void updateListSanPhamVaDichVu(String trangThai) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from SanPhamVaDichVu where trangThai ='"+trangThai+"'");
		query.addEntity(SanPhamVaDichVu.class);
		if(trangThai.equals("Hoat Dong")) {
			_listSanPhamVaDichVus_active = (ArrayList<SanPhamVaDichVu>) query.list();
		}else {
			_listSanPhamVaDichVus_inactive = (ArrayList<SanPhamVaDichVu>) query.list();
		}
		session.getTransaction().commit();
		session.close();
	}
	
	public void getMaxID(List<SanPhamVaDichVu> listSanPhamVaDichVu) {
		if(listSanPhamVaDichVu.size()==0) {
			maxID =1;
		}else {
			maxID = listSanPhamVaDichVu.get(listSanPhamVaDichVu.size()-1).getMaDichVu();
			maxID++;
		}
	}

	public List<SanPhamVaDichVu> getListSanPhamVaDichVu() {
		return _listSanPhamVaDichVus;
	}
	public List<SanPhamVaDichVu> getListSanPhamVaDichVu_active() {
		return _listSanPhamVaDichVus_active;
	}
	public List<SanPhamVaDichVu> getListSanPhamVaDichVu_inactive() {
		return _listSanPhamVaDichVus_inactive;
	}

	public int getMaxID() {
		return maxID;
	}
	
	public static void main(String[] args) {
		SanPhamVaDichVuDao sanPhamVaDichVuDao = new SanPhamVaDichVuDao();
		sanPhamVaDichVuDao.updateListSanPhamVaDichVu();
		System.out.println(sanPhamVaDichVuDao.getListSanPhamVaDichVu().get(0).getNhomSPVaDichVu().toString());
	}
	
}


