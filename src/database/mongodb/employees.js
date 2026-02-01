// 20260109_Mongosh

//Enforcing Consistency
use company_db;

//validation rule for employees collection
{
    name - required
    age - required
    department - required
}

// required: array of the fields (strings) in the employees collection
db.createCollection("employees", {
   validator: {
      $jsonSchema: {
        bsonType: "object",
        required: ["name", "age", "department"],
        properties: {
            name: { bsonType: "string" },
            age: { bsonType: "int" },
            department: { bsonType: "string" },
        }
      }
    }
});

// insertOne
db.employees.insertOne({ name})


