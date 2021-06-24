package hamidov.sardor.goodzone.models

data class New(
    val count: String,
    val news: List<NewX>
)

data class NewX(
    val active: Boolean,
    val created_at: String,
    val description: String,
    val formatted_date: String,
    val full_text: String,
    val id: String,
    val imageURL: String,
    val meta: Meta,
    val preview_image: String,
    val slug: String,
    val title: String,
    val updated_at: String
)

data class Meta(
    val description: String,
    val tags: String,
    val title: String
)