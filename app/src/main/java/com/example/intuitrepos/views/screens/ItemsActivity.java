package com.example.intuitrepos.views.screens;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.intuitrepos.Constants;
import com.example.intuitrepos.R;
import com.example.intuitrepos.views.ActivityBase;
import com.example.intuitrepos.views.CallbackSelected;
import com.example.intuitrepos.views.adapters.ItemsAdapter;
import com.example.intuitrepos.vm.ItemsViewModel;

public abstract class ItemsActivity<T extends Object, TViewModel extends ItemsViewModel<T>>
        extends ActivityBase<TViewModel> implements CallbackSelected, SwipeRefreshLayout.OnRefreshListener {

    private static final String BUNDLE_RECYCLER_LAYOUT = "classname.recycler.layout";

    private RecyclerView _listView;

    private ItemsAdapter adapter;
    private Parcelable savedRecyclerLayoutState;
    private SwipeRefreshLayout _swipe;

    @Override
    public void onRefresh() {
        fetchItems();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        setupList();

        fetchItems();

        if (savedInstanceState != null) {
            savedRecyclerLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT);
            _listView.getLayoutManager().onRestoreInstanceState(savedRecyclerLayoutState);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, _listView.getLayoutManager().onSaveInstanceState());
    }

    protected abstract int getLayoutId();

    private void fetchItems() {

        postRefreshing(true);
        viewModel.fetch();

        viewModel.getItems().observe(this, items -> {
            postRefreshing(false);
            adapter.setItems(items);
            adapter.notifyDataSetChanged();
            _listView.getLayoutManager().onRestoreInstanceState(savedRecyclerLayoutState);
        });

        viewModel.getError().observe(this, error ->{
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        });
    }

    private void setupList() {
        _listView = findViewById(R.id.list);

        _swipe = findViewById(R.id.swipe);
        _swipe.setOnRefreshListener(this);

        postRefreshing(true);

        _listView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        adapter = createAdapter();

        _listView.setAdapter(adapter);

    }

    private void postRefreshing(boolean refreshing) {
        _swipe.post(() -> {

            _swipe.setRefreshing(refreshing);
        });
    }

    protected abstract ItemsAdapter createAdapter();


    @Override
    public void selected(Parcelable item) {

        Intent intent = new Intent(this, getDetailActivity());
        intent.putExtra(Constants.EXTRA_KEY_ITEM, item);
        this.startActivity(intent);
    }

    @Override
    public void notify(int position) {
        adapter.notifyItemChanged(position);
    }

    protected abstract Class<?> getDetailActivity();
}
