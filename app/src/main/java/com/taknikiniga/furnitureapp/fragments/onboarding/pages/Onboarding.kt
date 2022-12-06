package com.taknikiniga.furnitureapp.fragments.onboarding.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.viewModels
import com.taknikiniga.furnitureapp.R
import com.taknikiniga.furnitureapp.databinding.BindOnboard
import com.taknikiniga.furnitureapp.fragments.onboarding.custombind.OnboardBinding
import com.taknikiniga.furnitureapp.fragments.onboarding.viewmodel.OnboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Onboarding : Fragment() {
    private var binding: BindOnboard? = null
    private val onboardVM: OnboardViewModel by viewModels()

    @Inject
    lateinit var custombind: OnboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = inflate(inflater, R.layout.fragment_onboarding, container, false)
        binding?.binding = custombind
        binding?.viewmodel = onboardVM
        onboardVM.bind = custombind
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onboardVM.getOnboardData(binding!!.root)
        custombind.image=""
        custombind.slogstitle=""
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}