package br.com.example.projetoandroid.data

import br.com.example.projetoandroid.data.model.Payment

class PaymentRepository(private val dataSource: PaymentLocalDataSource) {
    fun getAllPayments() =
        dataSource.getAllTodos().map { entities -> entities.map { it.convertToModel() } }

    suspend fun remove(payment: Payment) = dataSource.deleteTodo(payment.convertToEntity())
    suspend fun add(payment: Payment) = dataSource.addTodo(payment.convertToEntity())
    suspend fun checkPayment(paymentId: Int, isCheck: Boolean) = dataSource.checkTodo(paymentId, isCheck)
}