package com.example.notes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.notes.adapters.NotesPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragment_manager;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        pager = findViewById(R.id.pager);
        fragment_manager = getSupportFragmentManager();
        pager.setAdapter(new NotesPagerAdapter(fragment_manager));
    }

}
