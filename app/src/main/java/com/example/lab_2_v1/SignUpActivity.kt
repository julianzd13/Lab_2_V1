package com.example.lab_2_v1

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import com.example.myapplicationholav02.UTILS.Constantes
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.text.SimpleDateFormat
import java.util.*

class SignUpActivity : AppCompatActivity() {


        private var cal = Calendar.getInstance()
        private var date : String = Constantes.EMPTY


     override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_sign_up)


            var gender = getString(R.string.male)

            val adapter = ArrayAdapter.createFromResource(this, R.array.city_list,
                android.R.layout.simple_spinner_item)

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sp_city.adapter = adapter

            rb_male.setOnClickListener {
                gender = getString(R.string.male)
            }


            rb_female.setOnClickListener {
                gender = getString(R.string.female)
            }


             val dataSetListener = object : DatePickerDialog.OnDateSetListener{
                    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                        cal.set(Calendar.YEAR, year)
                        cal.set(Calendar.MONTH, month)
                        cal.set(Calendar.DAY_OF_YEAR, dayOfMonth)

                        val format = "MM/dd/yyyy"
                        val sdf = SimpleDateFormat(format, Locale.US)
                        date = sdf.format(cal.time).toString()

                    }

             }

            bt_date_of_birth.setOnClickListener {
                DatePickerDialog(
                    this,
                    dataSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }


            bt_save.setOnClickListener {
                val name = et_user_name.text.toString()
                val e_mail = et_user_email.text.toString()
                val phon = et_user_phon.text.toString()
                val pass = et_user_pass.text.toString()
                val repass = et_user_rpass.text.toString()
                val city = sp_city.selectedItem.toString()
                var hobbies = Constantes.EMPTY

                if (cb_movies.isChecked) hobbies = hobbies + Constantes.SPACE + getString(R.string.movies)
                if (cb_gym.isChecked) hobbies = hobbies + Constantes.SPACE + getString(R.string.gym)
                if (cb_read.isChecked) hobbies = hobbies + Constantes.SPACE + getString(R.string.read)
                if (cb_shopping.isChecked) hobbies = hobbies + Constantes.SPACE + getString(R.string.shopping)


                if (name.isEmpty() || e_mail.isEmpty() || phon.isEmpty() || pass.isEmpty() || repass.isEmpty() ||
                    city.isEmpty() || date == Constantes.EMPTY)
                {
                    Toast.makeText(this, getText(R.string.error_login), Toast.LENGTH_SHORT).show()
                }else if (pass.length >= 6){
                    if (pass != repass)
                    {
                        Toast.makeText(this, getText(R.string.error_pass), Toast.LENGTH_SHORT).show()
                    }
                    if (pass == repass)
                    {
                        //Toast.makeText(this, getText(R.string.ok_sign), Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, LoginActivity::class.java)
                        intent.putExtra("Email",e_mail)
                        intent.putExtra("Pass",pass)
                        setResult(Activity.RESULT_OK, intent)
                        finish()
                    }
                }else if (pass.length < 6){
                    Toast.makeText(this, getText(R.string.error_pass1), Toast.LENGTH_SHORT).show()
                }

            }



     }




    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
        super.onBackPressed()
    }

    }
