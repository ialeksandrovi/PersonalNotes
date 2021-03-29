package com.axwel.personal_notes

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.axwel.personal_notes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NoteDetailsNavigator {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        binding.flNote?.visibility = if (OrientationService(applicationContext).isLandscape()) {
            View.INVISIBLE
        } else {
            View.GONE
        }
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.flNotesList, NoteListFragment.newInstance(), NoteListFragment.TAG)
                .commit()

        if (OrientationService(applicationContext).isLandscape()) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flNotesList, NoteListFragment.newInstance(), NoteListFragment.TAG)
                    .commit()
        } else {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flNotesList, NoteListFragment.newInstance(), NoteListFragment.TAG)
                    .addToBackStack(NoteListFragment.TAG)
                    .commit()
        }

        setContentView(binding.root)
    }

    override fun navigateToDetails(guid: String) {
        if (OrientationService(applicationContext).isLandscape()) {
            binding.flNote?.visibility = View.VISIBLE
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flNote, EditNoteFragment.newInstance(), EditNoteFragment.TAG)
                    .commit()
        } else {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flNotesList, EditNoteFragment.newInstance(), EditNoteFragment.TAG)
                    .addToBackStack(EditNoteFragment.TAG)
                    .commit()
        }
    }
}