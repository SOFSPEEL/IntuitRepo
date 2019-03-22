package com.example.intuitrepos.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.example.intuitrepos.R;
import com.example.intuitrepos.vm.ItemsViewModel;

public abstract class ItemsActivity<T extends Object, TViewModel extends ItemsViewModel<T>> extends ActivityBase<TViewModel> implements ISelectedItem {


    private RecyclerView _listView;

    private ItemsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        setupList();

        fetchItems();

    }

    protected abstract int getLayoutId();

    private void fetchItems() {

        viewModel.fetch();

        viewModel.getItems().observe(this, items -> {
            adapter.setItems(items);
            adapter.notifyDataSetChanged();
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

    protected abstract Class<?> getDetailActivity();
}
