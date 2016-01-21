(ns let-gone-wild-refactoring.core)

(defn big? [{{:keys [height width]} :dimensions}]
  (and (> height 10) (> width 10)))

(defn express? [{:keys [days-to-ship]}]
  (> 2 days-to-ship))

(defn factor [postage]
  (cond
    (and (express? postage) (big? postage)) 5
    (express? postage) 3
    (big? postage) 2
    :else 1))

(defn postage-cost [postage]
  (* (factor postage) (:weight postage)))
