package com.codingelab.MOB_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataBases extends AppCompatActivity {

    private Button btnlocal;
    private Button btnremote;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databases);

        btnlocal = (Button) findViewById(R.id.btnlocal);
       btnremote = (Button) findViewById(R.id.btnremote);

        btnlocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sqlLiteIntent = new Intent( DataBases.this, SQLitedb.class);
                startActivity(sqlLiteIntent);
            }
        });


        btnremote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sqlLiteIntent = new Intent( DataBases.this, RemoteControl.class);
                startActivity(sqlLiteIntent);
            }
        });
    }
}
