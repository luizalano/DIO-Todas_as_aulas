package com.everis.listadecontatos.helpers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.everis.listadecontatos.feature.listacontatos.model.ContatosVO

class HelperDB(
    context: Context
) : SQLiteOpenHelper(context, NOME_BANCO, null, VERSAO_ATUAL) {

    companion object {
        private val NOME_BANCO = "contato.db"
        private val VERSAO_ATUAL = 1
    }

    val TABLE_NAME = "contato"
    val COLUMNS_ID = "id"
    val COLUMNS_NOME = "nome"
    val COLUMNS_TELEFONE = "telefone"
    val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    val CREATE_TABLE = "CREATE TABLE $TABLE_NAME (" +
            "$COLUMNS_ID INTEGER NOT NULL," +
            "$COLUMNS_NOME TEXT NOT NULL," +
            "$COLUMNS_TELEFONE TEXT NOT NULL," +
            "" +
            "PRIMARY KEY($COLUMNS_ID AUTOINCREMENT)" +
            ")"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if(oldVersion != newVersion) {
            db?.execSQL(DROP_TABLE)
        }
        onCreate(db)
    }

    fun contatoDuplicado(nome: String, telefone:String): Boolean{
        val db = readableDatabase
        //val clausulaSql = "select count(*) as CONTADOR from $TABLE_NAME where $COLUMNS_NOME = '$nome' and $COLUMNS_TELEFONE = '$telefone'"
        //var cursor = db.rawQuery(clausulaSql, arrayOf())

        val clausulaSql = "select count(*) as CONTADOR from $TABLE_NAME where $COLUMNS_NOME = ? and $COLUMNS_TELEFONE = ?"
        val args = arrayOf(nome, telefone)
        var cursor = db.rawQuery(clausulaSql, args)

        var retorno = false
        if (cursor.moveToNext()){
            val q = cursor.getInt(cursor.getColumnIndex("CONTADOR"))
            if (q > 0) retorno = true
        }

        return retorno
    }

    fun temContatoDuplicado(nome: String, telefone:String): Boolean{
        val db = readableDatabase // ?: return mutableListOf()
        var lista = mutableListOf<ContatosVO>()
        var where = "$COLUMNS_NOME = ? and $COLUMNS_TELEFONE = ?"
        val args = arrayOf("$nome", "$telefone")

        var cursor = db.query(TABLE_NAME,null,where, args,null,null,null)

        if (cursor.count >0){
            db.close()
            return true
        }

        db.close()
        return false
    }

    fun buscarContatos(busca: String, isBuscaPorID: Boolean = false) : List<ContatosVO> {
        val db = readableDatabase ?: return mutableListOf()
        var lista = mutableListOf<ContatosVO>()
        var where: String? = null
        var args: Array<String> = arrayOf()
        if(isBuscaPorID){
            where = "$COLUMNS_ID = ?"
            args = arrayOf("$busca")
        }else{
            where = "$COLUMNS_NOME LIKE ?"
            args = arrayOf("%$busca%")
        }
        var cursor = db.query(TABLE_NAME,null,where, args,null,null,null)
        //cursor = db.rawQuery(clausulaSql, arrayOf())
        if (cursor == null){
            db.close()
            return mutableListOf()
        }
        while(cursor.moveToNext()){
            var contato = ContatosVO(
                cursor.getInt(cursor.getColumnIndex(COLUMNS_ID)),
                cursor.getString(cursor.getColumnIndex(COLUMNS_NOME)),
                cursor.getString(cursor.getColumnIndex(COLUMNS_TELEFONE))
            )
            lista.add(contato)
        }
        db.close()
        return lista
    }

    fun salvarContato(contato: ContatosVO) {
        if (!contatoDuplicado(contato.nome, contato.telefone)){
            val db = writableDatabase ?: return
            var content = ContentValues()
            content.put(COLUMNS_NOME,contato.nome)
            content.put(COLUMNS_TELEFONE,contato.telefone)
            db.insert(TABLE_NAME,null,content)
            db.close()
        }
    }

    fun deletarCoontato(id: Int) {
        val db = writableDatabase ?: return
        val sql = "DELETE FROM $TABLE_NAME WHERE $COLUMNS_ID = ?"
        val arg = arrayOf("$id")
        db.execSQL(sql,arg)
        db.close()
    }

    fun updateContato(contato: ContatosVO) {
        val db = writableDatabase ?: return
        val sql = "UPDATE $TABLE_NAME SET $COLUMNS_NOME = ?, $COLUMNS_TELEFONE = ? WHERE $COLUMNS_ID = ?"
        val arg = arrayOf(contato.nome,contato.telefone,contato.id)
        db.execSQL(sql,arg)
        db.close()
    }
}