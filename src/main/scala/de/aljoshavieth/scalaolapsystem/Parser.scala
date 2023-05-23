package de.aljoshavieth.scalaolapsystem


import de.aljoshavieth.scalaolapsystem.datastructure.DataStructureType.{CUSTOMER, DATE, DataStructureType, LINEORDER, PART, SUPPLIER}
import de.aljoshavieth.scalaolapsystem.datastructure._

import scala.io.Source
import scala.util.{Failure, Success, Try}

object Parser {
	def getDataStore: DataStore = {
		println("Starting to parse data...")
		val startTime = System.currentTimeMillis()
		val dataStore: DataStore = new DataStore(
			parseFile("customer.tbl", CUSTOMER).map(_.asInstanceOf[Customer]),
			parseFile("date.tbl", DATE).map(_.asInstanceOf[Date]),
			parseFile("lineorder.tbl", LINEORDER).map(_.asInstanceOf[Lineorder]),
			parseFile("part.tbl", PART).map(_.asInstanceOf[Part]),
			parseFile("supplier.tbl", SUPPLIER).map(_.asInstanceOf[Supplier]))

		println("All data parsed and stored in " + (System.currentTimeMillis() - startTime) + " ms")
		dataStore
	}

	private def parseFile(fileName: String, dataStructureType: DataStructureType): List[DataStructure] = {
		println("  Starting to parse " + fileName + " ...")
		val startTime = System.currentTimeMillis()
		Try(Source.fromFile(fileName)) match {
			case Success(file) =>
				val list: List[datastructure.DataStructure] =
					file.getLines().map(
						line => DataStructure(
							dataStructureType, line.split("\\|").toList)
					).toList
				file.close()
				println("    Data parsed in " + (System.currentTimeMillis() - startTime) + " ms")
				list
			case Failure(exception) =>
				println("Could not read file `" + fileName + "`. It should be placed into the same folder as the .jar")
				println(exception.getMessage)
				throw exception
		}
	}
}