package br.com.example.projetoandroid.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.example.projetoandroid.data.model.Payment

class PaymentViewHolder(
    private val binding: PaymentItemListBinding,
    private val onDelete: (Payment) -> Unit,
    private val onDetails: (Payment) -> Unit,
    private val onCheck: (Payment) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(payment: Payment) {
        binding.payment = Payment

        binding.actionDelete.setOnClickListener {
            onDelete(payment)
        }

        binding.actionDetails.setOnClickListener {
            onDetails(payment)
        }

        binding.paymentCheck.addOnCheckedStateChangedListener { check, _ ->
            val newPayment = payment.copy(check = check.isChecked)
            binding.payment = newPayment
            onCheck(newPayment)
        }
    }
}
