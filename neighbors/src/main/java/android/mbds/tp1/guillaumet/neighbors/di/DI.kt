package android.mbds.tp1.guillaumet.neighbors.di

import android.app.Application
import android.mbds.tp1.guillaumet.neighbors.repositories.NeighborRepository

object DI {
    lateinit var repository: NeighborRepository
    fun inject(application: Application) {
        repository = NeighborRepository.getInstance(application)
    }
}