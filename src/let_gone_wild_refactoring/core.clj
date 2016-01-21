(ns let-gone-wild-refactoring.core)

(defn big? [{{:keys [height width]} :dimensions}]
  (and (> height 10) (> width 10)))

(defn express? [{:keys [days-to-ship]}]
  (> 2 days-to-ship))

(defn big-and-express [postage]
  (assoc postage :type :big-and-express))

(defn express [postage]
  (assoc postage :type :express))

(defn big [postage]
  (assoc postage :type :big))

(defn classify-postage [postage]
  (cond
    (and (express? postage) (big? postage))
    (big-and-express postage)

    (express? postage)
    (express postage)

    (big? postage)
    (big postage)))

(def factors-by-postage-type
  {:big-and-express 5
   :express         3
   :big             2})

(defn factor [postage]
  (if-let [factor (factors-by-postage-type (:type (classify-postage postage)))]
    factor
    (cond
      (and (express? postage) (big? postage)) (throw (Exception. "should't get here!"))
      (express? postage) (throw (Exception. "should't get here!"))
      (big? postage) (throw (Exception. "should't get here!"))
      :else 1)))

(defn postage-cost [postage]
  (* (factor postage) (:weight postage)))
