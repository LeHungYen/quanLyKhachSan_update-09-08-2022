package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.NhomSPVaDichVu;
import utils.DB_Connection;

public class NhomSPVaDichVuDao{
private static List<NhomSPVaDichVu> _listNhomSPVaDichVus = new ArrayList<NhomSPVaDichVu>();
private static List<NhomSPVaDichVu> _listNhomSPVaDichVus_active = new ArrayList<NhomSPVaDichVu>();
private static List<NhomSPVaDichVu> _listNhomSPVaDichVus_inactive = new ArrayList<NhomSPVaDichVu>();
	
	public void them_sua(NhomSPVaDichVu nhomSPVaDichVu) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(nhomSPVaDichVu);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListNhomSPVaDichVu() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from NhomSPVaDichVu");
		query.addEntity(NhomSPVaDichVu.class);
		_listNhomSPVaDichVus = (ArrayList<NhomSPVaDichVu>) query.list();
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void updateListNhomSPVaDichVu(String trangThai) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from NhomSPVaDichVu where trangThai = '"+trangThai+"'");
		query.addEntity(NhomSPVaDichVu.class);
		if(trangThai.equals("Hoat Dong")) {
			_listNhomSPVaDichVus_active = (ArrayList<NhomSPVaDichVu>) query.list();
		}else {
			_listNhomSPVaDichVus_inactive = (ArrayList<NhomSPVaDichVu>) query.list();
		}
		session.getTransaction().commit();
		session.close();
		
	}

	public List<NhomSPVaDichVu> getListNhomSPVaDichVu() {
		return _listNhomSPVaDichVus;
	}
	public List<NhomSPVaDichVu> getListNhomSPVaDichVu_active() {
		return _listNhomSPVaDichVus_active;
	}
	public List<NhomSPVaDichVu> getListNhomSPVaDichVu_inactive() {
		return _listNhomSPVaDichVus_inactive;
	}
}