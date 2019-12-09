package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var premiumModel: PremiumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        premiumModel = ViewModelProviders.of(this).get(PremiumModel::class.java)

        btnCalculate.setOnClickListener {

            val age = spinAge.selectedItemPosition
            var premium = 0.00

            if (age == 0) {
                premium = 60.00
            } else if (age == 1) {
                premium = 70.00
                if (rbtnMale.isChecked) {
                    premium += 50.00
                }
                if (cbSmoker.isChecked) {
                    premium += 100.00
                }
            } else if (age == 2) {
                premium = 90.00
                if (rbtnMale.isChecked) {
                    premium += 100.00
                }
                if (cbSmoker.isChecked) {
                    premium += 150.00
                }
            } else if (age == 3) {
                premium = 120.00
                if (rbtnMale.isChecked) {
                    premium += 150.00
                }
                if (cbSmoker.isChecked) {
                    premium += 200.00
                }
            } else if (age == 4) {
                premium = 150.00
                if (rbtnMale.isChecked) {
                    premium += 200.00
                }
                if (cbSmoker.isChecked) {
                    premium += 250.00
                }
            } else if (age == 5) {
                premium = 150.00
                if (rbtnMale.isChecked) {
                    premium += 200.00
                }
                if (cbSmoker.isChecked) {
                    premium += 300.00
                }
            }
            lblPremium.text = "RM %.2f".format(premium)
            premiumModel.premium = premium
        }

        btnReset.setOnClickListener {
            spinAge.setSelection(0)
            rgGender.clearCheck()
            cbSmoker.isChecked = false
            lblPremium.text = "RM 0.00"
        }

        lblPremium.text = "RM " + premiumModel.premium.toString()

    }
}
