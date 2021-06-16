package com.example.room.mvvm.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room.mvvm.R
import com.example.room.mvvm.adapter.EmployeeListAdapter
import com.example.room.mvvm.model.DepTableModel
import com.example.room.mvvm.model.EmpDetailsModel
import com.example.room.mvvm.model.EmpTableModel
import com.example.room.mvvm.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var loginViewModel: MainActivityViewModel
    val mEmployeeList:ArrayList<EmpTableModel> = ArrayList()
    val mdepartmentList:ArrayList<DepTableModel> = ArrayList()
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        context = this@MainActivity
        prepareEmpdata()
    }

    private fun prepareEmpdata() {
        //inserting employee into list, then sending it to Db
        mEmployeeList.add(EmpTableModel(1,"Alisha J.",21, "22-Feb-13", 2, 2));
        mEmployeeList.add(EmpTableModel(2,"John Mathew",22, "13-Sep-14", 0, 4));
        mEmployeeList.add(EmpTableModel(3,"Syed Ali",23, "26-Jun-16", 2, 3));
        mEmployeeList.add(EmpTableModel(4,"Ramesh G.",24, "01-Nov-17", 2, 1));
        loginViewModel.insertempdata(context, mEmployeeList)
//inserting department into list, then sending it to Db
        mdepartmentList.add(DepTableModel(1,"Operations"))
        mdepartmentList.add(DepTableModel(2,"Finance"))
        mdepartmentList.add(DepTableModel(3,"HR"))
        mdepartmentList.add(DepTableModel(4,"Managing Director"))
        loginViewModel.inserdeptdata(context,mdepartmentList)

        //observing all data inserted in DB
        loginViewModel.getemployeeDetails(context)!!.observe(this, Observer {
            if(it!=null&&it.size>0) {
                val employeeListAdapter = EmployeeListAdapter(it as ArrayList<EmpDetailsModel>)
                rv_emp_details.layoutManager = LinearLayoutManager(context)
                rv_emp_details.setHasFixedSize(true)
                rv_emp_details.adapter = employeeListAdapter
                val dividerItemDecoration = DividerItemDecoration(
                    context,
                    (rv_emp_details.layoutManager as LinearLayoutManager).orientation
                )
                rv_emp_details.addItemDecoration(dividerItemDecoration)

            }
        })

    }
}