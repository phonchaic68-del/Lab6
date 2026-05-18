package com.example.lab5.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab5.R;
import com.example.lab5.controller.NoteController;
import com.example.lab5.model.Note;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private ListView listViewNotes;
    private Button btnGoToAddNote;
    private NoteController controller;
    private ArrayList<String> displayList;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        controller = new NoteController();
        listViewNotes = findViewById(R.id.listViewNotes);
        btnGoToAddNote = findViewById(R.id.btnGoToAddNote);
        displayList = new ArrayList<>();
        btnGoToAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        displayList.clear();
        for (Note note : controller.getNotes()) {
            displayList.add(note.getSummaryString());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        listViewNotes.setAdapter(adapter);
    }
}