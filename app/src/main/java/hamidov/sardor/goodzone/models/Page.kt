package hamidov.sardor.goodzone.models

data class Page(
    val count: String,
    val pages: List<PageX>
)

data class PageX(
    val active: Boolean,
    val content: String,
    val created_at: String,
    val id: String,
    val lang: String,
    val preview_image: String,
    val slug: String,
    val title: String,
    val updated_at: String
)