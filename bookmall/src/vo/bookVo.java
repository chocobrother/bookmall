package vo;

public class bookVo {
	private Long no;
	private String bookName;
	private int price;
	private int cate_no;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCate_no() {
		return cate_no;
	}
	public void setCate_no(int cate_no) {
		this.cate_no = cate_no;
	}
	@Override
	public String toString() {
		return "bookVo [no=" + no + ", bookName=" + bookName + ", price=" + price + ", cate_no=" + cate_no + "]";
	}
	
	
	
}
