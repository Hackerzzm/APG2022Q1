package com.zzm.rgbtest

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.WindowManager.LayoutParams
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.zzm.rgbtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    initViews()
    initEvent()
  }

  private fun initEvent() {
    binding.seekBarR.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
      override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        val rRalue = (binding.seekBarR.progress / 100.0 * 255).toInt()
        binding.Rvalue.text = "$rRalue(${intToHex(rRalue)})"
        updateViewBackground()
      }

      override fun onStartTrackingTouch(p0: SeekBar?) {
      }

      override fun onStopTrackingTouch(p0: SeekBar?) {
      }
    })
    binding.seekBarG.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
      override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        val gRalue = (binding.seekBarG.progress / 100.0 * 255).toInt()
        binding.Gvalue.text = "$gRalue(${intToHex(gRalue)})"
        updateViewBackground()
      }

      override fun onStartTrackingTouch(p0: SeekBar?) {
      }

      override fun onStopTrackingTouch(p0: SeekBar?) {
      }
    })
    binding.seekBarB.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
      override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        val bRalue = (binding.seekBarB.progress / 100.0 * 255).toInt()
        binding.Bvalue.text = "$bRalue(${intToHex(bRalue)})"
        updateViewBackground()
      }

      override fun onStartTrackingTouch(p0: SeekBar?) {
      }

      override fun onStopTrackingTouch(p0: SeekBar?) {
      }
    })
  }

  private fun initViews() {
    /*window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
    window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    val attrs = window.attributes
    attrs.flags = attrs.flags and LayoutParams.FLAG_FULLSCREEN.inv()
    window.attributes = attrs*/
//    https://blog.csdn.net/qq_34681580/article/details/103955191
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    //注意要清除 FLAG_TRANSLUCENT_STATUS flag
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.statusBarColor = resources.getColor(R.color.colorPrimary)

    val rRalue = (binding.seekBarR.progress / 100.0 * 255).toInt()
    binding.Rvalue.text = "$rRalue(${intToHex(rRalue)})"
    val gRalue = (binding.seekBarG.progress / 100.0 * 255).toInt()
    binding.Gvalue.text = "$gRalue(${intToHex(gRalue)})"
    val bRalue = (binding.seekBarB.progress / 100.0 * 255).toInt()
    binding.Bvalue.text = "$bRalue(${intToHex(bRalue)})"
    updateViewBackground()
    hideBottomUIMenu()
  }

  /**
   * 隐藏虚拟按键，并且全屏
   */
  protected fun hideBottomUIMenu() {
    val decorView: View = window.decorView
    val uiOptions: Int = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN)
    decorView.systemUiVisibility = uiOptions
  }

  private fun updateViewBackground(){
    val rRalue = (binding.seekBarR.progress / 100.0 * 255).toInt()
    val gRalue = (binding.seekBarG.progress / 100.0 * 255).toInt()
    val bRalue = (binding.seekBarB.progress / 100.0 * 255).toInt()
    val colorStr = "#${intToHex(rRalue)}${intToHex(gRalue)}${intToHex(bRalue)}"
    binding.view.setBackgroundColor(Color.rgb(rRalue, gRalue, bRalue))
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