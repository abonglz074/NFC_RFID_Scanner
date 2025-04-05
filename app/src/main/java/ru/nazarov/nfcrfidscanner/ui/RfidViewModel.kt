package ru.nazarov.nfcrfidscanner.ui

import android.content.Intent
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.nazarov.nfcrfidscanner.domain.GetNfcTagUseCase

class MainViewModel(private val getNfcTagUseCase: GetNfcTagUseCase) : ViewModel() {

    private val _tagId = MutableStateFlow<String?>(null)
    val tagId: StateFlow<String?> = _tagId

    fun onNewIntent(intent: Intent) {
        val tagId = getNfcTagUseCase(intent)
        _tagId.value = tagId
    }
}