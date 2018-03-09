package test;

import java.util.List;

import dao.buyDao;
import vo.buyVo;

public class buyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insertTest();
 		getListTest();
	
}


public static void insertTest() {
	buyDao dao = new buyDao();
	
	buyVo vo = new buyVo();
	
	vo.setOrderNo(1);
    vo.setOrderPrice(17000);
    vo.setHome("서울시 은평구 불광동");
    vo.setOrderday("2018-03-08");
    vo.setUser_no(1);
    
	dao.insert(vo);
	
}

public static void getListTest() {
	buyDao dao = new buyDao();
	
	List<buyVo> list = dao.getList();
	
	for( buyVo vo : list) {
		System.out.println( vo );
	}
}


}