package br.com.example.projetoandroid.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import br.com.example.projetoandroid.data.PaymentRepository
import br.com.example.projetoandroid.data.local.PaymentLocalDataSource
import br.com.example.projetoandroid.data.local.database.AppDatabase
import br.com.example.projetoandroid.data.model.Payment

class PaymentViewModel(application: Application) : AndroidViewModel(application) {
    private val paymentDao = AppDatabase.getInstance(application).paymentDao()
    private val localDataSource = PaymentLocalDataSource(paymentDao)
    private val repository = PaymentRepository(localDataSource)

    private val _paymentlist = repository.getAllPayments().asLiveData()
    val paymentlist: LiveData<List<Payment>> = _paymentlist
    init {
        repository.getAllPayments()
    }

    fun removePayment(payment: Payment) = viewModelScope.launch(Dispatchers.IO) {
        repository.remove(payment)
    }

    fun addPayment(payment: Payment) = viewModelScope.launch(Dispatchers.IO) {
        repository.add(payment)
    }

    fun checkPayment(paymentId: Int, isCheck: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        repository.checkPayment(paymentId, isCheck)
    }
}