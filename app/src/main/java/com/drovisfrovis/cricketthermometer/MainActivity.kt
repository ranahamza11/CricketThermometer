package com.drovisfrovis.cricketthermometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        

        btn_calculate_temp.setOnClickListener {
            if(et_input_chirps.text.toString().isEmpty()){
                et_input_chirps.error = "Cricket Chirps must be specified"
            }else{
                var tempInCelsius = et_input_chirps.text.toString().toFloat()
                tempInCelsius = tempInCelsius/3.0f + 4.0f

                var stringTemp = tempInCelsius.toString()
                stringTemp = if(stringTemp[stringTemp.length-2] == '.' && stringTemp[stringTemp.length - 1] == '0'){
                    stringTemp.substring(0, stringTemp.length-2)
                } else{
                    String.format("%.1f", stringTemp.toFloat())
                }

                tv_display_result.text = getString(R.string.result_text, stringTemp)

            }

        }
    }
}