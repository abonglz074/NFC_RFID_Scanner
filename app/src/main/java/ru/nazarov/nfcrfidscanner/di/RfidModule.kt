package ru.nazarov.nfcrfidscanner.di

import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.nazarov.nfcrfidscanner.data.NfcRepositoryImpl
import ru.nazarov.nfcrfidscanner.data.NfcSource
import ru.nazarov.nfcrfidscanner.domain.GetNfcTagUseCase
import ru.nazarov.nfcrfidscanner.domain.NfcRepository
import ru.nazarov.nfcrfidscanner.ui.MainViewModel

val diModule = module {
    single<NfcRepository> { NfcRepositoryImpl(get()) }
    single { NfcSource(androidContext()) }
    viewModel { MainViewModel(get()) }
    single { GetNfcTagUseCase(get()) }
}