package com.example.realtimeautoambulance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText mName,mMobilePhone,mEmergency1,mEmergency2,mVehicleNumber;
    TextView mUpdateButton;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName          = findViewById(R.id.Name);
        mMobilePhone   = findViewById(R.id.MobilePhone);
        mEmergency1    = findViewById(R.id.Emergency1);
        mEmergency2    = findViewById(R.id.Emergency2);
        mVehicleNumber = findViewById(R.id.VehicleNumber);
        mUpdateButton  = findViewById(R.id.UpdateButton);

        fAuth = FirebaseAuth.getInstance();


        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = mName.getText().toString().trim();
                String MobilePhone = mMobilePhone.getText().toString().trim();

                if(TextUtils.isEmpty(Name)){
                    mName.setError("Name is required");
                    return;
                }
                if(TextUtils.isEmpty(MobilePhone)){
                    mMobilePhone.setError("MobilePhone is required");
                    return;
                }

                //registering user in firebase

                fAuth.createUserWithEmailAndPassword(Name,MobilePhone).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "User Created",Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getApplicationContext(),"Error"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        }
        });
    }
}