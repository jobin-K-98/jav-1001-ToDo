package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    // declaring views and array list
    private lateinit var editText: EditText
    private lateinit var addButton: Button
    private lateinit var listView: ListView
    private lateinit var items: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializing the views and array list
        editText = findViewById(R.id.editText)
        addButton = findViewById(R.id.button)
        listView = findViewById(R.id.list_view)
        items = ArrayList()

        // we have decided to use adapter to connect the data source to the list view
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        //setting the adapter to the list view
        listView.adapter = adapter

        // setting on-click listener for the button
        addButton.setOnClickListener {
            val newItem = editText.text.toString()
            if (newItem.isNotEmpty()) {
                items.add(newItem)
                adapter.notifyDataSetChanged()// this notifies the adapter of data change
                editText.text.clear()// clears the input field
            }
        }

        // setting on-click listener for list items
        listView.setOnItemClickListener { _, view, position, _ ->
            val isChecked = (view as CheckedTextView).isChecked
            listView.setItemChecked(position, !isChecked)
        }
    }
}

