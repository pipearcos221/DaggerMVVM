package codemakers.daggermvvm.di

import codemakers.daggermvvm.di.module.AddModule
import codemakers.daggermvvm.di.module.MainModule
import codemakers.daggermvvm.ui.add.AddActivity
import codemakers.daggermvvm.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

/**
 * Created by Asus on 18/10/2017.
 */

@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class ActivityScope

@Module
abstract class ActivityBuilders{

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(AddModule::class))
    abstract fun bindAddActivity(): AddActivity


}