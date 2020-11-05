package com.example.myapplication

import android.app.Activity
import android.content.*
import android.net.ConnectivityManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.os.IBinder
import android.view.View
import android.widget.Toast

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    val ForResultActivity_1=100
    var mService: BoundService? = null
    var mBound = false
    val myBroadcastReceiver: BroadcastReceiver = MyBroadcastReceiver()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Je suis dans onCreate")

        /*button4.setOnClickListener {
            Intent().also{ intent ->
                intent.setAction("com.example.myapplication.MY_NOTIFICATION")
                intent.putExtra("data", "Call button")
                sendBroadcast(intent)
            }
        }*/

        button4.setOnClickListener {
                val email = Intent(Intent.ACTION_SEND)
                email.putExtra(Intent.EXTRA_TEXT, "Text")
                email.type = "text/plain"
                startActivity(Intent.createChooser(email, "Choose an application:"))
        }

        button12.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(intent)
        }

        button14.setOnClickListener{
            val monIntent = Intent(this, ShareActivity::class.java)
            startActivity(monIntent)
        }

        button3.setOnClickListener{
            val monIntent = Intent(this, CentraleMarseille::class.java)
            startActivity(monIntent)
        }

        val filter = IntentFilter("com.example.myapplication").apply {
            addAction("com.example.myapplication.MY_NOTIFICATION")
        }
        registerReceiver(myBroadcastReceiver, filter)

//        test.setOnClickListener {
//            val monIntent = Intent(this, Activity2::class.java)
//            startActivityForResult(monIntent, ForResultActivity_1)
//        }
//        button.setOnClickListener {
//            val monservice = Intent(this, BackgroundService::class.java)
//            startService(monservice)
//            Log.d("tag","test")
//        }
//        button4.setOnClickListener {
//            val monservice2 = Intent(this, BackgroundService::class.java)
//            stopService(monservice2)
//        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode ==ForResultActivity_1){
            Log.d("onActivityResult","firts"+resultCode)
            if(resultCode== Activity.RESULT_OK){
                //plain.setText(data?.getStringExtra("ret"))
                Toast.makeText(this@MainActivity, "ret:"+ data?.getStringExtra("ret"),Toast.LENGTH_SHORT).show()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, BoundService::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
        Log.d("MainActivity", "onStart")


    }
    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
        mBound=false

        Log.d("Main Activity"," onDestroy")
        unregisterReceiver(myBroadcastReceiver)
    }

    fun onButtonClick(v: View?){
        if (mBound){
            val num: Int=mService!!.getRandomNumber()
            Toast.makeText(this,"number: $num", Toast.LENGTH_LONG).show()
        }
    }

    private val connection: ServiceConnection= object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {

            val binder: BoundService.LocalBinder = service as BoundService.LocalBinder
            mService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {

            mBound = false
        }

    }

}

