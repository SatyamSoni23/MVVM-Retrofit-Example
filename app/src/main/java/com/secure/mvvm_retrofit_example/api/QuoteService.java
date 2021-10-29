package com.secure.mvvm_retrofit_example.api;

import com.secure.mvvm_retrofit_example.models.QuoteList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuoteService {

    @GET("/quotes")
    Call<QuoteList> getQuotes(@Query("page") int page);

    //BASE_URL + "/quotes?page=1"
}
