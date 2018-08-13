package com.example.alexcrafford.trivachallenge;

import android.app.Application;
import android.content.Context;

public class TriviaChallengeApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule((getApplicationContext())))
                .networkModule(new NetworkModule(BuildConfig.API_BASE_URL))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
    public static Context getApplicaitonContext() {
        return getApplicaitonContext();
    }
}
