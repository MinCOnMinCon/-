package com.example.c56

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat


class settingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
    }

}