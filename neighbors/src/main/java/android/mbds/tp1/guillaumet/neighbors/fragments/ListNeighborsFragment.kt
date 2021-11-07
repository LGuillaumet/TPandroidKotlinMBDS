package android.mbds.tp1.guillaumet.neighbors.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.mbds.tp1.guillaumet.neighbors.MainActivity
import android.mbds.tp1.guillaumet.neighbors.R
import android.mbds.tp1.guillaumet.neighbors.adapters.ListNeighborHandler
import android.mbds.tp1.guillaumet.neighbors.adapters.ListNeighborsAdapter
import android.mbds.tp1.guillaumet.neighbors.data.NeighborRepository
import android.mbds.tp1.guillaumet.neighbors.models.Neighbor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListNeighborsFragment : Fragment(), ListNeighborHandler{

    private lateinit var recyclerView: RecyclerView

    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        view.findViewById<FloatingActionButton>(R.id.add).setOnClickListener {
            (activity as? MainActivity)?.changeFragment(AddNeighbourFragment())
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }

    override fun onDeleteNeibor(neighbor: Neighbor) {
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setTitle("Neighbor Alert")
        alertDialogBuilder.setMessage("Voulez-vous supprimer ce voisin ?")

        alertDialogBuilder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(context,
                android.R.string.yes, Toast.LENGTH_SHORT).show()
            NeighborRepository.getInstance().deleteNeighbour(neighbor)
            //on refresh
            val neighbors = NeighborRepository.getInstance().getNeighbours()
            val adapter = ListNeighborsAdapter(neighbors, this)
            recyclerView.adapter = adapter
        }

        alertDialogBuilder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(context,
                android.R.string.no, Toast.LENGTH_SHORT).show()
        }
        alertDialogBuilder.show()
    }
}