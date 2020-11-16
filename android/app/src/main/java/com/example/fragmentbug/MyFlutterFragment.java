package com.example.fragmentbug;

import android.content.Context;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterFragment;

public class MyFlutterFragment extends FlutterFragment {

  private final OnBackPressedCallback onBackPressedCallback =
      new OnBackPressedCallback(true) {
        @Override
        public void handleOnBackPressed() {
          onBackPressed();
        }
      };

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    requireActivity().getOnBackPressedDispatcher().addCallback(onBackPressedCallback);
  }
}
