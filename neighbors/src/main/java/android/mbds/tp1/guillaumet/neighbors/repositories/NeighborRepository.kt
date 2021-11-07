package android.mbds.tp1.guillaumet.neighbors.repositories

import android.app.Application
import android.mbds.tp1.guillaumet.neighbors.adapters.ListNeighborsAdapter
import android.mbds.tp1.guillaumet.neighbors.dal.NeighborDatasource
import android.mbds.tp1.guillaumet.neighbors.dal.memory.DummyNeighborApiService
import android.mbds.tp1.guillaumet.neighbors.dal.memory.InMemoryNeighborDataSource
import android.mbds.tp1.guillaumet.neighbors.dal.room.RoomNeighborDataSource
import android.mbds.tp1.guillaumet.neighbors.models.Neighbor
import android.mbds.tp1.guillaumet.neighbors.repositories.NeighborRepository.Companion.getInstance
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NeighborRepository private constructor(private val application: Application) {
    var dataSource: NeighborDatasource = RoomNeighborDataSource(application)
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()

    // Méthode qui retourne la liste des voisins
    fun getNeighbours(): LiveData<List<Neighbor>> = dataSource.neighbours

    fun deleteNeighbour(neighbor: Neighbor) = executor.execute{dataSource.deleteNeighbour(neighbor)}
    fun add(neighbor: Neighbor) = executor.execute{dataSource.createNeighbour(neighbor)}
    fun setFavorite(neighbor: Neighbor) = dataSource.updateFavoriteStatus(neighbor)

    fun getId() = dataSource.getGeneratedId()

    fun setPersitMode() {
        dataSource = RoomNeighborDataSource(application)
    }

    fun setMemoryMode() {
        dataSource = DummyNeighborApiService.getInstance();
    }

    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(application: Application): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository(application)
            }
            return instance!!
        }
    }
}