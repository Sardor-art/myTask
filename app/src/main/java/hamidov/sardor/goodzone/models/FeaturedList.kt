package hamidov.sardor.goodzone.models

data class FeaturedList(
    val count: String,
    val featured_lists: List<FeaturedLists>
)

data class FeaturedLists(
    val active: Boolean,
    val created_at: String,
    val description: String,
    val id: String,
    val lang: String,
    val order: String,
    val products: List<Product>,
    val slug: String,
    val title: String
)

data class Product(
    val active: Boolean,
    val brand: Brand,
    val category: Category,
    val code: String,
    val created_at: String,
    val external_id: String,
    val id: String,
    val image: String,
    val in_stock: InStock,
    val name: String,
    val preview_text: String,
    val price: Price,
    val prices: List<PriceX>,
    val slug: String,
    val updated_at: String
)

data class Brand(
    val active: Boolean,
    val created_at: String,
    val description: String,
    val id: String,
    val image: String,
    val name: String,
    val order: String,
    val preview_text: String,
    val slug: String,
    val updated_at: String
)

data class Category(
    val active: Boolean,
    val id: String,
    val image: String,
    val name: String,
    val order: String,
    val parent: Parent,
    val slug: String
)

data class InStock(
    val samarkand: Boolean,
    val tashkent_city: Boolean
)

data class Price(
    val old_price: String,
    val price: String
)

data class PriceX(
    val id: String,
    val old_price: String,
    val price: String,
    val type: String
)

data class Parent(
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