(defproject divisadero/example "0.0.1-SNAPSHOT"
  :description "FIXME: write"
  :source-path "src/clojure"
  :test-path "test/clojure"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [ring/ring-jetty-adapter "0.3.5"]
                 [divisadero "0.0.1-SNAPSHOT"]]
  :dev-dependencies [[swank-clojure/swank-clojure "1.2.1"]
                     [marginalia "0.3.2"]
                     [lein-ring "0.2.4"]
                     [ring-serve "0.1.0"]])
