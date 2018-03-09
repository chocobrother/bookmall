package vo;

public class categoryVo {
	
	private int no;
	private String cateName;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	@Override
	public String toString() {
		return "categoryVo [no=" + no + ", cateName=" + cateName + "]";
	}
	
	
}
