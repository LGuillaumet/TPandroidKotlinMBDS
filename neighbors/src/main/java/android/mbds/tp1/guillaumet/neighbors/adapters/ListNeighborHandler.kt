package android.mbds.tp1.guillaumet.neighbors.adapters

import android.mbds.tp1.guillaumet.neighbors.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeibor(neighbor: Neighbor)
    fun onSetFavorite(neighbor: Neighbor)
    fun onShowNeighbor(neighbor: Neighbor)
    fun onShowChoice()

}