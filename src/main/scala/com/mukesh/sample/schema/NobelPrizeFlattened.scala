package com.mukesh.sample.schema

case class KnownName(en: Option[String])
case class Links(href: String)
case class Element(
                    id: Option[String],
                    knownName: KnownName,
                    links: Links,
                    portion: String,
                    sortOrder: String
                  )
case class Laureate(
                     element: Element
                   )
case class NobelPrizeFlattened(
                                awardYear: Option[String],
                                category: Category,
                                laureates: Seq[Element],
                                dateAwarded: Option[String]
                              )
case class Category(en: Option[String], no: Option[String], se: Option[String])
