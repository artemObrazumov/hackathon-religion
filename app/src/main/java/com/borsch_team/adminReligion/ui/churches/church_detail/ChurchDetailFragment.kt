package com.borsch_team.adminReligion.ui.churches.church_detail

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.borsch_team.adminReligion.R
import com.borsch_team.adminReligion.databinding.FragmentChurchDetailBinding
import com.borsch_team.adminReligion.ui.adapter.ImagesAdapter
import com.borsch_team.hackathonReligion.data.models.Church

class ChurchDetailFragment(): Fragment() {

    private lateinit var binding: FragmentChurchDetailBinding
    private lateinit var viewModel: ChurchDetailViewModel
    private lateinit var adapter: ImagesAdapter
    private val REQUEST_CODE_PICK_PHOTOS = 12
    private var church = Church()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChurchDetailBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[ChurchDetailViewModel::class.java]

        // Устанавливаем текщие данные

        church = Church(
            requireArguments().getString("church_id")!!,
            requireArguments().getDouble("church_x"),
            requireArguments().getDouble("church_y"),
            requireArguments().getBoolean("church_is_old"),
            requireArguments().getString("church_name")!!,
            requireArguments().getString("church_desc")!!,
            requireArguments().getStringArrayList("church_images")!!,
        )

        binding.etName.setText(church.name)
        binding.etDesc.setText(church.description)
        binding.etX.setText(church.x.toString())
        binding.etY.setText(church.y.toString())
        binding.switchChurch.isChecked = church.isOld

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = ImagesAdapter {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            viewModel.removePhoto(it, church.id)
            adapter.removeItem(it)
        }

        adapter.setDataList(church.urlsImages)
        binding.recyclerView.adapter = adapter

        binding.imgAddPhotos.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            startActivityForResult(intent, REQUEST_CODE_PICK_PHOTOS)
        }

        viewModel.mutableLiveDataPhotos.observe(requireActivity()){
            adapter.setDataList(it)
            church.urlsImages = it
        }

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val desc = binding.etDesc.text.toString()
            val x = binding.etX.text.toString()
            val y = binding.etY.text.toString()
            val isOld = binding.switchChurch.isChecked

            if(name != "" && desc != "" && x != "" && y != ""){
                val newChurch = Church(
                    church.id,
                    x.toDouble(),
                    y.toDouble(),
                    isOld,
                    name,
                    desc,
                    church.urlsImages
                )
                viewModel.updateData(newChurch)
                Navigation.findNavController(binding.root).navigate(R.id.nav_churches)
            }
            else{
                Toast.makeText(requireContext(), "Заполните все поля!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_PICK_PHOTOS && resultCode == RESULT_OK) {
            val photoUris = mutableListOf<Uri>()
            if (data?.clipData != null) {
                for (i in 0 until data.clipData!!.itemCount) {
                    val uri = data.clipData!!.getItemAt(i).uri
                    photoUris.add(uri)
                }
            } else if (data?.data != null) {
                photoUris.add(data.data!!)
            }
            viewModel.addPhotos(photoUris, church.id)
        }
    }
}