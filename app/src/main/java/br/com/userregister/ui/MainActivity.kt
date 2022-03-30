package br.com.userregister.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.userregister.App
import br.com.userregister.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }

    //inicializar na primeira vez e nas próximas vezes que for usar é devolvido um valor como já atribuido em cache
    private val adapter by lazy { UserAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_cards.adapter = adapter
        getAllUser()
        insertListeners()
    }

    private fun insertListeners() {
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddUserActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAllUser() {
        mainViewModel.getAll().observe(this,{user ->
            adapter.submitList(user)
        })
    }
}