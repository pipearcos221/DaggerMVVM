package codemakers.daggermvvm.di.module

import codemakers.daggermvvm.di.ActivityScope
import codemakers.daggermvvm.ui.adapters.TodoAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by Asus on 18/10/2017.
 */

@Module
class MainModule {

    @ActivityScope
    @Provides
    fun provideAdapter():TodoAdapter = TodoAdapter()


}