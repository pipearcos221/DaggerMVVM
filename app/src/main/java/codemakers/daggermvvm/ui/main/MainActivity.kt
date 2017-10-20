package codemakers.daggermvvm.ui.main

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import codemakers.daggermvvm.R
import codemakers.daggermvvm.databinding.ActivityMainBinding
import codemakers.daggermvvm.ui.adapters.TodoAdapter
import codemakers.daggermvvm.ui.add.AddActivity
import dagger.android.AndroidInjection
import io.reactivex.rxkotlin.subscribeBy
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel : MainViewModel

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var adapter: TodoAdapter

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.mainTitle)
        //setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.recycler.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.listTodo().subscribeBy( onNext = { adapter.data = it } )
    }

    fun goToAdd() {
        startActivity<AddActivity>()
    }

    }





