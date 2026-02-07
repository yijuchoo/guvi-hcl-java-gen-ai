## MongoDB Task: Food Delivery Database Setup

### Scenario

You’re building the backend data layer for a **local food delivery app**. The app is live in one city and expanding fast, but the team has a data problem:

* Restaurant details are stored in one place
* Orders are stored in another
* Reporting is manual (Excel exports + copy/paste)
* Duplicate records and inconsistent status updates are causing operational issues

Your job is to set up a MongoDB database that supports:

1. restaurant discovery (basic details + cuisine + location)
2. order tracking (order status, totals, timestamps)
3. simple analytics using aggregation

You must use:

* **mongosh** (the shell) for database + query work
* **MongoDB Compass** for verifying data visually (at least once)

## Part A — Database Setup (mongosh)

1. Create/use a database named:
   `food_delivery_db`

2. Create two collections:

* `restaurants`
* `orders`

> Note: In MongoDB, collections can be created automatically when you insert the first document.

## Part B — Insert Data

### 3) Insert restaurant documents

Insert **at least 6** restaurant documents into `restaurants`.

Each restaurant document must include the following fields (use these exact field names):

* `restaurantId` (Number)
* `name` (String)
* `city` (String)
* `area` (String)
* `cuisines` (Array of Strings)
* `rating` (Number)
* `isOpen` (Boolean)

Dataset requirements:

* At least **2 restaurants** in **Bangalore** (or your favorite city)
* At least **1 restaurant** in **Hyderabad** (or any city of your choice)
* At least **1 restaurant** that has **rating >= 4.5**
* At least **2 restaurants** that share at least **one cuisine** (e.g., both offer `"East Indian"`)

### 4) Insert order documents

Insert **at least 10** order documents into `orders`.

Each order document must include the following fields (use these exact field names):

* `orderId` (Number)
* `restaurantId` (Number)  *(must match an existing restaurant)*
* `customerName` (String)
* `items` (Array of Objects)
* `totalAmount` (Number)
* `status` (String)
* `orderedAt` (Date)

`items` must look like this:

```js
items: [
  { name: "Item Name", qty: 2, price: 180 },
  { name: "Another Item", qty: 1, price: 120 }
]
```

Dataset requirements:

* At least **3 different statuses** across orders. Eg: `PLACED`, `PREPARING`, `DELIVERED`, `CANCELLED`
* At least **2 orders** from the **same customerName**
* At least **2 orders** for the **same restaurantId**
* At least **2 orders** on the **same calendar date**
* At least **one order** with `totalAmount > 800`

> Tip: Ensure `totalAmount` matches the items you insert (qty × price summed up). Your data should be internally consistent.

## Part C — Read Queries (Filters + Projection)

Write queries for each of the following.

5. Find all restaurants in **Bangalore** that are currently **open** (`isOpen: true`).
   Return only: `name`, `area`, `cuisines`, `rating` (hide `_id`).

6. Find restaurants that serve `"East Indian"` **and** have `rating >= 4.0`.
   Return only: `name`, `city`, `rating`.

7. Find all orders with `status: "DELIVERED"` and `totalAmount > 500`.
   Return only: `orderId`, `restaurantId`, `totalAmount`, `orderedAt`.

8. Find all orders for a single restaurant (pick one `restaurantId` from your data).
   Sort by `orderedAt` from newest to oldest and return only:
   `orderId`, `customerName`, `status`, `totalAmount`, `orderedAt`.

## Part D — Update and Delete

9. One restaurant temporarily stopped accepting orders.
   Update **one** restaurant (by `restaurantId`) and set:
   `isOpen: false`

10. A customer called support and the order must be cancelled.
    Update **one** order (by `orderId`) and set:
    `status: "CANCELLED"`

11. A test order was inserted accidentally.
    Delete **one** order using `orderId`.

## Part E — Aggregation Framework

Write aggregation pipelines for the following.

12. **Orders count by status**
    Return an output where each document shows:

* `status`
* `totalOrders`
* [Reference](https://www.mongodb.com/docs/manual/reference/operator/aggregation/count/?msockid=2d9685db16bb6b950c5093d9171d6a0e)

13. **Total revenue per restaurant (DELIVERED only)**
    For orders where `status: "DELIVERED"`, compute total revenue grouped by `restaurantId`:

* `restaurantId`
* `revenue`

Sort revenue highest to lowest.

14. **Top 3 restaurants by delivered revenue (with restaurant name)**
    Join `orders` with `restaurants` so the final output includes:

* `restaurantId`
* `restaurantName`
* `deliveredRevenue`

Sort by revenue desc and return only the top 3.

> This requires [$lookup](https://www.mongodb.com/docs/manual/reference/operator/aggregation/lookup/?msockid=2d9685db16bb6b950c5093d9171d6a0e) + [$unwind](https://www.mongodb.com/docs/manual/reference/operator/aggregation/unwind/?msockid=2d9685db16bb6b950c5093d9171d6a0e) + grouping + projection.

15. **Most frequently ordered item name**
    Across all orders, find the single most frequently ordered item by total quantity.
    Your output should show:

* `itemName`
* `totalQty`

> This requires unwinding `items` and grouping.

## Part F — Indexing Basics

16. Create indexes to support the system’s most common operations:

* Fast filtering by `status`
* Fast sorting/recent lookups by `orderedAt`
* Fast lookups by `restaurantId`

Create **at least two indexes** on the `orders` collection that support the above.

17. Use [explain()](https://www.mongodb.com/docs/manual/reference/command/explain/?msockid=2d9685db16bb6b950c5093d9171d6a0e) on one of your Part C queries to show that MongoDB can use an index.
* You don’t need to deeply interpret the output—just run it and confirm it’s working.

## Submission Checklist

Before submitting, confirm you have:

* Created/used `food_delivery_db`
* Inserted **6+ restaurants** and **10+ orders** with the required fields
* Written all filter + projection queries
* Performed update + delete correctly
* Written all required aggregation pipelines (including `$lookup` task)
* Created indexes and ran at least one `explain()`
* Verified collections in MongoDB Compass