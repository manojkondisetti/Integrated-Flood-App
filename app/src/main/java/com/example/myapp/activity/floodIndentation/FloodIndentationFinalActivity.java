package com.example.myapp.activity.floodIndentation;

import android.os.Bundle;
import android.os.FileObserver;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;
import com.example.myapp.model.FloodIndentationUserData;

import java.io.File;

/*import ml.dmlc.xgboost4j.java.Booster;
import ml.dmlc.xgboost4j.java.XGBoost;
import ml.dmlc.xgboost4j.java.XGBoostError;*/

public class FloodIndentationFinalActivity extends AppCompatActivity {

    private EditText mlResult;
    FloodIndentationUserData floodIndentationUserData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        floodIndentationUserData = (FloodIndentationUserData) getIntent()
                .getSerializableExtra("floodIndentationUserData");
        setContentView(R.layout.activity_floodindentationfinal);
        displayResults();
    }

    private void displayResults() {
        TextView mlResult = findViewById(R.id.mlResult);
        mlResult.setText(getResultFromMLModel() + " Units");
    }

    private double getResultFromMLModel() {
        try {
            System.out.println(System.getProperty("user.dir"));
            File file = new File("../../mlmodel/model.dat");
            //Booster booster = XGBoost.loadModel("../../mlmodel/model.dat");
            //System.out.println(booster.getAttrs());
        } catch (Exception e) {
            System.out.println("Exception");
        }
        return 1.23;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); //commented this line in order to disable back press
        //Write your code here
        //Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }
}
