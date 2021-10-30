package com.secure.mvvm_retrofit_example.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.secure.mvvm_retrofit_example.models.ResultsItem;

@Database(entities = {ResultsItem.class}, version = 1)
public abstract class QuoteDatabase extends RoomDatabase {

    private static final String DB_NAME = "quoteDB";
    private static volatile QuoteDatabase instance;

    public static synchronized QuoteDatabase getDatabase(Context context){
        if(instance == null){
            instance = create(context);
        }
        return instance;
    }

    private static QuoteDatabase create(final Context context){
        return Room.databaseBuilder(context, QuoteDatabase.class, DB_NAME)
                .build();
    }

    public abstract QuoteDao quoteDao();
}
