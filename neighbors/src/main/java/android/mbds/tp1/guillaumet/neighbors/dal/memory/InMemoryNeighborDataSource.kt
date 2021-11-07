package android.mbds.tp1.guillaumet.neighbors.dal.memory

import android.mbds.tp1.guillaumet.neighbors.dal.NeighborDatasource
import android.mbds.tp1.guillaumet.neighbors.models.Neighbor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class InMemoryNeighborDataSource : NeighborDatasource {

    private val observable: MutableLiveData<List<Neighbor>> = MutableLiveData(InMemory_NeighborS)


    override val neighbours: LiveData<List<Neighbor>>
        get() = observable

    override fun deleteNeighbour(neighbor: Neighbor) {
        InMemory_NeighborS.remove(neighbor)
        observable.value = InMemory_NeighborS
    }

    override fun getGeneratedId(): Long {
        return (InMemory_NeighborS.size+1).toLong()
    }

    override fun createNeighbour(neighbor: Neighbor) {
        InMemory_NeighborS.add(neighbor)

    }

    override fun updateFavoriteStatus(neighbor: Neighbor) {
        neighbor.favorite = !neighbor.favorite
    }

    override fun updateDataNeighbour(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }



}