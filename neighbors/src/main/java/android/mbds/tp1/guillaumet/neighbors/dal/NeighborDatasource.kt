package android.mbds.tp1.guillaumet.neighbors.dal

import android.mbds.tp1.guillaumet.neighbors.models.Neighbor
import androidx.lifecycle.LiveData

interface NeighborDatasource {
    /**
     * Get all my Neighbors
     * @return [MutableList]
     */
    val neighbours: LiveData<List<Neighbor>>

    /**
     * Deletes a neighbor
     * @param neighbor : Neighbor
     */
    fun deleteNeighbour(neighbor: Neighbor)

    fun getGeneratedId():Long

    /**
     * Create a neighbour
     * @param neighbor: Neighbor
     */
    fun createNeighbour(neighbor: Neighbor)

    /**
     * Update "Favorite status" of an existing Neighbour"
     * @param neighbor: Neighbor
     */
    fun updateFavoriteStatus(neighbor: Neighbor)

    /**
     * Update modified fields of an existing Neighbour"
     * @param neighbor: Neighbor
     */
    fun updateDataNeighbour(neighbor: Neighbor)

}