package com.masai.a12recycler_view_iii_identity_we1;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//1
public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {
    //3
    private ArrayList<Employee> employeeList;
    private ItemClickListener itemClickListener;

    //4 calling constructor
    public EmployeeAdapter(ArrayList<Employee> employeeList, ItemClickListener itemClickListener) {
        this.employeeList = employeeList;
        this.itemClickListener = itemClickListener;
    }


    @NonNull
//2
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("Debug", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent,false);
        return new EmployeeViewHolder(view, itemClickListener);
    }

    //6 binding process : getting employee from list using getMethod
    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Log.d("Debug", "onBindViewHolder");

        Employee employee = employeeList.get(position);
        holder.setData(employee);
    }

    //5 after constructor write return type except 0
    @Override
    public int getItemCount() {
        return employeeList.size();
    }
//
//    public void updateData(ArrayList<Employee> newList) {
//        this.employeeList = newList;
//        notifyDataSetChanged();
//    }
}







