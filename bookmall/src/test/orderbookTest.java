package test;

import java.util.List;

import dao.orderbookDao;
import vo.orderbookVo;

public class orderbookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      insertTest(); 
	}

	public static void insertTest() {
		orderbookVo vo = new orderbookVo();
		orderbookDao dao = new orderbookDao();
		
		vo.setOrder_no(1);
		vo.setBook_no(1);
		vo.setCount(1);
		vo.setOrderBP(17000);
		
		dao.insert(vo);
		
	}
	
	public static void getListTest() {
		orderbookDao dao = new orderbookDao();
		
		List<orderbookVo>list = dao.getList();
		
		for(orderbookVo vo : list) {
			System.out.println(vo);
		}
	}
	
}
