package com.bridgelabz.hibApp.DAO;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import com.bridgelabz.hibApp.DTO.DemoDto;

public class DemoDao {
	SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
	Session session = factory.openSession();
	Transaction transaction = session.beginTransaction();;

	public void save(DemoDto demodto) {
		session.save(demodto);
		transaction.commit();
		session.close();
		factory.close();
		System.out.println("Data is Inserted");
	}

	public void update(Integer ID, String Brand) {

		DemoDto demodto = (DemoDto) session.get(DemoDto.class, ID);
		demodto.setBrand(Brand);
		session.update(demodto);
		transaction.commit();
		session.close ();
		System.out.println("Data is updated");
	}

	public void display() {

		List list = session.createQuery("FROM DemoDto").list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			DemoDto demodto = (DemoDto) iterator.next();
			System.out.print("id     :" + demodto.getMid() + " ");
			System.out.print("brand  :" + demodto.getBrand() + " ");
			System.out.print("price  :" + demodto.getPrice() + " ");
			System.out.println("color :" + demodto.getColor() + " ");
		}

		session.close();

	}

	public void delete(Integer ID) {
		DemoDto demodto = (DemoDto) session.get(DemoDto.class, ID);
		session.delete(demodto);
		transaction.commit();
		session.close();
		System.out.println("Data is is deleted id"+ID);
	}
	public void displaySingle(int id) {

		List list = session.createQuery("from DemoDto e where e.id="+ id).list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			DemoDto demodto = (DemoDto) iterator.next();
			System.out.print("id     :" + demodto.getMid() + " ");
			System.out.print("brand  :" + demodto.getBrand() + " ");
			System.out.print("price  :" + demodto.getPrice() + " ");
			System.out.println("color :" + demodto.getColor() + " ");
		}

		session.close();

	}

}
