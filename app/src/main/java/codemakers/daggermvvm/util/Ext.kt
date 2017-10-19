package codemakers.daggermvvm.util

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Asus on 17/10/2017.
 */

fun ViewGroup.inflate(@LayoutRes layout:Int) = LayoutInflater.from(context).inflate(layout, this, false)