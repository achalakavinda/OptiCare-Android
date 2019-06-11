package com.opensource.eye.opticare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.opensource.eye.opticare.Adapters.ReminderPatientListAdapter;
import com.opensource.eye.opticare.Models.ReminderPatientModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Models.UserStatic;
import Services.HttpRequest;

public class PatientReminderActivity extends AppCompatActivity {

    RequestQueue queue = null;
    String url =new HttpRequest().getUri();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<ReminderPatientModel> input = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_reminder);

        layoutManager = new LinearLayoutManager(this);
        recyclerView =  findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        recyclerView.setLayoutManager(layoutManager);

        queue = Volley.newRequestQueue(this);

        getCheckups();


    }


    public void getCheckups(){
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url+"/user/"+ UserStatic.getUserId() +"/checkups", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                if(response.length()>0){
                    System.out.println(response.toString());

                    Toast.makeText(getApplicationContext(),"Loading......",Toast.LENGTH_LONG).show();

                    try {

                        JSONArray jsonArray = response.getJSONArray("checkup");

                        System.out.println(jsonArray.toString());

                        int run = 0;
                        for (int x = 0; x < jsonArray.length(); x++)
                        {
                            run = x;
                            ReminderPatientModel Model = new ReminderPatientModel( jsonArray.getJSONObject(x).getString("id"),jsonArray.getJSONObject(x).getString("optician_id"),jsonArray.getJSONObject(x).getString("optician_name"),jsonArray.getJSONObject(x).getString("patient_name"),jsonArray.getJSONObject(x).getString("patient_id"),jsonArray.getJSONObject(x).getString("date"),jsonArray.getJSONObject(x).getString("type").toUpperCase(), jsonArray.getJSONObject(x).getString("isMobile"), jsonArray.getJSONObject(x).getString("status").toUpperCase(),jsonArray.getJSONObject(x).getString("note"),true );
                            input.add(Model);
                        }

                        if(0 == run){
                            Toast.makeText(getApplicationContext(),"No Check up....",Toast.LENGTH_SHORT).show();
                        }

                        mAdapter = new ReminderPatientListAdapter(input);
                        recyclerView.setAdapter(mAdapter);

                    }
                    catch (JSONException e){
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"No Check up....",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("error : "+error.getMessage()+" url "+url+"post");
                Toast.makeText(getApplicationContext(),"error : "+error.getMessage()+" url "+url+"post",Toast.LENGTH_LONG).show();
            }
        });
        queue.add(objectRequest);
    }

}
