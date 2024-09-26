package com.ncorti.kotlin.template.app;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.react.ReactFragment;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

public class MainActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_appcompose).setOnClickListener(button -> {
            Bundle launchOptions = new Bundle();
            launchOptions.putString("message", "my value");

            ReactFragment fragment = new ReactFragment.Builder()
                    .setComponentName("HelloWorld")
                    .setLaunchOptions(launchOptions)
                    .build();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.react_native_fragment, fragment)
                    .commit();
        });
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }
}
