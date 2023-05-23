package de.aljoshavieth.scalaolapsystem.datastructure

case class Customer(c_custkey: String,
					c_name: String,
					c_address: String,
					c_city: String,
					c_nation: String,
					c_region: String,
					c_phone: String,
					c_mktsegment: String
				   ) extends DataStructure