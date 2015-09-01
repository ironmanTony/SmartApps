package com.me.ironmanli.designsupportlibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.me.ironmanli.designsupportlibs.componet.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.main_list)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        ListView listView;

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,null));

        MainAdapter mAdapter = new MainAdapter(getData());
        mRecyclerView.setAdapter(mAdapter);

    }

    private List<Content> getData() {
        ArrayList<Content> data = new ArrayList<Content>();
        for (int i = 1; i <= 1000; i++) {
            data.add(new Content("title "+i, "this is content "));
        }
        return data;
    }

    @Override
    protected void onStop() {
        super.onStop();
        ButterKnife.unbind(this);
    }
}
