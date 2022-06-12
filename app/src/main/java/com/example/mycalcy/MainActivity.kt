package com.example.mycalcy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.Unit.toString
import kotlin.time.TimeSource.Monotonic.toString

class MainActivity : AppCompatActivity() {
    var isNewOp=true
    var oldno=""
    var op="+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun butadd(view: View) {
        var editText=findViewById<TextView>(R.id.editText)
        if(isNewOp)
        {
            editText.setText("")
        }
        isNewOp=false
        var buclick=editText.text.toString()
        var buselect=view as Button
        when(buselect.getId())
        {
            R.id.bu1->{buclick += "1"}
            R.id.bu2->{buclick += "2"}
            R.id.bu3->{buclick += "3"}
            R.id.bu4->{buclick += "4"}
            R.id.bu5->{buclick += "5"}
            R.id.bu6->{buclick += "6"}
            R.id.bu7->{buclick += "7"}
            R.id.bu8->{buclick += "8"}
            R.id.bu9->{buclick += "9"}
            R.id.bu0->{buclick += "0"}
            R.id.budot->{buclick += "."}
            R.id.bupm->{buclick="-$buclick"}
        }
    editText.setText(buclick)
    }
    fun buteve(view: View)
    {
        isNewOp = true
        var editText=findViewById<TextView>(R.id.editText)
        oldno = editText.text.toString()
        var buselect = view as Button
        when (buselect.id)
        {
            R.id.bum -> { op = "*" }
            R.id.bud -> { op = "/" }
            R.id.bup -> { op = "+" }
            R.id.pow -> { op = "^" }
            R.id.buminus -> { op = "-" }
        }
    }
    fun butac(view: View) {
        var editText=findViewById<TextView>(R.id.editText)
        editText.setText("0")
        isNewOp=true
    }
    fun equal(view: View)
    {
        var editText=findViewById<TextView>(R.id.editText)
        var newno= editText.text.toString()
        var result=0.0
        when(op)
        {
            "+"->{result=oldno.toDouble()+newno.toDouble()}
            "-"->{result=oldno.toDouble()-newno.toDouble()}
            "/"->{result=oldno.toDouble()/newno.toDouble()}
            "*"->{result=oldno.toDouble()*newno.toDouble()}
            "^"->{result=oldno.toDouble()*oldno.toDouble()}
        }
        editText.setText(result.toString())
    }

    fun percentage(view: View) {
        var editText=findViewById<TextView>(R.id.editText)
        var no=editText.text.toString().toDouble()/100
        editText.setText(no.toString())
    }
}