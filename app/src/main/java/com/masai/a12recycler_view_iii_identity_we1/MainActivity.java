package com.masai.a12recycler_view_iii_identity_we1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    //1
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CardView mEditCardView;
    private EditText mEtName;
    private EditText mEtAge;
    private EditText mEtAddress;
    private Button mBtnDone;
    private EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2
        initViews();
        //3
        buildEmployeeList();
        //4
        setRecyclerView();
    }

    private void setRecyclerView() {
        employeeAdapter = new EmployeeAdapter(employeeList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(employeeAdapter);
    }

    //3
    private void buildEmployeeList() {
        for (int i = 0; i < 50; i++) {
            Employee employee = new Employee("Sai Krishna", "Kolhapur", 21);
            employeeList.add(employee);
        }

    }

    //2
    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        mEditCardView = findViewById(R.id.editCardView);
        mEtName = findViewById(R.id.etName);
        mEtAge = findViewById(R.id.etAge);
        mEtAddress = findViewById(R.id.etAddress);
        mBtnDone = findViewById(R.id.btnDone);

    }

    @Override
    public void onItemClicked(int position, Employee employee) {
        mEditCardView.setVisibility(View.VISIBLE);
        mEtName.setText(employee.getName());
        mEtAge.setText(employee.getAge() + "");
        mEtAddress.setText(employee.getAddress());

        mBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditCardView.setVisibility(View.GONE);
                //edited details

                Employee new_employee = new Employee(mEtName.getText().toString()
                        , mEtAddress.getText().toString(), Integer.parseInt(mEtAge.getText().toString()));

               // employeeList.set(position, new_employee);
                employeeAdapter.notifyItemChanged(position);
            }
        });
    }
}