package com.example.room.mvvm.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.room.mvvm.model.DepTableModel
import com.example.room.mvvm.model.EmpDetailsModel
import com.example.room.mvvm.model.EmpTableModel
import com.example.room.mvvm.repository.EmpRepository

//viewmodel class via making db calls and return back to activity
class MainActivityViewModel : ViewModel() {

    var liveDataemp: LiveData<List<EmpDetailsModel>>? = null

    fun insertempdata(context: Context,employeelist:ArrayList<EmpTableModel>){
        EmpRepository.inserEmpdata(context,employeelist)
    }
    fun deleteempdata(context: Context){
        EmpRepository.deleteAllemp(context)
    }
    fun inserdeptdata(context: Context,deptlist:ArrayList<DepTableModel>){
        EmpRepository.inserDeptdata(context,deptlist)
    }
    fun getemployeeDetails(context: Context) : LiveData<List<EmpDetailsModel>>?{
        liveDataemp = EmpRepository.getEmpdatails(context)

        return liveDataemp
    }


}