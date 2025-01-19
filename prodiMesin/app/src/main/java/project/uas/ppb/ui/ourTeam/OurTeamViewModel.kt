package project.uas.ppb.ui.ourTeam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OurTeamViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is our team Fragment"
    }
    val text: LiveData<String> = _text
}