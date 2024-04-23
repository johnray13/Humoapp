package ru.appsmile.humoapp

import androidx.fragment.app.Fragment

lateinit var APP_ACTIVITY: MainActivity

fun replaceFragment(fragment: Fragment, addStack: Boolean = true) {

    if (addStack) {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.placeHolder, fragment)
            .commit()
    } else {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .replace(R.id.placeHolder, fragment)
            .commit()

    }

}