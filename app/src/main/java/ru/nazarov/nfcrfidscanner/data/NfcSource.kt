package ru.nazarov.nfcrfidscanner.data

import android.app.Activity
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.nfc.NfcAdapter
import android.nfc.Tag

class NfcSource(private val context: Context) {

    private var nfcAdapter: NfcAdapter? = null

    init {
        nfcAdapter = NfcAdapter.getDefaultAdapter(context)
        if (nfcAdapter == null) {
            throw UnsupportedOperationException("NFC не поддерживается")
        }
    }

    fun enableForegroundDispatch(activity: Activity) {
        val pendingIntent = PendingIntent.getActivity(
            activity,
            0,
            Intent(activity, activity.javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP),
            PendingIntent.FLAG_MUTABLE
        )
        nfcAdapter?.enableForegroundDispatch(activity, pendingIntent, null, null)
    }

    fun disableForegroundDispatch(activity: Activity) {
        nfcAdapter?.disableForegroundDispatch(activity)
    }

    fun getTagIdFromIntent(intent: Intent): String? {
        return intent.getParcelableExtra<Tag>(NfcAdapter.EXTRA_TAG)?.id?.toHexString()
    }

    private fun ByteArray.toHexString(): String = joinToString("") { "%02X".format(it) }
}