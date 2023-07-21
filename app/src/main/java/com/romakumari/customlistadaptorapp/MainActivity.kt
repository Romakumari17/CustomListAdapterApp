package com.romakumari.customlistadaptorapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), ListClassInterface {
    lateinit var List: ListView
    lateinit var etName: EditText
    lateinit var EtRollno:EditText
    lateinit var spinner: Spinner
    lateinit var Fab: FloatingActionButton
    lateinit var adapter: LIstAdapter
    var StudentList = arrayListOf<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        List = findViewById(R.id.List)
        Fab = findViewById(R.id.Fab)
        adapter = LIstAdapter(StudentList, this)
        StudentList.add(Student("name", 9))
        List.adapter = adapter
        StudentList.add(Student("Heena",22))
        StudentList.add(Student("Reena",42))
        StudentList.add(Student("Meena",32))
        Fab.setOnClickListener { it: View? ->
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.customlayout)
          // spinner = findViewById(R.id.spinner)
         //  spinner.adapter = adapter
         //   spinner?.setOnItemClickListener(
          //      AdapterView.OnItemClickListener
           //         (_,View,Int ,2l)
          //  )
            etName=dialog.findViewById(R.id.etName)
             EtRollno = dialog.findViewById<EditText>(R.id.EtRollno)
            var Update = dialog.findViewById<Button>(R.id.BtnUpdate)
            dialog.getWindow()?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            Update.setOnClickListener {
                if (etName.text.toString().isNullOrEmpty()) {
                    etName.error = "Enter Your Name"
                } else if (EtRollno.text.toString().isNullOrEmpty()) {
                    EtRollno.error = "Enter Your Rollno"
                } else {
                    StudentList.add(
                        Student(
                            etName.text.toString(),
                            EtRollno.text.toString().toInt()
                        ))
                    dialog.dismiss()
                    adapter.notifyDataSetChanged()

                }}
                dialog.show()

        }}

        override fun onDeleteClick(student: Student, position: Int) {
            StudentList.removeAt(position)
            adapter.notifyDataSetChanged()
        }

    override fun onUpdateClick(student: Student, position: Int) {
        var dialog = Dialog(this)
        dialog.setContentView(R.layout.customlayout)
        etName = dialog.findViewById<EditText>(R.id.etName)
        EtRollno = dialog.findViewById<EditText>(R.id.EtRollno)
        var Update = dialog.findViewById<Button>(R.id.BtnUpdate)
        dialog.getWindow()?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        Update.setText("upadte")
        Update.setOnClickListener {
            if (etName.text.toString().isNullOrEmpty()) {
                etName.error = "Enter Your Name"
            } else if (EtRollno.text.toString().isNullOrEmpty()) {
                EtRollno.error = "Enter Your Rollno"
            } else {
                StudentList.set(position,Student(
                        etName.text.toString(),
                        EtRollno.text.toString().toInt()
                    )
                )
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
        }
        dialog.show()

    }
}