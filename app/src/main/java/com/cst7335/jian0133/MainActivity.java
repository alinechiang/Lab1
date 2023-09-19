package com.cst7335.jian0133;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        Button clickHereButton = findViewById(R.id.clickHereButton);
        Switch switchButton = findViewById(R.id.switchButton);
        View layout = findViewById(R.id.layout);

        clickHereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toastMessage = getResources().getString(R.string.toast_message);
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
            }
        });

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String state = isChecked ? "on" : "off";
                String snackbarMessage = "The switch is now " + state;

                Snackbar snackbar = Snackbar.make(layout, snackbarMessage, Snackbar.LENGTH_LONG);

                if (isChecked) {
                    snackbar.setAction("Undo", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // Perform the action to revert the switch state (if needed)
                            switchButton.setChecked(false); // For example, set it back to off
                        }
                    });
                }

                snackbar.show();
            }
        });
    }
}