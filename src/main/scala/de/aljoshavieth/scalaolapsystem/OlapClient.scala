package de.aljoshavieth.scalaolapsystem

class OlapClient(dataStore: DataStore) {


	/**
	 * Original Q1.1 in SQL:
	 *
	 * select sum(lo_extendedprice*lo_discount) as revenue
	 * from lineorder, date
	 * where lo_orderdate = d_datekey
	 * and d_year = 1993
	 * and lo_discount between 1 and 3
	 * and lo_quantity < 25;
	 */
	def q_1_1() = {
		// Create an index for valid date keys
		val validDateKeys = dataStore.dates.filter(_.d_year.equals("1993")).map(_.d_datekey).toSet

		// Filter lineorders using the index and stored int values
		val filteredLineorders = dataStore.lineorders
			.filter(lineorder => {
				val discount = lineorder.lo_discount.toInt
				val quantity = lineorder.lo_quantity.toInt
				discount >= 1 && discount <= 3 && quantity < 25 && validDateKeys.contains(lineorder.lo_orderdate)
			})

		// Perform the calculation on filtered lineorders
		val totalPrice = filteredLineorders
			.map(filteredLineorder => filteredLineorder.lo_extendedprice.toLong * filteredLineorder.lo_discount.toLong)
			.sum

		println(totalPrice)
	}

	def q_1_2() = {
		// Create an index for valid date keys
		val validDateKeys = dataStore.dates.filter(_.d_yearmonthnum.equals("199401")).map(_.d_datekey).toSet

		// Filter lineorders using the index

		val filteredLineorders = dataStore.lineorders
			.filter(lineorder => {
				val discount = lineorder.lo_discount.toInt
				val quantity = lineorder.lo_quantity.toInt
				discount >= 4 && discount <= 6 && quantity >= 26 && quantity <= 35 && validDateKeys.contains(lineorder.lo_orderdate)
			})

		val totalPrice = filteredLineorders
			.map(filteredLineorder => filteredLineorder.lo_extendedprice.toLong * filteredLineorder.lo_discount.toLong)
			.sum
		println(totalPrice)
	}


	def q_1_1_with_index(yearDateIndex: Map[String, List[Int]], orderdateLineorderIndex: Map[String, List[Int]]) = {
		println("yearDateIndex = " + yearDateIndex.size)
		println("orderdateLineorderIndex = " + orderdateLineorderIndex.size)
		yearDateIndex.get("1993") match {
			case Some(value) =>
				val validDateKeys: List[String] = value.map(i => dataStore.dates(i).d_datekey)
				println(validDateKeys.take(5))
				println(validDateKeys.size)
				val validLineorderIndexes: List[List[Int]] = validDateKeys.flatMap(orderdateLineorderIndex.get)
				println("Found " + validLineorderIndexes.size + " validLineorderIndexes")
				println(validLineorderIndexes.head)
				println(validLineorderIndexes.size)
				val flattened: List[Int] = validLineorderIndexes.flatten
				println("Now getting the lineorders...")
				var counter = 0
				flattened.foreach(i => {
					dataStore.lineorders(i)
					counter = counter + 1
				})
				println("done " + counter)
			//val validLineorders: List[Lineorder] = flattened.map(i => dataStore.lineorders(i))
			//println(validLineorders.size)

			/*
			println("now getting all valid Lineorders")
			val validLineorders: List[Lineorder] = validLineorderIndexes.map(i => dataStore.lineorders(i))
			println("got all valid Lineorders" + validLineorders.size)


			println(validLineorders.take(5))
			 */
			case None =>
				val validDateKeys = List.empty
		}

	}

}
