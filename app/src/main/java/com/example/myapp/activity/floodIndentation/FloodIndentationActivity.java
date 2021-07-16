package com.example.myapp.activity.floodIndentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;
import com.example.myapp.model.FloodIndentationUserData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FloodIndentationActivity extends AppCompatActivity {
    private EditText A1, A2, A3, A4, A5, A6, A7, A8;
    private Double rainfall, elevation, slope, distanceFromStream,
            evapotranspiration, surfaceTemperature, vegetationIndex, curveNumber;
    private FloodIndentationUserData floodIndentationUserData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floodindentation);
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        FloatingActionButton next = findViewById(R.id.NextMain);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                A1 = findViewById(R.id.A1);
                A2 = findViewById(R.id.A2);
                A3 = findViewById(R.id.A3);
                A4 = findViewById(R.id.A4);
                A5 = findViewById(R.id.A5);
                A6 = findViewById(R.id.A6);
                A7 = findViewById(R.id.A7);
                A8 = findViewById(R.id.A8);

                if(validateInput()) {
                    rainfall = Double.parseDouble(A1.getText().toString());
                    elevation = Double.parseDouble(A2.getText().toString());
                    slope = Double.parseDouble(A3.getText().toString());
                    distanceFromStream = Double.parseDouble(A4.getText().toString());
                    evapotranspiration = Double.parseDouble(A5.getText().toString());
                    surfaceTemperature = Double.parseDouble(A6.getText().toString());
                    vegetationIndex = Double.parseDouble(A7.getText().toString());
                    curveNumber = Double.parseDouble(A8.getText().toString());

                    floodIndentationUserData = new FloodIndentationUserData(rainfall, elevation, slope,
                            distanceFromStream, evapotranspiration, surfaceTemperature, vegetationIndex, curveNumber);
                    floodIndentationFinalActivity();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private boolean validateInput() {
        return A1.length()!=0 && A2.length()!=0 && A3.length()!=0 && A4.length()!=0 &&
                A5.length()!=0 && A6.length()!=0 && A7.length()!=0 && A8.length()!=0;
    }

    private void floodIndentationFinalActivity() {
        Intent intent = new Intent(this, FloodIndentationFinalActivity.class);
        intent.putExtra("floodIndentationUserData", floodIndentationUserData);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); //commented this line in order to disable back press
        //Write your code here
        //Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }
}
