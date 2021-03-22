package br.com.luigipietro.appcontentoprovider

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.luigipietro.appcontentoprovider.database.NotesDatabaseHelper.Companion.TITLE_NOTES
import br.com.luigipietro.appcontentoprovider.database.NotesProvider.Companion.URI_NOTES
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<Cursor> {
    lateinit var noteRecyclerView: RecyclerView
    lateinit var noteAdd: FloatingActionButton
    lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteAdd = findViewById(R.id.note_add)
        noteAdd.setOnClickListener {  }
        adapter = NotesAdapter()
        adapter.setHasStableIds(true)
        noteRecyclerView = findViewById(R.id.notes_recycler)
        noteRecyclerView.layoutManager = LinearLayoutManager(this)
        noteRecyclerView.adapter = adapter
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
        CursorLoader(this, URI_NOTES, null, null, null, TITLE_NOTES)
    }

    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {

    }

    override fun onLoaderReset(loader: Loader<Cursor>) {
        TODO("Not yet implemented")
    }
}