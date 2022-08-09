package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.Quyen;
import utils.DB_Connection;

public class QuyenDao{
private ArrayList<Quyen> _listQuyens = new ArrayList<Quyen>();
	
	public void them_sua(Quyen Quyen) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(Quyen);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListQuyen() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from Quyen");
		query.addEntity(Quyen.class);
		_listQuyens = (ArrayList<Quyen>) query.list();
		session.getTransaction().commit();
		session.close();
		
	}

	public ArrayList<Quyen> getListQuyen() {
		return _listQuyens;
	}
}
