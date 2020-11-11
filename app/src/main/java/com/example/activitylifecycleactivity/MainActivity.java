package com.example.activitylifecycleactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static String TAG ="LIFTCYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"(1)onCreate()");

        Button button=(Button)findViewById(R.id.buttonTest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AnotherActivity.class);

                intent.putExtra("name","Zhangsan");
                intent.putExtra("age",20);

                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0&&resultCode==0){
            String str=data.getStringExtra("result");
            Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"(2)onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"(3)onRestart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"(4)onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"(5)onResume()");
    }


}