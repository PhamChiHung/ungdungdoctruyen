package com.example.ungdungdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ungdungdoctruyen.database.databasedoctruyen;
import com.example.ungdungdoctruyen.model.Truyen;

public class ManDangBai extends AppCompatActivity {

    EditText edtTenTruyen,edtNoiDung,edtAnh;
    Button btnDangBai;
    databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_bai);

        edtAnh =  findViewById(R.id.dbimg);
        edtTenTruyen = findViewById(R.id.dbTentruyen);
        edtNoiDung = findViewById(R.id.dbnoidung);
        btnDangBai  = findViewById(R.id.dbdangbai);

        databasedoctruyen = new databasedoctruyen(this);

        //button đăng bài
        btnDangBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tentruyen =  edtTenTruyen.getText().toString();
                String noidung = edtNoiDung.getText().toString();
                String img = edtAnh.getText().toString();

                Truyen truyen = CreateTruyen();

                if(tentruyen.equals("") || noidung.equals("") || img.equals("")){
                    Toast.makeText(ManDangBai.this, "Yêu cầu nhập  đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    Log.e("ERR","Nhập đầy đủ thông tin");
                }
                //nếu đầy đủ tt thì thực hiện dữ liệu
                else {
                    databasedoctruyen.AddTruyen(truyen);
                    //chuyển qua màn Admin và cập nhật  lại dữ liệu
                        Intent intent = new Intent(ManDangBai.this, ManAdmin.class);
                        finish();
                        startActivity(intent);
                }
            }
        });
    }
    //phương thức tạo truyện
    private Truyen CreateTruyen(){
        String tentruyen =  edtTenTruyen.getText().toString();
        String noidung = edtNoiDung.getText().toString();
        String img = edtAnh.getText().toString();

        Intent intent =getIntent();

        int id = intent.getIntExtra("Id",0);
        Truyen truyen = new Truyen(tentruyen,noidung,img,id);
        return truyen;
    }
}