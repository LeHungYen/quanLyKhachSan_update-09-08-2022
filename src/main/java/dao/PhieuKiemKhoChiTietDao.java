package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.PhieuKiemKhoChiTiet;
import utils.DB_Connection;

public class PhieuKiemKhoChiTietDao{
private static ArrayList<PhieuKiemKhoChiTiet> _listPhieuKiemKhoChiTiets = new ArrayList<PhieuKiemKhoChiTiet>();
	
	public void them_sua(PhieuKiemKhoChiTiet phieuKiemKhoChiTiet) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.save(phieuKiemKhoChiTiet);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListPhieuKiemKhoChiTiet() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from PhieuKiemKhoChiTiet");
		query.addEntity(PhieuKiemKhoChiTiet.class);
		_listPhieuKiemKhoChiTiets = (ArrayList<PhieuKiemKhoChiTiet>) query.list();
		session.getTransaction().commit();
		session.close();
		
	}

	public ArrayList<PhieuKiemKhoChiTiet> getListPhieuKiemKhoChiTiet() {
		return _listPhieuKiemKhoChiTiets;
	}
	


}