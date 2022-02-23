package com.example.jetpacknavigationcomponent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_question.*
import kotlinx.android.synthetic.main.fragment_result.*
import kotlin.random.Random

class QuestionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var score = 0
        var randNumber1 = Random.nextInt(1, 49).toString()
        var randNumber2 = Random.nextInt(50, 100).toString()
        txtAngka1.setText(randNumber1)
        txtAngka2.setText(randNumber2)

        if (arguments != null) {
            var playerName = QuestionFragmentArgs.fromBundle(requireArguments()).playerName
            txtDisplayPlayerName.text = "$playerName's Turn"
        }

        btnSubmit.setOnClickListener {
            val angka1 = txtAngka1.text.toString()
            val angka2 = txtAngka2.text.toString()
            val result = (angka1.toInt() + angka2.toInt()).toString()
            // Log.d(angka1, "checkangka1: ")
            // Log.d(angka2, "checkangka2: ")
            // Log.d(result, "checkresult: ")

            if (result == txtAnswer.text.toString()) {
                score += 1
                txtAnswer.text?.clear()
                // untuk ambil value rand number baru
                randNumber1 = Random.nextInt(1, 49).toString()
                randNumber2 = Random.nextInt(50, 100).toString()
                txtAngka1.setText(randNumber1)
                txtAngka2.setText(randNumber2)
                // Log.d(score.toString(), "checkscore:")
            } else {
                val action = QuestionFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}