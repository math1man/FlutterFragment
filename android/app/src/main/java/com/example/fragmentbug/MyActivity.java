package com.example.fragmentbug;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (savedInstanceState == null) {
      getSupportFragmentManager()
          .beginTransaction()
          .add(android.R.id.content, new MyFlutterFragment())
          .commitNow();
    }
  }
}