package com.cui.open;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by cuiyang on 16/2/19.
 */
public class LollipopActivity extends BaseActivity {

    RecyclerView recyclerLollipop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lolloipop_one);
        super.initToolbar();

        recyclerLollipop = (RecyclerView) findViewById(R.id.recycler_lollipop);
        recyclerLollipop.setLayoutManager(new LinearLayoutManager(this));
        Simple_IMG_Adapter adapter = new Simple_IMG_Adapter(10, this);
        recyclerLollipop.setAdapter(adapter);


        adapter.setOnItemClickListener(new Simple_IMG_Adapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                float x = v.getX();
                float y = v.getY();
                Intent i = new Intent();
                i.setClass(LollipopActivity.this, LollipopTwoActivity.class);
                i.putExtra("px", x);
                i.putExtra("py", y);
                startActivity(i);
            }
        });

    }
}
