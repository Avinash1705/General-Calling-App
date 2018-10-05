package com.example.avinash.call;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {
    EditText num;
    Button call;
    private  int req_call=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = findViewById(R.id.etnumber);
        call = findViewById(R.id.btcall);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, req_call);
                    }
                    else {

                        String n = num.getText().toString();
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel: " + n));
                        startActivity(intent);

                    }
                        return;
                    }

                }
        });
    }
}
