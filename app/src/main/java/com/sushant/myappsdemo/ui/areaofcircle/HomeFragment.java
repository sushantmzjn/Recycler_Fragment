package com.sushant.myappsdemo.ui.areaofcircle;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.sushant.myappsdemo.R;

public class HomeFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final EditText et1 = root.findViewById(R.id.etnum1);
        final EditText et2 = root.findViewById(R.id.etnum2);
        final Button btnadd = root.findViewById(R.id.btnadd);

                btnadd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (TextUtils.isEmpty(et1.getText().toString())){ et1.setError("Enter first no."); return; }
                        if (TextUtils.isEmpty(et2.getText().toString())){ et2.setError("Enter second no."); return; }

                        int x = Integer.parseInt(et1.getText().toString());
                        int y = Integer.parseInt(et2.getText().toString());
                        int res = x + y;
                        Toast.makeText(getActivity(), "The sum is : "+res, Toast.LENGTH_LONG).show();

                    }
                });



        return root;
    }
}