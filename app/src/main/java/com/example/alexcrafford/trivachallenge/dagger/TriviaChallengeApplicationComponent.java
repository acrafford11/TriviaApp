package com.example.alexcrafford.trivachallenge.dagger;

import com.example.alexcrafford.trivachallenge.TriviaChallengeApplication;
import com.example.alexcrafford.trivachallenge.dagger.modules.TriviaChallengeApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {AndroidInjectionModule.class, TriviaChallengeApplicationModule.class})
public interface TriviaChallengeApplicationComponent extends AndroidInjector<TriviaChallengeApplication> {
}
