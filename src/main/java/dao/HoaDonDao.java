package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.HoaDon;
import utils.DB_Connection;

public class HoaDonDao{
private ArrayList<HoaDon> _listHoaDons = new ArrayList<HoaDon>();
	
	public void them_sua(HoaDon HoaDon) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(HoaDon);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListHoaDon() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from HoaDon");
		query.addEntity(HoaDon.class);
		_listHoaDons = (ArrayList<HoaDon>) query.list();
		session.getTransaction().commit();
		session.close();
		
	}

	public ArrayList<HoaDon> getListHoaDon() {
		return _listHoaDons;
	}
}
