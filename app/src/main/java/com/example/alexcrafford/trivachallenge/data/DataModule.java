package com.example.alexcrafford.trivachallenge.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Singleton
    @Provides
    DataSourceCallback providesDataSource() {
        return new DataSource();
    }
}
