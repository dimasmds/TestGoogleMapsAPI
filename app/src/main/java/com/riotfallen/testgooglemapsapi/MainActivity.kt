package com.riotfallen.testgooglemapsapi

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.location.places.ui.PlacePicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonMaps.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }

        buttonMapsPicker.setOnClickListener {
            val intentBuilder = PlacePicker.IntentBuilder()

            startActivityForResult(intentBuilder.build(this), PLACE_PICKER_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == PLACE_PICKER_REQUEST) {
            if(resultCode == Activity.RESULT_OK){
                val place = PlacePicker.getPlace(this, data)
                val toastMessage = String.format("Place: ${place.name} \n Place Lat: ${place.latLng.latitude} \n Place Long: ${place.latLng.longitude}")
                Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show()
                Preferences(this).writeLat(place.latLng.latitude)
                Preferences(this).writeLong(place.latLng.longitude)
            }
        }
    }

    companion object {
        const val PLACE_PICKER_REQUEST  = 1
    }
}
