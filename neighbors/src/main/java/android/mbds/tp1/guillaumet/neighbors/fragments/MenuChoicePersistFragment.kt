package android.mbds.tp1.guillaumet.neighbors.fragments

import android.app.Application
import android.mbds.tp1.guillaumet.neighbors.R
import android.mbds.tp1.guillaumet.neighbors.dal.memory.DummyNeighborApiService
import android.mbds.tp1.guillaumet.neighbors.dal.room.RoomNeighborDataSource
import android.mbds.tp1.guillaumet.neighbors.repositories.NeighborRepository
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment

class MenuChoicePersistFragment : Fragment() {

    private var persistant: Boolean = true;
    private var memory: Boolean = false;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.choice_persist_fragment, container, false)

        val btnPersistantMode: RadioButton = view.findViewById(R.id.RadioPersistant)
        val btnMemoryMode: RadioButton = view.findViewById(R.id.RadioMemory)
        val btnValider: Button = view.findViewById(R.id.RadioValidate)

        btnPersistantMode.setOnClickListener {
            persistant = true;
            memory = false;
            btnPersistantMode.isChecked = persistant;
            btnMemoryMode.isChecked = memory;
            NeighborRepository.getInstance(requireActivity().application).setPersitMode()

        }

        btnMemoryMode.setOnClickListener {
            persistant = false;
            memory = true;
            btnMemoryMode.isChecked = memory;
            btnPersistantMode.isChecked = persistant;
            NeighborRepository.getInstance(requireActivity().application).setMemoryMode()
        }


        btnValider.setOnClickListener {
            if (persistant) {
                NeighborRepository.getInstance(requireActivity().application).setPersitMode()
            } else {
                NeighborRepository.getInstance(requireActivity().application).setMemoryMode()
            }
            requireActivity().supportFragmentManager.popBackStack()
        }


        return view
    }
}