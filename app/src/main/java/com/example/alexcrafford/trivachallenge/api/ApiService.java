package com.example.alexcrafford.trivachallenge.api;

import com.example.alexcrafford.trivachallenge.data.models.QuestionResult;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api.php?amount=1&difficult=easy&type=multiple")
    Observable<QuestionResult> getEasyQuestions();

    @GET("api.php?amount=1&difficult=medium&type=multiple")
    Observable<QuestionResult> getMediumQuestions();

    @GET("api.php?amount=1&difficult=hard&type=multiple")
    Observable<QuestionResult> getHardQuestions();
}
