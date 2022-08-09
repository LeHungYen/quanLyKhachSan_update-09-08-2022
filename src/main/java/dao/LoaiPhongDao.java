package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.LoaiPhong;
import utils.DB_Connection;

public class LoaiPhongDao{
private ArrayList<LoaiPhong> _listLoaiPhongs = new ArrayList<LoaiPhong>();
	
	public void them_sua(LoaiPhong LoaiPhong) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(LoaiPhong);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListLoaiPhong() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from LoaiPhong");
		query.addEntity(LoaiPhong.class);
		_listLoaiPhongs = (ArrayList<LoaiPhong>) query.list();
		session.getTransaction().commit();
		session.close();
		
	}

	public ArrayList<LoaiPhong> getListLoaiPhong() {
		return _listLoaiPhongs;
	}
}
