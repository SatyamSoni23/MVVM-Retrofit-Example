package com.secure.mvvm_retrofit_example;

import android.app.Application;

import com.secure.mvvm_retrofit_example.api.QuoteService;
import com.secure.mvvm_retrofit_example.api.RetrofitHelper;
import com.secure.mvvm_retrofit_example.db.QuoteDatabase;
import com.secure.mvvm_retrofit_example.repository.QuoteRepository;

public class QuoteApplication extends Application {

    public QuoteRepository quoteRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }

    private void initialize() {
        QuoteService quoteService = RetrofitHelper.getInstance().create(QuoteService.class);
        QuoteDatabase database = QuoteDatabase.getDatabase(getApplicationContext());
        quoteRepository = new QuoteRepository(quoteService, database);
    }
}
