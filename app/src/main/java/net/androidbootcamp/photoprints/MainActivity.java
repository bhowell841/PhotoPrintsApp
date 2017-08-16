package net.androidbootcamp.photoprints;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    // declare variables
    double printsOrdered;
    double finalPrice;
    double smallPrice = 0.19;
    double mediumPrice = 0.49;
    double largePrice = 0.79;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define widgets
        final EditText number = (EditText) findViewById(R.id.txtNumberOfPrints);
        final RadioButton fourBySix = (RadioButton) findViewById(R.id.rad4x6);
        final RadioButton fiveBySeven = (RadioButton) findViewById(R.id.rad5x7);
        final RadioButton eightByTen = (RadioButton) findViewById(R.id.rad8x10);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button calculate = (Button) findViewById(R.id.btnOrder);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //convert the number of prints entered from string to a double
                printsOrdered = Double.parseDouble(number.getText().toString());
                //format decimal
                DecimalFormat hundredth = new DecimalFormat("##.##");

                //decision statement
                if (fourBySix.isChecked()){
                if (printsOrdered <= 50) {
                    finalPrice = printsOrdered * smallPrice;
                    result.setText("The Order Cost is $" + hundredth.format(finalPrice));
                } else {
                    Toast.makeText(MainActivity.this, "Order must be 50 or less", Toast.LENGTH_LONG).show();
                }
            }

                if (fiveBySeven.isChecked()) {
                    if (printsOrdered <= 50) {
                        finalPrice = printsOrdered * mediumPrice;
                        result.setText("The Order Cost is $" + hundredth.format(finalPrice));
                    } else {
                        Toast.makeText(MainActivity.this, "Order must be 50 or less", Toast.LENGTH_LONG).show();
                    }
                }


                if (eightByTen.isChecked()) {

                    if (printsOrdered <= 50) {

                        finalPrice = printsOrdered * largePrice;
                        result.setText("The Order Cost is $" + hundredth.format(finalPrice));
                    } else {
                        Toast.makeText(MainActivity.this, "Order must be 50 or less", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}//end class
