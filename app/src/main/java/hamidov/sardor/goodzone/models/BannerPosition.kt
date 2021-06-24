package hamidov.sardor.goodzone.models

data class BannerPosition(
    val count: String,
    val positions: List<Position>
)

data class Position(
    val active: Boolean,
    val created_at: String,
    val description: String,
    val id: String,
    val size: String,
    val slug: String,
    val title: String,
    val updated_at: String
)