package com.example.intuitrepos;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.intuitrepos.databinding.RepoRowBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Provider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReposActivity extends AppCompatActivity implements ISelectedRepo {

    private RecyclerView _listView;

    //    @Inject
    ReposViewModel reposViewModel;

    private List<Repo> repoList = new ArrayList<>();
    private ReposAdapter adapter;
    private AppComponent appComponent;

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
        appComponent = app.getAppComponent();

        DaggerMainActivityComponent.builder().appComponent(appComponent).build().injectMainActivity(this);
    }

    private void fetchRepos() {


        ReposViewModelFactory factory = new ReposViewModelFactory(new Provider<ReposViewModel>() {
            @Override
            public ReposViewModel get() {
                return new ReposViewModel(appComponent.getRepository());
            }
        });

        reposViewModel = ViewModelProviders.of(this, factory).get(ReposViewModel.class);

        reposViewModel.getRepos().observe(this, new Observer<List<Repo>>() {
            @Override
            public void onChanged(@Nullable List<Repo> repos) {
                repoList = repos;
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void setupList() {
        _listView = findViewById(R.id.list);

        adapter = new ReposAdapter(this);

        _listView.setAdapter(adapter);
    }

    int selected_position = -1;

    @Override
    public void selected(Repo repo) {
        this.startActivity(new Intent(this, RepoDetailActivity.class));
    }


    public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolderRepo> {

        private ISelectedRepo selectedRepo;

        public ReposAdapter(ISelectedRepo selectedRepo) {
            this.selectedRepo = selectedRepo;
        }

        @NonNull
        @Override
        public ViewHolderRepo onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            RepoRowBinding repoRowBinding = RepoRowBinding.inflate(getLayoutInflater(), viewGroup, false);
            return new ViewHolderRepo(repoRowBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolderRepo viewHolderRepo, int i) {
            viewHolderRepo.bind(repoList.get(i), i);
        }

        @Override
        public int getItemCount() {
            return repoList.size();
        }

        private class ViewHolderRepo extends RecyclerView.ViewHolder implements View.OnClickListener {

            private RepoRowBinding repoRowBinding;

            public ViewHolderRepo(@NonNull RepoRowBinding repoRowBinding) {
                super(repoRowBinding.getRoot());
                this.repoRowBinding = repoRowBinding;

                View root = repoRowBinding.getRoot();
                root.setOnClickListener(this);

            }

            public void bind(Repo repo, int position) {

                repoRowBinding.setRepo(repo);
                repoRowBinding.executePendingBindings();

                repoRowBinding.getRoot().setBackgroundColor(selected_position == position ? Color.LTGRAY : Color.TRANSPARENT);

            }

            @Override
            public void onClick(View view) {
                if (getAdapterPosition() == RecyclerView.NO_POSITION) return;

                // Updating old as well as new positions
                notifyItemChanged(selected_position);
                selected_position = getAdapterPosition();
                notifyItemChanged(selected_position);


                selectedRepo.selected(repoList.get(selected_position));


            }
        }

    }
}
