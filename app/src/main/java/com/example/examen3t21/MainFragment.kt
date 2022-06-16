package com.example.examen3t21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.examen3t21.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val discosViewModel by activityViewModels<DiscosViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adaptador = ArrayAdapter.createFromResource(
            requireContext(), R.array.generos, android.R.layout.simple_spinner_item
        ).apply { setDropDownViewResource(R.layout.spinner_dropdown_item) }


        with(binding.spinnerAlbumes) {
            adapter = adaptador
            setSelection(0, false)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p: AdapterView<*>?, v: View, position: Int, id: Long) {
                    if (position == 0) noSelectionSpinner()
                    else showButton()
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

            binding.button.setOnClickListener {
                onClickButton()
            }
        }
    }

    private fun onClickButton() {
        discosViewModel.updateGeneroLiveData(
            when (binding.spinnerAlbumes.selectedItemPosition) {
                1 -> Album.Genero.Rock
                2 -> Album.Genero.Blues
                3 -> Album.Genero.Jazz
                else -> throw RuntimeException("Opción no válida")
            }
        )
        findNavController().navigate(MainFragmentDirections.actionFirstFragmentToItemFragment())
    }

    private fun showButton() {
        binding.button.visibility = View.VISIBLE
    }

    private fun noSelectionSpinner() {
        binding.button.visibility = View.INVISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}