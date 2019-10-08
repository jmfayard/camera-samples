/*
 * Copyright 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.camera2basic

import android.graphics.SurfaceTexture
import android.hardware.camera2.*
import android.media.ImageReader
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.util.Size
import android.util.SparseIntArray
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import java.io.File
import java.util.concurrent.Semaphore

public inline fun needsRefactoring(): Nothing = throw NotImplementedError("""
    This does too much and needs to be refactored. 
    Don't put any kind of logic in the Activities and Fragments. 
""".trimIndent())


class Camera2BasicFragment : Fragment(), View.OnClickListener,
        ActivityCompat.OnRequestPermissionsResultCallback {
    private val surfaceTextureListener = object : TextureView.SurfaceTextureListener {
        override fun onSurfaceTextureAvailable(texture: SurfaceTexture, width: Int, height: Int) = needsRefactoring()
        override fun onSurfaceTextureSizeChanged(texture: SurfaceTexture, width: Int, height: Int) = needsRefactoring()
        override fun onSurfaceTextureDestroyed(texture: SurfaceTexture) = needsRefactoring()
        override fun onSurfaceTextureUpdated(texture: SurfaceTexture) = needsRefactoring()

    }
    private lateinit var cameraId: String
    private lateinit var textureView: AutoFitTextureView
    private var captureSession: CameraCaptureSession? = null
    private var cameraDevice: CameraDevice? = null
    private lateinit var previewSize: Size
    private val stateCallback = object : CameraDevice.StateCallback() {
        override fun onOpened(cameraDevice: CameraDevice) = needsRefactoring()
        override fun onDisconnected(cameraDevice: CameraDevice) = needsRefactoring()
        override fun onError(cameraDevice: CameraDevice, error: Int) = needsRefactoring()
    }
    private var backgroundThread: HandlerThread? = null
    private var backgroundHandler: Handler? = null
    private var imageReader: ImageReader? = null
    private lateinit var file: File
    private val onImageAvailableListener: ImageReader.OnImageAvailableListener = needsRefactoring()
    private lateinit var previewRequestBuilder: CaptureRequest.Builder
    private lateinit var previewRequest: CaptureRequest
    private var state = STATE_PREVIEW
    private val cameraOpenCloseLock = Semaphore(1)
    private var flashSupported = false
    private var sensorOrientation = 0
    private val captureCallback = object : CameraCaptureSession.CaptureCallback() {
        private fun process(result: CaptureResult): Unit = needsRefactoring()
        private fun capturePicture(result: CaptureResult): Unit = needsRefactoring()
        override fun onCaptureProgressed(session: CameraCaptureSession, request: CaptureRequest, partialResult: CaptureResult) = needsRefactoring()
        override fun onCaptureCompleted(session: CameraCaptureSession, request: CaptureRequest, result: TotalCaptureResult) = needsRefactoring()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = needsRefactoring()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = needsRefactoring()
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        needsRefactoring()
    }

    override fun onResume() {
        super.onResume()
        needsRefactoring()
    }

    override fun onPause() {
        super.onPause()
        needsRefactoring()
    }

    private fun requestCameraPermission(): Unit = needsRefactoring()
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray): Unit = needsRefactoring()
    private fun setUpCameraOutputs(width: Int, height: Int): Unit = needsRefactoring()
    private fun areDimensionsSwapped(displayRotation: Int): Boolean = needsRefactoring()
    private fun openCamera(width: Int, height: Int): Unit = needsRefactoring()
    private fun closeCamera(): Unit = needsRefactoring()
    private fun startBackgroundThread(): Unit = needsRefactoring()
    private fun stopBackgroundThread(): Unit = needsRefactoring()
    private fun createCameraPreviewSession(): Unit = needsRefactoring()
    private fun configureTransform(viewWidth: Int, viewHeight: Int): Unit = needsRefactoring()
    private fun lockFocus(): Unit = needsRefactoring()
    private fun runPrecaptureSequence(): Unit = needsRefactoring()
    private fun captureStillPicture(): Unit = needsRefactoring()
    private fun unlockFocus(): Unit = needsRefactoring()
    override fun onClick(view: View): Unit = needsRefactoring()
    private fun setAutoFlash(requestBuilder: CaptureRequest.Builder): Unit = needsRefactoring()

    companion object {
        init {
            needsRefactoring()
        }

        private val ORIENTATIONS = SparseIntArray()
        private val FRAGMENT_DIALOG = "dialog"
        private val TAG = "Camera2BasicFragment"
        private val STATE_PREVIEW = 0
        private val STATE_WAITING_LOCK = 1
        private val STATE_WAITING_PRECAPTURE = 2
        private val STATE_WAITING_NON_PRECAPTURE = 3
        private val STATE_PICTURE_TAKEN = 4
        private val MAX_PREVIEW_WIDTH = 1920
        private val MAX_PREVIEW_HEIGHT = 1080
        @JvmStatic
        private fun chooseOptimalSize(
                choices: Array<Size>, textureViewWidth: Int, textureViewHeight: Int,
                maxWidth: Int, maxHeight: Int, aspectRatio: Size): Size = needsRefactoring()

        @JvmStatic
        fun newInstance(): Camera2BasicFragment = needsRefactoring()
    }
}
