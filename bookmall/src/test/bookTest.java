package test;

import java.util.List;

import dao.bookDao;
import vo.bookVo;

public class bookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertTest();
//	getListTest();
	
}


public static void insertTest() {
	bookDao dao = new bookDao();
	
	bookVo vo = new bookVo();
	
	vo.setBookName("삼국지");
	vo.setPrice(30000);
	vo.setCate_no(2);
	
	dao.insert(vo);
	
}

public static void getListTest() {
	bookDao dao = new bookDao();
	
	List<bookVo> list = dao.getList();
	
	for( bookVo vo : list) {
		System.out.println( vo );
	}
}


}
