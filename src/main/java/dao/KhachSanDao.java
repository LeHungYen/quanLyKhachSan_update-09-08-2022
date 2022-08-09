package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.KhachSan;
import utils.DB_Connection;

public class KhachSanDao{
	private ArrayList<KhachSan> _listKhachSans = new ArrayList<KhachSan>();

	public void them_sua(KhachSan KhachSan) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(KhachSan);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListKhachSan() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from KhachSan");
		query.addEntity(KhachSan.class);
		_listKhachSans = (ArrayList<KhachSan>) query.list();
		session.getTransaction().commit();
		session.close();

	}

	public ArrayList<KhachSan> getListKhachSan() {
		return _listKhachSans;
	}
}
