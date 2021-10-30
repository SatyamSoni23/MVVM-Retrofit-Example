package com.secure.mvvm_retrofit_example.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "quote")
public class ResultsItem{

	@PrimaryKey(autoGenerate = true)
	private int quoteId;

	private String authorSlug;
	private String author;
	private int length;
	private String dateModified;
	private String id;
	private String content;
	private String dateAdded;

	public ResultsItem(int quoteId, String authorSlug, String author, int length, String dateModified, String id, String content, String dateAdded){
		this.quoteId = quoteId;
		this.authorSlug = authorSlug;
		this.author = author;
		this.length = length;
		this.dateModified = dateModified;
		this.id = id;
		this.content = content;
		this.dateAdded = dateAdded;
	}

	public int getQuoteId(){
		return quoteId;
	}

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
}