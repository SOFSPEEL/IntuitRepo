package com.example.intuitrepos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.intuitrepos.databinding.RepoRowBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView _listView;

    @Inject
    ReposViewModel reposViewModel;

    private List<Repo> repoList = new ArrayList<>();
    private RecyclerView.Adapter<ViewHolderRepo> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repos);

        inject();

        setupList();

        fetchRepos();
    }

    private void inject() {
        RepoApplication app = (RepoApplication) getApplication();
        DaggerMainActivityComponent.builder().appComponent(app.getAppComponent()).build().injectMainActivity(this);
    }

    private void fetchRepos() {
        reposViewModel.FetchRepos().enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                repoList = response.body();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }

    private void setupList() {
        _listView = findViewById(R.id.list);

        adapter = new RecyclerView.Adapter<ViewHolderRepo>() {

            @NonNull
            @Override
            public ViewHolderRepo onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                RepoRowBinding repoRowBinding = RepoRowBinding.inflate(getLayoutInflater(), viewGroup, false);
                return new ViewHolderRepo(repoRowBinding);
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolderRepo viewHolderRepo, int i) {
                viewHolderRepo.bind(repoList.get(i));
            }

            @Override
            public int getItemCount() {
                return repoList.size();
            }
        };
        _listView.setAdapter(adapter);
    }

    private static class ViewHolderRepo extends RecyclerView.ViewHolder {

        private RepoRowBinding repoRowBinding;

        public ViewHolderRepo(@NonNull RepoRowBinding repoRowBinding) {
            super(repoRowBinding.getRoot());
            this.repoRowBinding = repoRowBinding;
        }

        public void bind(Repo repo) {

            repoRowBinding.setRepo(repo);
            repoRowBinding.executePendingBindings();

        }
    }
}
