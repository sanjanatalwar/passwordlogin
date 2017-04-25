package com.example.admin.passwordinsertion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    EditText eename, eepass;
    Button b;
    Student stu;
    String email;
    String password;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        requestQueue = new Volley().newRequestQueue(this);
        stu = new Student();
        init();
    }

    void init() {
        eename = (EditText) findViewById(R.id.username);
        eepass = (EditText) findViewById(R.id.userpassword);
        b = (Button) findViewById(R.id.login);
        requestQueue = Volley.newRequestQueue(this);
    }

    public void ButtonClick(View v) {
        int id = v.getId();
        if (id == R.id.login) {
            email = eename.getText().toString().trim();

            password = eepass.getText().toString().trim();


            logIn();
        }
    }

    public void logIn() {


        final StringRequest request = new StringRequest(Request.Method.POST, Util.LOGIN_STUDENT_PHP, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(Login.this, "Response: " + response, Toast.LENGTH_LONG).show();


            }

    }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, "Some Error" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();

                map.put("email", email);


                map.put("password", password);
                return map;
            }


        };
        requestQueue.add(request);

    }
}