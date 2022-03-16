package br.com.userregister.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val lastName: String
)