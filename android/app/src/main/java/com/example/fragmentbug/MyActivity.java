package com.example.fragmentbug;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import io.flutter.embedding.android.FlutterFragment;

public class MyActivity extends AppCompatActivity {
    private static final String TAG_FLUTTER_FRAGMENT = "flutter_fragment";
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.frameLayout, new NativeFragment());
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        FlutterFragment flutterFragment =
                (FlutterFragment) fragmentManager.findFragmentByTag(TAG_FLUTTER_FRAGMENT);
        if (flutterFragment != null) {
            flutterFragment.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }
}