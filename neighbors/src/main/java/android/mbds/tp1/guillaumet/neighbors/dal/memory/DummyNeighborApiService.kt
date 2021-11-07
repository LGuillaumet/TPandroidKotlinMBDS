package android.mbds.tp1.guillaumet.neighbors.dal.memory

import android.mbds.tp1.guillaumet.neighbors.dal.NeighborDatasource
import android.mbds.tp1.guillaumet.neighbors.models.Neighbor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DummyNeighborApiService private constructor() : NeighborDatasource {

    private val DUMMY_NeighborS = InMemory_NeighborS
    private val observable: MutableLiveData<List<Neighbor>> = MutableLiveData(DUMMY_NeighborS)

    override val neighbours: LiveData<List<Neighbor>>
        get() = observable

    override fun deleteNeighbour(neighbor: Neighbor) {
        DUMMY_NeighborS.remove(neighbor)
        observable.postValue(DUMMY_NeighborS)
    }

    override fun createNeighbour(neighbor: Neighbor) {
        DUMMY_NeighborS.add(neighbor)
        observable.postValue(DUMMY_NeighborS)
    }

    override fun updateFavoriteStatus(neighbor: Neighbor) {
        neighbor.favorite = !neighbor.favorite
    }

    override fun updateDataNeighbour(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }
    

    override fun getGeneratedId(): Long {
        TODO("Not yet implemented")
    }


    companion object {
        private var instance: DummyNeighborApiService? = null
        fun getInstance(): DummyNeighborApiService {
            if (instance == null) {
                instance = DummyNeighborApiService()
            }
            return instance!!
        }
    }

}