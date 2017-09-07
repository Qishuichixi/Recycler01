package com.paisen.d.bank07;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private CommonAdapter adapter;
    private int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        final List<String> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add("" + i);
        }
        rv.setAdapter(adapter = new CommonAdapter<String>(this, R.layout.item, list) {
            @Override
            protected void convert(ViewHolder holder, String o, final int position) {


                holder.setText(R.id.item_tv, o);
                final TextView tv = holder.getView(R.id.item_tv);

                if (temp == position) {
                    tv.setTextColor(Color.RED);
                    tv.setBackgroundColor(Color.DKGRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                    tv.setBackgroundColor(Color.WHITE);
                }

                tv.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        temp = position;
                        Toast.makeText(mContext, "点击位置:" + temp, Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();

                    }
                });

            }
        });
    }
}
