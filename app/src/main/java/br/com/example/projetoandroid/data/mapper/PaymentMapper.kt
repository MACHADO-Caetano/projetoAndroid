package br.com.example.projetoandroid.data.mapper

import br.com.example.projetoandroid.data.local.entity.PaymentEntity
import br.com.example.projetoandroid.data.model.Payment

fun Payment.convertToEntity() =
    PaymentEntity(
            id = this.idPayment,
            paymentDescription = this.descriptionPayment,
            amountPayment = this.amountPayment,
            datePayment = this.datePayment,
            openedBy = this.openedBy,
            isCheck = this.check
        )

    fun PaymentEntity.convertToModel() =
        Payment(
            idPayment = this.id,
            descriptionPayment = this.paymentDescription,
            amountPayment = this.amountPayment,
            datePayment = this.datePayment,
            openedBy = this.openedBy,
            check = this.isCheck
        )
