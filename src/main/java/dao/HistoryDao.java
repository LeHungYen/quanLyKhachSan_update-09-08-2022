package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.History;
import utils.DB_Connection;

public class HistoryDao{
	private ArrayList<History> _listHistorys = new ArrayList<History>();
	
	public void them_sua(History History) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(History);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListHistory() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from History");
		query.addEntity(History.class);
		_listHistorys = (ArrayList<History>) query.list();
		session.getTransaction().commit();
		session.close();
		
	}

	public ArrayList<History> getListHistory() {
		return _listHistorys;
	}
}
