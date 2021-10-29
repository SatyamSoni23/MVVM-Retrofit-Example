package com.secure.mvvm_retrofit_example.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.secure.mvvm_retrofit_example.models.QuoteList;
import com.secure.mvvm_retrofit_example.repository.QuoteRepository;

public class MainViewModel extends ViewModel {
    private QuoteRepository quoteRepository;
    public MainViewModel(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
        quoteRepository.getQuotes(1);
    }

//    public LiveData<QuoteList> quotes = get();
//    private LiveData<QuoteList> get(){
//        return quoteRepository.quotes;
//    }
}
