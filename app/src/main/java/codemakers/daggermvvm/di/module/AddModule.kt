package codemakers.daggermvvm.di.module

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import codemakers.daggermvvm.di.ActivityScope
import codemakers.daggermvvm.ui.add.AddActivity
import codemakers.daggermvvm.ui.add.AddViewModel
import codemakers.daggermvvm.ui.main.MainActivity
import codemakers.daggermvvm.ui.main.MainViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Asus on 19/10/2017.
 */

@Module
class AddModule {

    @ActivityScope
    @Provides
    fun provideAddViewModel(activity: AddActivity, factory: ViewModelProvider.Factory): AddViewModel
            = ViewModelProviders.of(activity, factory).get(AddViewModel::class.java)

}
