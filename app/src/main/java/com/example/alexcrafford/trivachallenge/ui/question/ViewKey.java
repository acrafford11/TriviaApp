package com.example.alexcrafford.trivachallenge.ui.question;

import com.google.auto.value.AutoValue;

import com.example.alexcrafford.trivachallenge.Key;
import com.example.alexcrafford.trivachallenge.R;

@AutoValue
public abstract class ViewKey extends Key {
    @Override
    public int layout() {
        return R.layout.question_view;
    }

    public static ViewKey create() {
        return new AutoValue_ViewKey();
    }
}
