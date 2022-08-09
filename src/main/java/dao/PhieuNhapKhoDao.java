package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.PhieuNhapKho;
import entities.SanPhamVaDichVu;
import utils.DB_Connection;

public class PhieuNhapKhoDao{
private static ArrayList<PhieuNhapKho> _listPhieuNhapKhos = new ArrayList<PhieuNhapKho>();
	private int maxID;
	
	public void them_sua(PhieuNhapKho phieuNhapKho) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.save(phieuNhapKho);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListPhieuNhapKho() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from PhieuNhapKho");
		query.addEntity(PhieuNhapKho.class);
		_listPhieuNhapKhos = (ArrayList<PhieuNhapKho>) query.list();
		session.getTransaction().commit();
		session.close();
		getMaxID(_listPhieuNhapKhos);
	}
	
	public void getMaxID(List<PhieuNhapKho> listPNK) {
		if(listPNK.size()==0) {
			maxID =1;
		}else {
			maxID = listPNK.get(listPNK.size()-1).getMaNhap();
			maxID++;
		}
	}
	
	public ArrayList<PhieuNhapKho> getListPhieuNhapKho() {
		return _listPhieuNhapKhos;
	}
	
	public int getMaxID() {
		return maxID;
	}
}