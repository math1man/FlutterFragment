package com.example.fragmentbug;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import java.util.List;

import io.flutter.Log;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;

public class MyFlutterFragment extends FlutterFragment implements PlatformChannel.PlatformMessageHandler {
    private final static String TAG = "MyFlutterFragment";
    private OnBackPressedCallback onBackPressedCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Log.w(TAG, "OnBackPressedCallback Invoked");
            }
        };
        getFlutterEngine().getPlatformChannel().setPlatformMessageHandler(this);
        getActivity().getOnBackPressedDispatcher().addCallback(onBackPressedCallback);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onBackPressedCallback.remove();
    }

    @Override
    public void playSystemSound(@NonNull PlatformChannel.SoundType soundType) {

    }

    @Override
    public void vibrateHapticFeedback(@NonNull PlatformChannel.HapticFeedbackType feedbackType) {

    }

    @Override
    public void setPreferredOrientations(int androidOrientation) {

    }

    @Override
    public void setApplicationSwitcherDescription(@NonNull PlatformChannel.AppSwitcherDescription description) {

    }

    @Override
    public void showSystemOverlays(@NonNull List<PlatformChannel.SystemUiOverlay> overlays) {

    }

    @Override
    public void restoreSystemUiOverlays() {

    }

    @Override
    public void setSystemUiOverlayStyle(@NonNull PlatformChannel.SystemChromeStyle systemUiOverlayStyle) {

    }

    @Override
    public void popSystemNavigator() {
        OnBackPressedDispatcher onBackPressedDispatcher = getActivity().getOnBackPressedDispatcher();
        if (!onBackPressedDispatcher.hasEnabledCallbacks()) {
            onBackPressedDispatcher.onBackPressed();
            return;
        }

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            getActivity().finish();
        }
    }

    @Nullable
    @Override
    public CharSequence getClipboardData(@Nullable PlatformChannel.ClipboardContentFormat format) {
        return null;
    }

    @Override
    public void setClipboardData(@NonNull String text) {

    }

    @Override
    public boolean clipboardHasStrings() {
        return false;
    }
}
