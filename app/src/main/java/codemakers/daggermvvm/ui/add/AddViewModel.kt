package codemakers.daggermvvm.ui.add

import android.arch.lifecycle.ViewModel
import codemakers.daggermvvm.data.dao.TodoDao
import codemakers.daggermvvm.data.model.Todo
import codemakers.daggermvvm.util.applySchedulers
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Asus on 19/10/2017.
 */

class AddViewModel @Inject constructor(val dao: TodoDao):ViewModel(){

    fun insert(title: String, description: String): Observable<Unit> {
        return Observable.fromCallable { dao.insert(Todo(title,description)) }
                .applySchedulers()
    }

}
