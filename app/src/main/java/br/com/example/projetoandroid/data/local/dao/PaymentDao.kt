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

    @Query("Update payments SET paymentDescription = :descriptionPayment, amountPayment = :amountPayment, datePayment = :datePayment, openedBy = :openedBy  where id = :idPayment")
    suspend fun updatePayment(idPayment: Int, descriptionPayment: String, amountPayment: Double, datePayment: String, openedBy: String)

    @Delete
    suspend fun delete(user: PaymentEntity)
}