package com.example.c57

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [settingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class settingFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)

        val idPreference = findPreference<EditTextPreference>("serverId")
        val soundPreference = findPreference<ListPreference>("sound_list")

        idPreference?.setOnPreferenceChangeListener { preference, newValue ->
            Toast.makeText(activity, "$newValue", Toast.LENGTH_SHORT).show()
            true
        }
        soundPreference!!.setSummaryProvider(ListPreference.SimpleSummaryProvider.getInstance())
        idPreference!!.summaryProvider =
            Preference.SummaryProvider<EditTextPreference>{ preference ->
                val text = preference.text
                if(TextUtils.isEmpty(text)){
                    "설정되지않았습니다."
                }else {
                    "설정된 id값은 $text 입니다."
                }
            }
    }

}