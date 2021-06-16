package com.example.room.mvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.room.mvvm.model.DepTableModel
import com.example.room.mvvm.model.EmpDetailsModel
import com.example.room.mvvm.model.EmpTableModel
import com.example.room.mvvm.room.MyDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
//Repository section to call al db methods

class EmpRepository {

    companion object {

        var myDatabase: MyDatabase? = null
        var empdetailsModel: LiveData<List<EmpDetailsModel>>? = null

        fun initializeDB(context: Context) : MyDatabase {
            return MyDatabase.getDataseClient(context)
        }

        fun inserEmpdata(
            context: Context,
            emp: ArrayList<EmpTableModel>){
            myDatabase= initializeDB(context)
            CoroutineScope(IO).launch {
                myDatabase!!.myDao().insertEmpdata(emp)
            }
        }
        fun deleteAllemp(
            context: Context
            ){
            myDatabase= initializeDB(context)
            CoroutineScope(IO).launch {
                myDatabase!!.myDao().deleteAllemp()
            }
        }
        fun inserDeptdata(
            context: Context,
            dept: ArrayList<DepTableModel>){
            myDatabase= initializeDB(context)
            CoroutineScope(IO).launch {
                myDatabase!!.myDao().insertDeptdata(dept)
            }
        }
        fun getEmpdatails(
            context: Context) : LiveData<List<EmpDetailsModel>>?{
            myDatabase= initializeDB(context)
                empdetailsModel = myDatabase!!.myDao()!!.getemployeedatails()
            return empdetailsModel
        }

    }
}