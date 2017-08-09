(defproject baobab "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha16"]
                 [org.clojure/clojurescript "1.9.854"]
                 [reagent "0.7.0"]
                 [re-frame "0.9.4"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [deraen/lein-sass4clj "0.3.1"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"
                                    "resources/public/css/compiled"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :sass {:source-paths ["sass"]
         :target-path  "resources/public/css/compiled/app.css"}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.4"]]

    :plugins      [[lein-figwheel "0.5.12"]]
    }}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "baobab.core/mount-root"}
     :compiler     {:main                 baobab.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true
                    :preloads             [devtools.preload]
                    :external-config      {:devtools/config {:features-to-install :all}}
                    :npm-deps {
                               ;:blueprintjs/core "1.24.0"
                               :react-datepicker "0.52.0"
                               :recharts "1.0.0-alpha.2"
                               }
                    :install-deps true
                    }}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            baobab.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}


    ]}

  )
