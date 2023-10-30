package uz.gita.contactworkteam.data.source.remote.request

data class ContactAddRequest(
    val firstName: String,
    val lastName: String,
    val phone: String,
)