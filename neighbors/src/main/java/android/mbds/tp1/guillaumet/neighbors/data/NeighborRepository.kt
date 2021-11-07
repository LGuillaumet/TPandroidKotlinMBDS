package android.mbds.tp1.guillaumet.neighbors.data

import android.mbds.tp1.guillaumet.neighbors.data.service.DummyNeighborApiService
import android.mbds.tp1.guillaumet.neighbors.data.service.NeighborApiService
import android.mbds.tp1.guillaumet.neighbors.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService

    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): List<Neighbor> = apiService.neighbours

    fun deleteNeighbour(neighbor: Neighbor) = apiService.deleteNeighbour(neighbor)
    fun createNeighbour(neighbor: Neighbor) = apiService.createNeighbour(neighbor)


    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
}