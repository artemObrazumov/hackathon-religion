package com.borsch_team.hackathonReligion.ui.church_info

import android.content.DialogInterface
import android.content.DialogInterface.OnShowListener
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.borsch_team.hackathonReligion.data.models.Church
import com.borsch_team.hackathonReligion.databinding.FragmentChurchInfoBinding
import com.borsch_team.hackathonReligion.ui.adapters.GalleryAdapter
import com.borsch_team.hackathonReligion.ui.image_viewer.ImageViewerActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class ChurchInfoFragment(
    private val churchID: String
) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentChurchInfoBinding
    private lateinit var viewModel: ChurchInfoViewModel
    private var church: Church = Church()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this)[ChurchInfoViewModel::class.java]
        binding = FragmentChurchInfoBinding.inflate(inflater, container, false)

        viewModel.viewModelScope.launch{
            viewModel.getChurchInfo(churchID)
        }
        viewModel.mutableLiveDataChurch.observe(viewLifecycleOwner){church ->
            binding.churchName.text = church.name
            binding.churchDesc.text = church.description
            binding.resGallery.layoutManager = LinearLayoutManager(context)
            val adapter = GalleryAdapter{
                val intent = Intent(context, ImageViewerActivity::class.java)
                intent.putExtra("url_photo", it)
                startActivity(intent)
            }
            adapter.setDataList(arrayListOf(
                "https://www.dicoding.com/blog/wp-content/uploads/2019/01/rvlv2.png"
            ))
            binding.resGallery.adapter = adapter
        }

        customizeDialogState()
        return binding.root
    }

    private fun customizeDialogState() {
        dialog?.setOnShowListener {
            binding.root.minimumHeight = Resources.getSystem().displayMetrics.heightPixels
        }
    }
}