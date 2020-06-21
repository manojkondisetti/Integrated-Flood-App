package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText people, areatop, areanontop, average;
    private int noOfPeople, areaOfRoofTop, areaOfNonRoofTop, averageWaterDemand, selectedtype1, selectedtype2;
    private RadioButton radioButton1, radioButton2;
    private RadioGroup radioGroup1, radioGroup2;
    private String roofType, bmptype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        Button next = (Button) findViewById(R.id.NextMain);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                people = (EditText) findViewById(R.id.NumberOfPeople);
                areatop = (EditText) findViewById(R.id.AreaOfRoof);
                areanontop = (EditText) findViewById(R.id.NonRoofTopArea);
                average = (EditText) findViewById(R.id.AverageWaterDemand);
                radioGroup1 = (RadioGroup) findViewById(R.id.RoofTypes);
                radioGroup2 = (RadioGroup) findViewById(R.id.BMPs);

                boolean fieldsOK = validate(new EditText[]{people, areatop, areanontop, average});
                if (fieldsOK && radioGroup1.getCheckedRadioButtonId() != -1 && radioGroup2.getCheckedRadioButtonId() != -1) {

                    noOfPeople = Integer.parseInt(people.getText().toString());
                    areaOfRoofTop = Integer.parseInt(areatop.getText().toString());
                    areaOfNonRoofTop = Integer.parseInt(areanontop.getText().toString());
                    averageWaterDemand = Integer.parseInt(average.getText().toString());
                    selectedtype1 = radioGroup1.getCheckedRadioButtonId();
                    radioButton1 = (RadioButton) findViewById(selectedtype1);
                    roofType = radioButton1.getText().toString();
                    selectedtype2 = radioGroup2.getCheckedRadioButtonId();
                    radioButton2 = (RadioButton) findViewById(selectedtype2);
                    bmptype = radioButton2.getText().toString();

                    UserData.setNoOfPeople(noOfPeople);
                    UserData.setAreaOfRoofTop(areaOfRoofTop);
                    UserData.setAreaOfNonRoofTop(areaOfNonRoofTop);
                    UserData.setAverageWaterDemand(averageWaterDemand);
                    UserData.setRoofType(roofType);
                    UserData.setBmpType(bmptype);

                    System.out.println("noOfPeople " + UserData.getNoOfPeople());
                    System.out.println("areaOfRoof " + UserData.getAreaOfRoofTop());
                    System.out.println("averageWaterDemand " + UserData.getAverageWaterDemand());
                    System.out.println("roofType " + UserData.getRoofType());

                    Toast.makeText(getApplicationContext(), "Data has been saved", Toast.LENGTH_SHORT).show();
                    openMapsActivity();
                } else {
                    System.out.println("2");
                    Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openMapsActivity() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    private boolean validate(EditText[] fields) {
        for (int i = 0; i < fields.length; i++) {
            EditText currentField = fields[i];
            if (TextUtils.isEmpty(currentField.getText().toString())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); //commented this line in order to disable back press
        //Write your code here
        //Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }
}