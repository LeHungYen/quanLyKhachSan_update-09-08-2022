package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.ChucVu;
import entities.NhanVien;
import utils.DB_Connection;
import utils.IoCContainer;

public class NhanVienDao{
	private static ArrayList<NhanVien> _listNhanViens = new ArrayList<NhanVien>();
	private int maxID;
	public void them_sua(NhanVien nhanVien) {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		session.saveOrUpdate(nhanVien);
		session.getTransaction().commit();
		session.close();
	}

	
	public void updateListNhanVien() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from nhanVien");
		query.addEntity(NhanVien.class);
		_listNhanViens = (ArrayList<NhanVien>) query.list();
		session.getTransaction().commit();
		session.close();
		getMaxID(_listNhanViens);
	}
	public void updateListNhanVien_active() {
		Session session = new DB_Connection().getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from nhanVien where trangthai = 'Hoat Dong'");
		query.addEntity(NhanVien.class);
		_listNhanViens = (ArrayList<NhanVien>) query.list();
		session.getTransaction().commit();
		session.close();
		getMaxID(_listNhanViens);
	}
	
	public void getMaxID(ArrayList<NhanVien> listNhanVien) {
		if(listNhanVien.size()==0) {
			maxID =1;
		}else {
			maxID = Integer.parseInt(listNhanVien.get((listNhanVien.size()-1)).getMaNV());
			maxID++;
		}
	}

	public ArrayList<NhanVien> getListNhanVien() {
		return _listNhanViens;
	}
	
	public int getMaxID() {
		return maxID;
	}


}
