package com.abc.com;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import cn.jpush.android.api.JPushInterface;

public class BootCompletedReceiver extends BroadcastReceiver {
    private NotificationManager nm;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (null == nm) {
            nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        Bundle bundle = intent.getExtras();

        System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");

            //openNotification(context,bundle);
            openURL(context, bundle);
        }

/*
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Intent newIntent = new Intent(context, StartService.class);
            context.startService(newIntent);
        }
*/
        /*
        if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            //打开自定义的Activity
            Intent i = new Intent(context, MainActivity.class);
            //i.putExtras(bundle);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
*/

    }

    WebView webview;
    private void openURL(Context context, Bundle bundle) {
        String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
        String myValue = "";
        try {
            //extras = "{\"myKey\":\"http://www.google.com\"}";
            JSONObject extrasJson = new JSONObject(extras);
            System.out.println("JsonJsonJson=" + extrasJson);
            myValue = extrasJson.optString("myKey");

/*
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://www.example.com");
            //webview.loadUrl("http://www.google.com");
            */

            Uri uri= Uri.parse("http://www.google.com");
            Intent i=new Intent(Intent.ACTION_VIEW,uri);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);

            /*
            URL url = new URL("http://www.google.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(15000);//设置链接超时时间
            conn.setReadTimeout(15000);//设置读取超时时间
            conn.setRequestMethod("GET");//设置请求参数
            conn.setRequestProperty("Connection", "Keep-Alive");//添加Header
            */
        } catch (Exception e) {
            return;
        }
    }

    private void openNotification(Context context, Bundle bundle) {
        String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
        String myValue = "";
        try {

            JSONObject extrasJson = new JSONObject(extras);
            myValue = extrasJson.optString("myKey");
            System.out.println("myValue=" + myValue);

            //根据消息内容跳转到指定页面
            Intent i = new Intent(context, Page2.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //i.putExtra("message1", "食屎啦！");
            //i.putExtra("businessindex", "2");
            context.startActivity(i);
        } catch (Exception e) {
            return;
        }
    }

}
