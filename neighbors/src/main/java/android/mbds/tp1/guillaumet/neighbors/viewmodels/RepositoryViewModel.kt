package android.mbds.tp1.guillaumet.neighbors.viewmodels

import android.mbds.tp1.guillaumet.neighbors.di.DI
import android.mbds.tp1.guillaumet.neighbors.models.Neighbor
import android.mbds.tp1.guillaumet.neighbors.repositories.NeighborRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NeighborViewModel : ViewModel() {
    private val repository: NeighborRepository = DI.repository

    // On fait passe plat sur le résultat retourné par le repository
    val neighbors: LiveData<List<Neighbor>>
        get() = repository.getNeighbours()
}