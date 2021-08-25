package com.example.runtimepermission

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    var PERMISSION_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val permission = arrayOf<String>(
            "android.permission.ACCESS_BACKGROUND_LOCATION",
            "android.permission.ACCESS_MEDIA_LOCATION"
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permission, PERMISSION_CODE)
        }

    }


    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (permissions.contains("android.permission.ACCESS_BACKGROUND_LOCATION")
            && permissions.contains("android.permission.ACCESS_MEDIA_LOCATION")
        ) {
            Toast.makeText(
                applicationContext,
                "Media and background location access granted",
                Toast.LENGTH_SHORT
            ).show()

        } else if (permissions.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
            Toast.makeText(
                applicationContext,
                "background location access granted",
                Toast.LENGTH_SHORT
            ).show()

        } else if (permissions.contains("android.permission.ACCESS_MEDIA_LOCATION")) {
            Toast.makeText(
                applicationContext,
                "media location access permission granted",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
