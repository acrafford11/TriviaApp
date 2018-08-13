package com.example.alexcrafford.trivachallenge.data;

import com.example.alexcrafford.trivachallenge.TriviaChallengeApplication;
import com.example.alexcrafford.trivachallenge.api.ApiService;
import com.example.alexcrafford.trivachallenge.data.models.QuestionResult;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DataSource implements DataSourceCallback {

    @Inject
    ApiService apiService;

    public DataSource() {
        TriviaChallengeApplication.getAppComponent().inject(this);
    }

    @Override
    public Observable<QuestionResult> getEasyQuestions() {
        return apiService.getEasyQuestions();
    }
    @Override
    public Observable<QuestionResult> getMediumQuestions() {
        return apiService.getMediumQuestions();
    }
    @Override
    public Observable<QuestionResult> getHardQuestions() {
        return apiService.getHardQuestions();
    }
}
