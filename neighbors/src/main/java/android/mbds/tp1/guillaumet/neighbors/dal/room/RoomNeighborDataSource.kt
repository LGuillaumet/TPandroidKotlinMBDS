package android.mbds.tp1.guillaumet.neighbors.dal.room

import android.app.Application
import android.mbds.tp1.guillaumet.neighbors.dal.NeighborDatasource
import android.mbds.tp1.guillaumet.neighbors.dal.room.daos.NeighborDao
import android.mbds.tp1.guillaumet.neighbors.dal.utils.toEntity
import android.mbds.tp1.guillaumet.neighbors.dal.utils.toNeighbor
import android.mbds.tp1.guillaumet.neighbors.models.Neighbor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import java.util.concurrent.Executors

class RoomNeighborDataSource(application: Application) : NeighborDatasource {
    private val database: NeighborDataBase = NeighborDataBase.getDataBase(application)
    private val dao: NeighborDao = database.neighborDao()

    private val _neighors = MediatorLiveData<List<Neighbor>>()

    init {

        _neighors.addSource(dao.getNeighbors()) { entities ->
            _neighors.value = entities.map { entity ->
                entity.toNeighbor()
            }
        }
    }

    override val neighbours: LiveData<List<Neighbor>>
        get() = _neighors

    override fun deleteNeighbour(neighbor: Neighbor) {
        dao.deleteNeighbour(neighbor.toEntity())
    }

    override fun getGeneratedId(): Long {
        return 0
    }

    override fun createNeighbour(neighbor: Neighbor) {
        dao.add(neighbor.toEntity())
    }

    override fun updateFavoriteStatus(neighbor: Neighbor) {
        Executors.newSingleThreadExecutor().execute {
            neighbor.favorite = !neighbor.favorite;
            dao.update(neighbor.toEntity())
        }
    }

    override fun updateDataNeighbour(neighbor: Neighbor) {
        dao.update(neighbor.toEntity())
    }


}