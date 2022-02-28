package dev.ogabek.androiddatabase.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import dev.ogabek.androiddatabase.R
import dev.ogabek.androiddatabase.manager.RealmManager
import dev.ogabek.androiddatabase.model.Post

class MainActivity : AppCompatActivity() {

    private lateinit var btn_save: Button
    private lateinit var tv_text: TextView
    private lateinit var et_text: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        btn_save = findViewById(R.id.btn_save)
        tv_text = findViewById(R.id.tv_text)
        et_text = findViewById(R.id.et_text)

        btn_save.setOnClickListener {
            if (et_text.text.isNotEmpty()) {
                RealmManager.instance!!.savePost(Post(RealmManager.instance!!.loadPosts().size.toLong(), et_text.text.toString()))
            }
            val posts = RealmManager.instance!!.loadPosts()
            tv_text.text = posts.size.toString()
        }
    }
}