package hamidov.sardor.goodzone.models

data class ProductProperty(
    val count: String,
    val product_properties: List<ProductPropertyX>
)

data class ProductPropertyX(
    val active: Boolean,
    val created_at: String,
    val description: String,
    val id: String,
    val name: String,
    val options: List<Option>,
    val order: String,
    val slug: String,
    val type: String,
    val updated_at: String
)

data class Option(
    val id: String,
    val name: String,
    val value: String
)