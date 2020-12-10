(ns halp.core
  (:require [clojure.core.async :as a]
            [discljord.connections :as c]
            [discljord.messaging :as m])
  (:gen-class))

(def token (System/getenv "DISCORD_AUTH_TOKEN"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
