(ns watch.core
  (:require [babashka.pods :as pods]))

(pods/load-pod "pod-babashka-filewatcher")
(require '[pod.babashka.filewatcher :as fw])

(defn -main [& args]
  (->
    (Runtime/getRuntime)
    (.addShutdownHook (Thread. #(println "bye bye!"))))

  (let [dir (some-> args first)]
    (println "Watching" dir)
    (fw/watch dir
              (fn [event] (prn event))
              {:delay-ms 50}))

  @(promise))
