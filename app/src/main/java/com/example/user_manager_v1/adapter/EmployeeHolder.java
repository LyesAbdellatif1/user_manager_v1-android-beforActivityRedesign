package com.example.user_manager_v1.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.user_manager_v1.R;

public class EmployeeHolder extends RecyclerView.ViewHolder {

    TextView name, location, branch;

    public EmployeeHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.employeeListItem_name);
        location = itemView.findViewById(R.id.employeeListItem_location);
        branch = itemView.findViewById(R.id.employeeListItem_branch);
    }
}