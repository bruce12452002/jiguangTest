package com.abc.com;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.api.JPushClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Set<String> set = new HashSet<>();

        EditText et = findViewById(R.id.editText);
        EditText readonly = findViewById(R.id.readonly);
        Button addTag = findViewById(R.id.addTag);
        addTag.setOnClickListener(v -> {
            String etContent = et.getText().toString().trim();
            //標籤推送
            if (!etContent.isEmpty()) {
                set.add(etContent);
                readonly.setText(set.toString());
                et.setText("");
                Toast.makeText(MainActivity.this, "新增" + etContent + "成功", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "新增失敗，內容為空", Toast.LENGTH_LONG).show();
            }
        });

        Button removeTag = findViewById(R.id.removeTag);
        removeTag.setOnClickListener(v -> {
            String etContent = et.getText().toString().trim();
            //標籤移除
            if (!etContent.isEmpty()) {
                set.remove(etContent);
                readonly.setText(set.toString());
                et.setText("");
                Toast.makeText(MainActivity.this, "移除" + etContent + "成功", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "移除失敗，內容為空", Toast.LENGTH_LONG).show();
            }
        });

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(v -> {
            Log.d("", "xxxxxxxxxxxxxxxx");
            System.out.println("ooooooooooooooooo");

            //別名推送
            //JPushInterface.setAlias(MainActivity.this, 999, "ooo");

            JPushInterface.setTags(MainActivity.this, 888, set);
            //JPushInterface.addTags(MainActivity.this, 888, set);

            /*此方法雖然不用在 AndroidManifest.xml設定，但已經 deprecated 了
            JPushInterface.setAlias(MainActivity.this, "xxx", new TagAliasCallback() {
                @Override
                public void gotResult(int i, String s, Set<String> set) {
                    System.out.println("i=" + i);
                    System.out.println("s=" + s);
                    System.out.println("set=" + set);
                    System.out.println("regID=" + JPushInterface.getRegistrationID(MainActivity.this));
                }
            });
            */
            Toast.makeText(MainActivity.this, "設定成功", Toast.LENGTH_LONG).show();
        });


        Button p2 = findViewById(R.id.p2);
        p2.setOnClickListener(v -> {
            /*
            Uri uri= Uri.parse("http://www.google.com");
            Intent i=new Intent(Intent.ACTION_VIEW,uri);
            MainActivity.this.startActivity(i);
*/
            Intent i = new Intent();
            i.setClass(MainActivity.this, Page2.class);
            this.startActivity(i);
        });
    }
}
