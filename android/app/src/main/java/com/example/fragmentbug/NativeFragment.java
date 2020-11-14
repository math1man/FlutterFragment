package com.example.fragmentbug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import io.flutter.embedding.android.FlutterFragment;

public class NativeFragment extends Fragment {
    private static final String TAG_FLUTTER_FRAGMENT = "flutter_fragment";
    private View view;

    public NativeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_native, container, false);
        Button button = view.findViewById(R.id.button);
        FlutterFragment flutterFragment = new MyFlutterFragment();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.frameLayout, flutterFragment, TAG_FLUTTER_FRAGMENT)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}