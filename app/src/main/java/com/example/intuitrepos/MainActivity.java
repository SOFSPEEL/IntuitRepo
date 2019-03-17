package com.example.intuitrepos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.intuitrepos.Dto.Repo;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private RecyclerView _listView;

    @Inject
    RepoService repoService;
    private List<Repo> repoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repos);

        RepoApplication app = (RepoApplication) getApplication();


        _listView = findViewById(R.id.list);

        DaggerMainActivityComponent.builder().appComponent(app.getAppComponent()).build().injectMainActivity(this);

        repoService.GetRepos().enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                repoList = response.body();
                _listView.setAdapter(new RecyclerView.Adapter<ViewHolderRepo>() {

                    @NonNull
                    @Override
                    public ViewHolderRepo onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                        View view = getLayoutInflater().inflate(R.layout.repo_row, viewGroup, false);
                        return new ViewHolderRepo(view);
                    }

                    @Override
                    public void onBindViewHolder(@NonNull ViewHolderRepo viewHolderRepo, int i) {
                        viewHolderRepo.bind(i);
                    }

                    @Override
                    public int getItemCount() {
                        return repoList.size();
                    }
                });

            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });

    }

    private class ViewHolderRepo extends RecyclerView.ViewHolder {
        private final TextView repoName;
        private final TextView repoDesc;

        public ViewHolderRepo(@NonNull View itemView) {
            super(itemView);

            repoName = itemView.findViewById(R.id.repoName);
            repoDesc = itemView.findViewById(R.id.repoDesc);

        }

        public void bind(int position) {

            Repo repo = repoList.get(position);
            repoName.setText(repo.getFullName());
            repoDesc.setText(repo.getDescription());

        }
    }
}
