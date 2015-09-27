package com.mortenjust.rsstest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {

    String TAG = "mj.main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetchData();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void simplerfetchData(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://www.google.com";
        StringRequest stringRequest  = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "response is " + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "fejl");
            }
        });

        queue.add(stringRequest);

    }

    void fetchData(){
        String url = "http://www.dr.dk/mu/Feed/deadline?format=podcast&limit=500";
        SimpleXmlRequest<TvShow> showRequest = new SimpleXmlRequest<TvShow>(Request.Method.GET, url, TvShow.class,
                new Response.Listener<TvShow>() {
                    @Override
                    public void onResponse(TvShow response) {
                        Log.d(TAG, "most recent show is "+response.getLatestEpisode());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "error here "+error.getLocalizedMessage());
                    }
                });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(showRequest);
    }


    void noteExample_fetchData(){
        Log.d(TAG, "fetchdata");
        String url = "http://www.w3schools.com/xml/note.xml";
     // String url = "http://www.dr.dk/mu/Feed/deadline";
        SimpleXmlRequest<Note> simpleRequest = new SimpleXmlRequest<Note>(Request.Method.GET, url, Note.class,
                new Response.Listener<Note>()
                {
                    @Override
                    public void onResponse(Note response) {
                        // response Object
                        Log.d(TAG, "we got the note back and the heading is "+response.getHeading());
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error Object
                        Log.d(TAG, "volley error: "+error.getLocalizedMessage());
                    }
                }
        );

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(simpleRequest);

    }
}
