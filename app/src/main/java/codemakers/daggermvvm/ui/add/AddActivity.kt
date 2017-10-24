package codemakers.daggermvvm.ui.add
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import codemakers.daggermvvm.R
import codemakers.daggermvvm.databinding.ActivityAddBinding
import codemakers.daggermvvm.ui.LifeDisposable
import codemakers.daggermvvm.ui.main.MainViewModel
import codemakers.daggermvvm.util.text
import codemakers.daggermvvm.util.validateForm
import com.jakewharton.rxbinding2.view.clicks
import dagger.android.AndroidInjection
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_add.*
import javax.inject.Inject

class AddActivity : AppCompatActivity() {

    @Inject
    lateinit var addViewModel: AddViewModel

    lateinit var binding : ActivityAddBinding

    val dis : LifeDisposable = LifeDisposable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title=getString(R.string.addTask)
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_add)
    }

    override fun onResume() {
        super.onResume()

        dis add btnTodoAdd.clicks()
                .flatMap { validateForm(R.string.taskIncomplete, addTodoName.text(), addTodoDescription.text()) }
                .flatMap { addViewModel.insert(it[0],it[1]) }
                .subscribeBy (
                        onNext = {
                            finish()
                        })
    }
}
