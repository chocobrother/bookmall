package test;

import java.util.List;

import dao.cartDao;
import vo.cartVo;

public class cartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertTest(); 
//		getListTest();
	
}


public static void insertTest() {
	cartDao dao = new cartDao();
	
	cartVo vo = new cartVo();
	
	
	vo.setUser_id(1);
	vo.setBook_id(1);
	vo.setCartPrice(17000);
	
	dao.insert(vo);
	
}

public static void getListTest() {
	cartDao dao = new cartDao();
	
	List<cartVo> list = dao.getList();
	
	for( cartVo vo : list) {
		System.out.println( vo );
	}
}


}