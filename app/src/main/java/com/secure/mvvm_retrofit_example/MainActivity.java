package com.secure.mvvm_retrofit_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.secure.mvvm_retrofit_example.api.QuoteService;
import com.secure.mvvm_retrofit_example.api.RetrofitHelper;
import com.secure.mvvm_retrofit_example.models.QuoteList;
import com.secure.mvvm_retrofit_example.repository.QuoteRepository;
import com.secure.mvvm_retrofit_example.viewmodels.MainViewModel;
import com.secure.mvvm_retrofit_example.viewmodels.MainViewModelFactory;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuoteRepository repository = ((QuoteApplication)getApplicationContext()).quoteRepository;
        mainViewModel = new ViewModelProvider(this, new MainViewModelFactory(repository)).get(MainViewModel.class);
        mainViewModel.quotes().observe(this, new Observer<QuoteList>() {
            @Override
            public void onChanged(QuoteList quoteList) {
                Log.d("FIRST_ONE", quoteList.toString());
                Toast.makeText(MainActivity.this, String.valueOf(quoteList.getResults().size()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}