package edu.temple.coloractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

// 1. Create an app with activity ColorActivity as Main
public class ColorActivity extends AppCompatActivity {

    TextView bgTextView; // my text view background object
    Spinner pnSpinner; // my spinner object
    ArrayList<String> pnColors; // my Array List (Integer) object
    ConstraintLayout pnLayout; // my layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reference objects by R.id
        pnSpinner = findViewById(R.id.pnSpinner);
        bgTextView = findViewById(R.id.bgTextView);
        pnLayout = (ConstraintLayout)findViewById(R.id.layout);

        // make sure views are found in log, if not found, will display false
        Log.d("ColorActivity", "pnSpinner was found " + (pnSpinner != null));
        Log.d("ColorActivity", "bgTextView was found " + (bgTextView != null));

        // make array list of 10 string of colors, data set
        pnColors = new ArrayList<>();
        pnColors.add("Choose a Color");
        pnColors.add("Green");
        pnColors.add("Blue");
        pnColors.add("Black");
        pnColors.add("Red");
        pnColors.add("Dark Gray");
        pnColors.add("Gray");
        pnColors.add("Yellow");
        pnColors.add("Magenta");
        pnColors.add("Cyan");
        pnColors.add("Light Gray");

        final BaseAdapter pnAdapter = new ColorAdapter(this, pnColors);
        pnSpinner.setAdapter(pnAdapter);
        pnLayout = findViewById(R.id.layout);

        pnSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // log follows above line as reference
                Log.d("ColorActivity", "new item selected... position = " + position + "... id = " + id);

                // getting item at position as a string, parent is getting item from adapter (Low coupling)
                bgTextView.setText(parent.getItemAtPosition(position).toString());
                bgTextView.setTextColor(Integer.parseInt(String.valueOf(position)));

                Log.d("ColorActivity","back ground Color list is functional");
                if (pnSpinner.getSelectedItem().toString().equals("Choose a Color")) {
                    bgTextView.setBackgroundColor(Color.WHITE);
                }
                else if (pnSpinner.getSelectedItem().toString().equals("Green")) {
                    bgTextView.setBackgroundColor(Color.GREEN); //bg turns green
                }
                else if (pnSpinner.getSelectedItem().toString().equals("Blue")) {
                    bgTextView.setBackgroundColor(Color.BLUE);
                }
                else if (pnSpinner.getSelectedItem().toString().equals("Black")) {
                    bgTextView.setBackgroundColor(Color.BLACK);
                }
                else if (pnSpinner.getSelectedItem().toString().equals("Red")) {
                    bgTextView.setBackgroundColor(Color.RED);
                }
                else if (pnSpinner.getSelectedItem().toString().equals("Dark Gray")) {
                    bgTextView.setBackgroundColor(Color.DKGRAY);
                }
                else if (pnSpinner.getSelectedItem().toString().equals("Gray")) {
                    bgTextView.setBackgroundColor(Color.GRAY);
                }
                else if (pnSpinner.getSelectedItem().toString().equals("Yellow")) {
                    bgTextView.setBackgroundColor(Color.YELLOW);
                }
                else if (pnSpinner.getSelectedItem().toString().equals("Magenta")) {
                    bgTextView.setBackgroundColor(Color.MAGENTA);
                }
                else if (pnSpinner.getSelectedItem().toString().equals("Cyan")) {
                    bgTextView.setBackgroundColor(Color.CYAN);
                }
                else if (pnSpinner.getSelectedItem().toString().equals("Light Gray")) {
                    bgTextView.setBackgroundColor(Color.LTGRAY);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}