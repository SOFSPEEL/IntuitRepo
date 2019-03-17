package com.example.intuitrepos;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    Retrofit providesRetrofit(GsonConverterFactory converterFactory) {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(converterFactory).build();
    }

    @Provides
    GsonConverterFactory providesGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    RepoService providesRepoService(Retrofit retrofit) {
        return retrofit.create(RepoService.class);
    }

    @Provides
    IRepository providesRepository(RepoService repoService){
        return new Repository(repoService);
    }


}





