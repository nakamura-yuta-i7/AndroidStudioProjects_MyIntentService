package com.nkmr.myintentservice

import android.content.Intent
import android.app.IntentService
import android.util.Log
import java.util.*
import kotlin.concurrent.timerTask


class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        // 非同期処理を行うメソッド。タスクはonHandleIntentメソッド内で実行する
        Log.d("IntentService","onHandleIntent Start");
        if (intent != null) {
            Log.d("IntentService","intent msg:" + intent.getStringExtra("IntentServiceCommand") )

//            var i = 0
//            while (true) {
//                i++
//                Thread.sleep(1000)
//                Log.d("thread.sleep", i.toString())
//
//                if (i == 10) {
//                    break
//                }
//            }

//            object : MyTask() {
//                override fun doInBackground(vararg params: Void?): String? {
//
//                    return null
//                }
//            }.execute()
            val timer = Timer()
            timer.schedule(timerTask {
                Log.d("MyTask.doInBackground", "koko!!")
            }, 3000)
        }
    }
}


