package com.secure.mvvm_retrofit_example.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.secure.mvvm_retrofit_example.models.ResultsItem;

import java.util.List;

@Dao
public interface QuoteDao {

    @Insert
    void addQuotes(List<ResultsItem> quotes);

    @Query("SELECT * FROM  quote")
    List<ResultsItem> getQuotes();
}
