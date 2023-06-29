package com.example.ungdungdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ungdungdoctruyen.database.databasedoctruyen;

public class ManDangNhap extends AppCompatActivity {

    //tạo biến cho màn đăng nhập
    EditText edtTaiKhoan,edtMatKhau;
    Button btnDangNhap, btnDangKy;

    //tạo dối tượng cho databasedoctruyen
    databasedoctruyen databasedoctruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_nhap);

        AnhXa();

        //đối tượng databasedoctruyen
        databasedoctruyen = new databasedoctruyen(this);

        //tạo sk click button chuyen sang man hinh dang ky
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManDangNhap.this,ManDangKy.class);
                startActivity(intent);
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Gán cho các biến là giá trị nhập vào từ editText
                String tentaikhoan = edtTaiKhoan.getText().toString();
                String matkhau = edtMatKhau.getText().toString();

                //Sử dụng con trỏ để lấy dữ liệu, gọi tới getData() để lấy tất cả tài khoản ở database
                Cursor cursor = databasedoctruyen.getData();

                //Thực hiện vòng lặp để lấy dữ liệu từ cursor với moveToNext() di chuyển tiếp
                while (cursor.moveToNext()){
                    //Lấy dữ liệu và gán vào biến, ô 0 là idtaikhoan, ô 1 là dữ liệu tài khoản, ô 2 là mật khẩu, ô 3 là email, ô 4 là phân quyền
                    String datatentaikhoan = cursor.getString(1);
                    String datamatkhau = cursor.getString(2);

                    //Nếu tài khoản và mk nhập từ bàn phím khớp với database
                    if(datatentaikhoan.equals(tentaikhoan) && datamatkhau.equals(matkhau)){
                        //Lấy dữ liệu phân quyền và id
                        int phanquyen = cursor.getInt(4);
                        int id = cursor.getInt(0);
                        String email = cursor.getString(3);
                        String tentk = cursor.getString(1);

                        Intent intent = new Intent(ManDangNhap.this,MainActivity.class);

                        //gửi dữ liệu qua Activity là MainActivity
                        intent.putExtra("phanq",phanquyen);
                        intent.putExtra("id",id);
                        intent.putExtra("email",email);
                        intent.putExtra("tentaikhoan",tentk);

                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(ManDangNhap.this, "Tài khoản hoặc mật khẩu chưa đúng !", Toast.LENGTH_SHORT).show();
                    }
                }
                //Thực hiện trả cursor về đầu
                cursor.moveToFirst();
                cursor.close();
            }
        });
    }

    private void AnhXa() {
        edtTaiKhoan = findViewById(R.id.taikhoan);
        edtMatKhau= findViewById(R.id.matkhau);
        btnDangKy = findViewById(R.id.dangky);
        btnDangNhap = findViewById(R.id.dangnhap);
    }
}