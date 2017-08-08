(ns baobab.views
  (:require [re-frame.core :as re-frame]
            [cljsjs.material-components]))

(defn main-panel []
  (fn []
    [:div
     [:div "Hello from " @(re-frame/subscribe [:dfs-address])]
     [:button.mdc-button "Button"]]))
