package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.DichVuPhong;
import entities.DonViChiTiet;
import entities.PhieuNhapKhoChiTiet;
import entities.SanPhamVaDichVu;
import utils.DB_Connection;

public class DonViChiTietDao{
	private static List<DonViChiTiet> _listDonViChiTiets = new ArrayList<DonViChiTiet>();
	private int maxID;
	
	public void them_sua(DonViChiTiet donViChiTiet) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(donViChiTiet);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListDonViChiTiet() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from DonViChiTiet");
		query.addEntity(DonViChiTiet.class);
		_listDonViChiTiets = (ArrayList<DonViChiTiet>) query.list();
		session.getTransaction().commit();
		session.close();
		getMaxID(_listDonViChiTiets);
	}
	
	public void getMaxID(List<DonViChiTiet> listDonViChiTiet) {
		if(listDonViChiTiet.size()==0) {
			maxID =1;
		}else {
			maxID = listDonViChiTiet.get(listDonViChiTiet.size()-1).getMaDonViChiTiet();
			maxID++;
		}
	}

	public List<DonViChiTiet> getListDonViChiTiet() {
		return _listDonViChiTiets;
	}
	public int getMaxID() {
		return maxID;
	}
	
}
