package com.borsch_team.hackathonReligion.ui.thanks

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.DialogFragment
import com.borsch_team.hackathonReligion.R

class ThanksFragment: AppCompatDialogFragment() {
    private lateinit var customView: View

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        customView = this.layoutInflater.inflate(R.layout.fragment_thanks, null)
        customView.findViewById<TextView>(R.id.dismiss).setOnClickListener {
            dismiss()
        }

        return AlertDialog.Builder(this.context)
            .setView(customView)
            .create()
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}