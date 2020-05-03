package com.example.roomdb_crud.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.roomdb_crud.MyDatabase;
import com.example.roomdb_crud.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_add,btn_update,btn_read,btn_delete;
    public static MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase= Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"infodb").allowMainThreadQueries().build();

        anhXa();
    }

    private void anhXa() {
        btn_add=findViewById(R.id.btn_add);
        btn_update=findViewById(R.id.btn_update);
        btn_read=findViewById(R.id.btn_read);
        btn_delete=findViewById(R.id.btn_delete);
        //set onclick
        btn_add.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_read.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.btn_add:{
                startActivity(new Intent(MainActivity.this, AddDataActivity.class));
                break;
            }
            case R.id.btn_update:{
                startActivity(new Intent(MainActivity.this, UpdateDataActivity.class));
                break;
            }
            case R.id.btn_read:{
                startActivity(new Intent(MainActivity.this, ReadDataActivity.class));
                break;
            }
            case R.id.btn_delete:{
                startActivity(new Intent(MainActivity.this, DeleteDataActivity.class));
                break;
            }


        }

    }
}
