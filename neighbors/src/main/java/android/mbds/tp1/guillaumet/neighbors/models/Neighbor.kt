package android.mbds.tp1.guillaumet.neighbors.models

data class Neighbor(
    val id: Long,
    val name: String,
    val avatarUrl: String,
    val address: String,
    val phoneNumber: String,
    val aboutMe: String,
    var favorite: Boolean,
    val webSite: String
)