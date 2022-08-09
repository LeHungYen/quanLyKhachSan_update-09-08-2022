package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.ChucVu;
import utils.DB_Connection;

public class ChucVuDao{
private static ArrayList<ChucVu> _listChucVus = new ArrayList<ChucVu>();
	
	public void them_sua(ChucVu chucVu) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(chucVu);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListChucVu() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from chucVu");
		query.addEntity(ChucVu.class);
		_listChucVus = (ArrayList<ChucVu>) query.list();
		session.getTransaction().commit();
		session.close();
		
	}

	public ArrayList<ChucVu> getListChucVu() {
		return _listChucVus;
	}
	
	public static void main(String[] args) {
		ChucVu chucVu = new ChucVu(0,"Quản lý", "Hoat Dong", null, null);
		ChucVuDao cvd = new ChucVuDao();
		cvd.them_sua(chucVu);
	}
}
