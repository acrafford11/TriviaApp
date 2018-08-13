package com.example.alexcrafford.trivachallenge.data;

import com.example.alexcrafford.trivachallenge.data.models.QuestionResult;

import io.reactivex.Observable;

public interface DataSourceCallback {

    Observable<QuestionResult> getEasyQuestions();
    Observable<QuestionResult> getMediumQuestions();
    Observable<QuestionResult> getHardQuestions();
}
