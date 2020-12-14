(defproject halp "0.1.0-SNAPSHOT"
  :description "A Discord halper written in Clojure"
  :url "https://github.com/seylerius/halp"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.suskalo/discljord "1.2.0"]
                 [ch.qos.logback/logback-classic "1.2.3"]
                 [org.clojure/math.numeric-tower "0.0.4"]]
  :jvm-opts ["-Dclojure.tools.logging.factory=clojure.tools.logging.impl/slf4j-factory"]
  :main ^:skip-aot halp.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :plugins [[lein-cljfmt "0.7.0"]]
  :repl-options {:init-ns halp.core})
