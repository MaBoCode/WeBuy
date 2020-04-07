package com.example.webuy.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class NetworkSingleton {
    private static NetworkSingleton instance;
    private RequestQueue requestQueue;
    private static Context context;

    private NetworkSingleton(Context context) {
        this.context = context;

    }

    public static synchronized NetworkSingleton getInstance(Context context) {
        if(instance == null) {
            instance = new NetworkSingleton(context);
        }

        return instance;
    }

    public RequestQueue getRequestQueue() {
        if(requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }
}
