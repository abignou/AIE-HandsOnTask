package com.example.room.mvvm.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

//department table
@Entity(tableName = "Deptartment")
data class DepTableModel (
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "dept_name")
    var dept_name: String

)