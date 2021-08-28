package com.example.dialogfrangmentapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialogFrangment : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       val alertDialog : AlertDialog.Builder = AlertDialog.Builder(activity)
            alertDialog.setTitle("Think Like a Dev")
            alertDialog.setMessage("Legend developer never")
            alertDialog.setPositiveButton("OK",DialogInterface.OnClickListener { dialogInterfce,which ->
                Toast.makeText(context,"you done",Toast.LENGTH_SHORT).show()
            })
            alertDialog.setNegativeButton("CANCEL",DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(context,"you don't done",Toast.LENGTH_SHORT).show()
            })


      var  dialog_btn :AlertDialog = alertDialog.create()
        return dialog_btn
    }
}