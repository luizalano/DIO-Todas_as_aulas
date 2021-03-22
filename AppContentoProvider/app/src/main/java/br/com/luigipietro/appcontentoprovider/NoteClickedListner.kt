package br.com.luigipietro.appcontentoprovider

import android.database.Cursor

interface NoteClickedListner {
    fun noteClickedItem(cursor: Cursor)
    fun noteRemoveItem(cursor: Cursor?)
}