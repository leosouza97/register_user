package br.com.userregister.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.userregister.App
import br.com.userregister.R
import br.com.userregister.data.User
import kotlinx.android.synthetic.main.activity_add_user.*

class AddUserActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        insertListeners()

    }

    private fun insertListeners() {
        btn_close.setOnClickListener {
            finish()
        }

        btn_confirmar.setOnClickListener{
            val user = User(
                name = til_name.editText?.text.toString(),
                lastName = til_lastname.editText?.text.toString()
            )
            mainViewModel.insert(user)
            finish()
        }
    }
}