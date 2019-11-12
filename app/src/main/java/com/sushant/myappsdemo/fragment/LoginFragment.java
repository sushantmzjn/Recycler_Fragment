package com.sushant.myappsdemo.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sushant.myappsdemo.Dashboard;
import com.sushant.myappsdemo.MainActivity;
import com.sushant.myappsdemo.R;
import com.sushant.myappsdemo.TestLogin;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private EditText etU, etP;
    private Button btnL;
    boolean status;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_fragment, container, false);

        etU = view.findViewById(R.id.loginusername);
        etP = view.findViewById(R.id.Loginpassword);
        btnL = view.findViewById(R.id.bntlogin);


        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String Username = etU.getText().toString().trim();
             String Password = etP.getText().toString().trim();

             if (!TextUtils.isEmpty(Username)&& !TextUtils.isEmpty(Username)){
                 TestLogin testLogin =  new TestLogin();
                 testLogin.setUsername(Username);
                 testLogin.setPassword(Password);
                 status = testLogin.tstLogin();

                 if (status){
                     Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_LONG).show();
                     etU.setText("");
                     etP.setText("");

                     Intent intent = new Intent(getActivity(), Dashboard.class);
                     startActivity(intent);
                 }else {
                     etP.setError("Password not matched");
                   //  Toast.makeText(getActivity(), "Username and password not matched", Toast.LENGTH_LONG).show();
                    // etU.setText("");
                     etP.setText("");
                 }
             }else {
                 if (TextUtils.isEmpty(Username)){
                     etU.setError("Enter Username");
                 }
                 if (TextUtils.isEmpty(Password)){
                     etP.setError("Enter Password");
                 }
                 return;
             }

            }
        });




        return view;
    }

}
