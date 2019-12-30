package com.codingelab.MOB_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoteSearch extends AppCompatActivity {
    EditText txtGVFU;
    Button btnfet_Data;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_search);
        txtGVFU = (EditText)findViewById(R.id.editText);
        btnfet_Data = (Button)findViewById(R.id.buttonfetch);
        listview = (ListView)findViewById(R.id.listView);
        btnfet_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            } });
    }
    private void getData() {
        String value = txtGVFU.getText().toString().trim();
        if (value.equals("")) {
            return;
        }
        String url = UsersPHPSearch.URL + txtGVFU.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RemoteSearch.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response) {
        final ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(UsersPHPSearch.ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(UsersPHPSearch.ID);
                String Name = jo.getString(UsersPHPSearch.NAME);
                String Phone = jo.getString(UsersPHPSearch.PHONE);
                String Email = jo.getString(UsersPHPSearch.EMAIL);
                final HashMap<String, String> User = new HashMap<>();
                User.put(UsersPHPSearch.ID, "id: "+id);
                User.put(UsersPHPSearch.NAME, "name: "+Name);
                User.put(UsersPHPSearch.PHONE, "phone: "+Phone);
                User.put(UsersPHPSearch.EMAIL,  "email: "+Email);
                list.add(User);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                RemoteSearch.this, list, R.layout.listview_remote_search,
                new String[]{
                        UsersPHPSearch.ID,
                        UsersPHPSearch.NAME,
                        UsersPHPSearch.PHONE,
                        UsersPHPSearch.EMAIL},
                new int[]{
                        R.id.id1,
                        R.id.Name1,
                        R.id.Phone1,
                        R.id.Email,
                });
        listview.setAdapter(adapter);

    }



}
