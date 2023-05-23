package de.aljoshavieth.scalaolapsystem.datastructure

case class Part(p_partkey: String,
				p_name: String,
				p_mfgr: String,
				p_category: String,
				p_brand1: String,
				p_color: String,
				p_type: String,
				p_size: String,
				p_container: String
			   ) extends DataStructure
