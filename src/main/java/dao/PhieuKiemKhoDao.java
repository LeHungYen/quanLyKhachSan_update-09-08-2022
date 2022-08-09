package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.PhieuKiemKho;
import entities.PhieuNhapKho;
import utils.DB_Connection;

public class PhieuKiemKhoDao{
private static ArrayList<PhieuKiemKho> _listPhieuKiemKhos = new ArrayList<PhieuKiemKho>();
private int maxID;
	
	public void them_sua(PhieuKiemKho phieuKiemKho) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.save(phieuKiemKho);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListPhieuKiemKho() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from PhieuKiemKho");
		query.addEntity(PhieuKiemKho.class);
		_listPhieuKiemKhos = (ArrayList<PhieuKiemKho>) query.list();
		session.getTransaction().commit();
		session.close();
		getMaxID(_listPhieuKiemKhos);
	}

	public void getMaxID(List<PhieuKiemKho> listPKK) {
		if(listPKK.size()==0) {
			maxID =1;
		}else {
			maxID = listPKK.get(listPKK.size()-1).getMaKiemKho();
			maxID++;
		}
	}
	
	public int getMaxID() {
		return maxID;
	}
	
	public ArrayList<PhieuKiemKho> getListPhieuKiemKho() {
		return _listPhieuKiemKhos;
	}
}