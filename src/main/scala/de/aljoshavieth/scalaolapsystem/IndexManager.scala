package de.aljoshavieth.scalaolapsystem

object IndexManager {
	def createYearDateIndex(dataStore: DataStore): Map[String, List[Int]] = {
		dataStore.dates.zipWithIndex
			.groupBy { case (date, _) => date.d_year }
			.view
			.mapValues(_.map { case (_, index) => index })
	}.toMap

	def createOrderdateLineorderIndex(dataStore: DataStore): Map[String, List[Int]] = {
		dataStore.lineorders.zipWithIndex
			.groupBy { case (lineorder, _) => lineorder.lo_orderdate }
			.view
			.mapValues(_.map { case (_, index) => index })
	}.toMap
}
