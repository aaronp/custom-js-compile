def ws(base: sbt.io.syntax.File, include: sbt.io.FileFilter): sbt.internal.io.Source =
  WatchSource(base, include, excludeFilter=NothingFilter)

watchSources += ws(baseDirectory.value / "js",    "*.js")

Compile / sourceDirectory := baseDirectory( _ / "js" ).value

lazy val customCompile = taskKey[Seq[File]]("custom compile task")

customCompile := {
  import sys.process._

  // this is just manually kept in-step with our project structure
  val script = baseDirectory( _ / "build.sh").value
  val outputDir = baseDirectory( _ / "js-output").value
  val compileOutput = script.getPath.!!
  println(compileOutput)

  //note: this isn't recursive - it just assumes a flat directory
  sbt.IO.listFiles(outputDir)
}

(Compile / compile) := ((Compile / compile) dependsOn customCompile).value