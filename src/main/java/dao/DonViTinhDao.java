package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.DonViChiTiet;
import entities.DonViTinh;
import utils.DB_Connection;

public class DonViTinhDao{
	private static ArrayList<DonViTinh> _listDonViTinhs = new ArrayList<DonViTinh>();
	private static ArrayList<DonViTinh> _listDonViTinhs_active = new ArrayList<DonViTinh>();
	private static ArrayList<DonViTinh> _listDonViTinhs_inactive = new ArrayList<DonViTinh>();
	public void them_sua(DonViTinh donViTinh) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(donViTinh);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListDonViTinh() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from DonViTinh");
		query.addEntity(DonViTinh.class);
		_listDonViTinhs = (ArrayList<DonViTinh>) query.list();
		session.getTransaction().commit();
		session.close();
		
	}
	public void updateListDonViTinh_active() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from DonViTinh where trangThai = 'Hoat Dong'");
		query.addEntity(DonViTinh.class);
		_listDonViTinhs_active = (ArrayList<DonViTinh>) query.list();
		session.getTransaction().commit();
		session.close();
		
	}
	public void updateListDonViTinh_inactive() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from DonViTinh where trangThai = 'Khong Hoat Dong'");
		query.addEntity(DonViTinh.class);
		_listDonViTinhs_inactive = (ArrayList<DonViTinh>) query.list();
		session.getTransaction().commit();
		session.close();
		
	}

	public ArrayList<DonViTinh> getListDonViTinh() {
		return _listDonViTinhs;
	}
	public ArrayList<DonViTinh> getListDonViTinh_active() {
		return _listDonViTinhs_active;
	}
	public ArrayList<DonViTinh> getListDonViTinh_inactive() {
		return _listDonViTinhs_inactive;
	}
	
}