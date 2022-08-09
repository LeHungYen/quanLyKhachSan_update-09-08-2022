package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.Quyen_cv;
import utils.DB_Connection;

public class Quyen_cvDao{
	private ArrayList<Quyen_cv> _listQuyen_cvs = new ArrayList<Quyen_cv>();

	public void them_sua(Quyen_cv Quyen_cv) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(Quyen_cv);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListQuyen_cv() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from Quyen_cv");
		query.addEntity(Quyen_cv.class);
		_listQuyen_cvs = (ArrayList<Quyen_cv>) query.list();
		session.getTransaction().commit();
		session.close();

	}

	public ArrayList<Quyen_cv> getListQuyen_cv() {
		return _listQuyen_cvs;
	}
}
