package com.bridgelabz.hibApp.DAO;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.bridgelabz.hibApp.DTO.DemoDto;

public class DemoDao {

	public void save(DemoDto demodto) {
		System.out.println("Saving dto");
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(demodto);
		tx.commit();
		session.close();
		factory.close();
	}

	public void update(Integer ID, String Brand) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			DemoDto demodto = (DemoDto) session.get(DemoDto.class, ID);
			demodto.setBrand(Brand);
			session.update(demodto);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void display() {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM DemoDto").list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				DemoDto demodto = (DemoDto) iterator.next();
				System.out.print("id     :" + demodto.getMid()+" ");
				System.out.print("brand  :" + demodto.getBrand()+" ");
				System.out.print("price  :" + demodto.getPrice()+" ");
				System.out.println("color :" + demodto.getColor()+" ");

			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void delete(Integer ID) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			DemoDto demodto = (DemoDto) session.get(DemoDto.class, ID);
			session.delete(demodto);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
