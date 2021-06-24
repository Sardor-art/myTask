package hamidov.sardor.goodzone.models

data class ProductPropertyGroups(
    val count: String,
    val product_property_groups: List<ProductPropertyGroup>
)

data class ProductPropertyGroup(
    val active: Boolean,
    val created_at: String,
    val description: String,
    val id: String,
    val name: String,
    val order: String,
    val properties: List<Property>,
    val slug: String,
    val updated_at: String
)

data class Property(
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

