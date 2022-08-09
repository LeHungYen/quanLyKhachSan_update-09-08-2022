package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.PhieuNhapKhoChiTiet;
import utils.DB_Connection;

public class PhieuNhapKhoChiTietDao{
	private static ArrayList<PhieuNhapKhoChiTiet> _listPhieuNhapKhoChiTiets = new ArrayList<PhieuNhapKhoChiTiet>();
	public void them_sua(PhieuNhapKhoChiTiet phieuNhapKhoChiTiet) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.save(phieuNhapKhoChiTiet);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListPhieuNhapKhoChiTiet() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from PhieuNhapKhoChiTiet");
		query.addEntity(PhieuNhapKhoChiTiet.class);
		ArrayList<PhieuNhapKhoChiTiet> listPhieuNhapKhoChiTiet = (ArrayList<PhieuNhapKhoChiTiet>) query.list();
		session.getTransaction().commit();
		session.close();
	}
	

	public ArrayList<PhieuNhapKhoChiTiet> getListPhieuNhapKhoChiTiet() {
		return _listPhieuNhapKhoChiTiets;
	}


}