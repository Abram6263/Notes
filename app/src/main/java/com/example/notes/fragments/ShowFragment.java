package com.example.notes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.ListFragment;

import com.example.notes.R;
import com.example.notes.adapters.NotesIndexAdapter;
import com.example.notes.database.DatabaseHandler;
import com.example.notes.models.Note;

import java.util.ArrayList;


public class ShowFragment extends ListFragment {
    private ArrayList<Note> notes;
    DatabaseHandler database;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.show_fragment, container, false);
        Context context = getActivity();
        database = new DatabaseHandler(context);
        notes = database.getAllNotes();

        if(notes.size() == 0) {
            for(int i = 0; i < 5; i++) {
                database.addNote(new Note("  Plans for the day",  "  Work!"));
            }
            notes = database.getAllNotes();
        }
        setListAdapter(new NotesIndexAdapter(context, notes));

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }
}
