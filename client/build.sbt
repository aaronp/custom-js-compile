watchSources := (watchSources.value.filterNot {x =>
  println(s" >>> $x")
  x.getPath.contains("target")
})