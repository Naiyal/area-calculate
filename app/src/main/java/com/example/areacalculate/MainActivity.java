package com.example.areacalculate;

import static android.widget.AdapterView.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // inflate items
        Spinner spinner = findViewById(R.id.spinner);
        EditText et1 = findViewById(R.id.editTextNumberDecimal1);//Rectangle
        EditText et2 = findViewById(R.id.editTextNumberDecimal2);
        EditText et3 = findViewById(R.id.editTextNumberDecimal3);//circle
        EditText et4 = findViewById(R.id.editTextNumberDecimal4);//Triangle
        EditText et5 = findViewById(R.id.editTextNumberDecimal5);

        TextView tv = findViewById(R.id.textView);

        Button btn = findViewById(R.id.button);
        //circle -> pi * r * r
        //Rectangle -> w * h
        //Triangle -> 0.5 * base * h

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //            Toast toast =  Toast.makeText(get,position,500);
//            toast.show();
                switch (position){
                    case 0:
                        et1.setVisibility(View.GONE);
                        et2.setVisibility(View.GONE);
                        et3.setVisibility(View.GONE);
                        et4.setVisibility(View.GONE);
                        et5.setVisibility(View.GONE);
                        break;
                    case 1:
                        et1.setVisibility(View.VISIBLE);
                        et2.setVisibility(View.VISIBLE);
                        et3.setVisibility(View.GONE);
                        et4.setVisibility(View.GONE);
                        et5.setVisibility(View.GONE);
                        break;
                    case 2:
                        et1.setVisibility(View.GONE);
                        et2.setVisibility(View.GONE);
                        et3.setVisibility(View.VISIBLE);
                        et4.setVisibility(View.GONE);
                        et5.setVisibility(View.GONE);
                        break;
                    case 3:
                        et1.setVisibility(View.GONE);
                        et2.setVisibility(View.GONE);
                        et3.setVisibility(View.GONE);
                        et4.setVisibility(View.VISIBLE);
                        et5.setVisibility(View.VISIBLE);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int x = spinner.getSelectedItemPosition();
                    double area =0;
                    switch (x){
                        case 0:
                            tv.setText("Please select shape");
                            break;
                        case 1:
                            area  = Double.parseDouble(et1.getText().toString())*Double.parseDouble(et2.getText().toString());
                            tv.setText(area+" ");
                            break;
                        case 2:
                                     area =  Math.PI*Math.pow(Double.parseDouble(et3.getText().toString()),2);
                            tv.setText(area+" ");
                                     break;
                        case 3:
                                     area= 0.5*Double.parseDouble(et4.getText().toString())*Double.parseDouble(et5.getText().toString());
                            tv.setText(area+" ");
                                     break;

                    }

                    hideKeyboard();
                }
            });

    }
    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = getCurrentFocus();

        if (view == null) {
            view = new View(this);
        }

        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}