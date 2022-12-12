def ws(base: sbt.io.syntax.File, include: sbt.io.FileFilter): sbt.internal.io.Source =
  WatchSource(base, include, excludeFilter=NothingFilter)

watchSources += ws(baseDirectory.value / "js",    "*.js")

Compile / sourceDirectory := baseDirectory( _ / "js" ).value

lazy val customCompile = taskKey[Seq[File]]("custom compile task")

customCompile := {
  import sys.process._
  val script = baseDirectory( _ / "build.sh").value
  val outputDir = baseDirectory( _ / "js-output").value
  println(s"compiling using $script")
  val out = script.getPath.!!
  println("output:")
  println(out)
  val files = sbt.IO.listFiles(outputDir)
  files
}

Compile / sourceGenerators += customCompile


(Compile / compile) := ((Compile / compile) dependsOn customCompile).value