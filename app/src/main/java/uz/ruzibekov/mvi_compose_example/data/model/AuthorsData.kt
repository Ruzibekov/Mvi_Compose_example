package uz.ruzibekov.mvi_compose_example.data.model

data class AuthorsData(
    val `data`: List<Author>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)