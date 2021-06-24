package hamidov.sardor.goodzone.models

data class Categories(
    val categories: List<CategoryX>,
    val count: String
)

data class CategoryX(
    val active: Boolean,
    val children: List<Children>,
    val description: String,
    val id: String,
    val image: String,
    val name: String,
    val order: String,
    val slug: String
)

data class Children(
    val active: Boolean,
    val children: List<ChildrenX>,
    val created_at: String,
    val description: String,
    val id: String,
    val image: String,
    val name: String,
    val order: String,
    val slug: String,
    val updated_at: String
)

data class ChildrenX(
    val active: Boolean,
    val created_at: String,
    val description: String,
    val id: String,
    val image: String,
    val name: String,
    val order: String,
    val slug: String,
    val updated_at: String
)