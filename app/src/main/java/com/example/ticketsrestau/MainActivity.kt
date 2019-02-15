package com.example.ticketsrestau

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcRest(view: View) {
        var price = input_price.text.toString().toFloatOrNull()
        var tickets = input_tickets.text.toString().toFloatOrNull()

        if (price != null && tickets != null) {

            if (price is Float && tickets is Float) {
                val rest = price.rem(tickets)
                val restToPay = "%.2f".format(rest)
                val nbTickets = price.div(tickets).toInt()
                text_data.setText("N° ticket: $nbTickets\nRest to pay: $restToPay €")

            }
        } else {
            Toast.makeText(applicationContext, "You must input valid numbers", Toast.LENGTH_SHORT).show()
        }

    }

}
