package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.Tang;
import utils.DB_Connection;

public class TangDao{
	private ArrayList<Tang> _listTangs = new ArrayList<Tang>();
	
	public void them_sua(Tang Tang) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(Tang);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListTang() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from Tang");
		query.addEntity(Tang.class);
		_listTangs = (ArrayList<Tang>) query.list();
		session.getTransaction().commit();
		session.close();
		
	}

	public ArrayList<Tang> getListTang() {
		return _listTangs;
	}
}
