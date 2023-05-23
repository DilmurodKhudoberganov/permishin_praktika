package uz.gita.permishin_praktika

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {


    companion object {
        private const val REQUEST_CODE = 1001

    }
//
//    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
//        Log.d("TTT", "it= $it")
//        if (it) {
//            reaction()
//        } else{
//            // ui
//        }
//    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<AppCompatButton>(R.id.button).setOnClickListener {


            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                reaction()
            } else {
                requestPermissions(
                    arrayOf(
                        Manifest.permission.READ_SMS,
                        Manifest.permission.SEND_SMS,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ),
                    REQUEST_CODE
                )
            }
        }
    }
    private fun reaction() {
        // sms read, send sms
        Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE) {
            permissions.forEachIndexed { index, perrmission ->
                Log.d("TTT", "$perrmission -> ${grantResults[index]}")
            }
        }
    }

}