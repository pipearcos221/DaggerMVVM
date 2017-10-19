package codemakers.daggermvvm.ui.main

import android.arch.lifecycle.ViewModel
import codemakers.daggermvvm.data.dao.TodoDao
import javax.inject.Inject

/**
 * Created by Asus on 18/10/2017.
 */
class MainViewModel @Inject constructor(val dao: TodoDao) : ViewModel() {



}