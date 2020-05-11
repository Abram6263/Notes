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
import com.example.notes.models.Note;

public class UpdateFragment extends Fragment implements View.OnClickListener {
    DatabaseHandler database;
    Context context;
    EditText note_id_input;
    EditText title_input;
    EditText text_input;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.update_fragment, container, false);
        view.findViewById(R.id.button_update).setOnClickListener(this);
        note_id_input = view.findViewById(R.id.note_number);
        title_input = view.findViewById(R.id.title);
        text_input = view.findViewById(R.id.text);

        return view;
    }

    @Override
    public void onClick(View v) {
        context = getActivity();
        database = new DatabaseHandler(context);
        int note_id = Integer.parseInt(String.valueOf(note_id_input.getText()));

        try {
            database.getNote(note_id);
        } catch (CursorIndexOutOfBoundsException e) {
            Toast.makeText(context, "Note not exist", Toast.LENGTH_SHORT).show();
            return;
        }
        String title = title_input.getText().toString();
        String text = text_input.getText().toString();
        database.updateNote(new Note(note_id, title, text));

        note_id_input.setText("");
        title_input.setText("");
        text_input.setText("");
        Toast.makeText(context, "Note update", Toast.LENGTH_SHORT).show();

    }
}
