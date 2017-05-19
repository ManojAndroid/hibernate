package com.bridgelabz.hibcriteriaApp.Dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.bridgelabz.hibcriteriaApp.Dto.MobileDto;
import com.manoj.hib.util.HibernateUtil;

public class MobileDao {
	public MobileDao() {

	}

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction transaction = session.beginTransaction();

	public void save(MobileDto mobileDto) {

		session.persist(mobileDto);
		transaction.commit();
		System.out.println("sucessfilly inserted");
	}

	public void display() {
		System.out.println("intered in display");
		List list = session.createCriteria(MobileDto.class).add(Restrictions.gt("price", 30000.0)).list();
		for (Iterator it = list.iterator(); it.hasNext();) {
			MobileDto demodto = (MobileDto) it.next();
			System.out.print("id     :" + demodto.getId() + " ");
			System.out.print("brand  :" + demodto.getBrand() + " ");
			System.out.print("price  :" + demodto.getPrice() + " ");
			System.out.println("color :" + demodto.getColor() + " ");
		}
	}
		public void displayByName() {
			System.out.println("intered in displayByName");
			List list = session.createCriteria(MobileDto.class).add(Restrictions.like("brand","M%")).list();
			for (Iterator it = list.iterator(); it.hasNext();) {
				MobileDto demodto = (MobileDto) it.next();
				System.out.print("id     :" + demodto.getId() + " ");
				System.out.print("brand  :" + demodto.getBrand() + " ");
				System.out.print("price  :" + demodto.getPrice() + " ");
				System.out.println("color :" + demodto.getColor() + " ");
			}

	}
		public void displayByRange() {
			
			System.out.println("intered in displayByRange");
			List list = session.createCriteria(MobileDto.class).add(Restrictions.between("price", 20000.0, 100000.00)).list();
			for (Iterator it = list.iterator(); it.hasNext();) {
				MobileDto demodto = (MobileDto) it.next();
				System.out.print("id     :" + demodto.getId() + " ");
				System.out.print("brand  :" + demodto.getBrand() + " ");
				System.out.print("price  :" + demodto.getPrice() + " ");
				System.out.println("color :" + demodto.getColor() + " ");
			}
	}
public void displayByDecending() {
			
			System.out.println("intered in displayDescebding");
			List list = session.createCriteria(MobileDto.class).addOrder( Order.desc("price") ).list();
			for (Iterator it = list.iterator(); it.hasNext();) {
				MobileDto demodto = (MobileDto) it.next();
				System.out.print("id     :" + demodto.getId() + " ");
				System.out.print("brand  :" + demodto.getBrand() + " ");
				System.out.print("price  :" + demodto.getPrice() + " ");
				System.out.println("color :" + demodto.getColor() + " ");
			}

	}
public void displayByAscending() {
	
	System.out.println("intered in displayAscebding");
	List list = session.createCriteria(MobileDto.class).addOrder( Order.asc("price") ).list();
	for (Iterator it = list.iterator(); it.hasNext();) {
		MobileDto demodto = (MobileDto) it.next();
		System.out.print("id     :" + demodto.getId() + " ");
		System.out.print("brand  :" + demodto.getBrand() + " ");
		System.out.print("price  :" + demodto.getPrice() + " ");
		System.out.println("color :" + demodto.getColor() + " ");
	}

}
}
