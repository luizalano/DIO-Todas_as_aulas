package br.com.luigipietro.appnotification

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MeuFirebaseMessagingService : FirebaseMessagingService() {
    private val tag = "tagFirebaseMService"
    override fun onMessageReceived(mensagemRemota: RemoteMessage) {
        Log.i(tag, mensagemRemota.from.toString())

        if (mensagemRemota.notification != null){
            this.mostraNotificacao("1234",
                mensagemRemota.notification?.title.toString(),
                mensagemRemota.notification?.body.toString())
        }
    }
}