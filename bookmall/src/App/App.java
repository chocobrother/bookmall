package App;

import test.bookTest;
import test.buyTest;
import test.cartTest;
import test.categoryTest;
import test.orderbookTest;
import test.userTest;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("****************************");
		System.out.println("***********회원 리스트*********");
		
		userTest.getListTest();
		
		System.out.println("****************************");
		System.out.println("*********카테고리 리스트*********");
		
		categoryTest.getListTest();
		
		System.out.println("****************************");
		System.out.println("***********카트  리스트*********");
		
		cartTest.getListTest();
		
		System.out.println("****************************");
		System.out.println("***********상품  리스트*********");
		
		bookTest.getListTest();
		
		System.out.println("****************************");
		System.out.println("***********주문  리스트*********");
		
		buyTest.getListTest();
		
		System.out.println("****************************");
		System.out.println("***********주문 도서  리스트*********");
		
		orderbookTest.getListTest();
		
	}

}
