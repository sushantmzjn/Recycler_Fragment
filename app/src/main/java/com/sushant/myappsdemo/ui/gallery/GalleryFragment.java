package com.sushant.myappsdemo.ui.gallery;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.sushant.myappsdemo.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final EditText etR = root.findViewById(R.id.etradius);
        final Button btnR = root.findViewById(R.id.btnarea);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                btnR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (TextUtils.isEmpty(etR.getText().toString())){ etR.setError("Enter Radius"); return; }

                        Double a = Double.parseDouble(etR.getText().toString());
                        Double ans = 3.14 * a * a;
                        Toast.makeText(getActivity(), "The Area of Circle is : "+ans, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        return root;
    }
}