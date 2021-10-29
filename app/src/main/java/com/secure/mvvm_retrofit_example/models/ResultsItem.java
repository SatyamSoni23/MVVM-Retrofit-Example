package com.secure.mvvm_retrofit_example.models;

import java.util.List;

public class ResultsItem{
	private String authorSlug;
	private String author;
	private int length;
	private String dateModified;
	private String id;
	private String content;
	private String dateAdded;
	private List<String> tags;

	public String getAuthorSlug(){
		return authorSlug;
	}

	public String getAuthor(){
		return author;
	}

	public int getLength(){
		return length;
	}

	public String getDateModified(){
		return dateModified;
	}

	public String getId(){
		return id;
	}

	public String getContent(){
		return content;
	}

	public String getDateAdded(){
		return dateAdded;
	}

	public List<String> getTags(){
		return tags;
	}
}