package de.aljoshavieth.scalaolapsystem

import de.aljoshavieth.scalaolapsystem.datastructure._


class DataStore(
				   val customers: List[Customer],
				   val dates: List[Date],
				   val lineorders: List[Lineorder],
				   val parts: List[Part],
				   val suppliers: List[Supplier]) {
}

