(ns let-gone-wild-refactoring.core)

(defn postage-cost [{:keys [dimensions weight days-to-ship]}]
  (let [{height :height width :width} dimensions
        big? (and (> height 10) (> width 10))
        express? (> 2 days-to-ship)
        multiple (cond
                   (and express? big?) 5
                   express? 3
                   big? 2
                   :else 1)]
    (* multiple weight)))
