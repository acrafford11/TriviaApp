package com.example.alexcrafford.trivachallenge.ui.question;

import com.example.alexcrafford.trivachallenge.data.QuestionBank;
import com.example.alexcrafford.trivachallenge.data.models.Question;
import com.example.alexcrafford.trivachallenge.data.models.QuestionResult;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class QuestionPresenter implements Contract.Presenter {
    private final Contract.View questionView;
    private final CompositeDisposable compositeDisposable;
    private QuestionBank questionBank;

    @Inject
    QuestionResult questionResult;

    @Inject
    public QuestionPresenter(@NonNull QuestionBank questionBank,
            @NonNull Contract.View questionView) {
        this.questionBank = questionBank;
        this.questionView = questionView;
        compositeDisposable = new CompositeDisposable();
    }

    @Inject
    void attachPresenter() {
        questionView.presenter(this);
    }

    @Override
    public void loadQuestions() {
        compositeDisposable.clear();
        questionView.setLoading(true);
        Disposable disposable = questionBank.getMediumQuestions()
                .map(QuestionResult::results)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::processQuestions,
                        this::handleError
                );
        compositeDisposable.add(disposable);
    }

    private void handleError(Throwable throwable) {
        questionView.setLoading(false);
        questionView.showError(throwable.getLocalizedMessage());
    }

    private void processQuestions(List<Question> questions) {
        questionView.setLoading(false);
        if (questions.isEmpty()) {
            questionView.showEmpty();
        } else {
            questionView.showLatestQuestions(questions);
        }
    }

    @Override
    public void register() {
        loadQuestions();
    }

    @Override
    public void unregister() {
        compositeDisposable.clear();
    }
}
