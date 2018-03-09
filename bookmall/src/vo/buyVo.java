package vo;

public class buyVo {

	private Long no;
	private int orderNo;
	private int orderPrice;
	private String home;
	private String orderday;
	private int user_no;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getOrderday() {
		return orderday;
	}
	public void setOrderday(String orderday) {
		this.orderday = orderday;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	
	@Override
	public String toString() {
		return "번호 " + no + ", 주문 번호 =" + orderNo + ", 주문 가격=" + orderPrice + ", home=" + home
				+ ", orderday=" + orderday + ", user_no=" + user_no + "]";
	}
	
	
	
	
}
