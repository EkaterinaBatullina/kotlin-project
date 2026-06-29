package collections.maxmin

import collections.Customer
import collections.Product
import collections.Shop

// Return a customer who has placed the maximum amount of orders
fun Shop.getCustomerWithMaxOrders(): Customer? =
    this.customers.maxByOrNull { it.orders.size }

// Return the most expensive product that has been ordered by the given customer
fun getMostExpensiveProductBy(customer: Customer): Product? =
    customer.orders.flatMap { it.products }.maxByOrNull { it.price }