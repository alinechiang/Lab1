package com.cst7335.jian0133;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;




public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "PrefsFile";
    private EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        emailEditText = findViewById(R.id.editTextEmail);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String email = settings.getString("email","");
        emailEditText.setText(email);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("email",emailEditText.getText().toString());
        editor.apply();
    }
}