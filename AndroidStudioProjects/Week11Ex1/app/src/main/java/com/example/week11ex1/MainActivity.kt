package com.example.week11ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val EditName = findViewById<EditText>(R.id.name)
        val EditEmail = findViewById<EditText>(R.id.email)
        val EditAge = findViewById<EditText>(R.id.age)

        readBtn.setOnClickListener{
            readFirebase()
        }

        writeBtn.setOnClickListener{
            var Name : String
            var Email: String
            var Age : Int

            if(EditName.length()==0) Name = "null" else Name = EditName.text.toString()
            if(EditEmail.length()==0) Email = "null" else Email = EditEmail.text.toString()
            if(EditAge.length()==0) Age = 0 else Age = EditAge.text.toString().toInt()

            writeFirebase(Name, Email, Age)

        }

    }
    fun readFirebase()
    {
        db.collection("user")
                .get()
                .addOnSuccessListener {
                    result -> for (document in result)
                        output1.append("${document.data}\n")
                }
    }
    fun writeFirebase(Name: String, Email:String,Age:Int)
    {
        val user = mapOf(
                "name" to Name,
                "email" to Email,
                "age" to Age
        )
        val colRef: CollectionReference = db.collection("users")
        val docRef: Task<DocumentReference> = colRef.add(user)
        docRef.addOnSuccessListener{
            documentReference -> output1.append("Success : " + "${documentReference.id}\n")
        }
        docRef.addOnFailureListener{
            output1.append("Failure \n")
        }

    }
}