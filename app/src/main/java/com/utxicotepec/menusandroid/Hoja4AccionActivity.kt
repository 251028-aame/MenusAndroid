package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja4AccionActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    private var actionMode: ActionMode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja4_accion)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        txtResultado.setOnLongClickListener { view ->
            if (actionMode == null) {
                actionMode = startActionMode(actionModeCallback)
                view.isSelected = true
                true
            } else {
                false
            }
        }
    }

    private val actionModeCallback = object : ActionMode.Callback {

        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            val inflater = mode.menuInflater
            inflater.inflate(R.menu.menu_hoja4, menu)
            mode.title = getString(R.string.h4_titulo_accion)
            mode.subtitle = getString(R.string.h4_subtitulo_accion)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.menu_compartir -> {
                    txtResultado.text = getString(R.string.msg_accion_barra, getString(R.string.h4_compartir))
                    mode.finish()
                    true
                }
                R.id.menu_archivar -> {
                    txtResultado.text = getString(R.string.msg_accion_barra, getString(R.string.h4_archivar))
                    mode.finish()
                    true
                }
                R.id.menu_eliminar -> {
                    txtResultado.text = getString(R.string.msg_accion_barra, getString(R.string.h4_eliminar))
                    mode.finish()
                    true
                }
                else -> false
            }
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            actionMode = null
        }
    }
}