package com.example.room.mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room.mvvm.R
import com.example.room.mvvm.model.EmpDetailsModel

//setting list data
class EmployeeListAdapter(
    private val mList: ArrayList<EmpDetailsModel>
) : RecyclerView.Adapter<EmployeeListAdapter.EmployeeListHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeListHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent, false)
        return EmployeeListHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeListHolder, position: Int) {
        val empModel: EmpDetailsModel = mList!![position]
        holder.lbl_name.text=empModel.emp_name
        holder.lbl_doj.text=empModel.joining_date
        holder.lbl_age.text=""+empModel.emp_age
        holder.lbl_manager.text=""+empModel.manager_id
        holder.lbl_department.text=empModel.dept_name

    }



    override fun getItemCount(): Int {
        return mList!!.size
    }

    class EmployeeListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lbl_name: TextView
        val lbl_doj:TextView
        val lbl_age:TextView
        val lbl_manager:TextView
        val lbl_department:TextView

        init {
            lbl_name = itemView.findViewById(R.id.lbl_name)
            lbl_doj = itemView.findViewById(R.id.lbl_doj)
            lbl_age = itemView.findViewById(R.id.lbl_age)
            lbl_manager = itemView.findViewById(R.id.lbl_manager)
            lbl_department = itemView.findViewById(R.id.lbl_department)
        }
    }
}