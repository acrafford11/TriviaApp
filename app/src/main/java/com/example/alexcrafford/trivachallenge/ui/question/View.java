package com.example.alexcrafford.trivachallenge.ui.question;

import com.example.alexcrafford.trivachallenge.R;
import com.example.alexcrafford.trivachallenge.TriviaChallengeApplication;
import com.example.alexcrafford.trivachallenge.data.models.Question;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewAnimator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static dagger.internal.Preconditions.checkNotNull;

public class View  extends FrameLayout implements Contract.View {

    @BindView(R.id.view_error)
    TextView errorView;

    @BindView(R.id.view_empty)
    TextView emptyView;

    @BindView(R.id.view_loading)
    ProgressBar loadingView;

    @BindView(R.id.viewanimator_content)
    ViewAnimator viewAnimator;

    @BindView(R.id.layout_question_container)
    LinearLayout questionContainerLayout;

    @BindView(R.id.textview_question)
    TextView questionTextView;

    @BindView(R.id.button_answer1)
    Button answerButton1;

    @BindView(R.id.button_answer2)
    Button answerButton2;

    @BindView(R.id.button_answer3)
    Button answerButton3;

    @BindView(R.id.button_answer4)
    Button answerButton4;

    @Inject
    Contract.Presenter questionPresenter;

    private Question currentQuestion;

    public View(Context context) {
        super(context);
    }

    public View(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    public void init() {
        DaggerQuestionComponent.builder()
                .appComponent(TriviaChallengeApplication.getAppComponent())
                .questionModule(new QuestionModule(this))
                .build()
                .inject(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        questionPresenter.register();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        questionPresenter.unregister();
    }

    @Override
    public void setLoading(boolean isLoading) {
        viewAnimator.setDisplayedChild(viewAnimator.indexOfChild(loadingView));
    }

    @Override
    public void showError(String message) {
        errorView.setText(message);
        viewAnimator.setDisplayedChild(viewAnimator.indexOfChild(errorView));
    }

    @Override
    public void showEmpty() {
        viewAnimator.setDisplayedChild(viewAnimator.indexOfChild(emptyView));
    }


    @Override
    public void showLatestQuestions(List<Question> questions) {
        viewAnimator.setDisplayedChild(viewAnimator.indexOfChild(questionContainerLayout));
        currentQuestion = questions.get(0);
        questionTextView.setText(Html.fromHtml(currentQuestion.question()));

        List<String> currentAnswers = new ArrayList<>(4);
        currentAnswers.addAll(currentQuestion.incorrectAnswers());
        currentAnswers.add(currentQuestion.correctAnswer());

        Collections.shuffle(currentAnswers);
        setAnswers(currentAnswers);
    }

    private void setAnswers(List<String> currentAnswers) {
        answerButton1.setText(Html.fromHtml(currentAnswers.get(0)));
        answerButton2.setText(Html.fromHtml(currentAnswers.get(1)));
        answerButton3.setText(Html.fromHtml(currentAnswers.get(2)));
        answerButton4.setText(Html.fromHtml(currentAnswers.get(3)));
    }

    @OnClick(R.id.button_answer1)
    void chooseAnswer1() {
        chooseAnwser(answerButton1);
    }

    @OnClick(R.id.button_answer2)
    void chooseAnswer2() {
        chooseAnwser(answerButton2);
    }

    @OnClick(R.id.button_answer3)
    void chooseAnswer3() {
        chooseAnwser(answerButton3);
    }

    @OnClick(R.id.button_answer4)
    void chooseAnswer4() {
        chooseAnwser(answerButton4);
    }

    @OnClick(R.id.next_question)
    void nextQuestion() {
        resetButtons();
        questionPresenter.loadQuestions();
    }

    private void chooseAnwser(Button answerButton) {
        if (currentQuestion != null) {
            if (answerButton.getText().equals(Html.fromHtml(currentQuestion.correctAnswer()))) {
                disableButtons();
                adjustForCorrectAnswer(answerButton);
            } else {
                showAnswers();
                disableButtons();
            }
        }
    }

    public void resetButtons() {
        setDefaultColors();
        enableButtons();
    }

    private void setDefaultColors() {
        answerButton1.setBackground(getResources().getDrawable(R.drawable.default_button));
        answerButton2.setBackground(getResources().getDrawable(R.drawable.default_button));
        answerButton3.setBackground(getResources().getDrawable(R.drawable.default_button));
        answerButton4.setBackground(getResources().getDrawable(R.drawable.default_button));
    }

    private void enableButtons() {
        answerButton1.setClickable(true);
        answerButton2.setClickable(true);
        answerButton3.setClickable(true);
        answerButton4.setClickable(true);
    }

    private void disableButtons() {
        answerButton1.setClickable(false);
        answerButton2.setClickable(false);
        answerButton3.setClickable(false);
        answerButton4.setClickable(false);
    }

    private void showAnswers() {
        if(answerButton1.getText().equals(Html.fromHtml(currentQuestion.correctAnswer()))){
            adjustForCorrectAnswer(answerButton1);
        } else {
            adjustForIncorrectAnswer(answerButton1);
        }

        if (answerButton2.getText().equals(Html.fromHtml(currentQuestion.correctAnswer()))) {
            adjustForCorrectAnswer(answerButton2);
        } else {
            adjustForIncorrectAnswer(answerButton2);
        }

        if (answerButton3.getText().equals(Html.fromHtml(currentQuestion.correctAnswer()))) {
            adjustForCorrectAnswer(answerButton3);
        } else {
            adjustForIncorrectAnswer(answerButton3);
        }

        if (answerButton4.getText().equals(Html.fromHtml(currentQuestion.correctAnswer()))) {
            adjustForCorrectAnswer(answerButton4);
        } else {
            adjustForIncorrectAnswer(answerButton4);
        }

    }

    private void adjustForCorrectAnswer(Button button) {
        button.setBackground(getResources().getDrawable(R.drawable.correct_button));
    }

    private void adjustForIncorrectAnswer(Button button) {
        button.setBackground(getResources().getDrawable(R.drawable.incorrect_button));
    }

    @Override
    public void presenter(Contract.Presenter presenter) {
        questionPresenter = checkNotNull(presenter);
    }
}
