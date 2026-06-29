package collections.groupby

import collections.City
import collections.Customer
import collections.Shop

// Build a map that stores the customers living in a given city
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> =
    this.customers.groupBy { it.city }