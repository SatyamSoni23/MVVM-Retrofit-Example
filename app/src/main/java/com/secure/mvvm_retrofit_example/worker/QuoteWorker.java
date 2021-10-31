package com.secure.mvvm_retrofit_example.worker;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.secure.mvvm_retrofit_example.QuoteApplication;
import com.secure.mvvm_retrofit_example.repository.QuoteRepository;

public class QuoteWorker extends Worker {

    public QuoteWorker(Context context, WorkerParameters params){
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d("FIRST_CALLED", "Worker Called");
        QuoteRepository repository = ((QuoteApplication)getApplicationContext()).quoteRepository;
        repository.getQuotesBackground();
        return Result.success();
    }

}
