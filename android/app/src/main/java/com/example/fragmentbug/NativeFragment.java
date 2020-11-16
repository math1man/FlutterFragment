package com.example.fragmentbug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public final class NativeFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_native, container, false);
    Button button = view.findViewById(R.id.button);
    button.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new MyFlutterFragment())
                .addToBackStack(null)
                .commit();
          }
        });
    return view;
  }
}
