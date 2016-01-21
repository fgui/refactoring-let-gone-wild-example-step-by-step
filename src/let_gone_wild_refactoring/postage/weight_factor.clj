(ns let-gone-wild-refactoring.postage.weight-factor
  (:require
    [let-gone-wild-refactoring.postage.classification :as classification]))

(def ^:private factors-by-postage-type
  {[:big :express] 8
   :express 3
   :big 2
   :regular 1})

(defn compute [postage]
  (-> postage
      classification/classify
      factors-by-postage-type))
