package br.com.example.projetoandroid.data.local

import br.com.example.projetoandroid.data.model.Payment
import kotlinx.coroutines.flow.Flow

class PaymentLocalDataSource(private val paymentDao: PaymentDao) {
    fun getAllPayments(): Flow<List<PaymentEntity>> = paymentDao.getAllPayments()

    suspend fun addPayment(payment: PaymentEntity) {
        paymentDao.insert(payment)
    }

    suspend fun deletePayment(user: PaymentEntity) {
        paymentDao.delete(user)
    }

    suspend fun checkPayment(paymentId: Int, isCheck: Boolean) {
        paymentDao.checkPayment(paymentId, !isCheck)
    }
}