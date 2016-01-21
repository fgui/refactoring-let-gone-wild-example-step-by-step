(ns let-gone-wild-refactoring.core
  (:require
    [let-gone-wild-refactoring.postage.cost :as postage-cost]))

(defn postage-cost [postage]
  (postage-cost/compute postage))
