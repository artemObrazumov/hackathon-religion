package com.borsch_team.hackathonReligion.ui.churches

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.borsch_team.hackathonReligion.R
import com.borsch_team.hackathonReligion.databinding.FragmentChurchesBinding
import com.borsch_team.hackathonReligion.ui.church_info.ChurchInfoFragment
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.*
import com.yandex.mapkit.map.*
import com.yandex.runtime.ui_view.ViewProvider
import java.util.*


class ChurchesFragment : Fragment() {

    private var _binding: FragmentChurchesBinding? = null
    private val binding get() = _binding!!
    private var mapObjects: MapObjectCollection? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        MapKitFactory.setApiKey("02a6765a-370c-442e-989a-a3fe5a25bfb7")
        _binding = FragmentChurchesBinding.inflate(inflater, container, false)
        val TARGET_LOCATION = Point(59.945933, 30.320045)
        binding.mapview.getMap().move(
            CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 1F),
            null
        )
        mapObjects = binding.mapview.getMap().getMapObjects().addCollection()
        createMapObjects()
        return binding.root
    }

    private fun createMapObjects() {
        createTappableCircle()
    }

    private val circleMapObjectTapListener =
        MapObjectTapListener { mapObject, point ->
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

    private fun createTappableCircle() {
        val imageView = ImageView(requireContext())
        ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        imageView.setImageResource(R.drawable.baseline_church_24)
        val viewProvider = ViewProvider(imageView)
        val church = mapObjects!!.addPlacemark(Point(59.946263, 30.315181), viewProvider)
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