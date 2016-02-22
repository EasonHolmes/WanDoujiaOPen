package com.cui.open;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by cuiyang on 15/12/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar mToolbar;

    protected void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        mToolbar.setTitle(getClass().getSimpleName());
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected Toolbar getmToolbar() {
        return mToolbar;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
