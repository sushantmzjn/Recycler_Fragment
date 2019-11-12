package com.sushant.myappsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    private CircleImageView imgV;
    private TextView name1, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imgV = findViewById(R.id.imageView);
        name1 = findViewById(R.id.textView);
        no = findViewById(R.id.textView2);

        Bundle bundle = getIntent().getExtras();

            if (bundle!=null){
                imgV.setImageResource(bundle.getInt("image"));
                name1.setText(bundle.getString("name"));
                no.setText(bundle.getString("phone"));
            }


    }
}
