package br.com.example.projetoandroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.example.projetoandroid.data.model.Payment
import br.com.example.projetoandroid.databinding.FragmentFormPaymentBinding
import br.com.example.projetoandroid.ui.viewmodel.PaymentViewModel

class FormPaymentFragment : Fragment() {
    private lateinit var binding: FragmentFormPaymentBinding
    private val paymentViewModel: PaymentViewModel by viewModels()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonForm.setOnClickListener {
            val payment = Payment(
                descriptionPayment = binding.txvDescription.text.toString(),
                amountPayment = binding.txvAmount.text.toString().toDouble(),
                openedBy = binding.txvUser.text.toString(),
                datePayment = binding.txvDate.text.toString()
            )

            paymentViewModel.addPayment(payment)
            val action = FormPaymentFragmentDirections.actionFormPaymentFragmentToListPaymentFragment()
            findNavController().navigate(action)
        }

        binding.buttonForm.setOnClickListener {
            val payment = Payment(
                descriptionPayment = binding.txvDescription.text.toString(),
                amountPayment = binding.txvAmount.text.toString().toDouble(),
                openedBy = binding.txvUser.text.toString(),
                datePayment = binding.txvDate.text.toString()
            )

            paymentViewModel.updatePayment(payment)
            val action = FormPaymentFragmentDirections.actionFormPaymentFragmentToListPaymentFragment()
            findNavController().navigate(action)
        }
    }
}