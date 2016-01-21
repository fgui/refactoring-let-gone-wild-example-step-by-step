(ns let-gone-wild-refactoring.core
  (:require
    [let-gone-wild-refactoring.postage-factors-appliedd-to-weight :as postage-factor]))

(defn postage-cost [postage]
  (* (postage-factor/compute postage) (:weight postage)))
