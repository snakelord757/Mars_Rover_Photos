package com.snakelord.pets.marsroverphotos.presentation.main

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.databinding.ActivityMainBinding
import com.snakelord.pets.marsroverphotos.di.components.DaggerMainComponent
import com.snakelord.pets.marsroverphotos.presentation.extensions.gone
import com.snakelord.pets.marsroverphotos.presentation.extensions.visible
import com.snakelord.pets.marsroverphotos.presentation.main.adapter.PhotosAdapter
import com.snakelord.pets.marsroverphotos.presentation.utils.DateFormatter
import java.util.Calendar
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var factory: ViewModelProvider.Factory
    private var datePickerDialog: DatePickerDialog? = null
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        injectDependencies()
        restoreDatePickerDialog(savedInstanceState)
        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        mainViewModel.photos.observe(this, ::showPhotos)
        binding.calendarFab.setOnClickListener { showDatePickerDialog() }
        binding.photosRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun injectDependencies() {
        DaggerMainComponent
            .create()
            .inject(this)
    }

    private fun showPhotos(photos: Array<Photo>) {
        binding.progressBar.gone()
        binding.photosRecyclerView.adapter = PhotosAdapter(photos)
        binding.photosRecyclerView.visible()
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        buildDatePickerDialog(year, month, day)
    }

    private fun buildDatePickerDialog(year: Int, month: Int, day: Int) {
        datePickerDialog = DatePickerDialog(this, getOnDateSetListener(), year, month, day)
        datePickerDialog!!.show()
    }

    private fun getOnDateSetListener(): OnDateSetListener {
        return OnDateSetListener { _, year, month, dayOfMonth ->
            binding.photosRecyclerView.gone()
            binding.progressBar.visible()
            mainViewModel.getPhotosByDate(DateFormatter.formatDate(dayOfMonth, month, year))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        datePickerDialog?.let { dialog ->
            if (dialog.isShowing) {
                saveDatePickerDialogState(outState)
                dialog.dismiss()
            }
        }
        super.onSaveInstanceState(outState)
    }

    private fun restoreDatePickerDialog(savedInstanceState: Bundle?) {
        savedInstanceState?.let { bundle ->
            if (bundle.containsKey(IS_STATE_SAVED)) {
                val day = bundle.getInt(DAY_KEY)
                val month = bundle.getInt(MONTH_KEY)
                val year = bundle.getInt(YEAR_KEY)
                buildDatePickerDialog(year, month, day)
            }
        }
    }

    private fun saveDatePickerDialogState(outState: Bundle) {
        val datePicker = datePickerDialog!!.datePicker
        outState.putBoolean(IS_STATE_SAVED, true)
        outState.putInt(DAY_KEY, datePicker.dayOfMonth)
        outState.putInt(MONTH_KEY, datePicker.month)
        outState.putInt(YEAR_KEY, datePicker.year)
    }

    companion object {
        private const val IS_STATE_SAVED = "is-state-saved"
        private const val DAY_KEY = "day"
        private const val MONTH_KEY = "month"
        private const val YEAR_KEY = "year"
    }

}