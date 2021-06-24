package hamidov.sardor.goodzone.models

data class Order(
    val count: String,
    val orders: List<OrderX>
)

data class OrderX(
    val address: String,
    val created_at: String,
    val customer_id: String,
    val customer_name: String,
    val delivery_method: String,
    val id: String,
    val items: List<Item>,
    val longlat: String,
    val note: String,
    val number: String,
    val paid_at: String,
    val payment_method: String,
    val phone: String,
    val status: String,
    val updated_at: String
)

data class Item(
    val image: String,
    val price: Int,
    val product_id: String,
    val product_name: String,
    val quantity: Int
)