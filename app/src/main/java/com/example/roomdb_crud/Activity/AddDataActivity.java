package com.example.roomdb_crud.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdb_crud.MyDataList;
import com.example.roomdb_crud.R;

public class AddDataActivity extends AppCompatActivity {
    private EditText edt_id,edt_name,edt_email,edt_city;
    private Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        anhXa();
    }

    private void anhXa() {
        edt_id=findViewById(R.id.edt_id);
        edt_name=findViewById(R.id.edt_name);
        edt_email=findViewById(R.id.edt_email);
        edt_city=findViewById(R.id.edt_city);
        btn_add=findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(edt_id.getText().toString());
                String name=edt_name.getText().toString();
                String email=edt_email.getText().toString();
                String city=edt_city.getText().toString();
                MyDataList myDataList=new MyDataList();
                myDataList.setId(id);
                myDataList.setName(name);
                myDataList.setEmail(email);
                myDataList.setCity(city);

                MainActivity.myDatabase.myDao().addData(myDataList);
                Toast.makeText(getApplicationContext(),"Data Save",Toast.LENGTH_LONG).show();
                edt_id.setText("");
                edt_name.setText("");
                edt_email.setText("");
                edt_city.setText("");
                startActivity(new Intent(AddDataActivity.this,ReadDataActivity.class));

            }
        });
    }
}
