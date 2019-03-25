package com.example.intuitrepos.views.screens;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.example.intuitrepos.Constants;
import com.example.intuitrepos.R;
import com.example.intuitrepos.views.ActivityBase;
import com.example.intuitrepos.views.CallbackSelected;
import com.example.intuitrepos.views.adapters.ItemsAdapter;
import com.example.intuitrepos.vm.ItemsViewModel;

public abstract class ItemsActivity<T extends Object, TViewModel extends ItemsViewModel<T>> extends ActivityBase<TViewModel> implements CallbackSelected {

    private static final String BUNDLE_RECYCLER_LAYOUT = "classname.recycler.layout";

    private RecyclerView _listView;

    private ItemsAdapter adapter;
    private Parcelable savedRecyclerLayoutState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        setupList();

        fetchItems();

        if(savedInstanceState != null)
        {
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

        viewModel.fetch();

        viewModel.getItems().observe(this, items -> {
            adapter.setItems(items);
            adapter.notifyDataSetChanged();
            _listView.getLayoutManager().onRestoreInstanceState(savedRecyclerLayoutState);
        });
    }


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

    @Override
    public void notify(int position) {
        adapter.notifyItemChanged(position);
    }

    protected abstract Class<?> getDetailActivity();
}
