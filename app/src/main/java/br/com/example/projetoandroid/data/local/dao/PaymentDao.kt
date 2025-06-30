package br.com.example.projetoandroid.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import br.com.example.projetoandroid.data.local.entity.PaymentEntity

@Dao
interface PaymentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: PaymentEntity)

    @Query("SELECT * FROM payments")
    fun getAllPayments(): Flow<List<PaymentEntity>>

    @Query("Update payments SET isCheck = :isCheck where id = :paymentId")
    suspend fun checkPayment(paymentId: Int, isCheck: Boolean)

    @Delete
    suspend fun delete(user: PaymentEntity)
}