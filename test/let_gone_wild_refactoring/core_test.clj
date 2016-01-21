(ns let-gone-wild-refactoring.core-test
  (:require [midje.sweet :refer :all]
            [let-gone-wild-refactoring.core :refer :all]))

(facts
  "Postage costs"

  (fact
    "Regular postage"
    (postage-cost [2 1] 1 2) => 1
    (postage-cost [2 1] 3 2) => 3)

  (fact
    "Big postage"
    (postage-cost [20 15] 1 2) => 2
    (postage-cost [20 15] 3 2) => 6)

  (fact
    "Express postage"
    (postage-cost [2 1] 1 1) => 3
    (postage-cost [2 1] 3 1) => 9)

  (fact
    "Big and express postage"
    (postage-cost [20 15] 1 1) => 5
    (postage-cost [20 15] 3 1) => 15))
