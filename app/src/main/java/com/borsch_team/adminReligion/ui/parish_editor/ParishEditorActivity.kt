package com.borsch_team.adminReligion.ui.parish_editor

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.borsch_team.adminReligion.databinding.ActivityParishEditorBinding
import com.borsch_team.adminReligion.ui.adapter.ChurchesInnerAdapter
import com.borsch_team.adminReligion.ui.church_select.ChurchSelectSheetFragment
import com.borsch_team.adminReligion.data.api.models.Parishes
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import java.util.UUID

class ParishEditorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityParishEditorBinding
    private lateinit var viewModel: ParishEditorViewModel
    private lateinit var adapter: ChurchesInnerAdapter
    private val REQUEST_CODE_PICK_PHOTOS = 1
    private var imageURI: Uri? = null
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParishEditorBinding.inflate(LayoutInflater.from(this))
        viewModel = ViewModelProvider(this)[ParishEditorViewModel::class.java]
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Загрузка...")
        progressDialog.show()
        supportActionBar!!.title = "Редактирование прихода"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val parishId = intent.getStringExtra("parishId")
        if (parishId != null) {
            viewModel.loadParish(parishId)
        } else {
            progressDialog.dismiss()
        }
        adapter = ChurchesInnerAdapter(emptyList(), {}, {
            adapter.eraseChurch(it)
        })
        adapter.canErase = true
        binding.churches.layoutManager = LinearLayoutManager(this)
        binding.churches.adapter = adapter
        viewModel.loadChurches()
        viewModel.parish.observe(this) { parish ->
            binding.parishTitle.setText(parish.title)
            binding.parishInfo.setText(parish.mainInfo)
            binding.parishClosingInfo.setText(parish.closingInfo)
            binding.parishRestoringInfo.setText(parish.restoringInfo)
            Glide.with(this).load(parish.thumbnail).into(binding.thumbnail)
            binding.addCircle.visibility = View.GONE
        }
        viewModel.preloadedChurches.observe(this) {
            adapter.setDataset(it)
            progressDialog.dismiss()
        }
        binding.addChurch.setOnClickListener {
            ChurchSelectSheetFragment(viewModel.churches.value!!) { church ->
                adapter.addChurch(church)
            }.show(supportFragmentManager, "ChurchSelectSheetFragment")
        }
        binding.thumbnail.setOnClickListener{
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, REQUEST_CODE_PICK_PHOTOS)
        }
        binding.finishButton.setOnClickListener {
            submitParish()
        }
        setContentView(binding.root)
    }

    private fun submitParish() {
        if (!validateForm()) return

        var parishId = intent.getStringExtra("parishId")
        if (parishId == null) {
            parishId = UUID.randomUUID().toString()
        }
        val churches = adapter.getChurchesIds()
        val thumbnail = viewModel.parish.value?.thumbnail ?: ""
        val parish = Parishes(
            parishId,
            binding.parishTitle.text.toString().trim(),
            thumbnail,
            binding.parishInfo.text.toString().trim(),
            binding.parishClosingInfo.text.toString().trim(),
            binding.parishRestoringInfo.text.toString().trim(),
            ArrayList(churches)
        )
        progressDialog.show()
        viewModel.uploadParish(parish, imageURI) {
            runOnUiThread {
                onBackPressed()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    private fun validateForm(): Boolean {
        if (binding.parishTitle.text.toString().trim().isEmpty()) {
            Snackbar.make(binding.root, "Введите название", Snackbar.LENGTH_SHORT).show()
            return false
        }
        if (binding.parishInfo.text.toString().trim().isEmpty()) {
            Snackbar.make(binding.root, "Заполните основную информацию о приходе",
                Snackbar.LENGTH_SHORT).show()
            return false
        }
        if (imageURI == null && intent.getStringExtra("parishId") == null) {
            Snackbar.make(binding.root, "Добавьте изображение для прихода",
                Snackbar.LENGTH_SHORT).show()
            return false
        }
        if (adapter.itemCount == 0) {
            Snackbar.make(binding.root, "Добавьте хотя бы 1 церковь",
                Snackbar.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_PICK_PHOTOS) {
            imageURI = data?.data
            binding.addCircle.visibility = View.GONE
            binding.thumbnail.setImageURI(imageURI)
        }
    }
}