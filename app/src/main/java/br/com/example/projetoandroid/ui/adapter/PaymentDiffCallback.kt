package br.com.example.projetoandroid.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import br.com.example.projetoandroid.data.model.Payment

class PaymentDiffCallback : DiffUtil.ItemCallback<Payment>() {
    override fun areItemsTheSame(oldItem: Payment, newItem: Payment): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Payment, newItem: Payment): Boolean {
        return oldItem == newItem
    }
}