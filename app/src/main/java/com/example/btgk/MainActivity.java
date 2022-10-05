package com.example.btgk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user, password;
    CheckBox checkBox;
    Button btdangnhap;
    SharedPreferences sharedPreferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        sharedPreferences = getSharedPreferences("dataloign",MODE_PRIVATE);
        // lấy du lieu
        user.setText(sharedPreferences.getString("username",""));
        password.setText(sharedPreferences.getString("matkhau", ""));
        checkBox.setChecked(sharedPreferences.getBoolean("checked", false));
        btdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString().trim();
                String psssword = password.getText().toString().trim();
                if (username.equals("trongcanh") &&  psssword.equals("123456789")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công ", Toast.LENGTH_SHORT).show();
                    if (checkBox.isChecked()){
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("username",username);
                        editor.putString("matkhau", psssword);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }else{
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.remove("username");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Lỗi đăng nhập ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void anhxa() {
        user=findViewById(R.id.edtdangnhap);
        password=findViewById(R.id.edtpassword);
        btdangnhap=findViewById(R.id.btsignin);
        checkBox=findViewById(R.id.cb);

    }
}