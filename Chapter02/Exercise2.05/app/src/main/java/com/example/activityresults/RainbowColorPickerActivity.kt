package com.example.activityresults

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_rainbow_color_picker.*

class RainbowColorPickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rainbow_color_picker)

        val colorPickerClickListener = View.OnClickListener { view ->

            when (view.id) {
                R.id.red_button -> setRainbowColor(getString(R.string.red), R.color.red)
                R.id.orange_button -> setRainbowColor(getString(R.string.orange), R.color.orange)
                R.id.yellow_button -> setRainbowColor(getString(R.string.yellow), R.color.yellow)
                R.id.green_button -> setRainbowColor(getString(R.string.green), R.color.green)
                R.id.blue_button -> setRainbowColor(getString(R.string.blue), R.color.blue)
                R.id.indigo_button -> setRainbowColor(getString(R.string.indigo), R.color.indigo)
                R.id.violet_button -> setRainbowColor(getString(R.string.violet), R.color.violet)
                else -> {
                    Toast.makeText(this, getString(R.string.unexpected_color), Toast.LENGTH_LONG)
                        .show()
                }
            }
        }

        red_button.setOnClickListener(colorPickerClickListener)
        orange_button.setOnClickListener(colorPickerClickListener)
        yellow_button.setOnClickListener(colorPickerClickListener)
        green_button.setOnClickListener(colorPickerClickListener)
        blue_button.setOnClickListener(colorPickerClickListener)
        indigo_button.setOnClickListener(colorPickerClickListener)
        violet_button.setOnClickListener(colorPickerClickListener)
    }

    private fun setRainbowColor(colorName: String, color: Int) {

        Intent().let { pickedColorIntent ->

            pickedColorIntent.putExtra(RAINBOW_COLOR_NAME, colorName)
            pickedColorIntent.putExtra(RAINBOW_COLOR, color)

            setResult(Activity.RESULT_OK, pickedColorIntent)
            finish()
        }
    }
}
