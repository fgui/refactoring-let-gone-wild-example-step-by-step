(ns let-gone-wild-refactoring.core
  (:require
    [let-gone-wild-refactoring.factors-appliedd-to-weight :as weight-factor]))

(defn postage-cost [postage]
  (* (weight-factor/compute postage) (:weight postage)))
