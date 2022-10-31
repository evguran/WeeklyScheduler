package com.example.tablayouttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.tablayouttest.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private lateinit var binding: MainFragmentBinding
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            model.plant.value = PlantModel(
                R.drawable.romashka,
                "Ромашка - цветок",
                "Ромашкой полоскают горло"
            )
            (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.holder, ContentFragment.newInstance()).commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}