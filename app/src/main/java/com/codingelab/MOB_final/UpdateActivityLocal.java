package com.codingelab.MOB_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivityLocal extends AppCompatActivity {
    private EditText Name,Phone,Email;
    private Button update;
    DBHelper mydb;
    private Integer id;
    private String dName,dPhone,dEmail;
    private int found;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Name =  findViewById(R.id.eName);
        Phone =  findViewById(R.id.iPhone);
        Email =  findViewById(R.id.aEmail);
        update = findViewById(R.id.Update);
        mydb = new DBHelper(this);


        //Email.setText(getIntent().getExtras().getString("email"));
        //Phone.setText(getIntent().getExtras().getString("Phone"));
        Name.setText((getIntent().getExtras().getString("name")));
        Log.d("Tag", getIntent().getExtras().getString("id"));
        id = Integer.parseInt(getIntent().getExtras().getString("id"));

    }

    public void Update(View v)
    {
        mydb.updateContact(id,  Name.getText().toString(),Phone.getText().toString() , Email.getText().toString(),  null, null);

        finish();
    }
}
