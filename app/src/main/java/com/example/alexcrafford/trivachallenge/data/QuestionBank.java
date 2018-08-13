package com.example.alexcrafford.trivachallenge.data;

import com.example.alexcrafford.trivachallenge.data.models.QuestionResult;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.reactivex.Observable;

public class QuestionBank implements DataSourceCallback{
    @NonNull
    private final DataSourceCallback dataSource;

    @Inject
    QuestionBank(@NonNull DataSourceCallback dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Observable<QuestionResult> getEasyQuestions() {
        return dataSource.getEasyQuestions();
    }

    @Override
    public Observable<QuestionResult> getMediumQuestions() {
        return dataSource.getMediumQuestions();
    }

    @Override
    public Observable<QuestionResult> getHardQuestions() {
        return dataSource.getHardQuestions();
    }
}
