package br.com.luigipietro.appcontentoprovider

import android.app.Activity
import android.app.Dialog
import android.content.ContentValues
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.database.getStringOrNull
import androidx.fragment.app.DialogFragment
import br.com.luigipietro.appcontentoprovider.database.NotesDatabaseHelper.Companion.DESCRIPTION_NOTES
import br.com.luigipietro.appcontentoprovider.database.NotesDatabaseHelper.Companion.TITLE_NOTES
import br.com.luigipietro.appcontentoprovider.database.NotesProvider.Companion.URI_NOTES

class NotesDetailFragment: DialogFragment(), DialogInterface.OnClickListener {

    private lateinit var noteEditTitle: EditText
    private lateinit var noteEditdescription: EditText
    private var id: Long = 0

    companion object {
        private const val EXTRA_ID = "id"

        fun newInstance(id: Long) : NotesDetailFragment {
            /*
            Bundle() tem o id da coleção da activity
             */
            val bundle = Bundle()
            val notesFragment = NotesDetailFragment()

            bundle.putLong(EXTRA_ID, id)
            notesFragment.arguments = bundle

            return notesFragment
        }
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view: View? = activity?.layoutInflater?.inflate(R.layout.note_detail, null)

        noteEditTitle = view?.findViewById(R.id.note_edt_title) as EditText
        noteEditdescription = view.findViewById(R.id.note_edt_description) as EditText

        var newNote = true

        if (arguments != null && arguments?.getLong(EXTRA_ID) != 0L) {
            id = arguments?.getLong(EXTRA_ID) as Long
            val uri = Uri.withAppendedPath(URI_NOTES, id.toString())
            val cursor = activity?.contentResolver?.query(uri, null, null, null, null)
            if (cursor?.moveToNext() as Boolean) {
                newNote = false
                noteEditTitle.setText(cursor.getString(cursor.getColumnIndex(TITLE_NOTES)))
                noteEditdescription.setText(cursor.getString(cursor.getColumnIndex(DESCRIPTION_NOTES)))
            }
            cursor.close()
        }
        return AlertDialog.Builder(activity as Activity)
                .setTitle( if (newNote) "Nova mensagem" else "Editar mensagem")
                .setView(view)
                .setPositiveButton("Salvar", this)
                .setNegativeButton("Cancelar", this)
                .create()
    }

    override fun onClick(dialog: DialogInterface?, which: Int) {
        val values = ContentValues()
        values.put(TITLE_NOTES, noteEditTitle.text.toString())
        values.put(DESCRIPTION_NOTES, noteEditdescription.text.toString())

        if (id != 0L){
            val uri = Uri.withAppendedPath(URI_NOTES, id.toString())
            context?.contentResolver?.update(uri, values, null, null)
        } else {
            context?.contentResolver?.insert(URI_NOTES, values)
        }
    }
}