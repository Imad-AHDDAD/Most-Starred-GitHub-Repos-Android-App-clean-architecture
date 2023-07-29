package com.a7dev.moststarredgithubrepos_cleanarchitecture.ui.settings

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.a7dev.moststarredgithubrepos_cleanarchitecture.R
import com.a7dev.moststarredgithubrepos_cleanarchitecture.databinding.FragmentSettingsBinding
import java.util.*


class SettingsFragment : Fragment() {
    private lateinit var viewModel: SettingsViewModel
    private lateinit var binding: FragmentSettingsBinding
    private lateinit var languageDialog: Dialog
    private lateinit var themeDialog: Dialog
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSettingsBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[SettingsViewModel::class.java]
        binding.lifecycleOwner = this@SettingsFragment
        binding.viewmodel = viewModel
        binding.settingsLanguageCV.setOnClickListener {
            showLanguagePicker()
        }
        binding.settingsModeCV.setOnClickListener {
            showThemePicker()
        }
        return binding.root
    }

    private fun showLanguagePicker() {
        Toast.makeText(requireContext(), "show language picker", Toast.LENGTH_SHORT).show()
        languageDialog = Dialog(requireContext())
        languageDialog.setContentView(R.layout.changelanguagelayout)

        val closeBtn : ImageView = languageDialog.findViewById(R.id.closeBtn)
        closeBtn.setOnClickListener {
            languageDialog.dismiss()
        }

        val englishBtn: CardView = languageDialog.findViewById(R.id.englishLanguage)
        englishBtn.setOnClickListener {
            setLocale(requireContext(), "en")
            //activity?.finish()
            //activity?.startActivity(activity?.intent)
            activity?.recreate()
        }

        val frenchBtn: CardView = languageDialog.findViewById(R.id.frenchLanguage)
        frenchBtn.setOnClickListener {
            setLocale(requireContext(), "fr")
            //activity?.finish()
            //activity?.startActivity(activity?.intent)
            activity?.recreate()
        }
        languageDialog.show()
    }
    private fun showThemePicker() {
        Toast.makeText(requireContext(), "show theme picker", Toast.LENGTH_SHORT).show()
        themeDialog = Dialog(requireContext())
        themeDialog.setContentView(R.layout.changethemelayout)

        val closeBtn : ImageView = themeDialog.findViewById(R.id.closeBtn)
        closeBtn.setOnClickListener {
            themeDialog.dismiss()
        }

        val lightBtn: CardView = themeDialog.findViewById(R.id.lightModeCV)
        lightBtn.setOnClickListener {
            changeTheme(0)
        }

        val darkBtn: CardView = themeDialog.findViewById(R.id.darkModeCV)
        darkBtn.setOnClickListener {
            changeTheme(1)
        }

        themeDialog.show()
    }
    private fun changeTheme(mode: Int) {
        themeDialog.dismiss()
        when (mode) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                saveTheme("light")
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                saveTheme("dark")
            }
        }
    }
    private fun setLocale(activity: Context, languageCode: String?) {
        languageDialog.dismiss()
        val locale = languageCode?.let { Locale(it) }
        Locale.setDefault(locale)
        val resources: Resources = activity.resources
        val config: Configuration = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
        languageCode?.let { saveLanguage(languageCode) }
    }
    private fun saveTheme(mode: String){
        val sharedPreferences: SharedPreferences? = activity?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putString("mode", mode)
        editor?.apply()
    }
    private fun saveLanguage(language: String){
        val sharedPreferences: SharedPreferences? = activity?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putString("language", language)
        editor?.apply()
    }
}