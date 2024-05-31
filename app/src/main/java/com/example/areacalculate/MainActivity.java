package com.example.areacalculate;

import static android.widget.AdapterView.*;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    double area =0;
    TextView tv;
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

        Bundle b = new Bundle();
        b.putString("name","Fahed");
        b.putInt("age",23);





        Toast.makeText(getBaseContext(), "onCreate", Toast.LENGTH_LONG).show();
        // inflate items
        Spinner spinner = findViewById(R.id.spinner);
        EditText et1 = findViewById(R.id.editTextNumberDecimal1);//Rectangle
        EditText et2 = findViewById(R.id.editTextNumberDecimal2);
        EditText et3 = findViewById(R.id.editTextNumberDecimal3);//circle
        EditText et4 = findViewById(R.id.editTextNumberDecimal4);//Triangle
        EditText et5 = findViewById(R.id.editTextNumberDecimal5);

        tv = findViewById(R.id.textView);

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

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getBaseContext(),"OnStart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getBaseContext(),"OnResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getBaseContext(),"OnPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getBaseContext(), "OnStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getBaseContext(), "OnDestroy", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getBaseContext(), "onRestart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("area",tv.getText().toString());
        Toast.makeText(getBaseContext(), "on Save Instance State", Toast.LENGTH_LONG).show();

    }
/*android:screenOrientation="portrait"
            android:configChanges="orientation|screenSize"
* */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        String y = savedInstanceState.getString("area");
        tv.setText(y);

        Toast.makeText(getBaseContext(), "on Restore Instance State", Toast.LENGTH_LONG).show();

    }
}