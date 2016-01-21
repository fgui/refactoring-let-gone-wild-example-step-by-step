(ns let-gone-wild-refactoring.postage.classification)

(defn- big? [{{:keys [height width]} :dimensions}]
  (and (> height 10) (> width 10)))

(defn- express? [{:keys [days-to-ship]}]
  (> 2 days-to-ship))

(defn classify [postage]
  (cond
    (and (express? postage)
         (big? postage))
    [:big :express]

    (express? postage)
    :express

    (big? postage)
    :big

    :else
    :regular))
