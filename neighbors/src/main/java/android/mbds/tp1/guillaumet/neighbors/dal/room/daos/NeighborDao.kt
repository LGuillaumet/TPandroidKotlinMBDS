package android.mbds.tp1.guillaumet.neighbors.dal.room.daos

import android.mbds.tp1.guillaumet.neighbors.dal.room.entities.NeighborEntity
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NeighborDao {
    @Query("SELECT * from neighbors")
    fun getNeighbors(): LiveData<List<NeighborEntity>>
    @Insert
    fun add(toEntity: NeighborEntity)
    @Update
    fun update(toEntity: NeighborEntity)
    @Delete
    fun deleteNeighbour(toEntity: NeighborEntity)



}