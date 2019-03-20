package com.example.intuitrepos.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.intuitrepos.repository.IRepository;
import com.example.intuitrepos.db.RepoDatabase;
import com.example.intuitrepos.network.RepoService;
import com.example.intuitrepos.repository.Repository;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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

    @Provides
    Retrofit providesRetrofit(GsonConverterFactory converterFactory, OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .client(okHttpClient)
                .addConverterFactory(converterFactory).build();
    }

    @Provides
    OkHttpClient providesHttpClient() {
        return new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                //todo:
                String basic = Credentials.basic("sofspeel", "blah");
                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        basic);

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();
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
    IRepository providesRepository(RepoService repoService, RepoDatabase repoDatabase, Executor executor) {
        return new Repository(repoService, repoDatabase, executor);
    }


    @Provides
    RepoDatabase providesRepoDatabase() {
        return Room.databaseBuilder(context,
                RepoDatabase.class, "repo")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    Executor providesExecutor() {

        return Executors.newSingleThreadExecutor();
    }
}





