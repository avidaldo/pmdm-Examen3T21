package com.example.examen3t21

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examen3t21.placeholder.*

class DiscosViewModel() : ViewModel() {

    val generoLiveData = MutableLiveData<Album.Genero>()
    val albumsLiveData = MutableLiveData<MutableList<Album>>()
    val albumSeleccionadoLiveData = MutableLiveData<Album>()

    fun updateAlbumSeleccionadoLiveData(album: Album) {
        albumSeleccionadoLiveData.value = album
    }


    fun updateAlbumsLiveData(list: MutableList<Album>) {
        albumsLiveData.value = list
    }

    fun updateGeneroLiveData(genero : Album.Genero){
        generoLiveData.value = genero
        updateAlbumsLiveData(dataSource.getlistaFromGenero(genero))
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
        dataSource.getlistaFromGenero(generoLiveData.value!!)
            .apply {
                remove(album)
            }
            .let {
                updateAlbumsLiveData(it)
            }


}


