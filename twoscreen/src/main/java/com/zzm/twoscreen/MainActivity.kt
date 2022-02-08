package com.zzm.twoscreen

import android.hardware.display.DisplayManager
import android.os.Bundle
import android.util.Log
import android.view.Display
import androidx.appcompat.app.AppCompatActivity
import com.zzm.twoscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private var mDisplayManager: DisplayManager? = null
  private var myPresentation: MyPresentation? = null
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    Log.e(
      "zzm debug",
      "haha ${windowManager.defaultDisplay.width}，${windowManager.defaultDisplay.height}"
    )
    twoScreen1(1)
  }

  fun twoScreen1(id: Int) {
    mDisplayManager = getSystemService(DISPLAY_SERVICE) as DisplayManager
    val displays = mDisplayManager?.displays
    Log.e("zzm debug", "displays ${displays?.size}")
    showPresentation(displays?.get(id))
  }

  private fun showPresentation(display: Display?) {
    myPresentation = MyPresentation(this, display)
    myPresentation?.show()
  }
}