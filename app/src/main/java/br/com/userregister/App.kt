package br.com.userregister

import android.app.Application
import br.com.userregister.data.AppDatabase
import br.com.userregister.data.UserRepository

class App : Application() {

    //instanciar room e o repository.
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { UserRepository(database.userDao()) }
}