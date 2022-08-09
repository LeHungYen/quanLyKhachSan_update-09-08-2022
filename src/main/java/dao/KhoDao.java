package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entities.Kho;
import entities.NhanVien;
import entities.PhieuKiemKho;
import entities.PhieuNhapKho;
import entities.SanPhamVaDichVu;
import utils.DB_Connection;

public class KhoDao{
	private List<Kho> _listKhos = new ArrayList<Kho>();
	private List<Kho> _listKhos_active = new ArrayList<Kho>();
	private List<Kho> _listKhos_inactive = new ArrayList<Kho>();
	
	public void them_sua(Kho kho) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(kho);
		session.getTransaction().commit();
		session.close();
	}
	public void them(Kho kho) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.save(kho);
		session.getTransaction().commit();
		session.close();
	}
	public void sua(Kho kho) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.update(kho);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListKho() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from Kho");
		query.addEntity(Kho.class);
		_listKhos = (ArrayList<Kho>) query.list();
		session.getTransaction().commit();
		session.close();
	}
	public void updateListKho(String trangThai) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from Kho where trangThai = '"+trangThai+"'" );
		query.addEntity(Kho.class);
		if(trangThai.equals("Hoat Dong")) {
			_listKhos_active = (ArrayList<Kho>) query.list();
		}else {
			_listKhos_inactive = (ArrayList<Kho>) query.list();
		}
		session.getTransaction().commit();
		session.close();
		
	}

	
	public List<Kho> getListKho() {
		return _listKhos;
	}
	public List<Kho> getListKho_active() {
		return _listKhos_active;
	}
	public List<Kho> getListKho_inactive() {
		return _listKhos_inactive;
	}
	
}