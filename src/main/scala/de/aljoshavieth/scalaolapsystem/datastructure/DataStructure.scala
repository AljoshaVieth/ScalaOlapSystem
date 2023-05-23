package de.aljoshavieth.scalaolapsystem.datastructure
import DataStructureType._
trait DataStructure {}

object DataStructure {
	def apply(dataStructureType: DataStructureType, args: List[String]): DataStructure = {
		// In theory, scala provides the _ :* syntax to unpack the arguments, however at this point it is not clear how long the arguments are, so it is not possible here
		dataStructureType match {
			case CUSTOMER=> Customer(args.head, args(1), args(2), args(3), args(4), args(5), args(6), args(7))
			case DATE=> Date(args.head, args(1), args(2), args(3), args(4), args(5), args(6), args(7), args(8), args(9), args(10), args(11), args(12), args(13), args(14), args(15), args(16))
			case LINEORDER=> Lineorder(args.head, args(1), args(2), args(3), args(4), args(5), args(6), args(7), args(8), args(9), args(10), args(11), args(12), args(13), args(14), args(15), args(16))
			case PART=> Part(args.head, args(1), args(2), args(3), args(4), args(5), args(6), args(7), args(8))
			case SUPPLIER=> Supplier(args.head, args(1), args(2), args(3), args(4), args(5), args(6))
		}
	}
}
