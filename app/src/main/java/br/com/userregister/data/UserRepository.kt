package br.com.userregister.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Usado para chamar a class DAO
class UserRepository(private val dao: UserDao) {

    //IO executa operações de qualquer lugar da rede
    fun insert(user: User) = runBlocking {
        launch (Dispatchers.IO){
            dao.insert(user)
        }
    }

    fun getAll() = dao.getAll()

}