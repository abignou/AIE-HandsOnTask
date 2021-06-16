package com.example.room.mvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
//Employee table
@Entity(tableName = "Employee")
data class EmpTableModel (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = 0,

    @ColumnInfo(name = "emp_name")
    var emp_name: String,

    @ColumnInfo(name = "emp_age")
    var emp_age: Int,

    @ColumnInfo(name = "joining_date")
    var joining_date: String,

    @ColumnInfo(name = "manager_id")
    var manager_id: Int,

    @ColumnInfo(name = "department_id")
    var department_id: Int

)