package com.example.tablayouttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.tablayouttest.databinding.ContentFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.util.zip.Inflater

class ContentFragment : Fragment() {
    private lateinit var binding: ContentFragmentBinding
    private val model: MainViewModel by activityViewModels()
    private val fragList = listOf(
        InfoFragment.newInstance(),
        UsecaseFragment.newInstance()
    )

    private val fragListTitles = listOf(
        "Description",
        "Usability"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = ContentFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.plant.observe(viewLifecycleOwner) {
            binding.imMain.setImageResource(it.imageId)
        }
        val adapter = VpAdapter(activity as AppCompatActivity, fragList)
        binding.vp2.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.vp2) {
                tab, pos -> tab.text = fragListTitles[pos]
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContentFragment()
    }
}