package com.example.notes.fragments;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.notes.R;
import com.example.notes.database.DatabaseHandler;

public class DeleteFragment extends Fragment implements View.OnClickListener {
    DatabaseHandler database;
    Context context;
    EditText note_number;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.delete_fragment, container, false);
        view.findViewById(R.id.button_del).setOnClickListener(this);
        note_number = view.findViewById(R.id.note_number);
        return view;
    }

    @Override
    public void onClick(View v) {
        int note_id = Integer.parseInt(String.valueOf(note_number.getText()));
        context = getActivity();
        database = new DatabaseHandler(context);

        try {
            database.getNote(note_id);
        } catch (CursorIndexOutOfBoundsException e) {
            Toast.makeText(context, "Note not exist", Toast.LENGTH_SHORT).show();
            return;
        }
        database.deleteNote(note_id);
        note_number.setText("");
        Toast.makeText(context, "Note has been deleted", Toast.LENGTH_SHORT).show();
    }
}
