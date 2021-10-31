package com.secure.mvvm_retrofit_example.models;

import java.util.List;

public class QuoteList{
	private int count;
	private int totalPages;
	private int lastItemIndex;
	private int page;
	private int totalCount;
	private List<ResultsItem> results;

	public QuoteList(int count, int totalPages, int lastItemIndex, List<ResultsItem> results, int page, int totalCount) {
		this.count = count;
		this.totalPages = totalPages;
		this.lastItemIndex = lastItemIndex;
		this.results = results;
		this.page = page;
		this.totalCount = totalCount;
	}

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