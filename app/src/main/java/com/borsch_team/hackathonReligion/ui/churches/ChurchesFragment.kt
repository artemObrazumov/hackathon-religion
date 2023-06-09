package com.borsch_team.hackathonReligion.ui.churches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.borsch_team.hackathonReligion.R
import com.borsch_team.hackathonReligion.data.models.Church
import com.borsch_team.hackathonReligion.databinding.FragmentChurchesBinding
import com.borsch_team.hackathonReligion.ui.church_info.ChurchInfoFragment
import com.borsch_team.hackathonReligion.ui.church_search.ChurchSearchFragment
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.*
import com.yandex.mapkit.map.*
import com.yandex.runtime.ui_view.ViewProvider
import kotlinx.coroutines.launch


class ChurchesFragment : Fragment() {

    private var _binding: FragmentChurchesBinding? = null
    private val binding get() = _binding!!
    private var mapObjects: MapObjectCollection? = null
    private lateinit var viewModel: ChurchesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChurchesBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[ChurchesViewModel::class.java]

        viewModel.getDataListPoints()

        viewModel.liveDataListItemsPoints.observe(viewLifecycleOwner){
            it.forEach {church ->
                if (church.isOld) {
                    createOldChurchMark(church)
                } else {
                    createNewChurchMark(church)
                }
            }
        }


        var TARGET_LOCATION = Point(55.386799, 43.814133)
        var zoom = 12.0f
        arguments?.let {
            TARGET_LOCATION = Point(it.getDouble("x"), it.getDouble("y"))
            zoom = 20.0f
        }
        binding.mapview.map.move(
            CameraPosition(TARGET_LOCATION, zoom, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 1F),
            null
        )
        mapObjects = binding.mapview.map.mapObjects.addCollection()

        binding.search.setOnClickListener {
            ChurchSearchFragment { church ->
                binding.mapview.map.move(
                    CameraPosition(Point(church.x, church.y), 20.0f, 0.0f, 0.0f),
                    Animation(Animation.Type.SMOOTH, 1F),
                    null
                )
            }.show(childFragmentManager, "church_$id")
        }

        return binding.root
    }


    private val circleMapObjectTapListener =
        MapObjectTapListener { mapObject, _ ->
            if (mapObject is PlacemarkMapObject) {
                val userData = mapObject.userData
                if (userData is ChurchMarkerData) {
                    openChurchInfo(userData.churchID)
                }
            }
            true
        }

    private fun openChurchInfo(id: String) {
        val churchInfoFragment = ChurchInfoFragment(id)
        churchInfoFragment.show(childFragmentManager, "church_$id")
    }

    private fun createOldChurchMark(church: Church) {
        if (church.x == 0.0) {
            return
        }
        val imageView = ImageView(requireContext())
        imageView.setImageResource(R.drawable.baseline_church_24)
        imageView.setColorFilter(ContextCompat.getColor(
            requireContext(), R.color.oldChurch), android.graphics.PorterDuff.Mode.SRC_IN)
        imageView.setBackgroundResource(R.drawable.church_old_item_background)

        imageView.setPadding(6,6,6,6)
        imageView.minimumHeight = 48
        imageView.minimumWidth = 48
        val viewProvider = ViewProvider(imageView)
        val churchMark = mapObjects!!.addPlacemark(
            Point(church.x, church.y), viewProvider)
        churchMark.addTapListener(circleMapObjectTapListener)
        churchMark.userData = ChurchMarkerData(church.id)
    }

    private fun createNewChurchMark(church: Church) {
        if (church.x == 0.0) {
            return
        }
        val imageView = ImageView(requireContext())
        imageView.setImageResource(R.drawable.baseline_church_24)
        imageView.setColorFilter(ContextCompat.getColor(
            requireContext(), R.color.newChurch), android.graphics.PorterDuff.Mode.SRC_IN)
        imageView.setBackgroundResource(R.drawable.church_new_item_background)

        imageView.setPadding(6,6,6,6)
        imageView.minimumHeight = 48
        imageView.minimumWidth = 48
        val viewProvider = ViewProvider(imageView)
        val churchMark = mapObjects!!.addPlacemark(
            Point(church.x, church.y), viewProvider)
        churchMark.addTapListener(circleMapObjectTapListener)
        churchMark.userData = ChurchMarkerData(church.id)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStop() {
        binding.mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapview.onStart()
    }
}