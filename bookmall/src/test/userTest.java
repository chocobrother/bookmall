package test;

import java.util.List;

import dao.userDao;
import vo.userVo;

public class userTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//insertTest();
		getListTest();
		
	}
	
	
	public static void insertTest() {
		userDao dao = new userDao();
		
		userVo vo = new userVo();
		
		vo.setName("차주환");
		vo.setPhone("010-2956-0852");
		vo.setEmail("ngcps2@naver.com");
		vo.setPasswd("juhwan");
		dao.insert(vo);
		
	}
	
	public static void getListTest() {
		userDao dao = new userDao();
		
		List<userVo> list = dao.getList();
		
		for( userVo vo : list) {
			System.out.println( vo );
		}
	}
	

}
