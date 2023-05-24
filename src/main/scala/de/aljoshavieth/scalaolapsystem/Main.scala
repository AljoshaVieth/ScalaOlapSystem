package de.aljoshavieth.scalaolapsystem

object Main {
  def main(args: Array[String]): Unit = {
    val dataStore: DataStore = Parser.getDataStore
    val client: OlapClient = new OlapClient(dataStore)
    println("\n----------------------------------------")
    println("Running Q1.1 ...")
    println("Executed in: " + calculateExecutionTime(client.q_1_1()) + "ms")
    println("\n----------------------------------------")
    println("Running Q1.2 ...")
    println("Executed in: " + calculateExecutionTime(client.q_1_2()) + "ms")
    println("\n----------------------------------------")
    /*
    val yearDateIndex = IndexManager.createYearDateIndex(dataStore)
    val orderdateLineorderIndex = IndexManager.createOrderdateLineorderIndex(dataStore)

    client.q_1_1_with_index(yearDateIndex, orderdateLineorderIndex)


     */
  }


  /**
   * This function can be used to execute any other function while measuring the execution time
   *
   * @param f The function to be executed
   * @return The execution time of f in nanoseconds
   */
  private def calculateExecutionTime(f: => Unit): Long = {
    val startTime = System.currentTimeMillis()
    f
    System.currentTimeMillis() - startTime
  }
}