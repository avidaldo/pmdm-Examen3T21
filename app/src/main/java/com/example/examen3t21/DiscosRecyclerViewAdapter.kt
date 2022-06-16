package com.example.examen3t21

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.examen3t21.databinding.ItemBinding


class DiscosRecyclerViewAdapter(
    val onClickInfo: (Album) -> Unit
) : ListAdapter<Album, DiscosRecyclerViewAdapter.ViewHolder>(DiscoDiffCallback) {


    /** Clase que describe la vista de cada elemento de la lista y su posición en esta. */
    class ViewHolder(
        binding: ItemBinding,
        val onClickInfo: (Album) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        val tvtitulo = binding.tvtitulo
        val tvautor = binding.tvautor
        val imagenAlbum = binding.imageView

        private var currentAlbum: Album? = null

        init {
            binding.root.setOnClickListener { onClickInfo(currentAlbum!!) }
        }

        fun bind(album: Album) {
            currentAlbum = album
            tvtitulo.text = album.titulo
            tvautor.text = album.autor
            imagenAlbum.setImageResource(album.imageRes ?: IMAGE_NO_AVALIABLE_RESOURCE)
        }
    }


    /* Creates and inflates view and return FlowerViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClickInfo
    )

    /* Gets current flower and uses it to bind view. */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

object DiscoDiffCallback : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.titulo == newItem.titulo
    }
}
