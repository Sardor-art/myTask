package hamidov.sardor.goodzone.models

data class Shop(
    val shops: List<ShopX>
)

data class ShopX(
    val active: Boolean,
    val address: String,
    val address2: String,
    val external_id: String,
    val id: String,
    val image: String,
    val loc: Loc,
    val name: String,
    val phone: String,
    val preview_text: String,
    val slug: String,
    val working_hours: String
)

data class Loc(
    val lat: Int,
    val long: Int
)