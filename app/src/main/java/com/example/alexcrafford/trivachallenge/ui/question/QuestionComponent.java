package com.example.alexcrafford.trivachallenge.ui.question;

import com.example.alexcrafford.trivachallenge.AppComponent;
import com.example.alexcrafford.trivachallenge.scopes.ViewScope;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = { QuestionModule.class})
public interface QuestionComponent {

    void inject(View quetionView);
}
