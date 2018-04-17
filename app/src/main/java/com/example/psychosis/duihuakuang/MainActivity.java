package com.example.psychosis.duihuakuang;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)this.findViewById(R.id.btTs);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是一个对话框").setTitle("对话框");

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(MainActivity.this,"用户取消了按钮",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(MainActivity.this,"用户按下了取消按钮",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(MainActivity.this,"用户按下了忽略按钮",Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });


        Button button =(Button)findViewById(R.id.btDl);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater=getLayoutInflater();
                final View view1=inflater.inflate(R.layout.login_dialog,null);
                builder.setView(view1)
                        .setTitle("Login")
                        .setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int id) {
                                EditText editText=(EditText)view1.findViewById(R.id.editTextUserId);
                                EditText edit2=(EditText)view1.findViewById(R.id.editTextPwd);
                                String zh =editText.getText().toString();
                                String mm = edit2.getText().toString();

                                if(zh.equals("abc")&&mm.equals("123")){
                                    Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(MainActivity.this,"账号或密码错误",Toast.LENGTH_LONG).show();
                                }
                            }
                        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        finish();
                    }
                });
                builder.show();
            }
        });
    }
}


