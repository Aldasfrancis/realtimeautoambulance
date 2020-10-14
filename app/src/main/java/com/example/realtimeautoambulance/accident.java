package com.example.realtimeautoambulance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class accident extends AppCompatActivity {
    EditText mEnterVehicleNumber;
    TextView mSubmit;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accidentreport);

        mEnterVehicleNumber = findViewById(R.id.EnterVehicleNumber);
        mSubmit             = findViewById(R.id.Submit);

        fAuth = FirebaseAuth.getInstance();

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String EnterVehicleNumber = mEnterVehicleNumber.getText().toString().trim();

                if(TextUtils.isEmpty(EnterVehicleNumber)){
                    mEnterVehicleNumber.setError("Vehicle number is required");
                    return;
                }

                //registering user in firebase
             }
        });
    }
}