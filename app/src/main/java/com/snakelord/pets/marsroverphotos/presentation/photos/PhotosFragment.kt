package com.snakelord.pets.marsroverphotos.presentation.photos

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.snakelord.pets.marsroverphotos.R
import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.databinding.FragmentPhotosBinding
import com.snakelord.pets.marsroverphotos.di.components.DaggerPhotosComponent
import com.snakelord.pets.marsroverphotos.presentation.extensions.gone
import com.snakelord.pets.marsroverphotos.presentation.extensions.visible
import com.snakelord.pets.marsroverphotos.presentation.main.adapter.PhotosAdapter
import com.snakelord.pets.marsroverphotos.presentation.photos.PhotoDetails.Companion.PHOTO_ARG
import java.util.Calendar
import javax.inject.Inject

class PhotosFragment : Fragment() {

    @Inject lateinit var factory: ViewModelProvider.Factory
    private var datePickerDialog: DatePickerDialog? = null
    private lateinit var binding: FragmentPhotosBinding
    private lateinit var photosViewModel: PhotosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        injectDependencies()
        restoreDatePickerDialog(savedInstanceState)
        photosViewModel = ViewModelProvider(this, factory)[PhotosViewModel::class.java]
        photosViewModel.photos.observe(viewLifecycleOwner, ::showPhotos)
        binding.calendarFab.setOnClickListener { showDatePickerDialog() }
        binding.photosRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun injectDependencies() {
       DaggerPhotosComponent.builder()
           .build()
           .inject(this)
    }

    private val onPhotoClickListener: (Photo) -> Unit = {
        val args = Bundle()
        args.putSerializable(PHOTO_ARG, it)
        findNavController().navigate(R.id.to_photo_details, args)
    }

    private fun showPhotos(photos: Array<Photo>) {
        binding.usageHint.gone()
        binding.progressBar.gone()
        binding.photosRecyclerView.adapter = PhotosAdapter(photos, onPhotoClickListener)
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
        datePickerDialog =
            DatePickerDialog(requireContext(), getOnDateSetListener(), year, month, day)
        datePickerDialog!!.show()
    }

    private fun getOnDateSetListener(): OnDateSetListener {
        return OnDateSetListener { _, year, month, dayOfMonth ->
            binding.usageHint.gone()
            binding.photosRecyclerView.gone()
            binding.progressBar.visible()
            photosViewModel.getPhotosByDate("$year-$month-$dayOfMonth")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        datePickerDialog?.run {
            if (isShowing) {
                saveDatePickerDialogState(outState)
                dismiss()
            }
        }
        super.onSaveInstanceState(outState)
    }

    private fun saveDatePickerDialogState(outState: Bundle) {
        val datePicker = datePickerDialog!!.datePicker
        outState.putBoolean(IS_STATE_SAVED, true)
        outState.putInt(DAY_KEY, datePicker.dayOfMonth)
        outState.putInt(MONTH_KEY, datePicker.month)
        outState.putInt(YEAR_KEY, datePicker.year)
    }

    private fun restoreDatePickerDialog(savedInstanceState: Bundle?) {
        savedInstanceState?.run {
            if (containsKey(IS_STATE_SAVED)) {
                val day = getInt(DAY_KEY)
                val month = getInt(MONTH_KEY)
                val year = getInt(YEAR_KEY)
                buildDatePickerDialog(year, month, day)
            }
        }
    }

    companion object {
        private const val IS_STATE_SAVED = "is-state-saved"
        private const val DAY_KEY = "day"
        private const val MONTH_KEY = "month"
        private const val YEAR_KEY = "year"
    }

}