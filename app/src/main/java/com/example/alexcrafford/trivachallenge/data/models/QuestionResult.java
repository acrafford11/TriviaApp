package com.example.alexcrafford.trivachallenge.data.models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import android.os.Parcelable;

import java.util.List;

@AutoValue
public abstract class QuestionResult implements Parcelable {

    @SerializedName("response_code")
    public abstract int responseCode();

    @SerializedName("results")
    public abstract List<Question> results();

    public static TypeAdapter<QuestionResult> typeAdapter(Gson gson) {
        return new AutoValue_QuestionResult.GsonTypeAdapter(gson);
    }
}
