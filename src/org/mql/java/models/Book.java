package org.mql.java.models;

import java.util.ArrayList;

public class Book {
	private String name;
    private String publisher;
    private ArrayList<Person> authors;

    public Book(String name, String publisher, ArrayList<Person> authors) {
	super();
	this.name = name;
	this.publisher = publisher;
	this.authors = authors;
    }

	public ArrayList<Person> getAuthors() {
        return this.authors;
    }

    public void addAuthor(Person author) {
        this.authors.add(author);
    }

}
