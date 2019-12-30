package com.codingelab.MOB_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RemoteInsertActivity extends AppCompatActivity {

    EditText name,phone,email;
    Button insert;
    private Sync sync;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phpdb);

        this.sync =new Sync();

        insert=(Button)findViewById(R.id.bttnInsert);
        name=(EditText)findViewById(R.id.editTxtName);
        phone=(EditText)findViewById(R.id.editTxtPhone);
        email=(EditText)findViewById(R.id.editTxtEmail);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg= sync.doInBackground("insert",name.getText().toString(),phone.getText().toString(),email.getText().toString());
                Toast.makeText(getBaseContext(),msg, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
