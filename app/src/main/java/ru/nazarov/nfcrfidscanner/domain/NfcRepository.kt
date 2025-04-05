package ru.nazarov.nfcrfidscanner.domain

import android.content.Intent

interface NfcRepository {
    fun getTagIdFromIntent(intent: Intent): String?
}