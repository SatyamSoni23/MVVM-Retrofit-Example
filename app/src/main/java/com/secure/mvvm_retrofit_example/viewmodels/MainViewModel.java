package com.secure.mvvm_retrofit_example.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.secure.mvvm_retrofit_example.models.QuoteList;
import com.secure.mvvm_retrofit_example.repository.QuoteRepository;

public class MainViewModel extends ViewModel {
    private QuoteRepository quoteRepository;
    public MainViewModel(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
    }

    //public LiveData<QuoteList> quotes = get();
    public LiveData<QuoteList> quotes(){
        quoteRepository.getQuotes(1);
        return quoteRepository.quotes;
    }


}
