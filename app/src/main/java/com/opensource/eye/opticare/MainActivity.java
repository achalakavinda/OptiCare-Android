package com.opensource.eye.opticare;

import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import Models.UserStatic;
import Services.HttpRequest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Intent intent = null;
    RelativeLayout relativeLayout_1;
    Button buttonLogin;

    EditText editTextUsername;
    EditText editTextPassword;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            relativeLayout_1.setVisibility(View.VISIBLE);
        }
    };

    //request variables
    RequestQueue queue = null;
    String url =new HttpRequest().getUri();

    @Override
    public void onStart()
    {
        super.onStart();
        System.out.println("Login Method call");
        queue = Volley.newRequestQueue(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        relativeLayout_1 = (RelativeLayout) findViewById(R.id.relativeLayout_1);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);
        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonLogin:

                if(editTextUsername.getText().length()>0 && editTextPassword.getText().length()>0){
                    intent = new Intent(getApplicationContext(), HomeActivity.class);
                    loginFn();
                }else {
                    Toast.makeText(getApplicationContext(),"Please enter credentials..",Toast.LENGTH_SHORT).show();
                }


                break;
        }
    }


    public void loginFn() {

        Map<String, String> params = new HashMap<String, String>();
        params.put("email", editTextUsername.getText().toString());
        params.put("password", editTextPassword.getText().toString());

        System.out.println("Login Method call");

        JSONObject parameters = new JSONObject(params);

        System.out.println(url + "/login");

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, url + "/login", parameters, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println("Method :"+response.toString());


                if (response.length() > 0) {
                    try {
                        Boolean status = response.getBoolean("status");
                        String successMsg = response.getString("message");

                        if(status){
                            JSONObject userJson = response.getJSONObject("user");

                            UserStatic.setUserId(userJson.getString("id"));
                            UserStatic.setUsername(userJson.getString("name"));
                            UserStatic.setEmail(userJson.getString("email"));
                            UserStatic.setUserType(userJson.getString("type").toUpperCase());
                            UserStatic.setUserType(userJson.getString("type").toUpperCase());
                            UserStatic.setIsActive(userJson.getString("is_active").toUpperCase());

                            Toast.makeText(getApplicationContext(),successMsg,Toast.LENGTH_LONG).show();
                            queue.stop();
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(),successMsg,Toast.LENGTH_LONG).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                } else {
                    System.out.println("no data");
                    Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"server error",Toast.LENGTH_LONG).show();

            }
        });

        // Add the request to the RequestQueue.
        queue.add(objectRequest);
    }

}
