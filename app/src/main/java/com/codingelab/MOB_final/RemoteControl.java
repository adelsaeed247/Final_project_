package com.codingelab.MOB_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RemoteControl extends AppCompatActivity {
    private Button insert;
    private Button showData;
    private Button btnUpdate;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phpcon);
        this.insert=(Button)findViewById(R.id.insertdata);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent updateStudent = new Intent(RemoteControl.this, RemoteInsertActivity.class);
                startActivity(updateStudent);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        this.showData=(Button)findViewById(R.id.showData);
        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent show = new Intent(RemoteControl.this, ListviewActivity.class);
                startActivity(show);
            }
        });


        this.btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent update = new Intent(RemoteControl.this, ListviewRemoteUpdate.class);
                startActivity(update);
            }
        });
        this.btnSearch = (Button) findViewById(R.id.btnsearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent search = new Intent(RemoteControl.this, RemoteSearch.class);
                startActivity(search);
            }
        });

    }
}
