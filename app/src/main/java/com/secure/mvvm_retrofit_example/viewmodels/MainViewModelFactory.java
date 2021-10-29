package com.secure.mvvm_retrofit_example.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.secure.mvvm_retrofit_example.repository.QuoteRepository;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    private QuoteRepository repository;
    public MainViewModelFactory(QuoteRepository repository){
        this.repository = repository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(repository);
    }
}
