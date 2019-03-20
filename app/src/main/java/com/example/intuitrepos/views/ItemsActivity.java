package com.example.intuitrepos.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.example.intuitrepos.R;
import com.example.intuitrepos.RepoApplication;
import com.example.intuitrepos.di.AppComponent;
import com.example.intuitrepos.vm.ItemsViewModel;
import com.example.intuitrepos.vm.ItemsViewModelFactory;

import java.util.List;

public abstract class ItemsActivity<T extends Object, TViewModel extends ItemsViewModel<T>> extends AppCompatActivity implements ISelectedItem {
    protected AppComponent appComponent;
    //    @Inject
    ItemsViewModel<T> itemsViewModel;

    private RecyclerView _listView;

    private ItemsAdapter adapter;

    protected void inject() {
        RepoApplication app = (RepoApplication) getApplication();
        appComponent = app.getAppComponent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        inject();

        setupList();

        fetchItems();



    }


    protected abstract int getLayoutId();

    private void fetchItems() {

        ItemsViewModelFactory factory = new ItemsViewModelFactory(() -> createItemsViewModel());

        itemsViewModel = ViewModelProviders.of(this, factory).get(getItemsClass());

        itemsViewModel.fetch();

        itemsViewModel.getItems().observe(this, new Observer<List<T>>() {
            @Override
            public void onChanged(@Nullable List<T> items) {
                adapter.setItems(items);
                adapter.notifyDataSetChanged();
            }
        });
    }

    protected abstract Class<TViewModel> getItemsClass();

    protected abstract ItemsViewModel<T> createItemsViewModel();

    private void setupList() {
        _listView = findViewById(R.id.list);

        _listView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        adapter = createAdapter();

        _listView.setAdapter(adapter);
    }

    protected abstract ItemsAdapter createAdapter();


    @Override
    public void selected(Parcelable item) {
        Intent intent = new Intent(this, getDetailActivity());
        intent.putExtra(Constants.EXTRA_KEY_ITEM, item);
        this.startActivity(intent);
    }

    protected abstract Class<T> getDetailActivity();
}
