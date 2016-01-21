(ns let-gone-wild-refactoring.postage-factors-appliedd-to-weight
  (:require
    [let-gone-wild-refactoring.postage-classification :as postage-classification]))

(def ^:private factors-by-postage-type
  {[:big :express] 5
   :express 3
   :big 2
   :regular 1})

(defn compute [postage]
  (-> postage
      postage-classification/classify-postage
      :type
      factors-by-postage-type))
