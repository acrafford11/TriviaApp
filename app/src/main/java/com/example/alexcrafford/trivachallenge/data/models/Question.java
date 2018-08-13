package com.example.alexcrafford.trivachallenge.data.models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import android.os.Parcelable;

import java.util.List;

@AutoValue
public abstract class Question implements Parcelable {

    @SerializedName("difficulty")
    public abstract String difficulty();

    @SerializedName("question")
    public abstract String question();

    @SerializedName("correct_answer")
    public abstract String correctAnswer();

    @SerializedName("incorrect_answers")
    public abstract List<String> incorrectAnswers();

    @SerializedName("category")
    public abstract String category();

    @SerializedName("type")
    public abstract String type();

    public static TypeAdapter<Question> typeAdapter(Gson gson) {
        return new AutoValue_Question.GsonTypeAdapter(gson);
    }

}
