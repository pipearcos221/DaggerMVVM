package codemakers.daggermvvm.util

import android.support.annotation.LayoutRes
import android.support.design.widget.TextInputLayout
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jakewharton.rxbinding2.widget.text

/**
 * Created by Asus on 17/10/2017.
 */

fun ViewGroup.inflate(@LayoutRes layout:Int) = LayoutInflater.from(context).inflate(layout, this, false)

fun TextInputLayout.text():String = editText?.text.toString()