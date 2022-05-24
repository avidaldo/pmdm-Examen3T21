package com.example.examen3t21

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.examen3t21.databinding.FragmentInfoBinding
import com.example.examen3t21.placeholder.IMAGE_NO_AVALIABLE_RESOURCE


class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    private val discosViewModel by activityViewModels<DiscosViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val album = discosViewModel.albumSeleccionadoLiveData.value!!

        binding.albumTitulo.text = album.toString()
        binding.albumImage.setImageResource(album.imageRes ?: IMAGE_NO_AVALIABLE_RESOURCE)
        binding.albumDescription.text = resources.getString(album.descRes)

        binding.removeButton.setOnClickListener {
            discosViewModel.removeAlbum(album)
            //findNavController().navigate(InfoFragmentDirections.actionInfoFragmentToItemFragment())
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}