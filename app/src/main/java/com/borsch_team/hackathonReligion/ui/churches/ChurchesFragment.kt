package com.borsch_team.hackathonReligion.ui.churches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.borsch_team.hackathonReligion.R
import com.borsch_team.hackathonReligion.data.models.Church
import com.borsch_team.hackathonReligion.databinding.FragmentChurchesBinding
import com.borsch_team.hackathonReligion.ui.church_info.ChurchInfoFragment
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.*
import com.yandex.mapkit.map.*
import com.yandex.runtime.ui_view.ViewProvider


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
        viewModel.liveDataListItemsOldChurches.observe(viewLifecycleOwner){
            it.forEach {church ->
                createOldChurchMark(church)
            }
        }

        val TARGET_LOCATION_ARZAMAS = Point(55.386799, 43.814133)
        binding.mapview.map.move(
            CameraPosition(TARGET_LOCATION_ARZAMAS, 12.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 1F),
            null
        )
        mapObjects = binding.mapview.map.mapObjects.addCollection()

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
        val imageView = ImageView(requireContext())
        imageView.setImageResource(R.drawable.baseline_church_24)
        imageView.setColorFilter(ContextCompat.getColor(
            requireContext(), R.color.oldChurch), android.graphics.PorterDuff.Mode.SRC_IN)
        imageView.setBackgroundResource(R.drawable.church_old_item_background)

        imageView.setPadding(6,6,6,6)
        imageView.minimumHeight = 48
        imageView.minimumWidth = 48
        val viewProvider = ViewProvider(imageView)
        val church = mapObjects!!.addPlacemark(
            Point(church.x, church.y), viewProvider)
        church.addTapListener(circleMapObjectTapListener)
        church.userData = ChurchMarkerData("")
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