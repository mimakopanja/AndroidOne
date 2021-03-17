package com.mirjanakopanja.androidhomeworkone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Switch aSwitch;
    private RadioGroup radioGroup;
    private Button button;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initializeFields();
        activateOptions();
        changeTextColor();
        onButtonClick();

    }

    private void initializeFields() {
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        aSwitch = findViewById(R.id.switchBtn);
        button = findViewById(R.id.button);
        radioGroup = findViewById(R.id.radioColorGroup);
        linearLayout = findViewById(R.id.optionLayout);
        String string = editText.getText().toString();

    }
    private void activateOptions() {
        aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                linearLayout.setVisibility(View.VISIBLE);
            }
            else {
                linearLayout.setVisibility(View.GONE);
            }
        });
    }

    private void changeTextColor() {
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioRed){
                int color = ContextCompat.getColor(getApplicationContext(), R.color.red);
                textView.setTextColor(color);
            }
            else if (checkedId == R.id.radioGreen){
                int color = ContextCompat.getColor(getApplicationContext(), R.color.green);
                textView.setTextColor(color);
            }
            else if(checkedId == R.id.radioYellow){
                int color = ContextCompat.getColor(getApplicationContext(), R.color.yellow);
                textView.setTextColor(color);
            }
        });
    }



    private void onButtonClick() {
        button.setOnClickListener(v -> {
            String string = editText.getText().toString();
            textView.setText(string);
            textView.setAllCaps(true);
        });
    }
}