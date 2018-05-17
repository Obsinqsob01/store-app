package me.luisguerra495.store

import java.io.Serializable

data class Producto(val id:Int, var nombre:String, var desc:String, var precio:Float) : Serializable