package com.example.zeidspizza

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View

import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.order)
        val edtxt1: EditText = findViewById(R.id.pizzas)
        val total: TextView = findViewById(R.id.total)
        val sizeval : Spinner = findViewById(R.id.size)
        val typeVal : Spinner = findViewById(R.id.type)
        var flag:String="Large"
        var options1 = arrayOf("Large","Medium","Small")
        sizeval.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options1 )
        var options2 = arrayOf("Pepperoni Pizza","BBQ Chicken Pizza","Buffalo Pizza","Hawaiian Pizza","Margherita Pizza")
        typeVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options2 )


        button.setOnClickListener{ view ->
            var x: Int = edtxt1.text.toString().toInt();
            if(flag =="Large"){
                var y:Int = 4
                total.text = "your total is : "+mul(x,y).toString();}
            else if (flag == "Medium"){
                var z:Int = 3
                 total.text = "your total is : "+mul(x,z).toString();}
            else{
                var h:Int = 2
                 total.text = "your total is : "+mul(x,h).toString();}



        }
        sizeval.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options1.get(p2) //p2 is the index of selected item
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
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


public fun mul(a: Int, b: Int): Int {
    return a*b;}