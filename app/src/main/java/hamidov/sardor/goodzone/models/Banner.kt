package hamidov.sardor.goodzone.models

data class Banner(
    val banner: BannerX
)

data class BannerX(
    val active: Boolean,
    val created_at: String,
    val description: String,
    val id: String,
    val image: String,
    val position: Position,
    val title: String,
    val updated_at: String,
    val url: String
)
