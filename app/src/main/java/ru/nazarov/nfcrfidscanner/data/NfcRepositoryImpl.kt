package ru.nazarov.nfcrfidscanner.data

import android.content.Intent
import ru.nazarov.nfcrfidscanner.domain.NfcRepository

class NfcRepositoryImpl(private val nfcSource: NfcSource) : NfcRepository {
    override fun getTagIdFromIntent(intent: Intent): String? {
        return nfcSource.getTagIdFromIntent(intent)
    }
}