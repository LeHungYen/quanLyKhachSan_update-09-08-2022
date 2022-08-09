package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.KhachHang;
import utils.DB_Connection;

public class KhachHangDao{
private ArrayList<KhachHang> _listKhachHangs = new ArrayList<KhachHang>();
	
	public void them_sua(KhachHang KhachHang) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(KhachHang);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListKhachHang() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from KhachHang");
		query.addEntity(KhachHang.class);
		_listKhachHangs = (ArrayList<KhachHang>) query.list();
		session.getTransaction().commit();
		session.close();
		
	}

	public ArrayList<KhachHang> getListKhachHang() {
		return _listKhachHangs;
	}
}
