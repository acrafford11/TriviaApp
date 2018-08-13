package com.example.alexcrafford.trivachallenge.ui.question;

import com.example.alexcrafford.trivachallenge.data.QuestionBank;

import dagger.Module;
import dagger.Provides;

@Module
public class QuestionModule {
    private final Contract.View view;

    public QuestionModule(Contract.View view) {
        this.view = view;
    }

    @Provides
    Contract.Presenter providePresenter(Contract.View view,
            QuestionBank questionBank) {
        return new QuestionPresenter(questionBank, view);
    }

    @Provides
    Contract.View provideView() {
        return view;
    }
}
