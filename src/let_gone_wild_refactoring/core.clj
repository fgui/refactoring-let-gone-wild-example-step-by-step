(ns let-gone-wild-refactoring.core)

(defn big? [{{:keys [height width]} :dimensions}]
  (and (> height 10) (> width 10)))

(defn express? [{:keys [days-to-ship]}]
  (> 2 days-to-ship))

(defn big-and-express [postage]
  (assoc postage :type :big-and-express))

(defn classify-postage [postage]
  (when (and (express? postage) (big? postage))
    (big-and-express postage)))

(def factors-by-postage-type
  {:big-and-express 5})

(defn factor [postage]
  (if-let [factor (factors-by-postage-type (:type (classify-postage postage)))]
    factor
    (cond
      (and (express? postage) (big? postage)) (throw (Exception. "should't get here!"))
      (express? postage) 3
      (big? postage) 2
      :else 1)))

(defn postage-cost [postage]
  (* (factor postage) (:weight postage)))
