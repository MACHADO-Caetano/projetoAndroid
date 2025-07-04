package br.com.example.projetoandroid.data.local

import br.com.example.projetoandroid.data.local.dao.PaymentDao
import br.com.example.projetoandroid.data.local.entity.PaymentEntity
import kotlinx.coroutines.flow.Flow

class PaymentLocalDataSource(private val paymentDao: PaymentDao) {
    fun getAllPayments(): Flow<List<PaymentEntity>> = paymentDao.getAllPayments()

    suspend fun addPayment(payment: PaymentEntity) {
        paymentDao.insert(payment)
    }

    suspend fun deletePayment(payment: PaymentEntity) {
        paymentDao.delete(payment)
    }

    suspend fun checkPayment(paymentId: Long, isCheck: Boolean) {
        paymentDao.checkPayment(paymentId, isCheck)
    }

    suspend fun updatePayment(payment: PaymentEntity) {
        paymentDao.update(payment)
    }
}