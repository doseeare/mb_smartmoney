package com.molbulak.smartmoney.ui.loan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.molbulak.smartmoney.App
import com.molbulak.smartmoney.Screens
import com.molbulak.smartmoney.adapter.NewsAdapter
import com.molbulak.smartmoney.databinding.FragmentLoanBinding
import com.molbulak.smartmoney.extensions.toast
import com.molbulak.smartmoney.service.network.Status
import com.molbulak.smartmoney.ui.BackButtonListener
import com.molbulak.smartmoney.util.enums.ContainerType
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoanFragment : Fragment(), BackButtonListener {
    lateinit var binding: FragmentLoanBinding
    private val viewModel: LoanViewModel by viewModel()

    private lateinit var router: Router

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        router = App.localCicerone.getCicerone(ContainerType.LOAN).router

        binding = FragmentLoanBinding.inflate(inflater, container, false)
        initNews()
        return binding.root
    }

    private fun initNews() {
        viewModel.listNews.observe(viewLifecycleOwner, {
            val data = it.data
            when (it.status) {
                Status.SUCCESS -> {
                    binding.newsRv.adapter = NewsAdapter(data?.result!!) {
                        router.navigateTo(Screens.NewsDetailScreen(it))
                    }
                }
                Status.ERROR -> {
                    toast("news error ${data!!.error?.code}")
                }
                Status.NETWORK -> {
                    toast("Проблемы с подключением")
                }
            }
        })

    }

    override fun backPressed(): Boolean {
        router.exit()
        return true
    }

}