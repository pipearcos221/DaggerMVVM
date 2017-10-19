package codemakers.daggermvvm.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import codemakers.daggermvvm.ui.main.MainViewModel
import codemakers.daggermvvm.util.AppViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Asus on 19/10/2017.
 */

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory:AppViewModelFactory):ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}