package br.com.example.projetoandroid.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import br.com.example.projetoandroid.data.model.Payment
import br.com.example.projetoandroid.databinding.PaymentItemListBinding

class PaymentAdapter(
    private val onDelete: (Payment) -> Unit,
    private val onDetails: (Payment) -> Unit,
    private val onCheck: (Payment) -> Unit,
    private val onUpdate: (Payment) -> Unit
) : ListAdapter<Payment, PaymentViewHolder>(PaymentDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val binding =
            PaymentItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PaymentViewHolder(
            binding = binding,
            onDelete = onDelete,
            onDetails = onDetails,
            onCheck = onCheck,
            onUpdate = onUpdate
        )
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}