package com.danielcano.imdbapp

import android.app.Application
import android.content.Context

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setContext(this)
    }

    companion object {
        private lateinit var application: Application

        private fun setContext(app: App) {
            application = app
        }

        fun getContext(): Context {
            return application
        }
    }
}