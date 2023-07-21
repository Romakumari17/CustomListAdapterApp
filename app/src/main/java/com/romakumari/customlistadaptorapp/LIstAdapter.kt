package com.romakumari.customlistadaptorapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class LIstAdapter( var StudentList:  ArrayList<Student>, var listClassInterface: ListClassInterface) : BaseAdapter() {
    override fun getCount(): Int {
        return StudentList.size
    }

    override fun getItem(p0: Int): Any {
        return 1
    }

    override fun getItemId(p0: Int): Long {
       return 1L
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var view=LayoutInflater.from(p2?.context).inflate(R.layout.layoutfile,p2,false)
        var tvName = view.findViewById<TextView>(R.id.tvName)
        var Rollno=view.findViewById<TextView>(R.id.Rollno)
        var Delete=view.findViewById<Button>(R.id.Delete)
        var Edit=view.findViewById<Button>(R.id.Edit)
        tvName.setText(StudentList[position].name)
        Rollno.setText(StudentList[position].number.toString())
        Delete.setOnClickListener {
            listClassInterface.onDeleteClick(StudentList[position],position)
        }
        Edit.setOnClickListener {
            listClassInterface.onUpdateClick(StudentList[position ], position  )
        }
        return view
    }
}