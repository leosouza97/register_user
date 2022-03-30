package br.com.userregister.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Gerenciar entidades e o Room
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    //abstract class não pode ser instanciada e não pode criar objetos para a classe
    abstract fun userDao() : UserDao

    companion object{
        @Volatile
        private var INSTANCE : AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "user_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}