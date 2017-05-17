package com.bridgelabz.hibApp.UTIL;

import com.bridgelabz.hibApp.DAO.DemoDao;
import com.bridgelabz.hibApp.DTO.DemoDto;

public class testerinsert {

	public static void main(String[] args)
	{
		DemoDto dt = new DemoDto();
		dt.setBrand("samsung");
		dt.setPrice(3000.00);
		dt.setColor("silver");
		
		DemoDto dt2 = new DemoDto();
		dt2.setBrand("Micromax");
		dt2.setPrice(3222.00);
		dt2.setColor("green");
		
		DemoDao dao = new DemoDao();
		dao.displaySingle(12);
		/*dao.save(dt);*/
		/*DemoDao dao1 = new DemoDao();
		dao1.save(dt2);*/
		/*dao1.displaySingle(6);*/
		
		/*dao1.update(3,"nova");
		dao1.delete(1);
		dao1.display();*/
	}
}
