package com.jeferson.workshopmongo.models.embedded;

import java.time.Instant;

public class Comment {

	private String title;
	private Instant moment;
	private Author author;
	
	public Comment() {}

	public Comment(String title, Instant moment, Author author) {

		this.title = title;
		this.moment = moment;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
