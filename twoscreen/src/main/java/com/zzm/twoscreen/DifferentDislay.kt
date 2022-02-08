package com.zzm.twoscreen

import android.app.Presentation
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Matrix
import android.os.Build
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.util.Log
import android.view.Display
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.zzm.twoscreen.R.drawable
import com.zzm.twoscreen.R.id
import com.zzm.twoscreen.R.layout

class DifferentDislay(outerContext: Context?, display: Display?) :
  Presentation(outerContext, display) {
  override fun onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(layout.diffrentdisplay)
    Log.e("zzm debug", " onCreate : " + resources.configuration.toString())
  }

  /*companion object {
    private var imageView: ImageView? = null
    fun setImage(which: Int) {
      when (which) {
        1 -> imageView!!.setImageResource(drawable.maintenance2)
        2 -> imageView!!.setImageResource(drawable.testchanghong2)
        3 -> imageView!!.setImageResource(drawable.testchanghong3)
        4 -> imageView!!.setImageResource(drawable.testchanghong4)
        else -> {}
      }
    }

    fun setImage(bitmap: Bitmap) {
      imageView!!.setImageBitmap(adjustPhotoRotation(bitmap, 90))
    }

    private fun adjustPhotoRotation(bm: Bitmap, orientationDegree: Int): Bitmap? {
      val m = Matrix()
      m.setRotate(orientationDegree.toFloat(), bm.width.toFloat() / 2, bm.height.toFloat() / 2)
      return try {
        Bitmap.createBitmap(bm, 0, 0, bm.width, bm.height, m, true)
      } catch (ex: OutOfMemoryError) {
        null
      }
    }
  }*/
}