(ns halp.core
  (:require [clojure.core.async :as as]
            [discljord.connections :as c]
            [discljord.messaging :as m]
            [clojure.spec.alpha :as sspec])
  (:gen-class))

(def token (System/getenv "DISCORD_AUTH_TOKEN"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [event-ch (as/chan 100)
        connection-ch (c/connect-bot! token event-ch
                                      :intents #{:guild-messages
                                                 :guild_message_reactions})
        message-ch (m/start-connection! token)]))
