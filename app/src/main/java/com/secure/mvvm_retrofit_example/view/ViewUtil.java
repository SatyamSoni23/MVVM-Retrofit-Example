package com.secure.mvvm_retrofit_example.view;

import com.secure.mvvm_retrofit_example.models.ResultsItem;

import java.util.List;

public class ViewUtil {
    private int index = 0;
    private List<ResultsItem> resultsItem;

    public ViewUtil(int index, List<ResultsItem> resultsItem){
        this.index = index;
        this.resultsItem = resultsItem;
    }

    public ResultsItem getQuote(){
        return resultsItem.get(index);
    }

    public ResultsItem nextQuote(){
        int size = resultsItem.size();
        index = (index+1)%size;
        return resultsItem.get(index);
    }

    public ResultsItem previousQuote(){
        int size = resultsItem.size();
        index = (size + (index - 1)) % size;
        return resultsItem.get(index);
    }
}
