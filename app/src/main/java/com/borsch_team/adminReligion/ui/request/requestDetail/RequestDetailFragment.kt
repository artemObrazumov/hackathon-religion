package com.borsch_team.adminReligion.ui.request.requestDetail

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.borsch_team.adminReligion.databinding.FragmentRequestsDetailBinding
import com.borsch_team.adminReligion.ui.adapter.RequestAdapter
import com.borsch_team.hackathonReligion.data.models.Request


class RequestDetailFragment(
    private val archived: Boolean = false,
    private val onArchived: (archivedRequest: Request) -> Unit
): Fragment() {

    private var _binding: FragmentRequestsDetailBinding? = null
    private val binding get() = _binding!!
    private var _viewModel: RequestViewModel? = null
    private val viewModel get() = _viewModel!!
    private lateinit var adapter: RequestAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewModel =
            ViewModelProvider(this)[RequestViewModel::class.java]
        viewModel.loadRequests(archived)
        adapter = RequestAdapter(emptyList(), archived, { email ->
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto: $email")
            startActivity(intent)
        }, { phone ->
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel: $phone"))
            if (ContextCompat.checkSelfPermission(requireContext(),android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.CALL_PHONE), 0)
            } else {
                startActivity(intent)
            }
        }) { archiveRequest ->
            viewModel.archiveRequest(archiveRequest.id)
            adapter.removeItem(archiveRequest)
            onArchived(archiveRequest)
        }
        viewModel.requests.observe(viewLifecycleOwner) { requests ->
            adapter.updateDataset(requests)
        }
        _binding = FragmentRequestsDetailBinding.inflate(inflater, container, false)
        binding.requests.layoutManager = LinearLayoutManager(requireContext())
        binding.requests.adapter = adapter
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun addRequest(request: Request) {
        adapter.prependRequest(request)
    }
}