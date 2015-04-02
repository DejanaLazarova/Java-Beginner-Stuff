

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookDao {
	
	@Id 
	@GeneratedValue
	private Long id;
	@Column(name = "isbn")
	private String isbn;
	@Column(name = "title")
	private String title;
	
	public BookDao(){}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
