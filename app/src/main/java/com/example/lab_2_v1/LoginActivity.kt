package com.example.lab_2_v1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplicationholav02.UTILS.Constantes
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var e_mail_sign : String = Constantes.EMPTY
    var pass_sign : String = Constantes.EMPTY

    var e_mail_main : String = Constantes.EMPTY
    var pass_main : String = Constantes.EMPTY


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var datafmain = intent.extras

        if (datafmain != null) {
            e_mail_main = datafmain?.getString("Email").toString()
            pass_main = datafmain?.getString("Pass").toString()

            et_log_email.setText(e_mail_main)
        }

        bt_sign1.setOnClickListener {

            var intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent, 1112)

        }

        bt_login.setOnClickListener {

            var e_mail_log = et_log_email.text.toString()
            var pass_log : String = et_log_pass.text.toString()


            if (e_mail_log == e_mail_sign && pass_log == pass_sign && e_mail_log.isNotEmpty() && pass_log.isNotEmpty()){
                intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Email",e_mail_log)
                intent.putExtra("Pass", pass_log)
                startActivity(intent)
                //et_log_pass.setText(Constantes.EMPTY)
                finish()
            }else if (e_mail_log == e_mail_main && pass_log == pass_main && e_mail_log.isNotEmpty() && pass_log.isNotEmpty()){
                intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Email",e_mail_log)
                intent.putExtra("Pass", pass_log)
                startActivity(intent)
                //et_log_pass.setText(Constantes.EMPTY)
                finish()
            }else if (e_mail_log.isEmpty() || e_mail_sign.isNotEmpty() && e_mail_log != e_mail_sign || e_mail_main.isNotEmpty() && e_mail_log != e_mail_main){
                Toast.makeText(this, "error E-Mail", Toast.LENGTH_SHORT).show()
                et_log_pass.setText(Constantes.EMPTY)
            }else if (pass_log.isEmpty() || pass_sign.isNotEmpty() && pass_log != pass_sign || pass_main.isNotEmpty() && pass_main != pass_log){
                Toast.makeText(this, "error PASSWORD", Toast.LENGTH_SHORT).show()
                et_log_pass.setText(Constantes.EMPTY)
            }else Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()

        }



    }


    /*override fun onStart() {
        bt_login.setOnClickListener {

            var e_mail_log = et_log_email.text.toString()
            var pass_log : String = et_log_pass.text.toString()


            if (e_mail_log == e_mail_sign && pass_log == pass_sign && e_mail_log.isNotEmpty() && pass_log.isNotEmpty()){
                intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Email",e_mail_log)
                intent.putExtra("Pass", pass_log)
                startActivity(intent)
                //et_log_pass.setText(Constantes.EMPTY)
                finish()
            }else{
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                et_log_pass.setText(Constantes.EMPTY)
            }

        }

        super.onStart()
    }*/


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1112 && resultCode == Activity.RESULT_CANCELED){
            Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show()
        }
        if (requestCode == 1112 && resultCode == Activity.RESULT_OK){

            Toast.makeText(this, getText(R.string.ok_sign), Toast.LENGTH_SHORT).show()

            var datafsign = data?.extras
            e_mail_sign = datafsign?.getString("Email").toString()
            pass_sign = datafsign?.getString("Pass").toString()

            Log.d("oooe", e_mail_sign)
            Log.d("oooe", pass_sign)

        }

        /*bt_login.setOnClickListener {

            var e_mail_log = et_log_email.text.toString()
            var pass_log = et_log_pass.text.toString()

            if (e_mail_log == e_mail_sign && pass_log == pass_sign && e_mail_log.isNotEmpty() && pass_log.isNotEmpty()){
                intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Email",e_mail_log)
                startActivity(intent)
            }
        }*/

        super.onActivityResult(requestCode, resultCode, data)
    }

}
