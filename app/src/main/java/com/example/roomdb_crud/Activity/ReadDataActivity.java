package com.example.roomdb_crud.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.roomdb_crud.MyAdapter;
import com.example.roomdb_crud.MyDataList;
import com.example.roomdb_crud.R;

import java.util.List;

public class ReadDataActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);
        rv=findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        getData();
    }

    private void getData() {
        class GetData extends AsyncTask<Void,Void, List<MyDataList>>{

            @Override
            protected List<MyDataList> doInBackground(Void... voids) {
                //Được thực thi trong quá trình tiến trình chạy nền(bat buoc)
                List<MyDataList> myDataLists= MainActivity.myDatabase.myDao().getMyData();
                return myDataLists;
            }

            @Override
            protected void onPostExecute(List<MyDataList> myDataLists) {
                //Sau khi tiến trình kết thúc thì hàm này sẽ tự động xảy ra.
                // Ta có thể lấy được kết quả trả về sau khi thực hiện tiến trình kết thúc ở đây.
                MyAdapter myAdapter=new MyAdapter(myDataLists,getApplicationContext());
                rv.setAdapter(myAdapter);
                super.onPostExecute(myDataLists);
            }
        }
        GetData gd=new GetData();
        gd.execute();
        //Gọi hàm execute để kích hoạt tiến trình
    }
}
