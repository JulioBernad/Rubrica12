package es.salesianos.edu.model;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {

	private String nameBook;
	private String isbn;
	private String nameAuthor;
	
	public String getNameBook() {
		return nameBook;
	}
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getNameAuthor() {
		return nameAuthor;
	}
	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}


}
