package codemakers.daggermvvm.di.module

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders

import codemakers.daggermvvm.di.ActivityScope
import codemakers.daggermvvm.ui.update.UpdateActivity
import codemakers.daggermvvm.ui.update.UpdateViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Asus on 19/10/2017.
 */

@Module
class UpdateModule{

    @ActivityScope
    @Provides
    fun provideUpdateViewModel(activity: UpdateActivity, factory: ViewModelProvider.Factory): UpdateViewModel
            = ViewModelProviders.of(activity, factory).get(UpdateViewModel::class.java)


}
