package com.example.intuitrepos.di;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.intuitrepos.repository.IRepository;
import com.example.intuitrepos.db.RepoDatabase;
import com.example.intuitrepos.network.RepoService;
import com.example.intuitrepos.repository.Repository;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }


    @Provides @Singleton
    SharedPreferences providesPrefs() {
        SharedPreferences prefs = context.getSharedPreferences(
                "prefs", Context.MODE_PRIVATE);

        return prefs;
    }

    @Provides @Singleton
    RepositoryHolder providesRepositoryHolder() {
        return new RepositoryHolder();
    }


    @Provides @Singleton
    Retrofit providesRetrofit(GsonConverterFactory converterFactory, OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .client(okHttpClient)
                .addConverterFactory(converterFactory).build();
    }

    @Provides @Singleton
    OkHttpClient providesHttpClient(RepositoryHolder repository ) {
        return new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                
                String password = repository.getRepository().fetchPassword();
                String basic = Credentials.basic("sofspeel", password);
                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        basic);

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();
    }


    @Provides @Singleton
    GsonConverterFactory providesGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides @Singleton
    RepoService providesRepoService(Retrofit retrofit) {
        return retrofit.create(RepoService.class);
    }

    @Provides @Singleton
    IRepository providesRepository(RepoService repoService, RepoDatabase repoDatabase, Executor executor, SharedPreferences preferences, RepositoryHolder repositoryHolder) {

        Repository repository = new Repository(repoService, repoDatabase, executor, preferences);
        repositoryHolder.setRepository(repository);
        return repository;
    }


    @Provides @Singleton
    RepoDatabase providesRepoDatabase() {
        return Room.databaseBuilder(context,
                RepoDatabase.class, "repo")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides @Singleton
    Executor providesExecutor() {

        return Executors.newSingleThreadExecutor();
    }
}





