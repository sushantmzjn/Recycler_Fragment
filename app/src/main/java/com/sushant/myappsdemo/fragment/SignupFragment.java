package com.sushant.myappsdemo.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.sushant.myappsdemo.R;
import com.sushant.myappsdemo.TestLogin;
import com.sushant.myappsdemo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {

    ArrayList<String> addArray = new ArrayList<>();
    private EditText usrname, password, CPassword;
    private Button signupbtn;
   // private String Username, Password, Cpassword;
   // private ListView lstuser;

    static List<User> userList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);


        usrname = view.findViewById(R.id.signupusername);
        password = view.findViewById(R.id.signuppassword);
        CPassword = view.findViewById(R.id.signupconfirmpassword);
        signupbtn = view.findViewById(R.id.btnsignup);
       // lstuser = view.findViewById(R.id.userlist);



        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   int name = Integer.parseInt(usrname.getText().toString());
             //   int pass = Integer.parseInt(password.getText().toString());
              //  int cpass = Integer.parseInt(Cpassword.getText().toString());
               String Username = usrname.getText().toString().trim();
               String Password = password.getText().toString().trim();
               String Cpassword = CPassword.getText().toString().trim();

                if (TextUtils.isEmpty(Username)){
                    usrname.setError("Enter Username"); return;
                }
                if (TextUtils.isEmpty(Password)){
                    password.setError("Enter password"); return;
                }
                if (TextUtils.isEmpty(Cpassword)){
                    CPassword.setError("Confirm Password"); return;
                }

               if (!TextUtils.isEmpty(Username)&& !TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Username)){
                   if (!Password.equals(Cpassword)){
                       CPassword.setError("Password didn't matched");
                       onStop();
                   }else {
                       User user = new User();
                       user.setUser(Username);
                       user.setPsd(Password);
                       userList.add(user);

                       TestLogin testLogin = new TestLogin();
                       testLogin.setUserList(userList);

                       for (int i =0; i<testLogin.getUserList().size(); i++){
                           final User userdetail = testLogin.getUserList().get(i);
                          // Toast.makeText(getActivity(), ""+userdetail.getUser(), Toast.LENGTH_LONG).show();
                       }
                       Toast.makeText(getActivity(), "Sign Up successful", Toast.LENGTH_LONG).show();
                       usrname.setText("");
                       password.setText("");
                       CPassword.setText("");
                   }
               }

            }
        });


        return view;
    }

}
