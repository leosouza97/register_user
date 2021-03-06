package br.com.userregister.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.userregister.data.User
import br.com.userregister.data.UserRepository

//Usada para trafegar informações entre o repository e a UI
class MainViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun insert(user: User){
        userRepository.insert(user)
    }

    fun getAll() : LiveData<List<User>>{
        return userRepository.getAll()
    }

}

//Para instanciar esse ViewModel, preciso ter uma Factory que os ViewModelProviders possam usar para criar sua instância.
class MainViewModelFactory(private val repository: UserRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}