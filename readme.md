# Babashka Filewatcher Example

An example for working with Babashka to write a simple file watcher.

As written, it exits immediately...

But it works great in a repl, where the clojure process is kept alive.

# Usage

## Execute raw

From the root of this project:

```sh
bb -cp $(clojure -Spath) -m watch.core -- src
```

## Build and run an uberjar

Pods don't play nicely with the bb uberscript build process,
but uberjars work just fine.

```sh
bb -cp $(clojure -Spath) -m watch.core --uberjar watch.jar
```

Then you can run via:

```sh
bb watch.jar
```
