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
import project.uas.ppb.detail.FasilitasLabActivity
import project.uas.ppb.detail.ProfilProdi
import project.uas.ppb.detail.StrukturOrganisasiActivity


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val button1: Button = binding.button1
        val button2: Button = binding.button2
        val button3: Button = binding.button3
        val button4: Button = binding.button4

        button1.setOnClickListener {
            val intent = Intent(activity, ProfilProdi::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(activity, DosenstafActivity::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(activity, StrukturOrganisasiActivity::class.java)
            startActivity(intent)
        }

        button4.setOnClickListener {
            val intent = Intent(activity, FasilitasLabActivity::class.java)
            startActivity(intent)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
