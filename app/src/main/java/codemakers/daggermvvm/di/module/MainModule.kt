package codemakers.daggermvvm.di.module

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import codemakers.daggermvvm.di.ActivityScope
import codemakers.daggermvvm.ui.adapters.TodoAdapter
import codemakers.daggermvvm.ui.main.MainActivity
import codemakers.daggermvvm.ui.main.MainViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Asus on 18/10/2017.
 */

@Module
class MainModule {

    @ActivityScope
    @Provides
    fun provideViewModel(activity: MainActivity, factory: ViewModelProvider.Factory): MainViewModel
            = ViewModelProviders.of(activity, factory).get(MainViewModel::class.java)

    @ActivityScope
    @Provides
    fun provideAdapter():TodoAdapter = TodoAdapter()


}