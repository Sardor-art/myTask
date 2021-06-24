package hamidov.sardor.goodzone.models

data class Promo(
    val count: String,
    val promos: List<PromoX>
)

data class PromoX(
    val active: Boolean,
    val created_at: String,
    val end_time: String,
    val formatted_date: String,
    val formatted_end_date: String,
    val formatted_start_date: String,
    val id: String,
    val image: String,
    val lang: String,
    val preview_image: String,
    val preview_text: String,
    val slug: String,
    val start_time: String,
    val title: String,
    val updated_at: String
)