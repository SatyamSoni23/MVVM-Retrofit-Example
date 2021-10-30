package com.secure.mvvm_retrofit_example.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.secure.mvvm_retrofit_example.api.QuoteService;
import com.secure.mvvm_retrofit_example.db.QuoteDatabase;
import com.secure.mvvm_retrofit_example.models.QuoteList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoteRepository {
    private QuoteService quoteService;
    private QuoteDatabase quoteDatabase;

    private MutableLiveData<QuoteList> quotesLiveData = new MutableLiveData<>();

    public QuoteRepository(QuoteService quoteService, QuoteDatabase quoteDatabase){
        this.quoteService = quoteService;
        this.quoteDatabase = quoteDatabase;
    }

    public LiveData<QuoteList> quotes = get();
    private LiveData<QuoteList> get(){
        return quotesLiveData;
    }


    public void getQuotes(int page){
        Call<QuoteList> result = quoteService.getQuotes(page);
        result.enqueue(new Callback<QuoteList>() {
            @Override
            public void onResponse(Call<QuoteList> call, Response<QuoteList> response) {
                if(response != null && response.body() != null){
                    quoteDatabase.quoteDao().addQuotes(response.body().getResults());
                    quotesLiveData.postValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<QuoteList> call, Throwable t) {
                Log.d("Error", t.toString());
            }
        });
    }
}
