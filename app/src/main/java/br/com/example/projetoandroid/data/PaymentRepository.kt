package br.com.example.projetoandroid.data

import br.com.example.projetoandroid.data.local.PaymentLocalDataSource
import br.com.example.projetoandroid.data.mapper.convertToEntity
import br.com.example.projetoandroid.data.mapper.convertToModel
import br.com.example.projetoandroid.data.model.Payment
import kotlinx.coroutines.flow.map

class PaymentRepository(private val dataSource: PaymentLocalDataSource) {
    fun getAllPayments() =
        dataSource.getAllPayments().map { entities -> entities.map { it.convertToModel() } }

    suspend fun remove(payment: Payment) = dataSource.deletePayment(payment.convertToEntity())
    suspend fun add(payment: Payment) = dataSource.addPayment(payment.convertToEntity())
    suspend fun checkPayment(paymentId: Long, isCheck: Boolean) = dataSource.checkPayment(paymentId, isCheck) // <--- **paymentId deve ser Long**
    suspend fun updatePayment(payment: Payment) = dataSource.updatePayment(payment.convertToEntity())
}