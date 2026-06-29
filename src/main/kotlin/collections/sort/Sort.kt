package collections.sort

import collections.Customer
import collections.Shop

// Return a list of customers, sorted in the descending by number of orders they have made
fun Shop.getCustomersSortedByOrders(): List<Customer> =
    this.customers.sortedByDescending {it.orders.size}