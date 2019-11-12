package com.sushant.myappsdemo.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sushant.myappsdemo.R;
import com.sushant.myappsdemo.adapter.ContactsAdapter;
import com.sushant.myappsdemo.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {


    private RecyclerView recyclerView;
   // final ArrayList<Contacts> contactList = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);

        // Create a list of contacts to display in RecyclerView
        List<Contacts> contactsList = new ArrayList<>();
        // Adding all the contacts object in list
        contactsList.add(new Contacts("Adel", "9801234567", R.drawable.adele));
        contactsList.add(new Contacts("Cornor", "9801234567", R.drawable.conor));
        contactsList.add(new Contacts("Adel", "9801234567", R.drawable.adele));
        contactsList.add(new Contacts("Adel", "9801234567", R.drawable.adele));
        contactsList.add(new Contacts("Cornor", "9801234567", R.drawable.conor));
        contactsList.add(new Contacts("Adel", "9801234567", R.drawable.adele));
        contactsList.add(new Contacts("Adel", "9801234567", R.drawable.adele));
        contactsList.add(new Contacts("Cornor", "9801234567", R.drawable.conor));
        contactsList.add(new Contacts("Adel", "9801234567", R.drawable.adele));


        ContactsAdapter contactsAdapter = new ContactsAdapter(getActivity(), contactsList);
        recyclerView.setAdapter(contactsAdapter);

        //Display all the contacts in linear layout (vertically)
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return root;
    }
}