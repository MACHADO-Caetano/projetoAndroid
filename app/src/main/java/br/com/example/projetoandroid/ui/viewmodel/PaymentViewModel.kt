package br.com.example.projetoandroid.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import br.com.example.projetoandroid.data.PaymentRepository
import br.com.example.projetoandroid.data.local.PaymentLocalDataSource
import br.com.example.projetoandroid.data.local.database.AppDatabase
import br.com.example.projetoandroid.data.model.Payment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

    fun checkPayment(paymentId: Long, isCheck: Boolean) = viewModelScope.launch(Dispatchers.IO) { // <--- **paymentId deve ser Long**
        repository.checkPayment(paymentId, isCheck)
    }

    fun updatePayment(payment: Payment) = viewModelScope.launch(Dispatchers.IO) {
        repository.updatePayment(payment)
    }
}