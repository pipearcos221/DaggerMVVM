package codemakers.daggermvvm.util

import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.widget.text
import io.reactivex.Observable
import org.jetbrains.anko.toast

/**
 * Created by Asus on 17/10/2017.
 */

fun ViewGroup.inflate(@LayoutRes layout:Int) = LayoutInflater.from(context).inflate(layout, this, false)

fun TextInputLayout.text():String = editText?.text.toString()

fun AppCompatActivity.validateForm ( message:Int, vararg fields: String): Observable<List<String>>
        = Observable.create<List<String>> {
            if (fields.contains("")) toast(message)
            else it.onNext(fields.toList())
            it.onComplete()
        }

fun AppCompatActivity.snackBarAction(content: View, message: Int, resAction: Int, obj:Any ) : Observable<Any>
        = Observable.create<Any> { emmiter -> Snackbar.make(content, message, Snackbar.LENGTH_LONG)
        .setAction(resAction, {
            emmiter.onNext(obj)
            emmiter.onComplete()
        }).show()
}