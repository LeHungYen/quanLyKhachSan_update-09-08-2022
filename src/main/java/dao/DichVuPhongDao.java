package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.DichVuPhong;
import utils.DB_Connection;

public class DichVuPhongDao{
private ArrayList<DichVuPhong> _listDichVuPhongs = new ArrayList<DichVuPhong>();
	
	public void them_sua(DichVuPhong DichVuPhong) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(DichVuPhong);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListDichVuPhong() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from DichVuPhong");
		query.addEntity(DichVuPhong.class);
		_listDichVuPhongs = (ArrayList<DichVuPhong>) query.list();
		session.getTransaction().commit();
		session.close();
		
	}

	public ArrayList<DichVuPhong> getListDichVuPhong() {
		return _listDichVuPhongs;
	}
}
