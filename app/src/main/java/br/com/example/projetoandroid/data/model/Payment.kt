package br.com.example.projetoandroid.data.model

import java.io.Serializable

data class Payment (
        val idPayment: Int = 0,
        val descriptionPayment: String = "",
        val amountPayment: Double = 0.0,
        val check: Boolean = false,
        val datePayment: String  = "xx/xx/xxxx",
        val openedBy: String = ""
) : Serializable
