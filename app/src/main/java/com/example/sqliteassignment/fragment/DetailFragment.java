package com.example.sqliteassignment.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sqliteassignment.R;
import com.example.sqliteassignment.entity.Bill;

public class DetailFragment extends Fragment {

    private Bill bill;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        TextView textView = view.findViewById(R.id.tv_content);
        textView.setText(bill.toString());
    }
}