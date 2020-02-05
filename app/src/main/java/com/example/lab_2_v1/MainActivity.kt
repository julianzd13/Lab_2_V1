package com.example.lab_2_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.myapplicationholav02.UTILS.Constantes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var e_mail : String = Constantes.EMPTY
    var pass : String = Constantes.EMPTY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dataflog = intent.extras
        e_mail = dataflog?.getString("Email").toString()
        pass = dataflog?.getString("Pass").toString()

        tv_main.text = e_mail
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_v1, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_0v1) {
            var intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("Email",e_mail)
            intent.putExtra("Pass", pass)
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }





}
