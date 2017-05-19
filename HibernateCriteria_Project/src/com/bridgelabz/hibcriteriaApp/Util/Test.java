package com.bridgelabz.hibcriteriaApp.Util;

import com.bridgelabz.hibcriteriaApp.Dao.MobileDao;
import com.bridgelabz.hibcriteriaApp.Dto.MobileDto;

public class Test {

	public static void main(String[] args) {

		MobileDto mobileDto = new MobileDto();
		mobileDto.setBrand("soney1");
		mobileDto.setColor("black");
		mobileDto.setPrice(144444);
		MobileDao dao = new MobileDao();
		
		dao.display();
		System.out.println("****************");
		dao.displayByName();
		System.out.println("****************");
		dao.displayByRange();
		System.out.println("****************");
		dao.displayByDecending();
		System.out.println("****************");
		dao.displayByAscending();
	}

}
