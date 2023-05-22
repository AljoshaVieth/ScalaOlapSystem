package de.aljoshavieth.scalaolapsystem

import de.aljoshavieth.scalaolapsystem.datastructure._


class DataStore(
				   val customers: Array[Customer],
				   val dates: Array[Date],
				   val Lineorders: Array[Lineorder],
				   val parts: Array[Part],
				   val suppliers: Array[Supplier]) {
}

