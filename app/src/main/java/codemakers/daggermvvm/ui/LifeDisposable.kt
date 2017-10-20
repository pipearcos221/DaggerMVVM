package codemakers.daggermvvm.ui

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Asus on 20/10/2017.
 */
class LifeDisposable (owner: LifecycleOwner):LifecycleObserver{

    var dis: CompositeDisposable = CompositeDisposable()

    init {
        owner.lifecycle.addObserver(this)
    }

    infix fun add(disposable: Disposable){
        dis.add(disposable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun clearAll(){
        dis.clear()
    }

}