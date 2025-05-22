package com.example.pas_semestergenap;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.pas_semestergenap.Fragment.MatchScheduleFragment;
import com.example.pas_semestergenap.Fragment.PremiereLeagueFragment;
import com.example.pas_semestergenap.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, new PremiereLeagueFragment())
                .commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_premier) {
                fragment = new PremiereLeagueFragment();
            } else if (itemId == R.id.nav_jadwal) {
                fragment = new MatchScheduleFragment();
            } else if (itemId == R.id.nav_information) {
                fragment = new ProfileFragment();
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, fragment)
                        .commit();
                return true;
            }
            return false;
        });
    }
}