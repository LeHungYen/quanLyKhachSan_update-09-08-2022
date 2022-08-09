package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.Phong;
import utils.DB_Connection;

public class PhongDao {
	private ArrayList<Phong> _listPhongs = new ArrayList<Phong>();

	public void them_sua(Phong Phong) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(Phong);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListPhong() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from Phong");
		query.addEntity(Phong.class);
		_listPhongs = (ArrayList<Phong>) query.list();
		session.getTransaction().commit();
		session.close();

	}

	public ArrayList<Phong> getListPhong() {
		return _listPhongs;
	}
}
