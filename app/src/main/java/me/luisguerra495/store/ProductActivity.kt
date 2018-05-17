package me.luisguerra495.store

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
//import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.content_product.*
import kotlinx.android.synthetic.main.product.view.*
import android.graphics.BitmapFactory
import android.net.Uri
import java.io.InputStream


class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        setSupportActionBar(toolbar)

        val product = getIntent().getExtras().getSerializable("product") as? Producto

        toolbar_layout.title = product!!.nombre
        txtProductDescription.text = product.desc

        textPrice.text = " \$${product.precio.toString()}"
    }
}
