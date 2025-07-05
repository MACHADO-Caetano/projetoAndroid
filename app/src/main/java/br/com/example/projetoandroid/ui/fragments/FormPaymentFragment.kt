package br.com.example.projetoandroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.example.projetoandroid.data.model.Payment
import br.com.example.projetoandroid.databinding.FragmentFormPaymentBinding
import br.com.example.projetoandroid.ui.viewmodel.PaymentViewModel

class FormPaymentFragment : Fragment() {
    private lateinit var binding: FragmentFormPaymentBinding
    private val paymentViewModel: PaymentViewModel by viewModels()
    //A propriedade 'args' é inicializada usando 'navArgs()'.
    private val args: FormPaymentFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }
    // so é execudando quando for uma edição chamando seus campos ja preenchidos
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receivedPayment = args.payment

        receivedPayment?.let { payment ->
            binding.txvDescription.setText(payment.descriptionPayment)
            binding.txvAmount.setText(payment.amountPayment.toString())
            binding.txvUser.setText(payment.openedBy)
            binding.txvDate.setText(payment.datePayment)
            binding.buttonForm.text = "Atualizar Pagamento"
        }

        binding.buttonForm.setOnClickListener {
            val description = binding.txvDescription.text.toString()
            val amount = binding.txvAmount.text.toString().toDoubleOrNull() ?: 0.0
            val user = binding.txvUser.text.toString()
            val date = binding.txvDate.text.toString()

            if (receivedPayment == null) {
                val newPayment = Payment(
                    descriptionPayment = description,
                    amountPayment = amount,
                    openedBy = user,
                    datePayment = date
                )
                paymentViewModel.addPayment(newPayment)
            } else {
                val updatedPayment = receivedPayment.copy(
                    descriptionPayment = description,
                    amountPayment = amount,
                    openedBy = user,
                    datePayment = date
                )
                paymentViewModel.updatePayment(updatedPayment)
            }

            val action = FormPaymentFragmentDirections.actionFormPaymentFragmentToListPaymentFragment()
            findNavController().navigate(action)
        }
    }
}