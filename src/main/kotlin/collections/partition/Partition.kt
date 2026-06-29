package collections.partition

import collections.Customer
import collections.Shop

// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
    this.customers.filter { customer ->

        val (delivered, undelivered) =
            customer.orders.partition { it.isDelivered }

        delivered.size < undelivered.size
    }.toSet()