package project.uas.ppb.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import project.uas.ppb.databinding.FragmentHomeBinding
import project.uas.ppb.detail.DosenstafActivity


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Mengambil referensi ke Button
        val dosenstaffButton: Button = binding.dosenstaff // Pastikan ID sesuai dengan layout XML

        // Menetapkan OnClickListener untuk Button
        dosenstaffButton.setOnClickListener {
            // Intent untuk memulai DosenstaffActivity
            val intent = Intent(activity, DosenstafActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}