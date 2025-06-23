package br.com.example.projetoandroid.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payments")
data class PaymentEntity(
    @PrimaryKey(autoGenerate = true)

    val id: Int = 0,
    val title: String = "",
    val taskDescription: String = "",
    val isCheck: Boolean = false,
    val createdAt: String = "10/02/2025",
    val openedBy: String = "Big Caethas"
)