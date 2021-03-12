package com.everis.listadecontatos.application

import android.app.Application
import com.everis.listadecontatos.helpers.HelperDB

class ContatoApplication : Application() {

    var helperDB: HelperDB? = null
        private set
    /* com private set. a propriedade fica protejida contra set's externos
    *  como se fosse privada */

    companion object {
        lateinit var instance: ContatoApplication
    }
    // companion object para transformar a classe em um objeto singleton

    override fun onCreate() {
        super.onCreate()
        instance = this
        helperDB = HelperDB(this)
    }
}