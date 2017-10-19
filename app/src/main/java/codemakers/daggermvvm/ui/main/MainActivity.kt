package codemakers.daggermvvm.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import codemakers.daggermvvm.R
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
    }
}
