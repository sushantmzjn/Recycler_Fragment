package com.sushant.myappsdemo.ui.add;

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

public class GalleryFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final EditText etR = root.findViewById(R.id.etradius);
        final Button btnR = root.findViewById(R.id.btnarea);


                btnR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (TextUtils.isEmpty(etR.getText().toString())){ etR.setError("Enter Radius"); return; }

                        Double a = Double.parseDouble(etR.getText().toString());
                        Double ans = 3.14 * a * a;
                        Toast.makeText(getActivity(), "The Area of Circle is : "+ans, Toast.LENGTH_SHORT).show();
                    }
                });


        return root;
    }
}