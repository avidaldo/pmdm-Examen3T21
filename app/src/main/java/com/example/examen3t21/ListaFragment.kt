package com.example.examen3t21

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.examen3t21.databinding.FragmentListadoBinding
import com.example.examen3t21.placeholder.Album


class ListaFragment : Fragment() {
    private var _binding: FragmentListadoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListadoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /***********************************************************/


    private val discosViewModel by activityViewModels<DiscosViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val discosAdapter = DiscosRecyclerViewAdapter({ album -> onClickInfo(album) }).also {
            binding.recyclerView.adapter = it
        }

        discosViewModel.albumsLiveData.observe(viewLifecycleOwner) {
            it?.let {
                discosAdapter.submitList(it)
            }
        }

/*        binding.fab.setOnClickListener {
            fabOnClick()
        }*/

    }

    private fun onClickInfo(album: Album) {
        discosViewModel.updateAlbumSeleccionadoLiveData(album)
        findNavController().navigate(
            ListaFragmentDirections.actionToInfoFragment()
        )
    }

/*private fun onClickRemove(album: Album) = findNavController().navigate(
    Directions.actionToFlowerDetailFragment(album.id))*/


/*private fun fabOnClick() {}
findNavController().navigate(
    FlowerListFragmentDirections.actionToAddFlowerFragment())
*/
}