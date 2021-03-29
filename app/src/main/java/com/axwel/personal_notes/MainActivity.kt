package com.axwel.personal_notes

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axwel.personal_notes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var orientation: GradientDrawable.Orientation
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager
                .beginTransaction()
                .replace(R.id.flNotesList, NoteListFragment.newInstance(), NoteListFragment.TAG)
                .commit()
        if (OrientationService(applicationContext).isLandscape()) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flNote, EditNoteFragment.newInstance(), EditNoteFragment.TAG)
                    .commit()
        }

    }
}