package com.example.examen3t21.placeholder

import com.example.examen3t21.R

class Album(val titulo: String, val autor: String, val imageRes: Int, val descRes: Int) {
    enum class Genero {
        Rock, Blues, Jazz
    }

    override fun toString(): String {
        return "$titulo - $autor"
    }

}



fun getListadoRock() = mutableListOf(
    Album( "Abbey Road", "The Beatles", R.drawable.abbeyroad, R.string.abbeyroad),
    Album("Exile on Main Street", "The Rolling Stones", R.drawable.exileonmainst, R.string.exilesonmainstreet),
    Album("The Velvet Underground", "The Velvet Underground and Nico", R.drawable.velvetunderground, R.string.velvetunderground),
    Album("Are You Experienced", "Jimi Hendrix", R.drawable.areyouexperienced, R.string.areyouexperienced),
    Album("Back in Black", "AC/DC", R.drawable.backinblack, R.string.backinblack),
    Album("Appetite for Destruction", "Guns N’ Roses", R.drawable.appetitefordestruction, R.string.appetitefordestruction),
    Album("Led Zeppelin IV", "Led Zeppelin", R.drawable.ledzeppeliniv, R.string.ledzeppeliniv)
)

fun getListadoBlues() = mutableListOf(
    Album("Lady Soul", "Aretha Franklin", R.drawable.ladysoul, R.string.ladysoul),
    Album("I Never Loved a Man the Way I Love You", "Aretha Franklin", R.drawable.neverloved, R.string.ineverloveda),
    Album("What's Going On", "Marvin Gaye", R.drawable.whatsgoingon, R.string.whatsgoingon)
)

fun getListadoJazz() = mutableListOf(
    Album("Kind of Blue", "Miles Davis", R.drawable.kindofblue, R.string.kindofblue),
    Album("Bitches Brew", "Miles Davis", R.drawable.bitchesbrew, R.string.bitchesbrew),
    Album("A Love Supreme", "John Coltrane", R.drawable.alovesupreme, R.string.alovesupreme)
)
