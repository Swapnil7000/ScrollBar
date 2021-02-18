package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.recyclerview.databinding.ActivityMainBinding;
import com.turingtechnologies.materialscrollbar.AlphabetIndicator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> wordsList = new ArrayList<>();
    ActivityMainBinding b;
    WordListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        createData();
        setupAdapter();
        setupFAB();

    }

    public void createData() {
        wordsList.add("Apple");
        wordsList.add("Banana");
        wordsList.add("Apricots");
        wordsList.add("Avocado.");
        wordsList.add("Blackberries.");
        wordsList.add("Blueberries.");
        wordsList.add("Breadfruit.");
        wordsList.add("Cranberries");
        wordsList.add("Custard-Apple");
        wordsList.add("Grapefruit");
        wordsList.add("Figs");
        wordsList.add("Java-Plum");
        wordsList.add("Lemon");
        wordsList.add("Kiwi");
        wordsList.add("Mango");
        wordsList.add("Lychee");
        wordsList.add("Orange");
        wordsList.add("Papaya");
        wordsList.add("Pineapple");
    }

    private void setupAdapter() {
        //Create adapter object
        adapter = new WordListAdapter(this, wordsList);
//        b.mReclyclerView.setAdapter(adapter);
        //has to be called AFTER RecyclerView.setAdapter()
        b.recyclerView.setAdapter(adapter);
        b.recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        b.mReclyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    private void setupFAB() {
        b.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new word
                String newWord = "+ Word" + wordsList.size();

                //Add the word to list
                wordsList.add(newWord);

                //Notify adapter
                adapter.notifyItemInserted(wordsList.size() - 1);

                //Scroll to bottom
                b.mReclyclerView.smoothScrollToPosition(wordsList.size() - 1);
            }
        });
    }
}