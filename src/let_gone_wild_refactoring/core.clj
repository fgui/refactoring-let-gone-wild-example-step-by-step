(ns let-gone-wild-refactoring.core)

(defn big? [{{:keys [height width]} :dimensions}]
  (and (> height 10) (> width 10)))

(defn factor [{:keys [days-to-ship] :as postage}]
  (let [express? (> 2 days-to-ship)
        factor (cond
                 (and express? (big? postage)) 5
                 express? 3
                 (big? postage) 2
                 :else 1)]
    factor))

(defn postage-cost [postage]
  (* (factor postage) (:weight postage)))
