package collections.compound

import collections.Customer
import collections.Product
import collections.Shop

// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer
        .orders
        .filter { it.isDelivered }
        .flatMap { it.products }
        .maxByOrNull { it.price }
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return this.customers
        .flatMap { it.getOrderedProducts() }
        .filter {it == product}
        .size
}

fun Customer.getOrderedProducts(): List<Product> =
    this.orders.flatMap { it.products }