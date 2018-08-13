package com.example.alexcrafford.trivachallenge.dagger.modules;

import com.example.alexcrafford.trivachallenge.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TriviaChallengeApplicationModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeActivityInjector();

}
