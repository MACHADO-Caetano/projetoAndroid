package br.com.example.projetoandroid.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: PaymentEntity)

    @Query("SELECT * FROM payment")
    fun getAllPayment(): Flow<List<PaymentEntity>>

    @Query("Update payments SET isCheck = :isCheck where id = :paymentId")
    suspend fun checkPayment(paymentId: Int, isCheck: Boolean)

    @Delete
    suspend fun delete(user: PaymentEntity)
}