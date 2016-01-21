(ns let-gone-wild-refactoring.core-test
  (:require [midje.sweet :refer :all]
            [let-gone-wild-refactoring.core :refer :all]))

(facts
  "Postage costs"

  (fact
    "Regular postage"

    (postage-cost
      {:weight       1
       :days-to-ship 2
       :dimensions   {:height 2
                      :width  1}}) => 1
    (postage-cost
      {:weight       3
       :days-to-ship 2
       :dimensions   {:height 2
                      :width  1}}) => 3)

  (fact
    "Big postage"
    (postage-cost
      {:weight 1
       :days-to-ship 2
       :dimensions {:height 20
                    :width 15}}) => 2
    (postage-cost
      {:weight 3
       :days-to-ship 2
       :dimensions {:height 20
                    :width 15}}) => 6)

  (fact
    "Express postage"
    (postage-cost
      {:weight 1
       :days-to-ship 1
       :dimensions {:height 2
                    :width 1}}) => 3
    (postage-cost
      {:weight 3
       :days-to-ship 1
       :dimensions {:height 2
                    :width 1}}) => 9)

  (fact
    "Big and express postage"
    (postage-cost
      {:weight 1
       :days-to-ship 1
       :dimensions {:height 20
                    :width 15}}) => 8
    (postage-cost
      {:weight 3
       :days-to-ship 1
       :dimensions {:height 20
                    :width 15}}) => 24))
