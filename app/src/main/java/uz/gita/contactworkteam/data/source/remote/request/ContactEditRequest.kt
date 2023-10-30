package uz.gita.contactworkteam.data.source.remote.request

data class ContactEditRequest(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: String,
)