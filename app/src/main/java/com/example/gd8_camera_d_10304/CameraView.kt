package com.example.gd8_camera_d_10304

import android.content.Context
import android.hardware.Camera
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.io.IOException

class CameraView(context: Context?, private val mCamera: Camera) : SurfaceView(context),SurfaceHolder.Callback {

    private val mHolder: SurfaceHolder

    init {
        mCamera.setDisplayOrientation(90)
        mHolder = holder
        mHolder.addCallback(this)
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    }
    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        try {
            mCamera.setPreviewDisplay(mHolder)
            mCamera.startPreview()
        } catch (e: IOException) {
            Log.d("error", "Camera eror on surfaceCreated + e.message")
        }
    }

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {
        mCamera.stopPreview()
        mCamera.release()
    }

}
