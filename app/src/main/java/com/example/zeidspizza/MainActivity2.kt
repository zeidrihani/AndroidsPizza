package com.example.zeidspizza

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val button: Button = findViewById(R.id.button)
        var flag : String = "Cash on delivery"
        val spinnerVal : Spinner = findViewById(R.id.spinnerPaymentMethod)
        var options = arrayOf("Cash on delivery","Credit Card")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }


            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }.also { spinnerVal.onItemSelectedListener = it }


        button.setOnClickListener { view ->

            if (flag == "Cash on delivery") {
                val intent1 = Intent(this, MainActivity::class.java)
                startActivity(intent1)
                val text = "Your Order is on the way"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            } else if (flag == "Credit Card") {

                val intent2 = Intent(this, MainActivity3::class.java)
                startActivity(intent2)
            }
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var report= ReportClass()
        when(item.itemId){
            R.id.subitem1 -> report.show(supportFragmentManager, "Custom Dialog")




            R.id.subitem2 -> android.os.Process.killProcess(android.os.Process.myPid())
        }
        return true;
    }
}