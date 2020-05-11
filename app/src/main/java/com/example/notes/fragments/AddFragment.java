package com.example.notes.fragments;

import android.content.Context;
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

public class AddFragment extends Fragment implements View.OnClickListener {
    EditText title_input;
    EditText text_input;
    Context context;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_fragment, container, false);
        title_input = view.findViewById(R.id.title);
        text_input = view.findViewById(R.id.text);
        view.findViewById(R.id.button_add).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        String title = title_input.getText().toString();
        String text = text_input.getText().toString();
        context = getActivity();
        new DatabaseHandler(context).addNote(new Note(title, text));
        title_input.setText("");
        text_input.setText("");
        Toast.makeText(context, "New note created", Toast.LENGTH_SHORT).show();

    }
}
