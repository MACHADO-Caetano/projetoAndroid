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
    suspend fun checkPayment(paymentId: Int, isCheck: Boolean) = dataSource.checkPayment(paymentId, isCheck)
    suspend fun updatePayment(idPayment: Int, descriptionPayment: String, amountPayment: Double, datePayment: String, openedBy: String) = dataSource.updatePayment(idPayment, descriptionPayment, amountPayment, datePayment, openedBy)
}