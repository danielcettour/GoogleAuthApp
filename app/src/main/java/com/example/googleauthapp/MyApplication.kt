package com.example.googleauthapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * in this class, all the code for the dependency injection will be generated
 */
@HiltAndroidApp
class MyApplication: Application() // add in Manifest -> android:name=".MyApplication"