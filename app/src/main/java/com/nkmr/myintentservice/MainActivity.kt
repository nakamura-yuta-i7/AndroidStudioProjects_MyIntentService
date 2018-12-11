package com.nkmr.myintentservice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        object : MyTask() {
            override fun doInBackground(vararg params: Void?): String? {
                Thread.sleep(3000)
                Log.d("MyTask.doInBackground", "koko!!")
                return super.doInBackground(*params)
            }
        }.execute()


        object : MyTask() {
            override fun doInBackground(vararg params: Void?): String? {
                Thread.sleep(3000)
                Log.d("MyTask.doInBackground", "koko!!")
                return super.doInBackground(*params)
            }
        }.execute()


        object : MyTask() {
            override fun doInBackground(vararg params: Void?): String? {
                Thread.sleep(3000)
                Log.d("MyTask.doInBackground", "koko!!")
                return super.doInBackground(*params)
            }
        }.execute()

    }
    var count = 0
    fun onClickButton4(v: View) {
        count++
        var text = findViewById(R.id.centerText) as TextView
        text.text = count.toString()
    }
    fun onClickButton(v: View) {
        val v = v as Button
        //MyIntentServiceを起動する
        val intent = Intent(this, MyIntentService::class.java)
        intent.putExtra("IntentServiceCommand", v.text )
        this.startService(intent)
    }
}
