package test;

import java.util.List;

import dao.categoryDao;
import vo.categoryVo;

public class categoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertTest();
//	getListTest();
	
}


public static void insertTest() {
	categoryDao dao = new categoryDao();
	
	categoryVo vo = new categoryVo();
	
	vo.setNo(2);
	vo.setCateName("소설");
//	vo.setCate_no(1);
	
	dao.insert(vo);
	
}

public static void getListTest() {
	categoryDao dao = new categoryDao();
	
	List<categoryVo> list = dao.getList();
	
	for( categoryVo vo : list) {
		System.out.println( vo );
	}
}


}
