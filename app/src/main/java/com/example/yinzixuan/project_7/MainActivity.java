package com.example.yinzixuan.project_7;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PublicKey;


public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=(Button)findViewById(R.id.button_one);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View textEntryView=inflater.inflate(R.layout.login_dialog,null);

                builder.setView(textEntryView)
                        .setTitle("用户登录")
                        .setPositiveButton("登录",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                //获取对象
                                EditText number=(EditText)textEntryView.findViewById(R.id.editTextUserId);
                                EditText password=(EditText)textEntryView.findViewById(R.id.editTextPwd);

                                //获取用户名和密码字符串
                                String Number=number.getText().toString();
                                String Password=password.getText().toString();

                                if(Number.equals("abc")&&Password.equals("123"))
                                {
                                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                                    startActivity(intent);
                                }
                                else if(Number.equals(""))
                                {
                                    Toast.makeText(MainActivity.this,"请输入用户名",Toast.LENGTH_LONG).show();
                                }
                                else if(Password.equals(""))
                                {
                                    Toast.makeText(MainActivity.this,"请输入密码",Toast.LENGTH_LONG).show();
                                }
                                else
                                    Toast.makeText(MainActivity.this,"用户名或密码错误",Toast.LENGTH_LONG).show();

                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                builder.show();
            }
        });



        Button btn = (Button) this.findViewById(R.id.button_two);
        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("是否退出").setTitle("退出应用");

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "退出操作已取消", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "退出操作已忽略", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();

            }});
    }
}

