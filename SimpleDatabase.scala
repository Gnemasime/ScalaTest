// Define the SimpleDatabase class
class SimpleDatabase[T] {
  // Using a mutable Map to store key-value pairs
  private var data: Map[String, T] = Map()

  // Method to store a key-value pair
  def put(key: String, value: T): Unit = {
    data += (key -> value) // Adds or updates the value for the given key
  }

  // Method to retrieve the value associated with a key
  def get(key: String): String = {
    // Check if the key exists, return the value or a message if not found
    data.get(key) match {
      case Some(value) => value.toString
      case None => s"Key '$key' not found."
    }
  }

  // Method to delete a key-value pair by key
  def delete(key: String): Unit = {
    if (data.contains(key)) {
      data -= key // Remove the key-value pair
      println(s"Key '$key' has been deleted.")
    } else {
      println(s"Key '$key' not found, cannot delete.")
    }
  }

  // Method to display all key-value pairs in the database
  def display(): Unit = {
    if (data.isEmpty) {
      println("No data to display.")
    } else {
      data.foreach { case (key, value) =>
        println(s"$key -> $value")
      }
    }
  }
}

// Example usage
object SimpleDatabaseTest extends App {
  // Create an instance of SimpleDatabase to store String type values
  val db = new SimpleDatabase[String]()

  // Add key-value pairs
  db.put("name", "John Doe")
  db.put("age", "30")

  // Retrieve and print value for the key "name"
  println(db.get("name"))  // Output: John Doe

  // Delete the key "age"
  db.delete("age")

  // Display all key-value pairs
  db.display()  // Output: name -> John Doe
}
