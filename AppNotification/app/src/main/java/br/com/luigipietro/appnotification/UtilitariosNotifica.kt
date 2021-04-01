package br.com.luigipietro.appnotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat

lateinit var canalNotificacao: NotificationChannel
lateinit var gerenteNotificacao: NotificationManager
lateinit var builderNotificacao: NotificationCompat.Builder

fun Context.mostraNotificacao(idCanal: String, titulo:String, mensagem: String){
    gerenteNotificacao = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val intent = Intent(this, MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
        canalNotificacao = NotificationChannel(idCanal, mensagem, NotificationManager.IMPORTANCE_HIGH).apply {
            lightColor = Color.BLUE
            enableVibration(true)
        }

        gerenteNotificacao.createNotificationChannel(canalNotificacao)
        builderNotificacao = NotificationCompat.Builder(this, idCanal).apply {
            setSmallIcon(R.drawable.refresh_verde_limao)
            setContentTitle(titulo)
            setContentText(mensagem)
            setAutoCancel(true)
            setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
            setContentIntent(pendingIntent)
        }
    }
    gerenteNotificacao.notify(idCanal.toInt(), builderNotificacao.build())
}