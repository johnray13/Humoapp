package ru.appsmile.humoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.appsmile.humoapp.ui.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        APP_ACTIVITY=this
    }


    override fun onResume() {
        super.onResume()
        replaceFragment(MainFragment(),false)
    }
}