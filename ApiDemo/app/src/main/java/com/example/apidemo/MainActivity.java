package com.example.apidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        imageView=findViewById(R.id.imageView);
String url="https://randomuser.me/api/";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
//                    Log.d("sorabh",">>>>>>>>>>>>>>>>>>>>>>>"+response.getJSONArray("results").getJSONObject(0).getJSONObject("name").getString("title").toString());
                    String name=response.getJSONArray("results").getJSONObject(0).getJSONObject("name").getString("title").toString()+" "+
                            response.getJSONArray("results").getJSONObject(0).getJSONObject("name").getString("first").toString()+ " "+
                            response.getJSONArray("results").getJSONObject(0).getJSONObject("name").getString("last").toString();
                    String email=response.getJSONArray("results").getJSONObject(0).getString("email");
                    String phone=response.getJSONArray("results").getJSONObject(0).getString("phone");
                    String city=response.getJSONArray("results").getJSONObject(0).getJSONObject("location").getString("city");
                    String url=response.getJSONArray("results").getJSONObject(0).getJSONObject("picture").getString("medium");
                    Uri uri=Uri.parse(url);
                    Log.d("sorabh","name "+url);

                        Picasso.with(MainActivity.this).load(uri).into(imageView);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
Log.d("sorabh",">>>>>>>>>>>>>>>>>>"+error.getMessage());
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}