(ns let-gone-wild-refactoring.core
  (:require
    [let-gone-wild-refactoring.postage-classification :as postage-classification]))

(def factors-by-postage-type
  {[:big :express] 5
   :express 3
   :big 2
   :regular 1})

(defn factor [postage]
  (-> postage
      postage-classification/classify-postage
      :type
      factors-by-postage-type))

(defn postage-cost [postage]
  (* (factor postage) (:weight postage)))
