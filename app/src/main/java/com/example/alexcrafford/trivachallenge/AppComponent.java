package com.example.alexcrafford.trivachallenge;

import com.example.alexcrafford.trivachallenge.AppModule;
import com.example.alexcrafford.trivachallenge.NetworkModule;
import com.example.alexcrafford.trivachallenge.data.DataModule;
import com.example.alexcrafford.trivachallenge.data.DataSource;
import com.example.alexcrafford.trivachallenge.data.QuestionBank;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DataModule.class, NetworkModule.class, AppModule.class})
public interface AppComponent {
    void inject(DataSource localDataSource);
    QuestionBank getQuestionBank();

}
