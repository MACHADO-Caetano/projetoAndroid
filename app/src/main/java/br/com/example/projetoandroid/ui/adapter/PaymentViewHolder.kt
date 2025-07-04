package br.com.example.projetoandroid.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.example.projetoandroid.data.model.Payment
import br.com.example.projetoandroid.databinding.PaymentItemListBinding

class PaymentViewHolder(
    private val binding: PaymentItemListBinding,
    private val onDelete: (Payment) -> Unit,
    private val onDetails: (Payment) -> Unit,
    private val onCheck: (Payment) -> Unit,
    private val onUpdate: (Payment) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(payment: Payment) {
        binding.payment = payment

        binding.actionDelete.setOnClickListener {
            onDelete(payment)
        }

        binding.actionDetails.setOnClickListener {
            onDetails(payment)
        }
        binding.actionUpdate.setOnClickListener {
            onUpdate(payment)
        }

        binding.paymentCheck.addOnCheckedStateChangedListener { check, _ ->
            val newPayment = payment.copy(check = check.isChecked)
            binding.payment = newPayment
            onCheck(newPayment)
        }
    }
}
