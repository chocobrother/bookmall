package vo;

public class orderbookVo {

	private int order_no;
	private int book_no;
	private int count;
	private int orderBP;
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getOrderBP() {
		return orderBP;
	}
	public void setOrderBP(int orderBP) {
		this.orderBP = orderBP;
	}
	
	@Override
	public String toString() {
		return "orderbookVo [order_no=" + order_no + ", book_no=" + book_no + ", count=" + count + ", orderBP="
				+ orderBP*count + "]";
	}
	
	
	
	
	
	
}
