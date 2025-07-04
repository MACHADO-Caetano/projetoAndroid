package br.com.example.projetoandroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.example.projetoandroid.data.model.Payment
import br.com.example.projetoandroid.databinding.FragmentListPaymentBinding
import br.com.example.projetoandroid.ui.adapter.PaymentAdapter
import br.com.example.projetoandroid.ui.viewmodel.PaymentViewModel

class ListPaymentFragment : Fragment() {
    private lateinit var binding: FragmentListPaymentBinding
    private lateinit var adapter: PaymentAdapter
    private val paymentViewModel: PaymentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        paymentViewModel.paymentlist.observe(viewLifecycleOwner) { payment ->
            adapter.submitList(payment.toMutableList())
        }

        binding = FragmentListPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rc = binding.recyclerView
        adapter = PaymentAdapter(
            onDelete = { payment ->
                paymentViewModel.removePayment(payment)
            },
            onDetails = { payment ->
                goToDetails(payment = payment)
            },
            onCheck = { payment ->
                paymentViewModel.checkPayment(paymentId = payment.idPayment, isCheck = !payment.check) // <--- **idPayment deve ser Long**
            },
            onUpdate = { payment ->
                editPayment(payment = payment)
            }
        )
        rc.adapter = adapter

        binding.fabAdd.setOnClickListener {
            val action = ListPaymentFragmentDirections.actionListPaymentFragmentToFormPaymentFragment(null as Payment?)
            findNavController().navigate(action)
        }
    }

    private fun goToDetails(payment: Payment) {
        val action = ListPaymentFragmentDirections.actionListPaymentFragmentToDetailsPaymentFragment(payment)
        findNavController().navigate(action)
    }

    private fun editPayment(payment: Payment){
        val action = ListPaymentFragmentDirections.actionListPaymentFragmentToFormPaymentFragment(payment)
        findNavController().navigate(action)
    }
}