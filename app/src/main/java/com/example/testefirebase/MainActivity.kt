package com.example.testefirebase

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.testefirebase.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        //val firestore = Firebase.firestore -> versão mais recente
        val firestore = FirebaseFirestore.getInstance() // versão mais antiga do AS

        val Aluno = hashMapOf(
            "nome" to "Matheus Lopes",
            "nota" to 7.56,
            "Faltas" to 4
        )

        firestore.collection("Aluno").add(Aluno).addOnSuccessListener {
                Toast.makeText(this,"inserido com sucesso", Toast.LENGTH_SHORT).show()
            }

            .addOnFailureListener {
                Toast.makeText(this,"falha ao inserir", Toast.LENGTH_SHORT).show()
            }


    }
}