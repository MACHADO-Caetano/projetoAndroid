package br.com.example.projetoandroid.data.model

import java.io.Serializable

data class Payment (
        val idPayment: Int = 0,
        val descriptionPayment: String = "",
        val amountPayment: Double,
        val check: Boolean = false,
        val datePayment: String,
        val openedBy: String = ""
) : Serializable
