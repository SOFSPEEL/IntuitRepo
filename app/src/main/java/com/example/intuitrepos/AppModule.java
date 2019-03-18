package com.example.intuitrepos;

import android.arch.persistence.room.Room;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context){
        this.context = context;
    }

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
    IRepository providesRepository(RepoService repoService, RepoDatabase repoDatabase){
        return new Repository(repoService, repoDatabase);
    }


    @Provides
    RepoDatabase providesRepoDatabase(){
        return Room.databaseBuilder(context,
                RepoDatabase.class, "repo").build();
    }


}





