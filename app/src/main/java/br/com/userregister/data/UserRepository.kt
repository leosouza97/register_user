package br.com.userregister.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class UserRepository(private val dao: UserDao) {

    fun insert(user: User) = runBlocking {
        launch (Dispatchers.IO){
            dao.insert(user)
        }
    }

    fun getAll() = dao.getAll()

}