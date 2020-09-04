package com.example.datepicker

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var button_date: Button? = null
    var textview_date: TextView? = null
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the references from layout file
        textview_date = this.text_view_date_1
        button_date = this.button_date_1

        textview_date!!.text = "--/--/----"

        // create an OnDateSetListener
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        button_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@MainActivity,
                        dateSetListener,
                        // set DatePickerDialog to point to today's date when it loads up
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show()
            }

        })
    }

    private fun updateDateInView() {
        val myFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textview_date!!.text = sdf.format(cal.getTime())
    }

}

//class MainActivity : AppCompatActivity() {
//
//    var cal = Calendar.getInstance()
//    var data: TextView? = null
//    var button: Button? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        var newDateSetListener = object : DatePickerDialog.OnDateSetListener {
//            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
//                cal.set(Calendar.YEAR, year)
//                cal.set(Calendar.MONTH, month)
//                cal.set(Calendar.DAY_OF_YEAR, dayOfMonth)
//
//                val formatoDeData = "dd/mm/yyyy"
//                val formatador = SimpleDateFormat(formatoDeData, Locale.ITALY)
//                data!!.text = formatoDeData.format(cal.time)
//            }
//        }
//
//        button!!.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                DatePickerDialog(this@MainActivity, newDateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_YEAR)).show()
//            }
//
//        })
//
////        button.setOnClickListener{
////            DatePickerDialog(this@MainActivity, newDateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_YEAR)).show()
////        }
//    }
//}