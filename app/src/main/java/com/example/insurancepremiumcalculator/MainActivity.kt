package com.example.insurancepremiumcalculator

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var premiumModel: PremiumModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        premiumModel = ViewModelProviders.of(this).get(PremiumModel:: class.java)


        findViewById<Button>(R.id.Calculate).setOnClickListener {
            premiumModel.premium= calculation()

        }
        display()


        findViewById<Button>(R.id.Reset).setOnClickListener {
         AgeRange.setSelection(0)
            Gender.clearCheck()
            Smoker.isChecked =false
            totalPremium.text= " "
        }
    }
    fun display(){
       totalPremium.text = premiumModel.premium.toString()
    }
   fun calculation():Double{

        val age = AgeRange.selectedItemPosition
if (male.isChecked || Female.isChecked ) {
    return when (age) {
        0 -> 60.00
        1 -> 70.00 +
                (if (male.isChecked) 50.00 else 0.0) +
                (if (Smoker.isChecked) 100.00 else 0.0)
        2 -> 90.00 +
                (if (male.isChecked) 100.00 else 0.0) +
                (if (Smoker.isChecked) 150.00 else 0.0)
        3 -> 120.00 +
                (if (male.isChecked) 150.00 else 0.0) +
                (if (Smoker.isChecked) 200.00 else 0.0)
        4 -> 150.00 +
                (if (male.isChecked) 200.00 else 0.0) +
                (if (Smoker.isChecked) 250.00 else 0.0)
        5 -> 150.00 +
                (if (male.isChecked) 250.00 else 0.0) +
                (if (Smoker.isChecked) 300.00 else 0.0)
        else -> 0.0

    }
}else
    return 0.0

    }





}
