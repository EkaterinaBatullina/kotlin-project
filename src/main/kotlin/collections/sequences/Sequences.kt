package collections.sequences

import collections.Customer
import collections.Product
import collections.Shop

// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer
        .orders
        .asSequence()
        .filter { it.isDelivered }
        .flatMap { it.products.asSequence() }
        .maxByOrNull { it.price }
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return this.customers
        .flatMap { it.getOrderedProducts() }
        .count { it == product }
}

fun Customer.getOrderedProducts(): Sequence<Product> =
    this.orders.asSequence().flatMap { it.products.asSequence() }
