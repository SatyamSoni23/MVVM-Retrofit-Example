package com.secure.mvvm_retrofit_example.models;

import java.util.List;

public class QuoteList{
	private int count;
	private int totalPages;
	private int lastItemIndex;
	private int page;
	private int totalCount;
	private List<ResultsItem> results;

	public int getCount(){
		return count;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public int getLastItemIndex(){
		return lastItemIndex;
	}

	public int getPage(){
		return page;
	}

	public int getTotalCount(){
		return totalCount;
	}

	public List<ResultsItem> getResults(){
		return results;
	}
}