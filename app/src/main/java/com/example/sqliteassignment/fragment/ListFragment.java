package com.example.sqliteassignment.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sqliteassignment.R;
import com.example.sqliteassignment.entity.Bill;

import java.util.ArrayList;


public class ListFragment extends Fragment {
    private Context mContext;
    private ArrayList<Bill> list;
    LinearLayout linearLayout;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        initData();
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        linearLayout = view.findViewById(R.id.ln_list_item);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            Bill bill = list.get(i);
            View viewItem = LayoutInflater.from(mContext).inflate(R.layout.item_bill, linearLayout, false);
            TextView tvName = viewItem.findViewById(R.id.tvName);
            TextView tvDes = viewItem.findViewById(R.id.tvDescription);
            TextView tvDetail = viewItem.findViewById(R.id.tvDetail);
            TextView tvPrice = viewItem.findViewById(R.id.tvPrice);
            TextView tvDate = viewItem.findViewById(R.id.tvDate);
            TextView tvCategory = viewItem.findViewById(R.id.tvCategory);
            tvName.setText(bill.getName());
            tvDes.setText(bill.getDescription());
            tvDetail.setText(bill.getDetail());
            tvPrice.setText((int) bill.getPrice());
            tvDate.setText((CharSequence) bill.getDate());
            tvCategory.setText(bill.getName());
            linearLayout.addView(viewItem);
            viewItem.setTag(bill);
            viewItem.setOnClickListener((View.OnClickListener) this);
        }
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new Bill("Ti vi", "0914366644", "abc", 12000, "2021-09-10", "Cat 1"));
        list.add(new Bill("Tủ lạnh", "0914366644", "abc", 50000, "2021-09-10", "Cat 2"));
        list.add(new Bill("Máy tính", "0914366644", "abc", 20000, "2021-09-10", "Cat 3"));
    }
}