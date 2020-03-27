package com.example.demo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.timehop.stickyheadersrecyclerview.sample.SampleActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SampleActivity.class));
            }
        });

        RecyclerView recyclerView = findViewById(android.R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> data = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            data.add(String.valueOf(i));
        }
        recyclerView.setAdapter(new DemoAdapter(data,this));

        PinnedHeaderDecoration decoration = new PinnedHeaderDecoration();
        decoration.setPinnedTypeHeader(RecyclerItem.ITEM_HEADER);
        decoration.registerTypePinnedHeader(RecyclerItem.ITEM_HEADER, new PinnedHeaderDecoration.PinnedHeaderCreator() {
            @Override
            public boolean create(RecyclerView parent, int adapterPosition) {
                // Draw hea kderView
                return true;
            }
        });

        recyclerView.addItemDecoration(decoration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
