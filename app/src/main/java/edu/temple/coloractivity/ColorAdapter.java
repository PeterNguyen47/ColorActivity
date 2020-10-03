package edu.temple.coloractivity;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

// 2. Created ColorAdapter that extends BaseAdapter to present set of color options
public class ColorAdapter extends BaseAdapter {

    Context context; //context object for adapter reference
    ArrayList<String> pnColors; // array of strings object
    Spinner pnSpinner;
    TextView bgTextView;
    // Ex. ArrayList<String> PN <- just an independent object from same class, can be any name

    // constructor
    public ColorAdapter(Context colorActivity, ArrayList<String> pnColors) {

        context = colorActivity; // THIS only needed when instance variables have same name
        this.pnColors = pnColors; // sent over from main activity using context color activity
        this.pnSpinner = pnSpinner;
    }

    // counts how many in data set by size because ArrayList (String uses length)
    @Override
    public int getCount() {
        Log.d("ColorActivity", "pnColors size is: " + pnColors.size());
        return pnColors.size();
    }

    // Give item found at this position, returns string
    @Override
    public Object getItem(int position) {
        // follow flow
        Log.d("ColorActivity", "position is: " + position); // position is "1"
        Log.d("ColorActivity", "pnColors position is: " + pnColors.get(position)); // color at position "Tabby cat"
        return pnColors.get(position); // checking 2 values, returns position of color in spinner
    }

    // left alone
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // where user sees initial display
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // How we want things to display to the user, default is selected for user
        Log.d("ColorActivity", "view position is: " + position);

        int pnColors[] = new int[11];
        pnColors[0] = Color.BLACK;
        pnColors[1] = Color.GREEN;
        pnColors[2] = Color.BLUE;
        pnColors[3] = Color.BLACK;
        pnColors[4] = Color.RED;
        pnColors[5] = Color.DKGRAY;
        pnColors[6] = Color.GRAY;
        pnColors[7] = Color.YELLOW;
        pnColors[8] = Color.MAGENTA;
        pnColors[9] = Color.CYAN;
        pnColors[10] = Color.LTGRAY;

        TextView bgTextView;
        if (convertView == null) {
            bgTextView = new TextView(context);
            bgTextView.setPadding(5, 5, 5, 5); // spacing in spinner (optional)
            bgTextView.setTextSize(18);
            bgTextView.setBackgroundColor(pnColors[position % pnColors.length]); // spinner bg color
        }
        else
            bgTextView = (TextView) convertView;
            bgTextView.setText(getItem(position).toString()); // get text from position
            bgTextView.setBackgroundColor(Color.WHITE); // spinner bg (WHITE)
            bgTextView.setTextColor(pnColors[position % pnColors.length]);

        return bgTextView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        Log.d("ColorActivity", "dropdown view position is: " + position);
        // TODO convert position to color string
        // TODO convert color string to color value
        // TODO set background text view to color value
        View v = getView(position, convertView, parent);

        return v;
    }

}
