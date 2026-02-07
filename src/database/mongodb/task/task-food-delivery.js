/*
* MongoDB Task: Food Delivery Database Setup
*   https://github.com/Nikhilnair48/guvi-java-gen-ai/blob/main/tasks/MongoDB-Task.md
*/
// MongoDB
//      database (eg. company_db)
//      collection (eg. employees) = table -> group of documents of a similar type
//      document = row -> 1 record stored as key value pairs
//      field (in a document) = column -> every document has an _id field that identifies it

/*
    MongoDB Query Language = MQL
*/

Part A — Database Setup (mongosh)
1. Create/use a database named: food_delivery_db
    use food_delivery_db;

2. Create two collections:
    - restaurants
    - orders
Note: In MongoDB, collections can be created automatically when you insert the first document.

db.createCollection("restaurants")
db.createCollection("orders")

-------------------------------------------------------------------------------------------------------------
Part B — Insert Data
3) Insert restaurant documents
Insert at least 6 restaurant documents into restaurants.

Each restaurant document must include the following fields (use these exact field names):

restaurantId (Number)
name (String)
city (String)
area (String)
cuisines (Array of Strings)
rating (Number)
isOpen (Boolean)

Dataset requirements:
At least 2 restaurants in Bangalore (or your favorite city)
At least 1 restaurant in Hyderabad (or any city of your choice)
At least 1 restaurant that has rating >= 4.5
At least 2 restaurants that share at least one cuisine (e.g., both offer "East Indian")

db.restaurants.insertMany([
    {
        restaurantId: 1,
        name: "Banana Leaf Apolo",
        city: "Bangalore",
        area: "Whitefield",
        cuisines: [
            "East Indian",
            "North Indian",
            "Western"
        ],
        rating: 4.5,
        isOpen: true
    },
    {
        restaurantId: 2,
        name: "Chandra's Chai",
        city: "Bangalore",
        area: "Koramangala",
        cuisines: [
            "East Indian",
            "Western"
        ],
        rating: 4.8,
        isOpen: true
    },
    {
        restaurantId: 3,
        name: "Jodhi's Restaurant",
        city: "Hyderabad",
        area: "Gachibowli",
        cuisines: [
            "South Indian",
            "Japanese"
        ],
        rating: 4.2,
        isOpen: true
    },
    {
        restaurantId: 4,
        name: "Famous Muthu-bak",
        city: "Mumbai",
        area: "Bandra",
        cuisines: [
            "East Indian"
        ],
        rating: 3.5,
        isOpen: true
    },
    {
        restaurantId: 5,
        name: "Chiru's Restaurant",
        city: "Delhi",
        area: "Rohini",
        cuisines: [
            "South Indian",
            "North Indian"
        ],
        rating: 4.0,
        isOpen: true
    },
    {
        restaurantId: 6,
        name: "Komala's Restaurant",
        city: "Delhi",
        area: "Shakurpur",
        cuisines: [
            "South Indian",
            "North Indian"
        ],
        rating: 4.6,
        isOpen: true
    }
]);

-------------------------------------------------------------------------------------------------------------
4) Insert order documents
Insert at least 10 order documents into orders.

Each order document must include the following fields (use these exact field names):

orderId (Number)
restaurantId (Number) (must match an existing restaurant)
customerName (String)
items (Array of Objects)
totalAmount (Number)
status (String)
orderedAt (Date)
items must look like this:
items: [
  { name: "Item Name", qty: 2, price: 180 },
  { name: "Another Item", qty: 1, price: 120 }
]

Dataset requirements:
At least 3 different statuses across orders. Eg: PLACED, PREPARING, DELIVERED, CANCELLED
At least 2 orders from the same customerName
At least 2 orders for the same restaurantId
At least 2 orders on the same calendar date
At least one order with totalAmount > 800
Tip: Ensure totalAmount matches the items you insert (qty × price summed up). Your data should be internally consistent.

db.orders.insertMany([
    {
        orderId: 101,
        restaurantId: 1,
        customerName: "Alex Tan",
        items: [
            { name: "Fish Head Curry", qty: 1, price: 33.50 },
            { name: "White Rice with Vegetables", qty: 1, price: 6.50 }
        ],
        totalAmount: 40,
        status: "PLACED",
        orderedAt: new Date("2025-01-15T10:30:00")
    },
    {
        orderId: 102,
        restaurantId: 2,
        customerName: "Jamie Lim",
        items: [
          { name: "Chicken Biryani", qty: 3, price: 5 },
          { name: "Mushroom Soup", qty: 2, price: 5 }
        ],
        totalAmount: 25,
        status: "PREPARING",
        orderedAt: new Date("2025-01-15T11:00:00")
      },
      {
        orderId: 103,
        restaurantId: 1,
        customerName: "Alex Tan",
        items: [
          { name: "Butter Chicken", qty: 2, price: 10 }
        ],
        totalAmount: 20,
        status: "DELIVERED",
        orderedAt: new Date("2025-01-15T13:15:00")
      },
      {
        orderId: 104,
        restaurantId: 3,
        customerName: "Sarah Lee",
        items: [
          { name: "Shoyu Ramen", qty: 2, price: 20 },
          { name: "Miso Pasta - Spaghetti", qty: 1, price: 15 }
        ],
        totalAmount: 55,
        status: "DELIVERED",
        orderedAt: new Date("2025-01-16T09:45:00")
      },
      {
        orderId: 105,
        restaurantId: 4,
        customerName: "Daniel Wong",
        items: [
          { name: "Chicken Dum Briyani", qty: 4, price: 120 }
        ],
        totalAmount: 480,
        status: "PLACED",
        orderedAt: new Date("2025-01-16T10:20:00")
      },
      {
        orderId: 106,
        restaurantId: 2,
        customerName: "Jamie Lim",
        items: [
          { name: "Deluxe Cheese Burger", qty: 2, price: 180 },
          { name: "Truffle Fries", qty: 2, price: 90 }
        ],
        totalAmount: 540,
        status: "DELIVERED",
        orderedAt: new Date("2025-01-16T12:00:00")
      },
      {
        orderId: 107,
        restaurantId: 5,
        customerName: "Chris Ng",
        items: [
          { name: "Cheeseburger", qty: 3, price: 160 },
          { name: "Fries", qty: 2, price: 80 }
        ],
        totalAmount: 640,
        status: "PREPARING",
        orderedAt: new Date("2025-01-17T14:10:00")
      },
      {
        orderId: 108,
        restaurantId: 6,
        customerName: "Emily Koh",
        items: [
          { name: "Vegan Bowl", qty: 2, price: 200 },
          { name: "Smoothie", qty: 2, price: 120 }
        ],
        totalAmount: 640,
        status: "PLACED",
        orderedAt: new Date("2025-01-17T15:00:00")
      },
      {
        orderId: 109,
        restaurantId: 3,
        customerName: "Michael Tan",
        items: [
          { name: "Lasagna", qty: 3, price: 260 },
          { name: "Caesar Salad", qty: 1, price: 120 }
        ],
        totalAmount: 900,
        status: "DELIVERED",
        orderedAt: new Date("2025-01-17T18:30:00")
      },
      {
        orderId: 110,
        restaurantId: 1,
        customerName: "Sarah Lee",
        items: [
          { name: "Paneer Tikka", qty: 2, price: 190 },
          { name: "Masala Dosa", qty: 2, price: 150 }
        ],
        totalAmount: 680,
        status: "PLACED",
        orderedAt: new Date("2025-01-18T11:40:00")
      }
]);

-------------------------------------------------------------------------------------------------------------
Part C — Read Queries (Filters + Projection)
Write queries for each of the following.

5. Find all restaurants in Bangalore that are currently open (isOpen: true). Return only: name, area, cuisines,
rating (hide _id).
db.restaurants.find(
    { city: "Bangalore", isOpen: true },
    { _id: 0, name: 1, area: 1, cuisines: 1, rating: 1 }
);

6. Find restaurants that serve "East Indian" and have rating >= 4.0. Return only: name, city, rating.
db.restaurants.find(
    { cuisines: "East Indian", rating: { $gte: 4.0 } },
    { _id: 0, name: 1, city: 1, rating: 1 }
);

7. Find all orders with status: "DELIVERED" and totalAmount > 500. Return only: orderId, restaurantId, totalAmount,
orderedAt.
db.orders.find(
    { status: "DELIVERED", totalAmount: { $gt: 500 } },
    { _id: 0, orderId: 1, restaurantId: 1, totalAmount: 1, orderedAt: 1 }
);

8. Find all orders for a single restaurant (pick one restaurantId from your data). Sort by orderedAt from newest to
oldest and return only: orderId, customerName, status, totalAmount, orderedAt.
db.orders.find(
    { restaurantId: 1 },
    { _id: 0, orderId: 1, customerName: 1, status: 1, totalAmount: 1, orderedAt: 1 }
).sort({ orderedAt: -1 });

-------------------------------------------------------------------------------------------------------------
Part D — Update and Delete
9. One restaurant temporarily stopped accepting orders. Update one restaurant (by restaurantId) and set: isOpen: false
db.restaurants.updateOne(
    { restaurantId: 2 },
    { $set: { isOpen: false } }
);

10. A customer called support and the order must be cancelled. Update one order (by orderId) and set: status:
"CANCELLED"

db.orders.updateOne(
    { orderId: 105 },
    { $set: status: "CANCELLED"}
);

11. A test order was inserted accidentally. Delete one order using orderId.

db.orders.deleteOne(
    { orderId: 110 }
);

-------------------------------------------------------------------------------------------------------------
Part E — Aggregation Framework
Write aggregation pipelines for the following.

12. Orders count by status. Return an output where each document shows:
    - status
    - totalOrders

db.orders.aggregate([
  {
    $group: {
      _id: "$status",
      totalOrders: { $sum: 1 }
    }
  },
  {
    $project: {
      _id: 0,
      status: "$_id",
      totalOrders: 1
    }
  }
]);


13. Total revenue per restaurant (DELIVERED only) For orders where status: "DELIVERED", compute total revenue grouped by
 restaurantId:
    - restaurantId
    - revenue
    Sort revenue highest to lowest.

db.orders.aggregate([
  {
    $match: { status: "DELIVERED" }
  },
  {
    $group: {
      _id: "$restaurantId",
      revenue: { $sum: "$totalAmount" }
    }
  },
  {
    $project: {
      _id: 0,
      restaurantId: "$_id",
      revenue: 1
    }
  },
  {
    $sort: { revenue: -1 }
  }
]);


14. Top 3 restaurants by delivered revenue (with restaurant name) Join orders with restaurants so the final output
includes:
    - restaurantId
    - restaurantName
    - deliveredRevenue
    Sort by revenue desc and return only the top 3.

This requires $lookup + $unwind + grouping + projection.

db.orders.aggregate([
  {
    $match: { status: "DELIVERED" }
  },
  {
    $group: {
      _id: "$restaurantId",
      deliveredRevenue: { $sum: "$totalAmount" }
    }
  },
  {
    $lookup: {
      from: "restaurants",
      localField: "_id",
      foreignField: "restaurantId",
      as: "restaurant"
    }
  },
  {
    $unwind: "$restaurant"
  },
  {
    $project: {
      _id: 0,
      restaurantId: "$_id",
      restaurantName: "$restaurant.name",
      deliveredRevenue: 1
    }
  },
  {
    $sort: { deliveredRevenue: -1 }
  },
  {
    $limit: 3
  }
]);


15. Most frequently ordered item name Across all orders, find the single most frequently ordered item by total quantity.
 Your output should show:
    - itemName
    - totalQty
    This requires unwinding items and grouping.

db.orders.aggregate([
  {
    $unwind: "$items"
  },
  {
    $group: {
      _id: "$items.name",
      totalQty: { $sum: "$items.qty" }
    }
  },
  {
    $sort: { totalQty: -1 }
  },
  {
    $limit: 1
  },
  {
    $project: {
      _id: 0,
      itemName: "$_id",
      totalQty: 1
    }
  }
]);


-------------------------------------------------------------------------------------------------------------
Part F — Indexing Basics
16. Create indexes to support the system’s most common operations:
    - Fast filtering by status
    - Fast sorting/recent lookups by orderedAt
    - Fast lookups by restaurantId

    Create at least two indexes on the orders collection that support the above.

Index 1: Filter by status + sort by orderedAt
db.orders.createIndex(
  { status: 1, orderedAt: -1 }
);

Index 2: Fast lookups by restaurantId
db.orders.createIndex(
  { restaurantId: 1 }
);

Index 3: If your app often fetches recent orders for a restaurant
db.orders.createIndex(
  { restaurantId: 1, orderedAt: -1 }
);

17. Use explain() on one of your Part C queries to show that MongoDB can use an index.
    - You don’t need to deeply interpret the output—just run it and confirm it’s working.

db.orders
  .find(
    { status: "DELIVERED", totalAmount: { $gt: 500 } },
    { _id: 0, orderId: 1, restaurantId: 1, totalAmount: 1, orderedAt: 1 }
  )
  .explain("executionStats");

