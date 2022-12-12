# Custom compile tasks

This is a (perhaps hacky) example of achieving a custom-compilation task for a watched directory using SBT.

The 'server' directory is empty --- just presumed to be some normal scala server code.

The 'client' subproject has:
 * its own source directory (e.g. './client/js' )
 * its own build step (e.g. just executing './client/build.sh', which in our case is just a dumb copy)
 * its own output directory (e.g. './client/js-output')

The result is that we can add/edit/remove files in './client/js' and see them (nearly) immediately reflected in './client/-js-output' when running:

```
sbt "project client" ~compile
```