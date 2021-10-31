package com.secure.mvvm_retrofit_example.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.secure.mvvm_retrofit_example.api.QuoteService;
import com.secure.mvvm_retrofit_example.db.QuoteDatabase;
import com.secure.mvvm_retrofit_example.models.QuoteList;
import com.secure.mvvm_retrofit_example.models.ResultsItem;
import com.secure.mvvm_retrofit_example.utils.NetworkUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoteRepository {
    private QuoteService quoteService;
    private QuoteDatabase quoteDatabase;
    private Context applicationContext;

    private MutableLiveData<QuoteList> quotesLiveData = new MutableLiveData<>();

    public QuoteRepository(QuoteService quoteService, QuoteDatabase quoteDatabase, Context applicationContext){
        this.quoteService = quoteService;
        this.quoteDatabase = quoteDatabase;
        this.applicationContext = applicationContext;
    }

    public LiveData<QuoteList> quotes = get();
    private LiveData<QuoteList> get(){
        return quotesLiveData;
    }


    public void getQuotes(int page){

        if(NetworkUtils.isNetworkAvailable(applicationContext)){
            Call<QuoteList> result = quoteService.getQuotes(page);
            result.enqueue(new Callback<QuoteList>() {
                @Override
                public void onResponse(Call<QuoteList> call, Response<QuoteList> response) {
                    if(response != null && response.body() != null){
                        insertQuote(response);
                        quotesLiveData.postValue(response.body());
                    }
                }
                @Override
                public void onFailure(Call<QuoteList> call, Throwable t) {
                    Log.d("Error", t.toString());
                }
            });
        }
        else{
            insertOfflineQuote();
        }
    }

    private void insertQuote(Response<QuoteList> response){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                quoteDatabase.quoteDao().addQuotes(response.body().getResults());
            }
        });
    }

    private void insertOfflineQuote(){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<ResultsItem> quotes = quoteDatabase.quoteDao().getQuotes();
                QuoteList quoteList = new QuoteList(1, 1, 1, quotes, 1, 1);
                quotesLiveData.postValue(quoteList);
            }
        });
    }

    public void getQuotesBackground(){
        int randomNumber = (int) (Math.random()*10);

        Call<QuoteList> result = quoteService.getQuotes(randomNumber);
        result.enqueue(new Callback<QuoteList>() {
            @Override
            public void onResponse(Call<QuoteList> call, Response<QuoteList> response) {
                insertQuote(response);
            }

            @Override
            public void onFailure(Call<QuoteList> call, Throwable t) {

            }
        });
    }
}
