(ns let-gone-wild-refactoring.postage-classification)

(defn- big? [{{:keys [height width]} :dimensions}]
  (and (> height 10) (> width 10)))

(defn- express? [{:keys [days-to-ship]}]
  (> 2 days-to-ship))

(defn- big-and-express [postage]
  (assoc postage :type [:big :express]))

(defn- express [postage]
  (assoc postage :type :express))

(defn- big [postage]
  (assoc postage :type :big))

(defn- regular [postage]
  (assoc postage :type :regular))

(defn classify-postage [postage]
  (cond
    (and (express? postage)
         (big? postage))
    (big-and-express postage)

    (express? postage)
    (express postage)

    (big? postage)
    (big postage)

    :else
    (regular postage)))
