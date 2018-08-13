package com.example.alexcrafford.trivachallenge.ui.question;

import com.example.alexcrafford.trivachallenge.ui.view_base.BasePresenter;
import com.example.alexcrafford.trivachallenge.ui.view_base.BaseView;
import com.example.alexcrafford.trivachallenge.data.models.Question;

import java.util.List;

public interface Contract {
    interface View extends BaseView<Presenter> {

        void setLoading(boolean isLoading);

        void showError(String message);

        void showEmpty();

        void showLatestQuestions(List<Question> questions);
    }

    interface Presenter extends BasePresenter {

        void loadQuestions();
    }
}
