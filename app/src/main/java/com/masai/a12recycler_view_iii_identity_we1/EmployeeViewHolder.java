package com.masai.a12recycler_view_iii_identity_we1;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvName;
    private TextView mTvAge;
    private TextView mTvAddress;
    private ImageView mIvEdit;
    private ItemClickListener itemClickListener;


    public EmployeeViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initData(itemView);
    }

    private void initData(View itemView) {
        mTvAddress = itemView.findViewById(R.id.tvAddress);
        mTvName = itemView.findViewById(R.id.tvName);
        mTvAge = itemView.findViewById(R.id.tvAge);
        mIvEdit = itemView.findViewById(R.id.ivEdit);
    }

    public void setData(Employee employee) {
        mTvAddress.setText(employee.getAddress());
        mTvName.setText(employee.getName());
//or        mTvAge.setText(employee.getAge() + "");
        mTvAge.setText(employee.getAge() + "");

        mIvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(), employee);
            }
        });
    }
}











