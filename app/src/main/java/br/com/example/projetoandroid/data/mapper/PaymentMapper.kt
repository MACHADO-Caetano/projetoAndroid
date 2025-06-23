package br.com.example.projetoandroid.data.mapper

import br.com.example.projetoandroid.data.model.Payment

class PaymentMapper {
    fun Payment.convertToEntity() =
        PaymentEntity(
            descriptionPayment = this.descriptionPayment,
            amountPayment = this.amountPayment,
            datePayment = this.datePayment,
            openedBy = this.openedBy,
            isCheck = this.check
        )

    fun PaymentEntity.convertToModel() =
        Payment(
            idPayment = this.idPayment,
            descriptionPayment = this.descriptionPayment,
            amountPayment = this.amountPayment,
            datePayment = this.datePayment,
            openedBy = this.openedBy,
            isCheck = this.check
        )
}