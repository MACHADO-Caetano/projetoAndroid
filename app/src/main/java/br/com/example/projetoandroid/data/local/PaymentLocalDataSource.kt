package br.com.example.projetoandroid.data.local

import br.com.example.projetoandroid.data.local.dao.PaymentDao
import br.com.example.projetoandroid.data.local.entity.PaymentEntity
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