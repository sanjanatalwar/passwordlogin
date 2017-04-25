package com.example.admin.passwordinsertion;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    EditText ename, ephone, eemail, ecity;
    Button b,login;
    RequestQueue requestQueue;

    Student student;

    void init() {
        student = new Student();

        requestQueue = Volley.newRequestQueue(this);
        ename = (EditText) findViewById(R.id.name);
        ephone = (EditText) findViewById(R.id.phone);
        eemail = (EditText) findViewById(R.id.email);
        ecity = (EditText) findViewById(R.id.city);
        b = (Button) findViewById(R.id.submit);
login=(Button)findViewById(R.id.newlogin);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        randomString(7);
    }




    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }


    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.submit) {
            student.setName(ename.getText().toString().trim());
            student.setPhone(ephone.getText().toString().trim());
            student.setEmail(eemail.getText().toString().trim());
            student.setCity(ecity.getText().toString().trim());
            student.setPassword(randomString(7));

            Log.i("test", student.toString());
            insertIntoCloud();
            sendEmail();
        }
    }


    public void insertIntoCloud() {

        StringRequest request = new StringRequest(Request.Method.POST, Util.INSERT_STUDENT_PHP, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, "Response: " + response, Toast.LENGTH_LONG).show();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Some Error" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("name", student.getName());
                map.put("phone", student.getPhone());
                map.put("email", student.getEmail());

                map.put("city", student.getCity());
                map.put("password", student.getPassword());
                return map;
            }


        };
        requestQueue.add(request);

    }

    public void sendEmail() {


        String[] EMAIL = {"ravinder1131994@gmail.com"};
        ;
        String[] TO = {student.getEmail()};
       // String[] CC = {"ravinder1131994@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        //emailIntent.setData(Uri.parse("mailto:ravinder1131994@gmail.com"));
        emailIntent.setData(Uri.parse("ravinder1131994@gmail.com"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        //emailIntent.putExtra(Intent.EXTRA_CC, CC);


        {

            //emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
            emailIntent.putExtra(Intent.EXTRA_TEXT, student.getPassword());

            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                finish();
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MainActivity.this,
                        "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }
        }

    }
public  void  newAcitivity(View v){
    int id=v.getId();
    if(id==R.id.newlogin){
        Intent i=new Intent(MainActivity.this,Login.class);
        startActivity(i);
    }
}
}