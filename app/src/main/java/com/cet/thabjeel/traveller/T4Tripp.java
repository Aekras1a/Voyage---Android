package com.cet.thabjeel.traveller;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.SearchSuggestionsAdapter;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

import java.util.ArrayList;
import java.util.List;

public class T4Tripp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_t4_tripp);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//        final FloatingSearchView mSearchView = (FloatingSearchView) findViewById(R.id.floating_search_view);
//        mSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
//            @Override
//            public void onSearchTextChanged(String oldQuery, final String newQuery) {
//
//                //get suggestions based on newQuery
//                Suggestion s = new Suggestion("thabjeel");
//                List<SearchSuggestion> list = new ArrayList<SearchSuggestion>();
//                list.add(s);
//                //pass them on to the search view
//                mSearchView.swapSuggestions(list);
//            }
//        });
//        mSearchView.setOnBindSuggestionCallback(new SearchSuggestionsAdapter.OnBindSuggestionCallback() {
//            @Override
//            public void onBindSuggestion(View suggestionView, ImageView leftIcon, TextView textView, SearchSuggestion item, int itemPosition) {
//
//                //here you can set some attributes for the suggestion's left icon and text. For example,
//                //you can choose your favorite image-loading library for setting the left icon's image.
//                //leftIcon.setImageResource(R.drawable.logo);
//                textView.setText(item.getBody());
//                Log.e("TAG","Cliccked");
//            }
//
//        });
//        mSearchView.setCloseSearchOnKeyboardDismiss(true);
//    }

//    @Override
//    public void onBackPressed() {
//
//        super.onBackPressed();
//    }
        //    /*@Override
//    public boolean onCreateOptionsMenu(Menu menu_main) {
//        // Inflate the menu_main; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu_main.menu_t4_tripp, menu_main);
//        return true;
//    }*/
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu_main) {
//        getMenuInflater().inflate(R.menu_main.menu_t4_tripp, menu_main);
//        MenuItem searchItem = menu_main.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//        // Configure the search info and add any event listeners
//        return super.onCreateOptionsMenu(menu_main);
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
    }
}
