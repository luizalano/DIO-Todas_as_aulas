package br.com.luigipietro.appnotification

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

class MeuFirebaseInstanceidService : FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
        Log.i("**********new token", FirebaseInstanceId.getInstance().toString())
    }
}