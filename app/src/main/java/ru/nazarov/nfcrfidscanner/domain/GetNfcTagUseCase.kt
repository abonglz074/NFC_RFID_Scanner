package ru.nazarov.nfcrfidscanner.domain

import android.content.Intent

class GetNfcTagUseCase(private val repository: NfcRepository) {
    operator fun invoke(intent: Intent): String? {
        return repository.getTagIdFromIntent(intent)
    }
}