package br.com.luigipietro.contatosii

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contato(
        var nome: String,
        var telefone: String,
        var imagem: String
): Parcelable
