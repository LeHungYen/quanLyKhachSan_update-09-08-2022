package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entities.ChucVu;
import entities.DichVuPhong;
import entities.DonViChiTiet;
import entities.DonViTinh;
import entities.History;
import entities.HoaDon;
import entities.KhachHang;
import entities.KhachSan;
import entities.KhachTrongPhong;
import entities.Kho;
import entities.LoaiPhong;
import entities.NhanVien;
import entities.NhomSPVaDichVu;
import entities.PhieuKiemKho;
import entities.PhieuKiemKhoChiTiet;
import entities.PhieuNhapKho;
import entities.PhieuNhapKhoChiTiet;
import entities.Phong;
import entities.Quyen;
import entities.Quyen_cv;
import entities.SanPhamVaDichVu;
import entities.Tang;

public class DB_Connection {
	public static Session getSession(Configuration configuration) {
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		return session;
	}

	public static Session getSession() {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(ChucVu.class)
				.addAnnotatedClass(Quyen.class).addAnnotatedClass(Quyen_cv.class).addAnnotatedClass(KhachSan.class)
				.addAnnotatedClass(Tang.class).addAnnotatedClass(Phong.class).addAnnotatedClass(LoaiPhong.class)
				.addAnnotatedClass(KhachTrongPhong.class).addAnnotatedClass(HoaDon.class)
				.addAnnotatedClass(History.class).addAnnotatedClass(NhanVien.class).addAnnotatedClass(KhachHang.class)
				.addAnnotatedClass(PhieuNhapKho.class).addAnnotatedClass(PhieuKiemKho.class)
				.addAnnotatedClass(PhieuKiemKhoChiTiet.class).addAnnotatedClass(PhieuNhapKhoChiTiet.class)
				.addAnnotatedClass(SanPhamVaDichVu.class).addAnnotatedClass(Kho.class)
				.addAnnotatedClass(NhomSPVaDichVu.class).addAnnotatedClass(DonViTinh.class)
				.addAnnotatedClass(DonViChiTiet.class).addAnnotatedClass(DichVuPhong.class);
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		return session;
	}

}
