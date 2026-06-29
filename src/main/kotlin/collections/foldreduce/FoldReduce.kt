package collections.foldreduce

import collections.Customer
import collections.Product
import collections.Shop

// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> =
    this.customers
        .map { it.getOrderedProducts() }
        .reduce { orderedByAll, nextCustomerProducts ->
            orderedByAll.intersect(nextCustomerProducts)
        }

fun Customer.getOrderedProducts(): Set<Product> =
    this.orders.flatMap { it.products }.toSet()
