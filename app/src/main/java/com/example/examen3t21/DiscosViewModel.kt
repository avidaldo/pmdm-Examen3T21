package com.example.examen3t21

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examen3t21.placeholder.*

class DiscosViewModel() : ViewModel() {

    val albumsLiveData = MutableLiveData<MutableList<Album>>()
    val albumSeleccionadoLiveData = MutableLiveData<Album>()

    fun updateAlbumSeleccionadoLiveData(album: Album) {
        albumSeleccionadoLiveData.value = album
    }

    fun updateAlbumsLiveData(list: MutableList<Album>) {
        albumsLiveData.value = list
    }

    fun updateAlbumsLiveData(genero: Album.Genero?) {
        updateAlbumsLiveData(genero?.let { dataSource.getlistaFromGenero(it) }
            ?: dataSource.getAll())
    }

    fun addAlbum(titulo: String, autor: String, image: Int?, description: Int) {
        dataSource.getlistaFromGenero(generoLiveData.value!!)
            .apply {
                add(newAlbumIndexing(titulo, autor, image, description))
            }
            .let {
                updateAlbumsLiveData(it)
            }
    }

    fun removeAlbum(album: Album) =
        dataSource.removeAlbum(album)
            .let {
                updateAlbumsLiveData(it)
            }


}


