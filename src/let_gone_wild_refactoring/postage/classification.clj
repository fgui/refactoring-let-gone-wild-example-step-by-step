(ns let-gone-wild-refactoring.postage.classification)

(defn- big? [{{:keys [height width]} :dimensions}]
  (and (> height 10) (> width 10)))

(defn- express? [{:keys [days-to-ship]}]
  (> 2 days-to-ship))

(defn with-type [postage type]
  (assoc postage :type type))

(defn classify [postage]
  (cond
    (and (express? postage)
         (big? postage))
    (with-type postage [:big :express])

    (express? postage)
    (with-type postage :express)

    (big? postage)
    (with-type postage :big)

    :else
    (with-type postage :regular)))
