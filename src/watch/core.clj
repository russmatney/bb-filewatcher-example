(require '[babashka.pods :as pods])
(pods/load-pod "pod-babashka-filewatcher")
(require '[pod.babashka.filewatcher :as fw])

(->
  (Runtime/getRuntime)
  (.addShutdownHook (Thread. #(println "bye bye!"))))

(let [dir
      ;; "src"
      (first *command-line-args*)
      ]
  (println "Watching" dir)
  (fw/watch dir
            (fn [event] (prn event))
            {:delay-ms 50}))
