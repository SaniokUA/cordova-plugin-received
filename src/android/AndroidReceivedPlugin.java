package com.rex.plugin;

import android.content.Intent;

import com.tapapp.rex.WorksService;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class AndroidReceivedPlugin extends CordovaPlugin {


    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        //and call your method
        executeJavascript("sayHello('bear')", webView);
    }

    private static synchronized void executeJavascript(final String strJS, CordovaWebView myWebView) {

        Runnable jsLoader = new Runnable() {
            public void run() {
                myWebView.loadUrl("javascript:" + strJS);
            }
        };
        try {
            Method post = myWebView.getClass().getMethod("post", Runnable.class);
            post.invoke(myWebView, jsLoader);
        } catch (Exception e) {
            ((Activity) (myWebView.getContext())).runOnUiThread(jsLoader);
        }
    }

}