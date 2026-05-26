package com.example.lab5.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab5.R;

public class BrowseNoteActivity extends AppCompatActivity {

    private EditText etSearchQuery;
    private Button btnSearch;
    private ProgressBar searchProgressBar;
    private TextView tvSearchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_note);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        etSearchQuery = findViewById(R.id.etSearchQuery);
        btnSearch = findViewById(R.id.btnSearch);
        searchProgressBar = findViewById(R.id.searchProgressBar);
        tvSearchResult = findViewById(R.id.tvSearchResult);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSearchResult.setText("");
                searchProgressBar.setVisibility(View.VISIBLE);
                searchProgressBar.setIndeterminate(true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                searchProgressBar.setVisibility(View.GONE);
                                tvSearchResult.setText("ไม่พบข้อมูล");
                            }
                        });
                    }
                }).start();
            }
        });
    }
}