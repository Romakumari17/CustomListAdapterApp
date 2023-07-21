package com.romakumari.customlistadaptorapp

interface ListClassInterface {
    fun onDeleteClick(student: Student, position :Int)
    fun onUpdateClick(student: Student, position :Int)

}