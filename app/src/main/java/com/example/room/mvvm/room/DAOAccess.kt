package com.example.room.mvvm.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.room.mvvm.model.DepTableModel
import com.example.room.mvvm.model.EmpDetailsModel
import com.example.room.mvvm.model.EmpTableModel

//dao interface whick makes easy to communicate with room DB
@Dao
interface DAOAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmpdata(userTableModel: ArrayList<EmpTableModel>)

    @Query("DELETE FROM Employee")
    suspend fun deleteAllemp()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeptdata(depat: ArrayList<DepTableModel>)

//    @Query("select * from deptartment inner join employee on deptartment.id = employee.department_id")
    @Query("select d.dept_name,e.emp_name,e.emp_age,e.joining_date,IFNULL(m.emp_name,'')`manager_name`from deptartment d inner join employee e on d.id = e.department_id left join employee m on m.id = e.manager_id")
    fun getemployeedatails(): LiveData<List<EmpDetailsModel>>

    /*select d.id AS `DepId`,d.dept_name,e.id as `EmpId`,e.emp_name,e.emp_age,e.joining_date,IFNULL(m.emp_name,'') `Manager_Name`
    from deptartment d
    inner join employee e on d.id = e.department_id
    left join employee m on m.id = e.manager_id;*/
}