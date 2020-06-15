

public class Tweet {
	private static final long serialVersionUID = 1L;
	public String creationDate;
	public int id;
	public String text;
	
	
	public Tweet(String creationDate, int id, String text) {
		super();
		this.creationDate = creationDate;
		this.id = id;
		this.text = text;
	}
	
	
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
