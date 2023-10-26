package com.example.user_manager_v1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.user_manager_v1.EmployeeListActivity;
import com.example.user_manager_v1.R;
import com.example.user_manager_v1.model.Employee;

import java.util.Collections;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeHolder> {

    private List<Employee> employeeList;

    public EmployeeAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_employee_item, parent, false);
        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {

        Employee employee = employeeList.get(position);
        holder.name.setText(employee.getName());
        holder.location.setText(employee.getLocation());
        holder.branch.setText(employee.getBranch());

    }


    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}
