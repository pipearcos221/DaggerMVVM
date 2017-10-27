package codemakers.daggermvvm.ui.update

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import codemakers.daggermvvm.R
import codemakers.daggermvvm.data.model.Todo
import codemakers.daggermvvm.databinding.ActivityUpdateBinding
import codemakers.daggermvvm.ui.LifeDisposable
import codemakers.daggermvvm.util.text
import codemakers.daggermvvm.util.validateForm
import com.jakewharton.rxbinding2.view.clicks
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_update.*
import javax.inject.Inject

class UpdateActivity : AppCompatActivity() {

    @Inject
    lateinit var updateViewModel : UpdateViewModel
    lateinit var todo : Todo
    lateinit var binding : ActivityUpdateBinding
    val dis: LifeDisposable = LifeDisposable(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_update)
        todo = intent.getParcelableExtra("todo")
        title = todo.title
        updateDescription.editText?.setText(todo.description)

    }

    override fun onResume() {
        super.onResume()
        dis add btnSaveTodo.clicks()
                .flatMap { validateForm(R.string.taskIncomplete, updateDescription.text()) }
                .flatMap {
                    todo.description = it[0]
                    updateViewModel.updateTodo(todo)
                }
                .subscribe { finish() }
    }

}
