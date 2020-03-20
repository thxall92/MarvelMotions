package com.thxallgrace.marvelmotions.view.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thxallgrace.marvelmotions.R
import com.thxallgrace.marvelmotions.base.DatabindingFragment
import com.thxallgrace.marvelmotions.databinding.FragmentHomeBinding

class HomeFragment : DatabindingFragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentHomeBinding>(inflater, R.layout.fragment_home, container).apply {

        }.root
    }
}