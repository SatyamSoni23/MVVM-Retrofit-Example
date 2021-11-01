package com.secure.mvvm_retrofit_example;

import android.app.Application;

import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.secure.mvvm_retrofit_example.api.QuoteService;
import com.secure.mvvm_retrofit_example.api.RetrofitHelper;
import com.secure.mvvm_retrofit_example.db.QuoteDatabase;
import com.secure.mvvm_retrofit_example.repository.QuoteRepository;
import com.secure.mvvm_retrofit_example.worker.QuoteWorker;

import java.util.concurrent.TimeUnit;

public class QuoteApplication extends Application {

    public QuoteRepository quoteRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
        setupWorker();
    }

    private void setupWorker() {
        Constraints constraint = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        PeriodicWorkRequest workerRequest = new PeriodicWorkRequest.Builder(QuoteWorker.class, 1, TimeUnit.MINUTES)
                .setConstraints(constraint)
                .build();
        WorkManager.getInstance(this).enqueue(workerRequest);
    }

    private void initialize() {
        QuoteService quoteService = RetrofitHelper.getInstance().create(QuoteService.class);
        QuoteDatabase database = QuoteDatabase.getDatabase(getApplicationContext());
        quoteRepository = new QuoteRepository(quoteService, database, getApplicationContext());
    }
}
