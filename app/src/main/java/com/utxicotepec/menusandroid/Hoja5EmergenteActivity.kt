package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja5EmergenteActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja5_emergente)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
        val btnEmergente = findViewById<Button>(R.id.btnEmergente)
        btnEmergente.setOnClickListener { vista ->
            mostrarPopup(vista)
        }
    }

    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate
    private fun mostrarPopup(v: View) {
        val popup = PopupMenu(this, v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.menu_hoja5, popup.menu)
        popup.setOnMenuItemClickListener(this)
        popup.show()
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.opcion_1 -> {
                txtResultado.text = getString(R.string.msg_seleccionaste, getString(R.string.h5_reportar))
                true
            }
            R.id.opcion_2 -> {
                txtResultado.text = getString(R.string.msg_seleccionaste, getString(R.string.h5_silenciar))
                true
            }
            R.id.opcion_3 -> {
                txtResultado.text = getString(R.string.msg_seleccionaste, getString(R.string.h5_importante))
                true
            }
            else -> false
        }
    }
}
