package com.zzm.twoscreen

import android.app.Presentation
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Display
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView

class MyPresentation(outerContext: Context?, display: Display?) :
  Presentation(outerContext, display) {
  private var seekBarR:SeekBar? = null
  private var seekBarG:SeekBar? = null
  private var seekBarB:SeekBar? = null
  private var Rvalue:TextView? = null
  private var Gvalue:TextView? = null
  private var Bvalue:TextView? = null
  private var view: View? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.diffrentdisplay)
    Log.e("zzm debug", "MyPresentation onCreate : " + resources.configuration.toString())
    initViews()
    initEvent()
  }

  private fun initViews() {
    seekBarR = findViewById(R.id.seekBarR)
    seekBarG = findViewById(R.id.seekBarG)
    seekBarB = findViewById(R.id.seekBarB)
    Rvalue = findViewById(R.id.Rvalue)
    Gvalue = findViewById(R.id.Gvalue)
    Bvalue = findViewById(R.id.Bvalue)
    view = findViewById(R.id.view)
    val rRalue = (seekBarR?.progress!! / 100.0 * 255).toInt()
    Rvalue?.text = "$rRalue(${intToHex(rRalue)})"
    val gRalue = (seekBarG?.progress!! / 100.0 * 255).toInt()
    Gvalue?.text = "$gRalue(${intToHex(gRalue)})"
    val bRalue = (seekBarB?.progress!! / 100.0 * 255).toInt()
    Bvalue?.text = "$bRalue(${intToHex(bRalue)})"
    updateViewBackground()
  }

  private fun initEvent() {
    seekBarR?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
      override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        val rRalue = (seekBarR?.progress!! / 100.0 * 255).toInt()
        Rvalue?.text = "$rRalue(${intToHex(rRalue)})"
        updateViewBackground()
      }

      override fun onStartTrackingTouch(p0: SeekBar?) {
      }

      override fun onStopTrackingTouch(p0: SeekBar?) {
      }
    })
    seekBarG?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
      override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        val gRalue = (seekBarG?.progress!! / 100.0 * 255).toInt()
        Gvalue?.text = "$gRalue(${intToHex(gRalue)})"
        updateViewBackground()
      }

      override fun onStartTrackingTouch(p0: SeekBar?) {
      }

      override fun onStopTrackingTouch(p0: SeekBar?) {
      }
    })
    seekBarB?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
      override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        val bRalue = (seekBarB?.progress!! / 100.0 * 255).toInt()
        Bvalue?.text = "$bRalue(${intToHex(bRalue)})"
        updateViewBackground()
      }

      override fun onStartTrackingTouch(p0: SeekBar?) {
      }

      override fun onStopTrackingTouch(p0: SeekBar?) {
      }
    })
  }

  private fun updateViewBackground(){
    val rRalue = (seekBarR?.progress!! / 100.0 * 255).toInt()
    val gRalue = (seekBarG?.progress!! / 100.0 * 255).toInt()
    val bRalue = (seekBarB?.progress!! / 100.0 * 255).toInt()
    val colorStr = "#${intToHex(rRalue)}${intToHex(gRalue)}${intToHex(bRalue)}"
    view?.setBackgroundColor(Color.rgb(rRalue, gRalue, bRalue))
  }

  private fun intToHex(n: Int): String {
    var n = n
    var s = StringBuffer()
    val b =
      charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')
    while (n != 0) {
      s = s.append(b[n % 16])
      n /= 16
    }
    return s.reverse().toString()
  }
}