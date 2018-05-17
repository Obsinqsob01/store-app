package me.luisguerra495.store

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.product.view.*
import java.net.URI

class MainActivity : AppCompatActivity() {
    var listProducts = ArrayList<Producto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (1..15).map {
            listProducts.add(Producto(it, "Producto $it", "Description $it", it * 123f))
        }

        var productsAdapter = ProductAdapter(listProducts)
        listaProducts.adapter = productsAdapter

    }

    inner class ProductAdapter : BaseAdapter {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                var myView = layoutInflater.inflate(R.layout.product, null)
                var product = listProductAdapter[position]

                myView.txtNombre.text = product.nombre
//                Glide.with(myView).load(product.imagen).into(myView.productImagen)

                myView.btnEdit.setOnClickListener {
                    var intent = Intent(getApplicationContext(), ProductActivity::class.java)
                    intent.putExtra("note", note)
                    startActivity(intent)
                }

                return myView

        }

        override fun getItem(position: Int): Any {
            return listProductAdapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listProductAdapter.size
        }

        var listProductAdapter = ArrayList<Producto>()

        constructor(listProducts: ArrayList<Producto>): super(){
            this.listProductAdapter = listProducts
        }
    }
}
