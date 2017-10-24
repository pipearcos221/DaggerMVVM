package codemakers.daggermvvm.ui.main

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import codemakers.daggermvvm.R
import codemakers.daggermvvm.data.model.Todo
import codemakers.daggermvvm.databinding.ActivityMainBinding
import codemakers.daggermvvm.ui.LifeDisposable
import codemakers.daggermvvm.ui.adapters.TodoAdapter
import codemakers.daggermvvm.ui.add.AddActivity
import codemakers.daggermvvm.ui.update.UpdateActivity
import codemakers.daggermvvm.util.snackBarAction
import com.jakewharton.rxbinding2.view.clicks
import dagger.android.AndroidInjection
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.contentView
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var adapter: TodoAdapter

    lateinit var binding: ActivityMainBinding

    val dis : LifeDisposable = LifeDisposable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.mainTitle)
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.recycler.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.listTodo().subscribeBy( onNext = { adapter.data = it } )

        dis add goToAdd.clicks().subscribeBy ( onNext = { goToAdd() } )

        dis add adapter.todoDelete
                .flatMap { todo -> mainViewModel.removeTodo(todo).map { todo } }
                .flatMap { snackBarAction(contentView!!, R.string.msgSnackBar, R.string.undo, it) }
                .flatMap { mainViewModel.recoverTodo(it as Todo) }
                .subscribe()

        dis add adapter.todoDetail.subscribeBy( onNext = { goToDetail(it) } )

    }

    fun goToDetail(todo: Todo){
        startActivity<UpdateActivity>("todo" to todo)
    }

    fun goToAdd() {

        startActivity<AddActivity>()
    }

    }






